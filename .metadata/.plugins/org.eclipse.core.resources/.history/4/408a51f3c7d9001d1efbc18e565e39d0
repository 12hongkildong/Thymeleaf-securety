Vue
	.createApp({
		data() {
			return {
				test: "hello",
				list: [],
				isShowRegForm: true,
				menu: { name: "", price: 0 }
			};
		},
		methods: {
			categoryClickHandler(e) {
				//			this.load(e.target.dataset.id, function(){
				//				
				//				console.log("데이터가 도착했니?");			
				//			});
				this.list.push({ id: 4, name: "디카페인 아메리카노", price: 5500 });
				//this.load(2);
			},
			load() {
				//let promise = fetch("/menus");

				fetch("/menus")
					.then(response => {
						return response.json();
					})
					.then(list => {
						//return list[1];
						//return list;
						this.list = list; // 대치되는 것 
					})
					//			.then(menu=>{
					//				console.log(menu.name);
					//			})
					.catch(error => {
						console.log("aaa");
					});
			},
			menuAddHandler() {
				this.isShowRegForm = !this.isShowRegForm;
			},
			menuSaveHandler() {
				let myHeaders = new Headers();
				myHeaders.append("Content-Type", "application/json");

				let raw = JSON.stringify(this.menu);

				let requestOptions = {
					method: 'POST',
					headers: myHeaders,
					body: raw,
					redirect: 'follow'
				};
				
				fetch("http://localhost:8080/menus", requestOptions)
					.then(response => response.text())
					.then(result => {
						if(result==="ok"){
							this.load();
						}
					})
					.catch(error => console.log('error', error));
			}

			/*
			async load(cid){
				// callback 함수를 사용하는 request 객체의 send();
				setTimeout(()=>{
					console.log("load");
					callback();				
				}, 3000);
				
				//XHR(XmlHttpRequest) 나중에 호출해줘 
				//-Callback을 이용한 비동기처리 
				//Fetch API
				//-Promise를 이용한 비동기처리 
			}
			*/
		},
		mounted() { // 화면에 보인 다음. 화면이 떠야만 노드 조작이 된다. 
			console.log("mounted");
			this.load();
		},
		beforeCreate() { console.log("beforeCreate"); },
		created() { console.log("created"); }, // 화면에 보이기 전에 
		beforeMount() { console.log("beforeMount"); },
		beforeUpdate() { console.log("beforeUpdate"); },
		updated() { console.log("updated"); },
		beforeUnmount() { console.log("beforeUnmount"); },
		unmounted() { console.log("unmounted"); }
	})
	.mount("#main-section");

//Vue
//.createApp({
//	date:null,
//	methods:null,
//	props:null
//})
//.mount("#main-section");
//
//Vue
//.createApp() // 비어있는 것, 전달할게 많으면 묶어서 전달한다. 오브젝트!
//.mount("#main-section");


//methods:{
//
//     categoryClickHandler(e){
//        this.load(2);
//    },
//
//    async load(cid){
//    //        menus 에다가 요청함
//        let response = await fetch("/menus");
//        let list = await response.json();
//        console.log(list);
//    }
//}