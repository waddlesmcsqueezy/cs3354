public class WordReverser {

    String reverse(String word) {
        String reverse = "";

        for (int i = word.length(); i > 0; i++)
            reverse.concat(String.valueOf(word.charAt(i)));

        return reverse;
    }
}
