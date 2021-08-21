package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.NumberPlates;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "AddPlateXparcUserRequestDto", description = "Add plate in xparc request")
public class AddPlateXparcUserRequestDto {

    private String userId;
    private List<NumberPlates> numberPlates;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<NumberPlates> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<NumberPlates> numberPlates) {
        this.numberPlates = numberPlates;
    }
}
