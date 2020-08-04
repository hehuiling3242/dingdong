<template>
  <div class="home">
    <xitongtwo></xitongtwo>
    <div class="kongbai"></div>
    <img src="../../assets/img/jiantou.png" @click="switchTo(a)">
    登录/注册
    <input @blur="checkUname" v-model="username" type="text" placeholder="请输入用户名" />
    <p v-show="isUname">
      <img v-if="unameState" src="../../assets/img/ture.png" alt />
      <img v-else src="../../assets/img/false.png" alt />
    </p>
    <input @blur="checkUpwd" v-model="password" type="password" placeholder="请输入密码" />
    <p v-show="isUpwd">
      <img v-if="upwdState" src="../../assets/img/ture.png" alt />
      <img v-else src="../../assets/img/false.png" alt />
    </p>
    <input class="submit" :class="{btnBg:mybtn}" type="submit" value="登录" />
    <p>
      没有账号？
      <a href="#">点击注册</a>
    </p>
    <p class="cen_wei">
      <span>第三方账号登录</span>
      <img src="../../assets/img/weixin.png" alt />
      <span>微信登录</span>
    </p>
    <p class="foot">
      登录即代表你同意叮咚买菜
      <span>《服务协议》</span>和
      <span>《隐私政策》</span>
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      a:"/",
      username: "",
      password: "",
      unameState: false,
      upwdState: false,
      mybtn: false,
      isUname:false,
      isUpwd:false
    };
  },
  methods: {
    switchTo(path){
    // console.log(this.$router)
        this.$router.replace(path)
    },
    checkBtn() {
      if (this.unameState == true && this.upwdState == true) {
        this.mybtn = true;
      } else {
        this.mybtn = false;
      }
    },
    checkUname() {
      this.isUname=true;
      let username = this.username;
      //校验用户名,用户名的规则为:字母、数字及下划线的组合,长度为6~12个字符
      let usernameRegExp = /^[0-9A-Za-z_]{6,12}$/;
      if (usernameRegExp.test(username)) {
        this.unameState = true;
      } else {
        this.unameState = false;
      }
      this.checkBtn();
    },
    checkUpwd() {
      this.isUpwd=true;
      let password = this.password;
      //校验密码,密码的规则为:字母、数字及下划线的组合,长度为8~20个字符
      let passwordRegExp = /^[0-9A-Za-z_]{8,20}$/;
      if (passwordRegExp.test(password)) {
        this.upwdState = true;
      } else {
        this.upwdState = false;
      }
      this.checkBtn();
    },
  },
};
</script>

<style scope>
.kongbai{
  height: 1rem;
  width: 100%;
}
.home {
  width: 100%;
  padding: 0px 2rem;
  font-size: 1.7rem;
  font-weight: 500;
  color: #111;
  box-sizing: border-box;
  /* margin-top: 20px; */
}
.home > img {
  width: 2rem;
  vertical-align: middle;
  margin-right: 1.5rem;
}
input {
  display: block;
  height: 5.5rem;
  width: 100%;
  font-size: 1.6rem;
  color: #8a8a8a;
  outline: 0;
  border: 0;
  padding: 0 1.5rem;
  border-bottom: 0.05rem solid #cdcdcd;
  letter-spacing:.1rem;
  box-sizing: border-box  ;
}
.home > input:nth-of-type(1) {
  margin-top: 2rem;
}
.home p:nth-of-type(1)>img{
  width: 2rem;
  position: absolute;
  right: 2rem;
  top: 8rem;
}
.home p:nth-of-type(2)>img{
  width: 2rem;
  position: absolute;
  right: 2rem;
  top: 14rem;
}
.home .submit {
  width: 100%;
  height: 4.5rem;
  background-color: #cdcdcd;
  color: #fff;
  border-radius: 5rem;
  margin-top: 3rem;
}
.btnBg {
  background-color: #32cd32 !important;
}
.home > p:nth-of-type(3) {
  margin-top: 1rem;
  font-size: 1.2rem;
  color: #8a8a8a;
  text-align: right;
}
.home > p:nth-of-type(3) > a {
  color: #32cd32;
}
.cen_wei {
  width: 9rem;
  display: flex;
  flex-direction: column;
  flex-wrap: row;
  align-items: center;
  justify-content: center;
  font-size: 1.3rem;
  color: #707070;
  margin: 10rem auto 0px;
  margin-top: 10rem;
}
.cen_wei > img {
  width: 5rem;
  /* display: block; */
  margin-top: 2rem;
  margin-bottom: 0.4rem;
}
.cen_wei > span{
  width: 100px;
  display: flex;
  justify-content: center;
}
.foot {
  font-size: 0.5rem;
  text-align: center;
  color: #707070;
  margin-top: 3rem;
}
.foot > span {
  color: #32cd32;
}
</style>
