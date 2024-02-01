// 2. Calculate and display the distribution of all possible combinations that can be
// obtained when rolling both Die A and Die B together. Show the math along with
// the code!



// We'll count the occurrences of each sum. The range of possible sums is from 2 (when both dice show 1) to 12 (when both dice show 6).

// Math:

// The sum can be any value from 2 to 12.
// The number of ways to obtain a particular sum is the number of combinations for which the sum is equal to that value.

public class DoomedDicePartA_2 {
    public static void main(String[] args) {
        // Define the number of faces on each die
        int facesOnDie = 6;

        // Create a 2D array to store the distribution
        int[][] distribution = new int[facesOnDie][facesOnDie];

        // Calculate and populate the distribution
        for (int i = 1; i <= facesOnDie; i++) {
            for (int j = 1; j <= facesOnDie; j++) {
                int sum = i + j;
                distribution[i - 1][j - 1] = sum;
            }
        }

        // Display the distribution table
        System.out.println("  | 1  2  3  4  5  6");
        System.out.println("--+-----------------");

        for (int i = 0; i < facesOnDie; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < facesOnDie; j++) {
                System.out.print(distribution[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

// Output

// | 1  2  3  4  5  6
// --+-----------------
// 1 | 2  3  4  5  6  7  
// 2 | 3  4  5  6  7  8  
// 3 | 4  5  6  7  8  9  
// 4 | 5  6  7  8  9  10  
// 5 | 6  7  8  9  10  11  
// 6 | 7  8  9  10  11  12  