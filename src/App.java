import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import dao.CityDao;
import dao.CountryDao;
import dao.LanguageDao;
import entities.City;
import entities.Country;
import entities.Database;
import entities.Language;

/**
 * 
 * The App class is a demonstration of using DAOs to access and modify data in a
 * database. 
 * It prints information about cities, languages, and countries, inserts new
 * data, updates existing data, and deletes data.
 */
public class App {
    public static void main(String[] args) throws Exception {
        List<City> cityList;
        // Establish a connection to the database and create a statement
        List<Language> languageList;
        try (Connection connection = Database.getDatabaseConnection();
                Statement statement = connection.createStatement();) {
            // Use a CityDao to find and print all cities
            CityDao cityDao = new CityDao(connection);
            // Call the findAll method to get a list of all cities
            cityList = cityDao.findAll();
            System.out.println("Printing cities: ");
            // Loop through the list and print each city
            for (City city : cityList) {
                System.out.println(city);
            }
            // Use a LanguageDao to find and print all languages
            LanguageDao languageDao = new LanguageDao(connection);
            // Call the findAll method to get a list of all languages
            languageList = languageDao.findAll();
            System.out.println("Printing Languages: ");
            // Loop through the list and print each language
            for (Language language : languageList) {
                System.out.println(language);
            }
            // Use a CountryDao to find and print all countries
            CountryDao countryDao = new CountryDao(connection);
            // Call the findAll method to get a list of all countries
            List<Country> countryList = countryDao.findAll();
            System.out.println("Printing Countries: ");
            // Loop through the list and print each country
            for (Country country : countryList) {
                System.out.println(country);
            }
            /**
             * Insert new city into the database
             */
            City insertCity = new City();
            insertCity.setName("Kingston");
            insertCity.setCountryCode("CAN");
            insertCity.setDistrict("Kings");
            insertCity.setPopulation(136604);
            cityDao.insert(insertCity);

            // Find city by ID
            City city = cityDao.findByID(4030);
            System.out.println("City returned from findByID (4030): " + city);
            // Update city
            city.setPopulation(10000);
            Boolean success = cityDao.update(city);
            // Print the city after the update to verify the update was successful 
            if (success)
            {
                System.out.println("City after the update: " + cityDao.findByID(4030));
            }
            else
            {
                System.out.println("City update failed");
            }
            //Delete city
            Boolean deleteSuccess = cityDao.delete(4030);
            // Print a message to verify the delete was successful
            if (deleteSuccess)
            {
                System.out.println("City deleted");
            }
            else
            {
                System.out.println("Delete failed");
            }
            /**
             * Insert new country into the database
             */
            
            Country insertCountry = new Country();
            insertCountry.setCode("TOR");
            insertCountry.setName("Toriland");
            insertCountry.setContinent("North America");
            insertCountry.setRegion("North America");
            insertCountry.setSurfaceArea(6521556);
            insertCountry.setIndepYear(2022);
            insertCountry.setPopulation(1);
            insertCountry.setLifeExpectancy(89);
            insertCountry.setGNP(100252);
            insertCountry.setGNPOld(665455);
            insertCountry.setLocalName("Toriland");
            insertCountry.setGovernmentForm("Monarchy");
            insertCountry.setHeadOfState("Tori Thompson");
            insertCountry.setCapital(300);
            insertCountry.setCode2("TR");
            // Insert country
            countryDao.insert(insertCountry);

            // Find country by code
            Country country = countryDao.findByID("TOR");
            System.out.println("Country returned from findByID (TOR): " + country);
            // Update country
            country.setPopulation(5);
            Boolean countrySuccess = countryDao.update(country);
            // Print the country after the update to verify the update was successful
            if (countrySuccess)
            {
                System.out.println("Country after the update: " + countryDao.findByID("TOR"));
            }
            else
            {
                System.out.println("Country update failed");
            }
            // Delete country
            Boolean countryDeleteSuccess = countryDao.delete("TOR");
            // Print a message to verify the delete was successful
            if (countryDeleteSuccess)
            {
                System.out.println("Country deleted");
            }
            else
            {
                System.out.println("Country delete failed");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
