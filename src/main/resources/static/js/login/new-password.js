


$(".email-btn").on("click",e=>{
    if(!$(".email-input").val()){
        $(".email-border").css("border","1px solid red");
        $(".email-btn-valid").html("필수 입력 항목입니다.")
        $(".email-btn-valid").show();
        return;
    }

    //존재하는 이메일인지 검사

    $.ajax({
        url : `/user/check-email/${$(".email-input").val()}`,
        async : false,
        success:function(result){
            if(!result){
                $(".email-btn-valid").html("존재하지 않는 아이디입니다.")
                $(".email-btn-valid").show();
                $(".email-border").css("border","1px solid red");
            }else{
                if(result.userStatus != "NORMAL"){
                    $(".email-btn-valid").html("카카오 또는 네이버 간편가입된 아이디 입니다.")
                    $(".email-btn-valid").show();
                    $(".email-border").css("border","1px solid red");
                }else{

                    $(".email-code-btn").removeClass("btn-disabled");

                }
            }
        }
    })






})


$(".email-input").on("keyup",e=>{
    $(".email-code-btn").addClass("btn-disabled");

    if(!$(".email-input").val()){
        $(".email-btn").trigger("click")
    }else{
        $(".email-border").css("border","1px solid #dbdbdb");
        $(".email-btn-valid").hide();
    }


})

let timerCnt;
let timeout;
let emailCode;
let email;
//타이머

function timer() {
    timerCnt--;
    document.querySelector(".timer").innerHTML = `0${Math.floor(timerCnt/60)}:${(timerCnt%60)>=10 ?timerCnt%60 : (timerCnt%60)==0? "00" : "0"+timerCnt%60 }`;
    console.log(timerCnt)
    if(timerCnt==0){
        clearInterval(timerInter);
        $(".email-check-form").css("border","1px solid red");
        $(".email-check-valid").html("인증코드가 만료되었습니다. 재전송해주세요.")
        $(".email-check-valid").show();


        timeout = true;

    }
}


$(".email-code-btn").on("click",e=>{
    if($(".email-code-btn").hasClass("btn-disabled")){
        return;
    }



    timeout = false;
    timerCnt =180;
    emailCode="";
    email = $(".email-input").val();
    $.ajax({
        type : "POST",
        url : "login/mailConfirm",
        data : {
            "email" : email,
            "type" : "newPassword"
        },
        success : function(code){
            alert("해당 이메일로 인증번호 발송이 완료되었습니다.")
            emailCode = code;
            timer();
            timerInter = setInterval(timer,1000);

            $(".email-form").hide();
            $(".code-check").show();

        }
    })

})



//이메일 인증 확인 버튼
$(".email-code-check-btn").on("click",e=>{
    if(timeout){
        return;
    }
    $(".email-check-valid").css("color","red");

    if( $(".email-code-input").val() == emailCode){
        clearInterval(timerInter);
        $(".new-password-btn").removeClass("btn-disabled")
        $(".email-check-form").css("border","1px solid #dbdbdb");
        $(".email-check-valid").html("인증 완료했습니다.");
        $(".email-check-valid").css("color","#7aab9a")
        $(".email-check-valid").show();
        timeout = true;

    }else{
        $(".email-check-form").css("border","1px solid red");
        $(".email-check-valid").html("인증코드가 일치하지 않습니다.")
        $(".email-check-valid").show();
        $(".new-password-btn").addClass("btn-disabled");





    }

})

//이메일 재전송
$(".re-send").on("click",e=>{
    $(".email-code-input").val("");
    clearInterval(timerInter);
    timeout = false;
    timerCnt =180;
    emailCode="";
    $.ajax({
        type : "POST",
        url : "login/mailConfirm",
        data : {
            "email" : email,
            "type" : "newPassword"
        },
        success : function(code){
            alert("해당 이메일로 인증번호가 재발송이 완료되었습니다.")
            $(".email-check-form").css("border","1px solid #dbdbdb");
            $(".email-check-valid").hide();
            emailCode = code;
            timer();
            timerInter = setInterval(timer,1000);

        }
    })
})


$(".new-password-btn").on("click",e=>{
    if($(".new-password-btn").hasClass("btn-disabled")){
        return;
    }


    $(".email-check-all").hide();
    $(".new-password").show();
    $(".tel").hide();
    $("header").hide();



})

const passwordNumberRegex =/[0-9]/g;
const passwordEnglishRegex = /[a-z]/ig;
const passwordSpecialCharacterRegex = /[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi;

//비밀번호
let $passwordInput = $("input[name='password']");
//비밀번호 확인
let $confirmPasswordInput = $("input[name='confirmPassword']");


$passwordInput.on("keyup",e=>{
    $(".new-password-valid").hide();
    $(".change-password-btn").addClass("btn-disabled");

    if(!$passwordInput.val()){
        $(".new-password-valid").html("필수 입력 항목입니다.");
        $(".new-password-valid").show();
        return;
    }

    if(!($passwordInput.val().length>=8&&$passwordInput.val().search(passwordNumberRegex)>-1&&$passwordInput.val().search(passwordEnglishRegex)>-1&&$passwordInput.val().search(passwordSpecialCharacterRegex)>-1)){
        $(".new-password-valid").html("영문,숫자,특수문자를 포함한 8자 이상만 가능합니다.");
        $(".new-password-valid").show();
        return;
    }

    if($confirmPasswordInput.val()!=$passwordInput.val()){
        $(".new-password-valid").html("비밀번호가 일치하지 않습니다.");
        $(".new-password-valid").show();
        return;
    }

    $(".new-password-valid").hide();
    $(".change-password-btn").removeClass("btn-disabled");

})

$confirmPasswordInput.on("keyup",e=>{
    $passwordInput.trigger("keyup");
})


$(".change-password-btn").on("click",e=>{
    if($(".change-password-btn").hasClass("btn-disabled")){
        return;
    }
    $("input[name='identification']").val(email);
    $(".submit-form").submit();

})