class KakaoMap {
    constructor(param) {
        if (param.mapContainer === null || param.mapContainer === undefined) {
            alert('mapContainer를 넘겨주세요!');
        }


        this.info = {
            ...param,
            mapOption: {
                center: new kakao.maps.LatLng(param.latitude, param.longitude), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            },
            selectedMaker: null,
            infoWindow: new kakao.maps.InfoWindow({zIndex: 1}),
        };

        this.init();
    }

    init() {
        let {map, mapOption, mapContainer = null} = this.info;

        let self = this;

        map = new kakao.maps.Map(mapContainer, mapOption);

        kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
            let selectedMaker = self.info.selectedMaker;

            if (selectedMaker !== null) {
                selectedMaker.setMap(null);
            }

            selectedMaker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: mouseEvent.latLng, // 마커를 표시할 위치
                title: "" // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
//            image: markerImage // 마커 이미지 
            });
            // 클릭한 위도, 경도 정보를 가져옵니다 
            var latlng = mouseEvent.latLng;

            // 마커 위치를 클릭한 위치로 옮깁니다
            selectedMaker.setPosition(latlng);
            selectedMaker.setDraggable(true);
            console.log(latlng.getLat(), latlng.getLng());

            self.info.selectedMaker = selectedMaker;
        });



        this.info.map = map;
    }

    getMarkerInfo() {
        return {
            position: this.info.selectedMaker.getPosition()
        };
    }
    getMap() {
        return this.info.map;
    }

    updateMap() {
        this.info.map.relayout();
    }
}

class KakaoSearch {
    constructor(param) {
        if (param.map === null || param.map === undefined) {
            alert('map 객체를 넘겨주세요!');
        }
        this.info = {
            ...param,
            placeService: new kakao.maps.services.Places(),
            infoWindow: new kakao.maps.InfoWindow({zIndex: 1}),
            searchMarkers: [],
        };

        this.init();
    }

    init() {

        let self = this;

        this.placesSearch = function (data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                var bounds = new kakao.maps.LatLngBounds();

                for (var i = 0; i < data.length; i++) {
                    self.displayMarker(data[i]);
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                self.info.map.setBounds(bounds);
            }
        };

    }

    displayMarker(place) {
        let {searchMarkers, infoWindow, map} = this.info;


        infoWindow.close();
        searchMarkers.forEach((m) => {
            m.setMap(null);
        });
        searchMarkers = [];


        // 마커를 생성하고 지도에 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x)
        });
        searchMarkers.push(marker);

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'mouseover', function () {
            // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
            infoWindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
            infoWindow.open(map, marker);
        });
    }

    search(keyword) {
        console.log(keyword, this.info.placeService, this.placesSearch);

        this.info.placeService.keywordSearch(keyword, this.placesSearch);
    }

}

