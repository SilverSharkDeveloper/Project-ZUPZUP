let page;
let type;
let keyword;

$(document).ready(function() {
    // 전체 선택 체크박스 클릭 시 모든 체크박스 선택
    $('#checkAll').on('click', function() {
        $('.inputCheckBox').prop('checked', $(this).prop('checked'));
    });

    // 체크박스를 모두 체크하면 전체 선택 체크박스도 선택
    $('.inputCheckBox').on('click', function() {
        var totalCheckboxes = $('.inputCheckBox').length;
        var checkedCheckboxes = $('.inputCheckBox:checked').length;
        $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
    });

    // 페이지 이동
    $("a.change-page").on("click", function(e) {
        e.preventDefault();
        page = $(this).attr("href");
        type = $("select[name=type]").val();
        keyword = $("input[name=keyword]").val();
        location.href = `/admin/notice?page=${page}&type=${type}&keyword=${keyword}`;
    });
});

// 공지사항 삭제
function deleteNotice() {
    var checkboxes = $('.inputCheckBox');
    var selectItems = [];

    checkboxes.each(function(i, checkbox) {
        if ($(checkbox).prop('checked')) {
            selectItems.push($(checkbox).val()); // 선택된 항목의 val값을 배열에 추가
        }
    });

    $.ajax({
        url: '/admin/notice/delete',
        type: 'DELETE',
        data: JSON.stringify(selectItems),
        contentType: 'application/json',
        dataType: 'json',
        success: function(deletedNoticeIds) {
            location.href = "/admin/notice";
        },
        error: function(error) {
            console.error(error);
        }
    });
}