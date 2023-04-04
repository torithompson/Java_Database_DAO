package entities;

/**
 *  Country class to represent a country in the database
 */
public class Country {
    String Code; // PK
    String Name;
    String Continent;
    String Region;
    double SurfaceArea;
    Integer IndepYear;
    Integer Population;
    double LifeExpectancy;
    double GNP;
    double GNPOld;
    String LocalName;
    String GovernmentForm;
    String HeadOfState;
    Integer Capital;
    String Code2;

    //Getters and setters for Country

    //Get and set code
    public String getCode() {return Code;}
    public void setCode(String code) {
        this.Code = code;
    }
    //Get and set name
    public String getName() {return Name;}
    public void setName(String name) {
        Name = name;
    }
    //Get and set continent
    public String getContinent() {return Continent;}
    public void setContinent(String continent) {
        Continent = continent;
    }
    //Get and set region
    public String getRegion() {return Region;}
    public void setRegion(String region) {
        Region = region;
    }
    //Get and set surface area
    public double getSurfaceArea() {return SurfaceArea;}
    public void setSurfaceArea(double surfaceArea) {
        SurfaceArea = surfaceArea;
    }
    //Get and set independent year
    public Integer getIndepYear() {return IndepYear;}
    public void setIndepYear(Integer indepYear) {
        IndepYear = indepYear;
    }
    //Get and set population
    public Integer getPopulation() {return Population;}
    public void setPopulation(Integer population) {
        Population = population;
    }
    //Get and set life expectancy
    public double getLifeExpectancy() {return LifeExpectancy;}
    public void setLifeExpectancy(double lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }
    //Get and set GNP
    public double getGNP() {return GNP;}
    public void setGNP(double gNP) {
        GNP = gNP;
    }
    //Get and set GNP old
    public double getGNPOld() {return GNPOld;}
    public void setGNPOld(double gNPOld) {
        GNPOld = gNPOld;
    }
    //Get and set local name
    public String getLocalName() {return LocalName;}
    public void setLocalName(String localName) {
        LocalName = localName;
    }
    //Get and set government form
    public String getGovernmentForm() {return GovernmentForm;}
    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }
    //Get and set head of state
    public String getHeadOfState() {return HeadOfState;}
    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }
    //Get and set capital
    public Integer getCapital() {return Capital;}
    public void setCapital(Integer capital) {
        Capital = capital;
    }
    //Get and set code 2
    public String getCode2() {return Code2;}
    public void setCode2(String code2) {
        Code2 = code2;
    }
    //Return the country as a string
    @Override
    public String toString() {
        return "Country [Code=" + Code + ", Name=" + Name + ", Continent=" + Continent + ", Region=" + Region
                + ", SurfaceArea=" + SurfaceArea + ", IndepYear=" + IndepYear + ", Population=" + Population
                + ", LifeExpectancy=" + LifeExpectancy + ", GNP=" + GNP + ", GNPOld=" + GNPOld + ", LocalName="
                + LocalName + ", GovernmentForm=" + GovernmentForm + ", HeadOfState=" + HeadOfState + ", Capital="
                + Capital + ", Code2=" + Code2 + "]";
    }
}
