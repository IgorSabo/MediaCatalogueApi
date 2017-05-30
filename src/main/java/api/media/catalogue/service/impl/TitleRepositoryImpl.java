package api.media.catalogue.service.impl;

import api.media.catalogue.model.Title;
import api.media.catalogue.repository.TitleRepositoryCustom;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gile on 5/28/2017.
 */

@Repository
@Transactional
public class TitleRepositoryImpl implements TitleRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public HashMap<String, Number> getCountsForParams(String genre, String type, String year) {
        return null;
    }

    @Override
    public List<Object[]> getQuickSearchResults(String word) {
        Session session = em.unwrap(Session.class);
        Criteria criteria=session.createCriteria(Title.class);
        ProjectionList plist = Projections.projectionList();
        plist.add(Projections.property("IDfilm"));
        plist.add(Projections.property("imdbTitle"));
        criteria.add(Restrictions.like("imdbTitle", "%"+word+"%"));
        criteria.setProjection(plist);

        ArrayList<Object[]> list = (ArrayList<Object[]>) criteria.list();

        System.out.println("Size of the results for word "+word+" is "+list.size());
        return list;
    }

    @Override
    public List<Title> getResults(String type, int page, int perPage, String genre, String year) {
        Criteria criteria=null;
        Session session = em.unwrap(Session.class);
        criteria=session.createCriteria(Title.class);
        System.out.println("Nadjeni sledeci parametri: type="+type+", page="+page+", perPage="+perPage+", forYear: "+year);
        if(genre!=null && !genre.equals("null") && !genre.equals("undefined"))
        {
            System.out.println("Adding criteria for genre: "+genre);
            criteria.add(Restrictions.like("genre", "%"+genre+"%"));
        }
        if(year!=null && !year.equals("null") && !year.equals("undefined") && !year.equals("NotSelected"))
        {
            System.out.println("Adding criteria for year: "+year);
            criteria.add(Restrictions.like("year", "%"+year+"%"));
        }

        if(type==null)
        {
            //
        }
        else if(type.toLowerCase().equals("movie"))
        {
            criteria.add(Restrictions.eq("IDtype", 1));
        }
        else if(type.toLowerCase().equals("series"))
        {
            criteria.add(Restrictions.eq("IDtype", 2));
        }
        else if(type.toLowerCase().equals("game"))
        {
            criteria.add(Restrictions.eq("IDtype", 4));
        }
        else if(type.toLowerCase().equals("recentlyadded"))
        {
            criteria.add(Restrictions.eq("lastAdded", 1));
        }
        else if(type.toLowerCase().equals("mustwatch"))
        {
            criteria.add(Restrictions.eq("mustWatch", 1));
        }
        else if(type.toLowerCase().equals("favorite"))
        {
            criteria.add(Restrictions.eq("favorite", 1));
        }

        criteria.setFirstResult(page);
        criteria.setMaxResults(perPage);
        ArrayList<Title> list =(ArrayList<Title>)criteria.list();
        return list;
    }

    public Number getTotalEntities() {
        return null;
    }
}
