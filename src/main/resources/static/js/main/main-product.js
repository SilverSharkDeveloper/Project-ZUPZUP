$(document).ready(function () {
    // const $reviewList = $(".css-gkfaqp div.review-list");
    const $productList = $("div.product-list");
    console.log("products");
    let productText = "";

products.forEach((product) => {
        productText += `
                <div class="item"><a href="/product/product_detail?id=${product.id}}">
                    <article class="css-1evwse1 e1e2zisd6">
                        <div class="css-1hnq8aw e1e2zisd5">
                <img class="css-j9woce e1e2zisd7 preview" alt=""
                src="/main/displayProduct?productFullImageName=${product.productImagePath}/t_${product.productImageUuid}_${product.productImageName}">;
                        <div class="css-fyyvpx e1fm144d2">
                <div class="e1fm144d7 css-wpil38 e193wc2k3">
                    <!--before위치-->
                    <img src="">
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













