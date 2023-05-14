showList();

function showList() {
    boards = JSON.parse(boards);
    console.log(boards);
    const $couponList = $(".virtualized-list");
    let text = "";

    boards.forEach(board => {
        text += `			
			<div class="col-6 col-md-3 product-item-wrap" style="display: inline-flex; max-width: 33%">
                        <article style="margin-right: 1rem;" class="production-item"><a
                                class="production-item__overlay"
                                href="/productions/767440/selling?affect_id&amp;affect_type=StoreHome"></a>
                            <div class="production-item-image production-item__image"><img class="image" alt=""
                                                                                           src="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/167168822852557476.jpg?gif=1&amp;w=360&amp;h=360&amp;c=c&amp;q=0.8"
                                                                                           srcset="https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/167168822852557476.jpg?gif=1&amp;w=640&amp;h=640&amp;c=c&amp;q=0.8 1.5x,https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/167168822852557476.jpg?gif=1&amp;w=720&amp;h=720&amp;c=c&amp;q=0.8 2x,https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/167168822852557476.jpg?gif=1&amp;w=1080&amp;h=1080&amp;c=c&amp;q=0.8 3x"><button
                                    class="production-item-scrap-badge production-item-image__scrap-badge"
                                    type="button"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                       viewBox="0 0 24 24" class="inactive-icon"></svg><svg class="active-icon"
                                                                                                            width="24" height="24" viewBox="0 0 24 24"
                                                                                                            preserveAspectRatio="xMidYMid meet"></svg></button>
                                <div class="production-item-image__dark-overlay"></div>
                            </div>
                            <div class="production-item__content">
                                <h1 class="production-item__header"><span
                                        class="production-item__header__brand">${board.located} </span><span
                                        class="production-item__header__name">${board.name}
                                            </span></h1><span class="production-item-price"><span
                                    class="production-item-price__price">${board.price}</span></span>
                            </div>
                        </article>

                    </div>			
			
			`;
    });
    if (!boards) {
        text += `
			<li>
				<div>
					현재 게시글이 없습니다. 게시글 작성을 해보세요!
				</div>
			</li>
			`;
    } else {
        if (boards.length == 0) {
            text += `
			<li>
				<div>
					현재 게시글이 없습니다. 게시글 작성을 해보세요!
				</div>
			</li>
			`;
        }
    }

    $ul.append(text);
}

/*참고용*/
/*<li class="inner">
				<a>
					<div class="img_wrap">
						<p class="img">
							<img alt="img" src="https://test-image.wishbeen.co.kr/160x160_376b52fa601151a3b5a651883155c734.jpg">
						</p>
					</div>
					<div class="txt_wrap">
						<ul>
							<li class="schedule"><span>ITEM</span>&nbsp&nbsp${board.item_name}</li>
							<li class="tit">${board.title}</li>
							<li class="nick">by ${board.name}</li>
							<li class="di_flex">
								<ul class="ico_wrap">
									<li><span class="ico_vote"></span> 200</li>
									<li><span class="ico_spot"></span> ${board.viewedCount}</li>
									<li><span class="ico_cmt"></span> 130</li>
								</ul>
							</li>
						</ul>
					</div>
				</a>
			</li>*/