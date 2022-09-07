package com.pluralsight.hibernatefundamentals.airport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CountryService {
  @PersistenceContext
  private EntityManager em;
  public static String[][] COUNTRY_INIT_DATA = {
    {"Australia", "AU"},
    {"Canada", "CA"},
    {"United States", "US"}
  };

  @Transactional
  public void init(){
    for (int i = 0; i < COUNTRY_INIT_DATA.length; i++){
      String [] countrInitData = COUNTRY_INIT_DATA[i];
      Country country = new Country(countrInitData[0], countrInitData[1]);
      em.persist(country);
    }
  }

  @Transactional
  public void clear(){
    em.createQuery("delete from Country c");
  }

  public List<Country> getAllCountries() {
    return em.createQuery("select c from Country c").getResultList();
  }

}
