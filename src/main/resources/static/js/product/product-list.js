let count = 1;
showList();



//지역카테고리
$(".location button").each((i,btn)=>{
    $(btn).on("click",e=>{

        $(".location button").each((idx,all)=>{

            $(all).removeClass("location-active");
        })
        $(btn).addClass("location-active");
        count=1;
        $(".virtualized-list").html("");
        showList();
    })
})

//카테고리
$(".category button").each((i,btn)=>{
    $(btn).on("click",e=>{
        $(".category button").each((idx,all)=>{
            $(all).removeClass("category-active");
        })
        $(btn).addClass("category-active");
        count=1;
        $(".virtualized-list").html("");
        showList();
    })
})

//정렬
$(".order-list button").each((i,btn)=>{
    $(btn).on("click",e=>{
        $(".order-list button").each((idx,all)=>{
            $(all).removeClass("order-active");
        })
        $(btn).addClass("order-active");
        count=1;
        $(".virtualized-list").html("");
        showList();
    })
})












//페이징, 오더, 처리


function showList() {
    let order = $(".order-active").html()
    let category = $(".category-active").html()
    let location = $(".location-active").html()
    $.ajax({
        url:"/product/getList",
        data : {"order" : order, "category" :category ,"location":location,"count":count},
        async :false,
        success : function (products) {
            console.log(products)
            let text = ``;
            products.forEach((product,index) =>{
                text +=` <div class="col-6 col-md-3 product-item-wrap" ${product.productStock==0?'style="opacity:0.5;"':''}>
                        <article class="production-item"><a class="production-item__overlay"
                                                            href="/product/product-detail?productId=${product.id}"></a>
                            <div class="production-item-image production-item__image"><img class="image" alt=""
                                                                                           src="/admin/display?fileName=${product.productImagePath}/${product.productImageUuid}_${product.productImageName}"
                                                                                           >
                                <button class="production-item-scrap-badge production-item-image__scrap-badge scrap-btn" id="${product.id}"
                                        type="button">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         class="inactive-icon">
                                        <defs>
                                            <path id="scrap-icon-5-b"
                                                  d="M12.472 6.93l7.056-3.811A1 1 0 0 1 21 4.002v15.496c0 .83-.672 1.502-1.5 1.502h-15c-.828 0-1.5-.673-1.5-1.502V4.002a1 1 0 0 1 1.472-.883l7.056 3.811a.999.999 0 0 0 .944 0z"></path>
                                            <filter id="scrap-icon-5-a" width="150%" height="150%" x="-25%" y="-25%"
                                                    filterUnits="objectBoundingBox">
                                                <feOffset in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                                                <feGaussianBlur in="shadowOffsetOuter1" result="shadowBlurOuter1"
                                                                stdDeviation="1.5"></feGaussianBlur>
                                                <feComposite in="shadowBlurOuter1" in2="SourceAlpha" operator="out"
                                                             result="shadowBlurOuter1"></feComposite>
                                                <feColorMatrix in="shadowBlurOuter1"
                                                               values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.26 0"></feColorMatrix>
                                            </filter>
                                            <filter id="scrap-icon-5-c" width="150%" height="150%" x="-25%" y="-25%"
                                                    filterUnits="objectBoundingBox">
                                                <feGaussianBlur in="SourceAlpha" result="shadowBlurInner1"
                                                                stdDeviation="1.5"></feGaussianBlur>
                                                <feOffset in="shadowBlurInner1" result="shadowOffsetInner1"></feOffset>
                                                <feComposite in="shadowOffsetInner1" in2="SourceAlpha" k2="-1" k3="1"
                                                             operator="arithmetic"
                                                             result="shadowInnerInner1"></feComposite>
                                                <feColorMatrix in="shadowInnerInner1"
                                                               values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.2 0"></feColorMatrix>
                                            </filter>
                                        </defs>
                                        <g fill="none" fill-rule="nonzero" transform="matrix(1 0 0 -1 0 24)">
                                            <use fill="#000" filter="url(#scrap-icon-5-a)" href="#scrap-icon-5-b"></use>
                                            <use fill="#FFF" fill-opacity=".4" href="#scrap-icon-5-b"></use>
                                            <use fill="#000" filter="url(#scrap-icon-5-c)" href="#scrap-icon-5-b"></use>
                                            <path stroke="#FFF"
                                                  d="M12.71 7.37h-.002a1.5 1.5 0 0 1-1.417 0L4.236 3.56a.499.499 0 0 0-.736.442v15.496c0 .553.448 1.002 1 1.002h15c.552 0 1-.449 1-1.002V4.002a.499.499 0 0 0-.734-.443l-7.057 3.81zm-.475-.88h-.001z"></path>
                                        </g>
                                    </svg>
                                    <svg class="scrap-icon ${product.wished==false ? 'active-icon' : ''}" width="24" height="24" viewBox="0 0 24 24"
                                         preserveAspectRatio="xMidYMid meet">
                                        <path fill="#3b7661 " fill-rule="nonzero"
                                              d="M12.472 17.07a.999.999 0 0 0-.944 0l-7.056 3.811A.999.999 0 0 1 3 19.998V4.502C3 3.672 3.672 3 4.5 3h15c.828 0 1.5.673 1.5 1.502v15.496a1 1 0 0 1-1.472.883l-7.056-3.811z"></path>
                                    </svg>
                                </button>
                                <div class="production-item-image__dark-overlay"></div>
                            </div>
                            <div class="production-item__content"><h1 class="production-item__header"><span
                                    class="production-item__header__brand"><span class="location-img"></span>${product.productUsedLocation}</span><span
                                    class="production-item__header__name">${product.productName}</span>
                            </h1><span class="production-item-price"><span
                                    class="production-item-price__rate">${product.productStock}개 남음</span><span
                                    class="production-item-price__price">${product.productCost}<img src="/image/huge.png"
                                                                               width="23px"> </span></span>

                            </div>
                            <button class="production-item-scrap-badge production-item-image__scrap-badge" disabled
                                    type="button" style=" bottom: 3px;left: 0px;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     class="inactive-icon">
                                    <defs>
                                        <path id="scrap-icon-5-b"
                                              d="M12.472 6.93l7.056-3.811A1 1 0 0 1 21 4.002v15.496c0 .83-.672 1.502-1.5 1.502h-15c-.828 0-1.5-.673-1.5-1.502V4.002a1 1 0 0 1 1.472-.883l7.056 3.811a.999.999 0 0 0 .944 0z"></path>
                                        <filter id="scrap-icon-5-a" width="150%" height="150%" x="-25%" y="-25%"
                                                filterUnits="objectBoundingBox">
                                            <feOffset in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                                            <feGaussianBlur in="shadowOffsetOuter1" result="shadowBlurOuter1"
                                                            stdDeviation="1.5"></feGaussianBlur>
                                            <feComposite in="shadowBlurOuter1" in2="SourceAlpha" operator="out"
                                                         result="shadowBlurOuter1"></feComposite>
                                            <feColorMatrix in="shadowBlurOuter1"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.26 0"></feColorMatrix>
                                        </filter>
                                        <filter id="scrap-icon-5-c" width="150%" height="150%" x="-25%" y="-25%"
                                                filterUnits="objectBoundingBox">
                                            <feGaussianBlur in="SourceAlpha" result="shadowBlurInner1"
                                                            stdDeviation="1.5"></feGaussianBlur>
                                            <feOffset in="shadowBlurInner1" result="shadowOffsetInner1"></feOffset>
                                            <feComposite in="shadowOffsetInner1" in2="SourceAlpha" k2="-1" k3="1"
                                                         operator="arithmetic" result="shadowInnerInner1"></feComposite>
                                            <feColorMatrix in="shadowInnerInner1"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.2 0"></feColorMatrix>
                                        </filter>
                                    </defs>
                                    <g fill="none" fill-rule="nonzero" transform="matrix(1 0 0 -1 0 24)">
                                        <use fill="#000" filter="url(#scrap-icon-5-a)" href="#scrap-icon-5-b"></use>
                                        <use fill="#FFF" fill-opacity=".4" href="#scrap-icon-5-b"></use>
                                        <use fill="#000" filter="url(#scrap-icon-5-c)" href="#scrap-icon-5-b"></use>
                                        <path stroke="#FFF"
                                              d="M12.71 7.37h-.002a1.5 1.5 0 0 1-1.417 0L4.236 3.56a.499.499 0 0 0-.736.442v15.496c0 .553.448 1.002 1 1.002h15c.552 0 1-.449 1-1.002V4.002a.499.499 0 0 0-.734-.443l-7.057 3.81zm-.475-.88h-.001z"></path>
                                    </g>
                                </svg>
                                <svg class="scrap-icon" width="24" height="24" viewBox="0 0 24 24"
                                     preserveAspectRatio="xMidYMid meet">
                                    <path fill="#3b7661 " fill-rule="nonzero"
                                          d="M12.472 17.07a.999.999 0 0 0-.944 0l-7.056 3.811A.999.999 0 0 1 3 19.998V4.502C3 3.672 3.672 3 4.5 3h15c.828 0 1.5.673 1.5 1.502v15.496a1 1 0 0 1-1.472.883l-7.056-3.811z"></path>
                                </svg>
                            </button><span class="scrap-cnt">${product.userWishCount}</span>
                        </article>

                    </div>`

            })

            if(products.length!=0){
                $(".virtualized-list").append(text);
                addBtnClick();
                count = count+products.length;

            }

        }
    })

}

