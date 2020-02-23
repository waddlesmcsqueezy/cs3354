public class NumberFinder {

    // for this method, N must be given and the
    // array must not include the missing number
    int findMissingNumber(int[] missingArray, int n) {
        int missing = -1;
        int[] helperArray = new int[n];

        for (int value : missingArray) {
            helperArray[value - 1] = value;
        }

        for (int i = 0; i < n; i++) {
            if (helperArray[i] == 0)
                missing = i + 1;
        }

        return missing;
    }
}
