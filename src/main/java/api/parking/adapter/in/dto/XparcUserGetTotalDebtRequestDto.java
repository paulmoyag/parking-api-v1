package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcUserGetTotalDebtRequestDto", description = " Get User total debt in xparc request")
public class XparcUserGetTotalDebtRequestDto {
    private String userId;
    private String numberplate;
    private Long ticketNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
