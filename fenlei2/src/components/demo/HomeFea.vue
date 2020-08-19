<template>
    <div class="home_fea">
        <div>
            <div>
                <div></div>
                <p>特色专区</p>
            </div>
            <div class="home_fea_box">
                <div class="home_fea_body" style="border-right:0;border-bottom: 0;">
                    <p style="-webkit-background-clip: text;" class="home_fea_text">新品尝鲜</p>
                    <p>戈壁硒砂瓜 细嫩香甜</p>
                    <div class="home_fea_pic">
                        <img src="../../assets/img/jd-shuiguo.jpg" alt="" class="home_fea_SG">
                        <img src="../../assets/img/jd-shuiguo.jpg" alt="" class="home_fea_SG">
                    </div>
                </div>
                <div>
                    <p style="-webkit-background-clip: text;" class="home_fea_text1">7月爆款</p>
                    <p>很丑好甜 蜜宝火龙果</p>
                    <div class="home_fea_pic">
                        <img src="../../assets/img/jidan.png" alt="" class="home_fea_SG">
                        <img src="../../assets/img/jidan.png" alt="" class="home_fea_SG">
                    </div>
                </div>
                <div>
                    <p style="-webkit-background-clip: text;" class="home_fea_text2">平价菜场</p>
                    <p>苦瓜约550g 3.99元/份</p>
                        <div class="home_fea_pic">
                        <img src="../../assets/img/jd-xianrou.jpg" alt="" class="home_fea_SG">
                        <img src="../../assets/img/jd-xianrou.jpg" alt="" class="home_fea_SG">
                        </div>
                </div>
                <div class="home_fea_foot" style="border-left:0;border-top: 0;">
                    <div style="border-right:0.1rem solid #eee">
                        <p class="home_fea_title">一周菜单</p>
                        <p>童年·美味</p>
                        <div>
                        <img src="../../assets/img/kuaishoucai.jpg" alt="" class="home_fea_SG">
                        </div>
                    </div>
                    <div>
                        <p class="home_fea_title">绿卡专享</p>
                        <p>一省再省!</p>
                        <div>
                        <img src="../../assets/img/jd-shuiguo.webp" alt="" class="home_fea_SG">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
    .home_fea>div{
        background-color: #fff;
        box-sizing: border-box;
        padding-top: 0.5rem;
    }
    .home_fea>div>div:first-child{
        display: flex;
        align-items: center;
        margin: 0rem 1rem 0rem 1rem;
    }
    .home_fea>div>div:first-child>div{
        width: .4rem;
        height: 1.6rem;
        background: linear-gradient(90deg,#47d15e,#18bf49);
        margin-right: .8rem;
    }
    .home_fea>div>div:first-child>p{
        font-size: 1.8rem;
        /* font-weight: bolder; */
        letter-spacing:.1rem;
        font-weight:800;
        /* margin-left: 2rem; */
    }
    .home_fea>div>div:last-child{
         display: flex;
         flex-wrap: wrap;
         justify-content: space-around;
         box-sizing: border-box;
         margin: 1rem 1rem;
     }
     .home_fea>div>div:last-child>div{
         width: 50%;
         border: 0.1rem solid #eee;
         box-sizing: border-box;
     }
    .home_fea .home_fea_pic{
         display: flex;
     }
    .home_fea .home_fea_SG{
        width: 7rem;
        height: 7rem;
        margin-left: 0.7rem;
    }
    .home_fea .home_fea_foot{
        display: flex;
        justify-content: space-around;
    }
    .home_fea .home_fea_text{
        font-size: 1.8rem;
        font-weight: 600;
        background: linear-gradient(to right, #eb504d, #ef9659);
        color: transparent;
        margin-bottom: .7rem;
    }
    .home_fea .home_fea_text1{
        font-size: 1.8rem;
        font-weight: 600;
        background: linear-gradient(to right, #fc445e, #df6693);
        color: transparent;
        margin-bottom: .7rem;
    }
    .home_fea .home_fea_text2{
        font-size: 1.8rem;
        font-weight: 600;
        background: linear-gradient(to right, #5b8a76, #6ca652);
        color: transparent;
        margin-bottom: .7rem;
    }
    .home_fea>div>:last-child>div>:nth-child(2){
        font-size: 1.2rem;
        color:#989898;
        margin-bottom: .7rem;
    }
    .home_fea_title{
        color:#000;
        font-size: 1.8rem;
        font-weight: bold;
        margin-bottom: .7rem;
    }
    .home_fea_box>:nth-child(1),.home_fea_box>:nth-child(2),.home_fea_box>:nth-child(3){
        padding: 1rem  1.5rem;
    }
    .home_fea_foot>div>:nth-child(2){
        color:#989898;
        letter-spacing:.1rem;
        margin-bottom: .7rem;
    }
    .home_fea .home_fea_foot>div{
        width: 50%;
        box-sizing: border-box;
        padding: 0.7rem 0 0 0.8rem;
    }
</style>