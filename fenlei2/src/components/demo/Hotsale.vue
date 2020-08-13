<template>
    <div id="app">
        <div class="sale">
            <table></table>
            <div class="hotsale">
                <div class="hotsale_top">
                    <p>猜你喜欢</p>
                </div>
                <div class="hotsale_btn"  v-for="(item,index) in content" :key="index">
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <table></table>   
        </div> 
    </div>
</template>
<script>
export default {
    data(){
        return{
            content:10
        }
    }
}
</script>
<style scoped>
    .sale{
        background-color: #f0f0f0;
        width: 100%;
        margin-bottom: 54.8px;
    }
    .hotsale{
        background-color: #f0f0f0;
        padding: 0px 1rem;
    }
    .hotsale_top{
        width: 100%;
        border-top: 1px solid #dcdcdc;
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
        margin: 24px 0px;
        background-color: #f5f5f5;
    }
    .hotsale_top>p{
        position: absolute;
        top:-8px;
        background-color: #f0f0f0;
        padding: 0px 1rem;
        font-size: 1.6rem;
        letter-spacing:.1rem;
    }
    .hotsale_btn{
        width: 100%;
        margin: 1rem 0px;
        display: flex;
        justify-content: space-between;
    }
    .lieB1{
        width: 49%;
        border-radius: .6rem;
        overflow: hidden;
        /* margin-bottom: 1rem; */
    }
    .lieB1>div{
        width: 100%;
        background-color: #f5f5f5;
        /* padding: 1rem; */
    }
    .lieB1>div>div{
        width: 100%;
        background-color: #fff;
        /* padding: 1rem; */
    }
    .lieB1_top{
        width: 100%;
    }
    .lieB1_top>img{
        width: 100%;
    }
    .lieB1_z{
        padding: 0px 1rem;
    }
    .lieB1_z>p:first-child{
        font-size: 1.4rem;
        color: #1a1a1a;
        margin-top: 1rem;
    }
    .lieB1_z>p:last-child{
        font-size: 1.2rem;
        color: #afafaf;
        margin-top: .5rem;
    }
    .lieB1_btn{
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin: 1rem 0px 1rem;   
        padding: 0px 1rem;
    }
    .lieB1_btn_l{
        display: flex;
        align-items: center;
    }
    .lieB1_btn_l>div:first-child{
        font-size: 1.8rem;
        color: #e95960;
        font-weight:600;
    }
    .lieB1_btn_l>div:first-child>span{
        font-size: 1.2rem;
        color: #e95960;
        margin-right: -0.5rem;
    }
    .lieB1_btn_l>p{
        text-decoration: line-through;
        font-size: 1.4rem;
        color: #bcbcbc;
    }
    .lieB1_btn_r{
        width: 2.8rem;
        height: 2.8rem;
        background: linear-gradient(#4ad278,#33b05d);
        border-radius: 1.4rem;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        /* margin: -0.5rem 0 0 7rem; */
    }
    .lieB1_btn_r>img{
        width: 1.6rem;
        height: 1.6rem;
    }
</style>