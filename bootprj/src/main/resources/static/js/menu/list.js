window.addEventListener("load", function() {

	const menuList = document.querySelector(".menu-list")
	let ul = document.querySelector(".menu-category>ul");
	const form = document.querySelector(".search-header form");
	const findButton = form.querySelector(".icon-find");

	findButton.onclick = function(e) {
		e.preventDefault();
		const queryValue = form.querySelector("input[name=q]").value;

		const request = new XMLHttpRequest();
		request.onload = function() {
			let menus = JSON.parse(request.responseText);
			bind(menus);
		}
		request.open("GET", `http://localhost:8080/menus?q=${queryValue}`, true);
		request.send();
	}

	ul.onclick = function(e) {
		e.preventDefault();
		//화살표 함수를 사용하면 {}안의 지역화가 안 이루어진다.
		let tagName = e.target.tagName;
		if (tagName != 'LI' && tagName != 'A') //태그명이 li랑 a가 아니면 return
			return;

		//데이터 수집을 해야 한다.
		let elLi = tagName === 'LI' ? e.target : e.target.parentNode;
		let curLi = ul.querySelector("li.menu-selected");
		if (curLi === elLi)
			return;

		curLi.classList.remove("menu-selected");
		elLi.classList.add("menu-selected");

		let categoryId = elLi.dataset.cid;
		const request = new XMLHttpRequest();
		request.onload = function() {
			let menus = JSON.parse(request.responseText);
			bind(menus);
		}
		//브라우저에서 url을 입력하는 것과 같은 요청
		if (categoryId)
			request.open("GET", `http://localhost:8080/menus?c=${categoryId}`, true);
		else
			request.open("GET", `http://localhost:8080/menus`, true);
		request.send();
	};

	function bind(menus) {
		menuList.innerHTML = "";
		// 기존 목록을 모두 지우고
		//menuList.children[0].remove();
		//menuList.removeChild(menuList.firstElementChild);

		//목록 지우는 방법 1
		//			while(menuList.firstElementChild)
		//				menuList.firstElementChild.remove();

		//let size = menuList.children.length;
		//for(let i=0; i<size; i++){
		//menuList.firstElementChild.remove();
		//}
		//목록 지우는 방법 2

		//			let menuSection = document.createElement("section");
		//			menuSection.className = "menu";
		//			let form = document.createElement("form");
		//			form.className="";
		//			
		//			//노드의 기능
		//			//menuSection.appendChild(form);
		//			
		//			//Element의 기능
		//			menuSection.append(form);
		//			menuList.append(menuSection);


		//방법 2 : 문자열을 이용한 객체 생성
		for (let m of menus) {
			let template = `<section class="menu">
		                <form class="">
		                    <h1><span>${m.name}</span></h1> 
		                    <div class="menu-img-box">
		                        <a href="detail.html"><img class="menu-img" src="/image/product/12.png"></a>
		                    </div>    
		                    <div class="menu-price">${m.price}</div>
		                    <div class="menu-option-list">
		                        <span class="menu-option">
		                            <input class="menu-option-input" type="checkbox">
		                            <label>ICED</label>
		                        </span>            
		                        <span class="menu-option ml-2">
		                            <input class="menu-option-input" type="checkbox">
		                            <label>Large</label>
		                        </span>
		                    </div>
		                    <div class="menu-button-list">
		                        <input class="btn btn-fill btn-size-1 btn-size-1-lg" type="submit" value="담기">
		                        <input class="btn btn-line btn-size-1 btn-size-1-lg ml-1" type="submit" value="주문하기">
		                    </div>
		                </form>
		            </section>`
			//				menuList.innerHTML += template;
			//기존에 것에 추가하는 것
			menuList.insertAdjacentHTML("beforeend", template);
		}
	}
});



		//예전 방식 XmlHttpRequest
/*		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function() {
			if (this.readyState === 4) {
				console.log(this.responseText);
			}
		});

		xhr.open("GET", "http://localhost:8080/menus/617");
		xhr.send();
		
		//Fetch API
		var requestOptions = {
			method: 'GET',
			redirect: 'follow'
		};

		fetch("http://localhost:8080/menus/617", requestOptions)
			.then(response => response.text())
			.then(result => console.log(result))
			.catch(error => console.log('error', error));
	 */
