package ex.com.ticketexample.model;

import org.threeten.bp.LocalDateTime;

/* Model of the application */
public class Ticket {
    public enum RailQuotas {
        GENERAL,
        TATKAL,
        DEFENCE,
        FOREIGN_TOURIST
    };

    Long pnrNo;
    Integer trainNo;
    Long transactionId;
    RailQuotas quota;

    Double ticketFare;
    Double gstCharge;
    Double totalFare;

    String fromStation;
    String toStation;

    String schDepDate;
    String schArrDate;

    String passFname;
    String passMname;
    String passLname;
    String mobileNo;
    String passAddress;

    int adults;
    int child;

    public Ticket(Long pnrNo, Integer trainNo) {
        this.pnrNo = pnrNo;
        this.trainNo = trainNo;
    }

    public Long getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(Long pnrNo) {
        this.pnrNo = pnrNo;
    }

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public RailQuotas getQuota() {
        return quota;
    }

    public void setQuota(RailQuotas quota) {
        this.quota = quota;
    }

    public Double getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(Double ticketFare) {
        this.ticketFare = ticketFare;
    }

    public Double getGstCharge() {
        return gstCharge;
    }

    public void setGstCharge(Double gstCharge) {
        this.gstCharge = gstCharge;
    }

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Double totalFare) {
        this.totalFare = totalFare;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getSchDepDate() {
        return schDepDate;
    }

    public void setSchDepDate(String schDepDate) {
        this.schDepDate = schDepDate;
    }

    public String getSchArrDate() {
        return schArrDate;
    }

    public void setSchArrDate(String schArrDate) {
        this.schArrDate = schArrDate;
    }

    public String getPassFname() {
        return passFname;
    }

    public void setPassFname(String passFname) {
        this.passFname = passFname;
    }

    public String getPassMname() {
        return passMname;
    }

    public void setPassMname(String passMname) {
        this.passMname = passMname;
    }

    public String getPassLname() {
        return passLname;
    }

    public void setPassLname(String passLname) {
        this.passLname = passLname;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassAddress() {
        return passAddress;
    }

    public void setPassAddress(String passAddress) {
        this.passAddress = passAddress;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }
}
