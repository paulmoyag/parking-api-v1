package api.parking.domain.xparc.dto.ticket;

public class ActiveDebtResDto {
    public FeeDto fee;

    public FeeDto getFee() {
        return fee;
    }

    public void setFee(FeeDto fee) {
        this.fee = fee;
    }
}
