package utility;

import nonuser.Airline;
import nonuser.Flight;
import user.AirlineRepresentative;
import user.CateringOperationsManager;

import java.time.LocalDate;
import java.time.LocalTime;

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
                "John Smith",                         // fullName
                "Catering Operations Manager",        // role
                LocalDate.of(1988, 5, 15),            // dateOfBirth
                "Male",                               // gender
                "john.smith@airport.com",             // email
                "01711111111",                        // phone
                "Dhaka, Bangladesh",                  // address
                "Active",                             // status
                LocalDate.of(2022, 1, 10),            // joinDate
                "Operations",                         // department
                "Operations Manager",                 // designation
                85000f                               // salary
        );
        BinaryFileUtility.writeObjects("User.bin", manager);

        // Dummy Airline Representative
//        AirlineRepresentative representative = new AirlineRepresentative(
//                "1234",                      // password
//                "Sarah Johnson",                      // fullName
//                "Airline Representative",             // role
//                LocalDate.of(1994, 9, 20),            // dateOfBirth
//                "Female",                             // gender
//                "sarah@skyair.com",                   // email
//                "01822222222",                        // phone
//                "Chattogram, Bangladesh",             // address
//                "Active",                             // status
//                "BG001",                              // airlineId
//                "02-98765432"                         // officeContact
//        );
//        BinaryFileUtility.writeObjects("User.bin", representative);

        System.out.println("catering user id: "+" "+manager.getUserId() + "catering User pass: " +manager.getPassword());
//        System.out.println("catering user id: "+ representative.getUserId()+" " + "catering User pass: " +representative.getPassword());
    }
}

