//1. How many total combinations are possible? Show the math along with the code!

// Math:

// Die A has 6 faces.
// Die B has 6 faces.
// Total combinations = Faces on Die A * Faces on Die B
// = 6 * 6
// = 36

public class DoomedDicePartA_1 {
    public static void main(String[] args) {
        // Number of faces on each die
        int facesOnDie_A = 6;
        int facesOnDie_B = 6;

        // Calculate total combinations
        int totalCombinations = facesOnDie_A * facesOnDie_B;

        // Print the result
        System.out.println("Total Combinations: " + totalCombinations);
    }
}

// Output

// Total Combinations: 36