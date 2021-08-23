package api.parking.domain.xparc.dto;

public class SaleRecord {
    private String installationId;
    private int salesNo;

    public SaleRecord() {
    }

    public String getInstallationId() {
        return installationId;
    }

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    public int getSalesNo() {
        return salesNo;
    }

    public void setSalesNo(int salesNo) {
        this.salesNo = salesNo;
    }
}
