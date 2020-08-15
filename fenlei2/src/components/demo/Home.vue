<template>
    <div id="app">
        <div class="app">
            <table></table>
            <xitong></xitong>
            <navtop></navtop>
            <classifyinputhome></classifyinputhome>
            <table> </table>
            <homenew></homenew>
            <homecoupon></homecoupon>
            <jiujiu></jiujiu>
            <homesort></homesort>
            <homead></homead>
            <homesale></homesale>
            <homefea></homefea>
            <table></table>
            <homelist></homelist>
            <bottontab></bottontab>
            <table></table>
        </div>
    </div>
</template>
<script>
// 新人尝鲜价
import homenew from '../demo/HomeNew.vue'
import homecoupon from '../demo/HomeCoupon.vue'
import homesale from '../demo/HomeSale.vue'
import navtop from '../demo/NavTop.vue'
import homefea from '../demo/HomeFea.vue'
import jiujiu from '../demo/jiujiu.vue'
// 特色专区
import homead from '../demo/home_ad.vue'
// 会员
import homesort from '../demo/home_sort.vue'
// 首页分类
import homelist from '../demo/HomeList.vue'
// 首页分类
export default {
    data(){
        return{
           
        }
    },
    methods:{
        
    },
    components:{
        homelist,
        homesort,
        homead,
        homenew,
        homecoupon,
        homesale,
        navtop,
        homefea,
        jiujiu
    }
}
</script>
<style scoped>
    ::-webkit-scrollbar { /*滚动条整体样式*/
        width: 0px; /*宽分别对应竖滚动条的尺寸*/
        height: 0px; /*高分别对应横滚动条的尺寸*/
    }
    .app{
        background: url("../../assets/img/home_bgc.gif") no-repeat;
        margin-bottom: 54.8px;
        /* padding-top: 55px; */
    }
</style>

