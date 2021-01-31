class FileManager {
    constructor(param) {
        this.info = {
            ...param,
            fileInfos: [],
            findFile: $("<input/>", {type: "file", multiple: "", css: {display: "none"}})
        };
        this.initialize();
    }

    initialize() {
        let {findBtn, findFile, changeCallback} = this.info;

        let self = this;
        findBtn.click(function () {
            findFile.click();
        });

        findFile.change(function () {
            if (this.files.length < 1) {
                return;
            }

            for (let file of this.files) {
                self.add({file});
                changeCallback(file);
            }
            
            findFile.val(null);
        });
    }

    loadImage(imgTag, file) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imgTag.attr('src', e.target.result);
        };
        reader.readAsDataURL(file);
    }

    add(param) {
        let {id = null, file = null, url = null} = param;
        this.info.fileInfos.push(new FileInfo(id, file, url));
    }

    getFileInfos() {
        return this.info.fileInfos;
    }

    isEmpty(str) {
        return str === "" || str === undefined || str === null;
    }
    nonEmpty(str) {
        return !this.isEmpty(str);
    }

}