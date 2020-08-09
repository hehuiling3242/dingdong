module.exports={
    chainWebpack:config=>{
      //删除编译后的独立js文件上的预获取操作[语音聊天]
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
                target: 'http://localhost:9090',
                changeOrigin: true,
                pathRewrite: {
                    '^/server': ''
                }
            }
        },
    },
}
