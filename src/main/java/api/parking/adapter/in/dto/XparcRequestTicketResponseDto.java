package api.parking.adapter.in.dto;

import api.parking.domain.xparc.dto.ticket.FeeDto;

public class XparcRequestTicketResponseDto {
    private String customreference;
    private int deviceid;
    private int entrance2exitGraceTime;
    private String entrancedate;
    private String entrancedevicename;
    private String exitdate;
    private String exitdevicename;
    private String externalcardnumber;
    private FeeDto fee;
    private String firstname;
    private String numberplate;
    private FeeDto paid;
    private int payment2exitGraceTime;
    private String paymentdate;
    private String paymentdevicename;
    private String paymenttype;
    private int receiptnumber;
    private String receipttext;
    private FeeDto remainingBalance;
    private int remainingPoints;
    private String surname;
    private int ticketnumber;
    private String user;

    public XparcRequestTicketResponseDto() {
    }

    public String getCustomreference() {
        return customreference;
    }

    public void setCustomreference(String customreference) {
        this.customreference = customreference;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public int getEntrance2exitGraceTime() {
        return entrance2exitGraceTime;
    }

    public void setEntrance2exitGraceTime(int entrance2exitGraceTime) {
        this.entrance2exitGraceTime = entrance2exitGraceTime;
    }

    public String getEntrancedate() {
        return entrancedate;
    }

    public void setEntrancedate(String entrancedate) {
        this.entrancedate = entrancedate;
    }

    public String getEntrancedevicename() {
        return entrancedevicename;
    }

    public void setEntrancedevicename(String entrancedevicename) {
        this.entrancedevicename = entrancedevicename;
    }

    public String getExitdate() {
        return exitdate;
    }

    public void setExitdate(String exitdate) {
        this.exitdate = exitdate;
    }

    public String getExitdevicename() {
        return exitdevicename;
    }

    public void setExitdevicename(String exitdevicename) {
        this.exitdevicename = exitdevicename;
    }

    public String getExternalcardnumber() {
        return externalcardnumber;
    }

    public void setExternalcardnumber(String externalcardnumber) {
        this.externalcardnumber = externalcardnumber;
    }

    public FeeDto getFee() {
        return fee;
    }

    public void setFee(FeeDto fee) {
        this.fee = fee;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public FeeDto getPaid() {
        return paid;
    }

    public void setPaid(FeeDto paid) {
        this.paid = paid;
    }

    public int getPayment2exitGraceTime() {
        return payment2exitGraceTime;
    }

    public void setPayment2exitGraceTime(int payment2exitGraceTime) {
        this.payment2exitGraceTime = payment2exitGraceTime;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getPaymentdevicename() {
        return paymentdevicename;
    }

    public void setPaymentdevicename(String paymentdevicename) {
        this.paymentdevicename = paymentdevicename;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public int getReceiptnumber() {
        return receiptnumber;
    }

    public void setReceiptnumber(int receiptnumber) {
        this.receiptnumber = receiptnumber;
    }

    public String getReceipttext() {
        return receipttext;
    }

    public void setReceipttext(String receipttext) {
        this.receipttext = receipttext;
    }

    public FeeDto getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(FeeDto remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }

    public void setRemainingPoints(int remainingPoints) {
        this.remainingPoints = remainingPoints;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(int ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
