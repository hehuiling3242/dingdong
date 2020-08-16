<template>
  <div class="content">
    <div class="right" ref="right">
      <div v-for="(item,index) of fenlei" :key="index">
        <div class="shangp2">
          <div class="tuijian1">
            <div>
              <p>{{fenlei[index].label}}</p>
              <div>
                <p>销量</p>
                <p>价格</p>
              </div>
            </div>

            <div class="img">
              <img src="../../assets/img/shangjiantou.png" />
              <img src="../../assets/img/xiajiantou.png" />
            </div>
          </div>
          <div class="shangp" v-for="(item1,index1) of list[index]" :key="index1">
            <div class="shangp1">
              <img :src="item1.filePaths[0]" />
              <div class="details">
                <p class="title">{{item1.productName}}</p>
                <p class="jieshao">{{item1.productAbout}}</p>
                <p class="huod">专区满21元赠豆腐</p>
                <div class="pri">
                  <p class="price">
                    <em>¥</em>
                    <b>{{`¥${item1.price}`}}</b>
                  </p>
                  <div class="gouwuc" @click="addcar(index1)">
                    <img src="../../assets/img/gouwu.png" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "listGoods",
  data() {
    return {
      list: [],
      itemAll: [],
      productQuery: {},
      //存储商品详细的数据
      // list:5,
      n: -1,
      // list1:17,
      //存储分类表中的内容
      fenlei: [
        { id: 101, label: "蔬菜豆制品" },
        { id: 102, label: "新鲜水果" },
        { id: 103, label: "肉禽蛋品" },
        { id: 104, label: "海鲜水产" },
        { id: 105, label: "快手菜" },
        { id: 106, label: "乳品烘焙" },
        { id: 107, label: "冰淇淋" },
        { id: 108, label: "营养早餐" },
        { id: 109, label: "熟食卤味" },
        { id: 110, label: "速食冻品" },
        { id: 111, label: "粮油调味" },
        { id: 112, label: "酒饮零食" },
        { id: 113, label: "厨房用品" },
      ],
      //存储滚动位置的
      move: [],
    };
  },
  created() {
    this.queryProductList();
  },
  methods: {
    queryProductList() {
      let url = "/server/product/query-list";
      this.axios.get(url).then((res) => {
        var list = res.data;
        for (var i = 0; i < 13; i++) {
          this.list.push([]);
        }
        for (var item of list) {
          var i = item.classifyId - 101;
          this.list[i].push(item);
        }
        this.move[0]=0;
        for (var i = 1; i < 13; i++) {
          this.move.push(this.move[i-1]+this.list[i-1].length*140+45);
        }
        console.log(this.move);
      });
    },
    addcar(index) {
      var obj = this.list[index];
      this.itemAll = [];
      this.$store.state.shoplist.forEach((item) => {
        this.itemAll.push(item.id);
      });
      var id = sessionStorage.getItem("id");
      console.log(id);
      if (id == null) {
        console.log("您未登录");
        this.$router.replace("/login");
      } else {
        console.log("登录成功");
      }
      if (this.itemAll.indexOf(obj.id) == -1) {
        obj.count = 1;
        this.$store.commit("add_car_mutations", obj);
      } else {
        var i = this.itemAll.indexOf(obj.id);
        this.$store.commit("add_car_count", i);
      }
    },
  },
  watch: {},
  mounted() {
    //   this.mt=this.$refs.right.offsetHeight;
    //   console.log(this.n);

    this.$refs.right.onscroll = () => {
      this.sctop = this.$refs.right.scrollTop;
      for (var i = 0; i < this.move.length; i++) {
        if (this.sctop >= this.move[i] && this.sctop < this.move[i + 1]) {
          this.$parent.$refs.listgoods.greens(i, 1);
        }
      }
    };
  },
};
</script>
<style scoped>
.content {
  display: flex;
  flex-wrap: wrap;
  width: 75%;
}
.content .right {
  width: 100%;
  /* background-color: #f4f4f4; */
  height: 100vh;
  color: #848484;
  overflow-y: auto;
  overflow-x: hidden;
  -webkit-overflow-scrolling: touch;
  /* float: left;
       top: 0;
       left: 10.35rem; */
}

