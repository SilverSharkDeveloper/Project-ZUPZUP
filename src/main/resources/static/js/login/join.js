
let emailBtn = $("button[name = 'emailAuth']");
const emailFirstRegex =  /[`~!@#$%^&*|\\\'\";:\/?]/;
const emailLastRegex = /[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

let email;
let emailcheck;
let timerInter;
let timerCnt;
let timeout;
let checkedEmail;






let emailCodeCheck;
let checkPassword;
let checkConfirmPassword;
let checkNickname;


//이메일 유효성검사
$(".direct-input").on("keyup",e=>{
    $(".first-email").trigger("keyup");
})

$(".select-email").on("change",e=>{
    $(".first-email").trigger("keyup");


    if($(".select-email").val()== "_manual"){
        $(".select").css("display","none");
        $(".direct").css("display","block");
    }

})


$(".del-direct").on("click",e=>{
    $(".select").css("display","block");
    $(".direct").css("display","none");
   $(".choice").prop("selected",true);
    $(".first-email").trigger("keyup");
    $(".direct-input").val("");
})





$(".first-email").on("keyup",e=>{
    $(".email-code-input").val("");
    emailBtn.removeClass("email-valid-form");
    $(".email-certification-box").slideUp();
    emailCodeCheck= false;
    clearInterval(timerInter);


    email= "";

    if(emailFirstRegex.test($(".first-email").val())){
        $(".email").css("color","red");
        $(".first-email").css("border","1px solid red");
        $(".email-valid").prop("innerText","이메일 형식이 올바르지 않습니다");
        $(".email-valid").css("display","block");
        $(".direct-input").css("border","1px solid red");
        $(".select-email").css("border","1px solid red");
        return;

    }else if(!$(".first-email").val()){
            $(".email").css("color","red");
            $(".first-email").css("border","1px solid red");
            $(".email-valid").prop("innerText","필수 입력 항목입니다.");
            $(".email-valid").css("display","block");
        $(".direct-input").css("border","1px solid red");
        $(".select-email").css("border","1px solid red");

        return;
    }else if(!$(".select-email").val()){
        $(".email").css("color","red");
        $(".first-email").css("border","1px solid red");
        $(".email-valid").prop("innerText","이메일 형식이 올바르지 않습니다.");
        $(".email-valid").css("display","block");
        $(".direct-input").css("border","1px solid red");
        $(".select-email").css("border","1px solid red");
        return;
    }else if($(".select-email").val()=="_manual"){
        if(!(emailLastRegex.test($(".direct-input").val()) && $(".direct-input").val().substring($(".direct-input").val().indexOf(".") + 1).length > 1 )){
            $(".email").css("color","red");
            $(".first-email").css("border","1px solid red");
            $(".email-valid").prop("innerText","이메일 형식이 올바르지 않습니다.");
            $(".email-valid").css("display","block");
            $(".direct-input").css("border","1px solid red");
            $(".select-email").css("border","1px solid red");
            return;
        }else{
            email =  $(".first-email").val() + "@" +   $(".direct-input").val();
            if(checkedEmail==email){
                emailCodeCheck=true;
                return;
            }
            $.ajax({
                url : `/user/check-email/${email}`,
                async : false,
                success:function(result){
                    if(result){
                        emailcheck =true;
                    }
                }
            })

            if(emailcheck){
                $(".email").css("color","red");
                $(".first-email").css("border","1px solid red");
                $(".email-valid").prop("innerText","중복된 이메일이 존재합니다.");
                $(".email-valid").css("display","block");
                $(".direct-input").css("border","1px solid red");
                $(".select-email").css("border","1px solid red");
                emailcheck = false;
                return;
            }

            $(".email").css("color","black");
            $(".first-email").css("border","1px solid #dbdbdb");
            $(".email-valid").css("display","none");
            $(".direct-input").css("border","1px solid #dbdbdb");
            $(".select-email").css("border","1px solid #dbdbdb");
            emailBtn.addClass("email-valid-form");

        }
    }else{
        email =  $(".first-email").val() + "@" +   $(".select-email").val();
        if(checkedEmail==email){
            emailCodeCheck=true;
            return;
        }
        $.ajax({
            url : `/user/check-email/${email}`,
            async : false,
            success:function(result){
                if(result){
                    emailcheck =true;
                }
            }
        })
        if(emailcheck){
            $(".email").css("color","red");
            $(".first-email").css("border","1px solid red");
            $(".email-valid").prop("innerText","중복된 이메일이 존재합니다.");
            $(".email-valid").css("display","block");
            $(".direct-input").css("border","1px solid red");
            $(".select-email").css("border","1px solid red");
            emailcheck = false;
            return;
        }

        $(".email").css("color","black");
        $(".first-email").css("border","1px solid #dbdbdb");
        $(".email-valid").css("display","none");
        $(".direct-input").css("border","1px solid #dbdbdb");
        $(".select-email").css("border","1px solid #dbdbdb");

        emailBtn.addClass("email-valid-form");
    }
})






let emailCode;
//이메일인증 버튼
emailBtn.on("click",e=>{
    if(!$(".first-email").val()){
        $(".email").css("color","red");
        $(".first-email").css("border","1px solid red");
        $(".email-valid").prop("innerText","필수 입력 항목입니다.");
        $(".email-valid").css("display","block");
        $(".direct-input").css("border","1px solid red");
        $(".select-email").css("border","1px solid red");
        return;
    }
    if(!emailBtn.hasClass("email-valid-form")){
        $(".first-email").focus();
        return;
    }
    timeout = false;
    timerCnt =180;
    emailBtn.removeClass("email-valid-form");
    $(".logo-area").show();
    emailCode="";
    $.ajax({
        type : "POST",
        url : "login/mailConfirm",
        data : {
            "email" : email
        },
        success : function(code){
            $(".logo-area").hide();
            alert("해당 이메일로 인증번호 발송이 완료되었습니다.")
            $(".email-certification-box").slideDown();
            emailCode = code;
            timer();
            timerInter = setInterval(timer,1000);

        }
    })
})


//이메일 인증 확인 버튼
$(".email-code-check-btn").on("click",e=>{
    if(timeout){
        return;
    }

    if( $(".email-code-input").val() == emailCode){
        alert("인증에 성공하셨습니다.")
        emailCodeCheck = true;
        $(".email-certification-box").slideUp();
        checkedEmail = email;
        $(".email").css("color","black");
        $(".first-email").css("border","1px solid #dbdbdb");
        $(".email-valid").css("display","none");
        $(".direct-input").css("border","1px solid #dbdbdb");
        $(".select-email").css("border","1px solid #dbdbdb");

    }else{
        alert("인증번호가 일치하지 않습니다.")
    }

})




//타이머
function timer() {
    timerCnt--;
    document.querySelector(".timer").innerHTML = `0${Math.floor(timerCnt/60)}:${(timerCnt%60)>=10 ?timerCnt%60 : (timerCnt%60)==0? "00" : "0"+timerCnt%60 }`;
    console.log(timerCnt)
  if(timerCnt==0){
      clearInterval(timerInter);
      alert("시간초가 다 되었습니다. 재전송 해주세요!")
      timeout = true;

  }
}

$(".re-send").on("click",e=>{
    clearInterval(timerInter);
    timeout = false;
    timerCnt =180;
    $(".logo-area").show();
    emailCode="";
    $.ajax({
        type : "POST",
        url : "login/mailConfirm",
        data : {
            "email" : email
        },
        success : function(code){
            $(".logo-area").hide();
            alert("해당 이메일로 인증번호가 재발송이 완료되었습니다.")
            emailCode = code;
            timer();
            timerInter = setInterval(timer,1000);

            /* chkEmailConfirm(data, $memailconfirm, $memailconfirmTxt);*/
        }
    })
})
const passwordNumberRegex =/[0-9]/g;
const passwordEnglishRegex = /[a-z]/ig;
const passwordSpecialCharacterRegex = /[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi;


//비밀번호
let $passwordInput = $("input[name='password']");
//비밀번호 확인
let $confirmPasswordInput = $("input[name='confirmPassword']");

$passwordInput.on("keyup",e=>{
    console.log($passwordInput.val())
    if(!$passwordInput.val()){
        $(".password-valid").html("필수 입력 항목입니다.");
        $(".password-title").css("color","red");
        $passwordInput.css("border","1px solid red");
        $(".password-valid").css("display","block");
        checkPassword =false;
        $confirmPasswordInput.trigger("keyup");
        $passwordInput.removeClass("highlight");
        return;
    }
    if($passwordInput.val().length>=8&&$passwordInput.val().search(passwordNumberRegex)>-1&&$passwordInput.val().search(passwordEnglishRegex)>-1&&$passwordInput.val().search(passwordSpecialCharacterRegex)>-1){
        checkPassword =true;
        $passwordInput.css("border","1px solid #dbdbdb");
        $(".password-title").css("color","black");
        $(".password-valid").css("display","none");
        $confirmPasswordInput.trigger("keyup");
        $passwordInput.addClass("highlight");

    }else{
        $(".password-valid").val("영문, 숫자,특수기호를 포함한 8자 이상");
        $(".password-title").css("color","red");
        $passwordInput.css("border","1px solid red");
        $(".password-valid").css("display","block");
        checkPassword =false;
        $confirmPasswordInput.trigger("keyup");
        $passwordInput.removeClass("highlight");
    }
})

$confirmPasswordInput.on("keyup",e=>{
    if($passwordInput.val() == $confirmPasswordInput.val()){
        checkConfirmPassword =true;
        $confirmPasswordInput.css("border","1px solid #dbdbdb");
        $(".confirmPassword-title").css("color","black");
        $(".confirm-password-valid").css("display","none");
        $confirmPasswordInput.addClass("highlight")

    }else{
        $(".confirmPassword-title").css("color","red");
        $confirmPasswordInput.css("border","1px solid red");
        $(".confirm-password-valid").css("display","block");
        checkConfirmPassword =false;
        $confirmPasswordInput.removeClass("highlight")
    }
})

//닉네임
const specialCharacterRegex = /[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gim;
let $nicknameInput = $("input[name='nickname']");
let checkNicknameValid

$nicknameInput.on("keyup",e=>{
    checkNickname=false;
    if(!$nicknameInput.val()){
        $(".nickname-valid").html("필수 입력 항목입니다.");
        $(".nickname-title").css("color","red");
        $nicknameInput.css("border","1px solid red");
        $(".nickname-valid").css("display","block");
        checkNickname =false;
        $nicknameInput.removeClass("highlight");
        return;
    }
    if($nicknameInput.val().search(specialCharacterRegex)>=0){
        $(".nickname-valid").html("특수 문자는 사용 할 수 없습니다..");
        $(".nickname-title").css("color","red");
        $nicknameInput.css("border","1px solid red");
        $(".nickname-valid").css("display","block");
        checkNickname =false;
        $nicknameInput.removeClass("highlight");
        return;
    }
    if($nicknameInput.val().length>=2 && $nicknameInput.val().length<=15){
        $.ajax({
            url : `/user/check-nickname/${$nicknameInput.val()}`,
            async : false,
            success : function (result) {
                checkNicknameValid = result;
            }

        })


        if(checkNicknameValid){
            $(".nickname-valid").html("이미 사용중인 닉네임입니다!");
            $(".nickname-title").css("color","red");
            $nicknameInput.css("border","1px solid red");
            $(".nickname-valid").css("display","block");
            checkNickname =false;
            $nicknameInput.removeClass("highlight");
            return;
        }


        checkNickname = true;
        $nicknameInput.css("border","1px solid #dbdbdb");
        $(".nickname-title").css("color","black");
        $(".nickname-valid").css("display","none");
        $nicknameInput.addClass("highlight");
    }else{
        $(".nickname-valid").html("닉네임은 한글,영어,숫자 조합으로<br> 2~15자 사이만 가능합니다.");
        $(".nickname-title").css("color","red");
        $nicknameInput.css("border","1px solid red");
        $(".nickname-valid").css("display","block");
        checkNickname =false;
        $nicknameInput.removeClass("highlight");
    }
})


//약관동의
let $checkBoxes = $(".check-box");

$checkBoxes.each((i,checkbox1)=>{
    if(i==0){
        $(checkbox1).on("click",e=>{


            if($(checkbox1).hasClass("check")){
                $checkBoxes.each((i,checkbox2)=>{
                    $(checkbox2).removeClass("check");
                })
            }else{
                $checkBoxes.each((i,checkbox2)=>{
                    $(checkbox2).addClass("check");
                })
            }


                if($checkBoxes.filter((i,checkbox)=>{
                    if(i>0 && i<4){
                        return $(checkbox).hasClass("check");
                    }else{
                        return false;
                    }
                }).length<3){
                    $(".checkbox-title").css("color","red");
                    $(".checkbox-form").css("border","1px solid red");
                    $(".checkbox-valid").css("display","block");


                }else{
                    $(".checkbox-title").css("color","black");
                    $(".checkbox-form").css("border","1px solid #dbdbdb");
                    $(".checkbox-valid").css("display","none");
                }
        }

        )
    }else{
        $(checkbox1).on("click",e=>{

            if($(checkbox1).hasClass("check")){
                $(checkbox1).removeClass("check");
            }else {
                $(checkbox1).addClass("check");
            }

            if($checkBoxes.filter((i,checkbox)=>{
                if(i==0){
                    return false;
                }else{
                    return $(checkbox).hasClass("check")
                }
            }).length==5
            ){
                $checkBoxes.eq(0).addClass("check");
            }else{
                $checkBoxes.eq(0).removeClass("check");
            }

            if($checkBoxes.filter((i,checkbox)=>{
                if(i>0 && i<4){
                    return $(checkbox).hasClass("check");
                }else{
                    return false;
                }
            }).length<3){
                $(".checkbox-title").css("color","red");
                $(".checkbox-form").css("border","1px solid red");
                $(".checkbox-valid").css("display","block");


            }else{
                $(".checkbox-title").css("color","black");
                $(".checkbox-form").css("border","1px solid #dbdbdb");
                $(".checkbox-valid").css("display","none");
            }
        })
    }
})



//회원가입 버튼

let $joinBtn= $(".join-btn");

$joinBtn.on("click",e=>{
    //1번 이메일 유효성 검사
  if(!$(".first-email").val()){
      $(".first-email").trigger("keyup")
      $(".first-email").focus();
      return;
  }

    if( $(".email-valid").css("display")=="block"){
        $(".first-email").focus();
        return;
    }

    //2번 이메일 인증 검사
    if(!emailCodeCheck){
        $(".first-email").focus();
        $(".email").css("color","red");
        $(".first-email").css("border","1px solid red");
        $(".email-valid").prop("innerText","이메일 인증을 진행해주세요!");
        $(".email-valid").css("display","block");
        $(".direct-input").css("border","1px solid red");
        $(".select-email").css("border","1px solid red");
        return;
    }

    //3번 비밀번호 유효성
    if(!$passwordInput.val()){
        $passwordInput.trigger("keyup");
        $passwordInput.focus();
        return;
    }

    if($(".password-valid").css("display")=="block"){
        $passwordInput.focus();
        return;
    }

    //4번 비밀번호 검사 유효성

    if(!$confirmPasswordInput.val()){
        $confirmPasswordInput.trigger("keyup");
        $confirmPasswordInput.focus();
        return;
    }

    if($(".confirm-password-valid").css("display")=="block"){
        $confirmPasswordInput.focus();
        return;
    }

    //5번 닉네임
    if(!$nicknameInput.val()){
        $nicknameInput.trigger("keyup");
        $nicknameInput.focus();
        return;
    }

    if($(".nickname-valid").css("display")=="block"){
        $nicknameInput.focus();
        return;
    }


    //6번 필수 체크박스 유효성 검사
    if($checkBoxes.filter((i,checkbox)=>{
        if(i>0 && i<4){
            return $(checkbox).hasClass("check");
        }else{
            return false;
        }
    }).length<3){
        $(".checkbox-title").css("color","red");
        $(".checkbox-form").css("border","1px solid red");
        $(".checkbox-valid").css("display","block");

        return;
    }



})

$checkBoxes.each((i,checkbox)=>{

})