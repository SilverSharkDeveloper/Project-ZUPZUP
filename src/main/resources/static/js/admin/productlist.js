$(document).ready(function(){
    let text= "";
    console.log(products);
    products.forEach(product =>{
        text+= `
            <tr>
                <td class = "inputCheckBoxBtn"><input value="${product.id}"class="inputCheckBox"type="checkbox"></td>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.productUsedLocation}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productStock}</td>
                    <td>${product.productCost}</td>
                    <td>${product.productRegisterDate}</td>
                    
            </tr>
            `
    });
    $('.productTable tbody').html(text);
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
});

//페이징

$("a.change-page").on("click", function(e){
    // 어디로 이동해야할 페이지
    e.preventDefault();
    let page = $(this).attr("href");
    let type= $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    console.log(page);
    location.href = `/admin/product?page=${page}&type=${type}&keyword=${keyword}`;
    // location.href = "/admin/notice?page=" + page;
});


function deleteProduct() {
    var checkboxes = $('.inputCheckBox');
    var selectItems = [];

    checkboxes.each(function(i, checkbox) {
        if ($(checkbox).prop('checked')) {
            selectItems.push($(checkbox).val()); // 선택된 항목의 val값을 배열에 추가
        }
    });

    $.ajax({
        url: '/admin/product/delete',
        type: 'DELETE',
        data: JSON.stringify(selectItems),
        contentType: 'application/json',
        dataType: 'json',
        success: function(deletedNoticeIds) {
            location.href = "/admin/product";
        },
        error: function(error) {
            console.error(error);
        }
    });
}