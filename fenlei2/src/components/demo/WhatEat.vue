<template>
    <div id="app">
        <xitongtwo></xitongtwo>
        <h1>吃什么</h1>
        <button @click="a()">退出</button>
        <bottontab></bottontab>
    </div>
</template>
<script>
export default {
    methods:{
        a(){
            // 退出登录事件
            sessionStorage.clear()
            // 跳转首页事件
        },
        switchTo(){
            this.$router.push("/")
        // this.$router.replace(path)
        
        },
    },
    mounted(){
        
    }
}
</script>
<style scoped>



</style>