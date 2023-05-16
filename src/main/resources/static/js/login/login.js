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