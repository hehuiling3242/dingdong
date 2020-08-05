<template>
    <div>
        <!-- 整体 -->
        <div id="lieBiao">
        <!--头部  -->
        <div class="listHeader">
            <!-- 头部第一个内容 -->
            <div class="headerNei1">
                <div class="biaoTi1">
                    <div>快捷购物</div>
                    <div>猜你喜欢</div>
                </div>
                
            </div>
            <div class="headerNei2">
                <div class="biaoTi2">
                <div>快捷购物</div>
                    <div>猜你喜欢</div>
                </div>

            </div>
             <div class="headerNei3">
                <div class="biaoTi2">
                <div>快捷购物</div>
                    <div>猜你喜欢</div>
                </div>
            </div>
             <div class="headerNei4">
                 <div class="biaoTi4">
                <div>快捷购物</div>
                    <div>猜你喜欢</div>
                </div>
            </div>
        </div>
        <!-- 头部结束 -->
        </div>
        <!-- 整体结束 -->
    </div>
</template>
<script>
</script>
<style scoped>

.listHeader{
    width: 100%;
     display: flex;
     justify-content: space-between;
     flex-wrap: nowrap;
     
}
.biaoTi1,.biaoTi2,.biaoTi3,.biaoTi4{
    /* display: inline-block; */
    
    width: 100%;
    height: 8rem;
    display: flex;
    flex-direction: column;
justify-content: center;
     align-items: center;
     
    
}
.headerNei1,.headerNei2,.headerNei3,.headerNei4{
    width: 25%;
    display: flex;
    justify-content:center;
     align-items: center;
}
.biaoTi1>p,.biaoTi2>p,.biaoTi3>p,.biaoTi4>p{
    /* display: inline-block; */
    width: 3.6rem;
    height: 1.6rem;
    font-size: 0.6rem;
    width: 100%;
}
.biaoTi1>span,.biaoTi2>span,.biaoTi3>span,.biaoTi4>span{
    display: inline-block;
    width: 3.6rem;
    height: 1.4rem;
    font-size: 0.4rem;
}




/* #carBei{
    width: 2.8rem;
    height: 2.8rem;
    background: linear-gradient(#4ad278,#33b05d);
    border-radius: 1.4rem;
    display: flex;
    justify-content: center;
    align-items: center;

}
#carBei>img{
    width: 1.6rem;
    height: 1.6rem;
} */
</style>