$(document).ready(function () {
    // const $reviewList = $(".css-gkfaqp div.review-list");
    const $reviewList = $("div.review-list");
    const $productList = $("div.product-list");
    const $ploggingList = $("div.plogging-list");
    let reviewText = "";
    let productText = "";
    let ploggingText = "";

/*    products.forEach((product) => {
        productText += `
                <div class="item"><a href="/review/local_review_detail?id=${product.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        // product.files.forEach(file => {
        //     if (file.fileType == "REPRESENTATIVE") {
        //         productText += `
        //                 <img class="css-j9woce e1e2zisd7" alt="대표 이미지"
        //                 src="/reviewImage/display?reviewImageName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
        //     }
        // })
        productText += `

                        <div class="css-fyyvpx e1fm144d2">
                <div class="e1fm144d7 css-wpil38 e193wc2k3">
                    <!--before위치-->
                    <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=360&amp;h=180&amp;c=c" srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=480&amp;h=360&amp;c=c 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=640&amp;h=360&amp;c=c 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=850&amp;h=640&amp;c=c 3x" class="e193wc2k2 css-gnpvt2 css-a0qkmc">
                </div>
                <div class="css-1t28ktu e193wc2k0">
                    <span type="fill" variant="primary2" class="css-ueburv">NEW</span>
                </div>
                <div class="css-ou7uck e1fm144d3">
                    <p class="css-vbg47w e1rx0k8j1">
                        <span class="css-1opz4n5 e1rx0k8j0 ">${product.productName}</span>
                    </p>
                    <address class="project-feed__item__writer-wrap">
                        <a class="project-feed__item__writer" href="/users/5921670?affect_type=ProjectSelfIndex&amp;affect_id=1">
                            <img class="project-feed__item__writer__image" alt="" src="https://www.wishbeen.co.kr/geo.922951f5cf1908d9.svg">
                            <span class="project-feed__item__writer__name">${product.productUsedLocation}</span>
                        </a>
                    </address>
                    <div class="css-iadmuc ele2zisd3">${product.productCost}
                        <span class="css-4vnul8 ele2zisd8">
                            <!--before-->
                            재고 : ${product.productStock}</span>
                    </div>
                </div>
                <a class="css-11ab5xd e1fm144d0" href="/projects/139475/detail?affect_type=Home&amp;affect_id=0"></a>
            </div>
        `
    });
    $productList.append(productText);

    ploggings.forEach(( plogging) => {
        ploggingText += `
                <div class="item"><a href="/review/local_review_detail?id=${plogging.id}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        // plogging.files.forEach(file => {
        //     if (file.fileType == "REPRESENTATIVE") {
        //         ploggingText += `
        //                 <img class="css-j9woce e1e2zisd7" alt="대표 이미지"
        //                 src="/reviewImage/display?reviewImageName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
        //     }
        // })
        ploggingText += `
                 <div class="css-fyyvpx e1fm144d2">
                <div class="e1fm144d7 css-wpil38 e193wc2k3">
                    <!--before위치-->
                    <img src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=360&amp;h=180&amp;c=c" srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=480&amp;h=360&amp;c=c 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=640&amp;h=360&amp;c=c 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/projects/168138560511525706.jpg?w=850&amp;h=640&amp;c=c 3x" class="e193wc2k2 css-gnpvt2 css-a0qkmc">
                </div>
                <div class="css-ou7uck e1fm144d3">
                    <p class="css-vbg47w e1rx0k8j1">
                        <span class="css-1opz4n5 e1rx0k8j0">${plogging.ploggingTitle} </span>
                    </p>
                    <address class="project-feed__item__writer-wrap">
                        <a class="project-feed__item__writer" href="/users/5921670?affect_type=ProjectSelfIndex&amp;affect_id=1">
                            <img class="project-feed__item__writer__image" alt="" src="https://www.wishbeen.co.kr/geo.922951f5cf1908d9.svg">
                            <span class="project-feed__item__writer__name">${plogging.ploggingStartLocation}</span>
                        </a>
                    </address>
                    <address class="project-feed__item__writer-wrap">
                        <a href="/interior3ds/642b8b6f176b1d16aebc302a"></a>
                        <a class="project-feed__item__writer" href="/users/5921670?affect_type=ProjectSelfIndex&amp;affect_id=1">
                            <img class="project-feed__item__writer__image" alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=36&amp;h=36&amp;c=c&amp;webp=1" srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=72&amp;h=72&amp;c=c&amp;webp=1 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=72&amp;h=72&amp;c=c&amp;webp=1 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=144&amp;h=144&amp;c=c&amp;webp=1 3x">
                            <span class="project-feed__item__writer__name">${plogging.userNickname}</span>
                        </a>
                    </address>
                    <div class="css-iadmuc e1e2zisd3">보상휴지롤 ${plogging.ploggingReward}
                        <span class="css-4vnul8 e1e2zisd8">참가인원  1/${plogging.ploggingMaximumParticipant}</span>
                    </div>
                    <div class="css-iadmuc ele2zisd3">
                        <span class="css-4vnul9 e1e2zisd8">시작 날짜 ${plogging.ploggingStartDateTime}</span>
                    </div>
                </div>
                <a class="css-11ab5xd e1fm144d0" href="/projects/139475/detail?affect_type=Home&amp;affect_id=0"></a>
            </div>

        </div>
        `
    });
    $ploggingList.append(ploggingText);*/

    reviews.forEach((review) => {
        reviewText += `
                <div class="item"><a href="/review/local_review_detail?id=${review.id}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                `
        reviewText += `
                        <img class="css-j9woce e1e2zisd7" alt="" src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}">`;
        reviewText += `
                            <img class="css-j9woce e1e2zisd7" alt="" src="">
                            <span class="project-feed__item__image__new" aria-label="NEW"><svg class="icon" width="36" height="20" viewBox="0 0 36 20" preserveAspectRatio="xMidYMid meet"><g fill="none" fill-rule="evenodd"><rect width="36" height="20" fill="#FDBD39" rx="4"></rect><path fill="#FFF" fill-rule="nonzero" d="M6 14V6h1.668l3.446 5.644h.036V6h1.318v8h-1.475L7.354 7.97h-.036V14H6zm8.414 0V6h5.174v1.131h-3.687v2.193h2.865v1.12h-2.865v2.425h3.76V14h-5.247zm8.317 0l-2.067-8h1.511l1.414 5.924h.037L25.318 6h1.21l1.667 5.924h.037L29.658 6H31l-2.03 8h-1.476l-1.62-5.808h-.036L24.194 14H22.73z"></path></g></svg></span>
                        </div>
                        <div class="css-1647809 e1e2zisd4">
                            <h2 class="css-z2d3s1 e1e2zisd2">${review.reviewTitle}</h2>
                            <address class="project-feed__item__writer-wrap">
                                <a class="project-feed__item__writer" href="/mypage/main">
                                    <img class="project-feed__item__writer__image" alt="" src="/reviewImages/display?reviewImageName=${review.reviewImagePath}/t_${review.reviewImageImageUuid}_${review.reviewImageImageName}">
                                    <span class="project-feed__item__writer__name">${review.userNickname}</span>
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













