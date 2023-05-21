$("a.change-page").on("click", function(e){
    // 어디로 이동해야할 페이지
    e.preventDefault();
    let page = $(this).attr("href");
    location.href = `/admin/member?page=${page}`;
    // location.href = "/admin/notice?page=" + page;
});