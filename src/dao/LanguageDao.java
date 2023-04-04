package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Language;
import entities.Language.PK;

/**
 *  LanguageDao class to represent a language in the database
 */
public class LanguageDao implements Dao<Language, Language.PK> {
    Connection connection;
    //Constructor for LanguageDao
    public LanguageDao(Connection connection) {
        this.connection = connection;
    }
    //Return a list of all languages in the database
    public List<Language> findAll() {
        //Create a list of languages
        List<Language> languages = new ArrayList<Language>();

        try (Statement statement = connection.createStatement()) {
            //Execute the query
            ResultSet result = statement.executeQuery("SELECT * FROM CountryLanguage");

            while (result.next()) {
                Language language = new Language(result.getString("CountryCode"), result.getString("Language"),
                        result.getBoolean("IsOfficial"), result.getFloat("Percentage"));
                languages.add(language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return the list of languages
        return languages;
    }
    //Insert a new language into the database
    public void insert(Language language) {
    }
    //Update a language in the database
    public Boolean update(Language language) {
        return true;
    }
    //Find a language by its primary key
    public Language findByID(PK pk) {
        return null;
    }
    //Delete a language from the database
    public Boolean delete(PK pk) {
        return true;
    }
}
