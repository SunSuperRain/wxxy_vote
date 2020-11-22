/*$(function () {*/

    function checkForm(){
        $("#sub_btn").click(function () {
            // 验证用户名是否输入
            var usernameText = $("#username").val();
            if(usernameText == "" || usernameText == null){
                alert("请输入用户名");
                return false;
            }
            // 验证密码是否输入
            var passwordText = $("#password").val();
            if(passwordText == "" || passwordText == null){
                alert("请输入密码");
                return false;
            }
        })
    }
/*
})*/
