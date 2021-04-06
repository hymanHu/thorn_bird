import Vue from "vue";
import VueQrCode from "./components/VueQrCode.vue";

var qrVue = new Vue({
	el: "#vueQr",
	// 使用 render 函数引入 Vue 组件
	render: function(createElement) {
		return createElement(VueQrCode);
	},
});
