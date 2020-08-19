import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    shoplist:[
    ],
    dizhilist:[
    ],
    name:'',
    sex:'',
    phone:'',
    menpai:'',
    moren:'',
    biaoqian:'',
    dizhi: ''
  },
   getters:{
        productNum(state){
          let productnumber=0;
          for (var key in state.shoplist) {
            productnumber +=
              state.shoplist[key].count 
          }
          return productnumber;
        },
        productPrice(state){
           let productprice=0;
           for(var key in state.shoplist){
             productprice+=
             state.shoplist[key].price*
             state.shoplist[key].count*
             state.shoplist[key].status
           }
           return productprice;
         }
      },
  mutations: {
     //添加商品种类
     add_car_mutations(state,payload){
      state.shoplist.push(payload)
  },
  //给商品数量自增
  add_car_count(state,i){
    state.shoplist[i].count++;
  },
  //清空购物车
  remove_car_count(state){
    state.shoplist=[]
  },
  //判断是否为check状态
  check_change(state,sub){
  state.shoplist[sub].status=(state.shoplist[sub].status=1?0:1)
  },
  //订单栏地址

    //姓名内容
    addgetListPOI(state,name) {
      state.dizhilist.push(name);
    },
    //性别内容
    addshow1(state,sex) {
      state. dizhilist.push(sex);
    },
    //手机号内容
    addgetListPOI1(state,phone) {
      state. dizhilist.push(phone);
    },
    //门牌号内容
    addgetListPOI2(state,menpai) {
      state.dizhilist.push(menpai);
    },
    //标签内容
    addbiaoqian(state,biaoqian) {
      state.dizhilist.push(biaoqian);
    },
    //设为默认地址的变化
    addcolorchange(state,qiu) {
      state.dizhilist.push(qiu);
    },

    //保存并使用提交并改变前页面的值
    addtijiao(state) {
      console.log(state.dizhilist);
    },
    //保存dzchange的值
    adddzchange(state,dizhi1) {
       state.dizhi = dizhi1;
       console.log(state.dizhi);
    }
  },
  
  actions: {
  },
  modules: {
  }
})
