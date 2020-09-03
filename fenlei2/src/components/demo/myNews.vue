<template>
<div>
    <div class="my">
        <table></table>
        <div class="my_top">
            <xitongtwo></xitongtwo>
            <div class="my_top_top">
                 <img src="./../../assets/img/tongzhih.png" alt="">
            </div>
        </div>
        <div class="my_z">
            <div class="my_z_l">
                <img src="./../../assets/img/touxiang.png" alt="">
                <div v-if="login">
                    <h2 @click="loginTo(f)">请点击登录</h2>
                </div>
                <div v-else>
                    <h2>{{userList.realName}}</h2>
                    <div>
                        <img src="./../../assets/img/shouji.png" alt="">
                        <p>{{userList.mobile}}</p>
                    </div>
                </div>
            </div>
            <div class="my_z_r">
                <img src="./../../assets/img/shoucang.png" alt="">
                <p>签到领积分</p>
            </div>
        </div>
        <div class="my_btn">
            <div class="my_btn_l">
                <h2>0</h2>
                <p>优惠券</p>
            </div>
            <div class="my_btn_z">
                <h2>0</h2>
                <p>积分</p>
            </div>
            <div class="my_btn_y">
                <h2>0.00</h2>
                <p>余额.充值(元)</p>
            </div>
        </div>
        <table></table>
    </div>
    <div class="my_t">
        <table></table>
        <div class="my_t_top">
            <div>
                <p>我的订单</p>
                <p  @click="switchTo()">查看全部订单></p>
            </div>
            <div>
                <div class="states">
                    <img @click="switchTo()" src="./../../assets/img/daizhifu.png" alt="">
                    <p v-show="nopay">
                        <span v-if="login"></span>
                        <span v-else>{{m}}</span>
                    </p>
                    <p @click="switchTo()">待支付</p>
                </div>
                <div class="states">
                    <img src="./../../assets/img/daishouhuo.png" alt="">
                    <p v-show="notake">
                        <span v-if="login"></span>
                        <span v-else>{{n}}</span>
                    </p>
                    <p>待收货</p>
                </div>
                <div class="states">
                    <img src="./../../assets/img/daipingjia.png" alt="">
                    <p v-show="noasse">
                        <span v-if="login"></span>
                        <span v-else>{{o}}</span>
                    </p>
                    <p>待评价</p>
                </div>
                <div class="states">
                    <img src="./../../assets/img/shouhou.png" alt="">
                    <p v-show="saled">
                        <span v-if="login"></span>
                        <span v-else>{{p}}</span>
                    </p>
                    <p>售后/退款</p>
                </div>
            </div>
        </div>
        <div class="my_t_z">
            <div class="my_t_z_l">
                <div>
                    <p>叮咚农场</p>
                    <p>免费领鲫鱼</p>
                </div>
                <div>
                    <img src="./../../assets/img/mianfeiling.png" alt="">
                </div>
            </div>
            <div class="my_t_z_r">
                <div>
                    <p>叮咚农场</p>
                    <p>免费领鲫鱼</p>
                </div>
                <div>
                    <img src="./../../assets/img/30hongbao.png" alt="">
                </div>
            </div>
        </div>
        <div class="my_b">
            <div>
                <div>
                    <img src="./../../assets/img/tuceng3.png" alt="">
                    <p>绿卡会员</p>
                </div>
                <div>
                    <img src="./../../assets/img/tuceng10.png" alt="">
                    <p>收货地址</p>
                </div>
                <div>
                    <img src="./../../assets/img/tuceng9.png" alt="">
                    <p>邀请有礼</p>
                </div>
                <div>
                    <img src="./../../assets/img/tuceng8.png" alt="">
                    <p>联系客服</p>
                </div>
            </div>
            <div>
                <div>
                    <img src="./../../assets/img/tuceng7.png" alt="">
                    <p>礼品卡</p>
                </div>
                <div>
                    <img src="./../../assets/img/tuceng6.png" alt="">
                    <p>扫一扫</p>
                </div>
                <div>
                    <img src="./../../assets/img/tuceng5.png" alt="">
                    <p>意见反馈</p>
                </div>
                <div >
                    <img  @click="showCont()" src="./../../assets/img/tuceng4.png" alt="">
                    <p>设置</p>
                </div>
            </div>
        </div>
        <table></table>
    </div>
    <div class="tuichu" v-show="yangshi " >
        <div>
            <span class="login" @click="tui()"><p>退出登录</p></span>
            <span @click="close()"><p >取消退出</p></span>
        </div>
    </div>
