<template>
  <div class="content">
    <xitongtwo></xitongtwo>
    <div class="title">
      <div class="dizhi_img">
        <router-link to="/fills">
          <p class="dizhi_img1">
            <img src="../../assets/img/left.png" />
          </p>
        </router-link>
      </div>
      <p class="dizhi">添加地址</p>
    </div>
    <div class="xinxi">
      <div class="name">
        <p>联系人</p>
        <input type="text" placeholder="请填写姓名" v-model="name" ref="name1" />
      </div>
      <div class="sex">
        <div class="sex1">
          <p class="sex1_1" ref="sex1_1" @click="show1($event,1)">
            <span v-show="show1_1 == 1"></span>
          </p>
          <p ref="man">先生</p>
        </div>
        <div class="sex2">
          <p class="sex1_2" ref="sex1_2" @click="show1($event,2)">
            <span v-show="show1_2 == 2"></span>
          </p>
          <p ref="woman">女士</p>
        </div>
      </div>
      <div class="phone">
        <p>手机号</p>
        <input type="text" placeholder="请填写手机号" v-model="phone" />
      </div>
      <div class="shouhuo">
        <p>收货地址</p>
        <div class="shouhuo2">
          <router-link to="/">
            <div class="shouhuo1">
              <p>请选择收货地址</p>
              <img src="../../assets/img/right.png" />
            </div>
          </router-link>
        </div>
      </div>
      <div class="menpai">
        <p>门牌号</p>
        <input type="text" placeholder="例：9号楼302室" v-model="menpai" />
      </div>
      <div class="biaoqian">
        <p>标签</p>
        <div class="biaoqian1">
          <p
            class="biaoqian2"
            :class="{ a: changeGreen == index }"
            @click="green($event,index)"
            v-for="(item,index) of biaoqian"
            :key="index"
          >{{item.label}}</p>
        </div>
      </div>
      <div class="moren">
        <div class="moren_left">
          <p>设为默认地址</p>
          <p>在启动APP时将优先定位至默认地址，避免下单时选择错误地址</p>
        </div>
        <div class="moren_right">
          <div :class="{ qiuti:ys1,qiuti1:ys2 }" @click="colorchange($event)">
            <p :class="{ xiaoqiu:ys1,xiaoqiu1:ys2 }"></p>
          </div>
        </div>
      </div>
    </div>
    <div class="use" :class="{ use1:change }" @click="tijiao">保存并使用</div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      //设置选中sex的变化
      show1_1: 0,
      show1_2: 0,
      //设置标签被选中时候的变化
      changeGreen: -1,
      ys1: true,
      ys2: false,
      biaoqian: [{ label: "家" }, { label: "公司" }, { label: "父母家" }],
      //点击设置默认地址时候样式的变化
      qiucolor: 0,
      //输入后保存并使用的按钮的背景色变色
      change: false,
      name: "",
      phone: "",
      menpai: "",
      timeout: null,
    };
  },

  watch: {
    //输入姓名改变button的样式
    name(curVal, oldVal) {
      // 实现input连续输入，只发一次请求
      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        this.getListPOI(curVal);
        // console.log(this.getListPOI(curVal));
      }, 2000);
    },

    //输入手机号改变button的样式
    phone(curVal, oldVal) {
      // 实现input连续输入，只发一次请求
      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        this.getListPOI1(curVal);
        // console.log(this.getListPOI(curVal));
      }, 2000);
    },

    //输入手机号改变button的样式
    menpai(curVal, oldVal) {
      // 实现input连续输入，只发一次请求
      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        this.getListPOI2(curVal);
        // console.log(this.getListPOI(curVal));
      }, 2000);
    },
  },

  methods: {
    show1(e, i) {
      this.show1_1 = i;
      this.show1_2 = i;
      this.change = true;
      if (i == 1) {
        this.$store.commit("addgetListPOI", this.$refs.man.innerText);
      } else if (i == 2) {
        this.$store.commit("addgetListPOI", this.$refs.woman.innerText);
      }
    },
    green(e, index) {
      this.changeGreen = index;
      this.change = true;
      this.$store.commit("addbiaoqian", e.target.innerText);
    },

    //点击改变默认地址右边的球体的位置变化
    colorchange() {
      this.ys1 = !this.ys1;
      this.ys2 = !this.ys2;
      this.change = true;
      if (this.ys2) {
        this.$store.commit("addcolorchange", "默认");
      }
    },
    //输入姓名改变button的样式
    getListPOI(curVal) {
      if (curVal != null) {
        this.change = true;
        this.$store.commit("addgetListPOI", curVal);
      }
    },
    //输入手机号改变button的样式
    getListPOI1(curVal) {
      if (curVal != null) {
        this.change = true;
        this.$store.commit("addgetListPOI1", curVal);
      }
    },
    //输入门牌改变button的样式
    getListPOI2(curVal) {
      if (curVal != null) {
        this.change = true;
        this.$store.commit("addgetListPOI2", curVal);
      }
    },

    //保存并使用提交按钮
    tijiao() {
      // let a = this.$store.commit("addtijiao");
      // console.log(a);
      this.$router.push("/fills");
      // console.log(this.$parents.$refs);
    },
  },
  mounted() {
    //  window.console.log(this.$refs.name.value)
    //  console.log(this.$refs.name.innerText);
  },
};
</script>
<style scoped>
.content {
  display: flex;
  background-color: #f4f4f4;
  flex-wrap: wrap;
  width: 100%;
  height: 100vh;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}

