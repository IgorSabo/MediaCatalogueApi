package api.media.catalogue.service.impl;


import api.media.catalogue.model.MediaFolder;
import api.media.catalogue.repository.MediaFolderRepository;
import api.media.catalogue.service.MediaFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Gile on 4/30/2017.
 */
@Repository
@Transactional
public class MediaFolderServiceImpl implements MediaFolderService {

    @Autowired
    private MediaFolderRepository mediaFolderRepository;



    @Override
    public List<MediaFolder> getAllMediaFolders() {
        return (List<MediaFolder>) mediaFolderRepository.findAll();
    }
}
