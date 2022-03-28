# librarium-v1.0-master

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).


这是一个简单的前后端分离项目，主要采用 Vue.js + SpringBoot 技术栈开发。

# 技术栈

## 1.前端技术栈

1.Vue

2.Element-UI

3.axios   

## 2.后端技术栈

1.Spring Boot

2.Spring Data + JPA

3.MySQL

4.Shiro

## 3.部署方法  

在IntelliJ IDEA中运行 `librarium` 项目，为了保证项目成功运行，可以右键点击 `pom.xml` 选择 maven -> reimport ，并重启项目

至此，服务端就启动成功了，同时，运行 `librarium-vue` 项目，访问 `http://localhost:8181` ，即可进入登录页面，默认账号是 `admin`，密码是 `123`

由于在 `librarium-vue` 项目中已经配置了端口转发，将数据转发到SpringBoot上，因此项目启动之后，在浏览器中输入 `http://localhost:8181` 就可以访问我们的前端项目了，所有的请求通过端口转发将数据传到 SpringBoot 中（注意此时不要关闭 SpringBoot 项目）。

