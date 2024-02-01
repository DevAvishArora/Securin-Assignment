// 3. Calculate the Probability of all Possible Sums occurring among the number of
// combinations from (2).
// Example: P(Sum = 2) = 1/X as there is only one combination possible to obtain
// Sum = 2. Die A = Die B = 1.

// Math:
// The probability of a specific sum is given by the formula:

// P(Sum=x)= Number of combinations resulting in Sum=x / Total number of combinations


// We can use the distribution table calculated earlier to determine the number of combinations for each sum.

public class DoomedDicePartA_3 {
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

        // Calculate the probability for each sum
        int totalCombinations = facesOnDie * facesOnDie;
        
        System.out.println("Probability of Sums:");
        for (int sum = 2; sum <= 12; sum++) {
            int occurrences = countOccurrences(distribution, sum);
            int numerator = occurrences;
            int denominator = totalCombinations;
            
            // Simplify the fraction
            int gcd = findGCD(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            
            System.out.println("P(Sum = " + sum + ") = " + numerator + "/" + denominator);
        }
    }

    // Helper method to count occurrences of a sum in the distribution
    private static int countOccurrences(int[][] distribution, int targetSum) {
        int count = 0;
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                if (distribution[i][j] == targetSum) {
                    count++;
                }
            }
        }
        return count;
    }

    // Helper method to find the greatest common divisor (GCD)
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }   
}

// // Output

// Probability of Sums:
// P(Sum = 2) = 1/36
// P(Sum = 3) = 1/18
// P(Sum = 4) = 1/12
// P(Sum = 5) = 1/9
// P(Sum = 6) = 5/36
// P(Sum = 7) = 1/6
// P(Sum = 8) = 5/36
// P(Sum = 9) = 1/9
// P(Sum = 10) = 1/12
// P(Sum = 11) = 1/18
// P(Sum = 12) = 1/36