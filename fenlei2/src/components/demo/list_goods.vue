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
         fenlei:[{label:'推荐'},{label:'新品'},{label:'平价好菜'},{label:'供港蔬菜'},{label:'茄果瓜果'},{label:'根茎类'},{label:'豆腐豆浆'},{label:'叶菜类'},{label:'香辛葱蒜'},{label:'球茎类'},{label:'菌菇类'},{label:'豆类'},{label:'有机蔬菜'},{label:'豆芽海带'},{label:'净菜'},{label:'豆干豆皮'},{label:'其他豆制品'}],
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