module.exports={
    chainWebpack:config=>{
      //删除编译后的独立js文件上的预获取操作
      config.plugins.delete("prefetch")
    },

    /**
     * 设置代理
     */
    devServer: {
        host:'127.0.0.1',
        open:true,
        port: 8080,
        proxy: {
            '/server': {
                target: 'http://121.199.24.90:9090',
                changeOrigin: true,
                pathRewrite: {
                    '^/server': ''
                }
            }
        },
    },
}
