package utility;

import nonuser.Airline;
import nonuser.Flight;
import user.AirlineRepresentative;
import user.CateringOperationsManager;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DummyDataGenerator {

        public static void Airlines() {

            //Airlines
            BinaryFileUtility.writeObjects(
                    "Airline.bin",
                    new Airline("BG", "Biman Bangladesh Airlines", "02-8901600")
            );

            BinaryFileUtility.writeObjects(
                    "Airline.bin",
                    new Airline("UB", "US-Bangla Airlines", "02-55058080")
            );

            BinaryFileUtility.writeObjects(
                    "Airline.bin",
                    new Airline("NV", "NOVOAIR", "02-9891891")
            );

            BinaryFileUtility.writeObjects(
                    "Airline.bin",
                    new Airline("AA", "Air Astra", "02-41090909")
            );

            //Flights
            BinaryFileUtility.writeObjects(
                    "Flight.bin",
                    new Flight(
                            "BG101",
                            "Dhaka to Cox's Bazar",
                            LocalDate.of(2026, 8, 5),
                            LocalTime.of(8, 30),
                            "Cox's Bazar"
                    )
            );

            BinaryFileUtility.writeObjects(
                    "Flight.bin",
                    new Flight(
                            "UB220",
                            "Dhaka to Chattogram",
                            LocalDate.of(2026, 8, 5),
                            LocalTime.of(10, 15),
                            "Chattogram"
                    )
            );

            BinaryFileUtility.writeObjects(
                    "Flight.bin",
                    new Flight(
                            "NV315",
                            "Dhaka to Sylhet",
                            LocalDate.of(2026, 8, 6),
                            LocalTime.of(9, 45),
                            "Sylhet"
                    )
            );

            BinaryFileUtility.writeObjects(
                    "Flight.bin",
                    new Flight(
                            "AA410",
                            "Dhaka to Jashore",
                            LocalDate.of(2026, 8, 7),
                            LocalTime.of(11, 0),
                            "Jashore"
                    )
            );

            BinaryFileUtility.writeObjects(
                    "Flight.bin",
                    new Flight(
                            "BG505",
                            "Dhaka to Bangkok",
                            LocalDate.of(2026, 8, 8),
                            LocalTime.of(14, 20),
                            "Bangkok"
                    )
            );

            System.out.println("Dummy Airline.bin and Flight.bin created successfully.");
        }

    public static void morsalin() {

        // Dummy Catering Operations Manager
        CateringOperationsManager manager = new CateringOperationsManager(
                "1234",                      // password
                "S. M. S. Morsalin",                  // fullName
                "Catering Operations Manager",        // role
                LocalDate.of(2005, 11, 20),            // dateOfBirth
                "Male",                               // gender
                "smsmorsalin1@gmail.com",             // email
                "01755400336",                        // phone
                "Dhaka, Bangladesh",                  // address
                "Active",                             // status
                LocalDate.of(2022, 1, 10),            // joinDate
                "Operations",                         // department
                "Operations Manager",                 // designation
                85000f                               // salary
        );
        BinaryFileUtility.writeObjects("User.bin", manager);

        // Dummy Airline Representative
        AirlineRepresentative representative = new AirlineRepresentative(
                "1234",                      // password
                "S. M. S. Morsalin",                  // fullName
                "Airline Representative",             // role
                LocalDate.of(2005, 11, 20),            // dateOfBirth
                "Male",                               // gender
                "smsmorsalin1@gmail.com",             // email
                "01755400336",                        // phone
                "Bashundhara R/A Dhaka, Bangladesh",  // address
                "Active",                             // status
                "BG001",                              // airlineId
                "02-98765432"                         // officeContact
        );
        BinaryFileUtility.writeObjects("User.bin", representative);

        System.out.println("catering user id: "+manager.getUserId() +" " + "catering User pass: " +manager.getPassword());
        System.out.println("Airline Rep user id: "+ representative.getUserId()+" " + "catering User pass: " +representative.getPassword());
    }

    public static void totalUser(){
        ArrayList<Object> users =
                BinaryFileUtility.readObjects("User.bin");

        System.out.println("Number of users: " + users.size());
    }

    public static void DeleteAllUser(){
        File file = new File("User.bin");

        System.out.println("Deleting file: " + file.getAbsolutePath());

        if (file.exists()) {
            boolean deleted = file.delete();
            System.out.println("Deleted: " + deleted);
        }
    }
}

