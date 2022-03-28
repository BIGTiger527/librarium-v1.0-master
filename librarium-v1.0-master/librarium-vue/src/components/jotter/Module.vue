<template>
    <div style=" ">
      <a href="../../../static/html/别点我.html" class="module">
        <img src="../../assets/img/icon/icon1.png" alt="">
        <br>
        <br>
        <br>
        <span class="desc">springboot+vue.js</span>
        <span class="desc">书籍是人类进步的阶梯!!</span>
      </a>
    </div>
</template>

<script>
  export default {
    name: 'Module'
  }
</script>

<style scoped>
  a.module {
    background:url("../../../static/img/carousel/44292d86b1af0a203c7cf13b248c4554.jpeg");
    display: block;
    width: 95%;
    height: 145px;
    margin: 10px;
    padding: 15px;
    background-color: #DCDFE6;
    float: left;
    border-radius: 15px;
    position: relative;
    text-decoration: none;
    font-family: "PingFang SC";
    color: rgb(84, 92, 100);

  }
  a.module img {
    float: left;
  }
  a.module img span{
    font-size: 20px;
    font-weight: bold;
    color: #84fff2;
  }
  span.desc {
   font-size: 20px;
    font-weight: bold;
    color: #e36209;
  }
</style>
