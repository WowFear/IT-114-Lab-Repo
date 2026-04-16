import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeProcessor {
    public static void main(String[] args) {

        // Input and Output file names
        String inputFileName = "student_data.txt";
        String outputFileName = "grade_report.txt";

        // TODO 1: Wrap your code in a try-catch block.
        // We need this because file operations can fail (file not found, etc.)
        // Java forces us to handle this with a checked exception
        try {
            // TODO 2: Create a File object and a Scanner to read the input file.
            // File just points to where the file is, Scanner is what actually reads it
            File inputFile = new File(inputFileName);
            Scanner fileScanner = new Scanner(inputFile);

            // TODO 3: Create a PrintWriter object to write to the output file.
            // PrintWriter lets us use print/println just like System.out, but to a file
            PrintWriter writer = new PrintWriter(outputFileName);

            System.out.println("Processing file...");

            // Write the header to the output file separated by tab characters 
            //  just inserts a tab space so the columns line up nicely
            writer.printf("%-10s\t%-10s\t%-10s%n", "Name", "Average", "Status");
            // Print a dashed line to separate the header from the data below it
            writer.println("-------------------------------- ");

            // TODO 4: While loop to go through every line in the file until there's nothing left
            while (fileScanner.hasNext()) {
                // Read the name (String), next() grabs one token (word) at a time
                String name = fileScanner.next();

                // Read the three scores, nextInt() reads the next integer token
                int score1 = fileScanner.nextInt();
                int score2 = fileScanner.nextInt();
                int score3 = fileScanner.nextInt();

                // Calculate the averag, cast to double so we don't get integer division
                double average = (score1 + score2 + score3) / 3.0;

                // Determine Pass or Fail based on the average
                // Using a ternary here since it's just a simple condition, keeps it clean
                String status = (average >= 70.0) ? "Pass" : "Fail";

                // Write the formatted line to the output file
                // %.2f rounds the average to 2 decimal places
               writer.printf("%-10s\t%-10.1f\t%-10s%n", name, average, status);
            }

            // TODO 5: Close both the Scanner and the PrintWriter
            // Always close your resources when done 
            fileScanner.close();
            writer.close();

            System.out.println("Done! Check " + outputFileName + " for results.");

        // TODO 6: catch block — this runs if the file doesn't exist or can't be opened
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file 'student_data.txt' was not found. ");
        }
    }
}