<template>
<div id="d1">
     <xitongtwo></xitongtwo>
    <div class="goods_1">
        <div class="goods_toubu">
            <div class="goods_2">
                <img src="../../assets/img/zuojiantou1.png" alt="" @click="my_goodsA">
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
     <div v-show="this.$store.state.shoplist.length>0">
         <div class="goods_qubu2">
              <div class="goods_qubu3">
               <span>2020-08-20 22:43:42</span>
               <span></span>
              </div>
              <div class="goods_qubu4" v-for="(products,index) of this.$store.state.shoplist" :key='index'>
               <div>
               <img :src="products.filePaths[0]" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>{{products.productName}}</p><span>¥{{products.price}}</span>
                </div>
               <p>单价:¥{{products.price}}/份</p>
               <p>数量:{{products.count}}份</p>
               </div>
              </div>
              <div class="goods_qubu6">
                   <span>共{{this.$store.getters.productNum}}份商品 实付¥{{this.$store.getters.productPrice.toFixed(2)}}</span>
               </div>
                        
               <div class="goods_qubu7">
                   <button @click="delete1()">删除订单</button><button>再次购买</button>
               </div>
         </div>
     </div>
           <div class="goods_shanchu01">
                <div class="goods_shanchu" v-show="shanchuY">
                    <div><p>确认删除该订单吗?</p></div>
                    <div>
                    <span @click="delete22()">取消</span><span @click="delete33()">确定</span>
                    </div>
                </div>
          </div>    
         <div class="goods_qubu8">
            <span @click="show($event)">查看三个月以前的订单<img src="../../assets/img/xia_jiantou.png" alt=""></span>
         </div>
      <div v-show="isShow"  class=".goods_qubu2A" >
         <div v-show="this.$store.state.shoplist.length>0">
              <div class="goods_qubu4" v-for="(products,index) of this.$store.state.shoplist" :key='index'>
               <div>
               <img :src="products.filePaths[0]" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>{{products.productName}}</p><span>¥{{products.price}}</span>
                </div>
               <p>单价:¥{{products.price}}/份</p>
               <p>数量:{{products.count}}份</p>
               </div>
              </div>
               <div class="goods_qubu7">
                   <button>删除订单</button><button>再次购买</button>
               </div>
         </div>
     </div>   
 </div>
    <div v-show="a==2" class="goods_322">
          <div v-show="e">
             <div class="goods_qubu2" v-show="this.$store.state.shoplist.length>0">
              <div class="goods_qubu3">
               <span>2020-08-20 22:43:42</span>
               <span></span>
              </div>
              <div class="goods_qubu4" v-for="(products,index) of this.$store.state.shoplist" :key='index'>
               <div>
               <img :src="products.filePaths[0]" alt="">
               </div>
               <div class="goods_qubu5">
                <div>
               <p>{{products.productName}}</p><span>¥{{products.price}}</span>
                </div>
               <p>单价:¥{{products.price}}/份</p>
               <p>数量:{{products.count}}份</p>
               </div>
              </div>
               <div class="goods_qubu6">
                   <span>共{{this.$store.getters.productNum}}份商品 实付￥{{this.$store.getters.productPrice.toFixed(2)}}</span>
               </div>
               <div class="goods_qubu7">
                   <button>删除订单</button><button>立即支付</button>
               </div>
         </div>
          </div>
    </div>
    <div v-show="a==3" class="goods_333">
        <div>
            <div class="goods_qubu2">
              <div class="goods_qubu3">
               <span>2020-08-20 22:43:42</span>
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
            e:true,
            shanchuY:false
        }
    },
    methods:{
        change(ab){
            this.a=ab;
        },
        show(e){
            if(this.isShow==false){
            this.isShow=true;
            e.currentTarget.children[0].src=require("../../assets/img/shang_jiantou.png");
            }else{
            this.isShow=false;
            e.currentTarget.children[0].src=require("../../assets/img/xia_jiantou.png");
            }
        },
        hide(){
            this.e=false;
        },
        my_goodsA(){
            this.$router.push("/Mine")
        },
        delete1(){
            this.shanchuY=true;
        },
        delete22(){
            this.shanchuY=false;
        },
        delete33(){
            // 点击确定，删除所有商品的框框按钮
            this.$store.commit('remove_car_count');
            this.shanchuY=false;
            this.goods_wudingdan=false;
        }
    }
})
</script>

