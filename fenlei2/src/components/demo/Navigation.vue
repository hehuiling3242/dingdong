<template>
    <div class="Navigation">
        <xitongtwo></xitongtwo>
        <div class="nav_SH">
            <div>
                <img src="../../assets/img/jiantou.png" @click="jump">
            </div>
            <div>
                <p>选择收货地址</p>
            </div>
            <div>
                <span>新增地址</span>
            </div>
        </div>
        <div class="nav_FL">
            <div @click="BlockTrue">
                <span>{{city}}</span>
                <img :class="{tran:tran}" src="../../assets/img/sanjiaodown.png" class="tranform">
            </div>
            <div>
                <div>
                    <img src="../../assets/img/sousuo.png">
                </div>
                <input type="text" placeholder="输入您的收货地址">
            </div>
        </div>
        <div class="nav_gif">
            <div :class="{nav_gifnone:nav_gifnone}">
                <img src="../../assets/img/icon11.gif" :class="{gifnone:gifnone}">
            </div>
        </div>
        <div class="nav_DW">
            <div class="nav_RE">
                <p>当前地址</p>
                <div>
                    <div>
                        <p>联强大厦</p>
                        <p>西湖区文三路253号</p>
                    </div>
                    <div>
                        <img src="../../assets/img/miaozhun.png" alt="">
                        <span>重新定位</span>
                    </div>
                </div>
            </div> 
            <div class="nav_BD" >
                <p>附近地址</p>
                <div v-for="(i,k) of 5" :key="k">
                    <p>钱江世纪城</p>
                    <p>江干区阿里巴巴66号</p>
                </div>
            </div>
        </div>
        <div class="nav_none" v-show="NoneTrue">
            <div>
                <div>
                    <p>已开通以下城市</p>
                </div>
                <div @click="CityT">
                    <div v-for="(c,y) of citys" :key="y">{{citys[y]}}</div>
                    <p class="nav_P">我们将开通更多城市,敬请期待</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    methods: {
        jump(){
            this.$router.push("/")
        },
        CityT(e){
            this.city=e.target.innerHTML;
            this.NoneTrue=false;
            this.tran=( this.tran==true?false:true);
        },
        BlockTrue(){
            this.NoneTrue=( this.NoneTrue==true?false:true)
            this.tran=( this.tran==true?false:true);
        }
    },
    data(){
        return {
            city:"杭州市",
            citys:["上海市","深圳市","杭州市","北京市","苏州市","宁波市","无锡市","常州市","绍兴市","嘉兴市"],
            NoneTrue:false,
            tran:false,
            nav_gifnone:false,
            gifnone:false
        }
    },
    mounted(){
        setTimeout(()=>{
            this.nav_gifnone=true
            this.gifnone=true
        },2000)
    }


}
</script>
<style  >
    *{
        margin: 0;padding: 0;
        box-sizing: border-box;
    }
    .Navigation>.nav_SH{
        display: flex;
        justify-content: space-between;
        margin: auto;
        width: 90%;
        line-height: 4.6rem;
    }
    .Navigation>.nav_SH>div>img{
        width: 1.6rem;
        height: 1.6rem;
        vertical-align: middle;
    }
    .Navigation>.nav_SH>div>span{
        color: #48a264;
        font-size: 1.6rem;
        font-weight: 500;
    }
    .Navigation>.nav_SH>div>p{
        font-size: 1.8rem;
        font-weight: 500;
    }
    .Navigation>.nav_SH>div:first-child{
        width:6.4rem;
    }
    .Navigation>.nav_FL{
        display: flex;
        width: 90%;
        margin: auto;
        margin-bottom: 1rem;
        align-items: center;
    }
    .Navigation>.nav_FL>div:first-child{
        display: flex;
        justify-content: space-between;
    }
    .Navigation>.nav_FL>div:last-child{
        display: flex;
        margin-left:1rem;
        height: 100%;
    }
    .Navigation>.nav_FL>div:first-child span{
        display: inline-block;
        width: 5.1rem;
        font-size: 1.4rem;
        color: #414141;
    }
    .Navigation>.nav_FL>div:last-child{
         width: 100%;
         display: flex;
         height: 3rem;
    }
    .Navigation>.nav_FL>div:last-child input{
        width: 100%;
        /* height: 3.8rem; */
        display: inline-block;
        background-color: #f6f5f5;
        height: 3rem;
        border:0.1rem solid #f8f7f7;
        outline: none;
        border-radius:0 1.6rem 1.6rem 0;
        padding-left: 1rem;
    }
    .Navigation>.nav_FL>div:last-child>div{
        width: 4rem;
        background-color: #f6f5f5;
        border: 0.1rem solid #f8f7f7;
        border-radius: 1.6rem 0 0 1.6rem;
        display: flex;
        align-items: center;
    }
    .Navigation>.nav_FL>div:last-child img{
        width: 1.6rem;
        height: 1.6rem;
        margin-left: 1rem ;
        vertical-align: text-top;
    }
    .Navigation>.nav_DW>.nav_RE{
        background-color: #f6f5f5;
    }
    .Navigation>.nav_DW>.nav_RE>p{
        font-size: 1.6rem;
        color:#666;
        padding-left: 1.5rem;
        padding: 0.5rem 1.5rem;
    }
    .Navigation>.nav_DW>.nav_RE>div{
        display: flex;
        justify-content: space-between;
        padding: 0 1.5rem;
        background-color: #fff;
    }
    .Navigation>.nav_DW>.nav_RE>div>div{
        padding: 1rem 0;
    }
    .Navigation>.nav_DW>.nav_RE>div>div>p:first-child{
        font-size: 1.6rem;
        font-weight: 500;
        margin-bottom: 0.5rem;
        letter-spacing: 0.1rem;
    }
    .Navigation>.nav_DW>.nav_RE>div>div>p:last-child{
        color: #666;
    }
    .Navigation>.nav_DW>.nav_RE>div>div:last-child{
        display: flex;
        align-items: center;
    }
    .Navigation>.nav_DW>.nav_RE>div>div>img{
         vertical-align: middle;
         width: 2.6rem;
         height: 2.6rem;
     }
    .Navigation>.nav_DW>.nav_RE>div>div>span{
        color:#48a264;
        margin-left: 0.5rem;
    }
    .Navigation .nav_BD{
        background-color: #f6f5f5;
    }
    .Navigation .nav_BD>p{
        font-size: 1.6rem;
        color:#666;
        padding-left: 1.5rem;
        padding: 0.5rem 1.5rem;
    }
    .Navigation .nav_BD>div{
        background-color: #fff;
        padding: 1rem 1.5rem;
        border-bottom: 0.1rem solid #eee;
    }
    .Navigation .nav_BD>div>p:first-child{
        font-size: 1.6rem;
        font-weight: 500;
        margin-bottom: 0.5rem;
        letter-spacing: 0.1rem;
    }
    .Navigation .nav_BD>div>p:last-child{
        color: #666;
    }

    .Navigation .nav_none{
        position: relative;
    }
    .Navigation .nav_none>div{
        position: fixed;
        top: 12.75rem;
        width: 100%;
    }
    .Navigation .nav_none>div>div:first-child{
        padding: 0.5rem 1.5rem;
        background-color: #f6f5f5; 
        width: 100%; 
    }
    .Navigation .nav_none>div>div>p{
        font-size: 1.4rem;
        color: #666;
    } 
    .Navigation .nav_none>div>div:last-child{
        background: #fff;
        padding: 0.5rem 1.5rem;
        width: 100%;
    }
     .Navigation .nav_none>div>div:last-child>div{
        border-bottom: 0.1rem solid #eee; 
        font-size: 1.6rem;
        width: 100%;
        padding: 1rem 0;
     }
     .tran{
         transform: rotate(180deg) !important;
     }
    .tranform{
        transform: rotate(0deg);
         transition: .5s;
    }
    .nav_P{
        text-align: center;
        margin-top: 1.5rem;
        color: #666;
    }
    .Navigation .nav_gif>div{
        background: #f6f5f5;
        text-align: center;
        padding: 1rem;
        height: 5.9rem;
    }
    .nav_gifnone{
        padding: 0 !important;
        height: 0rem !important;
        transition: .5s
    }
    .gifnone{
        width: 0rem;
        height: 0rem;
        transition: .5s
    }
</style>