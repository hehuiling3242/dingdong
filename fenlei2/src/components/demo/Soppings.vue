<template>
  <div class="Soppings">
    <div class="Soppings_title">
      <div>
        <p>购物车</p>
      </div>
      <div>
        <span @click="delet">删除</span>
      </div>
    </div>
    <div class="Soppings_body">
      <div v-show="shop_none">
        <img src="../../assets/img/timg.jpg" alt />
      </div>
      <div v-show="shop_none">
        <button @click="junmp_SY">去逛逛</button>
      </div>
      <div v-for="(products,sub) of shoplist" :key="sub" class="lastSopp">
        <div>
          <input type="checkbox" v-model="isAgress[sub]" @click="Check($event,sub)" class="item" />
          <label for="item"></label>
          <img src="../../assets/img/shuiguo.jpg" alt />
        </div>
        <div>
          <p>{{products.sp_name}}</p>
          <ul class="lastSopp_smalltitle">
            <li>新人尝鲜</li>
            <li>限购99件</li>
          </ul>
          <p>
            {{`¥${products.sp_price}`}}
            <span>/份</span>
          </p>
        </div>
        <div>
          <button @click="delet1(sub)">-</button>
          <span>{{products.count}}</span>
          <button @click="adds(sub)">+</button>
        </div>
      </div>
    </div>
    <div class="ceshi">
      <div v-for="(shop,index) of shopAll" :key="index">
        <img src="../../assets/img/shuiguo.jpg" alt />
        <p>{{shop.sp_name}}</p>
        <p>{{`¥${shop.sp_price}`}}</p>
        <img src="../../assets/img/gouwu.png" @click="addcar(index)" />
      </div>
    </div>
    <div></div>
    <div class="Soppings_alert" v-show="deletSopp">
      <div>
        <div>
          <p>确认删除勾选商品吗?</p>
        </div>
        <div>
          <span @click="deletSopp_quit">取消</span>
          <span style="border-left: 1px solid #eee;" @click="deletSopp_true">确定</span>
        </div>
      </div>
    </div>
    <div class="Soppings_Price" v-show="priceSum">
      <div>
        <div>
          <p class="Checkitem">
            <input type="checkbox" v-model="checkedall" @click="checkedAll" class="itemAll" />
            <label for="itemAll"></label>
            <span>全选</span>
          </p>
        </div>
        <div>
          <div>
            <p>
              合计
              <span>{{`¥${parseFloat(Sprice).toFixed(2)}`}}</span>
            </p>
            <p>已免配送费</p>
          </div>
          <button @click="say">{{`去结算(${priceage})`}}</button>
        </div>
      </div>
    </div>
    <div class="Soppings_alert" v-show="deletSopp2">
      <div>
        <div>
          <p>确认删除该商品吗?</p>
        </div>
        <div>
          <span @click="deletSopp2_quit1">取消</span>
          <span style="border-left: 1px solid #eee;" @click="deletSopp_true2">确定</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    delet() {
      this.deletSopp = true;
      //点击删除按钮跳出删除所有商品的框
    },
    deletSopp_quit() {
      this.deletSopp = false;
      //取消按钮。弹出框消失
    },
    deletSopp_true() {
      //点击确定，删除所有商品的框框按钮
      this.shoplist = [];
      this.priceage = 0;
      //商品个数为0
      this.priceSum = false;
      //结算框隐藏
      //价格为0
      (this.shop_none = true), (this.deletSopp = false);
      //购物车大图显示，取消弹窗
      console.log("已跳转到购物车");
    },
    deletSopp2_quit1() {
      this.deletSopp2 = false;
      //点击取消按钮，取消删除单个商品的框
    },
    deletSopp_true2() {
      //点击确定，删除购物车中单个商品
      //从获取到商品的位置，删除一位
      this.shoplist.splice(this.Index, 1);
      this.deletSopp2 = false;
      //弹窗消息
      if (this.shoplist.length == 0) {
        //如果数组的长度为0，就直接调用全部删除的按钮
        this.deletSopp_true();
      }
      this.priceage--;
      //当前的商品数量-1；
      console.log(`下标${this.Index}已删除`);
    },
    junmp_SY() {
      this.$router.push("/");
      //跳转首页
    },
    addcar(index) {
      this.shop_none = false; //购物车大图消失
      this.priceSum = true; //价格结算框显示
      if (this.shoplist.indexOf(this.shopAll[index]) == -1) {
        this.isAgress.push(true);
        //如果当前商品的位置返回-1说明不存在，name在新数组末尾添加该数组
        this.shoplist.push(this.shopAll[index]);
        this.shoplist[this.shoplist.length - 1].count = 1;
        //找到这个商品中[长度-1的位置]的数量为1
        //商品数量++
        this.priceage++;
      } else {
        this.priceage++;
        //否则这个商品的数量自增
        var i = this.shoplist.indexOf(this.shopAll[index]);
        this.shoplist[i].count++;
        //总价+=当前商品的价格
      }
    },
    delet1(sub) {
      //减少当前购物车清单中的商品数量
      //如果当前商品的数量<2
      if (this.isAgress[sub] == true) {
        if (this.shoplist[sub].count < 2) {
          // this.myindex=pp;
          //获取当前商品的位置
          this.Index = this.shoplist.indexOf(this.shoplist[sub]);
          //并弹出删除框选项
          this.deletSopp2 = true;
          this.myindex = sub;
        } else {
          //否则这个商品的数量--，数量--，价格--
          this.shoplist[sub].count--;
          this.priceage--;
        }
      }
    },
    adds(sub) {
      //点击加号怎么增加当前商品总价，总个数和个数
      if (this.isAgress[sub] == true) {
        this.priceage++;
        this.shoplist[sub].count++;
      }
    },
    Check(e, sub) {
      this.Agressindex = sub;
      if (e.target.checked !== true) {
        this.priceage -= this.shoplist[sub].count;
      } else {
        this.priceage += this.shoplist[sub].count;
      }
      console.log(this.isAgress);
    },
    checkedAll() {
      for (var key in this.isAgress) {
        if (this.checkedall == true) {
          this.isAgress[key] = false;
          this.priceage = 0;
          this.Sprice = 0;
        } else {
          this.isAgress[key] = true;
          this.Sprice = 0;
          this.priceage = 0;
          for (var key in this.shoplist) {
            this.Sprice +=
              this.shoplist[key].sp_price *
              this.shoplist[key].count *
              this.isAgress[key];
            this.priceage += this.shoplist[key].count;
          }
        }
      }
    },
    say() {
      console.log(this.shoplist);
    },
  },

  data() {
    return {
      count: 1,
      myindex: -1,
      Index: "",
      deletSopp: false,
      deletSopp2: false,
      shop_none: true,
      shopAll: [],
      shoplist: [],
      priceSum: false,
      priceage: 0,
      isAgress: [],
      checkedall: true,
      Agressindex: -1,
      Sprice: 0,
    };
  },
  mounted() {
    this.axios.get("/Soppings").then((result) => {
      this.shopAll = result.data.result;
    });
  },
  computed: {},
  watch: {
    priceage() {
      setTimeout(() => {
        this.Sprice = 0;
        for (var key in this.shoplist) {
          this.Sprice +=
            this.shoplist[key].sp_price *
            this.shoplist[key].count *
            this.isAgress[key];
          console.log(this.isAgress[key]);
        }
      }, 200);
    },
    isAgress() {
      this.checkedall = true;
      for (var elem of this.isAgress) {
        if (elem == false) {
          this.checkedall = false;
          break;
        }
      }
    },
    // this.axios.get('/cart?uid='+this.uid).then(result=>{
    //   if(result.data.code!==0){
    //     this.shoplist=result.data.result;
    //   }
    // })
  },
};
</script>
<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.Soppings_title {
  padding: 10px 15px;
  display: flex;
}
.Soppings_title > div:first-child {
  display: flex;
  width: 100%;
  justify-content: center;
  font-size: 20px;
  font-weight: 600;
  text-indent: 50px;
}
.Soppings_title > div:last-child {
  float: right;
  justify-content: flex-end;
}
.Soppings_title > div:last-child > span {
  font-size: 16px;
  color: #666;
  display: inline-block;
  width: 32px;
  text-align: right;
}
.Soppings_alert {
  height: 100vh;
  width: 100%;
  z-index: 999;
  position: fixed;
  top: 0px;
  left: 0px;
}
.Soppings_alert > div {
  width: 260px;
  height: 80px;
  background: #999;
  position: fixed;
  top: 37%;
  left: 50%;
  margin-left: -130px;
  border-radius: 16px;
}
.Soppings_alert > div > div:first-child {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50%;
  border-bottom: 1px solid #eee;
}
.Soppings_alert > div > div > p {
  font-size: 18px;
  font-weight: 600;
}
.Soppings_alert > div > div:last-child {
  display: flex;
  justify-content: space-around;
  align-items: center;
  height: 50%;
}
.Soppings_alert > div > div:last-child > span {
  display: inline-block;
  width: 100%;
  height: 100%;
  text-align: center;
  line-height: 40px;
}
.Soppings_body {
  padding: 1rem 0;
  position: relative;
  background-color: #f5f6f7;
}
.Soppings_body > div:first-child > img {
  width: 100%;
  height: 100%;
}
.Soppings_body > :nth-child(2) {
  text-align: center;
  position: absolute;
  left: 50%;
  bottom: 3rem;
  margin-left: -7.5rem;
}
.Soppings_body > :nth-child(2) > button {
  width: 15rem;
  height: 5rem;
  border-radius: 16px;
  outline: none;
  border: 1px solid #f8f7f7;
  color: #fff;
  background-color: green;
}
.ceshi {
  /* width: 100%; */
  display: flex;
}
.ceshi > div > img {
  width: 80%;
}
.ceshi > div > :last-child {
  width: 15px;
  height: 15px;
}
.Soppings_body > .lastSopp {
  display: flex;
  justify-content: flex-start;
  padding: 1rem;
  background-color: #fff;
}
.lastSopp {
  margin-bottom: 10px;
}
.Soppings_body > :last-child {
  margin-bottom: 0;
}
.Soppings_body > .lastSopp > div {
  width: 50%;
}

