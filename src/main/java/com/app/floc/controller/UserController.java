package com.app.floc.controller;

import com.app.floc.config.RecaptchaConfiguration;
import com.app.floc.domain.VO.UserVO;
import com.app.floc.service.user.EmailService;
import com.app.floc.service.user.KaKaoService;
import com.app.floc.service.user.NaverLoginBO;
import com.app.floc.service.user.UserService;
import com.github.scribejava.core.model.OAuth2AccessToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    private final UserService userService;
    private final EmailService registerMail;
    private String secretKey = "6LdwOykmAAAAAFpcV2g4J0aqP6sYpaJacLARxWyA";
    private final KaKaoService kakaoService;
    private final NaverLoginBO naverLoginBO;
    private String apiResult = null;


    //회원가입 폼으로
    @GetMapping("join")
    public void goToJoinForm(UserVO userVO){

    }

    //회원가입
    @PostMapping("join")
    public RedirectView join(UserVO userVO,HttpSession session){
        userService.join(userVO);
        return new RedirectView("/user/login");
    }

    //로그인창
    @GetMapping("login")
    public void goToLogin(String location,HttpSession session){
        if(location!=null){

            session.setAttribute("location",location);
        }else {
            session.setAttribute("location","/main/main");
        }

    }




    //로그인 진행
    @PostMapping("login")
    public RedirectView login(String identification, String password, HttpSession session, RedirectAttributes redirectAttributes){
        Optional<Long> foundUser = userService.login(identification, password);

        if(foundUser.isPresent()){
            if(userService.getUser(foundUser.get()).get().getUserRole().equals("admin")){
                log.info("들");
                return new RedirectView("/admin/admin");
            }
        }


        if(foundUser.isPresent()){
            session.setAttribute("userId",foundUser.get());
            log.info(session.getAttribute("userId").toString());
            return new RedirectView(session.getAttribute("location")==null?"/main/main" :session.getAttribute("location").toString() );
        }else{
            redirectAttributes.addFlashAttribute("login","fail");
            redirectAttributes.addFlashAttribute("identification",identification);
            return new RedirectView("/user/login?location=" + session.getAttribute("location"));
        }

    }

    //네이버 로그인 진행
    @GetMapping("Oauth-naver")
    public RedirectView oauthNaver(HttpSession session){
       return new RedirectView(naverLoginBO.getAuthorizationUrl(session));

    }
    //카카오 로그인 진행
    @GetMapping("Oauth-kakao")
    public RedirectView oauthKakao(){
        return new RedirectView("https://kauth.kakao.com/oauth/authorize?client_id=0a0d62970720c0f5877d5c69122ba110&redirect_uri=http://localhost:10000/user/login-kakao&response_type=code");
    }

    //네이버 로그인 성공시 callback호출 메소드
    @GetMapping("login-naver")
    public RedirectView naverCallback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session,RedirectAttributes redirectAttributes) throws IOException, ParseException {

        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);  //String형식의 json데이터
        //2. String형식인 apiResult를 json형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;
        //3. 데이터 파싱
        JSONObject naverUser = (JSONObject)jsonObj.get("response");
        //response의 nickname값 파싱
        log.info(naverUser.toString());
        if(naverUser.isEmpty()){
            redirectAttributes.addFlashAttribute("login","fail-kakao-non-email");
            return new RedirectView("/user/login");
        }

        UserVO userVO = new UserVO();
        userVO.setUserStatus("NAVER");
        userVO.setUserMarketing("AGREE");
        userVO.setUserAlarm("AGREE");
        userVO.setUserIdentification(naverUser.get("email").toString());
        userVO.setUserNickname(naverUser.get("nickname").toString());
        userVO.setUserPassword(naverUser.get("id").toString());
        userVO.setUserName(naverUser.get("name").toString());
        userVO.setUserTissue(0L);




        //네이버 로그인 성공시 받아온 아이디로 디비조회
        Optional<UserVO> foundUser = userService.checkId(userVO.getUserIdentification());

        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 노말인경우)
        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 카카오오인경우)
        //디비조회한 아이디가 있고 status가 카카오인경우 -> 로그인진행 밑 받아온 데이터로 업데이트)
        if(foundUser.isPresent()){
            if(foundUser.get().getUserStatus().equals("NORMAL")){

                redirectAttributes.addFlashAttribute("login","already-exist-NORMAL");
                return new RedirectView("/user/login?location=" + session.getAttribute("location"));
            }else if(foundUser.get().getUserStatus().equals("KAKAO")){
                redirectAttributes.addFlashAttribute("login","already-exist-KAKAO");
                return new RedirectView("/user/login?location=" + session.getAttribute("location"));
            }else{   //네이버 계정일경우 -> update
               userVO.setId(foundUser.get().getId());
                userService.modifyUser(userVO);
                session.setAttribute("userId",foundUser.get().getId());
                return new RedirectView(session.getAttribute("location").toString());

            }
        }
        //중복된 아이디가 없이 로그인 시도 -> db에 인서트
        userService.join(userVO);

        //인서트 이후 바로 세션아이디, 토큰 받고 메인페이지로
        Optional<Long> foundId = userService.login(userVO.getUserIdentification(), userVO.getUserPassword());
        session.setAttribute("userId",foundId.get());
        return new RedirectView(session.getAttribute("location").toString());
    }




    //비밀번호 재설정
    @GetMapping("new-password")
    public void goToSetNewPasswordForm(){ ;}

    @PostMapping("new-password")
    public RedirectView setNewPassword(String identification, String password, HttpSession session){
        Optional<UserVO> foundUser = userService.checkId(identification);
        foundUser.ifPresent(userVO-> {
            userVO.setUserPassword(password);
            userService.modifyUser(userVO);
        });

        return new RedirectView("/user/login?location=" + session.getAttribute("location"));
    }


    //카카오 오어스

    @GetMapping("/login-kakao")
    @Transactional()
    public RedirectView  kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        String token = kakaoService.getKaKaoAccessToken(code);
        Optional<UserVO> kakaoUser = Optional.ofNullable(kakaoService.getKakaoInfo(token));

        //카카오 로그인에서 빈객체 전송 -> 무언가 문제가 발생 ->실패로 로그인창
        if(kakaoUser.isEmpty()){
            redirectAttributes.addFlashAttribute("login","fail-kakao-non-email");
            return new RedirectView("/user/login?location=" + session.getAttribute("location"));
        }

        //카카오 로그인 성공시 받아온 아이디로 디비조회
        Optional<UserVO> foundUser = userService.checkId(kakaoUser.get().getUserIdentification());

        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 노말인경우)
        //디비조회한 아이디가 있다면 마이페이지에서 연동하도록 로그인창 띄워주기 (status 가 naver인경우)
        //디비조회한 아이디가 있고 status가 카카오인경우 -> 로그인진행 밑 받아온 데이터로 업데이트)
        if(foundUser.isPresent()){
            if(foundUser.get().getUserStatus().equals("NORMAL")){

                redirectAttributes.addFlashAttribute("login","already-exist-NORMAL");
                return new RedirectView("/user/login?location=" + session.getAttribute("location"));
            }else if(foundUser.get().getUserStatus().equals("NAVER")){
                redirectAttributes.addFlashAttribute("login","already-exist-NAVER");
                return new RedirectView("/user/login?location=" + session.getAttribute("location"));
            }else{   //네이버, 노말아닌 카카오 계정일경우 -> update
                kakaoUser.get().setId(foundUser.get().getId());
                kakaoUser.get().setUserTissue(foundUser.get().getUserTissue());
                userService.modifyUser(kakaoUser.get());
                session.setAttribute("token", token);
                session.setAttribute("userId",foundUser.get().getId());
                return new RedirectView(session.getAttribute("location").toString());

            }
        }
        //중복된 아이디가 없이 로그인 시도 -> db에 인서트
        userService.join(kakaoUser.get());

        //인서트 이후 바로 세션아이디, 토큰 받고 메인페이지로
        Optional<Long> foundId = userService.login(kakaoUser.get().getUserIdentification(), kakaoUser.get().getUserPassword());
        session.setAttribute("userId",foundId.get());
        session.setAttribute("token", token);
        return new RedirectView(session.getAttribute("location").toString());
    }





    @GetMapping("/logout")
    public RedirectView logoutAll(HttpSession session){
        //카카오 로그인 로그아웃
        if(session.getAttribute("token")!=null){
            kakaoService.logoutKakao((String)session.getAttribute("token"));
        }
        session.invalidate();
        return new RedirectView("/user/login");
    }















    //이메일 중복검사
    @GetMapping("check-email/{email}")
    @ResponseBody
    public UserVO checkEmail(@PathVariable String email){

        Optional<UserVO> foundUser = userService.checkId(email);
        if(foundUser.isPresent()){
           return foundUser.get();
        }else{
            return null;
        }

    }

    //닉네임 중복검사
    @GetMapping("check-nickname/{nickname}")
    @ResponseBody
    public boolean checkNickname(@PathVariable String nickname){return userService.checkNickname(nickname).isPresent();}

    //메일보내기
    @PostMapping("login/mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam("email") String email,@RequestParam("type") String type) throws Exception {
        String code = registerMail.sendSimpleMessage(email,type);
        return code;
    }

    //리캡챠 확인
    @GetMapping("recaptcha/login")
    @ResponseBody
    public boolean login(String gRecaptchaResponse) {



        //  [S]리캡차 검증
        try {
            RecaptchaConfiguration.setSecretKey(secretKey);
            Boolean verify = RecaptchaConfiguration.verify(gRecaptchaResponse);

            // 검증 실패 시
            if(!verify){
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        //  [E]리캡차 검증

        //검증 통과하면 로그인 진행 코드 작성
        return true;
    }

}
