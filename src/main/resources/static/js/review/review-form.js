//지역
$(".location-btn").on("click",e=>{
    $(".big-location-box").toggle();
})

$(".closeing-location").on("click", e=>{
    $(".big-location-box").toggle();
    $(".location-btn")[0].innerText ="선택해주세요";
    $(".end-location")[0].innerText ="선택해주세요";
    $(".small-location").each((idx,small)=>{
        $(small).css("display","none");
    })
})



let bigLocation;


$(".big-location").each((i,big)=>{
    $(big).on("click",e=>{
        bigLocation = e.target.innerText;
        console.log(bigLocation);
        $(".small-location").each((idx,small)=>{
            if(i==idx){
                $(small).css("display","block");
            }else{
                $(small).css("display","none");
            }




        })
    })
})



$(".small-location .panel-entry-list__item").on("click",e=>{
    $(".big-location-box").toggle();
    if(e.target.innerText.includes("전체")){
        $(".location-btn")[0].innerText =bigLocation;
    }else{

        $(".location-btn")[0].innerText =bigLocation+ " " + e.target.innerText;
    }
    $(".small-location").each((idx,small)=>{
        $(small).css("display","none");
    })
})

$(".sejong").on("click",e=>{
    $(".big-location-box").toggle();
    $(".location-btn")[0].innerText ="세종특별자치시";
    $(".small-location").each((idx,small)=>{
        $(small).css("display","none");
    })
})



//이미지추가


$(".add-image").each((i,item)=>{
    $(item).on("click",e=>{

        $($(".representingImage")[i]).trigger("click");
    })
})

let check;
$(".add-image-btn").each((i,item)=>{
    $(item).on("click",e=>{
        if($(".representingImage")[i].value){
            check = true
        }
        $($(".representingImage")[i]).trigger("click");
    })
})

$(".delete-image-btn").each((i,item)=>{
    $(item).on("click",e=>{
        $($(".representingImage")[i]).value ="";
        $($(".cover-image")[i]).css("display","none");
        $($(".cover-image-add")[i]).css("display","block");
        if(i<4){
            $($(".cover-image-add")[i+1]).css("display","none");
        }
        if(i>0){
            $($(".delete-image-btn")[i-1]).css("display","block")
        }
    })
})



$(".representingImage").each((i,item) =>{
    $(item).on("change", e => {
        // 이 때 e객체로 업로드된 파일의 정보를 가져올 수 있다(e.target.files[0]).
        // console.log(e.target.files[0]);

        // 하지만 change 이벤트 객체만으로는 해당 파일의 경로를 알 수 없기 때문에
        // FileReader객체가 필요하다.
        let reader = new FileReader();

        // reader객체의 readAsDataURL()메소드를 사용하여 파일의 정보를 전달해주면,
        reader.readAsDataURL(e.target.files[0]);
        // 모든 파일의 정보를 읽어왔을 때 onload 이벤트가 발생한다.
        // function(a){} == a => {}
        // function(e){} == e => {}


        reader.onload = event => {

            $($(".cover-image")[i]).css("backgroundImage",`url('${event.target.result}`)
            $($(".cover-image")[i]).css("background-size","100%");
            $($(".cover-image")[i]).css("background-repeat","no-repeat");
            $($(".cover-image")[i]).css("background-position","center");
            $($(".cover-image")[i]).css("display","block");


            if(check){
                check = false;
                return
            }

            $($(".cover-image-add")[i]).css("display","none");

            $($(".add-image-btn")[i]).css("display","block");
            $($(".delete-image-btn")[i]).css("display","block");

            if(i>0){
                $($(".delete-image-btn")[i-1]).css("display","none");
            }



            if(i<4){
                $($(".cover-image-add")[i+1]).css("display","block");
            }
        };
    });
})




$(".guide").on("click",e=>{
    $(".guide-detail").slideToggle();

    if( $(".toggle-icon")[0].style.transform =="rotate(180deg)"){
        $(".toggle-icon")[0].style.transform ="rotate(0deg)"
    }else{

        $(".toggle-icon")[0].style.transform ="rotate(180deg)"
    }
})

$(".input-btn").on("click",e=>{
    $(".input-detail").slideToggle();

    if( $(".toggle-icon")[1].style.transform =="rotate(180deg)"){
        $(".toggle-icon")[1].style.transform ="rotate(0deg)"
    }else{

        $(".toggle-icon")[1].style.transform ="rotate(180deg)"
    }
})




$(".title").on("keyup",e=>{
    $(".title-count")[0].innerText = `${e.target.value.length} / 80`;
})







