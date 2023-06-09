const form = document.querySelector(".estimate-productForm");
const permitBtn =document.querySelector(".permit");
const rejectBtn =document.querySelector(".reject");

permitBtn.addEventListener("click", e=>{
    let inputTitle = document.querySelectorAll(".input-title")[0];
    let input = document.querySelectorAll(".inputs")[0];
    let opposite = document.querySelectorAll(".input-title")[1];
    let oppositeInput = document.querySelectorAll(".inputs")[1];

    opposite.innerHTML = opposite.innerHTML.replace(" *","");
    opposite.style.color ="red";
    oppositeInput.value ="";

    if(!input.value){
        inputTitle.innerHTML = inputTitle.innerHTML.replace(" *","")+" *";
        inputTitle.style.color ="green";
        input.focus();
    }else{
        form.submit();
    }


})

rejectBtn.addEventListener("click", e=>{
    let inputTitle = document.querySelectorAll(".input-title")[1];
    let input = document.querySelectorAll(".inputs")[1];
    let opposite = document.querySelectorAll(".input-title")[0];
    let oppositeInput = document.querySelectorAll(".inputs")[0];
    opposite.innerHTML = opposite.innerHTML.replace(" *","");
    opposite.style.color ="green";
    oppositeInput.value ="";
    if(!input.value){
        inputTitle.innerHTML = inputTitle.innerHTML.replace(" *","")+" *";
        inputTitle.style.color ="red";
        input.focus();
    }else{
        form.submit();
    }

})
