<!-- 
App.vue 是项目的根组件，是唯一由 main.js 加载渲染的组件，替换 index.html 页面中的 <div id="app"></div>
router-view 是前台路由占位标签，由 router 插件控制
router-view 根据 index.js 中配置的路由关系，完成指定路径匹配指定页面组件，进行渲染
router-view 会被不同的页面组件替换，就形成了页面跳转
-->
<template>
	<div id="app">
		<img src="./assets/logo.png" />
		<router-view />
	</div>
</template>

<script>
// 无论是文件组件还是小组件，都可能被引用多次，在此设置导出的组件名
export default {
	name: "App"
};
</script>

<style>
#app {
	font-family: "Avenir", Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
	margin-top: 60px;
}
</style>
