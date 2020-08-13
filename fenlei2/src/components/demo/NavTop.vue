<template>
    <div class="nav">
    <table></table>
        <div class="nav_div" >
            <div class="nav_div_l" @click="switchTo(a)">
                <img src="../../assets/img/dingwei.png" alt="" class="nav_div_l_img1">
                <p>钱江新城</p>
                <span class="nav_span">丰谭站</span>
                <img src="../../assets/img/daosanjiao.png" alt=""
                class="nav_div_l_img2">
            </div>
            <div class="nav_div_r">
                <img src="../../assets/img/tongzhi.png" alt="">
            </div>
        </div>
    <table></table>
    </div>    
</template>
<script>
export default {
    data(){
        return {
            a:"/navigation",
            // a:"/"
        }
    },
    
    methods:{
        switchTo(path){
        // console.log(this.$router)
            this.$router.replace(path)
        },
    }   
}
</script>
<style  scoped>

    .nav_div{
        padding:1rem 1rem;
        display: flex;
        align-items:center;
        justify-content: space-between;
    }
    .nav_div_l{
        display: flex;
        align-items:center;
    }
    .nav_div_l>p{
        color:#fff;
        font-size: 1.6rem;
        font-weight: bolder;
        margin-right: 0.5rem;
        font-weight:500;
    }
    .nav_div_l>span{
        color:#eee;
        background-color: rgba(0, 0, 0, 0.2);
        padding: 0rem 0.3rem;
        font-size: 1rem;
        line-height: 2.1rem;
        margin-left: 0.5rem;
        border-radius: 2px;
    }
    .nav_div_l_img1{
        margin-right: 10px;
        width: 1.8rem;
        height: 1.8rem;
    }
    .nav_div_l_img2{
        margin-left: 10px;
        margin-right: 10px;
        width: .8rem;
        height: .4rem;
    }

</style>
    
