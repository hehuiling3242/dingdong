<template>
  <div class="content">
    <xitongtwo></xitongtwo>
    <div class="titles">
      <p @click="say">
        <img src="../../assets/img/jiantou.png" />
      </p>
      <p class="dingdan">填写订单</p>
    </div>
    <div class="dizhi" >
      <div @click="shdzshow">
        <div class="dizhi1">
          <p>选择收货地址</p>
          <img src="../../assets/img/right.png" />
        </div>
        <div class="dizhi2"></div>
      </div>
    </div>
    <div class="times">
      <div class="shangp">
        <span class="shangp_left">送达时间</span>
        <div class="shangp_right" @click="show">
          <b>
            <p ref="shangp_right">请选择送达时间</p>
          </b>
          <img src="../../assets/img/right.png" />
        </div>
      </div>
      <div class="shangp1">
        <p class="shangp1_left">超时补偿</p>
        <p class="shangp1_center">超时10分钟获赔300积分，可抵扣现金</p>
        <!-- <p class="shangp1_right">?</p> -->
      </div>
      <div class="shangp2" v-for="(products,index) of this.$store.state.shoplist" :key="index">
        <img :src="products.filePaths[0]" >
        <div class="details">
          <div class="details1">
            <p class="title">{{products.productName}}</p>
            <div class="price_right">
              <em>¥</em>
              <span>
                <b>{{products.price}}</b>
              </span>
            </div>
          </div>
          <p class="price">单价: ¥{{products.price}}/份</p>
          <p class="count">数量: {{products.count}}份</p>
        </div>
      </div>
    </div>
    <div class="pay">
      <div class="fangs">
        <p>支付方式</p>
      </div>
      <div class="pay_detail">
        <div class="detail1">
          <img src="../../assets/img/zhifub.svg" />
          <div class="detail1_4">
            <div class="detail1_5">
              <p class="detail1_1">支付宝支付</p>
              <p class="detail1_2">随机抢免单</p>
            </div>
            <p class="detail1_3" ref="detail1_3" @click="show1($event,1)">
              <span v-show="show1_1 == 1"></span>
            </p>
          </div>
        </div>
        <div class="detail2">
          <img src="../../assets/img/wechat.svg">
          <div class="detail2_3">
            <p class="detail2_1">微信支付</p>
            <p class="detail2_2" ref="detail2_2" @click="show1($event,2)">
              <span v-show="show1_1 == 2"></span>
            </p>
          </div>
        </div>
        <div class="detail3">
          <img src="../../assets/img/huabei.svg" />
          <div class="detail3_3">
            <p class="detail3_1">花呗</p>
            <p class="detail3_2" ref="detail3_2" @click="show1($event,3)">
              <span v-show="show1_1 == 3"></span>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="youhui">
      <!-- <div class="juan1">
        <router-link to="/youhui">
          <div class="juan">
            <p>优惠券</p>
            <div class="shuliang">
              <p>共5张，0张可用</p>
              <p>
                <img src="../../assets/img/youhui.png" />
                <span>请选择收货地址后使用优惠券</span>
              </p>
            </div>
            <img src="../../assets/img/right.png" />
          </div>
        </router-link>
      </div> -->
      <div class="jifen">
        <p>积分 共0，满300可用</p>
        <!-- <p>?</p> -->
      </div>
    </div>
    <div class="beizhu">
      <p>备注</p>
      <router-link to="/beizhu">
        <div class="beizhu1">
          <p>选填，可用告诉我们您的特殊需求</p>
          <img src="../../assets/img/right.png" />
        </div>
      </router-link>
    </div>
    <div class="price_detail">
      <div class="priced1">
        <p>商品金额</p>
        <p>
          <span>配送费</span>
          <!-- <span>?</span> -->
        </p>
        <p>配送费减免</p>
      </div>
      <div class="priced2">
        <p>
          <b>
            <em>¥</em>
            <span>{{this.$store.getters.productPrice.toFixed(2)}}</span>
          </b>
        </p>
        <p>
          <b>
            <em>¥</em>
            <span>5.00</span>
          </b>
        </p>
        <p>
          <b>
            <em>-</em>
            <em>¥</em>
            <span>5.00</span>
          </b>
        </p>
      </div>
    </div>
    <div class="tijiao1"></div>
    <div class="tijiao">
      <p>实付</p>
      <p>
        <b>
          <em>¥</em>
          <span>
            {{Number(this.$store.getters.productPrice.toFixed(2))+Number(a)}}
          </span>
        </b>
      </p>
      <p @click="switchTo(b)">提交订单</p>
    </div>
    <div class="yincang1" v-show="yincang1_show">
      <div class="yincang" ref="yincang_1" :style="{height:myheight}">
        <div class="songda">
          <p></p>
          <p>选择送达时间</p>
          <img @click="close" src="../../assets/img/cha.svg" />
        </div>
        <div class="date">
          <div class="date_left">
            <p :class="{ date_left1:changewhite == 0 }" v-show="time1 <= 2100 && time1 >=700" @click="showdate($event,0)">
              <b>今天{{month}}月{{date}}日</b>
            </p>
            <p :class="{ date_left1:changewhite == 1 }" @click="showdate($event,1)">
              <b>明天{{month}}月{{date+1}}日</b>
            </p>
          </div>
          <div class="date_right">
            <ul v-if="changewhite == 0">
              <li :class="{ link1:changGreen == -1 }" @click="greens($event,-1)" >
                尽快送达 (预计{{time}}前)
                <img src="../../assets/img/gou1.svg" v-show="img_show== -1">  
              </li>
              <li class="link" :class="{ link1:changGreen == index }" @click="greens($event,index)" v-for="(item,index) of data" v-show="mydate<=item.id" :key="index" >
                <b>{{item.label}}</b>
                <img src="../../assets/img/gou1.svg" v-show="img_show==index">
              </li>
            </ul>
            <ul v-else>
              <li class="link" :class="{ link1:changGreen == index }" @click="greens($event,index)" v-for="(item,index) of data" :key="index">
                <b>{{item.label}}</b>
                <img src="../../assets/img/gou1.svg" v-show="img_show==index">
              </li>
            </ul>
          </div>
        </div>
        <div class="date_buttom" @click="dateshow">
          <p>确定</p>
        </div>
      </div>
    </div>
    <div class="shdz" v-show="shdz_show">
      <div class="shdz_posi">
        <div class="shdz_top">
          <p></p>
          <p>选择送达时间</p>
          <img @click="shdz" src="../../assets/img/cha.svg" />
        </div>
        <div class="shdz_btn" @click="shdz">
          <p>
            {{userList.address}}
          </p>
          <p>
            {{userList.fullAddress}}
          </p>
        </div>
      </div>
      
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      statu:1,
      a:5,
      b:"/mygoods",
      mydate:26,
      myheight: "0vh",
      yincang1_show: false,
      shdz_show:false,
      yincang1_close:true,
      userList:{},
      //设置时间的样式
      changGreen: 0,
      //设置时间被选中时候后面的勾的显示与隐藏
      img_show:0,
      //设置时间方式被选中的时候的样式改变
      show1_1: 0,
      show1_2: 0,
      show1_3: 0,
      //设置时间方式最上方的尽快送达区域
      time: "", 
      // 设置时间界面的左半边
      month: "",
      date: "",
      time1: "",
      changewhite: 0,
      //点击时间界面的确定
      datexs1: "",
      datexs: "",
      //设置
      data: [
        { id:1,label: "07:00-07:30" },
        { id:2,label: "07:30-08:00" },
        { id:3,label: "08:00-08:30" },
        { id:4,label: "08:30-09:00" },
        { id:5,label: "09:00-09:30" },
        { id:6,label: "09:30-10:00" },
        { id:7,label: "10:00-10:30" },
        { id:8,label: "10:30-11:00" },
        { id:9,label: "11:00-11:30" },
        { id:10,label: "11:30-12:00" },
        { id:11,label: "12:00-12:30" },
        { id:12,label: "12:30-13:00" },
        { id:13,label: "13:00-13:30" },
        { id:14,label: "13:30-14:00" },
        { id:15,label: "14:00-14:30" },
        { id:16,label: "14:30-15:00" },
        { id:17,label: "15:00-15:30" },
        { id:18,label: "15:30-16:00" },
        { id:19,label: "16:00-16:30" },
        { id:20,label: "16:30-17:00" },
        { id:21,label: "17:00-17:30" },
        { id:22,label: "17:30-18:00" },
        { id:23,label: "18:00-18:30" },
        { id:24,label: "18:30-19:00" },
        { id:25,label: "19:00-19:30" },
        { id:26,label: "19:30-20:00" },
        { id:27,label: "20:00-20:30" },
        { id:28,label: "20:30-21 :00" },
        { id:29,label: "21:00-21:30" },
        { id:30,label: "21:30-22:00" },
      ],
    };
  },
  created(){
    this.queryUserList();
  },
  methods: {
    switchTo(a){
      this.$router.replace(a);
      this.$store.state.shoplist.forEach(indexSP=>{
        console.log(this.$store.state.shoplist);
        console.log(indexSP.id);
          let url="/server/plan/add?" + `userId=${sessionStorage.getItem("id")}&productId=${indexSP.id}&productName=${indexSP.productName}&planCount=${indexSP.count}&status=${indexSP.status}&unitPrice=${indexSP.price}&mainImgId=${indexSP.fileIdSet[1]}`;
          this.axios.post(url).then(res=>{
            console.log(res.data);
          })
      })
    },
    queryUserList(){
      this.userList = JSON.parse(sessionStorage.getItem("userList"));
    },
    //填写订单左边的按钮点击完后跳转
    say() {
       this.$router.push('/cart');
    },
    show() {
      //送达时间的设定右边      
      var date=new Date();
      var hour=date.getHours();
      this.mydate=hour*2-11;
      var minutes=date.getMinutes();
      var date1 = (hour+1) + ":" + (minutes = (minutes<10? "0"+minutes:minutes)) ;
      // console.log(date1);
      this.time = date1;
      if(minutes>30){
        this.mydate+=1;
      }

      //送达时间的设定左边
      var month = date.getMonth()+1;
      var date = date.getDate();
      this.month = (month = (month<10? "0"+month:month));
      this.date = (date = (date<10? "0"+date:date));
      // console.log(month,date);
      //送达时间的设定左边的显示与隐藏部分
      var date2 = parseInt(`${hour}`+`${minutes}`);
      // console.log(date2,typeof date2);
      this.time1 = date2;
      if( date2 <= 2100 && date2 >=700 ){
          this.changewhite = 0;
      }else{
        this.changewhite = 1;
      }
      //控制送达时间的显示与隐藏 
      var i = 0;
      this.yincang1_show = true;
      let timer = setInterval( ()=> {
        i += 5;
        this.myheight = i + "vh";
        if (i >= 45) {
          clearInterval(timer);
        }
      }, 10);
    },
    //点x可以关掉显示的时间div
    close() {
      this.yincang1_show = false;
    },
    //右侧时间点击的显示
    greens(e,index) {
      this.changGreen = index;
      this.img_show = index;
      if( e.target.innerText.substring(0,2) == "尽快" ){
         this.datexs1 = "";
         this.datexs1 = e.target.innerText;
         
      }else{
         this.datexs1 = "";
         this.datexs1 = this.datexs1 + e.target.innerText;
      }     
      console.log(this.datexs1);
    },
    
    //支付方式点击的显示
    show1(e,i) {
      // e.target.style="box-shadow: 0 0 3rem rgba(0,0,0,.8)";
      // e.target.style="box-shadow 0.3s ease-in-out"; 
      this.show1_1 = i;
      this.show1_2 = i;
      this.show1_3 = i;
    },
    //左侧时间点击的显示
    showdate(e,i) {
      this.changewhite = i;
      this.datexs = e.target.innerText.substring(0,2);
    },
    dateshow() {
      this.$refs.shangp_right.innerText = this.datexs + this.datexs1;
      this.yincang1_show = false;
      console.log(this.datexs + this.datexs1);
    },
    shdzshow(){
      this.shdz_show = true
      console.log(1)
    },
    shdz(){

      this.shdz_show = false
    },
    // dzbgc(){

    // }
  },
};
</script>
<style scoped>
.shon{
    background-color: #ccc;
}
.shdz{
  position: fixed;
  bottom: 0px;
  height: 100vh;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  font-size: 1.6rem;
  color: #282828;
}
.shdz_posi{
  position: fixed;
  bottom: 0px;
  /* height: 20vh; */
  width: 100%;
  background-color: #fff;
  border-radius: 1rem 1rem 0px 0px;
}
.shdz_top{
  height: 4.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 1rem;
}
.shdz_btn{
  margin: 0px 1rem;
  padding: 1rem;
  border-top:1px solid #ccc
}
.shdz_btn>p:first-child{
  font-size: 1.6rem;
  color: #333;
  /* margin-top:.rem */
}
.shdz_btn>p:last-child{
  font-size: 1.4rem;
  color: #666;
  margin-top:.5rem
}
.shdz_top>p:first-child{
  width: 2rem;
}
.shdz_top>img{
  width: 2rem;
}
.content {
  display: flex;
  background-color: #f5f5f5;
  flex-wrap: wrap;
  width: 100%;
  /* height: 100vh; */
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

/* 第一行 */
.content > .titles {
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
.titles > p:first-child {
  width: 1.5rem;
  height: 2rem;
  line-height: 2rem;
  margin: 0 2rem 0 1rem;
}
.titles > p:first-child img {
  width: 100%;
  height: 1.5rem;
  vertical-align: middle;
}
/* 第一行的字体设置 */
.titles .dingdan {
  font-size: 1.8rem;
}

/* 第二行设置 */
.dizhi {
  width: 100%;
  height: 5.5rem;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  margin: 1.5rem 0 0 0;
}
.dizhi .dizhi1 {
  display: flex;
  width: 100%;
  height: 5rem;
  background-color: #fff;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
/* 选择收货地址栏 */
.dizhi1 > p {
  font-size: 1.6rem;
  color: #2e2e2e;
  margin: 0 0 0 1.5rem;
}
.dizhi1 > img {
  width: 1.6rem;
  height: 1.6rem;
  margin: 0 1rem 0 0;
}
.dizhi2 {
  width: 100%;
  height: 0.2rem;
  background-image: url("../../assets/img/border.png");
  background-repeat: repeat-x;
}

/* 第三行设置 */
.times {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
.times > .shangp {
  width: 100%;
  height: 5rem;
  background-color: #fff;
  font-size: 1.6rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin: 1.5rem 0 0 0;
}

/* 第三行送达时间设置 */
.times .shangp_left {
  margin: 0 0 0 1.5rem;
  color: #242424;
}
.times .shangp_right {
  width: 40%;
  display: flex;
  justify-content: space-between;
  margin: 0 0 0 0;
  color: #2fa956;
}
.shangp_right p {
  /* width: 80%; */
  margin: 0 0 0 0;
}
.shangp img {
  width: 1.6rem;
  height: 1.6rem;
  margin: 0 1rem 0 0;
}
/* 第三行里的第二行 */
.times .shangp1 {
  width: 100%;
  height: 3rem;
  display: flex;
  flex-direction: row;
  align-items: center;
  background-color: #fff;
  font-size: 1.2rem;
  color: #aeaeae;
  border-bottom: 0.1rem solid #f9f9f9;
}
.shangp1 > .shangp1_left {
  width: 5rem;
  height: 1.5rem;
  font-size: 1.2rem;
  margin: 0 0 0 1.5rem;
  background-color: #edfef4;
  border: 0.1rem solid #a0cab1;
  color: #46a865;
}
.shangp1 > .shangp1_center {
  margin: 0 0.5rem 0 0.5rem;
}
.shangp1 > .shangp1_right {
  width: 1.4rem;
  height: 1.4rem;
  border: 0.1rem solid #aeaeae;
  border-radius: 50%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
/* 第三行里的第三行 */
.shangp2 {
  width: 100%;
  height: 8rem;
  display: flex;
  background-color: #fff;
  flex-direction: row;
  align-items: center;
}
.shangp2 > img {
  width: 5.5rem;
  height: 5.5rem;
  margin: 0 0 0 1.5rem;
}
/* 第三行里的第二列 */
.shangp2 > .details {
  width: 75%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 0 0 0 1.5rem;
}
.details1 {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: #242424;
  font-size: 1.4rem;
}
.details > .price{
  margin: .4rem 0px;
  color: #666;
}
.details > .count {
  color: #666;
  /* margin: 0 0 0 0; */
}

/* 第四行里面的第一行 */
.pay {
  width: 100%;
  margin: 1.5rem 0 0 0;
}
.pay > .fangs {
  width: 100%;
  height: 5rem;
  background-color: #fff;
  font-size: 1.6rem;
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 0 0 0 0;
  border-bottom: 0.1rem solid #f6f6f6;
}
.fangs > p {
  /* float: left; */
  color: #242424;
  margin: 0 0 0 1.5rem;
}
/* 第四行里的第二块 */
.pay > .pay_detail {
  width: 100%;
  height: 15rem;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
/* 第二块里的第一行 */
.pay_detail > .detail1,
.pay_detail > .detail2,
.pay_detail > .detail3 {
  width: 100%;
  height: 5rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  font-size: 1.6rem;
  color: #242424;
}
.pay_detail > .detail1 > img,
.pay_detail > .detail2 > img,
.pay_detail > .detail3 > img {
  width: 1.6rem;
  height: 1.6rem;
  margin-left: 1.5rem;
}
.pay_detail .detail1_1,
.pay_detail .detail1_2,
.pay_detail .detail2_1,
.pay_detail .detail3_1 {
  margin-left: 0.5rem;
}
.pay_detail .detail1_4,
.pay_detail .detail2_3,
.pay_detail .detail3_3 {
  width: 85.5%;
  display: flex;
  justify-content: space-between;
}
.pay_detail .detail1_5 {
  display: flex;
}

.pay_detail .detail1_2 {
  font-size: 1.2rem;
  color: #d87274;
}
.pay_detail .detail1_3,
.pay_detail .detail2_2,
.pay_detail .detail3_2 {
  width: 1.6rem;
  height: 1.6rem;
  background-color: #fff;
  border: 0.2rem solid #cbcbcb;
  border-radius: 50%;
}
/* 支付方式选择的图片填充 */
.detail1_3>span,.detail2_2>span,.detail3_2>span{
  display: inline-block;
  width: 100%;
  height: 100%;
  background:  url("../../assets/img/duigou.svg") no-repeat center center;
  background-size: 120%;
  
}


/* 第五行优惠 */
.youhui {
  width: 100%;
  /* height: 12rem; */
  background-color: #fff;
  display: flex;
  margin-top: 1.5rem;
  align-items: flex-start;
  flex-direction: column;
  /* color: #242424 !important; */
}
.youhui .juan1 {
  width: 100%;
  height: 6rem;
  background-color: #fff;
  border-bottom: 0.1rem solid #f6f6f6;
  /* color: #242424; */
}
.youhui .juan {
  width: 100%;
  height: 6rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  color: #000;
}
.youhui .juan > p {
  margin-left: 1.5rem;
  color: #242424;
  font-size: 1.6rem;
}
.youhui .juan > .shuliang {
  width: 75%;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
.youhui .juan > img {
  width: 1.6rem;
  height: 1.6rem;
  margin-right: 2rem;
}
.shuliang > p:nth-child(1) {
  color: #ababab;
  font-size: 1.6rem;
}
.shuliang > p:nth-child(2) {
  color: #ee6868;
  font-size: 1.2rem;
}
.shuliang > p:nth-child(2) > img {
  width: 1.2rem;
  height: 1.2rem;
  background-color: #f83231;
}
/* 第五行第二行 */
.jifen {
  width: 100%;
  height: 6rem;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.jifen > p:nth-child(1) {
  color: #242424;
  font-size: 1.6rem;
  margin-left: 1.5rem;
}
.jifen > p:nth-child(2) {
  width: 1.4rem;
  height: 1.4rem;
  border: 0.1rem solid #929292;
  border-radius: 50%;
  color: #7f7f7f;
  font-size: 1.4rem;
  margin-left: 0.5rem;
}

/* 第六行备注 */
.beizhu {
  width: 100%;
  height: 5rem;
  background-color: #fff;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin-top: 1.5rem;
}
.beizhu > p {
  color: #242424;
  font-size: 1.6rem;
  margin-left: 1.5rem;
}
.beizhu1 {
  width: 100%;
  display: flex;
  flex-direction: row;
  /* justify-content: flex-end; */
  align-items: center;
  color: #bbbbbb;
  font-size: 1.6rem;
}
.beizhu1 > img {
  width: 1.6rem;
  height: 1.6rem;
  margin-right: 2rem;
}

/* 第七行商品金额 */
.price_detail {
  width: 100%;
  height: 12rem;
  background-color: #fff;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 1.5rem;
  /* margin-bottom: 2rem; */
}
.price_detail > .priced1 {
  width: 20%;
  height: 10rem;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: flex-start;
  align-content: flex-start;
  margin-top: 1rem;
  margin-left: 1.5rem;
  color: #242424;
  font-size: 1.6rem;
}
.priced1 > p:nth-child(2) > span:nth-child(2) {
  width: 1.4rem;
  height: 1.4rem;
  border: 0.1rem solid #929292;
  border-radius: 50%;
  color: #7f7f7f;
  font-size: 1.4rem;
  margin-left: 0.5rem;
}

.price_detail > .priced2 {
  width: 20%;
  height: 10rem;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: flex-end;
  align-content: flex-start;
  margin-top: 1rem;
  margin-right: 1.5rem;
  color: #242424;
  font-size: 1.6rem;
}
.price_detail > .priced2 > p:nth-child(3) {
  color: #f65d5e;
  font-size: 1.6rem;
}

/* 最后一行提交订单 */
.tijiao {
  width: 100%;
  height: 5rem;
  background-color: #fff;
  display: flex;
  position: fixed;
  bottom: 0;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  margin-top: 1.5rem;
  font-size: 1.6rem;
  /* z-index: -10000; */
}
.tijiao > p:nth-child(1) {
  /* color: #F85857; */
  margin-right: 0.5rem;
}
.tijiao > p:nth-child(2) {
  color: #f85857;
  margin-right: 0.5rem;
}
.tijiao > p:nth-child(3) {
  width: 30%;
  height: 4rem;
  background-color: #fb5454;
  text-align: center;
  line-height: 4rem;
  color: #fff;
  border-top-right-radius: 2rem;
  border-top-left-radius: 2rem;
  border-bottom-right-radius: 2rem;
  border-bottom-left-radius: 2rem;
}

/* 提交下方的灰色部分 */
.tijiao1 {
  width: 100%;
  height: 4rem;
  background-color: #f5f5f5;
}

/* 隐藏栏设置 */
.yincang1 {
  width: 100%;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.6);
  /* opacity: 0.6; */
  position: fixed;
  bottom: 0;
}
.yincang {
  width: 100%;
  display: felx;
  flex-direction: column;
  align-items: center;
  border-top-left-radius: 0.5rem;
  border-top-right-radius: 0.5rem;
  background-color: #fff;
  position: fixed;
  bottom: 0;
  /* opacity: 1; */
  z-index: 10000;
  transition: all 1s;
}

.yincang > .songda {
  width: 100%;
  height: 6vh;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  font-size: 1.6rem;
  color: #282828;
}
.yincang > .songda > img {
  width: 2rem;
  height: 2rem;
  /* margin-right: 2rem; */
}

/* 隐藏的下左侧 */
.yincang > .date {
  width: 100%;
  height: 31vh;
  display: flex;
  flex-direction: row;
  /* align-items: center; */
}
.yincang .date_left {
  width: 40%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  background-color: #f1f1f1;
  color: #A6A6A6;
}
.yincang .date_left > p {
  width: 100%;
  height: 5rem;
  /* background-color: #fff; */
  text-align: center;
  line-height: 5rem;
  /* color: #181818; */
  font-size: 1.6rem;
}
.date_left1{
  color: #181818;
  background-color: #fff;
}

.date_right {
  width: 60%;
  height: 31vh;
  overflow-x: hidden;
  overflow-y: auto;
}
.date_right > ul {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.date_right > ul >li:first-child{
  width: 83%;
  height: 4.9rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #f8f8f8;
  line-height: 4.9rem;
  font-size: 1.6rem;
  /* color: #16A441; */
}
.date_right>ul>li{
  margin-left: 1.5rem;
}
.date_right .link {
  width: 100%;
  height: 4.9rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #f8f8f8;
  line-height: 4.9rem;
  font-size: 1.6rem;
}
.link>img{
  /* display: block; */
  width: 1.8rem;
  height: 1.8rem;
  /* line-height: 1.8rem; */
  margin-right: 4rem;
  background-color: #fff;

}

/* 隐藏的最下侧 */
.date_buttom {
  width: 100%;
  height: 8vh;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.date_buttom > p {
  width: 95%;
  height: 6vh;
  line-height: 6vh;
  font-size: 1.8rem;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #2ac058;
  border-top-left-radius: 3vh;
  border-top-right-radius: 3vh;
  border-bottom-left-radius: 3vh;
  border-bottom-right-radius: 3vh;
}

/* 时间点击后的样式改变 */
.link1{
  color: #21A54A;
  /* font-size:2rem; */
}
</style>