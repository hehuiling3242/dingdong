import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/demo/Home.vue'
import Classify from '../components/demo/Classify.vue'
import WhatEat from '../components/demo/WhatEat.vue'
import Cart from '../components/demo/Cart.vue'
import Mine from '../components/demo/Mine.vue'
// 分类input子组件
import ClassifyInput from '../components/demo/ClassifyInput.vue'
// input跳转页面,搜索页
import InputSeek from '../components/demo/InputSeek.vue'
// 测试页面
import ceshi from '../components/demo/ceshi.vue'
// 新人尝鲜价
import HomeNew from '../components/demo/HomeNew.vue'
// 优惠券
import HomeCoupon from '../components/demo/HomeCoupon.vue'
// 限时抢购
import HomeSale from '../components/demo/HomeSale.vue'
// 99活动
import jiujiu from '../components/demo/jiujiu.vue'


// 项总 
// 顶部定位
import NavTop from '../components/demo/NavTop.vue'
// 特色专区
import HomeFea from '../components/demo/HomeFea.vue'

// 组长
// 注册页面
import Login from '../components/demo/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/jiujiu',
    component:jiujiu
    // 注册页面(我的页面没有写,没有地方跳转)
  },
  {
    path:'/login',
    component:Login
    // 注册页面(我的页面没有写,没有地方跳转)
  },
  {
    path:'/homefea',
    component:HomeFea
    // 特色专区
  },
  {
    path:'/navtop',
    component:NavTop
    // 顶部定位
  },
  {
    path:'/homesale',
    component:HomeSale
    // 限时抢购
  },
  {
    path:'/homecoupon',
    component:HomeCoupon
    // 优惠券
  },
  {
    path:'/homenew',
    component:HomeNew
    // 新人尝鲜价
  },
  {
    path:'/ceshi',
    component:ceshi
    // 搜索跳转页面
  },
  {
    path:'/inputseek',
    component:InputSeek
    // 搜索跳转页面
  },
  {
    path:'/classifyinput',
    component:ClassifyInput
    // 搜索组件
  },
  {
    path:'/mine',
    component:Mine
    // 我的
  },
  {
    path:'/cart',
    component:Cart
    // 购物车
  },
  {
    path:'/whateat',
    component:WhatEat
    // 吃什么
  },
  {
    path:'/classify',
    component:Classify
    // 分类
  },
  {
    path:'/',
    component:Home
    // 首页
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
