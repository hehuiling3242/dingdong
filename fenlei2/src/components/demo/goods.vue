<template>
    <div class="content">
       <div class="right" ref="right">       
           <div v-for="(item,index) of fenlei" :key="index">
               <div class="shangp2">
                  <div class="tuijian1" >
                     <div>
                        <p>{{item.label}}</p>
                        <div>
                           <p>销量</p>
                           <p>价格</p>
                        </div>
                     </div>
                     
                     <div class="img">
                         <img src="../../assets/img/shangjiantou.png">
                         <img src="../../assets/img/xiajiantou.png">
                     </div>
                  </div>
                  <div class="shangp" v-for="(item,index) of list" :key="index">
                     <div class="shangp1">
                        <img src="../../assets/img/egg.png">
                        <div class="details">
                           <p class="title">上海青 约300g</p>
                           <p class="jieshao">上海本地菜 小时候妈妈的味道</p>
                           <p class="huod">专区满21元赠豆腐</p>
                           <div class="pri">
                              <p class="price">
                                 <em>¥</em>
                                 <span><b>2.99</b></span>
                              </p>
                              <div class="gouwuc">
                                 <img src="../../assets/img/gouwu.png">
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
         </div>
       </div>
    </div>
</template>
<script>
export default {
   name:'listGoods',
    data(){
      return {
         //存储商品详细的数据
         list:5,
         n:-1,
         // list1:17,
         //存储分类表中的内容
         fenlei:[{label:'推荐'},{label:'新品'},{label:'平价好菜'},{label:'供港蔬菜'},{label:'茄果瓜果'},{label:'根茎类'},{label:'豆腐豆浆'},{label:'叶菜类'},{label:'香辛葱蒜'},{label:'球茎类'},{label:'菌菇类'},{label:'豆类'},{label:'有机蔬菜'},{label:'豆芽海带'},{label:'净菜'},{label:'豆干豆皮'},{label:'其他豆制品'}],
         //存储滚动位置的
         move:[] 
      }
    },
    methods:{
    },
    watch:{
      
    },
    mounted(){
      //   this.mt=this.$refs.right.offsetHeight;
      //   console.log(this.n);
      this.$refs.right.onscroll=()=>{
         this.sctop=this.$refs.right.scrollTop;
         for(var i=0;i<this.move.length;i++){
            if(this.sctop>=this.move[i]&&this.sctop<this.move[i+1]){
               this.$parent.$refs.listgoods.greens(i,1);
            }
         }
      }
        this.move[0]=0;
        for(var i=1;i<17;i++){
           this.move.push(this.move[i-1]+744) ;
        }
    }
}
</script>
<style scoped>
    .content{ 
        display: flex; 
        flex-wrap: wrap; 
        width: 75%;  
    }
    .content .right{
       width: 100%;
       /* background-color: #f4f4f4; */
       height: 100vh;
       color: #848484;
       overflow-y: auto;   
       overflow-x: hidden;     
       -webkit-overflow-scrolling: touch;        
       /* float: left;
       top: 0;
       left: 10.35rem; */
    }

    /* 右侧上方推荐栏设置 */
    .content .tuijian{
       width:68%;
       height: 4.4rem;
       display:flex;
       background-color: #fff;
       flex-direction: row;
       align-items: center;
       flex-wrap: nowrap;
       justify-content: space-between;
       line-height: 4.4rem;
       text-align: center;
       margin: 0 0;
       border-bottom: 1px solid #e1e1e1;
       border-collapse: collapse;
       font-size: 1.3rem;
       position:fixed;
       top: 0;
       left: 28.5%;
       z-index: 9999;
    }
    .content .tuijian1{
       width:90%;
       height: 4.4rem;
       display:flex;
       background-color: #fff;
       flex-direction: row;
       align-items: center;
       flex-wrap: nowrap;
       justify-content: space-between;

       /* line-height: 4.4rem; */
       /* text-align: center; */
       margin: 0 auto;
       border-bottom: 1px solid #e1e1e1;
       border-collapse: collapse;
       font-size: 1.3rem;
       /* flex-wrap:nowrap */
       /* position:fixed;
       top: 0;
       left: 28%;
       z-index: 9999; */
    }
      .tuijian1>div:first-child{
         display: flex;
         width: 90%;
         justify-content: space-between;
      }
      .tuijian1>div>div{
         display: flex;
      }
      .tuijian1>div>div>p:first-child{
         margin-right: 1rem;
      }
    /* .content .tuijian1 P:nth-child(2){
       margin: 0 0 0 15rem;
    }
    .content .tuijian P:nth-child(2){
       margin: 0 0 0 15rem;
    } */

    /* 推荐栏最右侧图标设置 */
    .img{
       display: flex;
       flex-direction: column;
       justify-content: center;
    }
   

    /* 商品总览 */
    .shangp{
       width:95%;
       display: flex;
       justify-content: flex-end;
    }
    .content .shangp1{
       width: 95%;
       height: 14rem;
       display: flex;
       /* border-top:1px solid #e1e1e1; */
       border-bottom:1px solid #e1e1e1;
       justify-content: flex-end;
       /* flex-wrap: wrap */
       /* align-items:flex-end; */
    }
    .shangp1>img{
       width: 10rem;
       height: 10rem;
    }
    /* .shangp2{
       margin-top: 4.4rem;
    } */
   .shangp2{
      display: flex;
      flex-direction: column;
      /* justify-content: center; */
      /* align-self: center; */
      justify-content: center;
      /* margin: 0 auto; */
   }
    /* 商品详情 */
    .details{ position: relative; }
    .shangp1>.details{
       display: flex;
       flex-direction: column;
       align-items: flex-start;
       align-content:space-around
    }
    .details>.title{
       font-size: 1.6rem;
       color:#292929;
       margin:1rem 0 0 0;
    }
    .details>.jieshao{
       font-size: 1.4rem;
       color:#a0a0a0;
       padding:0.5rem 0 0 0;
       /* align-self: flex-end;
       flex-wrap: wrap; */
    }
    .details>.huod{
       font-size: 1.2rem;
       background-color: #FEF3F7;
       color: #f18c95;
       padding:.5rem .5rem;
       border-radius: 0.2rem;
       margin-top: 1rem;
    }
    /* .details .price{
       padding: 1rem 0 0 0;
    } */
    .details .price>em{
       display: inline-block;
       color:#fa657e;
       font-style: normal;
       font-size: 1rem;
    }
    .details .price>span{
       display: inline-block;
       color:#fa657e;
       font-size: 1.9rem;
    }

    /* 购物车 */
    .pri{
       display: flex;
       align-items: center;
       width: 100%;
       justify-content: space-between;
       /* justify-content: center; */
       /* flex-direction: ; */
    }
    .details .gouwuc{
       /* position: absolute; */
       width: 2.8rem;
       height: 2.8rem;
       background:linear-gradient(#4ad278,#33b05d);
       border-radius: 50%;
       /* right: 0;
       top: 9.5rem; */
       display: flex;
       justify-content: center;
       align-items: center;
    }
    .details .gouwuc img{
       width: 1.6rem;
       height: 1.6rem;
       /* padding: 0.5rem 0.2rem 0 0; */
    }
</style>