package com.bamdule.memorymap.model.entity.place;

import com.bamdule.memorymap.model.TO.FileInfoTO;
import java.util.List;

/**
 *
 * @author MW
 */
public class PlaceFormTO {

    private PlaceTO placeTO;

    private List<FileInfoTO> files;

    public List<FileInfoTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileInfoTO> files) {
        this.files = files;
    }

    public PlaceTO getPlaceTO() {
        return placeTO;
    }

    public void setPlaceTO(PlaceTO placeTO) {
        this.placeTO = placeTO;
    }

    @Override
    public String toString() {
        return "PlaceFormTO{" + "placeTO=" + placeTO + ", files=" + files + '}';
    }

    
}
