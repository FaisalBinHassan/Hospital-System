/*

--------- CODE EXPLANATION ---------

This code manages to solve a hospital.
The code is organised into a couple of stages :

PART I :
STAGE 1 ==> MAIN : Aims to read data from input file, and manages to spread data into different methods accordingly.
STAGE 2 ==> METHODS LISTED : Methods such as Doctors, Nurse, Room and other. Recieve and spread data to it's supposed class array.

PART II :
==> PRINTING PHASE : This methods takes all data from all sectored methods, and prints data to the output file.

-------------------------------------

 */


package ASSIGNMENTS;

// Importing Libriaries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/*
PART I :
        STAGE 1 ==> MAIN : Aims to read data from input file, and manages to spread data into different methods accordingly.
 */


public class KAUHOSPITALSystem_submitted {
    public static void main(String[] args) throws FileNotFoundException {

        // input file ( data must be read from )
        File file = new File("/Users/Faisal/Desktop/input.txt");

        // input file ( checker if existed )
        if (!file.exists()) {
            System.out.println("File 'input file' not found");
            System.exit(0);
        }

        // inisiliazing to READ and PRINT from/and/to files
        Scanner reader = new Scanner(file);
        PrintWriter output = new PrintWriter("/Users/Faisal/Desktop/Output_Hospital copy.txt");

        // Arrays | used in methods below, to store data to it's suppossed class
        Room[] HRooms = new Room[reader.nextInt()];
        Medicine[] HMedicines = new Medicine[reader.nextInt()];
        Person[] hpersons_array = new Person[reader.nextInt()];
        ArrayList<Person> HPersons = new ArrayList<>(hpersons_array.length);
        Doctor[] doctors = new Doctor[hpersons_array.length];
        Nurse[] nurses = new Nurse[hpersons_array.length];
        Patient[] patients = new Patient[hpersons_array.length];

        // The reading phase starts, reader reads from file and checks if a certain command found,
        // then its reffered to supposed method
        String Command = "";
        while(  !Command.equals("Quit") ) {

            Command = reader.next();

            if ( Command.equals("Add_Room") )
            {
                getRoom(input(file), HRooms);
            }
            if ( Command.equals("Add_Medicine") )
            {
                getMedicine(input(file), HMedicines);
            }
            if ( Command.equals("Add_Doctor") )
            {
                getDoctor(input(file), doctors, HPersons);
            }
            if ( Command.equals("Add_Nurse") )
            {
                getNurse(input(file), HPersons, nurses);
            }
            if ( Command.equals("Add_Patient")
                    || Command.equals("Assign_Doctor_Patient")
                    || Command.equals("Assign_Room_Patient")
                    || Command.equals("Assign_Medicine_Patient"))
            {
                getPatient(input(file), getDoctor(input(file), doctors, HPersons), getRoom(input(file), HRooms), getMedicine(input(file), HMedicines), HPersons, patients);
            }

            if ( Command.equals("Print_Bill")) {

                printBill(
                        input(file),
                        output,
                        getNurse(input(file), HPersons, nurses),
                        getDoctor(input(file), doctors, HPersons),
                        getRoom(input(file), HRooms),
                        getMedicine(input(file), HMedicines),
                        getPatient(input(file), getDoctor(input(file), doctors, HPersons), getRoom(input(file), HRooms), getMedicine(input(file), HMedicines), HPersons, patients)  );
            }
        }

        // File closes after reading...
        output.close();
    }

    /*

    STAGE 2 ==> METHODS LISTED : Methods such as Doctors, Nurse, Room and other.
    Recieve and spread data to it's supposed class array.

     */

    public static Scanner input(File file) throws FileNotFoundException {
        // Method used to retrieve file and return if needed..
        return new Scanner(file);
    }


    private static Room[] getRoom(Scanner reader, Room[] HRooms) {

        // After the command (Add_Room) has been found and sent to this method,
        // Loop starts to save data from file to the ROOM array class..
        String Command = "";
        int room_position = 0;

        while (reader.hasNext()) {

            Command = reader.next();


            if (Command.equalsIgnoreCase("Add_Room")) {
                // variables used to store data to its accorded variable..
                int roomNo;
                String floor, block;
                double charges;

                // variables used to read data from file
                roomNo = reader.nextInt();
                floor = reader.next();
                block = reader.next();
                charges = reader.nextDouble();

                // once all are saved, them now data is sent to the class array
                HRooms[room_position] = new Room(roomNo, floor, block, charges);

                // the array position is being incremented
                room_position++;
            }
        }

        // Once all data from command has been gotten, the final array is returned
        return HRooms;
    }

