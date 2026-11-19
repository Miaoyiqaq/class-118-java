$(document).ajaxError(function (event, xhr, options, exc) {
    if (xhr.status == 400) {
        let result = JSON.parse(xhr.responseText);
        alert(result.errorMessage);
    }else if (xhr.status == 401) {
        location.href = "blog_login.html";
    }
});

//ajax 请求发送时, 执行的代码
$(document).ajaxSend(function (event, xhr, options) {
    let user_token = localStorage.getItem("user_token");
    xhr.setRequestHeader("User-Token", user_token);
});

function getUserInfo(url) {
    $.ajax({
        type: "get",
        url: url,
        success: function (result) {
            if (result != null && result.code == 200 && result.data != null) {
                let userInfo = result.data;
                $(".left .card h3").text(userInfo.userName);
                $(".left .card a").attr("href", userInfo.githubUrl)

            } else {
                //TODO
                alert(result.message);
            }
        }
    });
}

function logout(){
    localStorage.removeItem("user_token");
    localStorage.removeItem("login_userid");
    location.href = "blog_login.html";
}