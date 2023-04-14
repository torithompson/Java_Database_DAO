package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.City;

/**
 * CityDao class to access the city table in the database 
 *
 */
public class CityDao implements Dao<City, Integer> {
    Connection connection;
    // Constructor
    public CityDao(Connection connection) {
        this.connection = connection;
    }
    // Methods 
    // Find all cities in the database 
    public List<City> findAll() {
        List<City> cities = new ArrayList<City>();
        try (Statement statement = connection.createStatement()) {
            // Execute the query 
            ResultSet result = statement.executeQuery("SELECT * FROM city");
            while (result.next()) {
                City city = new City();
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return the list of cities
        return cities;
    }

    /**
     *  Find a city by its ID 
     */
    public City findByID(Integer pk) {
        City city = new City();
        // SQL query to find a city by its ID
        String select = "SELECT * FROM city WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setInt(1, pk);
            // Execute the query
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // Return the city
        return city;
    }

    /**
     * Insert a city into the database
     */
    public void insert(City city) {
        try (Statement statement = connection.createStatement()) {
            // SQL query to insert a city into the database
            String insert = "INSERT INTO city(ID, Name, CountryCode, District, Population) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, city.getName());
            ps.setString(3, city.getCountryCode());
            ps.setString(4, city.getDistrict());
            ps.setInt(5, city.getPopulation());
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                city.setID(keys.getInt(1));
            }
            // Execute the query
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *  Update a city in the database with passed city object 
     */
    public Boolean update(City city) {
        Boolean success = true;
        String update = "UPDATE city SET population=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(update)) {
            ps.setInt(1, city.getPopulation());
            ps.setInt(2, city.getID());
            // Execute the query
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            success = false;
        }
        // Return success
        return success;
    }

    /**
     *  Delete a city from the database 
     */
    public Boolean delete(Integer pk) {
        Boolean success = false;
        // SQL query to delete a city from the database
        String delete = "DELETE FROM city WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, pk);
            // Execute the query
            ps.executeUpdate();
            success = true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // Return success
        return success;
    }

    public List<City> findCityByName(String name) {
        List<City> cities = new ArrayList<City>();
        // Query to find a city by its name
        String select = "SELECT * FROM city WHERE name=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, name);
            // Execute the query
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }

    public List<City> findCityByCountryCode(String countryCode) {
        List<City> cities = new ArrayList<City>();
        City city = new City();
        // Query to find a city by its country code
        String select = "SELECT * FROM city WHERE countryCode=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, countryCode);
            // Execute the query
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }

    public List<City> findCityPopulationOver1Million() {
        List<City> cities = new ArrayList<City>();
        City city = new City();
        // Query to find a city with population over 1 million
        String select = "SELECT * FROM city WHERE population > 1000000";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            // Execute the query
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }
}
