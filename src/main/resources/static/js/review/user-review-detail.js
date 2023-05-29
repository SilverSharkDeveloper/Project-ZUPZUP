$(document).ready(function () {
    const $list = $("div.item-list");
    let text = "";

    reviews.forEach(review => {
        text += `
                
<div class="item"><a href="/review/detail?id=${review.id}">
    <article class="css-1evwse1 e1e2zisd6">
    <div class="css-1hnq8aw e1e2zisd5">
    <img class="css-j9woce e1e2zisd7 preview" alt="" src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}">
    <span class="project-feed__item__image__new" aria-label="NEW"><svg class="icon" width="36" height="20" viewBox="0 0 36 20" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><rect width="36" height="20" fill="#FDBD39" rx="4"></rect><path fill="#FFF" fill-rule="nonzero" d="M6 14V6h1.668l3.446 5.644h.036V6h1.318v8h-1.475L7.354 7.97h-.036V14H6zm8.414 0V6h5.174v1.131h-3.687v2.193h2.865v1.12h-2.865v2.425h3.76V14h-5.247zm8.317 0l-2.067-8h1.511l1.414 5.924h.037L25.318 6h1.21l1.667 5.924h.037L29.658 6H31l-2.03 8h-1.476l-1.62-5.808h-.036L24.194 14H22.73z"></path></g></svg></span>
</div>
<div class="css-1647809 e1e2zisd4">
    <h2 class="css-z2d3s1 e1e2zisd2">${review.reviewTitle}</h2>
    <address class="project-feed__item__writer-wrap">
    <a class="project-feed__item__writer" href="/mypage/main"><img class="project-feed__item__writer__image" alt="" src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}" class="css-j9woce e1e2zisd7 preview"><span class="project-feed__item__writer__name">${review.userNickname}</span></a>
</address>
<!--<div class="css-iadmuc e1e2zisd3">좋아요 16<span class="css-4vnul8 e1e2zisd8">조회 6,542</span>-->
<!--</div>-->
<div class="css-iadmuc e1e2zisd3">
    <span class="css-4vnul9 e1e2zisd8">${review.reviewRegisterDate}</span>
    </div>
    </div>
    </article>
    </a></div>
        `
    });
    $list.append(text);
});
/*if(order == 'popular'){
        let $order = $("button.order");
        $("button.order-checked").removeClass("order-checked");
        $order.eq(1).addClass("order-checked");
    }*/

/*$("button.order").on("click", function (e) {
    e.preventDefault();
    let order = this.classList[1];
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    if (this.classList.length == 2) {
        $("button.order-checked").removeClass("order-checked");
        $(this).addClass("order-checked");
        location.href = `/review/list?page=${nowPage}&type=${type}&keyword=${keyword}&order=${order}`;
    }
});*/













