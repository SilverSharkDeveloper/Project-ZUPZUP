const searchInput = document.querySelector(".css-1pneado");
const search = document.querySelector(".css-1yhxgcl");

searchInput.addEventListener("focus", evt =>{
    search.style.borderColor = "#7aab9a";
} )

searchInput.addEventListener("blur", evt =>{
    search.style.borderColor = "#DADDE0";
} )


$(".write-btn").on("click",e=>{
    $(".writes").toggle();
})

$(".mypage-btn").on("click",e=>{
    $(".mypage").toggle();
})