</div>
</template>
<script>
export default {
    data(){
        return{
            m:0,
            nopay:false,
            n:0,
            notake:false,
            o:0,
            noasse:false,
            p:0,
            saled:false,
            id:'',
            f:"/login",
            login:true,
            userList:{},
            planQuery:{},
            planList:[{}],
            yangshi:false,
        }
    },
    created(){
        this.queryUserList();
        this.queryPlanList();
    },
    methods:{
        queryUserList() {
            this.userList = JSON.parse(sessionStorage.getItem("userList"));
        },
        queryPlanList(){
            this.planQuery.userId = this.userList.id;
            if(this.userList.id!=null){
                this.login=false;
            };
            let url = "/server/plan/query-list"
            this.axios.get(url, {params: this.planQuery}).then((res) => {
                this.planList = res.data;
                this.planList.forEach(aa=>{
                    if(aa.status==1){
                        this.nopay=true;
                        this.m++;
                    }else if(aa.status==2){
                        this.notake=true;
                        this.n++;
                    }else if(aa.status==3){
                        this.noasse=true;
                        this.o++;
                    }else{
                        this.saled=true;
                        this.p++;
                    }
                })
            })
        },
        switchTo(){
            var id=sessionStorage.getItem("id")
                console.log(id)
            if(id==null){
                this.$router.replace("/login");
            }else{
                this.$router.replace("/mygoods");
            }
        },
        loginTo(f){
            this.$router.replace(f);
        },
        showCont(){
        this.yangshi = true;
        },
        close() {
          this.yangshi = false;
        },
        tui(){
            sessionStorage.clear()
            this.$router.push("/")
        }
    },
}
</script>
<style scoped>
    .my{
        width: 100%;
        padding: 0px 1rem;
        background: url(../../assets/img/my_bg.png);
    }
    /* 订单状态 */
     .tuichu{
        position: fixed;
        bottom: 0rem;
        width: 100%;
        height: 100vh;
        /* border: 0.1rem solid red; */
        background-color: rgba(0,0,0,.6);
        z-index: 9998;
    }
    .tuichu>div{
        height: 20vh;
        width: 100%;
        position: fixed;
        bottom: 0rem;
        display: flex;
        justify-content: space-around;
        align-items: center;
        background-color: #fff;
      

    }
    .tuichu span{
        width: 46%;
        height: 5.5rem;
        border: 0;
        border-radius: 2.5rem;
        background-color:#2ac058 ;
        display: flex;
        justify-content: center;
    }
    .tuichu span p{
        height: 1.9rem;
        width: 7.5rem;
        margin: auto;
        padding: 0;
        font-size: 1.8rem;
        color: #fff;
    }
    .tuichu .login{
        background-color: #ee0d45;
    }
    .states span{
        position: absolute;
        display: inline-block;
        width: 2.2rem;height: 2.2rem;
        background-color: red;
        border-radius: 50%;
        line-height: 2rem;
        color: #fff;
        font-size: 1.5rem;
        text-align: center;
        left: 2rem;top: -0.7rem;
    }
    .states{
        position: relative;
    }
    .states span{
        position: absolute;
        display: inline-block;
        width: 2.2rem;height: 2.2rem;
        background-color: red;
        border-radius: 50%;
        line-height: 2rem;
        color: #fff;
        font-size: 1.5rem;
        text-align: center;
        left: 2rem;top: -0.7rem;
    }
    .my_top{
        width: 100%;
        padding: 0px 1rem;
    }
    .my_top_top{
        display: flex;
        flex-direction:row-reverse;
        margin-top: 2.4rem;
    }
    .my_z{
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 0px 1rem;
        margin-top: 2rem;
    }
    .my_z_l{
        display: flex;
        align-items: center;
    }
    .my_z_l>img{
        width: 4.8rem;
        height: 4.8rem;
    }
    .my_z_l>div{
        margin-left: 1rem;
    }
    .my_z_l>div>h2{
        font-size: 1.8rem;
        font-weight:600
    }
    .my_z_l>div>div{
        display: flex;
        align-items: center;
        margin-top: .6rem;
    }
    .my_z_l>div>div>img{
        width: 1.2rem;
        height: 1.6rem;
    }
    .my_z_l>div>div>p{
        color: #999;
        font-size: 1.4rem;
    }
    .my_z_r{
        width: 10rem;
        height: 3rem;
        border-radius: 1.5rem;
        background-color: #fff;
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: .8rem;
    }
    .my_z_r>img{
        width: 2rem;
        height: 2rem;
    }
    .my_z_r>p{
        font-size: 1.2rem;
        color: #202020;
    }
    .my_btn{
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 0px 1rem;
        margin: 3.5rem 0px 7.2rem ;
    }
    .my_btn>div{
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 0px 3rem;
    }
    .my_btn>div>h2{
        font-size: 1.8rem;
        color: #1e1e1e;
        font-weight:600
    }
    .my_btn>div>p{
        font-size: 1.2rem;
        color: #999;
        margin-top: 1rem;
    }
    .my_t{
        background-color: #f0f0f0;
        width: 100% ;
        padding: 0px 1rem;
    }
    .my_t_top{
        background-color: #fff;
        border-radius: .6rem;
        padding: 2rem 1.6rem;
        margin-top: 1rem;
    }
    .my_t_top>div{
        display: flex;
        justify-content: space-between;
    }
    .my_t_top>div>p:first-child{
        font-size: 1.6rem;
        color: #2c2c2c;
        font-weight:600
    }
    .my_t_top>div>p:last-child{
        font-size: 1.4rem;
        color: #9d9d9d;
    }
    .my_t_top>div>div{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-between;
        margin-top: 2.6rem;
        cursor: pointer;
    }
    .my_t_top>div>div>img{
        width: 30px;
        margin-bottom: 1rem;
    }
    .my_t_top>div>div>p{
        color: #4b4b4b;
    }
    .my_t_z{
        width: 100%;
        display: flex;
        justify-content: space-between;
        margin-top: 1rem;
    }
    .my_t_z>div{
        border-radius: .6rem;
        padding: 2rem 1.6rem;
        background-color: #fff;
        width: 48.5%;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .my_t_z>div>div>p:first-child{
        font-size: 1.6rem;
        color: #2c2c2c;
        font-weight:600
    }
    .my_t_z>div>div>p:last-child{
        font-size: 1.4rem;
        color: #9d9d9d;
        margin-top:1rem
    }
    .my_b{
        width: 100%;
        /* padding: 0px 1rem; */
        background-color: #fff;
        border-radius: .6rem;
        margin: 1rem 0rem;
        padding: 2rem 1.6rem;
    }
    .my_b>div{
        width: 100%;
        display: flex;
        justify-content: space-between;
    }
    .my_b>div:last-child{
        margin-top: 3rem;
    }
    .my_b>div>div{
        /* width: 100%; */
        display: flex;   
        flex-direction: column;
        align-items: center;
        width:4.8rem;
        height: 5.1rem;
    }
    .my_b>div>div>img{
        width: 30px;
        margin-bottom: 1rem;
    }
</style>