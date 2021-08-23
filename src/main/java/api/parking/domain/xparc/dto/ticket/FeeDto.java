package api.parking.domain.xparc.dto.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeeDto {
    public String currencyCode;
    public Integer fractionDigits;
    public Double value;
    @JsonProperty("Value")
    public Double ValueTicket;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getFractionDigits() {
        return fractionDigits;
    }

    public void setFractionDigits(Integer fractionDigits) {
        this.fractionDigits = fractionDigits;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValueTicket() { return ValueTicket; }

    public void setValueTicket(Double valueTicket) { ValueTicket = valueTicket; }
}
