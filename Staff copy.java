/*

CPCS 203 - ASSIGNMENT #3 | KAU HOSPITAL SYSTEM
Name : Faisal Bin Hassan
ID No : 2136143
Course : CPCS 203 - ZJ
Lab Instructer Name : Dr Ibrahim AlHarby

*/

package ASSIGNMENTS;

public abstract class Staff extends Person {
    private String specialization;
    private String staffID;

    //

    public Staff(int id, String name, String nationality, char gender, int phone, String specialization, String staffID) {
        super(id, name, nationality, gender, phone);
        this.specialization = specialization;
        this.staffID = staffID;
    }

    //

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    //

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                ", specialization='" + specialization + '\'' +
                ", staffID='" + staffID + '\'' +
                '}';
    }
}
