let email = document.querySelectorAll('input');


email[0].addEventListener('keyup',()=>{
    if(!email[0].value){
        email[0].classList.add('_2Zb2k');
    }
    else {
        email[0].classList.remove('_2Zb2k');
    }
})

email[1].addEventListener('keyup',()=>{
    if(!email[1].value){
        email[1].classList.add('_2Zb2k');
    }
    else {
        email[1].classList.remove('_2Zb2k');
    }
})


$(".password").on("keyup",e=>{
    $(".check-login-valid").css("display","none");
})



//ajax로 데이터 요청해 받아오는것은 보안상 페이지 이동이 생기면서 인터셉터 해야하는것을 막기때문에 보안성을 취약하게하므로 무조건 로그인은 페이징처리로 진행
/*let $submitForm = $(".submit-form");
let $submitBtn = $(".submit-btn");*/

/*$submitBtn.on("click",e=>{
    let $inputs = $("input");
    $.ajax({
        url : "/user/check-login",
        data : {
            identification : $inputs.eq(0).val(),
            password : $inputs.eq(1).val()
        },
        async : false,
        success : function (result) {
            if(result){
                $submitForm.submit();
            }else{
                $(".check-login-valid").css("display","block");
                $(".password").css("border","1px solid red");
                $inputs.eq(1).val("");
            }
        }
    })
})*/
