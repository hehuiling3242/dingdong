<template>
<div id="d1">
     <xitongtwo></xitongtwo>
    <div class="goods_1">
        <div class="goods_toubu">
            <div class="goods_2">
                <img src="../../assets/img/zuojiantou1.png" alt="">
                <span>我的订单</span>
            </div>
            <div class="goods_3">

                <div @click="change(1)" :class="a==1?'goods_31':''" >全部</div>

                <div @click="change(2)" :class="a==2?'goods_31':''" >待付款</div>

                <div @click="change(3)" :class="a==3?'goods_31':''" >待收货</div>

                <div @click="change(4)" :class="a==4?'goods_31':''" >待评价</div>

            </div>
       </div>
    <div v-show="a==1" class="goods_311">
            <div class="goods_qubu1">
                <p>最近常买的商品</p>
                <button>常购清单</button>
            </div>
     <div>
         <div class="goods_qubu2">
              <div class="goods_qubu3">
               <span>2020-08-03 22:43:42</span>
               <span>已取消</span>
              </div>
              <div class="goods_qubu4">
               <div>
               <img src="../../assets/img/001f075ad3feeda8012138670b58f0.jpg" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>上海青 约300g</p><span>￥29.99</span>
                </div>
               <p>单价:￥29.99/份</p>
               <p>数量:1份</p>
               </div>
              </div>
               <div class="goods_qubu6">
                   <span>共1份商品 实付￥0.00</span>
               </div>
               <div class="goods_qubu7">
                   <button>删除订单</button><button>再次购买</button>
               </div>
         </div>
     </div>
            
         <div class="goods_qubu8">
            <span @click="show">查看三个月以前的订单<img src="../../assets/img/xiajiantou.png" alt=""></span>
         </div>
      <div v-show="isShow==true">
         <div>
             <div class="goods_qubu2">
                    <div class="goods_qubu3">
                    <span>2020-08-03 22:43:42</span>
                    <span>已取消</span>
                    </div>
                    <div class="goods_qubu4">
                    <div>
                    <img src="../../assets/img/001f075ad3feeda8012138670b58f0.jpg" alt="">
                    </div>
                    <div class="goods_qubu5">
                        <div>
                    <p>上海青 约300g</p><span>￥29.99</span>
                        </div>
                    <p>单价:￥29.99/份</p>
                    <p>数量:1份</p>
                    </div>
                    </div>
                    <div class="goods_qubu7">
                        <button>删除订单</button><button>再次购买</button>
                    </div>
             </div>
          </div>

        </div>   
    </div>
    <div v-show="a==2" class="goods_322">
          <div v-show="e">
             <div class="goods_qubu2">
             <div class="goods_qubu3">
               <span>2020-08-03 22:43:42</span>
               <span>待付款</span>
             </div>
              <div class="goods_qubu4">
               <div>
               <img src="../../assets/img/001f075ad3feeda8012138670b58f0.jpg" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>上海青 约300g</p><span>￥29.99</span>
                </div>
               <p>单价:￥29.99/份</p>
               <p>数量:1份</p>
               </div>
              </div>
               <div class="goods_qubu6">
                   <span>共1份商品 实付￥0.00</span>
               </div>
               <div class="goods_qubu7">
                   <button @click="hide">删除订单</button><button>立即支付</button>
               </div>
             </div>
          </div>
    </div>
    <div v-show="a==3" class="goods_333">
        <div>
            <div class="goods_qubu2">
              <div class="goods_qubu3">
               <span>2020-08-03 22:43:42</span>
               <span>等待收货</span>
              </div>
              <div class="goods_qubu4">
               <div>
               <img src="../../assets/img/001f075ad3feeda8012138670b58f0.jpg" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>上海青 约300g</p><span>￥29.99</span>
                </div>
               <p>单价:￥29.99/份</p>
               <p>数量:1份</p>
               </div>
              </div>
               <div class="goods_qubu6">
                   <span>共1份商品 实付￥0.00</span>
               </div>
               <div class="goods_qubu7">
                <button>待收货</button><button>再次购买</button>
               </div>
            </div>
        </div>
            
    </div>
        <div v-show="a==4" class="goods_344">
            <div>
             <div class="goods_qubu2">
             <div class="goods_qubu3">
               <span>2020-08-03 22:43:42</span>
               <span><img src="../../assets/img/wancheng.png" alt=""></span>
             </div>
              <div class="goods_qubu4">
               <div>
               <img src="../../assets/img/001f075ad3feeda8012138670b58f0.jpg" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>上海青 约300g</p><span>￥29.99</span>
                </div>
               <p>单价:￥29.99/份</p>
               <p>数量:1份</p>
               </div>
              </div>
               <div class="goods_qubu6">
                   <span>共1份商品 实付￥0.00</span>
               </div>
               <div class="goods_qubu7">
                   <button>删除订单</button><button>待评价</button>
               </div>
             </div>
         </div>
    </div>
   </div>
    </div>
</template>
<script>
export default({    
    data(){
        return{
            a:1,
            b:"goods_31",
            isShow:false,
            e:true
        }
    },
    methods:{
        change(ab){
            this.a=ab;
        },
        show(){
            this.isShow=true;
            
        },
        hide(){
            this.e=false;
        }
    }
})
</script>



