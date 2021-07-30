"use strict";
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

// node 自带的文件路径工具
const path = require("path");

module.exports = {
  // 开发环境
  dev: {
    // Paths
    // 静态资源根目录
    assetsSubDirectory: "static",
    // 静态资源映射路径，建议修改为 ./ 因为打包之后，外部引入 js 和 css 文件时，
    // 如果路径以 ' / ' 开头，在本地是无法找到对应文件的（服务器上没问题）
    assetsPublicPath: "/",
    // 代理列表，建一个虚拟 api 服务器来代理本机的请求，只能用于开发模式
    proxyTable: {},

    // Various Dev Server settings
    // 域名
    host: "localhost", // can be overwritten by process.env.HOST
    // 端口
    port: 8080, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    // 是否打开浏览器
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-

    // Use Eslint Loader?
    // If true, your code will be linted during bundling and
    // linting errors and warnings will be shown in the console.
    useEslint: true,
    // If true, eslint errors and warnings will also be shown in the error overlay
    // in the browser.
    showEslintErrorsInOverlay: false,

    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: "cheap-module-eval-source-map",

    // If you have problems debugging vue-files in devtools,
    // set this to false - it *may* help
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

  build: {
    // Template for index.html
    index: path.resolve(__dirname, "../dist/index.html"),

    // Paths
    assetsRoot: path.resolve(__dirname, "../dist"),
    assetsSubDirectory: "static",
    assetsPublicPath: "/",

    /**
     * Source Maps
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: "#source-map",

    // Gzip off by default as many popular static hosts such as
    // Surge or Netlify already gzip all static assets for you.
    // Before setting to `true`, make sure to:
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false,
    productionGzipExtensions: ["js", "css"],

    // Run the build command with an extra argument to
    // View the bundle analyzer report after build finishes:
    // `npm run build --report`
    // Set to `true` or `false` to always turn it on or off
    bundleAnalyzerReport: process.env.npm_config_report
  }
};
