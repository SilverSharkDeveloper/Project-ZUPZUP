$(document).ready(function(){
    const $div = $(".css-18ewygj");
    const $p = $(".css-of8h0b");

    var totalTissue = 0;
    let text = "";
    tissues.forEach(tissue => {
        totalTissue += parseInt(`${tissue.tissuePoint}`);
        console.log(totalTissue);
        text += `
            <div class="css-oc7sge e1rx7pum8">
    <div class="css-1kwo4sf e1rx7pum7">
        <div class="css-3eylin e1rx7pum6">${tissue.tissueCreatedDate}</div>
        <div class="css-15jzb03 e1rx7pum5">
            <div class="css-s5xdrg e1rx7pum4">
                <div class="accumulate css-y3863i e1rx7pum3">적립</div>
                <h2 class="css-1kzfo6n e1rx7pum2">${tissue.tissueHistory}</h2></div>
            <ul class="css-82ta8s e1rx7pum1">
                <!--<li>첫 사진을 올리셨네요? 짝짝짝! 1000 휴지롤 적립되었습니다</li>
                <li>유효기간: 2023.08.13까지</li>-->
            </ul>
        </div>
    </div>
    <div class="css-lgp5e9 e1rx7pum0">`+`+ ${tissue.tissuePoint}</div>
</div>
        `
    });

    let point= totalTissue;
    $div.html(text);
    $p.html(point);
});










