<style  scoped>
.goods_1{
    /* background-color: #ebebeb; */
    width: 100%;
    height: 100%;
    border: 0;
    display: flex;
    flex-direction: column;
}
.goods_toubu{
    /* position: fixed; */
    /* z-index: 999; */
    width: 100%;
    /* height: 4rem; */
}
.goods_2{
    width: 100%;
    height: 4rem;
    background-color: #fff;
    border: 0;
    /* margin-top: 2rem; */
    display: flex;
    align-items: center;
    /* justify-content: space-between; */
}
.goods_2 img{
    width: 1.8rem;
    height: 1.8rem;
    margin-left: 1rem;
    vertical-align: middle;
}

.goods_2 span{
    display: inline-block;
    /* height: 3.8rem; */
    font-size: 1.8rem;
    color: #000;
    margin-left: 2.6rem;
    line-height: 4rem;
    vertical-align: middle;
}
.goods_3{
    width: 100%;
    height: 4rem;
    background-color: #fff;
    border: 0;
    display: flex;
    justify-content: space-between;
    margin-top: 1rem;

}
.goods_3>div{
    width: 25%;
    /* height: 4rem; */
    /* text-align: center; */
    /* margin-left: 10%; */
    /* margin-top: 2.5rem; */
    font-size: 1.5rem;
    display: flex;
    align-items: center;
    justify-content: center;
    /* position: relative; */
}
.goods_31{
    color: limegreen;
    border-bottom: 0.3rem solid mediumseagreen;
    position: relative;
}
.goods_32{
    color: limegreen;
    border-bottom: 0.3rem solid mediumseagreen;
}
.goods_33{
    color: limegreen;
    border-bottom: 0.3rem solid mediumseagreen;
}
.goods_34{
    color: limegreen;
    border-bottom: 0.3rem solid mediumseagreen;
}
.goods_311,.goods_322,.goods_333,.goods_344{
    /* position: absolute;
    width: 100%;
    height: 100%; */
    overflow: hidden;
    /* margin-top: 1rem; */
    float: flex;
    border: 0.2rem solid #ebebeb;
    background-color: #ebebeb;
    /* margin-top: 11rem; */
}
.goods_qubu1{
    width: 100%;
    height: 5rem;
    background-color: #FFF;
    line-height: 5rem;
    padding-left: 1rem;
    display: flex;
}
.goods_qubu1>button{
    display: inline-block;
    width: 7rem;
    height: 3rem;
    text-align: right;
    margin-right: 1rem;
    position: absolute;
    justify-content:flex-end;
    z-index: 999;
    right: 0;
    margin-top: 1rem;
    color: #fff;
    background-color: darkcyan;
    border-radius: 8rem;
    text-align: center;
    border: 0;
}
.goods_qubu2{
    width: 100%;
    height: 100%;
    background-color: #fff;
    margin-top: 1rem;
}
.goods_qubu2>div:nth-child(1){
    width: 100%;
    height: 4rem;
    background-color: #fff;
    font-size: 1.5rem;
    color: #696969;
    line-height: 4rem;
    position: relative;

}
.goods_qubu3{
    width: 100%;
    margin: 0px 1rem;
    display: flex;
    justify-content: space-between;
    box-sizing: border-box;
}
/* .goods_qubu3>span:nth-child(1){
    /* margin-left: 1rem; */
    /* position: absolute; */
    /* left: 0; */
/* } */
/* .goods_qubu3>span:nth-child(2){ */
    /* position: absolute; */
    /* right: 0; */
    /* margin-right: 1rem; */
/* } */ 
.goods_qubu4{
    width: 96%;
    height: 10rem;
    background-color: #ebebeb;
    border-radius: 0.8rem;
    margin-left:1.5%; 
    /* margin-right:0.2rem; */
    display: flex;
    overflow: hidden;
    
}
.goods_qubu4>div:nth-child(1){
    width: 10rem;
    height: 10rem;
    display: flex;
    display: inline-block;
    position: relative;
    background-color: #ebebeb;
}
.goods_qubu4 img{
    width: 8rem;
    height: 8rem;
    margin-top: 1rem;
    margin-left:1rem ;
    border-radius: 1rem;

}
.goods_qubu5{
    width: 100%;
    height: 9rem;
    margin-left: 2rem;
    line-height: 2rem;
    color: #494949;
    padding-top: 1rem;
    /* background-color: #ebebeb; */
}
.goods_qubu5>div:nth-child(1){
    height: 3rem;
    line-height: 3rem;
    color: #000;
    font-size: 1.5rem;
}
.goods_qubu5>div>p:nth-child(1){
    display: inline-block;
    height: 4rem;
    width: 10rem;
}
.goods_qubu5>div>span{
    float: right;
    margin-right: 2rem;
}
.goods_qubu6{
    width: 100%;
    height: 4rem;
    line-height: 4rem;
    text-align: right;
    border-bottom:0.1rem solid #dddbdb;
    background-color: #FFF;
    
}
.goods_qubu6>span{
    margin-right: 2rem;
}
.goods_qubu7{
    width: 100%;
    height: 4rem;
    /* border: 0.1rem solid red; */
    line-height: 4rem;
    text-align: right;
    margin-right: 2rem;
    background-color: #FFF;
}
.goods_qubu7>button{
    width: 6rem;
    height: 3rem;
    border-radius: 5rem;
    background-color: #ebebeb;
    border: 0;
    margin-right: 1rem;
}
.goods_qubu7>button:nth-child(1){
    margin-right: 1rem;

}
.goods_qubu8{
    width: 100%;
    height: 3rem;
    text-align: center;
}
.goods_qubu8>span{
    font-size: 1.4rem;
    color: #000;
    line-height: 3rem;

}
.goods_qubu8 img{
    width: 2rem;
    height: 2rem;
    top: 50%;
    vertical-align: middle;
}
#d1{
    width: 100%;
}
</style>