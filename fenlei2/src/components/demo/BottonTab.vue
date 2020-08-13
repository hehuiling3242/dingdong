<template>
    <div id="app">
        <img src="" alt="">
        <div class="botton_tab">
            <div class="tab_item" @click="switchTo(a)">
                <img :src="$route.path=='/'? tabBarImgArr[0].selected : tabBarImgArr[0].normal" class="but">
                <span :class="{on:a === $route.path}">首页</span>
            </div>
            <div class="tab_item" @click="switchTo(b)">
                <img :src=" $route.path=='/classify' ? tabBarImgArr[1].selected : tabBarImgArr[1].normal" class="but">
                <span :class="{on:b === $route.path}">分类</span>
            </div>
            <div class="tab_item" @click="switchTo(c)">
                <img :src=" $route.path=='/whateat'? tabBarImgArr[2].selected : tabBarImgArr[2].normal" class="but">
                <span :class="{on:c === $route.path}">吃什么</span>
            </div>
            <div class="tab_item" @click="switchTo(d)">
                <img :src=" $route.path=='/cart' ? tabBarImgArr[3].selected : tabBarImgArr[3].normal" class="but">
                <span :class="{on:d === $route.path}">购物车</span>
            </div>
            <div class="tab_item" @click="switchTo(e)">
                <img :src=" $route.path=='/mine' ? tabBarImgArr[4].selected : tabBarImgArr[4].normal" class="but">
                <span :class="{on:e === $route.path}">我的</span>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            tabBarImgArr:[   //图片切换
                {normal: require('./../../assets/coverage.png'), selected: require('./../../assets/coverage_hover.png')},
                {normal: require('./../../assets/classify.png'), selected: require('./../../assets/classify_hover.png')},
                {normal: require('./../../assets/whateat.png'), selected: require('./../../assets/whateat_hover.png')},
                {normal: require('./../../assets/cart.png'), selected: require('./../../assets/cart_hover.png')},
                {normal: require('./../../assets/mine.png'), selected: require('./../../assets/mine_hover.png')},
            ] ,
            a:"/",
            b:"/classify",
            c:"/whateat",
            d:"/cart",
            e:"/mine",
        }
    },
    methods:{
        switchTo(path){
        // console.log(this.$router)
            this.$router.replace(path)
        }
    }
}
</script>
<style scoped>
.botton_tab{
    width: 100%;
    height: 8%;
    background-color: #f8f8f8;
    position:fixed;
    left: 0px; 
    bottom:0px;
    display: flex;
}
.tab_item{
    display: flex;
    flex: 1;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    color: #5c5c5c;
}
.tab_item>span{
    font-size: .8rem;

}
.tab_item>img{
    width: 4rem;
    height: 3rem;
}
.on{
    color: #3dcc5f;
}
.but{
    margin-bottom: .5rem;
}
</style>
