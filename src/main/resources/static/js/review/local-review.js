$(document).ready(function () {
    const $list = $("div.list-input");

    let text = "";
    reviews.forEach(review => {
        text += `
        <div class="css-xy5hx5 erfbhrp0"
                 style="padding-top: 0px; transform: translateY(0px);">
                <div class="item"><a href="/review/detail?id=${review.reviewId}">
                    <article class="css-1evwse1 e1e2zisd6">
                    <div class="css-1hnq8aw e1e2zisd5">
                        <img class="css-j9woce e1e2zisd7" alt="대표 이미지" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/interior3ds/168057505001286882.png?gif=1&amp;w=480&amp;h=320&amp;c=c&amp;q=80&amp;webp=1">
                        <span class="project-feed__item__image__new" aria-label="NEW">
                            <svg class="icon" width="36" height="20" viewBox="0 0 36 20" preserveAspectRatio="xMidYMid meet">
                                <g fill="none" fill-rule="evenodd">
                                    <rect width="36" height="20" fill="#FDBD39" rx="4"></rect>
                                    <path fill="#FFF" fill-rule="nonzero" d="M6 14V6h1.668l3.446 5.644h.036V6h1.318v8h-1.475L7.354 7.97h-.036V14H6zm8.414 0V6h5.174v1.131h-3.687v2.193h2.865v1.12h-2.865v2.425h3.76V14h-5.247zm8.317 0l-2.067-8h1.511l1.414 5.924h.037L25.318 6h1.21l1.667 5.924h.037L29.658 6H31l-2.03 8h-1.476l-1.62-5.808h-.036L24.194 14H22.73z"></path>
                                </g>
                            </svg>
                        </span>
                    </div>
                    <div class="css-1647809 e1e2zisd4">
                        <h2 class="css-z2d3s1 e1e2zisd2">${review.reviewTitle}</h2>
                        <address class="project-feed__item__writer-wrap">
                            <a class="project-feed__item__writer" href="/users/5921670?affect_type=ProjectSelfIndex&amp;affect_id=1">
                                <img class="project-feed__item__writer__image" alt="" src="https://www.wishbeen.co.kr/geo.922951f5cf1908d9.svg">
                                <span class="project-feed__item__writer__name">${plogging.ploggingStartLocation}</span>
                            </a>
                        </address>
                        <address class="project-feed__item__writer-wrap">
                            <a class="project-feed__item__writer" href="/users/5921670?affect_type=ProjectSelfIndex&amp;affect_id=1">
                                <img class="project-feed__item__writer__image" alt="" src="https://image.ohou.se/i/bucketplace-v2-development/uploads/users/profile_images/168186561821130322.png?gif=1&amp;w=36&amp;h=36&amp;c=c&amp;webp=1">
                                <span class="project-feed__item__writer__name">${user.userNickname}</span>
                            </a>
                        </address>
                        <div class="css-iadmuc e1e2zisd3">좋아요 16
                            <span class="css-4vnul8 e1e2zisd8">조회 6,542</span>
                        </div>
                        <div class="css-iadmuc e1e2zisd3">
                            <span class="css-4vnul9 e1e2zisd8">${review.reviewRegisterDate}</span>
                        </div>
                    </div>
                </article>
                </a>
            </div>
            </div>
        `
    });

    $list.appendChild(text);
});