/* 第一行 */
.content > .title {
  width: 100%;
  background-color: #fff;
  height: 5.5rem;
  display: flex;
  /* flex-direction: row; */
  /* flex-wrap: nowrap; */
  justify-content: flex-start;
  align-items: center;
  /* text-align: center; */
}
.title .dizhi_img {
  width: 1.5rem;
  height: 2rem;
  line-height: 2rem;
  margin: 0 2rem 0 1rem;
}
.title > .dizhi_img img {
  width: 100%;
  height: 2rem;
  vertical-align: middle;
}
/* 第一行的字体设置 */
.title .dizhi {
  font-size: 1.8rem;
}

/* 第二块内容区域 */
.xinxi {
  width: 100%;
  background-color: #fff;
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  margin-top: 1.5rem;
}

/* 联系人 */
.xinxi > .name {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.name > p {
  width: 20%;
  display: flex;
  margin-left: 1.5rem;
  color: #606060;
  font-size: 1.6rem;
}
.name > input {
  width: 80%;
  height: 1.6rem;
  display: inline-block;
  border: none;
  outline: none;
  font-size: 1.6rem;
  caret-color: green;
}
.name > input::-webkit-input-placeholder {
  color: #b3b3b3;
}

/* 性别 */
.sex {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.sex1 {
  margin-left: 23%;
}
.sex1,
.sex2 {
  width: 20%;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
}
.sex1_1,
.sex1_2 {
  width: 1.6rem;
  height: 1.6rem;
  background-color: #fff;
  border: 0.2rem solid #cbcbcb;
  border-radius: 50%;
}
.sex1 > p:nth-child(2),
.sex2 > p:nth-child(2) {
  margin-left: 0.5rem;
  color: #1d1d1d;
  font-size: 1.6rem;
}
.sex1_1 > span,
.sex1_2 > span {
  display: inline-block;
  width: 100%;
  height: 100%;
  background: url("../../assets/img/duigou.svg") no-repeat center center;
  background-size: 130%;
}

/* 手机号 */
.phone {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.phone > p {
  width: 20%;
  display: flex;
  margin-left: 1.5rem;
  color: #606060;
  font-size: 1.6rem;
}
.phone > input {
  width: 80%;
  height: 1.6rem;
  display: inline-block;
  border: none;
  outline: none;
  font-size: 1.6rem;
  caret-color: green;
}
.phone > input::-webkit-input-placeholder {
  color: #b3b3b3;
}

/* 收货地址 */
.shouhuo {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.shouhuo2 {
  width: 80%;
  /* height: 5.5rem; */
  /* display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center; */
}
.shouhuo1 {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.shouhuo1 > img {
  width: 1.6rem;
  height: 1.6rem;
  margin: 0 1rem 0 0;
}
.shouhuo1 {
  color: #b3b3b3;
  font-size: 1.6rem;
}
.shouhuo > p {
  width: 20%;
  display: flex;
  margin-left: 1.5rem;
  color: #606060;
  font-size: 1.6rem;
}

/* 门牌号 */
.menpai {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.menpai > p {
  width: 20%;
  display: flex;
  margin-left: 1.5rem;
  color: #606060;
  font-size: 1.6rem;
}
.menpai > input {
  width: 80%;
  height: 1.6rem;
  display: inline-block;
  border: none;
  outline: none;
  font-size: 1.6rem;
  caret-color: green;
}
.menpai > input::-webkit-input-placeholder {
  color: #b3b3b3;
}

/* 标签 */
.biaoqian {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  border-bottom: 0.1rem solid #f6f6f6;
}
.biaoqian > p {
  width: 20%;
  display: flex;
  margin-left: 1.5rem;
  color: #606060;
  font-size: 1.6rem;
}
.biaoqian1 {
  width: 80%;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
}
.biaoqian1 > .biaoqian2 {
  width: 4rem;
  height: 2rem;
  line-height: 2rem;
  text-align: center;
  background-color: #f7f7f7;
  font-size: 1.2rem;
  color: #939393;
}
.a {
  background-color: #d8f1de !important;
  color: #51be74 !important;
}
.biaoqian1 > p + p {
  margin-left: 1.5rem;
}

/* 设置默认地址 */
.moren {
  width: 100%;
  height: 10rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
.moren_left {
  width: 70%;
  display: flex;
  flex-direction: column;
  /* flex-wrap: wrap; */
  justify-content: center;
  align-items: flex-start;
  margin-left: 1.5rem;
}
.moren_left > p:nth-child(1) {
  color: #595959;
  font-size: 1.6rem;
}
.moren_left > p:nth-child(2) {
  color: #a0a0a0;
}
/* 默认地址的右侧 */
.moren_right {
  width: 30%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.moren_right > .qiuti {
  width: 4rem;
  height: 2rem;
  position: relative;
  border: 2px solid #cecece;
  border-top-left-radius: 2rem;
  border-top-right-radius: 2rem;
  border-bottom-left-radius: 2rem;
  border-bottom-right-radius: 2rem;
}
.moren_right > .qiuti1 {
  width: 4rem;
  height: 2rem;
  position: relative;
  border: 2px solid #cecece;
  background-color: #4bd865;
  border-top-left-radius: 2rem;
  border-top-right-radius: 2rem;
  border-bottom-left-radius: 2rem;
  border-bottom-right-radius: 2rem;
}
.moren_right .xiaoqiu {
  width: 2rem;
  height: 2rem;
  border: 1px solid #cecece;
  border-radius: 50%;
  position: absolute;
  top: -0.2rem;
  left: -0.1rem;
}
.moren_right .xiaoqiu1 {
  width: 2rem;
  height: 2rem;
  border: 1px solid #cecece;
  border-radius: 50%;
  background-color: #fff;
  position: absolute;
  top: -0.2rem;
  right: -0.1rem;
}

/* 保存并使用 */
.use {
  width: 95%;
  height: 5rem;
  margin: 0 auto;
  margin-top: 2rem;
  line-height: 5rem;
  text-align: center;
  color: #fff;
  font-size: 2rem;
  background-color: #cccccc;
  border-top-left-radius: 5rem;
  border-top-right-radius: 5rem;
  border-bottom-left-radius: 5rem;
  border-bottom-right-radius: 5rem;
}
.use1 {
  background: linear-gradient(#41de5b, #2ebc5a);
}
</style>