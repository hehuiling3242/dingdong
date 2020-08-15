//加载express模块
const express=require('express');
//加载cors模块
const cors=require('cors');
//创建服务器
const server=express();
//获取所有文章分类的接口

const bodyParser=require('body-parser');

//加载mysql模式
const mysql=require('mysql');

//创建mysql连接池
const pool=mysql.createPool({
    host:'127.0.0.1',
    port:3306,
    user:'root',
    password:'',
    database:'dingdong',
    connectionLimit:20
})

//使用cros模块
server.use(cors({
    origin:['http://localhost:8080','http://127.0.0.1:8080']

}))

//使用bodyParser模块
server.use(bodyParser.urlencoded({
    extended:false
}));

server.get('/ceshi',(req,res)=>{
    let _uname=req.query.username;
    let _pwd=req.query.password;
    console.log(_uname)
    console.log(_pwd)
    let sql='select id from user where username=? and password=?';
    pool.query(sql,[_uname,_pwd],(err,a)=>{
        if(err) throw err;
        if(a.length==0){
            console.log('1')
        }else{
            res.send(a)
        }
    })
})

//创建服务器监听端口
server.listen(3000,()=>{
    console.log('服务器启动...');
})



