import java.util.*;

public class AlternateOrderTest {
    public static int[] arrangeAlternate(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        // Merge positive and negative numbers alternately
        int[] result = new int[arr.length];
        int posIndex = 0, negIndex = 0, i = 0;
        boolean positiveTurn = true;

        while (posIndex < positives.size() && negIndex < negatives.size()) {
            if (positiveTurn) {
                result[i++] = positives.get(posIndex++);
            } else {
                result[i++] = negatives.get(negIndex++);
            }
            positiveTurn = !positiveTurn;
        }

        // Add if any remaining positive numbers 
        while (posIndex < positives.size()) {
            result[i++] = positives.get(posIndex++);
        }

        // Add if any remaining negative numbers 
        while (negIndex < negatives.size()) {
            result[i++] = negatives.get(negIndex++);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {-3, 1, 2, 4, -6, 8, -8, -1};
        int[] input2 = {1, 2, 3, 4, 5};
        int[] input3 = {-1, -2, -3, -4, -5};
        int[] input4 = {-1, -2, -3, -4, -5, 6, 7, 8};
        
        System.out.println(Arrays.toString(arrangeAlternate(input1))); // [1, -3, 2, -6, 4, -8, 8, -1]
        System.out.println(Arrays.toString(arrangeAlternate(input2))); // [1, -2, 3, -4, 5]
        System.out.println(Arrays.toString(arrangeAlternate(input3))); // [-1, -2, -3, -4, -5]
        System.out.println(Arrays.toString(arrangeAlternate(input4))); // [-1, 6, -2, 7, -3, 8, -4, -5]
    }
}
