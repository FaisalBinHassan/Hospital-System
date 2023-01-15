/*

CPCS 203 - ASSIGNMENT #3 | KAU HOSPITAL SYSTEM
Name : Faisal Bin Hassan
ID No : 2136143
Course : CPCS 203 - ZJ
Lab Instructer Name : Dr Ibrahim AlHarby

*/

package ASSIGNMENTS;

public class Room {
    private int roomNo;
    private String floor;
    private String block;
    private double charges;

    //

    public Room(int roomNo, String floor, String block, double charges) {
        this.roomNo = roomNo;
        this.floor = floor;
        this.block = block;
        this.charges = charges;
    }

    //

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    //

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", floor='" + floor + '\'' +
                ", block='" + block + '\'' +
                ", charges=" + charges +
                '}';
    }
}