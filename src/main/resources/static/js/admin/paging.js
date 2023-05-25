$("a.change-page").on("click", function(e){
    // 어디로 이동해야할 페이지
    e.preventDefault();
    let page = $(this).attr("href");
    let type= $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    console.log(page);
    location.href = `/admin/notice?page=${page}&type=${type}&keyword=${keyword}`;
    // location.href = "/admin/notice?page=" + page;
});
// $("a.change-page").on("click", function(e){
//     e.preventDefault();
//     let page = $(this).attr("href");
//     let type = $("select[name=type]").val();
//     let keyword = $("input[name=keyword]").val();
//     location.href = `/post/list?page=${page}&type=${type}&keyword=${keyword}&order=${order}`;
// });