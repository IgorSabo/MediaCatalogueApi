package api.media.catalogue.repository;

import api.media.catalogue.model.Title;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gile on 5/28/2017.
 */

@Transactional
public interface TitleRepositoryCustom {
    public HashMap<String, Number> getCountsForParams(String genre, String type, String year);

    //public void synchronizeTitles();

    public List<Object[]> getQuickSearchResults(String word);

    public List<Title> getResults(String type, int page, int perPage, String genre, String year);

    public Number getTotalEntities();

}
