function gopage() {
    var message = document.getElementById("message");
    message.innerHTML = ""; // 기존 메시지 초기화

    var form = document.getElementById("frm");

    // name 속성으로 입력값 가져오기
    var title = form.title.value.trim();
    var author = form.author.value.trim();
    var content = form.content.value.trim();
    var fileInput = form.file;

    // 필수 입력 체크
    if (title=="" || author=="" || content=="") {
        alert("제목, 글쓴이, 내용은 필수 입력사항입니다.");
        return false; // 제출 막기
    }

    // 파일 첨부 체크 (선택사항)
    if (fileInput.files.length > 0) {
        var fileSize = fileInput.files[0].size;
        var maxSize = 10 * 1024 * 1024; // 10MB

        if (fileSize > maxSize) {
            message.innerHTML = "첨부파일은 최대 10MB까지 업로드 가능합니다.";
            return false; // 제출 막기
        }
    }

    return true; // 모든 체크 통과 → 폼 제출 허용
}
