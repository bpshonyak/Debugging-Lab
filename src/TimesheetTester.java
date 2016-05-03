/**
 * This class holds all tests for the Timesheet class
 */
public class TimesheetTester {

    private Timesheet timesheet;

    public TimesheetTester() {
        timesheet = new Timesheet();
    }

    // General Tests -------------------------------------------------

    public boolean testEmptyTimesheet(){
        double pay = timesheet.calculatePay();
        return pay == 0.0;
    }

    //168 = 24*7
    public boolean testMaxHours(){
        return true;
    }

    public boolean testMaxHoursPerDay(){
        return true;
    }

    public boolean testNegativeHoursPerDay(){
        return true;
    }


    // Function tests ------------------------------------------------

    //Over or under 7 days
    public boolean testSetWeekHours(){
        return true;
    }

    public boolean testSetDayHours(){
        return true;
    }

    public boolean testCalculatePay(){
        return true;
    }

    // Specification tests --------------------------------------------

    public boolean testFristInput(){
        return true;
    }

    public boolean testSecondInput(){
        return true;
    }

    public boolean testThirdInput(){
        return true;
    }
}
