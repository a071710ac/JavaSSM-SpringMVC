function updateData() {

    $.get("/mvc/data", function (data) {
        window.alert('接收到异步请求数据: ' + JSON.stringify(data))
        $("#name").text(data.name)
        $("#age").text(data.age)
    })

}

function submitData() {

    $.post("/mvc/submit1", {
        name: "杰哥",
        age: 18
    }, function (data) {
        window.alert(JSON.stringify(data))
    })

}

function submitAjaxData() {

    $.ajax({
        type: 'POST',
        url: "/mvc/submit2",
        data: JSON.stringify({name: "杰哥", age: 18}),
        success: function (data) {
            window.alert(JSON.stringify(data))
        },
        contentType: "application/json"
    })

}

