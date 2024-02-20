/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Set Patient/procedure attributes and display it here
 * Due: 02/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package Assignment2;
public class PatientDriverApp {
    
    public static void main(String[] args) {

        Patient patient1 = new Patient();
        patient1.setFirstName("Willy"); 
        patient1.setMiddleName("Jilly");  
        patient1.setLastName("Nilly"); 
        patient1.setStreetAddress("324 street"); 
        patient1.setCity("Gtown"); 
        patient1.setState("MD"); 
        patient1.setZipCode("23342"); 
        patient1.setEmergencyContactPhone("351-124-4267"); 
        patient1.setEmergencyContactName("Mark Fishbach"); 
         
   
        
        // Use constructors to create procedure objects
        Procedure p1 = new Procedure("Checkup", "06/12/2023");
        p1.setPractitionerName("Dr. Smith"); 
        p1.setprocedureCharges(555.03); 

        Procedure p2 = new Procedure("X-Ray", "07/15/2023"); 
        p2.setPractitionerName("Dr. Johnson");
        p2.setprocedureCharges(5232.04);
        
        Procedure p3 = new Procedure("Blood Test", "08/20/2023"); 
        p3.setPractitionerName("Dr. Williams"); 
        p3.setprocedureCharges(500.23); 

        // Display patient procedure info
        displayPatient(patient1);
        displayProcedure(p1);
        displayProcedure(p2);
        displayProcedure(p3);

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(p1, p2, p3);
        System.out.printf("Total Charges: $%,.2f\n", totalCharges);
        
        System.out.println("\nStudent Name: Dylan Avallone");
        System.out.println("MC#: 21113732");
        System.out.println("Due Date: 02/19/2024");

    }

    public static void displayPatient(Patient patient) {
        System.out.println(patient);
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }

    public static double calculateTotalCharges(Procedure... procedures) {
        double total = 0.0;
        for (Procedure procedure : procedures) {
            total += procedure.getprocedureCharges();
        }
        return total;
    }
    
}

