/*

CPCS 203 - ASSIGNMENT #3 | KAU HOSPITAL SYSTEM
Name : Faisal Bin Hassan
ID No : 2136143
Course : CPCS 203 - ZJ
Lab Instructer Name : Dr Ibrahim AlHarby

*/

package ASSIGNMENTS;


public class Medicine {
    private int medicineCode;
    private String name;
    private double price;

    //

    public Medicine(int medicineCode, String name, double price) {
        this.medicineCode = medicineCode;
        this.name = name;
        this.price = price;
    }

    //

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineCode=" + medicineCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}