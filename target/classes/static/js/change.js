/*$(function () {
    $("#sub_btn").click(function () {
        // 验证原密码是否输入
        var oldpwdText = $("#oldpwd").val();
        if(oldpwdText == ""||oldpwdText == null){
            alert("请输入原密码");
            return false;
        }

        // 验证密码：长度为6到12位
        var passwordText = $("#password").val();
        var passwordPatt = /^\w{6,12}$/;
        if(!passwordPatt.test(passwordText)){
            alert("新密码格式不合法");
            return false;
        }

        // 验证确认密码：和密码相同
        var repwdText = $("#repwd").val();
        if(repwdText != passwordText){
            alert("确认密码和新密码不一致！");
            return false;
        }
    })
})*/

function check() {
    $("#sub_btn").click(function () {
        // 验证原密码是否输入
        var oldpwdText = $("#oldpwd").val();
        alert(oldpwdText)
        if(oldpwdText == ""||oldpwdText == null){
            alert("请输入原密码");
            return false;
        }

        // 验证密码：长度为6到12位
        var passwordText = $("#password").val();
        var passwordPatt = /^\w{6,12}$/;
        if(!passwordPatt.test(passwordText)){
            alert("新密码格式不合法");
            return false;
        }

        // 验证确认密码：和密码相同
        var repwdText = $("#repwd").val();
        if(repwdText != passwordText){
            alert("确认密码和新密码不一致！");
            return false;
        }
    })
}