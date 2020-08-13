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
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
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
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
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
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
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
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
                                    </div>
                                </div>
                                <table></table>
                            </div>
                        </div>
                    </div>
                    <div class="lieB1">
                        <div>
                            <div>
                                <div class="lieB1_top">
                                    <img class="shopTu1" src="../../assets/img/fangz1.png" alt="">
                                </div>
                                <div class="lieB1_z">
                                    <p class="wen1">南翔小笼包 180g/袋</p>
                                    <p class="wen2">10只装 在家就能尝到</p>
                                </div>
                                <div class="lieB1_btn">
                                    <div class="lieB1_btn_l">
                                        <div>
                                            <span>$</span>
                                            7.90
                                        </div>
                                        <p>$9.90</p>
                                    </div>
                                    <div class="lieB1_btn_r">
                                        <img src="../../assets/img/gouwuche.png" alt="">
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
                NeiR:"NeiR11"
            }
        },
        methods:{
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
        width: 49%;
        /* margin-bottom: 1rem; */
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
    .lieB1_top>img{
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