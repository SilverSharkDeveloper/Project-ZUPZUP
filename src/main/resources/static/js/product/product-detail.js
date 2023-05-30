let text=``;

text =`<div class="production-selling-overview container">
                <nav class="commerce-category-breadcrumb-wrap production-selling-overview__category">
                    <ol class="commerce-category-breadcrumb">
                        <li class="commerce-category-breadcrumb__entry"><a class="link"
                                                                        >${productDTO.productUsedLocation.split(" ")[0]}</a>
                            <svg class="icon" width="8" height="8" viewBox="0 0 8 8" fill="currentColor"
                                 preserveAspectRatio="xMidYMid meet">
                                <path d="M4.95 4L2.12 1.19l.7-.71 3.54 3.54-3.53 3.53-.7-.7z"></path>
                            </svg>
                        </li>
                        <li class="commerce-category-breadcrumb__entry"><a class="link"
                                                                            >${productDTO.productCategory}</a>
                        </li>
                    </ol>
                </nav>
                <div class="production-selling-overview__container row">
                    <div class="production-selling-overview__cover-image-wrap col-12 col-md-6 col-lg-7">
                        <div class="production-selling-cover-image-container">
                            <div class="carousel production-selling-cover-image production-selling-overview__cover-image"
                                 role="region" aria-roledescription="carousel">
                                <div class="carousel__list-wrap production-selling-cover-image__carousel-wrap">
                                    <div class="carousel__list" aria-live="polite" style="transform: translateX(0%);">
                                        <div class="carousel__list__entry production-selling-cover-image__entry"
                                             role="group" aria-roledescription="slide" aria-label="1 of 8"
                                             style="width: 100%;"><img
                                                class="production-selling-cover-image__entry__image" tabindex="0"
                                                alt="상품의 대표 이미지"
                                               src="/admin/display?fileName=${productDTO.productImagePath}/${productDTO.productImageUuid}_${productDTO.productImageName}"
                                                >

                                        </div>
                                    </div>
                                </div>
                                <ul class="production-selling-cover-image__list">
                                    <li class="production-selling-cover-image__list__item">
                                        <button class="production-selling-cover-image__list__btn production-selling-cover-image__list__btn--selected"
                                                type="button" aria-label="8개 중 1번째 항목"><img class="image"
                                                                                            alt="상품의 대표 이미지"
                                                                                             src="/admin/display?fileName=${productDTO.productImagePath}/t_${productDTO.productImageUuid}_${productDTO.productImageName}"
                                                                                           >
                                        </button>
                                    </li>

                                </ul>
                                <div class="production-selling-cover-image__paginator">
                                    <ul class="carousel-paginator">
                                        <li><span class="carousel-paginator__page selected" data-key="1"></span></li>
                                        <li><span class="carousel-paginator__page" data-key="2"></span></li>
                                        <li><span class="carousel-paginator__page" data-key="3"></span></li>
                                        <li><span class="carousel-paginator__page" data-key="4"></span></li>
                                        <li><span class="carousel-paginator__page" data-key="5"></span></li>
                                        <li><span class="carousel-paginator__page small" data-key="6"></span></li>
                                        <li><span class="carousel-paginator__page tiny" data-key="7"></span></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="production-selling-overview__content col-12 col-md-6 col-lg-5">
                        <div class="production-selling-header">
                            <h1 class="production-selling-header__title">
                                <div class="production-selling-header__title__name-wrap"><span
                                        class="production-selling-header__title__name" >${productDTO.productName}</span>
                                    <div class="production-selling-header__action">
                                      
                                            <button class="production-selling-header__action__button production-selling-header__action__button-scrap wish-btn ${productDTO.wished?'production-selling-header__action__button--active':''}"
                                                    type="button" id="${productDTO.id}">
                                                <svg class="icon--stroke" aria-label="스크랩" width="24" height="24"
                                                     fill="currentColor" stroke="currentColor" stroke-width="0.5"
                                                     viewBox="0 0 24 24" preserveAspectRatio="xMidYMid meet">
                                                    <path d="M11.53 18.54l-8.06 4.31A1 1 0 0 1 2 21.97V3.5A1.5 1.5 0 0 1 3.5 2h17A1.5 1.5 0 0 1 22 3.5v18.47a1 1 0 0 1-1.47.88l-8.06-4.31a1 1 0 0 0-.94 0z"></path>
                                                </svg>
                                                <span class="count">${productDTO.userWishCount}</span></button>
                                     
                                        

                                        <div class="drop-down">
                                            <button class="production-selling-header__action__button" disabled type="button">
                                                <svg class="icon" aria-label="공유하기" width="24" height="24"
                                                     viewBox="0 0 24 24" fill="currentColor"
                                                     preserveAspectRatio="xMidYMid meet">
                                                    <path d="M9.64 14.646a4.5 4.5 0 1 1 0-5.292l4.54-2.476a4.5 4.5 0 1 1 .63.795l-4.675 2.55c.235.545.365 1.146.365 1.777s-.13 1.232-.365 1.777l4.675 2.55a4.5 4.5 0 1 1-.63.795l-4.54-2.476zM18 8a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM6 15.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM18 23a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"></path>
                                                </svg>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </h1>
                            <div class="production-selling-header__content">

                                <div class="production-selling-header__price"><span
                                        class="production-selling-header__price__price-wrap"><div
                                        class="production-selling-header__price__price-value-wrap"><div
                                        class="production-selling-header__price__price"><span
                                        class="number">${productDTO.productCost}</span><span class="won" style="margin: 4px 0 0 0;"><img src="/image/huge.png" style="width: 40px;vertical-align: middle;    "></span></div></div></span></div>
                                <div class="css-y2nf6n eo634xw3"><span class="css-kell50 eo634xw2">${productDTO.productStock+'개 남음'}<span
                                        class="css-1djn7ak eo634xw1"></span></span>

                                </div>

                            <div class="production-selling-header__info-wrap">
                                <div class="production-selling-header__promotion">
                                    <div class="production-selling-header__promotion__title-wrap"><span>쿠폰</span></div>
                                    <div class="production-selling-header__promotion__content-wrap"><p
                                            class="production-selling-header__promotion__entry">
                                        <b>사용처</b></p>
                                        <p class="production-selling-header__promotion__entry" >
                                            ${productDTO.productUsedLocation}
                                        </p>
                                    </div>
                                </div>
                                <div class="production-selling-header__delivery">
                                    <div class="production-selling-header__delivery__title-wrap"><span>교환</span></div>
                                    <div class="production-selling-header__delivery__content-wrap"><span
                                            class="production-selling-header__delivery__fee"><b>쿠폰 사용 방법</b></span><span
                                            class="production-selling-header__delivery__type"><span>해당 쿠폰의 사용처에 가서 알맞은 상품을 골라 큐알코드를 보여주세요!</span></span><span
                                            class="production-selling-header__delivery__disclaimer-wrap"></span>

                                    </div>
                                </div>
                                <div class="production-selling-header__delivery">
                                    <div class="production-selling-header__delivery__title-wrap"><span>상품</span></div>
                                    <div class="production-selling-header__delivery__content-wrap"><span
                                            class="production-selling-header__delivery__fee"><b>상세정보</b></span><span
                                            class="production-selling-header__delivery__type"><span>${productDTO.productDetail}</span></span><span
                                            class="production-selling-header__delivery__disclaimer-wrap"></span>

                                    </div>
                                </div>
                            </div>
                            </div>
                        <div class="production-selling-option-form production-selling-overview__option-form">

                            <hr class="css-1gc4ylt">

                            <div class="production-selling-option-form__footer">

                                <button class="button button--color-blue button--size-55 button--shape-4 coupon-btn"
                                        type="button">쿠폰 교환
                                </button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>`

