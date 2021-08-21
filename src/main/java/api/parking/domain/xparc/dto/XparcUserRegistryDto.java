package api.parking.domain.xparc.dto;

import java.util.List;

public class XparcUserRegistryDto {
    public String countryCode;
    public boolean isActive;
    public String firstName;
    public String lastName;
    public boolean isPostPaymentAllowed;
    public boolean isWalletPaymentAllowed;
    public List<NumberPlates> numberPlates;
    public String validityFrom;
    public String validityUntil;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPostPaymentAllowed() {
        return isPostPaymentAllowed;
    }

    public void setPostPaymentAllowed(boolean isPostPaymentAllowed) {
        this.isPostPaymentAllowed = isPostPaymentAllowed;
    }

    public boolean isWalletPaymentAllowed() {
        return isWalletPaymentAllowed;
    }

    public void setWalletPaymentAllowed(boolean isWalletPaymentAllowed) {
        this.isWalletPaymentAllowed = isWalletPaymentAllowed;
    }

    public List<NumberPlates> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<NumberPlates> numberPlates) {
        this.numberPlates = numberPlates;
    }

    public String getValidityFrom() {
        return validityFrom;
    }

    public void setValidityFrom(String validityFrom) {
        this.validityFrom = validityFrom;
    }

    public String getValidityUntil() {
        return validityUntil;
    }

    public void setValidityUntil(String validityUntil) {
        this.validityUntil = validityUntil;
    }
}
