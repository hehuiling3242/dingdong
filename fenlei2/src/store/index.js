import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    shoplist:[
    ],
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
  }
  },
  actions: {
  },
  modules: {
  }
})
