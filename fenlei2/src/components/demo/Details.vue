<template>
  <div class="details">
    <xitongtwo></xitongtwo>
    <img src="../../assets/img/jiantou.png">
    <div class="none" style="display:none">
      <img src="../../assets/img/jiantou.png">
      <p style="display:inline" class="nonecen">
        <span>商品</span>
        <span>评价</span>
        <span>详情</span>
        <span>推荐</span>
      </p>
      <img src="../../assets/img/zhuan.png" alt="">
    </div>
    <div class="lunbo">
      <img src="../../assets/img/main1021.jpg" alt="">
    </div>
    <p class="price">
      <span>¥98.80</span>
      <del>¥118.90</del>  
    </p>
    <p class="title">山姆 美国 进口 车厘子 900g</p>
    <p class="deta">红宝石级"美人果"</p>
    <hr style="border:0.05rem solid #eee"/>
    <div class="time">
      <img src="../../assets/img/shijian.png" alt="">
      <span>最快明天07:00-07:30送达</span>
    </div>
    <img src="../../assets/img/hf.jpg" alt="">
    <hr style="border:0.05rem solid #eee;margin-bottom:2rem"/>
    <!-- 推荐做法 -->
    <div class="recom">
      <p class="recom_top">
        <span>推荐做法</span>
        <img src="../../assets/img/gengduo.png" alt="">  
      </p>
    </div>
    <homenew></homenew>
    <hr style="border:0.05rem solid #eee;margin-bottom:2rem"/>
    <!-- 评价 -->
    <div class="assess">
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
    <p class="tui">为你推荐</p>
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
    <div class="detabom">
      <img src="../../assets/img/datails1021-1.jpg" alt="">
      <img src="../../assets/img/datails1022-2.jpg" alt="">
    </div>

    <div style="height:6rem"></div>
    <div class="detailadd">
      <img src="./../../assets/cart.png" alt="">
      <button>加入购物车</button>
    </div>
  </div>
</template>

<script>
import homenew from '../demo/HomeNew.vue'
export default {
    data(){
        return{}
    },
    methods:{
        
    },
    components:{
        homenew,
    }
}
</script>

<style scope>
  .details{
    padding: 0rem 2rem;
  }
  .details>img{
    width: 2rem;
  }
  .lunbo>img{
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
  /* .sliding_item_img>.sliding_item_btn{
    display: none;
  }
  .sliding_item>.sliding_item_img>p{
    text-align: left;
  }
  .sliding_item_img[data-v-56a8acf6]{
    height: 15rem;
  }  */

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