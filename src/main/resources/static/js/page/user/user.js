

$(document).ready(function () {
    console.log("ready!");

    let contextPath = $("#contextPath").val();

    $("#saveBtn").click(function () {

        var formData = new FormData();

        var files = $("#file")[0].files; //선택한 파일리스트를 가져온다.

        for (var index = 0; index < files.length; index++) {
            formData.append(`files[${index}].file`, files[index]);
            formData.append(`files[${index}].file`, files[index]);
        }
        //formData의 file key값을 files[0,1..].file 형식으로 지정한다.

        $.ajax({
            url: `${contextPath}/saveFile`,
            type: "POST",
            data: formData,
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function (data) {
                alert("completed!");
            },
            error: function () {
                alert("failed! ")
            }
        });
    });
});