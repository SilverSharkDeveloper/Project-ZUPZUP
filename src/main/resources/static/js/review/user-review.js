$(document).ready(function () {
    const $list = $("div.item-list");
    let text = "";
    reviews.forEach(review => {
        text += `
                <div class="item">
                <a href="/review/user_review_detail?id=${review.id}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">`
        text += `<img src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}" class="css-j9woce e1e2zisd7 preview">`;
        text += `
                        </div>
                        <div class="css-1647809 e1e2zisd4">
                            <h2 class="css-z2d3s1 e1e2zisd2">${review.reviewTitle}</h2>
                            <address class="project-feed__item__writer-wrap">
                                <a class="project-feed__item__writer" href="/mypage/my-host-list?id=${review.userId}">
                                    <img class="project-feed__item__writer__image" alt="" src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}">
                                    <span class="project-feed__item__writer__name"
                                          >${review.userNickname}</span>
                                </a>
                            </address>
<!--                            <div class="css-iadmuc e1e2zisd3">좋아요 16-->
<!--                                <span class="css-4vnul8 e1e2zisd8">조회 6,542</span>-->
<!--                            </div>-->
                            <div class="css-iadmuc e1e2zisd3">
                                <span class="css-4vnul9 e1e2zisd8">${elapsedTime(review.reviewRegisterDate)}</span>
                            </div>
                        </div>
                    </article>
                </a>
                </div>
        `
    });
    $list.append(text);
})
// //무한스크롤
// window.addEventListener("scroll", infiniteScroll);
// function infiniteScroll(){
//     const currentScroll = window.scrollY;
//     const windowHeight = window.innerHeight;
//     const bodyHeight = document.querySelector(".css-b3oum6").clientHeight;
//     if(currentScroll + windowHeight +50>= bodyHeight){
//         showList();
//     }
// }
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


// review.files.forEach(file => {
//     if (file.reviewImageType == "REPRESENTATIVE") {
//         text += `
//                 <img class="css-j9woce e1e2zisd7 preview" alt="대표 이미지"
//                 src="/reviewImage/display?reviewImageName=${file.reviewImagePath}/t_${file.reviewImageUuid}_${file.reviewImageName}">`;
//     }
// })
//     if (file.reviewImageType == "REPRESENTATIVE") {
/*

  text += `
          `;*/
// }
// })









