package api.media.catalogue.repository;

import api.media.catalogue.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by Gile on 5/28/2017.
 */
public interface TitleRepository  extends JpaRepository<Title, Integer>, TitleRepositoryCustom{

    public List<Title> findByImdbTitle(String title);

}
