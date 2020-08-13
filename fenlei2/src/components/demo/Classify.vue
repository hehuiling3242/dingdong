<template>
    <div id="app">
        <!-- <input type="text"> -->
        <xitongtwo></xitongtwo>
        <classifyinput></classifyinput>
        <div class="cart_btn">
            <listgoods ref="listgoods"></listgoods>
            <goods ref="goods"></goods>
        </div>
        <bottontab></bottontab>
    </div>
</template>
<script>
// 上半部分
import goods from '../demo/goods.vue'
// 猜你喜欢
import listgoods from '../demo/list_goods.vue'
export default {
    components:{
        goods,
        listgoods
    },
}
</script>
<style scoped>
/* #app{
    width: 100%;
    height: 100Vh;
} */
.cart_btn{
    display: flex;
    width: 100%;
}
</style>