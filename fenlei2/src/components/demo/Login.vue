<template>
  <div class="home">
    <xitongtwo></xitongtwo>
    <div class="kongbai"></div>
    <div class="home_top">
        <img src="../../assets/img/jiantou.png" @click="switchTo(a)">
        <div>
            <p>登录</p>/
            <p>注册</p>
        </div>
    </div>
    <div class="home_zhong">
        <div class="home_zhong_top">
            <input @blur="checkUname" v-model="username" type="text" placeholder="请输入用户名" />
            <div v-show="isUname">
                <img v-if="unameState" src="../../assets/img/ture.png" alt />
                <img v-else src="../../assets/img/false.png" alt />
            </div>
        </div>
        <div class="home_zhong_btn">
            <input @blur="checkUpwd" v-model="password" type="password" placeholder="请输入密码" />
            <div v-show="isUpwd">
                <img v-if="upwdState" src="../../assets/img/ture.png" alt />
                <img v-else src="../../assets/img/false.png" alt />
            </div>
        </div>
    </div>
    <input class="submit" :class="{btnBg:mybtn}" type="submit" value="登录" @click="login()"/>
    <!-- <div class="home_zhong_xia">
        <p>没有账号？</p>
        <p>点击注册</p>
    </div> -->
    <div class="home_zhong_btn1">
        <div class="home_zhong_btn_top">
            <p>第三方账号登录</p>
        </div>
        <div class="home_zhong_btn_zhong">
            <img src="../../assets/img/weixin.png" alt="">
            <p>微信登录</p>
        </div>
        <div class="home_zhong_btn_btn">
            <p class="foot">
            登录即代表你同意叮咚买菜
            <span>《服务协议》</span>和
            <span>《隐私政策》</span>
    </p>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
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
      isUpwd:false,
      productQuery:{},
      productList:[{}],
      userQuery:{},
      userList:[]
    };
  },
  methods: {
    login() {
      this.userQuery.userName= this.username;
      this.userQuery.passWord= this.password;
      let url = "/server/user/login"
      this.axios.get(url, {params: this.userQuery}).then((res) => {
        console.log(res)
      if(res.data.code == 400){
        console.log("用户名或密码错误")
      }else{
        console.log("登录成功")
        this.$router.replace("/");
        let data=JSON.stringify(res.data.data);
        sessionStorage.setItem("userList",data)
        let id=res.data.data.id;
        sessionStorage.setItem("id",id)
        console.log(data,id)
      }
        console.log("--->> 用户",this.productList);
      })
    },
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
      //校验密码,密码的规则为:字母、数字及下划线的组合,长度为4~20个字符
      //are you kidding me?数据库里的密码最长的就6位,你限制8位?那我怎么输?
      let passwordRegExp = /^[0-9A-Za-z_]{4,20}$/;
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
.home {
  width: 100%;
  padding: 0px 2rem;
  font-size: 1.7rem;
  font-weight: 500;
  color: #111;
  box-sizing: border-box;
  /* margin-top: 20px; */
}
.kongbai{
  height: 1rem;
  width: 100%;
}
.home_top{
    display: flex;
}
.home_top > img {
  width: 2rem;
  vertical-align: middle;
  margin-right: 2rem;
}
.home_top > div{
    display: flex;
}
.home_zhong{
    margin-top: 2rem;
}
.home_zhong>input{
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
.home_zhong img{
    width: 2rem;
}
.home_zhong_top{
    display: flex;
    align-items: center;
}
.home_zhong_btn{
    display: flex;
    align-items: center;
}
.home_zhong_btn1{
    width: 90%;
    display: flex;
    align-items: center;
    flex-direction: column;
    position: fixed;
    bottom: 3rem;
}
.home_zhong_xia{
    display: flex;
     justify-content:flex-end;
    margin-top: 1.5rem;
    font-size: 1.2rem;
    color: #8a8a8a;
    text-align: right;
}
.home_zhong_xia>p:last-child{
    color: #32cd32;
    cursor: pointer;
    
}
.home_zhong_btn_top{
    width: 100%;
    border-top: 1px solid #dcdcdc;
    display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
}
.home_zhong_btn_top>p{
    position: absolute;
    top:-8px;
    background-color: #fff;
    padding: 0px 1rem;
}
.home_zhong_btn_zhong{
    margin-top: 8rem;
}
.home_zhong_btn_zhong>img{
    margin-bottom: 1rem;
}
.foot {
  font-size: 0.5rem;
  text-align: center;
  color: #707070;
  margin-top: 3rem;
}
</style>
