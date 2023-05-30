let text= ``;

console.log(products);
console.log(coupons);

coupons.forEach((coupon,i) =>{
    text +=`<div class="col-6 col-lg-4" ${coupon.couponStatus == 'VALID'? '' :'style = "opacity : 0.5;"' }>
                                    <div class="css-prip86 e1lm7yo60"><a class="css-beq49r e1vfbmcc3"
                                                                   ${coupon.couponStatus == 'VALID'? 'href='+coupon.couponQrcodePath :'' }><img
                                            class="css-1b4920d e1vfbmcc2"
                                             src="/admin/display?fileName=${products[i].productImagePath}/${products[i].productImageUuid}_${products[i].productImageName}"
                                            >
                                    </a></div>
                                    <div class="css-1647809 e1e2zisd4"><a><h2 class="css-z2d3s1 e1e2zisd2">${products[i].productName}</h2>
                                    </a><address class="project-feed__item__writer-wrap"><a ></a><a class="project-feed__item__writer" ><img class="project-feed__item__writer__image" alt="" src="https://www.wishbeen.co.kr/geo.922951f5cf1908d9.svg">
                                        <span class="project-feed__item__writer__name">${products[i].productUsedLocation}</span></a></address>


                                        <div class="css-iadmuc e1e2zisd3">
                                            <span class="css-4vnul9 e1e2zisd8">발급일 : ${coupon.couponCreatedDate}</span>
                                            <span class="css-4vnul9 e1e2zisd8" ${coupon.couponStatus == 'VALID'? 'style = "display : none;"' :'' }">사용날짜 : ${coupon.couponUsedDate}</span>
                                            <span class="css-4vnul9 e1e2zisd8 status" ${coupon.couponStatus == 'VALID'? '' :'style = "color : grey;"' }>${coupon.couponStatus == 'VALID'? '사용가능' : '사용완료'}</span>
                                        </div>
                                    </div>
                                </div>`
})

$(".virtualized-list").append(text);



