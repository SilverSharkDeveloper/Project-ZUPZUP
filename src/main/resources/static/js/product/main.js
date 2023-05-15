$(document).ready(function() {
    var $local = $("div.local");
    var $category = $("div.category-item");
    console.log($local.length);
    // 클릭 이벤트를 바인딩
    $local.on('click', function() {
        event.preventDefault();
        // 이전에 활성화된 요소에서 localactive 클래스 제거
        $local.removeClass('localactive');
        console.log("클래스 제거");
        // 클릭된 요소에 localactive 클래스 추가
        $(this).addClass('localactive');
        console.log("클래스 추가");
    });
    $category.on("click",function () {
        event.preventDefault();
        $category.removeClass('categoryactive');
        $(this).addClass('categoryactive');
    });

    var $transimage = $("article.production-item");

    $transimage.on("mouseover", function () {
        event.preventDefault();
        console.log("이미지 들어옴")
        console.log($(this).find('.image').toString());
        $(this).find('.image').addClass('transimage');
        $(this).children('.image').css(
            {
                "transition": "transform 2s ease",
                "transform": "scale 1.05"
            }
        )
        console.log("이미지 변화끝?");
    });
});