<template>
  <div class="details">
    <xitongtwo></xitongtwo>
    <div id="toTop" v-show="showAbs">
      <div class="none">
      <img src="../../assets/img/jiantou.png">
      <p style="display:inline-block" class="nonecen">
        <a href="#lL">商品</a>
        <a href="#2L">评价</a>
        <a href="#3L">详情</a>
        <a href="#4L">推荐</a>
      </p>
      <img src="../../assets/img/zhuan.png" alt="">
      </div>
    </div>
    <img src="../../assets/img/jiantou.png">
    <!-- 轮播 -->
    <lunbo  class="lunbo"></lunbo>
    <p class="price">
      <span>¥{{price}}</span>
      <del>¥{{original_cost}}</del>  
    </p>
    <p class="title">{{title}}</p>
    <p class="deta">{{describe}}</p>
    <hr style="border:0.05rem solid #eee"/>
    <div class="time">
      <img src="../../assets/img/shijian.png" alt="">
      <span>最快明天07:00-07:30送达</span>
    </div>
    <img src="../../assets/img/hf.jpg" alt="">
    <hr style="border:0.05rem solid #eee;margin-bottom:2rem"/>
    <!-- 推荐做法 -->
    <div class="recom">
      <p  class="recom_top">
        <span class="tui">推荐做法</span>
        <img src="../../assets/img/gengduo.png" alt="">
      </p>
      <div class="homenew_btn">
        <div class="sliding_box">
          <div class="sliding_item" v-for="(item,index) in content" :key="index">
            <div class="sliding_item_img">
              <img src="../../assets/img/yt.jpg" alt="">
                <p>{{title}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <hr style="border:0.05rem solid #eee;margin-bottom:2rem"/>
    <!-- 评价 -->
    <div class="assess" id="2L">
      <p>评价</p>
      <div class="asscen">
        <img src="../../assets/img/people.png" alt="">
        <div class="assright">
          <p><span>啊哈**哈</span><span class="data">2020-07-30</span></p>
          <p class="fivex">
            <img src="../../assets/img/fivex.png" alt="">
            <img src="../../assets/img/fivex.png" alt="">
            <img src="../../assets/img/fivex.png" alt="">
            <img src="../../assets/img/fivex.png" alt="">
            <img src="../../assets/img/fivex.png" alt="">
            <span>很满意</span>
          </p>
          <p>真方便，不在父母身边，也能为他们买东西，省得他们老人大热天出去买这么沉的东西</p>
          <p>查看更多(6622)</p>
        </div>
      </div>
    </div>
    <!-- 为你推荐 -->
    <hr style="border:0.05rem solid #eee;margin:2rem 0rem"/>
    <p class="tui"  id="3L">为你推荐</p>
    <homenew></homenew>
    <!-- 规格 -->
    <hr style="border:0.05rem solid #eee;margin:2rem 0rem"/>
    <p class="tui">规格</p>
    <hr style="border:0.05rem solid #eee;margin:1.6rem 0rem"/>
    <pre>净含量      900g</pre>
    <hr style="border:0.05rem solid #eee;margin:1.6rem 0rem"/>
    <pre>保质期      18个月</pre>
    <hr style="border:0.05rem solid #eee;margin:1.6rem 0rem"/>
    <pre>保存条件    常温</pre>
    <hr style="border:0.05rem solid #eee;margin:1.6rem 0rem"/>
    <div class="detabom" id="4L">
      <img src="../../assets/img/datails1021-1.jpg" alt="">
      <img src="../../assets/img/datails1022-2.jpg" alt="">
    </div>

    <div style="height:6rem"></div>
    <div class="detailadd">
      <img src="./../../assets/cart.png" alt="">
      <span v-show="btnadd">{{n}}</span>
      <button @click="add" >加入购物车</button>
    </div>
  </div>
</template>

<script>
import homenew from '../demo/HomeNew.vue'
import lunbo from '../demo/lunbo.vue'
export default {
    data(){
        return{
          price:2.55,
          original_cost:5.55,
          title:"杭白菜 300g",
          describe:"又称毛毛菜，煮汤味更美哦",
          content:13,
          showAbs: false,
          n:0,
          btnadd:false,
          // 数量
          content: 13,
          // 价格
          price: 19.90,
          // 标题
          title: "樱桃果酱樱桃果酱",
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
      scrollTops(){
        var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
        // console.log(scrollTop);
        var toTop=document.getElementById("toTop");
          if(scrollTop>=500){
            this.showAbs = true;
          }else{
            this.showAbs = false;
          }
        },
        add(){
          this.btnadd=true,
          this.n++;
        },
        
    },
    mounted(){
      this.load();
      window.addEventListener('scroll',this.scrollTops);
    },
    components:{
        homenew,
        lunbo,
    },

}
</script>

<style scope>
  /* body, html {
    scroll-behavior: smooth;
  } */
  .details{
    padding: 0rem 2rem;
  }
  #toTop{
    width: 100%;
    position: fixed;
    top: 0;
    background-color: #fff;
    box-sizing: border-box;
  }
  .none{
    width: 90%;
    display: flex;
    justify-content: space-between;
    color: #333;
    font-size: 1.8rem;
    font-weight: 550;
    padding: 2rem 0rem;
  }
  .none>.nonecen{
    width: 65%;
    display: flex;
  }
  .nonecen>a{
    margin-left: 2rem;
    color: #333;
  }
  .none>img{
    height: 2.5rem;
    vertical-align: middle;
  }
  .details>img{
    width: 2.5rem;
  }
  .lunbo{
    width: 100%;
    margin: 1rem 0rem;
  }
  .price>span{
    color: red;
    font-size: 3rem;
    font-weight: 800;
  }
  .price>del{
    margin-left:1rem;
    font-size: 1.5rem;
    color: #888;
  }
  .title{
    color: #333;
    font-size: 2.3rem;
    font-weight: 550;
    margin-top: 1.5rem;
    margin-bottom: 1.3rem;
  }
  .deta{
    color: #888;
    font-size: 1.6rem;
    margin-bottom: 2rem;
  }
  .time{
    margin-top: 2rem;
  }
  .time>img{
    width: 2.2rem;
    vertical-align: middle;
    margin-right: 0.5rem;
  }
  .time>span{
    color: #333;
    font-size: 1.3rem;
  }
  .time+img{
    width: 100%;
    margin: 1.8rem 0rem;
  }
  .recom_top{
    display: flex;
    justify-content: space-between;
  }
  .tui , .assess>p , .recom_top>span{
    color: #333;
    font-size: 2.15rem;
    font-weight: 600;
    height: 4rem;
    line-height: 4rem;
  }
  .recom_top>img{
    height: 4rem;
    vertical-align: middle;
  }

  .homenew>.homenew_top{
    display: none;
  }
  .recom .sliding_box{
    display: flex;
    overflow-y: hidden;
    overflow-x: scroll;
    background-color: #fff;
    /* border-radius: .6rem; */
    margin-bottom: .8rem;
    /* overflow-y: scroll; */
    /* overflow:hidden */
  }
  .recom .sliding_item{
    display: flex;
    margin-right: .8rem;
    margin-left: .8rem;
    /* background-color: #CDCDCD; */
    border-radius: .6rem;
  }
  .recom .sliding_item_img {
    width: 11.5rem;
    height: 15rem;
    border-radius: .6rem;
    display: flex;
    flex-direction: column;
    align-items:center;
  }
  .recom .sliding_item_img>img{
    margin: 1.5rem 0px 1.5rem;
    width: 12rem;
    border-radius: 1rem;
    height: 9rem;
  }
  .recom .sliding_item_img>p{
    text-align: left;
  }

  .asscen{
    display: flex;
    justify-content: space-between;
    font-size: 1.4rem;
  }
  .asscen>img{
    height: 3.3rem;
    margin-right: 1.5rem;
  }
  .assright>p:nth-child(1){
    display: flex;
    justify-content: space-between;
  }
  .assright>.fivex{
    margin: 0.8rem 0rem;
  }
  .assright>p:nth-child(4){
    margin-top: 1.2rem;
    width: 13rem;
    height: 3rem;
    line-height: 3rem;
    text-align: center;
    border: 0.1rem solid #888;
    border-radius: 5rem;
    margin-left: 6rem;
  }
  pre{
    color: #333;
    font-size: 1.7rem;
    margin-top: 1rem;
    font-weight: 550;
  }
  .detabom img{
    width: 100%;
  }
  .detabom img:nth-child(2){
    margin-top:-0.5rem ;
  }


  
  .detailadd{
    width: 100%;
    height: 8%;
    background-color: #f8f8f8;
    position:fixed;
    left: 0px; 
    bottom:0px;
    display: flex;
    flex-wrap: nowrap;
    justify-content:space-between;
  }
  .detailadd img{
    height: 3.5rem;
    padding: 1rem 1rem;
    vertical-align: middle;
    position: relative;
  }
  .detailadd>span{
    display: inline-block;
    background-color: red;
    width: 2.2rem;height: 2.2rem;
    line-height: 2rem;
    color: #fff;
    font-size: 1.5rem;
    text-align: center;
    border-radius: 50%;
    position: absolute;
    left: 4.2rem;
    top: 0.5rem;
  }
  .detailadd button{
    border-radius: 5rem;
    width: 16rem;
    height: 5rem;
    border: 0;outline: 0;
    background-color: green;
    color: #fff;
    font-size: 1.8rem;
    margin: 0.5rem 1rem;
  }
</style>