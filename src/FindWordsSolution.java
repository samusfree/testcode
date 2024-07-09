import java.util.*;
public class FindWordsSolution {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        char[][] grid = new char[][] {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        ArrayList<String> words = new ArrayList<String>();
        words.add("ABC");
        words.add("ABE");
        words.add("ACD");
        words.add("XYZ");

        strings = findWords(grid, words);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> findWords(char[][] grid, ArrayList<String> words) {
        ArrayList<String> wordsFound = new ArrayList<String>();
        words.forEach(w -> {
            if(findWord(grid, w))
                wordsFound.add(w);
        });
        return wordsFound;
    }

    public static boolean findWord(char[][] grid, String word) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == word.charAt(0)) {
                    return checkEntireWord(word, 0, r, c, grid);
                }
            }
            return false;
        }
        return false;
    }

    //EBA
    // ```
    // Grid:
    // A B C
    // D E F
    // G H I

    public static boolean checkEntireWord(String word, int index, int row, int column, char[][] grid){
        if(index == word.length())
            return true;

        //  if(grid[row][column] == word.charAt(index)){
        return checkEntireWord(word, index + 1, row, column + 1, grid) ||
                checkEntireWord(word, index + 1, row + 1, column, grid);

        //  }
    }
    // Your previous Plaiclan Text content is preserved below:

    // This is just a simple shared plaintext pad, with no execution capabilities.

    // When you know what language you'd like to use for your interview,
    // simply choose it from the dropdown in the top bar.

    // You can also change the default language your pads are created with
    // in your account settings: https://app.coderpad.io/settings

    // Enjoy your interview!


    // Given a 2D grid of characters and a list of words, return all words that exist in the grid.

    // ```
    // Grid:
    // A B C
    // D E F
    // G H I

    // Input Words:
    // [ABC, ABE, ACD, XYZ]

    // Expected Output:
    // [ABC, ABE]

    // Example test cases:
    // Input: [AAA, HIF, CEG, HDB]
    // Expected: [HIF, CEG, HDB]
    // // // // // // // // // // // // // // // // // // // // //
}
