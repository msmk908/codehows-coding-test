// JavaScript (jQuery 기반)
$(document).ready(function() {
    // 사용자 정보 가져오기
    $.ajax({
        type: "GET",
        url: "/getUserInfo", // 사용자 정보를 가져오는 API의 URL
        success: function(response) {
            // 성공 시 hidden 필드에 사용자 정보 설정
            $("#name").val(response.name);
            $("#phonenum").val(response.phonenum);
            $("#email").val(response.email);
        },
        error: function(xhr, status, error) {
            console.error("사용자 정보를 가져오는 중 오류가 발생했습니다.");
            // 오류 처리
        }
    });
});

$(document).ready(function() {

    $("#saveButton").click(function() {
        var title = $("#title").val();
        var name = $("#name").val();
        var profileimage = $("#profileimage").val();
        var phonenum = $("#phonenum").val();
        var email = $("#email").val();
        var onelinecontent = $("#onelinecontent").val();
        var stack = $("#stack").val();
        var content = $("#content").val();


        // AJAX 요청 보내기
        $.ajax({
            type: "POST",
            url: "/savePortfolio",
            contentType: "application/json",
            data: JSON.stringify({
                "title": title,
                "name": name,
                "profileimage": profileimage,
                "phonenum": phonenum,
                "email": email,
                "onelinecontent": onelinecontent,
                "stack": stack,
                "content": content
            }),
            success: function(response) {
                console.log("게시물이 성공적으로 저장되었습니다.");

                window.location.href = "/portfolioList";
            },
            error: function(xhr, status, error) {
                console.error("게시물 저장 중 오류가 발생했습니다.");
                // 오류 처리
            }
        });
    });
});