//버튼 추가
function addBtnClick(){
    $(".scrap-btn").filter((i,btn)=>i>count-2).each((i,btn)=>{

        $(btn).on("click",e=>{
                wishing(btn,i);
        })
    })
}

//wish 체크

//위싱 리스트 넣기
function wishing(btn,i){
    $.ajax({
        url: "/product/wishing",
        data: {productId : $(btn).attr("id")},
        async : false,
        success : function (sessionId) {

            if(sessionId){
                if($(btn).find(".scrap-icon").hasClass("active-icon")){
                    console.log("들어옴");
                    $(btn).find(".scrap-icon").removeClass("active-icon");

                    console.log( $(btn).closest(".production-item").find(".scrap-cnt"));

                    $(btn).closest(".production-item").find(".scrap-cnt").html(Number($(btn).closest(".production-item").find(".scrap-cnt").html())+1)
                }else{
                    $(btn).find(".scrap-icon").addClass("active-icon");
                    $(btn).closest(".production-item").find(".scrap-cnt").html(Number($(btn).closest(".production-item").find(".scrap-cnt").html())-1)

                }
            }else{
                alert("로그인 후 이용 바랍니다");
                location.href = `/user/login?location=${location.href}`;
            }

        }

    })
}





//무한스크롤
window.addEventListener("scroll", infiniteScroll);


function infiniteScroll(){
    const currentScroll = window.scrollY;
    const windowHeight = window.innerHeight;
    const bodyHeight = document.querySelector(".css-b3oum7").clientHeight;


    if(currentScroll + windowHeight +200>= bodyHeight){


           showList();

    }
}

