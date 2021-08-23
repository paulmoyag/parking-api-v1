package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.SaleRecord;
import api.parking.domain.xparc.dto.ticket.FeeDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcUserGetOutstandingFeeResponseDto", description = " Get User Outstanding Fee in xparc response")
public class XparcUserGetOutstandingFeeResponseDto {
    private FeeDto totalFee;
    private SaleRecord[] saleRecords;

    public XparcUserGetOutstandingFeeResponseDto() {
    }

    public XparcUserGetOutstandingFeeResponseDto(FeeDto totalFee, SaleRecord[] saleRecords) {
        this.totalFee = totalFee;
        this.saleRecords = saleRecords;
    }

    public FeeDto getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(FeeDto totalFee) {
        this.totalFee = totalFee;
    }

    public SaleRecord[] getSaleRecords() {
        return saleRecords;
    }

    public void setSaleRecords(SaleRecord[] saleRecords) {
        this.saleRecords = saleRecords;
    }
}
