$(document).ready(function(){
    if(order == 'popular'){
        let $order = $("button.order");
        $("button.orderActive").removeClass("orderActive");
        $order.eq(1).addClass("orderActive");
    }
})

$("button.order").on("click", function(e){
    e.preventDefault();
    let order = this.classList[1];
    if(this.classList.length == 7){
        $("button.orderActive").removeClass("orderActive");
        $(this).addClass("orderActive");
        location.href = `/review/list?page=${nowPage}&order=${order}`;
    }
});