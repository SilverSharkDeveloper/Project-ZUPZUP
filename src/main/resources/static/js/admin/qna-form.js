
let submitBtn = document.querySelector(".btn-write");
let writeTitle = document.querySelectorAll(".write-title");
submitBtn.addEventListener("click", form)

form();


function form(e) {

    let infos = document.querySelectorAll(".write-text");
    let check = true;
    infos.forEach((info,i) => {
        if(!info.value){
            check= false;
            writeTitle[i].innerHTML = writeTitle[i].innerHTML.replace(" *","")+" *";
            writeTitle[i].style.color ="red";
        }else{
            writeTitle[i].innerHTML = writeTitle[i].innerHTML.replace(" *","");
            writeTitle[i].style.color ="black";
        }
    })



    if(check){
        document.querySelector(".submit-form").submit();
    }

}







