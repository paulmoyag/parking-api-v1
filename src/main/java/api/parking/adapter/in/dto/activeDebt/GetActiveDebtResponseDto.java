package api.parking.adapter.in.dto.activeDebt;

public class GetActiveDebtResponseDto {
    public Double debtValue;
    public Boolean hasActiveDebt;

    public Double getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(Double debtValue) {
        this.debtValue = debtValue;
    }

    public Boolean getHasActiveDebt() {
        return hasActiveDebt;
    }

    public void setHasActiveDebt(Boolean hasActiveDebt) {
        this.hasActiveDebt = hasActiveDebt;
    }
}
