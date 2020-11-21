$(function () {
    $("#sub_btn").click(function () {
        // 验证评价是否全部完成
        var usernameText = $("#eva").length;
        alert(usernameText)
        if(usernameText == "" || usernameText == null){
            alert("请输入用户名");
            return false;
        }

        var text = $('input[id^="eva"]').length;
        alert(text)
    })
})