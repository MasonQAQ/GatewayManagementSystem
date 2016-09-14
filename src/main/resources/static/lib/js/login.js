$("#sublime-login").click(function () {
    $.ajax({
        type: 'POST',
        url: '/login/check' ,
        data: {username:$("#username").val(),password:$("#password").val()} ,
        success: function (msg) {
            console.log(msg);
            if (msg["code"]!=1){
                alert("wrong username or password!")
            }else{
                top.location='/main';
            }
        }
    });
})