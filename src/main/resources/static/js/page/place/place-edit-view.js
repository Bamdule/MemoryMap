

$(document).ready(function () {
    $('.menu .item').tab();
    $('body').toast({
        message: 'place edit view !'
    });

    var mapContainer = document.getElementById('map'); // 지도를 표시할 div  
    let kakaoMap = new KakaoMap({
        mapContainer,
        latitude: 37,
        longitude: 127
    });

    let kakaoSearch = new KakaoSearch({
        map: kakaoMap.getMap()
    });

    let keyword = $("#keyword");
    $("#search-btn").click(function () {
        kakaoSearch.search(keyword.val());
    });

    let gallery = new Gallery({
        baseDiv: $("#gallery-container")
    });

    let fileManager = new FileManager({
        findBtn: $("#image-find-btn"),
        changeCallback: function (file) {
            console.log(file);
            gallery.add({file});
        }
    });
    $("#saveBtn").click(function () {
        
        let fileInfos = fileManager.getFileInfos();
        
        
        var formData = new FormData();
//        //formData란 <form> 태그를 객체화한 것을 의미한다.
//        //formData.append(key, value)를 이용해 데이터를 삽입할 수 있다.
//        //form 태그 내에 input 태그를 사용한 것과 동일하다.
//
//        var files = $("#files")[0].files; //선택한 파일리스트를 가져온다.
//
        for (var index = 0; index < fileInfos.length; index++) {
            formData.append(`files[${index}].file`, fileInfos[index].file);
            formData.append(`files[${index}].id`, index);
        }
//        //formData의 file key값을 files[0,1..].file 형식으로 지정한다.
//
    let contextPath = $("#contextPath").val();
        $.ajax({
            url: `${contextPath}/place/edit`,
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