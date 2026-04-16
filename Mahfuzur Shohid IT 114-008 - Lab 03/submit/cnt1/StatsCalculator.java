public class StatsCalculator {

    public static void main(String[] args) {
        // 1. Initialize the 2D array with the sample data (you may copy and paste it from sample_data.txt)
        
        double[][] scores = {
        {85.5, 90.0, 78.5, 92.0},
        {76.0, 88.5, 90.0, 85.0},
        {95.0, 92.0, 94.5, 98.0},
        {60.0, 70.5, 65.0, 72.0},
        {82.0, 84.0, 80.0, 88.0}

        };
       
       
        // 2. Call methods
        System.out.println("--- GradeBook Statistics ---\n");
        calculateStudentAverages(scores);
        System.out.println();
        calculateAssignmentAverages(scores);
        System.out.println();
        findHighestScore(scores);
    }

    // TODO: Implement this method
    public static void calculateStudentAverages(double[][] data) {
        System.out.println("Student Averages:");
        // Your logic here (Row-major traversal)

        //We're making a double for loop for our 2D Array. The first loop is for the rows, which in this case would be the students i.e student 0, student 1, and so on. 
        for(int row = 0; row < data.length; row++) {
            double sum = 0; //We want to rest each students total value since they have different scores for their assingments. 

        for (int col = 0; col < data[row].length; col++){ //This does a similar thing as the first, but for the columns/assignments. 
            sum += data[row][col]; //We want to add all the data from that specific student across all the assignments.
        }

        double average = sum / data[row].length; //to get the sum, divide by the total by the # of assignments 
        System.out.println("The Average for Student " + (row + 1) + " is: " + average);


    }


 }

    // TODO: Implement this method
    public static void calculateAssignmentAverages(double[][] data) {
        System.out.println("Assignment Averages:");
        // Your logic here (Column-major traversal)

      for (int col = 0; col < data[0].length; col++) { //I mostly just followed the same concept from the students but just really flipped it for the coiumns. 
        double sum = 0;

        for (int row = 0; row < data.length; row++){
            sum += data[row][col];
        }

        double average = sum / data.length; //Don't have to say much, since I said before its very similar to before for the averages
        System.out.println("The Average for Assignment " + (col + 1) + " is: " + average);

      }

    }

    // TODO: Implement this method
    public static void findHighestScore(double[][] data) {
         // Your logic here
    
    double highScore = data[0][0];
    int students = 0;
    int assignments = 0;
    
    for(int row = 0; row < data.length; row++){ //Same types of for loops we used before to go through all the elements, rows and columns in all. 
        for (int col = 0; col < data[row].length; col++) {
           if (data[row][col] > highScore){ //Should have mentioned this but, we initially just assume our first value is the highest so we can do a comparrison 
                highScore = data[row][col];// We assume the first value within the list is the highest and then we just compare it to everything else. 
                students = row; //If the value we have is greater than all we do is just swap it out for the new value we sorted out with. 
                assignments = col;
           } 
        }

    } 
    
    System.out.println("The Highest Score is: " + highScore); //Just making the final print statments to finalize the results
    System.out.println("The Student who had that score was Student: " + (students + 1));
    System.out.println("The Assignment associated with it is Assignment : " + (assignments + 1));    
    
        }
  
        
    
}