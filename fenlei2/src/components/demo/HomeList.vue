<template>
<div>
        <!-- 整体 -->
    <div id="lieBiao">
        <!--头部  -->
        <div class="listHeader" >
            <!-- 头部第一个内容 -->
            <div class="headerNei1" @click="change('NeiR11')" :class="NeiR=='NeiR11'?'open':''">
                <div class="biaoTi1">
                <p>快捷购物</p>
                <span>猜你喜欢</span>
                </div>
                   <!-- 头部第一个内容结束 -->
            </div><div class="shu">|</div>
            <div class="headerNei2" @click="change('NeiR22')" :class="NeiR=='NeiR22'?'open':''">
                <div class="biaoTi2">
                <p>实时鲜货</p>
                <span>能量加油站</span>
                </div>
            </div><div class="shu">|</div>
            
            <div class="headerNei3" @click="change('NeiR33')" :class="NeiR=='NeiR33'?'open':''">
                <div class="biaoTi2">
                <p>叮咚上新</p>
                <span>买点不一样</span>
                </div>
            </div><div class="shu">|</div>
            <div class="headerNei4" @click="change('NeiR44')" :class="NeiR=='NeiR44'?'open':''">
                 <div class="biaoTi4">
                <p>上班带餐</p>
                <span>轻奢快手菜</span>
                </div>
            </div>
        </div>
        <!-- 头部结束-->
        <!-- 内容一开始 -->
        <div class="NeiR1" v-if="NeiR=='NeiR11'">
                <div class="lieB1">
                        <div>
                            <div v-for="(item,index) in productList" :key="index">
                                <div class="lieB1_top">
                                    <a :href="'http://127.0.0.1:8080/details/'+productList[index].id"><img :src="productList[index].filePaths[p]"></a>
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">{{productList[index].productName}}</p>
                                    <p class="wen2">{{productList[index].productAbout}}</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>¥</span>
                                            {{productList[index].price}}
                                        </div>
                                        <p>¥9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt=""  @click="addcar(index)">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
        </div>
        <!--内容一结束 -->
        <!-- 内容二开始 -->
         <div class="NeiR2" v-else-if="NeiR=='NeiR22'">
                <div class="lieB1">
                        <div>
                            <div v-for="(item,index) in productList1" :key="index">
                                <div class="lieB1_top">
                                    <a :href="'http://127.0.0.1:8080/details/'+productList1[index].id"><img :src="productList1[index].filePaths[p]"></a>
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">{{productList1[index].productName}}</p>
                                    <p class="wen2">{{productList1[index].productAbout}}</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>¥</span>
                                           {{productList1[index].price}}
                                        </div>
                                        <p>¥9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt=""  @click="addcar(index)">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>

        </div>
        <!-- 内容二结束 -->
        <!-- n内容三开始 -->
        <div class="NeiR3" v-else-if="NeiR=='NeiR33'">
   <div class="lieB1">
                        <div>
                            <div v-for="(item,index) in productList2" :key="index">
                                <div class="lieB1_top">
                                    <a :href="'http://127.0.0.1:8080/details/'+productList2[index].id"><img :src="productList2[index].filePaths[p]"></a>
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">{{productList2[index].productName}}</p>
                                    <p class="wen2">{{productList2[index].productAbout}}</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>¥</span>
                                           {{productList2[index].price}}
                                        </div>
                                        <p>¥9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt=""   @click="addcar(index)">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>

        </div>
        <!-- 内容三结束 -->
        <!-- 内容4开始 -->
         <div class="NeiR4" v-else>
                 <div class="lieB1">
                        <div>
                            <div v-for="(item,index) in productList3" :key="index">
                                <div class="lieB1_top">
                                    <a :href="'http://127.0.0.1:8080/details/'+productList3[index].id"><img :src="productList3[index].filePaths[p]"></a>
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">{{productList3[index].productName}}</p>
                                    <p class="wen2">{{productList3[index].productAbout}}</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>¥</span>
                                           {{productList3[index].price}}
                                        </div>
                                        <p>¥9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt=""   @click="addcar(index)">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>

        </div>
               
         
        <!-- 内容4结束 -->
    </div>
        <!-- 整体结束 -->
