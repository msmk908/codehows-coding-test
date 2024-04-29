// JavaScript (jQuery 기반)
$(document).ready(function() {

    $("#saveButton").click(function() {
        var name = $("#name").val(); // 히든 필드에서 사용자 이름 가져오기
        var content = $("#content").val();


        // AJAX 요청 보내기
        $.ajax({
            type: "POST",
            url: "/saveBoard",
            contentType: "application/json",
            data: JSON.stringify({ "name": name, "content": content }),
            success: function(response) {
                console.log("게시물이 성공적으로 저장되었습니다.");

                // 게시물 저장 후 방명록 목록 업데이트
                updateBoardList();
            },
            error: function(xhr, status, error) {
                console.error("게시물 저장 중 오류가 발생했습니다.");
                // 오류 처리
            }
        });
    });
});

// 방명록 목록 업데이트 함수
function updateBoardList() {
    // AJAX를 이용하여 서버로부터 방명록 목록을 다시 가져옴
    $.get("/board", function(data) {
        // 서버로부터 받은 HTML을 페이지에 업데이트
        $("#boardList").html(data);
    });
}

/*
const btn_sumit =  document.getElementById('saveButton');
btn_sumit.addEventListener('click', function(event){
    alert('Hello world, '+event.target.value);
});*/
