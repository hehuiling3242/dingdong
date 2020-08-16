<template>
    <div class="homenew">
        <table></table>
        <div class="homenew_top">
            <div class="homenew_top_l">
                <h2>新人尝鲜价</h2>
                <p>限量供应,抢完为止</p>
            </div>
            <div class="homenew_top_r">
                <p>查看更多></p>
            </div>
        </div>
        <div class="homenew_btn">
            <div class="sliding_box">
                    <!-- {{this.$store.state.shoplist[0].productName}} -->
                <div class="sliding_item" v-for="(item,index) in content" :key="index">
                    <div class="sliding_item_img">
                        <a :href="'http://127.0.0.1:8080/details/'+productList[index].id">
                            <img :src="productList[index].filePaths[0]" alt="">
                        </a>
                        <!-- <img :src="productList[index].filePaths[0]" alt=""> -->
                        <p>{{productList[index].productName}}</p>
                        <div class="sliding_item_btn">
                            <div class="sliding_item_btn_l">
                                <div><span>¥</span>{{productList[index].price.toFixed(2)}}</div>
                                <p>6.90</p>
                            </div>
                            <div class="sliding_item_btn_r"   @click="addcar(index)">
                                <img src="../../assets/img/gouwuche.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table></table>
    </div>
</template>
<script>
export default {
    data(){
        return{
            // a:1,
            content: 10,
            productQuery:{},
            productList:[{}],
            filePaths:[]
        }
    },
    created(){
        this.queryProductList();
    },
    methods:{
        queryProductList() {
            this.productQuery.productShow = 0;
            // console.log(this.productQuery.productShow);
            let url = "/server/product/query-list"
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                console.log(res);
                this.productList = res.data;
                // console.log("--->> 商品",this.productList);
            })
        },
        addcar(index) {
            var obj = this.productList[index];
            this.itemAll = [];
            this.$store.state.shoplist.forEach((item) => {
                this.itemAll.push(item.id);
            });
            var id=sessionStorage.getItem("id")
            console.log(id)
            if(id==null){
                console.log("您未登录");
                this.$router.replace("/login");
                return;
            }else{
                console.log("登录成功")
            }
            if (this.itemAll.indexOf(obj.id) == -1) {
                obj.count = 1;
                this.$store.commit("add_car_mutations", obj);
            } else {
                var i = this.itemAll.indexOf(obj.id);
                this.$store.commit("add_car_count", i);
            }
        },
    }
}
</script>
<style scoped>
    ::-webkit-scrollbar { /*滚动条整体样式*/
        width: 0px; /*宽分别对应竖滚动条的尺寸*/
        height: 0px; /*高分别对应横滚动条的尺寸*/
    }
    .homenew{
        /* background: url("../../assets/img/home_bgc.png") no-repeat; */
        padding: .5px 1rem .5px 1rem;
        /* margin: 1.4rem 0rem; */
        /* height: 500px; */
        box-sizing: border-box;
    }
    .homenew_top{
        display: flex;
        justify-content: space-between;
        color: #fff;
        margin: 1rem 0px 1rem 0px;
    }
    .homenew_top_l{
        display: flex;
        align-items:flex-end
    }
    .homenew_top_l>h2{
        font-size: 1.8rem;
        font-weight:800;
        letter-spacing:.1rem;
        margin-right: .5rem;
    }
    .homenew_top_l>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .homenew_top_r{
        display: flex;
        align-items:flex-end
    }
    .homenew_top_r>p{
        font-size: 1.4rem;
        letter-spacing:.1rem;
    }
    .sliding_box{
        display: flex;
        overflow-y: hidden;
        overflow-x: scroll;
        background-color: #fff;
        border-radius: .6rem;
        margin-bottom: .8rem;
        /* overflow-y: scroll; */
        /* overflow:hidden */
    }
    .sliding_item{
        display: flex;
        margin-right: .8rem;
        /* background-color: #CDCDCD; */
        border-radius: .6rem;
    }
    .sliding_item_img {
        width: 11.5rem;
        height: 20rem;
        border-radius: .6rem;
        display: flex;
        flex-direction: column;
        align-items:center;
        /* justify-content: center; */
    }
    .sliding_item_img img{
        margin: 1.5rem 0px 1.5rem;
        width: 9rem;
        height: 9rem;
    }
    .sliding_item_btn{
        display: flex;
        margin-top: 2.6rem;
        align-items:center;
    }
    .sliding_item_img p{
        width: 100%;
        font-size: 1.4rem;
        color: #393939;
        font-weight:800;
        white-space:nowrap;
        overflow:hidden;
        text-overflow:ellipsis;
        text-align: center;
        /* display: flex; */
        /* align-items: center; */
    }
    .sliding_item_btn_l{
        margin-right: 2rem;
    }
    .sliding_item_btn_l>div{
        font-size: 1.4rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .sliding_item_btn_l>div>span{
        font-size: .6rem;
        color: #ff3e3d;
        font-weight:800;
    }
    .sliding_item_btn_l>p{
        font-size: 1.2rem;
        color: #b4b4b4;
        /* font-weight:800; */
        /* text-decoration:none */
        text-decoration:line-through;
    }
    .sliding_item_btn_r{
        width: 2.8rem;
        height: 2.8rem;
        background: linear-gradient(#4ad278, #33b05d);
        border-radius: 1.4rem;
        display: flex;
        justify-content:center;
        align-items: center;
    }
    .sliding_item_btn_r>img{
        width: 1.6rem;
        height: 1.6rem;
    }
</style>