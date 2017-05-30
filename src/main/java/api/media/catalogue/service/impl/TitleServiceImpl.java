package api.media.catalogue.service.impl;

import api.media.catalogue.model.Title;
import api.media.catalogue.repository.TitleRepository;
import api.media.catalogue.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gile on 5/28/2017.
 */
@Repository
@Transactional
public class TitleServiceImpl  implements TitleService {

    @Autowired
    TitleRepository titleRepository;

    @Override
    public void createTitle(Title title) {
        titleRepository.save(title);
    }

    @Override
    public void updateTitle(Title title) {
        Title titleFromDb = titleRepository.findOne(title.getIDfilm());

        //session.get(Title.class, title.getIDfilm());
        titleFromDb.setActors(title.getActors());
        titleFromDb.setDescription(title.getDescription());
        titleFromDb.setImdbTitle(title.getImdbTitle());
        titleFromDb.setRawName(title.getRawName());
        titleFromDb.setLocation(title.getLocation());
        titleFromDb.setQuality(title.getQuality());
        titleFromDb.setPicture(title.getPicture());
        titleFromDb.setGenre(title.getGenre().replace("-", ""));
        titleFromDb.setYear(title.getYear().replace("â","–").replace("\u2013","–").replace("â??", "–"));
        titleFromDb.setIDtype(title.getIDtype());

        titleRepository.save(titleFromDb);
    }

    @Override
    public Title showInfo(int titleId) {
        Title title = titleRepository.findOne(titleId);
        return title;
    }

    @Override
    public void addToMustWatch(int titleId) {
        Title title = titleRepository.findOne(titleId);
        title.setMustWatch(1);
        titleRepository.save(title);
    }

    @Override
    public void addToFavorite(int titleId) {
        Title title = titleRepository.findOne(titleId);
        title.setFavorite(1);
        titleRepository.save(title);
    }

    @Override
    public void addToIncorrect(int titleId) {
        Title title = titleRepository.findOne(titleId);
        title.setIncorrect(1);
        titleRepository.save(title);
    }

    @Override
    public void deleteTitle(int titleId) {
        Title title = titleRepository.findOne(titleId);
        titleRepository.delete(title);
    }

    @Override
    public HashMap<String, Number> getCountsForParams(String genre, String type, String year) {
        return null;
    }

    @Override
    public List<Object[]> getQuickSearchResults(String word) {
        return titleRepository.getQuickSearchResults(word);
    }

    @Override
    public List<Title> getResults(String type, int page, int perPage, String genre, String year) {
        return titleRepository.getResults(type, page, perPage, genre, year);
    }

    @Override
    public Number getTotalEntities() {
        return titleRepository.getTotalEntities();
    }

    @Override
    public Title getTitle(int IDtitle) {
        return titleRepository.findOne(IDtitle);
    }

    @Override
    public List<Title> findByImdbTitle(String title) {
        return titleRepository.findByImdbTitle(title);
    }
}
