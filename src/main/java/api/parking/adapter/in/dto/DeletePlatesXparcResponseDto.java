package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.NumberPlates;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "DeletePlatesXparcResponseDto")
public class DeletePlatesXparcResponseDto {
    public String email;
    public List<NumberPlates> numberPlates;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NumberPlates> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<NumberPlates> numberPlates) {
        this.numberPlates = numberPlates;
    }
}
