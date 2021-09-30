package ir.maktab.model;

public class WorkUnit {
    private int workUnitID;
    private String name;
    private String phoneNumber;

    public WorkUnit() {
    }

    public WorkUnit(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public WorkUnit(int workUnitID, String name, String phoneNumber) {
        this.workUnitID = workUnitID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWorkUnitID() {
        return workUnitID;
    }

    public void setWorkUnitID(int workUnitID) {
        this.workUnitID = workUnitID;
    }
}