.Soppings_body > .lastSopp > div > p:first-child {
  font-size: 15px;
}
.Soppings_body > .lastSopp > div > img {
  width: 65%;
}
.Soppings_Price {
  width: 100%;
  position: fixed;
  bottom: 5.9rem;
}
.Soppings_Price > div {
  width: 100%;
  display: flex;
  background-color: #fff;
  padding: 1rem 1rem;
}
.Soppings_Price > div > div:first-child {
  width: 25%;
  font-size: 1.6rem;
  align-self: center;
  position: relative;
}
.Soppings_Price > div > div:last-child {
  width: 80%;
  display: flex;
  justify-content: flex-end;
}
.Soppings_Price > div > div:last-child > div span {
  color: rgba(255, 0, 0, 0.7);
  padding: 0 0.3rem;
  letter-spacing: 0.1rem;
  font-size: 1.8rem;
  font-weight: 600;
}
.Soppings_Price > div > div:last-child > div>p{
  font-size: 1.6rem;
}
.Soppings_Price > div > div:last-child > div>p:last-child{
  font-size: 1.4rem;
  color: rgba(0, 0, 0, 0.6);
}
.Soppings_Price > div > div:last-child > div {
  margin-right: 0.5rem;
  text-align: right;
  font-size: 14px;
}
.Soppings_Price > div > div:last-child button {
  width: 7rem;
  height: 3rem;
  border-radius: 1.6rem;
  outline: none;
  border: 1px solid #f8f7f7;
  background-color: red;
  color: #fff;
}
.Soppings_body > .lastSopp > div:first-child {
  position: relative;
  align-self: center;
  text-align: center;
}
.item {
  width: 2rem;
  height: 2rem;
  opacity: 0;
  position: absolute;
  left: 0rem;
  top: 50%;
  margin-top: -0.8rem;
  z-index: 100;
}
label {
  position: absolute;
  left: 0rem;
  top: 50%;
  width: 1.6rem;
  height: 1.6rem;
  border-radius: 50%;
  border: 0.1rem solid #999;
  margin-top: -0.8rem;
}
.item:checked + label {
  background-color: hsl(143, 73%, 54%);
  border: 1px solid hsl(143, 73%, 54%);
}
.item:checked + label::after {
  position: absolute;
  content: "";
  width: 5px;
  height: 10px;
  top: 1px;
  left: 5px;
  border: 2px solid #fff;
  border-top: none;
  border-left: none;
  transform: rotate(45deg);
}
.itemAll {
  width: 2rem;
  height: 2rem;
  opacity: 0;
  position: absolute;
  left: 0rem;
  top: 50%;
  margin-top: -0.8rem;
  z-index: 100;
}
.Checkitem{
  padding: 0 2rem;
}
.itemAll:checked + label {
  background-color: hsl(143, 73%, 54%);
  border: 1px solid hsl(143, 73%, 54%);
}
.itemAll:checked + label::after {
  position: absolute;
  content: "";
  width: 5px;
  height: 10px;
  top: 1px;
  left: 5px;
  border: 2px solid #fff;
  border-top: none;
  border-left: none;
  transform: rotate(45deg);
}
.Soppings_body > .lastSopp > div:last-child {
  align-self: flex-end;
  text-align: right;
}
.Soppings_body > .lastSopp > div:last-child > button {
  display: inline-block;
  background-color: #fff;
  outline: none;
  border: 0.1rem solid #fff;
  width: 2rem;
  height: 2rem;
  font-size: 1.8rem;
}
.Soppings_body > .lastSopp > div:last-child > span {
  display: inline-block;
  background-color: rgba(0, 0, 0, 0.05);
  width: 4rem;
  height: 2rem;
  text-align: center;
  line-height: 2rem;
  border-radius: 0.4rem;
}
.lastSopp > :nth-child(2) {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.lastSopp_smalltitle {
  display: flex;
}
.lastSopp_smalltitle > li {
  background-color: rgba(255, 0, 0, 0.2);
  margin-right: 0.5rem;
  padding: 0.1rem;
  border-radius: 0.4rem;
  color: rgba(255, 0, 0, 0.6);
  width: 5.2rem;
  height: 1.6rem;
  text-align: center;
}
.Soppings_body > .lastSopp > div > p:last-child {
  font-size: 1.4rem;
  font-weight: 600;
  color: rgba(255, 0, 0, 0.7);
}
.Soppings_body > .lastSopp > div > p:last-child > span {
  color: rgba(0, 0, 0, 0.2);
}
</style>