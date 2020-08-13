// 引入Express模块
const express = require('express');

// 引入CORS模块
const cors = require('cors');

// 引入MYSQL模块
const mysql = require('mysql');

//引入body-parser模块
const bodyParser = require('body-parser');

//创建MYsql的连接池
const pool = mysql.createPool({
  // 数据库服务器地址
  host: '121.199.24.90',
  //数据库用户名
  user: 'root',
  //数据库密码
  password: '123JSGBSH..jsgbsh',
  //数据库服务器端口号
  port: 3306,
  //数据库名称
  database: 'tcl_user',
  //编码方式
  charset: 'utf8',
  //连接限制
  connectionLimit: 20
});

// 创建Express实例
const server = express();

// 将CORS作为Server的中间件使用
server.use(cors({
  origin: ['http://127.0.0.1:8080', 'http://localhost:8080']
}));

//将bodyParser作为Server中间件使用
server.use(bodyParser.urlencoded({
  extended: false
}))

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

//指定服务器的监听端口号
server.listen(3000,()=>{
  console.log('服务器启动...');
})