package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "AddXparcUserResponseDto")
public class AddXparcUserResponseDto {
    public String id;
    public String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
