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
        List<Language> languageList;
        // Establish a connection to the database and create a statement
        try (Connection connection = Database.getDatabaseConnection();
                Statement statement = connection.createStatement();) {
            // City table
            // Use a CityDao to find and print all cities
            CityDao cityDao = new CityDao(connection);
            // Call the findAll method to get a list of all cities
            cityList = cityDao.findAll();
            System.out.println("Printing cities: ");
            // Loop through the list and print each city
            for (City city : cityList) {
                System.out.println(city);
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
            City city = cityDao.findByID(4003);
            System.out.println("City returned from findByID (4003): " + city);
            // Update city
            city.setPopulation(10000);
            Boolean success = cityDao.update(city);
            // Print the city after the update to verify the update was successful
            if (success) {
                System.out.println("City after the update: " + cityDao.findByID(4030));
            } else {
                System.out.println("City update failed");
            }
            // Delete city
            Boolean deleteSuccess = cityDao.delete(4030);
            // Print a message to verify the delete was successful
            if (deleteSuccess) {
                System.out.println("City deleted");
            } else {
                System.out.println("Delete failed");
            }
            // Find city by city name
            List<City> cityListByName;
            cityListByName = cityDao.findCityByName("London");
            System.out.println("Printing cities by name: ");
            // Loop through the list and print each city
            for (City cityByName : cityListByName) {
                System.out.println(cityByName);
            }
            // Find city by country code
            List<City> cityListByCountryCode;
            cityListByCountryCode = cityDao.findCityByCountryCode("CAN");
            System.out.println("Printing cities by country code: ");
            // Loop through the list and print each city
            for (City cityByCountryCode : cityListByCountryCode) {
                System.out.println(cityByCountryCode);
            }
            // Find cities with a population greater than 1000000
            List<City> cityListByPopulation;
            cityListByPopulation = cityDao.findCityPopulationOver1Million();
            System.out.println("Printing cities with a population greater than 1000000: ");
            // Loop through the list and print each city
            for (City cityByPopulation : cityListByPopulation) {
                System.out.println(cityByPopulation);
            }

            // Language table
            // Use a LanguageDao to find and print all languages
            LanguageDao languageDao = new LanguageDao(connection);
            // Call the findAll method to get a list of all languages
            languageList = languageDao.findAll();
            System.out.println("Printing Languages: ");
            // Loop through the list and print each language
            for (Language language : languageList) {
                System.out.println(language);
            }

            // Country table
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
            // Find country by name
            List<Country> countryListByName;
            countryListByName = countryDao.findByName("Canada");
            System.out.println("Printing countries by name: ");
            // Loop through the list and print each country
            for (Country countryByName : countryListByName) {
                System.out.println(countryByName);
            }
            // Find country by region
            List<Country> countryListByRegion;
            countryListByRegion = countryDao.findByRegion("North America");
            System.out.println("Printing countries by region: ");
            // Loop through the list and print each country
            for (Country countryByRegion : countryListByRegion) {
                System.out.println(countryByRegion);
            }
            // Update country
            country.setPopulation(5);
            Boolean countrySuccess = countryDao.update(country);
            // Print the country after the update to verify the update was successful
            if (countrySuccess) {
                System.out.println("Country after the update: " + countryDao.findByID("TOR"));
            } else {
                System.out.println("Country update failed");
            }
            // Delete country
            Boolean countryDeleteSuccess = countryDao.delete("TOR");
            // Print a message to verify the delete was successful
            if (countryDeleteSuccess) {
                System.out.println("Country deleted");
            } else {
                System.out.println("Country delete failed");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
