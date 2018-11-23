package com.futureGadgeLab.app;
import java.math.BigDecimal;
import java.util.Date;

public class Parking {
    private int ticketId, lotId;
    private Date entryTime, exitTime;
    private BigDecimal fee;
    protected Boolean ticketIssued;

    /**
     * Used to establish attributes within a row in the Parking table
     * @param
     */

    public Parking() {
    }

    public Parking(int ticketId) {
        this.ticketId = ticketId;
    }

    public Parking(int ticketId, int lotId, Date entryTime, Date exitTime){
        this.ticketId = ticketId;
        this.lotId = lotId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Parking(int ticketId, int lotId, Date entryTime, Date exitTime, BigDecimal fee){
        this.ticketId = ticketId;
        this.lotId = lotId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public int getTicketId(){
        return ticketId;
    }
    public void setTicketId(int ticketId){
        this.ticketId = ticketId;
    }

    public int getLotId(int lotId){
        return lotId; }
    public void setLotId(int lotId) { this.lotId = lotId; }

    public Date getEntryTime(){
        return entryTime;
    }
    public void setEntryTime(Date entryTime){
        this.entryTime = entryTime;
    }

    public Date getExitTime(){
        return exitTime;
    }
    public void setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }

    public BigDecimal getFee(){
        return fee;
    }
    public void setFee(BigDecimal fee){
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("Parking" + "\nTicket Id: " + ticketId + "\nLot Id: " + lotId + "\nEntry Time:" + entryTime + "\nExit Time: " + exitTime + "\nFee" + fee);
    }
}
