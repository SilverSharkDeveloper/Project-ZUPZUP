const searchInput = document.querySelector(".css-1pneado");
const search = document.querySelector(".css-1yhxgcl");

searchInput.addEventListener("focus", evt =>{
    search.style.borderColor = "#7aab9a";
} )

searchInput.addEventListener("blur", evt =>{
    search.style.borderColor = "#DADDE0";
} )


$(".write-btn").on("click",e=>{
    $(".writes").slideToggle();
})

$(".mypage-btn").on("click",e=>{
    $(".mypage").slideToggle();
})

$(".write").on("click",e=>{
    alert("로그인 이후 사용 가능합니다. 로그인 페이지로 이동합니다.");
    location.href ="/user/login";
})


$(".login-header").on("click",e=>{
    location.href = `/user/login?location=${location.href}`
})



$(".join-header").on("click",e=>{
    location.href = `/user/join?location=${location.href}`
})