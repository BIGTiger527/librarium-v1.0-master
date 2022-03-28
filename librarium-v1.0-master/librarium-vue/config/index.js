'use strict'

const path = require('path')

module.exports = {
  dev: {

    // Paths
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {
      '/api': {
        target: 'http://localhost:8088',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },

    //  Dev 服务器设置
    host: 'localhost', // 服务器地址
    port: 8181, // 端口
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-

    // 审查代码
    //如果为true，则代码在绑定和
    //错误和警告将显示在控制台中。
    useEslint: true,
    // 如果为true，错误和警告也将显示在错误覆盖在浏览器中。
    showEslintErrorsInOverlay: false,

    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'cheap-module-eval-source-map',

    //如果在devtools中调试vue文件时遇到问题，
    //将此设置为false-可能会有帮助
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

  build: {
    // Template for index.html
    index: path.resolve(__dirname, '../dist/index.html'),

    // Paths
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static',
    assetsPublicPath: './',

    /**
     * Source Maps
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: '#source-map',

    //默认情况下，Gzip会关闭许多流行的静态主机，例如
    //Surge或Netlify已经为您gzip所有静态资产。
    //在设置为“true”之前，请确保：
    //npm安装--保存开发压缩网页包插件
    productionGzip: true,
    productionGzipExtensions: ['js', 'css'],



      //运行带有额外参数的build命令
      //生成完成后查看捆绑包分析器报告：
      //`npm运行构建--报告`
      //设置为'true'或'false'以始终打开或关闭它
    bundleAnalyzerReport: process.env.npm_config_report
  }
}
