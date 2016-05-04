import java.security.InvalidParameterException;

/**
 * This class holds all tests for the Timesheet class
 */
public class TimesheetTester {

    //Fields
    private Timesheet timesheet;

    //Constructor
    public TimesheetTester() {
        timesheet = new Timesheet();
    }

    // General Tests -------------------------------------------------


    /**
     * Tests the calculatePay method being called on an empty timesheet
     * @return True if the test passes
     */
    public boolean testEmptyTimesheet(){

        timesheet = new Timesheet();

        double pay;

        try {
            pay = timesheet.calculatePay();
        } catch (NullPointerException ex) {
            return true;
        }

        return false;
    }

    /**
     * Tests a null day value
     * @return True if the test passes
     */
    public boolean testNullDay(){

        timesheet = new Timesheet();

        try {
            timesheet.setDayHours(1, 20);
        } catch (NullPointerException ex) {
            return true;
        }

        return false;
    }


    /**
     * Tests calling setDayHours with the hours value over 24 hours
     * @return True if the test passes
     */
    public boolean testMaxHoursPerDay(){

        timesheet = new Timesheet();

        try {
            timesheet.setDayHours(1, 25);
        } catch (InvalidParameterException ex) {
            return true;
        }

        return false;
    }

    /**
     * Tests calling setDayHours with the hours value below 0 hours
     * @return True if the test passes
     */
    public boolean testNegativeHoursPerDay(){

        timesheet = new Timesheet();

        try {
            timesheet.setDayHours(1, -2);
        } catch (InvalidParameterException ex) {
            return true;
        }

        return false;
    }

    /**
     * Tests the setWeekHours with over 7 days in the paramater array
     * @return True if the test passes
     */
    public boolean testSetWeekHours(){
        timesheet = new Timesheet();

        int[] week_hours = {1,2,3,4,5,6,7,8};

        try {
            timesheet.setWeekHours(week_hours);
        } catch (InvalidParameterException ex) {
            return true;
        }

        return false;
    }

    // Specification tests --------------------------------------------

    /**
     * Tests first timesheet in the specification document
     * @return True if the test passes
     */
    public boolean testFirstInput(){
        timesheet = new Timesheet();

        int[] week_hours = {0,8,8,8,10,6,0};

        timesheet.setWeekHours(week_hours);

        double pay = timesheet.calculatePay();

        return pay == 404.0;
    }

    /**
     * Tests second timesheet in the specification document
     * @return True if the test passes
     */
    public boolean testSecondInput(){
        timesheet = new Timesheet();

        int[] week_hours = {4,0,0,0,0,6,0};

        timesheet.setWeekHours(week_hours);

        double pay = timesheet.calculatePay();

        return pay == 120.0;
    }

    /**
     * Tests third timesheet in the specification document
     * @return True if the test passes
     */
    public boolean testThirdInput(){
        timesheet = new Timesheet();

        int[] week_hours = {8,7,6,7,8,7,6};

        timesheet.setWeekHours(week_hours);

        double pay = timesheet.calculatePay();

        return pay == 650.0;
    }
}
