$(document).ready(function () {
    const $reviewList = $("div.reivew-list");
    const $productList = $("div.product-list");
    const $ploggingList = $("div.plogging-list");
    let reviewText = "";
    let productText = "";
    let ploggingText = "";

    products.forEach((i, product) => {
        productText += `
                <div class="item"><a th:href="@{review/local_review_detail?id=${product.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        product.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                productText += `
                        <img class="css-j9woce e1e2zisd7" alt="대표 이미지" 
                        src="/reviewImage/display?reviewImageName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
            }
        })
        productText += `
                 
                        </div>
                        <div class="css-1647809 e1e2zisd4">
                            <h2 class="css-z2d3s1 e1e2zisd2">${product.reviewTitle}</h2>
                            <address class="project-feed__item__writer-wrap">
                                <a class="project-feed__item__writer" href="#">
                                    <img class="project-feed__item__writer__image" alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=36&amp;h=36&amp;c=c&amp;webp=1">
                                    <span class="project-feed__item__writer__name"
                                          >${product.userNickname}</span>
                                </a>
                            </address>
<!--                            <div class="css-iadmuc e1e2zisd3">좋아요 16-->
<!--                                <span class="css-4vnul8 e1e2zisd8">조회 6,542</span>-->
<!--                            </div>-->
                            <div class="css-iadmuc e1e2zisd3">
                                <span class="css-4vnul9 e1e2zisd8">${product.reviewRegisterDate}</span>
                            </div>
                        </div>
                    </article>
                </a>
                </div>
        `
    });
    $productList.append(productText);

    ploggings.forEach((i, plogging) => {
        ploggingText += `
                <div class="item"><a th:href="@{review/local_review_detail?id=${plogging.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        plogging.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                ploggingText += `
                        <img class="css-j9woce e1e2zisd7" alt="대표 이미지" 
                        src="/reviewImage/display?reviewImageName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
            }
        })
        ploggingText += `
                 
                        </div>
                        <div class="css-1647809 e1e2zisd4">
                            <h2 class="css-z2d3s1 e1e2zisd2">${plogging.reviewTitle}</h2>
                            <address class="project-feed__item__writer-wrap">
                                <a class="project-feed__item__writer" href="#">
                                    <img class="project-feed__item__writer__image" alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=36&amp;h=36&amp;c=c&amp;webp=1">
                                    <span class="project-feed__item__writer__name"
                                          >${plogging.userNickname}</span>
                                </a>
                            </address>
<!--                            <div class="css-iadmuc e1e2zisd3">좋아요 16-->
<!--                                <span class="css-4vnul8 e1e2zisd8">조회 6,542</span>-->
<!--                            </div>-->
                            <div class="css-iadmuc e1e2zisd3">
                                <span class="css-4vnul9 e1e2zisd8">${plogging.reviewRegisterDate}</span>
                            </div>
                        </div>
                    </article>
                </a>
                </div>
        `
    });
    $ploggingList.append(ploggingText);

    reviews.forEach((i, review) => {
        reviewText += `
                <div class="item"><a th:href="@{review/local_review_detail?id=${review.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        review.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                reviewText += `
                        <img class="css-j9woce e1e2zisd7" alt="대표 이미지" 
                        src="/reviewImage/display?reviewImageName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
            }
        })
        reviewText += `
                 
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
                                <span class="css-4vnul9 e1e2zisd8">${review.reviewRegisterDate}</span>
                            </div>
                        </div>
                    </article>
                </a>
                </div>
        `
    });
    $reviewList.append(reviewText);
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













