package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.NumberPlates;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "AddPlateXparcUserResponseDto")
public class AddPlateXparcUserResponseDto {
    public String email;
    public List<NumberPlates> numberPlates;

    public List<NumberPlates> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<NumberPlates> numberPlates) {
        this.numberPlates = numberPlates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
