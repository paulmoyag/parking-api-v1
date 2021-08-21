package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcUpdatePostPaymentResponseDto")
public class XparcUpdatePostPaymentResponseDto {
    public String id;
    public Boolean isPostPaymentAllowed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsPostPaymentAllowed() {
        return isPostPaymentAllowed;
    }

    public void setIsPostPaymentAllowed(Boolean isPostPaymentAllowed) {
        this.isPostPaymentAllowed = isPostPaymentAllowed;
    }
}
