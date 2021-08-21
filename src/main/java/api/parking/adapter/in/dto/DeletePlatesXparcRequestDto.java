package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Schema(name = "DeletePlatesXparcRequestDto", description = "Delete plates to xparc user")
public class DeletePlatesXparcRequestDto {
    @NotEmpty
    private String userId;
    @NotEmpty
    @NotBlank
    private List<String> numberPlates;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<String> numberPlates) {
        this.numberPlates = numberPlates;
    }
}
