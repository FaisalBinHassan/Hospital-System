/*

CPCS 203 - ASSIGNMENT #3 | KAU HOSPITAL SYSTEM
Name : Faisal Bin Hassan
ID No : 2136143
Course : CPCS 203 - ZJ
Lab Instructer Name : Dr Ibrahim AlHarby

*/

package ASSIGNMENTS;

public class Person {
    int id;
    String name;
    String nationality;
    char gender;
    int phone;

    //

    public Person(int id, String name, String nationality, char gender, int phone) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        this.phone = phone;
    }

    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    //

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                '}';
    }
}
