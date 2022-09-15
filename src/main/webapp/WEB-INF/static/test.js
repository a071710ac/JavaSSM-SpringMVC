updateData = function() {
    // 美元符. 的方式来使用Ajax请求 这里使用的是get方式 第一个参数为请求地址(注意: 需要带上Web应用程序名称) 第二个参数为成功获取到数据的方法 data就是返回的数据内容
    $.get("/mvc/data", function (data) { // 获取成功执行的方法
        window.alert('接收到异步请求数据: ' + JSON.stringify(data)) // 弹窗展示数据
        $("#username").text(data.username) // 这里使用了JQuery提供的选择器 直接选择id为username的元素 更新数据
        $("#password").text(data.password)
    })
}

submitData1 = function(){
    $.post("/mvc/submit", { // 这里使用POST方法发送请求
        username: "赛博朋克", // 第二个参数是要传递的对象 会以表单数据的方式发送
        password: 2077
    }, function (data) {
        window.alert(JSON.stringify(data)) // 发送成功执行的方法
    })
}

submitData2 = function(){
    $.ajax({ // 最基本的请求方式 需要自己设定一些参数
    type: 'POST', // 设定请求方法
    url: "/mvc/submit", // 请求地址
    data: JSON.stringify({username: "赛博朋克", password: 2088}), // 转换为JSON字符串进行发送
    success: function (data) {
        window.alert(JSON.stringify(data))
        },
        contentType: "application/json" // 请求头Content-Type 一定要设定为JSON格式
    })
 }