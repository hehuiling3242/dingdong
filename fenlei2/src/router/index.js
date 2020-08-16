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
// 搜索框
import InputSeekhome from '../components/demo/InputSeekhome.vue'
// 搜索框
import AddRemark from '../components/demo/AddRemark.vue'

// 项总 
// 顶部定位
import NavTop from '../components/demo/NavTop.vue'
// 特色专区
import HomeFea from '../components/demo/HomeFea.vue'
import Navigation from '../components/demo/Navigation.vue'
import Soppings from '../components/demo/Soppings.vue'

// 组长
// 注册页面
import Login from '../components/demo/Login.vue'
import Details from '../components/demo/Details.vue'
import lunbo from '../components/demo/lunbo.vue'
import sc from '../components/demo/sc.vue'

// 徐佳
// 会员
import homead from '../components/demo/home_ad.vue'
// 首页分类
import homesort from '../components/demo/home_sort.vue'
// 我的订单
import myGoods from '../components/demo/myGoods.vue'

// 海
import HomeList from '../components/demo/HomeList.vue'
// 我的
import mynews from '../components/demo/myNews.vue'

// 俞
// 我的
import goods from '../components/demo/goods.vue'
import listgoods from '../components/demo/list_goods.vue'
import Fills from '../components/demo/Fills.vue'
import filldingd from '../components/demo/fill_dingd.vue'

Vue.use(VueRouter)

const routes = [
  {
    path:'/addremark',
    component:AddRemark
    // 我的订单
  },
  {
    path:'/filldingd',
    component:filldingd
    // 我的订单
  },
  {
    path:'/fills',
    component:Fills
    // 我的订单
  },
  {
    path:'/mygoods',
    component:myGoods
    // 我的订单
  },
  {
    path:'/inputseekhome',
    component:InputSeekhome
    // 首页搜索
  },
  {
    path:'/soppings',
    component:Soppings
    // 地址跳转
  },
  {
    path:'/listgoods',
    component:listgoods
    // 地址跳转
  },
  {
    path:'/goods',
    component:goods
    // 地址跳转
  },
  {
    path:'/mynews',
    component:mynews
    // 地址跳转
  },
  {
    path:'/navigation',
    component:Navigation
    // 地址跳转
  },
  {
    path:'/homelist',
    component:HomeList
    // 会员
  },
  {
    path:'/homesort',
    component:homesort
    // 会员
  },
  {
    path:'/homead',
    component:homead
    // 会员
  },
  {
    path:'/lunbo',
    component:lunbo
  },
  {
    path:'/sc',
    component:sc
  },
  {
    path:'/details/:id',
    component:Details,
  },
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
    component:Cart,
    // meta: { requiresAuth: true } // 添加表示需要验证
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
