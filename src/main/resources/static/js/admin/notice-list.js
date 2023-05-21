$(document).ready(function(){
    let text = "";
    console.log(notices);
notices.forEach(notice => {
    text+= `
        <tr>
            <td class="inputCheckBoxBtn">
            <input class="inputCheckBox"type="checkbox">
            </td>
                <td>${notice.id}</td>
                <td>${notice.noticeTitle}</td>
                <td>${notice.userIdentification}</td>  
                <td>${notice.noticeCreatedDate}</td>
                <td>${notice.noticeUpdatedDate}</td>
                <td>
                <a th:href="@{notice-update-form}">
                <button type="button" class="update_btn">수정하기</button>
                </a>
                </td>
            </tr>
        `
    });
    $('.noticeTable tbody').html(text);
})
