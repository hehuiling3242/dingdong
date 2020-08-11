<template>
    <div class="shu">
        
        
        <div class="a">
            <p><router-link to='/details?id=1016'>毛奥阿尔</router-link></p>
            <span>毛奥阿尔</span>
        </div>
        
        <div cl>|</div>
        <div class="a">
            <p>毛奥阿尔</p>
            <span>毛奥阿尔</span>
        </div>
        <div>|</div>
        <div class="a">
            <p>毛奥阿尔</p>
            <span>毛奥阿尔</span>
        </div>
        <div>|</div>
        <div class="a">
            <p>毛奥阿尔</p>
            <span>毛奥阿尔</span>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            content: 5
        }
    }
}
</script>
<style scoped>
    .shu{
        width: 100%;
        display: flex;
        align-items:center;
    }
    .a{
        width: 25%;
        /* height: 100px; */
        /* background-color: #faf; */
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin: 20px 0px ;
    }
    .a p{
        font-size: 16px;
    }
    .a span{
        font-size: 14px;
        margin-top: 5px;
    }
</style>