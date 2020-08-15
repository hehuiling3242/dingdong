<template>
    <div id="app">
        <!-- <h1>购物车</h1> -->
        <xitongtwo></xitongtwo>
        <shoppings></shoppings>
        <hotsale></hotsale>
        <bottontab></bottontab>
    </div>
</template>
<script>
import shoppings from '../demo/Soppings.vue'
// 猜你喜欢
import hotsale from '../demo/Hotsale'
export default {
    components:{
        hotsale,
        shoppings
    },
    mounted(){
        var id=sessionStorage.getItem("id")
        console.log(id)
        if(id==null){
            console.log("您未登录");
            this.$router.replace("/login");
        }else{
            console.log("登录成功")
        }
    },
}
</script>
<style scoped>
/* #app{
    font-size: 62.5%;
    width: 100%;
    height: 100Vh;
} */
/* .cart_btn{
    display: flex;
    width: 100%;
} */
</style>