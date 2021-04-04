// 引入需要的 js 和 css
import $ from 'jquery';
import "./static/css/style.css";

$("#app").html("Hello World!");
var imgSrc = require('./static/img/picture.jpg');
$("#profile").attr("src", imgSrc);