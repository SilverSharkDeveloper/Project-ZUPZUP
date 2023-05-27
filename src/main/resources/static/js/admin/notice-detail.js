$(document).ready(function(){
    let text = "";
    console.log(notices);
    notices.forEach(notice => {

        text += `         
                <div class="customer-notice-list__list-item">
                    <a class="customer-notice-feed-item"href="/customer_notices/405">
                        <article class="customer-notice-feed-item__content">
                            <h1 class="customer-notice-feed-item__title">${notice.noticeTitle}</h1>
                                <time class="customer-notice-feed-item__date" >${notice.noticeCreatedDate}</time>
                        </article>
                    </a>
                </div>    
                `
    });
    $('.virtualized-list').html(text);
})