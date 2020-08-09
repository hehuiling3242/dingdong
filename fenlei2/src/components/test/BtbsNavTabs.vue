<template>
    <div>
        <el-tabs v-if="disposTabs.length > 1" v-model="activeName" @tab-click="tabClick">
            <el-tab-pane v-for="tab in disposTabs" :label="tab.label" :name="tab.code" :key="tab.code"></el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeName: '',
                userAgent: {permissions: {}},
                query: {},
                disposTabs: [],
            }
        },
        props: {
            tabs: {
                type: Array,
            },
        },

        created() {
            this.setActiveName();
            this.disposTabs = this.tabs;
        },

        methods: {
            //规范当前页面的路由
            resetRouterName() {
                let tempName = this.$route.name;
                if (tempName.indexOf('_TAB') == -1) {
                    tempName = tempName + '_TAB';
                }
                return tempName;
            },
            tabClick(tab) {
                this.$router.push({name: this.resetRouterName(), params: {tabType: tab.name}});
            },
            setActiveName() {
                if (this.tabs.length === 0) {
                    return;
                }

                if (this.$route.params.tabType) {
                    this.activeName = this.$route.params.tabType;
                } else {
                    this.activeName = this.tabs[0].tabType.toLowerCase();
                }
            },
        },
        destroyed(){
            this.disposTabs = [];
            this.activeName = '';
        },
        watch:{
            tabs(){
                this.setActiveName();
                this.disposTabs = this.tabs;
            },
            $route(){
                this.setActiveName();
            }
        }
    }
</script>
