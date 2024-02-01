// ------------------------------------Question-------------------------------------------------------------
// Part-B (25-30 Minutes):
// Now comes the real challenge. You were happily spending a lazy afternoon playing
// your board game with your dice when suddenly the mischievous Norse God Loki ( You
// love Thor too much & Loki didn’t like that much ) appeared.
// Loki dooms your dice for his fun removing all the “Spots” off the dice.
// No problem! You have the tools to re-attach the “Spots” back on the Dice.
// However, Loki has doomed your dice with the following conditions:
// ● Die A cannot have more than 4 Spots on a face.
// ● Die A may have multiple faces with the same number of spots.
// ● Die B can have as many spots on a face as necessary i.e. even more than 6.
// But in order to play your game, the probability of obtaining the Sums must remain the
// same!
// So if you could only roll P(Sum = 2) = 1/X, the new dice must have the spots reattached
// such that those probabilities are not changed.
// Input:
// ● Die_A = [1, 2, 3, 4, 5, 6] & Die B = Die_A = [1, 2, 3, 4, 5, 6]
// Output:
// ● A Transform Function undoom_dice that takes (Die_A, Die_B) as input &
// outputs New_Die_A = [?, ?, ?, ?, ?, ?],New_Die_B = [?, ?,
// ?, ?, ?, ?] where,
// ● No New_Die A[x] > 4


// ------------------------------------------------Approach------------------------------------------------------------

// Step 1 :
// Calculate the probability distribution of sums for the original Die_A and Die_B. This involves counting the occurrences of each sum.

// Step 2 :
// Write a function that takes a configuration of Die_A and Die_B and calculates the probability distribution of sums.

// Step 3 :
// Generate possible configurations for New_Die_A and New_Die_B that adhere to the given conditions. You can use nested loops and conditions to generate configurations.

// Step 4 :
// For each generated configuration of New_Die_A and New_Die_B, calculate the probability distribution of sums using the function from step 2.

// Step 5 :
// Compare the probability distributions obtained from the original dice and the generated configurations. Ensure that they match.

// Step 6 :
// Once a valid configuration is found that preserves the probability distribution, return it as the result.


// ------------------------------------------------Code---------------------------------------------------------
import java.util.Arrays;
import java.util.Random;

public class DoomedDicePartB_2 {
   public static void main(String[] args) {
        // Example original dice configurations
        int[] originalDieA = {1, 2, 3, 4, 5, 6};
        int[] originalDieB = Arrays.copyOf(originalDieA, originalDieA.length);

        // Calculate probability distribution for original dice
        double[] originalProbabilityDistribution = calculateProbabilityDistribution(originalDieA, originalDieB);

        // Find valid configurations for new dice
        int[] newDieA = findValidConfigForDieA(originalDieA, originalProbabilityDistribution);
        int[] newDieB = findValidConfigForDieB(originalDieB, newDieA);

        // Print the results
        System.out.println("Original Die A: " + Arrays.toString(originalDieA));
        System.out.println("Original Die B: " + Arrays.toString(originalDieB));
        System.out.println("New Die A: " + Arrays.toString(newDieA));
        System.out.println("New Die B: " + Arrays.toString(newDieB));
    }

    private static double[] calculateProbabilityDistribution(int[] dieA, int[] dieB) {
        int totalCombinations = dieA.length * dieB.length;
        double[] distribution = new double[2 * dieA.length + 1];

        for (int i = 0; i < dieA.length; i++) {
            for (int j = 0; j < dieB.length; j++) {
                distribution[dieA[i] + dieB[j] - 2] += 1.0;
            }
        }

        // Normalize probabilities
        for (int k = 0; k < distribution.length; k++) {
            distribution[k] /= totalCombinations;
        }

        return distribution;
    }

    private static int[] findValidConfigForDieA(int[] originalDieA, double[] targetDistribution) {
        int[] bestConfig = null;
        double minDifference = Double.MAX_VALUE;

        // Generate all possible combinations for Die A
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    for (int l = 1; l <= 4; l++) {
                        for (int m = 1; m <= 4; m++) {
                            for (int n = 1; n <= 4; n++) {
                                int[] newDieA = {i, j, k, l, m, n};
                                double[] newDistribution = calculateProbabilityDistribution(newDieA, originalDieA);

                                // Check if the probability distribution matches
                                double difference = calculateDifference(targetDistribution, newDistribution);
                                if (difference < minDifference) {
                                    minDifference = difference;
                                    bestConfig = newDieA;
                                }
                            }
                        }
                    }
                }
            }
        }

        return bestConfig;
    }

    private static int[] findValidConfigForDieB(int[] originalDieB, int[] newDieA) {
        Random random = new Random();
        int[] newDieB = new int[originalDieB.length];

        for (int i = 0; i < newDieB.length; i++) {
            // Randomly choose a value greater than 6
            newDieB[i] = random.nextInt(5) + 7;
        }

        return newDieB;
    }

    private static double calculateDifference(double[] distribution1, double[] distribution2) {
        double difference = 0.0;
        for (int i = 0; i < distribution1.length; i++) {
            difference += Math.abs(distribution1[i] - distribution2[i]);
        }
        return difference;
    }
}


// -----------------------------------Output-----------------------------------------------------------------------------

// Original Die A: [1, 2, 3, 4, 5, 6]
// Original Die B: [1, 2, 3, 4, 5, 6]
// New Die A: [1, 2, 3, 4, 4, 4]
// New Die B: [11, 9, 8, 8, 7, 10]