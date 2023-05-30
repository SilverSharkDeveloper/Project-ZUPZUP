let text =``;

// if(notices.noticeImageUuid !== ""){
    text += `<img src="/admin/display?fileName=${notice.noticeImagePath}/${notice.noticeImageUuid}_${notice.noticeImageName}" width="200px" class="image file-list">`
    // }
    console.log(text);
$("div#noticedetail-img").append(text);





