<template>
	<div class="qrCodeDiv">
		<h1>二维码</h1>
		<vue-qr ref="Qrcode" :text="dataObj.text" :logoSrc="dataObj.logo" :callback="test" qid="testQrId"></vue-qr>
	</div>
</template>

<script>
import VueQr from "vue-qr";
export default {
    name: "vueQrCode1",
    components: { VueQr },
    data() {
        return {
            dataObj: {
                text: "https://blog.csdn.net/weixin_43760328/rss/list",
                //logo: require("../assets/logo.png")
            }
        };
    },
    methods: {
        test(dataUrl, id) {
            console.log(dataUrl);
            console.log(id);
        }
    }
};
</script>

<style scoped>
h1,h2 {
    font-weight: normal;
}
ul {
    list-style-type: none;
    padding: 0;
}
li {
    display: inline-block;
    margin: 0 10px;
}
a {
    color: #42b983;
}
</style>