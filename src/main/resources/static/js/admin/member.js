
// $(document).ready(function() {
    // let type =$("select[name=type]").val();
    // let keyword=  $("input[name=keyword]").val();
    //
    // console.log(type);
    // console.log(keyword);
    // getUserList(page, type, keyword);
    //
    //
    // // 전체 선택 체크박스 클릭 시 모든 체크박스 선택
    // $('#checkAll').on('click', function() {
    //     $('.inputCheckBox').prop('checked', $(this).prop('checked'));
    // });
    //
    // // 체크박스를 다 체크하면 전체 선택 체크박스도 선택
    // $('.inputCheckBox').on('click', function() {
    //     var totalCheckboxes = $('.inputCheckBox').length;
    //     var checkedCheckboxes = $('.inputCheckBox:checked').length;
    //     $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
    // });
    //
    // // 페이지 버튼 클릭 시 이벤트 처리
    // $("a.change-page").on("click", function(e) {
    //     e.preventDefault();
    //     let page = $(this).attr("href"); // 페이지 번호를 숫자로 변환
    //     console.log(page);
    //     let type = $("select[name=type]").val();
    //     let keyword = $("input[name=keyword]").val();
    //
    // });


// });

// function deleteUser() {
//     var checkboxes = $('.inputCheckBox');
//     var selectItems = [];
//
//     checkboxes.each(function (i, checkbox) {
//         if ($(checkbox).prop('checked')) {
//             selectItems.push($(checkbox).val()); // 선택된 항목의 val값을 배열 추가
//         }
//     });
//
//     $.ajax({
//         url: '/admin/member/delete',
//         type: 'DELETE',
//         data: JSON.stringify(selectItems),
//         contentType: 'application/json',
//         success: function(deletedUserIds) {
//             location.href = "/admin/member";
//         },
//         error: function(error) {
//             console.error(error);
//         }
//     });
// }

// function getUserList() {
//     var text = "";
//     $.ajax({
//         url: `/admin/member/list?page=${page}&type=${type}&keyword=${keyword}`,
//         type: 'GET',
//         success: function(response) {
//             response.forEach(user => {
//                 text += `
//                     <tr>
//                         <td class="inputCheckBoxBtn">
//                             <input class="inputCheckBox" type="checkbox" value="${user.id}">
//                         </td>
//                         <td>${user.id}</td>
//                         <td>${user.userIdentification}</td>
//                         <td>${user.userNickName}</td>
//                         <td>${user.userName}</td>
//                         <td>${user.userRole}</td>
//                         <td>${user.userTissue}</td>
//                         <td>${user.userCreatedDate}</td>
//                         <td></td>
//                     </tr>
//                 `;
//             });
//
//             $('.userTable tbody').html(text);
//             // 전체 선택 체크박스 클릭 시 모든 체크박스 선택
//             $('#checkAll').on('click', function() {
//                 $('.inputCheckBox').prop('checked', $(this).prop('checked'));
//             });
//
//             // 체크박스를 다 체크하면 전체 선택 체크박스도 선택
//             $('.inputCheckBox').on('click', function() {
//                 var totalCheckboxes = $('.inputCheckBox').length;
//                 var checkedCheckboxes = $('.inputCheckBox:checked').length;
//                 $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
//             });
//
//             // 페이지 버튼 클릭 시 이벤트 처리
//             $("a.change-page").on("click", function(e) {
//                 e.preventDefault();
//                 let page = $(this).attr("href"); // 페이지 번호를 숫자로 변환
//                 console.log(page);
//                 let type = $("select[name=type]").val();
//                 let keyword = $("input[name=keyword]").val();
//
//             });
//         },
//         error: function(error) {
//             console.error(error);
//         }
//     });
// }

// $(document).ready(function(){
//     let text= "";
//     let type =$("select[name=type]").val();
//     let keyword=  $("input[name=keyword]").val();
//     getUserList();
// });
// function getUserList() {
//     $.ajax({
//         url: `/admin/member/{page}/{type}/{keyword}`,
//         type: 'GET',
//         success: function(response) {
//             response.forEach(user => {
//                 text += `
//                     <tr>
//                         <td class="inputCheckBoxBtn">
//                             <input class="inputCheckBox" type="checkbox" value="${user.id}">
//                         </td>
//                         <td>${user.id}</td>
//                         <td>${user.userIdentification}</td>
//                         <td>${user.userNickName}</td>
//                         <td>${user.userName}</td>
//                         <td>${user.userRole}</td>
//                         <td>${user.userTissue}</td>
//                         <td>${user.userCreatedDate}</td>
//                         <td></td>
//                     </tr>
//                 `;
//             });
//
//             $('.userTable tbody').html(text);
//
//         },
//         error: function(error) {
//             console.error(error);
//         }
//     });
// }

// let page = $(this).attr("href");
// $(document).ready(function(){

let type = $("select[name=type]").val();
let keyword = $("input[name=keyword]").val();

/*모듈*/
let userService = (function(){

    function getUserList(callback) {
        $.ajax({
            url : `/admin/member/${page}/${type}/${keyword}`,
            success : function(users){
                if(callback){
                    callback(users);
                }
            }
        });
    }

    function deleteUser() {

        var checkboxes = $('.inputCheckBox');
        var selectItems = [];

        checkboxes.each(function (i, checkbox) {
            if ($(checkbox).prop('checked')) {
                selectItems.push($(checkbox).val()); // 선택된 항목의 val값을 배열 추가
            }
        });

        $.ajax({
            url: '/admin/member/delete',
            type: 'DELETE',
            data: JSON.stringify(selectItems),
            contentType: 'application/json',
            success: function(deletedUserIds) {
                location.href = "/admin/member";
            },
            error: function(error) {
                console.error(error);
            }
        });
    }

    return {getUserList: getUserList, deleteUser: deleteUser};
})();
let tbody = $('.userTable tbody');
//이벤트 DOM , Ajax
userService.getUserList(showList);
    function showList(users){
        console.log(users);
        let text = "";
            users.forEach(user => {
                text += `
                    <tr>
                        <td class="inputCheckBoxBtn">
                            <input class="inputCheckBox" type="checkbox" id="checkAll" value="${user.id}">
                        </td>
                        <td>${user.id}</td>
                        <td>${user.userIdentification}</td>
                        <td>${user.userNickName}</td>
                        <td>${user.userName}</td>
                        <td>${user.userRole}</td>
                        <td>${user.userTissue}</td>
                        <td>${user.userCreatedDate}</td>
                        <td></td>
                    </tr>
                `;
            });

    // 변경된 내용을 추가합니다.
        tbody.html(text);


            // let type = $("select[name=type]").val();
            // let keyword = $("input[name=keyword]").val();

            // 전체 선택 체크박스 클릭 시 모든 체크박스 선택
            $('#checkAll').on('click', function() {
                $('.inputCheckBox').prop('checked', $(this).prop('checked'));
            });

            // 체크박스를 다 체크하면 전체 선택 체크박스도 선택
            $('.inputCheckBox').on('click', function() {
                var totalCheckboxes = $('.inputCheckBox').length;
                var checkedCheckboxes = $('.inputCheckBox:checked').length;
                $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
            });

            // 페이지 버튼 클릭 시 이벤트 처리
            $("a.change-page").on("click", function(e) {
                e.preventDefault();
                let page = $(this).attr("href"); // 페이지 번호를 숫자로 변환
                console.log(page);
                // let type = $("select[name=type]").val();
                // let keyword = $("input[name=keyword]").val();

            });
}

