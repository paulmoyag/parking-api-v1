package api.parking.domain.xparc.dto.ticket;

public class FeeDto {
    public String currencyCode;
    public Integer fractionDigits;
    public Double Value;

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
        return Value;
    }

    public void setValue(Double Value) {
        this.Value = Value;
    }
}