    //

    private static Medicine[] getMedicine(Scanner reader, Medicine[] HMedicines) {

        // After the command (Add_Medicine) has been found and sent to this method,
        // Loop starts to save data from file to the MEDICINE array class..
        String Command = "";
        int medicine_position = 0;

        while (reader.hasNext()) {

            Command = reader.next();

            if (Command.equalsIgnoreCase("Add_Medicine")) {
                // variables used to store data to its accorded variable..
                int mediceCode;
                String name;
                double price;

                // variables used to read data from file
                mediceCode = reader.nextInt();
                name = reader.next();
                price = reader.nextDouble();

                // once all are saved, them now data is sent to the class array
                HMedicines[medicine_position] = new Medicine(mediceCode, name, price);

                // the array position is being incremented
                medicine_position++;
            }
        }
        // Once all data from command has been gotten, the final array is returned
        return HMedicines;
    }

    //

    private static Doctor[] getDoctor(Scanner reader, Doctor[] doctors, ArrayList<Person> HPersons) {

        // After the command (Add_Doctor) has been found and sent to this method,
        // Loop starts to save data from file to the DOCTOR array class..
        String Command = "";
        int Doctor_position = 0;

        while (reader.hasNext()) {

            Command = reader.next();

            if (Command.equalsIgnoreCase("Add_Doctor")) {
                // variables used to store data to its accorded variable..
                double consultationFees;
                String staffid, specialization, name, nationality;
                int id, phone;
                char gender;

                // variables used to read data from file
                consultationFees = reader.nextDouble();
                staffid = reader.next();
                specialization = reader.next();
                id = reader.nextInt();
                name = reader.next();
                nationality = reader.next();
                gender = reader.next().charAt(0);
                phone = reader.nextInt();

                // once all are saved, them now data is sent to the class array
                doctors[Doctor_position] = new Doctor(consultationFees, staffid, specialization, id,
                        name, nationality, gender, phone);
                HPersons.add(doctors[Doctor_position]);

                // the array position is being incremented
                Doctor_position++;

            }
        }

        //Doctor[] realDoctors = (Doctor[]) getNEWarrays(doctors);

        // Once the previous array has saved NULL results,
        // we're now slotting a new arrays for the same class WITHOUT null results..
        int ArrayLength = 0;
        for (Doctor x : doctors)
        {
            if (x != null)
                ArrayLength++;
        }

        Doctor[] doc_CLEANER_array = new Doctor[ArrayLength];

        System.arraycopy(doctors, 0, doc_CLEANER_array, 0, ArrayLength);

        // Once all data from command has been gotten, the final array is returned
        return doc_CLEANER_array;
    }

    //

    private static Nurse[] getNurse(Scanner reader,ArrayList<Person> HPersons,Nurse[] nurses ) {

        // After the command (Add_Nurse) has been found and sent to this method,
        // Loop starts to save data from file to the NURSE array class..
        String Command = "";
        int Nurse_position = 0;

        while (reader.hasNext()) {

            Command = reader.next();

            if (Command.equalsIgnoreCase("Add_Nurse")) {
                // variables used to store data to its accorded variable..
                int experience;
                String staffid, specialization, name, nationality;
                int id, phone;
                char gender;

                // variables used to read data from file
                experience = reader.nextInt();
                staffid = reader.next();
                specialization = reader.next();
                id = reader.nextInt();
                name = reader.next();
                nationality = reader.next();
                gender = reader.next().charAt(0);
                phone = reader.nextInt();

                // once all are saved, them now data is sent to the class array
                nurses[Nurse_position] = new Nurse(experience, staffid, specialization, id,
                        name, nationality, gender, phone);
                HPersons.add(nurses[Nurse_position]);

                // the array position is being incremented
                Nurse_position++;
            }
        }

        //Nurse[] realNurses = (Nurses[]) getNEWarrays(nurses);


        // Once the previous array has saved NULL results,
        // we're now slotting a new arrays for the same class WITHOUT null results..
        int ArrayLength = 0;
        for (Nurse x : nurses)
        {
            if (x != null)
                ArrayLength++;
        }

        Nurse[] nurs_CLEANER_array = new Nurse[ArrayLength];

        System.arraycopy(nurses, 0, nurs_CLEANER_array, 0, ArrayLength);

        // Once all data from command has been gotten, the final array is returned
        return nurs_CLEANER_array;
    }

