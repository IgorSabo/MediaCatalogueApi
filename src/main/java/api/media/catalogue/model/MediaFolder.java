package api.media.catalogue.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Gile on 4/30/2017.
 */
@XmlRootElement
@Entity
@Table(name = "media_folder")
public class MediaFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int pathId;
    String path;

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