</div>
</template>
<script>
    export default({
        data(){
            return {
                p:0,
                NeiR:"NeiR11",
                productQuery:{},
                productList:[{}],
                productList1:[{}],
                productList2:[{}],
                productList3:[{}],

            }
        },
        created(){
      this.queryProductList();
      this.queryProductList1();
      this.queryProductList2();
      this.queryProductList3();
    },
        methods:{
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
            queryProductList() {
            this.productQuery.classifyId=109;
            console.log(this.productQuery.classifyId);
            let url = "/server/product/query-list";
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                console.log(res);
                this.productList = res.data;
                console.log("--->> 商品",this.productList);
        })
      }, 
      queryProductList1() {
            this.productQuery={};
            this.productQuery.classifyId=107;
            console.log(this.productQuery.classifyId);
            let url = "/server/product/query-list";
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                console.log(res);
                this.productList1 = res.data;
                console.log("--->> 商品",this.productList1);
        })
      },queryProductList2() {
            this.productQuery={};
            this.productQuery.classifyId=106;
            // console.log(this.productQuery.classifyId);
            let url = "/server/product/query-list";
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                // console.log(res);
                this.productList2 = res.data;
                // console.log("--->> 商品",this.productList1);
        })
      },queryProductList3() {
            this.productQuery={};
            this.productQuery.classifyId=110;
            // console.log(this.productQuery.classifyId);
            let url = "/server/product/query-list";
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                // console.log(res);
                this.productList3 = res.data;
                // console.log("--->> 商品",this.productList1);
        })
      },

            change(nr){
                this.NeiR=nr;
            }
        }
    })
</script>
<style scoped>
#lieBiao{
    margin-top: 1rem;
}
.listHeader{
    width: 100%;
     display: flex;
     justify-content: space-around;
     align-items:center;
     flex-wrap: nowrap;
     margin: -1rem 0rem 1rem;
     /* background-color: beige; */
}
.biaoTi1,.biaoTi2,.biaoTi3,.biaoTi4{
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    width: 25%;    
}
.biaoTi1>p,.biaoTi2>p,.biaoTi3>p,.biaoTi4>p{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 7rem;
    font-size: 1.6rem;
    color: #272727;
    margin-bottom: 0.4rem;
    box-sizing: border-box;
     /* background-color: #2dc053; */
}
.biaoTi1>span,.biaoTi2>span,.biaoTi3>span,.biaoTi4>span{
    display:flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    width: 7.2rem;
    font-size: 1.4rem;
    color: #a0a0a0;
}
.open>div>span{
    display: flex;
    align-items: center;
    /* padding: .2rem .2rem; */
    border-radius: 1.2rem;
    background-color: #2dc053;
    color: #fff;
    
}
.open>div>p{
    color: #23d452;
}
.shu{
    font-size: 1.6rem;
    color: #c2b3b3;
}
.NeiR1{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-content: center;
    width:100%;
    margin-top:1rem ;
    box-sizing: border-box;
    background-color: #f5f5f5;
    padding: 0 1rem;
     /* display: none; */
}
/*  */
.NeiR2{
     display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-content: center;
    width:100%;
    margin-top:1rem ;
    box-sizing: border-box;
    background-color: #f5f5f5;
    padding: 0 1rem;
}
/*  */
/*  */
.NeiR3{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-content: center;
    width:100%;
    margin-top:1rem ;
    box-sizing: border-box;
    background-color: #f5f5f5;
    padding: 0 1rem;
}
/*  */
/*  */
.NeiR4{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
    align-content: center;
    width:100%;
    margin-top:1rem ;
    box-sizing: border-box;
    background-color: #f5f5f5;
    padding: 0 1rem;
    box-sizing: border-box;
}
/*  */
.lieB1{
        width:100%;
        
    }
    .lieB1>div{
        width: 100%;
        background-color: #f5f5f5;  
        display: flex; 
        flex-wrap: wrap;
        justify-content: space-between;
    }
    .lieB1>div>div{
        width: 49%;
        background-color: #fff;
        display: flex;
        justify-content: space-between;
         flex-wrap: wrap;
        flex-direction: column;
        margin-top: 1rem;
    }
    .lieB1_top{
        width: 100%;
    }
    .lieB1_top>a>img{
        width: 100%;
        /* height: ; */
    }
    .lieB1_z{
        display: flex;
        width: 100%;
        flex-direction:column ;
        padding: 0px 1rem;
    }
    .lieB1_z>p:first-child{
        display: block;
        font-size: 1.4rem;
        color: #1a1a1a;
        margin-top: 1rem;
    }
    .lieB1_z>p:last-child{
        display:block;
        width: 50%;
        font-size: 1.2rem;
        color: #afafaf;
        margin-top: .5rem;
         white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .lieB1_btn{
        display: flex;
        width:100%;
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