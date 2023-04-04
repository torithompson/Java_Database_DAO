package entities;

// Language entity class with composite primary key (country code and language) 
// The composite primary key is a nested class of the entity class

public class Language {
    PK countryLanguage;
    Boolean isOfficial;
    Float percentage;
    
    //Constructor for Language
    public Language(String countryCode, String language, Boolean isOfficial, Float percentage) {
        this.countryLanguage = new PK(countryCode, language);
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }
    // PK class for Language
    public static class PK {
        public PK(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }

        String countryCode;
        String language;
    }
    // Override the toString method for Language
    @Override
    public String toString() {
        return "Country code: " + countryLanguage.countryCode + ", isOfficial: " + isOfficial + ", percentage: "
                + percentage + ", language: " + countryLanguage.language;
    }
}
