<template>
    <div class="addremark">
        <xitongtwo></xitongtwo>
        <div class="addremark_top">
            <div class="addremark_top_l">
                <img src="../../assets/img/jiantou.png" alt="">
                <p>添加备注</p>
            </div>
            <div class="addremark_top_r">
                <p>完成</p>
            </div>
        </div>
        <div class="addremark_z">
            <input type="text" name="" placeholder="在这里填写您的备注信息" v-model="a">
        </div>
        <div class="addremark_btn">
            <p v-for="(item,index) of val" :key="index" @click="values($event)">
                <span>{{val[index]}}</span>
            </p>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            a:"",
            val:["请不要敲门,到了后打电话","如果没人防门口"]
        }
    },
    methods:{
        values(e){
            this.a+=e.target.innerHTML;
        }
    }
}
</script>
<style scoped>
    .addremark_top{
        display: flex;
        justify-content: space-between;
        padding: 0px 1rem;
    }
    .addremark_top_l{
        display: flex;
        align-items: center;
    }
    .addremark_top_l>p{
        font-size: 1.8rem;
        color: #333;
    }
    .addremark_top_l>img{
        width: 1.6rem;
        height: 1.6rem;
        margin-right: 2rem;
    }
    .addremark_top_r{
        font-size: 1.6rem;
        color: #48a264;
    }
    .addremark_z>input{
        border-bottom: 0rem solid #cdcdcd;
        font-size: 1.4rem;
        height: 10rem;
    }
    .addremark_btn{
        display: flex;
        padding: 0px 1rem;
    }
    .addremark_btn>p{
        padding: .5rem;
        border:.1rem solid #cdcdcd;
        font-size: 1.4rem;
        color: #8a8a8a;
        border-radius: 1.5rem;
        margin-right: 1rem;
    }
</style>