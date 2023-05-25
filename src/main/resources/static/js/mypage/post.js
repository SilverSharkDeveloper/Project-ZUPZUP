const $upload = $("input.upload");

let sizes = new Array();
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes.push(files[0].size);

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });

    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            $("label.attach").eq(i).find("h6").hide();
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
        }
    });

    // console.log($(this).files[0]);

    // var reader = new FileReader();
    // reader.readAsDataURL(e.target.files[0]);
    // reader.onload = function(e){
    //     let url = e.target.result;
    //     if(url.includes('image')){
    //         $("label.attach").eq(i).find("h6").hide();
    //         $("div.x").eq(i).show();
    //         $thumbnail.eq(i).show();
    //         $thumbnail.eq(i).attr('src', url);
    //     }else{
    //         showWarnModal("이미지 파일만 등록 가능합니다.");
    //     }
    // }
});

function elapsedTime(date) {
    const start = new Date(date);
    const end = new Date();

    const diff = (end - start) / 1000;

    const times = [
        { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
        { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
        { name: '일', milliSeconds: 60 * 60 * 24 },
        { name: '시간', milliSeconds: 60 * 60 },
        { name: '분', milliSeconds: 60 },
    ];

    for (const value of times) {
        const betweenTime = Math.floor(diff / value.milliSeconds);

        if (betweenTime > 0) {
            return `${betweenTime}${value.name} 전`;
        }
    }
    return '방금 전';
}