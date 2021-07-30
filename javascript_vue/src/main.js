// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
// import ElementUI from "element-ui";
// import "element-ui/lib/theme-chalk/index.css";
import { Button, Select } from "element-ui";

// 全局引入 ElementUI，注意样式文件需要单独引入
// Vue.use(ElementUI);
// 局部按需导入，两种写法
Vue.use(Button);
Vue.use(Select);
// Vue.component(Button.name, Button);
// Vue.component(Select.name, Select);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
	el: "#app",
	router,
	components: { App },
	template: "<App/>"
});
