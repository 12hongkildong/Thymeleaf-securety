Vue
.createApp({
	data(){
		let x = 30;
		let y = 50;
		let z = 0;
		return{x,y,z};
	},
	methods:{
		calcHandler(e){
			this.z =this.x+this.y;
		},
		resetHandler(e){
			this.z = 0;
		}
	}
})
.mount("#calc") //view의 영역