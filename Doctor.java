package ASSIGNMENTS;

public class Doctor extends Staff {
    private double consultationFees;

    //

    public Doctor( double consultationFees,  String staffID, String specialization, int id, String name,
                   String nationality, char gender, int phone) {
        super(id, name, nationality, gender, phone, specialization, staffID);
        this.consultationFees = consultationFees;
    }

    //

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    //

    @Override
    public String toString() {
        return "Doctor{" +
                "consultationFees=" + consultationFees +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                '}';
    }
}
