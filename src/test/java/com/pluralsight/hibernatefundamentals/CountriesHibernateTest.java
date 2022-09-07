package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Country;
import com.pluralsight.hibernatefundamentals.airport.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountriesHibernateTest {

  @Autowired
  private CountryService countryService;

  private List<Country> expectedCountryList = new ArrayList<>();

  public static String[][] COUNTRY_INIT_DATA = {
    {"Australia", "AU"},
    {"Canada", "CA"},
    {"United States", "US"}
  };

  @BeforeEach
  public void setUp() {
    countryService.init();
    initExpectedCountryList();

//    emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
//
//    em = emf.createEntityManager();
//    em.getTransaction().begin();
//    for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
//      String[] countryInitData = COUNTRY_INIT_DATA[i];
//      Country country = new Country(countryInitData[0], countryInitData[1]);
//      em.persist(country);
//    }
//    em.getTransaction().commit();

  }

  @AfterEach
  public void dropDown() {
    countryService.clear();

  }

  @Test
  public void testCountryList() {
    List<Country> countryList = countryService.getAllCountries();
    assertNotNull(countryList);
    assertEquals(COUNTRY_INIT_DATA.length, countryList.size());
    for (int i = 0; i < expectedCountryList.size(); i++){
      assertEquals(expectedCountryList.get(i), countryList.get(i));
    }

  }


  private void initExpectedCountryList() {

    for (int i = 0; i < COUNTRY_INIT_DATA.length; i++) {
      String[] countryInitData = COUNTRY_INIT_DATA[i];
      Country country = new Country(countryInitData[0], countryInitData[1]);
      expectedCountryList.add(country);
    }

  }
}