/* 右侧上方推荐栏设置 */
.content .tuijian {
  width: 68%;
  height: 4.4rem;
  display: flex;
  background-color: #fff;
  flex-direction: row;
  align-items: center;
  flex-wrap: nowrap;
  justify-content: space-between;
  line-height: 4.4rem;
  text-align: center;
  margin: 0 0;
  border-bottom: 1px solid #e1e1e1;
  border-collapse: collapse;
  font-size: 1.3rem;
  position: fixed;
  top: 0;
  left: 28.5%;
  z-index: 9999;
}
.content .tuijian1 {
  width: 90%;
  height: 4.4rem;
  display: flex;
  background-color: #fff;
  flex-direction: row;
  align-items: center;
  flex-wrap: nowrap;
  justify-content: space-between;

  /* line-height: 4.4rem; */
  /* text-align: center; */
  margin: 0 auto;
  border-bottom: 1px solid #e1e1e1;
  border-collapse: collapse;
  font-size: 1.3rem;
  /* flex-wrap:nowrap */
  /* position:fixed;
       top: 0;
       left: 28%;
       z-index: 9999; */
}
.tuijian1 > div:first-child {
  display: flex;
  width: 90%;
  justify-content: space-between;
}
.tuijian1 > div > div {
  display: flex;
}
.tuijian1 > div > div > p:first-child {
  margin-right: 1rem;
}
/* .content .tuijian1 P:nth-child(2){
       margin: 0 0 0 15rem;
    }
    .content .tuijian P:nth-child(2){
       margin: 0 0 0 15rem;
    } */

/* 推荐栏最右侧图标设置 */
.img {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

/* 商品总览 */
.shangp {
  width: 95%;
  display: flex;
  justify-content: flex-end;
}
.content .shangp1 {
  width: 95%;
  height: 14rem;
  display: flex;
  /* border-top:1px solid #e1e1e1; */
  border-bottom: 1px solid #e1e1e1;
  justify-content: flex-end;
  /* flex-wrap: wrap */
  /* align-items:flex-end; */
}
.shangp1 > img {
  width: 10rem;
  height: 10rem;
}
/* .shangp2{
       margin-top: 4.4rem;
    } */
.shangp2 {
  display: flex;
  flex-direction: column;
  /* justify-content: center; */
  /* align-self: center; */
  justify-content: center;
  /* margin: 0 auto; */
}
/* 商品详情 */
.details {
  position: relative;
}
.shangp1 > .details {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  align-content: space-around;
}
.details > .title {
  font-size: 1.6rem;
  color: #292929;
  margin: 1rem 0 0 0;
}
.details > .jieshao {
  font-size: 1.4rem;
  color: #a0a0a0;
  padding: 0.5rem 0 0 0;
  /* align-self: flex-end;
       flex-wrap: wrap; */
}
.details > .huod {
  font-size: 1.2rem;
  background-color: #fef3f7;
  color: #f18c95;
  padding: 0.5rem 0.5rem;
  border-radius: 0.2rem;
  margin-top: 1rem;
}
/* .details .price{
       padding: 1rem 0 0 0;
    } */
.details .price > em {
  display: inline-block;
  color: #fa657e;
  font-style: normal;
  font-size: 1rem;
}
.details .price > span {
  display: inline-block;
  color: #fa657e;
  font-size: 1.9rem;
}

/* 购物车 */
.pri {
  display: flex;
  align-items: center;
  width: 100%;
  justify-content: space-between;
  /* justify-content: center; */
  /* flex-direction: ; */
}
.details .gouwuc {
  /* position: absolute; */
  width: 2.8rem;
  height: 2.8rem;
  background: linear-gradient(#4ad278, #33b05d);
  border-radius: 50%;
  /* right: 0;
       top: 9.5rem; */
  display: flex;
  justify-content: center;
  align-items: center;
}
.details .gouwuc img {
  width: 1.6rem;
  height: 1.6rem;
  /* padding: 0.5rem 0.2rem 0 0; */
}
</style>