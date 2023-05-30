$(document).ready(function(){
    let text = ``;
    console.log(ploggings);
    ploggings.forEach(plogging =>{


    text +=
        `
            <tr>
                <td class = "inputCheckBoxBtn">
                <input class="inputCheckBox" value="${plogging.id}" type="checkbox"></td>
                    <td>${plogging.id}</td>
                    <td>${plogging.userNickname}</td>
                    <td>2023-05-15</td>  PLOGGING_START_DATETIME
                    <td>부산 해운대</td> PLOGGING_START_LOCATION
                    <td>완주시 휴지 1롤</td>
                    <td>16/30</td>
                <!-- 신청중,모집중,모집종료,기각),신청중 상태에서만 버튼으로 만들어 신청서 볼수 있게 만들기 -->
                `
            if(plogging.status == "심사대기"){
              text+=   `
                    <td><a th:href="@{floging-estimate}"><button type="button" class = "register-estimate-btn">심사 대기</button></a></td>`
            }
            else{
                text += `<td>모집중</td>`
            }
                text+=` <td><a th:href="@{floging-detail}"><button type="button" class = "register-detail-btn">상세보기</button></a></td>
            </tr>`
    });
    $('.plogTable tbody').html(text);
})


// <td><a th:href="@{floging-estimate}"><button type="button" class = "register-estimate-btn">심사 대기</button></a></td>
// <td><a th:href="@{floging-detail}"><button type="button" class = "register-detail-btn">상세보기</button></a></td>