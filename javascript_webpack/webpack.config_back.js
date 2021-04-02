/**
 * 导入依赖模块
 */
const path = require('path');
const webpack = require('webpack');
// 导出 html 文件
const HtmlWebpackPlugin = require('html-webpack-plugin');
// 清除输出目录，免得每次手动删除
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
// 加载 .vue 文件，vue-loader 15 版本需要
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
	// 入口
	entry: {
		jsEntry: path.join(__dirname, 'jsApp.js'),
		//vueQrCode: path.join(__dirname, 'vueApp.js'),
	},
	// 出口
	output: {
		path: path.join(__dirname, '/dist'),
		// [name]：入口的名字
		filename: 'js/[name].bundle.js'
	},
	// 初始化插件
	plugins: [
		new CleanWebpackPlugin(),
		new HtmlWebpackPlugin({
			filename: 'index.html',
			template: 'index.html',
		}),
		new VueLoaderPlugin(),
	],
	// 模块配置
	module: {
		rules: [
			{
				// 优先级 exclude > include > test
				test: /\.vue$/,
				loader: 'vue-loader',
				exclude: /node_modules/,
				include: [
					path.resolve(__dirname, "components"),
				],
			},
			{
				test: /\.css$/,
				// 使用 user 可添加多个 loader，则不能使用 options 属性
				use: [
					'css-loader',
					'style-loader',
				],
				exclude: /node_modules/,
			},
			{
				test: /.(png|jpe?g|gif|svg)(\?.*)?$/,
				loader: 'url-loader',
				options: {
					limit: 10000,
					name: 'static/img/[name].[hash:7].[ext]'
				},
				exclude: /node_modules/,
			},
		],
	},
};