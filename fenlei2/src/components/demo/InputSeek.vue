<template>
    <div>
            <xitongtwo></xitongtwo>
        <div class="inputseek">
            <img src="../../assets/img/jiantou.png" alt="" @click="switchTo(a)">
            <div>
                <div>
                    <img src="../../assets/img/sousuo.png" alt="">
                </div>
                <input type="text" v-model="n" placeholder="请输入商品名称"> 
            </div>
            <p>搜索</p> 
        </div>
        <div class="search">
            <!-- <a :href="'http://127.0.0.1:8080/details/'+productList[index].id">
                <span>{{productList[index].productName}}</span>
            </a> -->
            <p v-for="(productName,index) of productList" :key="index">
                <a :href="'http://127.0.0.1:8080/details/'+productList[index].id">
                    {{productList[index].productName}}
                </a>
            </p>
        </div>
        <div class="findseek">
            <h2>搜索发现</h2>
            <div>
                <div v-for="(item,index) of classiFy" :key="index" @click="values($event)">
                    {{classiFy[index]}}  
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            n:'',
            a:"/",
            searchText:'',
            productQuery:{},
            productList:[{}],
            classiFy:["土豆","可乐","可爱多","车厘子","小龙虾","鸡爪","南瓜饼","烤羊排","酸奶","卤肉","三只松鼠","鸡蛋"],
        }
    },
    methods:{
        values(e){
            this.n=e.target.innerText;
        },
        switchTo(path){
            // this.$router.replace(path)
            this.$router.push(path)
            // console.log(this.$router.go(-1))
        }
    },
    watch:{
        n(){
            this.productQuery.productName = this.n;
            // console.log(tthis.productQuery.productName);
            let url = "/server/product/query-list"
            this.axios.get(url, {params: this.productQuery}).then((res) => {
                console.log(res);
                this.productList = res.data;
                console.log("--->> 商品",this.productList);
            })
        }
    }
}
</script>
<style scoped>
    .inputseek{
        width: 100%;
        padding: 0px 20px 0px 20px;
        display: flex;
        align-items: center ;
        box-sizing: border-box;
    }
    .inputseek>img{
        width:18px;
        height: 18px;
    }
    .inputseek>p{
        
        font-size: 1.6rem;
        color: #81838f;
    }
    .inputseek>div{
        display: flex;
        margin: 0px 10px 0px 10px;
        width: 81.3%;
    }
    .inputseek>div>div{
        width:40px;
        height:34px;
        border:1px solid #f8f7f7;
        background-color: #f6f5f5;
        border-radius: 16px 0px 0px 16px;
        box-sizing: border-box;
        display: flex;
        justify-content: center;
        align-items: center;
        padding-left: 5px;
    }
    .inputseek>div>div>img{
        width: 15px;
        height: 15px;
    }
    .inputseek>div>input{
        width:100%;
        height:34px;
        border-radius: 0px 16px 16px 0px;
        background-color: #f6f5f5;
        border:1px solid #f8f7f7;
        /* padding: 0px 20px ; */
        box-sizing: border-box;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor:pointer;
        outline:none;
    }
    .search{
        margin-left: 9rem;
        z-index: 100;
    }
    .search p{
        width: 25rem;
        font-size: 1.5rem;
        margin: 1rem 0;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .search p>a{
        color: #333;
    }
    .findseek{
        margin-top: 40px;
        padding: 0px 20px 0px 20px;
    }
    .findseek h2{
        font-size: 1.6rem;
        color: #282828;
        font-weight:800;
    }
    .findseek>div>div{
        font-size: 1.4rem;
        padding: 10px 16px ;  
        background-color: #f5f5f5;  
        color: #707070;
        border-radius: 4px;
        display:inline-block;
        margin-top: 14px;
        margin-right: 8px;
    }
</style>