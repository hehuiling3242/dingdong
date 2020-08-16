<template>
    <div class="content">
       <div class="left">
          <ul class="fenlei" @touchstar.prevent="touchstart()">
              <li class="link" :class="{ link1:changeGreen == index }" @click="greens(index)" v-for="(item,index) of fenlei" :key="index">{{item.label}}</li>
              <transition name="fade"> 
                 <div  class="xiaobiao" :style="[ {marginTop:'0rem'},{transition:'.3s'} ]" ref="a"></div>
              </transition>
          </ul>
       </div>       
    </div>
</template>
<script>
export default {
   name:'listGoods',
    data(){
      return {
         //存储商品详细的数据
         n:10086,
         list:5,
         // list1:17,
         //存储分类表中的内容
         fenlei:[
            {id:101,label:'蔬菜豆制品'},
            {id:102,label:'新鲜水果'},
            {id:103,label:'肉禽蛋品'},
            {id:104,label:'海鲜水产'},
            {id:105,label:'快手菜'},
            {id:106,label:'乳品烘焙'},
            {id:107,label:'冰淇淋'},
            {id:108,label:'营养早餐'},
            {id:109,label:'熟食卤味'},
            {id:110,label:'速食冻品'},
            {id:111,label:'粮油调味'},
            {id:112,label:'酒饮零食'},
            {id:113,label:'厨房用品'}
         ],
         //设置分类的样式
         changeGreen:0
         //左侧分类绿标的滑动        
      }
    },
    methods:{
        greens:function(index,flag){
         //   this.$parent.$refs.goods.say(index);
           this.list = this.$parent.$refs.goods.move;
           console.log(this.list[index]);
         //   console.log(this.$parent.$refs.goods.$refs.right);
           if(flag!=1){
              this.$parent.$refs.goods.$refs.right.scrollTop = parseInt(this.list[index]);
           }
           this.changeGreen = index;
           this.$refs.a.style.marginTop = index*5.5+"rem";
        },
      //   改动右侧绿条位置
    }
}
</script>
<style scoped>
    .content{ 
        display: flex; 
        flex-wrap: wrap; 
        width: 25%;   
    }
    .content>.left{
       position: relative;
       width: 100%;
       height: 100vh;
       background-color: #f7f7f7;
       font-size: 1.3rem;
      overflow-y: scroll;   
      overflow-x: hidden;     
      -webkit-overflow-scrolling: touch;        
       /* float: left;
       top: 0;
       left: 0; */
    }
    .left::-webkit-scrollbar-thumb{
       /* opacity: 0; */
       
       background-color: #000;
    }
    .content .link{
       display:block;
       padding: 0rem 1rem;
       background-color: #f7f7f7;
       color: #949494;
       /* font-size: 3rem; */
       height: 5.5rem;
       display: flex;
       align-items: center;
       /* display: flex; */
       /* align-self: center; */
    }
    .content .link1{
       display:block;
       padding: 0rem 1rem;
       background-color: #fff;
       /* border-left: 4px solid #33BE5B; */
       color: #000;
       display: flex;
       align-items: center;
    }
    /* 点击触发绿标的滑动 */
   .content .xiaobiao{
       background-color: #33BE5B;
       width: 0.4rem;
       height: 5.5rem;
       position: absolute;
       top: 0;
       left: 0;
   }
   /* .l{
      transform: translateY(5.5rem);
      transition-duration: .3s;
   } */
   
</style>