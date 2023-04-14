package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Country;

/**
 *  CountryDao class to represent a country in the database
 */
public class CountryDao implements Dao<Country, String> {
    Connection connection;
    //Constructor for CountryDao
    public CountryDao(Connection connection) {
        this.connection = connection;
    }
    //Return a list of all countries in the database
    public List<Country> findAll() {
        //Create a list of countries
        List<Country> countries = new ArrayList<Country>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM country");
            //Loop through the result set and add each country to the list
            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGNP(result.getDouble("GNP"));
                country.setGNPOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                //Add the country to the list
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return the list of countries
        return countries;
    }

    /**
     *  Find a country by its primary key 
     */
    public Country findByID(String pk) {
        //Create a new country
        Country country = new Country();
        //Create a select statement
        String select = "SELECT * FROM country WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, pk);
            ResultSet result = ps.executeQuery();
            //If the result set has a country, set the country's attributes 
            if (result.next()) {
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGNP(result.getDouble("GNP"));
                country.setGNPOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //Return the country
        return country;
    }

    /**
     *  Insert a country into the database 
     */
    public void insert(Country country) {
        try (Statement statement = connection.createStatement()) {
            //Create an insert statement
            String insert = "INSERT INTO country VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //Create a prepared statement
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.setString(3, country.getContinent());
            ps.setString(4, country.getRegion());
            ps.setDouble(5, country.getSurfaceArea());
            ps.setInt(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setDouble(8, country.getLifeExpectancy());
            ps.setDouble(9, country.getGNP());
            ps.setDouble(10, country.getGNPOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());
            //Execute the prepared statement
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *  Update a country in the database 
     */
    public Boolean update(Country country) {
        // Create an update statement
        Boolean success = true;
        //Create a prepared statement
        String update = "UPDATE country SET lifeexpectancy=? WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(update);) {
            ps.setDouble(1, country.getLifeExpectancy());
            ps.setString(2, country.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            success = false;
        }
        //Return the success of the update
        return success;
    }

    /**
     *  Delete a country from the database
     */
    public Boolean delete(String pk) {
        //Create a delete statement
        Boolean success = false;
        String delete = "DELETE FROM country WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setString(1, pk);
            //Execute the prepared statement
            ps.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //Return the success of the delete
        return success;
    }

    // Find country by name
    public List<Country> findByName(String name) {
        // Create a list of countries
        List<Country> countries = new ArrayList<Country>();
        // Create a select statement
        String select = "SELECT * FROM country WHERE name=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            // Loop through the result set and add each country to the list
            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGNP(result.getDouble("GNP"));
                country.setGNPOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                // Add the country to the list
                countries.add(country);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // Return the list of countries
        return countries;
    }

    // Find all countries in a given region
    public List<Country> findByRegion(String region) {
        // Create a list of countries
        List<Country> countries = new ArrayList<Country>();
        // Create a select statement
        String select = "SELECT * FROM country WHERE region=?";
        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, region);
            ResultSet result = ps.executeQuery();
            // Loop through the result set and add each country to the list
            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGNP(result.getDouble("GNP"));
                country.setGNPOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                // Add the country to the list
                countries.add(country);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // Return the list of countries
        return countries;
    }
}
