$(document).ready(function () {
    const $list = $("div.item-list");
    let text = "";

    reviews.forEach(review => {
        text += `
                <div class="item"><a href="/review/local_review_detail?id=${review.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        // review.files.forEach(file => {
        //     if (file.reviewImageType == "REPRESENTATIVE") {
        //         text += `
        //                 <img class="css-j9woce e1e2zisd7 preview" alt="대표 이미지"
        //                 src="/reviewImage/display?reviewImageName=${file.reviewImagePath}/t_${file.reviewImageUuid}_${file.reviewImageName}">`;
        //     }
        // })
        //     if (file.reviewImageType == "REPRESENTATIVE") {
                const date = new Date(review.reviewRegisterDate);
                const year = date.getFullYear();
                const month = String(date.getMonth() + 1).padStart(2, '0');
                const day = String(date.getDate()).padStart(2, '0');
                const uuid = file.reviewImageUuid;
                const filename = file.reviewImageName;
                const filePath = `c:/upload/${year}/${month}/${day}_${uuid}_${filename}`;

                text += `
                        <img class="css-j9woce e1e2zisd7 preview" alt="대표 이미지"
                        src="${filePath}">`;
            // }
        // })

        text += `
                        </div>
                        <div class="css-1647809 e1e2zisd4">
                            <h2 class="css-z2d3s1 e1e2zisd2">${review.reviewTitle}</h2>
                            <address class="project-feed__item__writer-wrap">
                                <a class="project-feed__item__writer" href="#">
                                    <img class="project-feed__item__writer__image" alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=36&amp;h=36&amp;c=c&amp;webp=1">
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













