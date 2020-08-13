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
            sessionStorage.clear()
        }
    },
    mounted(){
        
    }
}
</script>
<style scoped>
#app{
    font-size: 62.5%;
    width: 100%;
    height: 100Vh;
}



</style>