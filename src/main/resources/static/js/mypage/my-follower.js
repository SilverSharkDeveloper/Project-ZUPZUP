$(document).ready(function(){
    const $div = $(".css-10zpfwf div");


    let text = "";
    follows.forEach(follow => {
        text += `
            <div class="" style="">
                                    <div class="css-1wwhxfz euanis37"><a class="css-1fqwelk euanis35"
                                                                         href="/users/3220925">
                                        <div class="css-qmr1ou euanis34"><img class="css-1cqverl euanis33"
                                                                              src="/image/mypage/base.png">
                                        </div>
                                        <div class="css-1fxvqh3 euanis32">
                                            <div class="css-19pzwhy euanis31">${follow.userNickname}</div>
                                            <div class="css-ei2twn euanis30">${follow.userIntroducingMessage}</div>
                                        </div>
                                    </a>
                                        <button class="_3Z6oR _1zLQC _1XHs9 css-19kmlp8 e43q1md0" type="button">삭제
                                        </button>
                                    </div>
                                </div>
        `
    });

    $div.html(text);
});