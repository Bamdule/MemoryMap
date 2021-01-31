class FileInfo {
    constructor(id, file, url) {
        this.id = id;
        this.file = file;
        this.url = url;

        this.init();
    }

    init() {

    }

    isEmpty(str) {
        return str === "" || str === undefined || str === null;
    }
    nonEmpty(str) {
        return !this.isEmpty(str);
    }

}