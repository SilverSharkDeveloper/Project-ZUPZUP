$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type= $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    console.log(page);
    console.log(type);
    console.log(keyword);
    location.href = `/admin/member?page=${page}&type=${type}&keyword=${keyword}`;
});



