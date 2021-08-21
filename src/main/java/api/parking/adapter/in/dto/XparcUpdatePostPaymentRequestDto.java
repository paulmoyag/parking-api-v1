package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcUpdatePostpaymentRequestDto", description = "Update Postpayment in xparc request")
public class XparcUpdatePostPaymentRequestDto {

    private String userId;
    private Boolean postPaymentStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getPostPaymentStatus() {
        return postPaymentStatus;
    }

    public void setPostPaymentStatus(Boolean postPaymentStatus) {
        this.postPaymentStatus = postPaymentStatus;
    }
}
