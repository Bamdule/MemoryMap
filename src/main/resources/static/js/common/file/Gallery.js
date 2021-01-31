class Gallery {
    constructor(param) {

        this.info = {
            ...param
        };

        this.init();
    }

    init() {
        let {baseDiv} = this.info;
    }

    add(param) {
        let {file = null, url = null} = param;

        let imgWrap = $("<div>");
        let imgElement = $("<img>", {css: {"max-width": "100%", "max-height": "100%"}});
        imgWrap.append(imgElement);

        if (file === null) {
            imgElement.attr("src", url);
        } else {
            this.loadImage(imgElement, file);
        }

        this.info.baseDiv.append(imgWrap);
    }

    loadImage(imgElement, file) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imgElement.attr('src', e.target.result);
        };
        reader.readAsDataURL(file);
    }

    isEmpty(str) {
        return str === "" || str === undefined || str === null;
    }
    nonEmpty(str) {
        return !this.isEmpty(str);
    }

}