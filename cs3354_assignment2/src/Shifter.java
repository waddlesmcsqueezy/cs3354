import java.io.*;
import java.util.Arrays;

public class Shifter {
    String fileInPath = String.valueOf(System.getProperty("user.home"))
            + "\\Documents\\input.txt";
    File fileIn = new File(fileInPath);
    String fileOutPath = String.valueOf(System.getProperty("user.home"))
            + "\\Documents\\output.txt";
    File fileOut = new File(fileOutPath);
    String data = null;

    public Shifter() {

    }

    private int[] read() throws IOException {
        int[] preShiftArray;
        BufferedReader reader = new BufferedReader(new FileReader(fileIn));

        //get the amount of characters present in the file
        int fileCharCount = 0;
        while ((data = reader.readLine()) != null)
            fileCharCount += data.length();

        // close and reopen to return to the beginning of the file
        reader.close();
        reader = new BufferedReader(new FileReader(fileIn));

        // using the character count, make an array
        preShiftArray = new int[fileCharCount];
        int charCount = 0;

        while ((data = reader.readLine()) != null) {
            for (int i = 0; i < data.length(); i++) {
                preShiftArray[i + charCount] =
                        Character.getNumericValue(data.charAt(i));
            }
            charCount += data.length();
        }

        reader.close();

        return preShiftArray;
    }

    private int[] shift(int[] preShiftArray, int shiftAmount) {
        int[] postShiftArray = new int[preShiftArray.length];

        for (int i = 0; i < postShiftArray.length; i++) {
            int shiftIndex = (i + shiftAmount) % postShiftArray.length;
            postShiftArray[shiftIndex] = preShiftArray[i];
        }

        return postShiftArray;
    }

    private void write(String str) throws IOException {
        BufferedWriter writer =
                new BufferedWriter(new FileWriter(fileOut));
        writer.write(str);

        writer.close();
    }

    public void readShiftWrite(int shiftAmount) throws IOException {
        int[] preShiftArray = read();
        int[] postShiftArray = shift(preShiftArray, shiftAmount);
        String str = "";
        for (int value : postShiftArray) str =
                str.concat(String.valueOf(value));

        write(str);
    }
}