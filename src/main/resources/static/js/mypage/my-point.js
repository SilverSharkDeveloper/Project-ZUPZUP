$(document).ready(function(){
    const $div = $(".css-18ewygj");
    const $p = $(".css-of8h0b");

    var totalTissue = 0;
    let text = "";
    tissues.forEach(tissue => {
        totalTissue += parseInt(`${tissue.tissuePoint}`);
        if((parseInt(`${tissue.tissuePoint}`))>=0)
        {
        text += `
            <div class="css-oc7sge e1rx7pum8">
    <div class="css-1kwo4sf e1rx7pum7">
        <div class="css-3eylin e1rx7pum6">${tissue.id}</div>
        <div class="css-15jzb03 e1rx7pum5">
            <div class="css-s5xdrg e1rx7pum4">
                <div class="accumulate css-y3863i e1rx7pum3">적립</div>
                <h2 class="css-1kzfo6n e1rx7pum2">${tissue.tissueHistory} <span style="font-size: 14px;color: rgb(188, 189, 190);">·${elapsedTime(tissue.tissueCreatedDate)}</span></h2></div>
            <ul class="css-82ta8s e1rx7pum1">
                <li>${tissue.tissueCreatedDate}</li>
            </ul>
        </div>
    </div>
    <div class="css-lgp5e9 e1rx7pum0">+${tissue.tissuePoint}개</div>
</div>
        `}
        else{
            text += `
            <div class="css-oc7sge e1rx7pum8">
    <div class="css-1kwo4sf e1rx7pum7">
        <div class="css-3eylin e1rx7pum6">${tissue.id}</div>
        <div class="css-15jzb03 e1rx7pum5">
            <div class="css-s5xdrg e1rx7pum4">
                <div class="accumulate css-y3863i e1rx7pum3" style="background-color: #c5867836;color: #d34b13;">사용</div>
                <h2 class="css-1kzfo6n e1rx7pum2">${tissue.tissueHistory} <span style="font-size: 14px;color: rgb(188, 189, 190);">·${elapsedTime(tissue.tissueCreatedDate)}</span></h2></div>
            <ul class="css-82ta8s e1rx7pum1">
                <li>${tissue.tissueCreatedDate}</li>
            </ul>
        </div>
    </div>
    <div class="css-lgp5e9 e1rx7pum0" style="color:#d27d59">${tissue.tissuePoint}개</div>
</div>
        `
        }
    });

    let point= totalTissue + `개`;
    $div.html(text);
    $p.html(point);
});










































