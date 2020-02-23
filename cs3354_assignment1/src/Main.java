public class Main {
    // Takes a string and reverses it. Returns a string
    String reverse(String word) {
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse.concat(String.valueOf(word.charAt(i)));
        }

        return reverse;
    }

    // Takes a string and separates it's even and odd indexes into 2 separate strings. Returns an array of 2 strings.
    // Index 0 is evens, index 1 is odds.
    String[] separate(String word) {
        String[] strArray = {"", ""};

        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                strArray[0] = strArray[0].concat(String.valueOf(word.charAt(i)));
            } else {
                strArray[1] = strArray[1].concat(String.valueOf(word.charAt(i)));
            }
        }

        return strArray;
    }

    String frankenString(String word) {
        String[] strings;
        String finalStr = "";

        // separate string into evens and odds
        strings = separate(word);
        // reverse the new even and odd strings
        strings[0] = reverse(strings[0]);
        strings[1] = reverse(strings[1]);

        // concatenate the reverse even and odd strings into a single string
        finalStr = finalStr.concat(strings[0]);
        finalStr = finalStr.concat(strings[1]);

        return finalStr;
    }

    public static void main(String[] args) {
        Main main = new Main();

        // REVERSE TEST CASE 1
        String str1 = "Hello World!";
        String rStr1 = "";

        rStr1 = main.reverse(str1);
        System.out.print(rStr1 + "\n");

        // FRANKENSTRING TEST CASE 1
        String str2 = "abscacd";
        str2 = main.frankenString(str2);
        System.out.print(str2 + "\n");

        // FRANKENSTRING TEST CASE 2
        String str3 = "batman";
        str3 = main.frankenString(str3);
        System.out.print(str3 + "\n");
    }
}