    //
    private static Object[] getNEWarrays(Object[] array) {


        int ArrayLength = 0;
        for (Object x : array)
        {
            if (array != null)
                ArrayLength++;
        }

        Object[] CLEANER_array = new Object[ArrayLength];

        System.arraycopy(array, 0, CLEANER_array, 0, ArrayLength);


        return CLEANER_array;
    }

    private static Patient[] getPatient(Scanner input, Doctor[] doctors, Room[] rooms, Medicine[] medicines, ArrayList<Person> HPersons, Patient[] patients) {


        int count_patient = 0;

        Patient[] patients_CLEANER_array = new Patient[0];

        while (input.hasNext()) {
            String Command = input.next();

            // After the command (Add_Patient) has been found and sent to this method,
            // Loop starts to save data from file to the PATIENT array class..
            if (Command.equals("Add_Patient")) {

                // variables used to store data to its accorded variable..
                String illness, bloodGroup, name, nationality;
                int id, phone, totalMedicine;
                char gender;

                // variables used to read data from file
                illness = input.next();
                bloodGroup = input.next();
                id = input.nextInt();
                name = input.next();
                nationality = input.next();
                gender = input.next().charAt(0);
                phone = input.nextInt();
                totalMedicine = input.nextInt();

                // once all are saved, them now data is sent to the class array
                patients[count_patient] = new Patient(illness, bloodGroup, id, name, nationality, gender, phone, totalMedicine);

                // the array position is being incremented
                count_patient++;
            }

            // Once the previous array has saved NULL results,
            // we're now slotting a new arrays for the same class WITHOUT null results..
            int ArrayLength = 0;
            for (Patient x : patients) {
                if (x != null)
                    ArrayLength++;
            }

            // Once all data from command has been gotten, the final array is made..
            patients_CLEANER_array = new Patient[ArrayLength];

            // And copied with it's NO NULLed values..
            System.arraycopy(patients, 0, patients_CLEANER_array, 0, ArrayLength);


            // -- ASSINING STAGE BEGINS --

            // First assign command, starts on processing data..
            if (Command.equals("Assign_Doctor_Patient")) {

                // Both data from file is being saved to certain variables
                int doctorID = input.nextInt();
                int patientID = input.nextInt();

                // for loop used to check if :
                // 1) patient from file is found in the patients records
                // 2) doctor from file is found in the doctors records
                for (Patient patient : patients_CLEANER_array) {
                    if (patientID == patient.getId()) {
                        for (Doctor doctor : doctors) {

                            // if found, then assign the patient to the doctor found
                            if (doctorID == doctor.getId()) {
                                patient.setDoctor(doctor);
                            }
                        }
                    }
                }
            }

            // second assigned command, Processing data..
            if (Command.equals("Assign_Room_Patient")) {

                // Both data from file is being saved to certain variables
                int roomNo = input.nextInt();
                int patientID = input.nextInt();

                // for loop used to check if :
                // 1) patient from file is found in the patients records
                // 2) room from file is found in the rooms records
                for (Patient patient : patients_CLEANER_array) {
                    if (patientID == patient.getId()) {
                        for (Room room : rooms) {

                            // if found, then assign the patient to the room found
                            if (roomNo == room.getRoomNo()) {
                                patient.setRoom(room);
                            }
                        }
                    }
                }
            }

            // third assignment command, Processing data..
            if (Command.equals("Assign_Medicine_Patient")) {

                // Both data from file is being saved to certain variables
                int patientID = input.nextInt();
                int totalMedicine = input.nextInt();
                int[] medicinesInputs = new int[totalMedicine];

                // loop used to store an array with the patient file and the number of medicines
                for (int medicinesInput = 0; medicinesInput < medicinesInputs.length; medicinesInput++) {
                    medicinesInputs[medicinesInput] = input.nextInt();
                }

                int medicineAvailable = 0;

                // for loop used to check if :
                // 1) patient from file is found in the patients records
                // 2) number of medicine from file is found with same number in the medicines records
                // 3) if the medicine with same numbers are found the same..
                for (Patient patient : patients_CLEANER_array) {
                    if (patientID == patient.getId()) {
                        if (totalMedicine == patient.getTotalMedicine()) {
                            for (Medicine medicine : medicines) {
                                for (int medicinesInput : medicinesInputs) {
                                    if (medicine.getMedicineCode() == medicinesInput) {
                                        medicineAvailable++;
                                    }
                                }
                            }

                            // is same number of meds occur to the same patient data, the now we compare
                            // if medicines are also the same...
                            if (medicineAvailable == totalMedicine) {
                                patient.setMedicine(new Medicine[totalMedicine]);
                                for (int m = 0; m < patient.getMedicine().length; m++) {
                                    for (Medicine medicine : medicines) {
                                        if (medicine.getMedicineCode() == medicinesInputs[m]) {
                                            patient.getMedicine()[m] = medicine;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // reader is cloes after loop is ended
        input.close();

        // Once all data from command has been gotten, the final array is returned
        return patients_CLEANER_array;
    }


    //

/*
    PART II :
            ==> PRINTING PHASE : This methods takes all data from all sectored methods, and prints data to the output file.
 */

    //

    public static void printBill(Scanner input, PrintWriter output, Nurse[] nurses,Doctor[] doctors, Room[] rooms,
                Medicine[] medicines, Patient[] patients) {


        // Prints the first statment to output file
            output.println("--------------- Welcome to KAU Hospital System ---------------");

            // variables used to store data to its accorded variable..
            int count_rooms = 0,count_medicines = 0,count_doctors = 0,count_nurses = 0,count_patients = 0;

            while (input.hasNext())
            {
                String Command = input.next();

                // if command found, then it prints reffered outputs
                if (Command.equals("Add_Room"))
                {
                    output.println("Command Add_Room: Add a new room record in the System");
                    output.println("\tRoom No: " + rooms[count_rooms].getRoomNo());
                    output.println("\tLocated in floor: " + rooms[count_rooms].getFloor());
                    output.println("\tBlock :" + rooms[count_rooms].getBlock());
                    output.println("\tCharges: " + rooms[count_rooms].getCharges() + "\n");
                    output.println("----------------------------------------------------------------");
                    count_rooms++;
                }

                // if command found, then it prints reffered outputs
                if (Command.equals("Add_Medicine"))
                {
                    output.println("Command Add_Medicine: Add a new Medicine record in the System");
                    output.println("\tMedicine Code: " + medicines[count_medicines].getMedicineCode());
                    output.println("\tName: " + medicines[count_medicines].getName());
                    output.println("\tPrice :" + medicines[count_medicines].getPrice() + "\n");
                    output.println("----------------------------------------------------------------");
                    count_medicines++;
                }

                // if command found, then it prints reffered outputs
                if (Command.equals("Add_Doctor"))
                {
                    output.println("Command Add_Doctor: Add a new doctor record in the System");
                    output.println("\tID: " + doctors[count_doctors].getId());
                    output.println("\tName: " + doctors[count_doctors].getName());
                    output.println("\tNationality :" + doctors[count_doctors].getNationality());
                    output.println("\tGender: " + doctors[count_doctors].getGender());
                    output.println("\tPhone: " + doctors[count_doctors].getPhone());
                    output.println("\tSpecilaization: " + doctors[count_doctors].getSpecialization());
                    output.println("\tStaff ID: " + doctors[count_doctors].getStaffID());
                    output.println("\tConsultation Fees :" + doctors[count_doctors].getConsultationFees() + "\n");
                    output.println("----------------------------------------------------------------");
                    count_doctors++;
                }

                // if command found, then it prints reffered outputs
                if (Command.equals("Add_Nurse"))
                {
                    output.println("Command Add_Nurse: Add a new nurse record in the System");
                    output.println("\tID: " + nurses[count_nurses].getId());
                    output.println("\tName: " + nurses[count_nurses].getName());
                    output.println("\tNationality :" + nurses[count_nurses].getNationality());
                    output.println("\tGender: " + nurses[count_nurses].getGender());
                    output.println("\tPhone: " + nurses[count_nurses].getPhone());
                    output.println("\tSpecilaization: " + nurses[count_nurses].getSpecialization());
                    output.println("\tStaff ID: " + nurses[count_nurses].getStaffID());
                    output.println("\tExperience Year: " + nurses[count_nurses].getExperience() + "\n");
                    output.println("----------------------------------------------------------------");
                    count_nurses++;
                }

                // if command found, then it prints reffered outputs
                if (Command.equals("Add_Patient"))
                {
                    output.println("Command Add_Patient: ");
                    output.println("Add a new Patient record in the System");
                    output.println("\tID: " + patients[count_patients].getId());
                    output.println("\tName: " + patients[count_patients].getName());
                    output.println("\tNationality :" + patients[count_patients].getNationality());
                    output.println("\tGender: " + patients[count_patients].getGender());
                    output.println("\tPhone: " + patients[count_patients].getPhone());
                    output.println("-------------------------------------------------------------------------" +
                            "------------------");
                    output.println("Illness: " + patients[count_patients].getIllness() + ", Blood Group: " +
                            patients[count_patients].getBloodGroup());
                    output.println("-------------------------------------------------------------------------" +
                            "------------------\n");
                    output.println("-------------------------------------------------------------------------------");
                    count_patients++;
                }

                // if command found, then it prints reffered outputs
                if (Command.equals("Assign_Doctor_Patient"))
            {
                int doctorID = input.nextInt();
                int patientID = input.nextInt();

                for (Doctor doctor : doctors)
                {
                    if (doctorID == doctor.getId())
                    {
                        for (Patient patient : patients)
                        {
                            if (patientID == patient.getId())
                            {
                                patient.setDoctor(doctor);
                            }
                        }
                    }
                }

                output.println("Command Assign_Doctor_Patient:");

                // checks if patient is there for printing phase
                boolean patientExist = false;

                for (Patient patient : patients)
                {
                    if (patientID == patient.getId())
                    {
                        patientExist = true;
                        if (doctorID == patient.getDoctor().getId())
                        {
                            output.println("Successfully Processed by the System:\n" +
                                    "Following are the details:");
                            output.println("\t\tPatient: " + patient.getName());
                            output.println("\t\tAssigned to Doctor: " + patient.getDoctor().getName());
                        }

                        else
                        {
                            output.println("Doctor " + doctorID + " NOT FOUND ");
                        }
                    }
                }

                // changes printig statment if patient isn't founds !
                if (!patientExist)
                    output.println("Patient " + patientID + " NOT FOUND ");
                output.println("-------------------------------------------------------------------------------");
            }

                // if command found, then it prints reffered outputs
                if (Command.equals("Assign_Room_Patient"))
            {
                int roomNo = input.nextInt();
                int patientID = input.nextInt();

                for (Room room : rooms)
                {
                    if (roomNo == room.getRoomNo())
                    {
                        for (Patient patient : patients)
                        {
                            if (patientID == patient.getId())
                            {
                                patient.setRoom(room);
                            }
                        }
                    }
                }

                output.println("Command Assign_Room_Patient:");

                // checks if patient is there for printing phase
                boolean patientExist = false;

                for (Patient patient : patients)
                {
                    if (patientID == patient.getId())
                    {
                        patientExist = true;
                        if (roomNo == patient.getRoom().getRoomNo())
                        {
                            output.println("Successfully Processed by the System:\n" +
                                    "Following are the details:");
                            output.println("\tPatient: " + patient.getName());
                            output.println("\tAssigned to Room:\tRoom No: " + patient.getRoom().getRoomNo());
                            output.println("\tLocated in floor: " + patient.getRoom().getFloor());
                            output.println("\tBlock :" + patient.getRoom().getBlock());
                            output.println("\tCharges: " + patient.getRoom().getCharges());
                            output.println("\n" + "---------------------------------------------------------------------------------");
                        }

                        else
                        {
                            output.println("Room " + roomNo + " NOT FOUND ");
                            output.println("---------------------------------------------------------------------------------");
                        }
                    }
                }

                // changes printing statment if patient isn't founds !
                if (!patientExist)
                {
                    output.println("Patient " + patientID + " NOT FOUND ");
                    output.println("---------------------------------------------------------------------------------");
                }
            }

                // if command found, then it prints reffered outputs
                if (Command.equals("Assign_Medicine_Patient"))
            {
                int patientID = input.nextInt();
                int totalMedicine = input.nextInt();
                int[][] medicinesInputs = new int[totalMedicine][2];
                for (int medicinesInput = 0; medicinesInput < medicinesInputs.length; medicinesInput++)
                {
                    medicinesInputs[medicinesInput][0] = input.nextInt();
                }

                int medicineAvailable = 0;

                for (Patient patient : patients)
                {
                    if (patientID == patient.getId())
                    {
                        if (totalMedicine == patient.getTotalMedicine())
                        {
                            for (Medicine medicine : medicines)
                            {
                                for (int[] medicinesInput : medicinesInputs)
                                {
                                    if (medicine.getMedicineCode() == medicinesInput[0])
                                    {
                                        medicineAvailable++;
                                    }
                                }
                            }

                            if (medicineAvailable == totalMedicine)
                            {
                                patient.setMedicine(new Medicine[totalMedicine]);
                                for (int m = 0; m < patient.getMedicine().length; m++)
                                {
                                    for (Medicine medicine : medicines)
                                    {
                                        if (medicine.getMedicineCode() == medicinesInputs[m][0])
                                        {
                                            patient.getMedicine()[m] = medicine;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                output.println("Command Assign_Medicine_Patient:");

                // checks if patient is there for printing phase
                boolean patientExist = false;

                int availableMedicine = 0;
                for (Patient patient : patients)
                {
                    if (patientID == patient.getId())
                    {
                        patientExist = true;
                        if (totalMedicine == patient.getTotalMedicine())
                        {
                            for (int medicine = 0; medicine < totalMedicine; medicine++)
                            {
                                if (medicinesInputs[medicine][0] == patient.getMedicine()[medicine].getMedicineCode())
                                {
                                    medicinesInputs[medicine][1] = 1;
                                    availableMedicine++;
                                }
                            }

                            if (availableMedicine == totalMedicine)
                            {
                                output.println("Successfully Processed by the System:\n" +
                                        "Following are the details:");
                                output.println("\tPatient: " + patient.getName());
                                for (Medicine medicine : patient.getMedicine())
                                {
                                    output.println("\tMedicine Prescribed: " + medicine.getName());
                                }
                            }

                            else
                            {
                                for (int[] ints : medicinesInputs) {
                                    if (ints[1] == 0) {
                                        output.println("Medicines " + ints[0] + " NOT FOUND ");
                                    }
                                }
                            }
                        }

                        else
                        {
                            output.println("Information mismatch: Patient " + patientID + "must have " +
                                    patient.getTotalMedicine() + " medicine not " + totalMedicine);
                        }
                    }
                }

                // changes printing statment if patient isn't founds !
                if (!patientExist) {output.println("Patient " + patientID + " NOT FOUND ");}
                output.println("-----------------------------------------------------------------------------");
            }


                // if command found, then it prints reffered outputs
            if (Command.equals("Print_Bill"))
            {
                Date date = new Date();

                output.println("\n" +
                        "Command: Print_Bill\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "--------------- Welcome to KAU Hospital System ---------------\n" +
                        "\n" +
                        "--------- Current Date :  " + date + "--------\n" +
                        "\n" +
                        "==================================================================");

                // saves data ID in a array
                int[] patientsIDs = new int[patients.length];

                for (int index = 0; index < patientsIDs.length; index++)
                {
                    patientsIDs[index] = patients[index].getId();
                }

                // sorting patients id
                Arrays.sort(patientsIDs);

                // stage for printing data [ BILL ]
                for (int patientsID : patientsIDs)
                {
                    for (Patient patient : patients)
                    {
                        if (patientsID == patient.getId())
                        {
                            double totalCharges = 0;

                            output.println("Patient Detail: ");
                            output.println(" ID: " + patient.getId() + " Name: " + patient.getName());
                            output.println("\tDoctor : " + patient.getDoctor().getName() +
                                    "   Doctor Consultation Fees: " + patient.getDoctor().getConsultationFees() +
                                    " SR\t");

                            totalCharges += patient.getDoctor().getConsultationFees();

                            output.println("\tMedicines  are:  ");

                            for (Medicine medicine : patient.getMedicine())
                            {
                                output.printf("%-30s%-15s\n", "\tMedicine name: " + medicine.getName(), "Price: "
                                        + medicine.getPrice() + " SR");
                                totalCharges += medicine.getPrice();
                            }

                            output.println("\tRoom: " + patient.getRoom().getRoomNo() + " Room Charge: " +
                                    patient.getRoom().getCharges() + " SR   ");

                            totalCharges += patient.getRoom().getCharges();

                            output.println("\t\t==== Total Charges :" + (totalCharges) + " SR ====");
                            output.println("----------------------------------------------------------------");
                        }
                    }
                }
                // Final message
                output.println("Thank you for using KAU Hospital System, Good Bye!");
            }
        }
    }
}

// Code ended