<style  scoped>
.goods_1{
    background-color: #ebebeb;
    width: 100%;
    height: 100%;
}
.goods_toubu{
    width: 100%;
    height: 4rem;
    margin-top: 0;
}
.goods_2{
    width: 100%;
    height: 4rem;
    display: flex;
    align-items: center; 
    justify-content: flex-start;
    background-color: #fff;
    border: 0;
}
.goods_2 img{
    width: 2rem;
    height: 2rem;
    margin-left: 1rem;
}

.goods_2 span{
    display: inline-block;
    height: 3.8rem;
    font-size: 2rem;
    margin-left: 2rem;
   line-height: 4rem;
}
.goods_3{
    width: 100%;
    height: 4rem;
    background-color: #fff;
    border: 0;
    display: flex;
    
}
.goods_3>div{
    width: 25%;
    height: 4rem;
    align-items: center;
    text-align: center;
    justify-content: space-around;
    line-height: 4rem;
    font-size: 1.5rem;
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
    width: 100%;
    height: 100%;
    overflow: hidden;
    background-color: #ebebeb;
    margin-top: 5rem;
}
.goods_qubu1{
    width: 100%;
    font-size: 1.3rem;
    background-color: #FFF;
    line-height: 5rem;
    padding-left: 1rem;
    display: flex;
    justify-content: space-between;
    align-items: center;

}
.goods_qubu1>button{
    width: 7rem;
    height: 3rem;
    margin-right: 2rem;
    color: #fff;
    background-color: darkcyan;
    border-radius: 8rem;
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
    display: flex;
    justify-content:space-between;

}
.goods_qubu3>span:nth-child(1){
    margin-left: 1rem;
}
.goods_qubu3>span:nth-child(2){
    margin-right: 2rem;
}
.goods_qubu4{
    width: 100%;
    background-color: #ebebeb;
    display: flex;
    align-items: center;
    overflow: hidden;
    margin-bottom: 0.1rem;
}

.goods_qubu4>div:nth-child(1){
    width: 10rem;
    height: 10rem;
    display: flex;
    align-items: center;
    margin-left: 1rem;
    background-color: #ebebeb;
}
.goods_qubu4 img{
    width: 8rem;
    height: 8rem;
    border-radius: 1rem;

}
.goods_qubu5{
    width: 100%;
    margin-left: 2rem;
    line-height: 2rem;
    color: #494949;
    align-items: center;
}
.goods_qubu5>div:nth-child(1){
    height: 3rem;
    line-height: 3rem;
    color: #000;
    font-size: 1.2rem;
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
    display: flex;
    justify-content: flex-end;
    align-items: center;
    border-bottom:0.1rem solid #dddbdb;
    background-color: #FFF;
    
}
.goods_qubu6>span{
    margin-right: 2rem;
}
.goods_qubu7{
    width: 100%;
    height: 4rem;
    display: flex;
    justify-content: flex-end;
    align-items: center;
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
    width: 1.5rem;
    height: 1.5rem;
    top: 50%;
    vertical-align: middle;
}
.goods_shanchu01{
    display: flex;
    justify-content: center;
    align-items: center;
}
.goods_shanchu{
    width: 15rem;
    height: 5rem;
    margin-top:-10rem;
    font-size: 1.5rem;
    background-color: #dddbdb ;
    border-radius: 0.5rem;
}
.goods_shanchu>div:nth-child(1){
    display: flex; 
    align-content: center;
    justify-content: center;
}
.goods_shanchu>div{
    padding-top: 0.6rem;
    color: #000;
    display: flex; 
     align-content: center;
    justify-content: space-around;
}

</style>