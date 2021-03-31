<template>
    <div class="hello">
        Hello {{name}}
    </div>
</template>
 
<script>
    module.exports={
        data: function () {
            return {
                name: 'HymanHy'
            }
        }
    }
</script>
 
<style scoped>
    .hello {
        padding: .5em;
        font-size: 2em;
        background-color: #fcf;
    }
</style>