import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shifter shifter = new Shifter();
        NumberFinder finder = new NumberFinder();

        try {
            shifter.readShiftWrite(5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int n = 6;

        int[] randArray1 = {1, 2, 4, 5, 6};
        shuffleArray(randArray1);

        int[] randArray2 = {1, 2, 3, 4, 5};
        shuffleArray(randArray1);

        int[] randArray3 = {2, 3, 4, 5, 6};
        shuffleArray(randArray1);

        System.out.print(finder.findMissingNumber(randArray1, n) + "\n");
        System.out.print(finder.findMissingNumber(randArray2, n) + "\n");
        System.out.print(finder.findMissingNumber(randArray3, n) + "\n");
    }

    public static int[] shuffleArray(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
