let password = document.querySelectorAll('input');


password[0].addEventListener('keyup',()=>{
    if(!password[0].value){
        password[0].classList.add('_2Zb2k');
    }
    else {
        password[0].classList.remove('_2Zb2k');
    }
})

password[1].addEventListener('keyup',()=>{
    if(!password[1].value){
        password[1].classList.add('_2Zb2k');
    }
    else {
        password[1].classList.remove('_2Zb2k');
    }
})


$(".password").on("keyup",e=>{
    $(".check-login-valid").css("display","none");
})
