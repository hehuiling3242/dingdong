<template>
    <div id="app">
        <div class="sale">
            <table></table>
            <div class="hotsale">
                <div class="hotsale_top">
                    <p>猜你喜欢</p>
                </div>
                <div class="hotsale_btn"  >
                    <div class="lieB1" v-for="(item,index) in content" :key="index">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <a class="shopTu1" :href="'http://127.0.0.1:8080/details/'+productList[index].id">
                                        <img :src="productList[index].filePaths[0]" alt="">
                                    </a>
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">{{productList[index].productName}}</p>
                                    <p class="wen2">{{productList[index].productAbout}}</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>¥</span>
                                            {{productList[index].price.toFixed(2)}}
                                        </div>
                                        <p>¥9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r"  @click="addcar(index)">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                </div>
                    <table></table>
            </div>
        <table></table>   
        </div> 
    </div>
</template>
<script>
export default {
    data(){
        return{
            content:20,
            productQuery:{},
            productList:[{}],
            filePaths:[],
            a:1
        }
    },
    created(){
        this.queryProductList();
    },
    methods:{
        queryProductList() {
            this.productQuery.productShow = 1;
            // console.log(this.productQuery.productShow);
            let url = "/server/product/query-list"
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                console.log(res);
                this.productList = res.data;
                console.log("--->> 促销商品",this.productList);
            })
        },
        addcar(index) {
            var obj = this.productList[index];
            this.itemAll = [];
            this.$store.state.shoplist.forEach((item) => {
                this.itemAll.push(item.id);
            });
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
    .wen2,.wen1{
        width:100%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .sale{
        background-color: #f0f0f0;
        width: 100%;
        margin-bottom: 34.8px;
    }
    .hotsale{
        width: 100%;
        background-color: #f0f0f0;
        padding: 0px 1rem;
    }
    .hotsale_top{
        width: 100%;
        border-top: 1px solid #dcdcdc;
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
        margin: 24px 0px;
        background-color: #f5f5f5;
    }
    .hotsale_top>p{
        position: absolute;
        top:-8px;
        background-color: #f0f0f0;
        padding: 0px 1rem;
        font-size: 1.6rem;
        letter-spacing:.1rem;
    }
    .hotsale_btn{
        width: 100%;
        margin: 1rem 0px;
        display: flex;
        justify-content: space-between;
        /* flex-direction:row; */
        flex-wrap:wrap;
    }
    .lieB1{
        width: 49%;
        border-radius: .6rem;
        overflow: hidden;
        margin-bottom: 1rem;
    }
    .lieB1>div{
        width: 100%;
        background-color: #f5f5f5;
        /* padding: 1rem; */
    }
    .lieB1>div>div{
        width: 100%;
        background-color: #fff;
        /* padding: 1rem; */
    }
    .lieB1_top{
        width: 100%;
    }
    .lieB1_top img{
        width: 100%;
    }
    .lieB1_z{
        padding: 0px 1rem;
    }
    .lieB1_z>p:first-child{
        font-size: 1.4rem;
        color: #1a1a1a;
        margin-top: 1rem;
    }
    .lieB1_z>p:last-child{
        font-size: 1.2rem;
        color: #afafaf;
        margin-top: .5rem;
    }
    .lieB1_btn{
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin: 1rem 0px 1rem;   
        padding: 0px 1rem;
    }
    .lieB1_btn_l{
        display: flex;
        align-items: center;
    }
    .lieB1_btn_l>div:first-child{
        font-size: 1.8rem;
        color: #e95960;
        font-weight:600;
    }
    .lieB1_btn_l>div:first-child>span{
        font-size: 1.2rem;
        color: #e95960;
        margin-right: -0.5rem;
    }
    .lieB1_btn_l>p{
        text-decoration: line-through;
        font-size: 1.4rem;
        color: #bcbcbc;
    }
    .lieB1_btn_r{
        width: 2.8rem;
        height: 2.8rem;
        background: linear-gradient(#4ad278,#33b05d);
        border-radius: 1.4rem;
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        /* margin: -0.5rem 0 0 7rem; */
    }
    .lieB1_btn_r>img{
        width: 1.6rem;
        height: 1.6rem;
    }
</style>