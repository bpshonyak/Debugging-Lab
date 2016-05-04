/**
 * This class runs the TimesheetTester class
 */
public class TestDriver {
    public static void main(String[] args) {

        TimesheetTester tester = new TimesheetTester();

        //Class Tests
        String emptyTimesheetTest = tester.testEmptyTimesheet()             ? "Passed" : "Failed";
        String nullDayTest = tester.testNullDay()                           ? "Passed" : "Failed";
        String maxHoursPerDayTest = tester.testMaxHoursPerDay()             ? "Passed" : "Failed";
        String negativeHoursPerDayTest = tester.testNegativeHoursPerDay()   ? "Passed" : "Failed";
        String setWeekHoursTest = tester.testSetWeekHours()                 ? "Passed" : "Failed";

        //Spec Tests
        String firstInputTest = tester.testFirstInput()                     ? "Passed" : "Failed";
        String secondInputTest = tester.testSecondInput()                   ? "Passed" : "Failed";
        String thirdInputTest = tester.testThirdInput()                     ? "Passed" : "Failed";


        //Console output
        System.out.println("----------------------- Timesheet Automated Tests -----------------------");
        System.out.println();
        System.out.println("************** Class Tests **************");
        System.out.println();
        System.out.println("Empty timesheet test: \t" + emptyTimesheetTest);
        System.out.println("Null day test: \t\t\t" + nullDayTest);
        System.out.println("Max hours test: \t\t" + maxHoursPerDayTest);
        System.out.println("Negative hours test: \t" + negativeHoursPerDayTest);
        System.out.println("Set week hours test: \t" + setWeekHoursTest);
        System.out.println();
        System.out.println("************** Spec Tests ***************");
        System.out.println();
        System.out.println("First week hours test: \t" + firstInputTest);
        System.out.println("Second week hours test: " + secondInputTest);
        System.out.println("Third week hours test: \t" + thirdInputTest);


    }
}
