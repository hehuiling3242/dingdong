<template>
    <div id="app">
        <!-- <h1>我的</h1> -->
        <mynews></mynews>
        <hotsale></hotsale>
        <bottontab></bottontab>
    </div>
</template>
<script>
// 上半部分
import mynews from '../demo/myNews.vue'
// 猜你喜欢
import hotsale from '../demo/Hotsale'
export default {
    components:{
        hotsale,
        mynews
    },
}
</script>
<style scoped>
/* #app{
    font-size: 62.5%;
    width: 100%;
    height: 100Vh;
} */

</style>