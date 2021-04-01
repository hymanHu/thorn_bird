const path = require('path');
const webpack = require('webpack');
// 用于插入 html 模板
const HtmlWebpackPlugin = require('html-webpack-plugin');
// 清除输出目录，免得每次手动删除
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
	entry: {
		vueQrCode1: path.join(__dirname, 'app.js'),
	},
	output: {
		path: path.join(__dirname, '/dist'),
		// [name]入口的名字
		filename: 'js/[name].[chunkhash:4].js'
	},
	module: {
		rules: [
			{
				test: /\.vue$/,
				loader: 'vue-loader',
				exclude: /node_modules/,
				include: resolve('src')
			},
			{
				test: /\.s?css$/,
				use: [
					MiniCssExtractPlugin.loader,
					'css-loader',
					'sass-loader'
				]
			},
			{
				test: /.(png|jpe?g|gif|svg)(\?.*)?$/,
				use: ['url-loader', 'image-webpack-loader'],
				options: {
					limit: 10000,
					name: 'static/img/[name].[hash:7].[ext]'
				}
			},
		],
	},
	plugins: [
		new CleanWebpackPlugin(),
		new HtmlWebpackPlugin({
			filename: 'index.html',
			template: 'index.html',
		}),
	],
};