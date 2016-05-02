import java.security.InvalidParameterException;

/**
 * This class represents a workplace timesheet.
 */
public class Timesheet {

    //Fields
    private double PAY_GRADE = 10.00;
    private double SATURDAY_BONUS = 100.00;
    private double SUNDAY_BONUS = 50.00;

    private int SATURDAY = 6;
    private int SUNDAY = 0;

    private Day[] week = new Day[7];

    /**
     * Default constructor
     */
    public Timesheet(){

    }

    /**
     * Parametrized constructor
     * @param week_hours Array of hours worked each day of the week
     */
    public Timesheet(int[] week_hours){
        setWeekHours(week_hours);
    }

    /**
     * Set the values for hours worked each day of the week
     * @param week_hours Array of hours worked each day of the week
     */
    public void setWeekHours(int[] week_hours){
        if(week_hours.length != 7){
            throw new InvalidParameterException("The week_hours array passed in must have exactly 7 indices");
        }

        for(int i = 0; i < week.length; i++){
            week[i] = new Day(i);
            week[i].setHours(week_hours[i]);
        }
    }

    /**
     * Set the hours worked for a specific day
     * @param day Day of the week
     * @param hours Hours worked
     */
    public void setDayHours(int day, int hours) {
        if (day < 0 || day > 6){
            throw new InvalidParameterException("The day value must be between 1-6 inclusive.");
        }

        week[day].hours = hours;
    }

    /**
     * Calculates the pay for a given work week
     * @return Pay earned for a given work week
     */
    public double calculatePay(){

        int totalHours = 0;
        int overtimeHours = 0;

        double totalPay = 0.0;

        for (int i = 0; i < week.length; i++) {

            //Add daily overtime hours
            if(week[i].hours > 8){
                week[i].dailyOvertimeHours += week[i].getHours() - 8;
                overtimeHours += week[i].getHours() - 8;
            }

            //Add weekly overtime hours
            if(totalHours > 40){
                week[i].weeklyOvertimeHours = week[i].getHours();
            }else if(totalHours + week[i].getHours() > 40){
                int excess = totalHours + week[i].getHours();
                int overHours = excess - 40;
                week[i].weeklyOvertimeHours = overHours;
            }

            totalHours += week[i].getHours();
        }

        //Calculate payment --------------------------------------------------------------------------------

        //Calculate Regular pay
        totalPay += (totalHours * PAY_GRADE);

        //Add Overtime Pay
        totalPay += overtimeHours * 2;


        //Add $4 per additional hour if totalHours exceeds 40
        if(totalHours > 40){
            totalPay += (totalHours - 40) * 4; // overtime
        }

        //Calculate bonuses
        totalPay += calculateSaturdayBonus();
        totalPay += calculateSundayBonus();

        return totalPay;
    }


    //Private helper methods -------------------------------------------------------------------------------

    private double calculateSaturdayBonus(){

        Day saturday = week[SATURDAY];
        double saturdayBonus;

        saturdayBonus = (saturday.hours * 10) + (saturday.dailyOvertimeHours * 2) + (saturday.weeklyOvertimeHours * 4);
        saturdayBonus = (saturdayBonus / 100) * SATURDAY_BONUS;

        return saturdayBonus;
    }

    private double calculateSundayBonus(){

        Day sunday = week[SUNDAY];
        double sundayBonus;

        sundayBonus = (sunday.hours * 10) + (sunday.dailyOvertimeHours * 2) + (sunday.weeklyOvertimeHours * 4);
        sundayBonus = (sundayBonus / 100) * SUNDAY_BONUS;

        return sundayBonus;
    }

    /**
     * Day class
     */
    class Day {

        private int day;
        private int hours = 0;
        private int dailyOvertimeHours = 0;
        private int weeklyOvertimeHours;

        //Constructor

        public Day(int day){
            this.day = day;
        }

        // Getters & Setters

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getDailyOvertimeHours() {
            return dailyOvertimeHours;
        }

        public void setDailyOvertimeHours(int dailyOvertimeHours) {
            this.dailyOvertimeHours = dailyOvertimeHours;
        }

        public int getWeeklyOvertimeHours() {
            return weeklyOvertimeHours;
        }

        public void setWeeklyOvertimeHours(int hoursOver40) {
            this.weeklyOvertimeHours = hoursOver40;
        }
    }


}
