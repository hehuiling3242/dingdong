<template>
    <div class="homenew">
        <table></table>
        <div class="homenew_top">
            <div class="homenew_top_l">
                <h2>108元券包</h2>
                <p>新人专享,抢完为止</p>
            </div>
            <!-- <div class="homenew_top_r">
                <p>查看更多></p>
            </div> -->
        </div>
        <div class="homenew_btn">
            <div class="sliding_box">
                <div class="sliding_item" v-for="(item,index) in content" :key="index">
                    <div class="sliding_item_img">
                        <div class="sliding_item_img_top">
                            <div><span>¥</span>13</div>
                        </div>
                        <div class="sliding_item_img_btn">
                            <p>满39元使用</p>
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
            content: 7
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
        padding: 0px 1rem 0px 1rem;
        /* height: 500px; */
        box-sizing: border-box;
    }
    .homenew .homenew_top{
        display: flex;
        justify-content: space-between;
        color: #fff;
        margin: 1rem 0px 1rem 0px;
    }
    .homenew .homenew_top_l{
        display: flex;
        align-items:flex-end
    }
    .homenew .homenew_top_l>h2{
        font-size: 1.8rem;
        font-weight:800;
        letter-spacing:.1rem;
        margin-right: .5rem;
    }
    .homenew .homenew_top_l>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .homenew .homenew_top_r{
        display: flex;
        align-items:flex-end
    }
    .homenew .homenew_top_r>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .homenew .sliding_box{
        display: flex;
        overflow-y: hidden;
        overflow-x: scroll;
        /* background-color: #fff; */
        border-radius: .6rem;
        margin-bottom: .8rem;
        /* overflow-y: scroll; */
        /* overflow:hidden */
    }
    .homenew .sliding_item{
        display: flex;
        margin-right: .8rem;
        /* background-color: #CDCDCD; */
        border-radius: .6rem;
    }
    .homenew .sliding_item_img {
        width: 8rem;
        height: 7rem;
        border-radius: .6rem;
        display: flex;
        flex-direction: column;
        align-items:center;
        background: url("../../assets/img/youhuiquanbgc.png");
        margin-right: 10px;
    }
    
    .homenew .sliding_item_btn{
        display: flex;
        margin-top: 2.6rem;
        align-items:center;
    }
    
    .homenew .sliding_item_btn_l{
        margin-right: 2rem;
    }
    .homenew .sliding_item_btn_l>div{
        font-size: 1.4rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .homenew .sliding_item_btn_l>div>span{
        font-size: .6rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .homenew .sliding_item_btn_l>p{
        font-size: 1.2rem;
        color: #b4b4b4;
        /* font-weight:800; */
        /* text-decoration:none */
        text-decoration:line-through;
    }
    .homenew .sliding_item_btn_r{
        width: 2.8rem;
        height: 2.8rem;
        background: linear-gradient(#4ad278, #33b05d);
        border-radius: 1.4rem;
        display: flex;
        justify-content:center;
        align-items: center;
    }
    .homenew .sliding_item_btn_r>img{
        width: 1.6rem;
        height: 1.6rem;
    }
    .homenew .sliding_item_img_top{
        margin-top: 8px;
    }
    .homenew .sliding_item_img_top>div{
        font-size: 3rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .homenew .sliding_item_img_top>div>span{
        font-size: 1.4rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .homenew .sliding_item_img_btn{
        margin-top: 1.4rem;
    }
    .homenew .sliding_item_img_btn>p{
        font-size: 1.4rem;
        color: #ff3e3d;
        /* font-weight:800; */
    }
</style>