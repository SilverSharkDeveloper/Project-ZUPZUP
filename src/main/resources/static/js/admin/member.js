// let page;
// let type;
// let keyword;
// $(document).ready(function() {
//     getList(showList);
//
// });
//
//
// function getList(callback, page) {
//     $.ajax({
//         url: `/member/${page}`,
//         success: function (users) {
//             if (callback) {
//                 callback(users);
//             }
//         }
//     });
// }
//
// function showList(users){
//     let text = ``;
//         users.forEach(user => {
//             text += `
//                   <tr>
//                         <td class="inputCheckBoxBtn">
//                             <input class="inputCheckBox" id="checkAll" type="checkbox" value="${user.id}">
//                         </td>
//                         <td>${user.id}</td>
//                         <td>${user.userIdentification}</td>
//                         <td>${user.userNickname}</td>
//                         <td>${user.userName}</td>
//                         <td>${user.userRole}</td>
//                         <td>${user.userTissue}</td>
//                         <td>${user.userCreatedDate}</td>
//                         <td></td>
//                     </tr>
//                 `;
//         });
//         $('.userTable tbody').append(text);
//
//     // 전체 선택 체크박스 클릭 시 모든 체크박스 선택
//     $('#checkAll').on('click', function() {
//         $('.inputCheckBox').prop('checked', $(this).prop('checked'));
//     });
//
//     // 체크박스를 모두 체크하면 전체 선택 체크박스도 선택
//     $('.inputCheckBox').on('click', function() {
//         var totalCheckboxes = $('.inputCheckBox').length;
//         var checkedCheckboxes = $('.inputCheckBox:checked').length;
//         $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
//     });
//
//
//
// //페이징
//
//     $("a.change-page").on("click", function(e) {
//         e.preventDefault();
//         page = $(this).attr("href");
//         type = $("select[name=type]").val();
//         keyword = $("input[name=keyword]").val();
//         location.href = `/admin/member?page=${page}&type=${type}&keyword=${keyword}`;
//     });
// };
//
//
// function deleteUsers() {
//     var checkboxes = $('.inputCheckBox');
//     var selectItems = [];
//
//     checkboxes.each(function(i, checkbox) {
//         if ($(checkbox).prop('checked')) {
//             selectItems.push($(checkbox).val()); // 선택된 항목의 val값을 배열에 추가
//         }
//     });
//
//     $.ajax({
//         url: `/member/delete/${selectItems}`,
//         type: 'DELETE',
//         data: JSON.stringify(selectItems),
//         contentType: 'application/json',
//         dataType: 'json',
//         success: function(userIds) {
//             getList(showList());
//         },
//         error: function(error) {
//             console.error(error);
//         }
//     });
// }
//
//
