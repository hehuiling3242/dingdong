<template>
    <div class="homenew">
        <table></table>
        <div class="homenew_top">
            <div class="homenew_top_l">
                <h2>新人尝鲜价</h2>
                <p>限量供应,抢完为止</p>
            </div>
            <div class="homenew_top_r">
                <p>查看更多></p>
            </div>
        </div>
        <div class="homenew_btn">
            <div class="sliding_box">
                <div class="sliding_item" v-for="(item,index) in content" :key="index">
                    <div class="sliding_item_img">
                        <img src="../../assets/img/jidan.png" alt="">
                        <p>土鸡蛋8枚</p>
                        <div class="sliding_item_btn">
                            <div class="sliding_item_btn_l">
                                <div><span>¥</span>5.99</div>
                                <p>6.90</p>
                            </div>
                            <div class="sliding_item_btn_r">
                                <img src="../../assets/img/gouwuche.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table></table>
    </div>
</template>
<script>
export default {
    data(){
        return{
            content: 5
        }
    }
}
</script>
<style scoped>
    ::-webkit-scrollbar { /*滚动条整体样式*/
        width: 0px; /*宽分别对应竖滚动条的尺寸*/
        height: 0px; /*高分别对应横滚动条的尺寸*/
    }
    .homenew{
        /* background: url("../../assets/img/home_bgc.png") no-repeat; */
        padding: .5px 1rem .5px 1rem;
        /* height: 500px; */
        box-sizing: border-box;
    }
    .homenew_top{
        display: flex;
        justify-content: space-between;
        color: #fff;
        margin: 1rem 0px 1rem 0px;
    }
    .homenew_top_l{
        display: flex;
        align-items:flex-end
    }
    .homenew_top_l>h2{
        font-size: 1.8rem;
        font-weight:800;
        letter-spacing:.1rem;
        margin-right: .5rem;
    }
    .homenew_top_l>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .homenew_top_r{
        display: flex;
        align-items:flex-end
    }
    .homenew_top_r>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .sliding_box{
        display: flex;
        overflow-y: hidden;
        overflow-x: scroll;
        background-color: #fff;
        border-radius: .6rem;
        margin-bottom: .8rem;
        /* overflow-y: scroll; */
        /* overflow:hidden */
    }
    .sliding_item{
        display: flex;
        margin-right: .8rem;
        /* background-color: #CDCDCD; */
        border-radius: .6rem;
    }
    .sliding_item_img {
        width: 11.5rem;
        height: 20rem;
        border-radius: .6rem;
        display: flex;
        flex-direction: column;
        align-items:center;
    }
    .sliding_item_img>img{
        margin: 1.5rem 0px 1.5rem;
        width: 9rem;
        height: 9rem;
    }
    .sliding_item_btn{
        display: flex;
        margin-top: 2.6rem;
        align-items:center;
    }
    .sliding_item_img>p{
        font-size: 1.4rem;
        color: #393939;
        font-weight:800;
    }
    .sliding_item_btn_l{
        margin-right: 2rem;
    }
    .sliding_item_btn_l>div{
        font-size: 1.4rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .sliding_item_btn_l>div>span{
        font-size: .6rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .sliding_item_btn_l>p{
        font-size: 1.2rem;
        color: #b4b4b4;
        /* font-weight:800; */
        /* text-decoration:none */
        text-decoration:line-through;
    }
    .sliding_item_btn_r{
        width: 2.8rem;
        height: 2.8rem;
        background: linear-gradient(#4ad278, #33b05d);
        border-radius: 1.4rem;
        display: flex;
        justify-content:center;
        align-items: center;
    }
    .sliding_item_btn_r>img{
        width: 1.6rem;
        height: 1.6rem;
    }
</style>