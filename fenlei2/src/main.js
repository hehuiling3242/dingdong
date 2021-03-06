import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import qs from 'qs'
// import MintUI from 'mint-ui'
// import 'mint-ui/lib/style.min.css'
// Vue.use(MintUI)

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI)

// 返回全局组件
// import Fanhuittop from './components/demo/Fanhuittop.vue'
// Vue.component('fanhuittop',Fanhuittop)
// 底部当行全局组件
import BottonTab from './components/demo/BottonTab.vue'
Vue.component('bottontab',BottonTab)
// 搜索框组件
import ClassifyInput from './components/demo/ClassifyInput.vue'
Vue.component('classifyinput',ClassifyInput)
// 搜索框组件
import ClassifyInputhome from './components/demo/ClassifyInputhome.vue'
Vue.component('classifyinputhome',ClassifyInputhome)
//系统栏组件黑
import xitong from './components/demo/xitong.vue'
Vue.component('xitong',xitong)
//系统栏组件白
import xitongtwo from './components/demo/xitongtwo.vue'
Vue.component('xitongtwo',xitongtwo)

Vue.prototype.axios = axios;
Vue.config.productionTip = false

// Vue.prototype.changeData = fanhui = function (){//changeData是函数名
//   alert('执行成功');w
// }
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
