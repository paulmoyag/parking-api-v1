package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.ticket.FeeDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcUserTotalDebtResponseDto", description = " Get User total debt")
public class XparcUserGetTotalDebtResponseDto {
    private FeeDto totalDebt;

    public FeeDto getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(FeeDto totalDebt) {
        this.totalDebt = totalDebt;
    }
}
