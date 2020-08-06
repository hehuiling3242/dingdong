<template>
  <div>



    <input type="file" @change="changeFile" value="选择文件"/>
    <input id="submit_form" type="submit" @click="upload" value="保存"/>

    =================================================================
    <input type="file" @change="batchChangeFile" value="选择文件"/>
    <input id="batch_submit_form" type="submit" @click="batchUpload" value="保存"/>


    <ul >
      <li v-for="item in imgArray">
        <img style="height: 100px;width: 100px" v-lazy="item">
      </li>
    </ul>

    <ul >
      <li v-for="item in fileDate">
        <img style="height: 100px;width: 100px" v-lazy="item.url">
      </li>
    </ul>
  </div>
</template>

<script>

  export default {
    data(){
      return {

        files:'',
        id: '',
        query:{},
        imgArray:[],
        fileDate:[],
        fileArray:[],
        fileId:[],

      }
    },

    created() {
      this.queryList(1);
    },

    methods:{

      changeFile(val){
        this.file = val.target.files[0];
        console.log(this.file);
      },

      batchChangeFile(val){
        this.fileArray.push(val.target.files[0]);
        console.log("--->>fileArray: ",this.fileArray);
      },

      upload(){
        let formData = new FormData();
        formData.append('file', this.file);
        this.axios.post("server/file/one-upload", formData).then((res)=>{
          let url = 'http://localhost:9090/file/'+ res.data +'/load'
          this.imgArray.push(url);
          console.log("---->> ",this.imgArray);
        })
      },

      batchUpload(){

        let _this =this;
        this.fileArray.forEach(function (val,index) {
          let formData = new FormData();
          formData.append('file', val);
          _this.axios.post("server/file/one-upload", formData).then((res)=>{
            _this.imgArray.push(url);
            console.log("---->> ",this.imgArray);
          })
        })

        /*let formData = new FormData();
        formData.append('fileArray', this.fileArray);
        console.log(formData);
        this.axios.post("server/file/batch-upload", formData).then((res)=>{
          console.log("---->>> ",res.data);
        })*/
      },

      load(id){
        let url = "server/file/" + id + "/load"
        this.axios.get(url).then((res) =>{
          console.log("--->> ",res.data);
          //this.id = 5;
        })
      },

      queryList(productId){
        let url = "server/file/" + productId + "/query-list-for-product"
        this.axios.get(url).then((res)=>{
          this.fileDate = res.data;
        })
      },
    }

  }


</script>