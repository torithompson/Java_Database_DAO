package entities;

/**
 *  City class to represent a city in the database
 */
public class City {
    Integer ID; // PK
    String Name;
    String CountryCode;
    String District;
    Integer Population;

    // Getters and Setters
    //Return the ID of the city
    public Integer getID() {
        return ID;
    }
    //Set the ID of the city
    public void setID(Integer ID) {
        this.ID = ID;
    }
    //Return the name of the city
    public String getName() {
        return Name;
    }
    //Set the name of the city
    public void setName(String name) {
        Name = name;
    }
    //Return the country code of the city
    public String getCountryCode() {
        return CountryCode;
    }
    //Set the country code of the city
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    //Return the district of the city
    public String getDistrict() {
        return District;
    }
    //Set the district of the city
    public void setDistrict(String district) {
        District = district;
    }
    //Return the population of the city
    public Integer getPopulation() {
        return Population;
    }
    //Set the population of the city
    public void setPopulation(Integer population) {
        Population = population;
    }   
    //Return the city as a string 
    @Override
    public String toString() {
        return "City [ID=" + ID + ", Name=" + Name + ", CountryCode=" + CountryCode + ", District=" + District
                + ", Population=" + Population + "]";
    }
}