$(".production-selling").append(text);



$(".wish-btn").on("click",e=>{
    wishing()
})

function wishing(){
    $.ajax({
        url: "/product/wishing",
        data: {productId : $(".wish-btn").attr("id")},
        async : false,
        success : function (sessionId) {

            if(sessionId){
                if($(".wish-btn").hasClass("production-selling-header__action__button--active")){
                    $(".wish-btn").removeClass("production-selling-header__action__button--active")
                    $(".count").html(Number($(".count").html())-1)
                }else{
                    $(".wish-btn").addClass("production-selling-header__action__button--active")
                    $(".count").html(Number($(".count").html())+1)
                }
            }else{
                alert("로그인 후 이용 바랍니다");
                location.href = `/user/login?location=${location.href}`;
            }

        }

    })
}








//쿠폰 교환
$(".coupon-btn").on("click",e=>{
    $.ajax({
        url : "/product/coupon",
        data : {productId : productDTO.id},
        async : false,
        success : function (condition) {
            console.log(condition);
            if(condition=="noUserId"){
                alert("로그인 후 이용할 수 있습니다.");
                location.href = "/user/login?location=" + location.href;
                return;
            }
            if(condition=="noProductStock"){
                alert("재고가 모두 소진되었습니다.");
                return;
            }
            if(condition=="notEnoughTissue"){
                alert("티슈가 부족합니다. 더 열심히 주우세요!")
                return;
            }

            //모든 조건이 통과되어 쿠폰을 발급할경우
            if(condition=="success"){
                alert("쿠폰이 발급되었습니다. 마이페이지에서 확인해주세요!")
                location.href="/mypage/my-product";
            }


        }
    })
})