<template>
    <div class="homenew">
        <table></table>
        <div class="HomeSale">
            <div class="HomeSale_l">
                <div></div>
                <h2>限时抢购</h2>
                <p>{{tohour}}</p>
                <span>:</span>
                <p>{{tominute}}</p>
                <span>:</span>
                <p>{{tosecond}}</p>
            </div>
            <div class="HomeSale_r">
                <p>更多</p>
            </div>
        </div>
        <div class="homenew_btn">
            <div class="sliding_box">
                <div class="sliding_item" v-for="(item,index) in content" :key="index">
                    <div class="sliding_item_img">
                        <img src="../../assets/img/xia.png" alt="">
                        <p>{{title}}</p>
                        <div class="sliding_item_btn">
                            <div class="sliding_item_btn_l">
                                <div><span>¥</span>{{price}}</div>
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
            // 数量
            content: 13,
            // 价格
            price: 19.90,
            // 标题
            title: "桂冠香肠(台湾风味) 108g/袋",
            a: null,   // 倒计时默认值
            oldTime: new Date().getTime(),   //获取现在距离1970年的毫秒数
            newTime: new Date('2020/8/4 00:00:00').getTime(),   //获取现在距离1970年的毫秒数
            second: null, //秒数
            hour: null,  //多少小时
            minute: null,  //多少分钟
            tosecond: null,
            tohour: null,
            tominute: null
        }
    },
    methods:{
        tow(n){
            return n>=0 && n<10 ? '0'+n : ''+n;
        },
        // getDate () {
        //     setInterval(this.load(),1000);
        // },
        load(){
            setInterval(()=>{
                this.oldTime= new Date().getTime()
                this.second=Math.floor((this.newTime - this.oldTime) / 1000),//总共多少秒
                this.hour=Math.floor(this.second / 3600),  //多少小时
                this.second %= 3600,
                this.minute=Math.floor(this.second / 60),  //多少分钟
                this.second %= 60
                this.tosecond=this.tow(this.second)
                this.tohour=this.tow(this.hour)
                this.tominute=this.tow(this.minute)
            },1000)
        },
    },
    mounted(){
        this.load()
        // this.tow(this.second)
    }
}
</script>
<style scoped>
    ::-webkit-scrollbar { /*滚动条整体样式*/
        width: 0px; /*宽分别对应竖滚动条的尺寸*/
        height: 0px; /*高分别对应横滚动条的尺寸*/
    }
    .homenew{
        
        box-sizing: border-box;
        margin-top: 1rem;
    }
    .HomeSale{
        display: flex;
        justify-content: space-between;
        color: #fff;
        margin: 1rem 0px 1rem 0px;
        padding: 0px 1rem 0px 1rem;
    }
    .HomeSale_l{
        display: flex;
        align-items:flex-end;
    }
    .HomeSale_l>div{
        width: .4rem;
        height: 1.6rem;
        background: linear-gradient(90deg,#47d15e,#18bf49);
        margin-right: .8rem;
    }
    .HomeSale_l>h2{
        font-size: 1.8rem;
        font-weight:600;
        letter-spacing:.1rem;
        margin-right: .5rem;
        color: #151515
    }
    .HomeSale_l>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
        width: 24px;
        height: 16px;
        background-color: #151515;
        border-radius: 4px;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .HomeSale_l>span{
        color: #151515;
        margin: 0px 5px 0px 5px;
        margin-bottom: .4rem;
    }
    .HomeSale_r{
        display: flex;
        align-items:flex-end
    }
    .HomeSale_r>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
        color: #4ebf71;
    }
    .sliding_box{
        display: flex;
        overflow-y: hidden;
        overflow-x: scroll;
        background-color: #fff;
        /* border-radius: .6rem; */
        margin-bottom: .8rem;
        /* overflow-y: scroll; */
        /* overflow:hidden */
    }
    .sliding_item{
        display: flex;
        margin-right: .8rem;
        margin-left: .8rem;
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
        margin-top: 1.6rem;
        align-items:center;
    }
    .sliding_item_img>p{
        font-size: 1.5rem;
        color: #393939;
        font-weight:500;
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