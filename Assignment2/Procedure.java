/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Set Procedure constructors,accessors,mutators
 * Due: 02/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package Assignment2;

public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;

    // A No-arg constructor
    public Procedure() {
    }

    // Parameterized constructor for procedureName and procedureDate
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    // Parameterized constructor for all attributes
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }

    // procedureName Accessor
    public String getProcedureName() {
        return procedureName;
    }

    //  procedureName Mutator 
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    // procedureDate Accessor 
    public String getprocedureDate() {
        return procedureDate;
    }

    // procedureDate Mutator
    public void setprocedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    // practitionerName Accessor 
    public String getPractitionerName() {
        return practitionerName;
    }

    // practitionerName Mutator 
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    
    public double getprocedureCharges() {
        return procedureCharges;
    }

    // procedureCharges Mutator
    public void setprocedureCharges(double procedureCharges) {
        this.procedureCharges = procedureCharges;
    }

    // toString method with tab formatting
    @Override
    public String toString() {
        return String.format("Procedure: %s\nProcedureprocedureDate=%s\nPractitioner=%s\nprocedureCharge=$%,.2f\n",
                             procedureName, procedureDate, practitionerName, procedureCharges);
    }
}
