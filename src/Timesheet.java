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

    private int[] week_hours = new int[7];


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

        this.week_hours = week_hours;
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

        week_hours[day] = hours;
    }

    /**
     * Calculates the pay for a given work week
     * @return Pay earned for a given work week
     */
    public double calculatePay(){

        int totalHours = 0;
        int overtimeHours = 0;

        double totalPay = 0.0;

        //Saturday and Sunday have special bonuses
        int sundayHours = week_hours[SUNDAY];
        int saturdayHours = week_hours[SATURDAY];

        for (int i = 0; i < week_hours.length; i++) {

            //Add to overtime hours
            if(week_hours[i] > 8){
                overtimeHours += week_hours[i] - 8;
            }

            totalHours += week_hours[i];
        }

        //Calculate payment --------------------------------------------------------------------------------

        //Regular pay
        totalPay += (totalHours * PAY_GRADE);

        //Overtime
        totalPay += overtimeHours * 2;

        //Sundays and Saturdays bonus calculations ------------------------------

        double saturdayBonus = calculateSaturdayBonus(saturdayHours);

        double sundayBonus = calculateSundayBonus(sundayHours);

        //Add $4 per additional hour if totalHours exceeds 40
        if(totalHours > 40){
            totalPay += overtimeHours * 4; // overtime

            sundayBonus += (sundayHours - 8) > 0 ? (sundayHours - 8) * 4 : 0;
            saturdayBonus += (saturdayHours - 8) > 0 ? (saturdayHours - 8) * 4 : 0;
        }

        totalPay += sundayBonus / 2;
        totalPay += saturdayBonus;

        return totalPay;
    }


    //Private helper methods -------------------------------------------------------------------------------

    private double calculateSaturdayBonus(int saturdayHours){

        double saturdayBonus = (saturdayHours * PAY_GRADE);
        saturdayBonus += (saturdayHours - 8) > 0 ? (saturdayHours - 8) * 2 : 0;

        return saturdayBonus;
    }

    private double calculateSundayBonus(int sundayHours){

        double sundayBonus = (sundayHours * PAY_GRADE);
        sundayBonus += (sundayHours - 8) > 0 ? (sundayHours - 8) * 2 : 0;

        return sundayBonus;
    }


}
