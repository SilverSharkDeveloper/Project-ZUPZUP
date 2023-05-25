$(document).ready(function () {
    const urlParams = new URL(location.href).searchParams;
    let lct=urlParams.get('location');

    for(let i=0;i<$lists.length;i++) {
        if($lists.eq(i).text().indexOf(lct)!=-1){
            $lists.eq(i).addClass('liactive');
        }
    }

    const $list = $("div.virtualized-list");
    let text = "";
    ploggings.forEach(plogging => {
        text += `
             <div class="col-12 col-md-4">
                 <article class="project-feed__item">
                 <a class="project-feed__item__link" href="/plogging/plogging-detail?id=${plogging.id}"></a>
                 <div class="project-feed__item__image">
                    <img class="image" alt="" src=""><!--플로깅 메인 사진-->
                 </div>
                 <h1 class="project-feed__item__title">${plogging.ploggingTitle}</h1>
                 <address class="project-feed__item__writer-wrap">
                     <a class="project-feed__item__writer" href="">
                         <img class="project-feed__item__writer__image" alt="" src=""> <!--프로필 사진-->
                         <span class="project-feed__item__writer__name">${plogging.userNickname}</span>
                     </a>
                 </address>
                 <footer class="project-feed__item__status">
                     <span class="entry">플로깅 ${plogging.ploggingViewedCount}&nbsp;</span>
                     <span class="entry">조회 ${plogging.ploggingViewedCount}</span>
                 </footer>
                 </article>
            </div>
        `;

    });
    $list.html(text);
})

