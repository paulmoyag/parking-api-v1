package api.parking.domain.xparc.dto;

public class NumberPlates {
    public String countryCode;
    public String numberPlate;

    public NumberPlates() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public NumberPlates(String countryCode, String numberPlate) {
        this.countryCode = countryCode;
        this.numberPlate = numberPlate;
    }
}
