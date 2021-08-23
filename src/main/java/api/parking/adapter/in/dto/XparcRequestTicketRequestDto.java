package api.parking.adapter.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "XparcRequestTicketRequestDto", description = "Get tickets request from xparc user")
public class XparcRequestTicketRequestDto {
    private Long ticketnumber;
    private String externalcardnumber;
    private String numberplate;
    private String barcode;
    private String qrtext;

    public XparcRequestTicketRequestDto() {
    }

    public Long getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(Long ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public String getExternalcardnumber() {
        return externalcardnumber;
    }

    public void setExternalcardnumber(String externalcardnumber) {
        this.externalcardnumber = externalcardnumber;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQrtext() {
        return qrtext;
    }

    public void setQrtext(String qrtext) {
        this.qrtext = qrtext;
    }
}
