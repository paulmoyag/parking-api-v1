package api.parking.adapter.in.dto.activeDebt;

import java.util.List;

public class GetActiveDebtRequestDto {
    public List<String> numberPlates;

    public List<String> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<String> numberPlates) {
        this.numberPlates = numberPlates;
    }
}
