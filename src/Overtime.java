
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * TODO: write up a class description
 */
public class Overtime {

    public static void main(String[] args) throws IOException {


        Scanner file = getFile();
        int rows = getNumberOfRows(file);

        Timesheet[] timesheets = new Timesheet[rows];

        populateTimesheets(timesheets, file);

        for (int i = 0; i <timesheets.length; i++){
            double totalPay = timesheets[i].calculatePay();
            System.out.println("Pay for timesheet [" + i + "] = " + totalPay );
        }

    }

    /**
     * Retrieves a file containing timesheet data
     * @return Scanner containing the selected file
     * @throws IOException Thrown if the specified file does not exist
     */
    public static Scanner getFile() throws IOException {

        Scanner stdin = new Scanner(System.in);

        System.out.print("Filename: ");
        String name = stdin.nextLine();

        File file = new File(name);

        return new Scanner(file);

    }

    /**
     * Retrieves the number of rows with timesheet data
     * @param fileIn File to retrieve data from
     * @return Number of rows with timesheet data
     */
    public static int getNumberOfRows(Scanner fileIn) {

        int numRows = fileIn.nextInt();
        fileIn.nextLine();

        return numRows;
    }

    /**
     * Creates timesheet objects
     * @param timesheets Array of empty timesheet objects
     * @param fileIn File to retrieve data from
     */
    public static void populateTimesheets(Timesheet[] timesheets, Scanner fileIn){

        for (int i = 0; i < timesheets.length; i++) {

            //Get Line
            String line = fileIn.nextLine();

            //Scanner for each integer
            Scanner lineIn = new Scanner(line);

            int[] timesheet = new int[7];

            //Populate timesheet array
            for (int j = 0; j < 7; j++) {
                timesheet[j] = lineIn.nextInt();
            }

            //Update timesheet in the timesheets array
            timesheets[i] = new Timesheet(timesheet);

        }

    }
}