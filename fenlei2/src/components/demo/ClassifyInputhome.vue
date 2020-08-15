<template>
    <div class="classifyinput">
        
       <div @click="switchTo(a)">
           <img src="../../assets/img/sousuo.png" alt="">
           <p>牛奶</p>
       </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            a:"/inputseekhome"
        }
    },
    methods:{
        switchTo(path){
        // console.log(this.$router)
            this.$router.replace(path)
        }
    }
}
</script>
<style scoped>
    .classifyinput{
        width: 100%;
        padding: 0px 1rem 0px 1rem;
        margin: .7rem 0rem;
        box-sizing: border-box;
    }
    .classifyinput>div{
        width:100%;
        height:32px;
        border-radius: 16px;
        background-color: #f6f5f5;
        border:1px solid #f8f7f7;
        padding: 0px 20px ;
        box-sizing: border-box;
        display: flex;
        justify-content: center;
        align-items: center;
        cursor:pointer;
    }
    .classifyinput>div>img{
        width: 18px;
        height: 18px;
        margin-right: 5px;
    }
    .classifyinput>div>p{
        font-size: 1.6rem;
        color: #c5c5c5;
    }
</style>