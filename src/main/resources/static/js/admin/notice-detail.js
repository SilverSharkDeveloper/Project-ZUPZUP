// $(document).ready(function(){
$(document).ready(function(){
    noticeService.getList(showList);

});
let page =1;
let noticeService = (function() {
    function getList(callback, page) {
        $.ajax({
            url: `/notice/${page}`,
            success: function (notices) {
                if (callback) {
                    callback(notices);
                }
            }
        });
    }
    return {getList: getList};
})();

$(document).ready(function(){
    noticeService.getList(showList, 1);
});

function showList(notices){
    let text = ``;
    notices.forEach(notice => {
        text += `         
                    <div class="customer-notice-list__list-item">
                        <a class="customer-notice-feed-item"href="notice-detail?id=${notice.id}">
                            <article class="customer-notice-feed-item__content">
                                <h1 class="customer-notice-feed-item__title">${notice.noticeTitle}</h1>
                                    <time class="customer-notice-feed-item__date" >${notice.noticeCreatedDate}</time>
                            </article>
                           
                        </a>
                    </div>    
                `
    });
    $('div.virtualized-list').append(text);
}
// $(document).ready(function(){
//     noticeService.getList(showList);

// });

//무한 스크롤

let nextPage = 2; // 다음 페이지 번호를 변수로 지정
$(window).scroll(function(){
    if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
        noticeService.getList(showList, nextPage);
        nextPage++; // 다음 페이지 번호 증가
    }
});