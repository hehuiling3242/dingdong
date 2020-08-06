<template>
  <div>



    <input type="file" @change="changeFile" value="选择文件"/>
    <input id="submit_form" type="submit" @click="upload" value="保存"/>

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

      }
    },

    created() {
      this.queryList();
    },

    methods:{

      changeFile(val){
        this.file = val.target.files[0];
        console.log(this.file);
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

      load(){
        this.axios.get("server/file/"+ 5 +"/load").then((res) =>{
          console.log("--->> ",res.data);
          this.id = 5;
        })
      },

      queryList(){
        this.axios.get("server/file/1/query-list-for-product").then((res)=>{
          this.fileDate = res.data;
        })
      },
    }

  }


</script>