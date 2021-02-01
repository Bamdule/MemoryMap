class PlaceApi {
    constructor(contextPath) {
        this.contextPath = contextPath;
    }

    editPlace(form, fileInfos) {

        var formData = new FormData(form[0]);

        for (var index = 0; index < fileInfos.length; index++) {
            formData.append(`files[${index}].file`, fileInfos[index].file);
            formData.append(`files[${index}].id`, index);
        }

        $.ajax({
            url: `${this.contextPath}/place/edit`,
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

    }
}