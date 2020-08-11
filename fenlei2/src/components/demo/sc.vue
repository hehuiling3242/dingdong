<template>
    <div>

        <!--<btbs-nav-tabs :tabs="tabs"></btbs-nav-tabs>-->

        <!--<input type="file" @change="changeFile" value="选择文件"/>
        <input id="submit_form" type="submit" @click="upload" value="保存"/>

        =================================================================
        <input type="file" @change="batchChangeFile" value="选择文件"/>
        <input id="batch_submit_form" type="submit" @click="batchUpload" value="保存"/>-->


        <!--    <ul >
              <li v-for="item in imgArray">
                <img style="height: 100px;width: 100px" v-lazy="item">
              </li>
            </ul>

            <ul >
              <li v-for="item in fileDate">
                <img style="height: 100px;width: 100px" v-lazy="item.url">
              </li>
            </ul>-->


        <el-table
                :data="productList"
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="id"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="productName"
                    label="商品名称"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="detail"
                    label="详细"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="url"
                    label="tupian"
                    width="180">
                <template slot-scope="scope">
                    <el-image v-for="url in scope.row.filePaths" :key="url" :src="url" lazy></el-image>
                </template>

            </el-table-column>
            <el-table-column
                    prop="img"
                    label="图片"
                    width="300px">
                <template slot-scope="scope">
                    <el-select v-model="fileType" placeholder="请选择图片类型">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                    <input type="file" style="width: 100px;display: inline" @change="changeFile" value="选择文件"/>
                    <input id="submit_form" style="width: 100px;display: inline" type="submit"
                           @click="upload(scope.row.id)" value="保存"/>
                </template>

            </el-table-column>
        </el-table>
    </div>
</template>

<script>

    import BtbsNavTabs from '../test/BtbsNavTabs.vue';
    export default {
        data() {
            return {

                files: '',
                id: '',
                query: {},
                imgArray: [],
                fileDate: [],
                fileArray: [],
                fileId: '',
                productQuery: {},
                fileQuery: {},
                productList: [],
                fileType:'',
                options: [
                    {
                        label: '主图',
                        value: 1,
                    },
                    {
                        label: '详情图',
                        value: 2,
                    },
                ],
                type: '',
                tabs: [
                    {
                        code: '蔬菜豆制品',
                        label: '蔬菜豆制品',
                        tabType: '101',
                        actionUrl: '',
                    },
                    {
                        code: '新鲜水果',
                        label: '新鲜水果',
                        tabType: '102',
                        actionUrl: '',
                    },
                    {
                        code: '肉禽蛋品',
                        label: '肉禽蛋品',
                        tabType: '103',
                        actionUrl: '',
                    },
                ],

            }
        },
        components:{
            BtbsNavTabs
        },

        created() {
            this.load();
        },

        methods: {

            load() {
                this.queryProductList();
            },

            changeFile(val) {
                this.file = val.target.files[0];
                let formData = new FormData();
                formData.append('file', this.file);
                this.axios.post("server/file/one-upload",formData ).then((res) => {
                    this.fileId = res.data;
                })
                console.log(this.file);
            },

            batchChangeFile(val) {
                this.fileArray.push(val.target.files[0]);
                console.log("--->>fileArray: ", this.fileArray);
            },

            upload(productId) {
                let param = {
                    productId:productId,
                    fileType:this.fileType,
                    id:this.fileId
                }
                let url = "server/file/upate-file?id=" + this.fileId + "&productId=" + productId + "&fileType=" + this.fileType
                this.axios.post(url).then((res) => {
                    this.load();
                })
            },

            queryList(fileQuery) {
                let url = "server/file/query-list"
                this.axios.get(url, {params: fileQuery}).then((res) => {
                    this.fileDate = res.data;
                })
            },

            queryProductList() {
                this.productQuery. = 1;
                let url = "server/product/query-list"
                this.axios.get(url, {params: this.productQuery}).then((res) => {
                    this.productList = res.data;
                    console.log("--->> 商品",);
                })
            },
        }

    }


</script>