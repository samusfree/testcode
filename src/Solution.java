import java.util.*;

/*

A friend has provided you with their phone’s lock screen combination, a series of numbers,

and told you it represents something significant to them.

You know that the lock screen numbers come associated with a set of letters (eg, 2 → ABC, 3→ DEF, .....),

so it seems reasonable to assume their lock screen combination could be a word or phrase.

Your challenge is to write a function which, given the lock screen number as an input,

returns a list of all the possible strings that number might represent.

Your code must be compilable, executable, and include test cases.

*Bonus points*: Once you have a function that returns all the possible strings, you’ll probably notice

the list can be pretty large. Can you come up with an additional function that can help you review the

result by ranking them by how likely they are to be an actual word or phrase?

Lockscreen Keyboard

1 2 3

[ABC] [DEF]

4 5 6

[GHI] [JKL] [MNO]

7 8 9

[PQRS] [TUV] [WXYZ]

0

Lock screen combination:

22

Output:

[ AA, AB, AC, BA, BB, BC, CA, CB, CC ]

Lock screen combination:

234

Output

[

ADG,

ADH,

ADI,

AEG,

AEH,

AEI,

AFG,

AFH,

AFI,

BDG,

BDH,

BDI,

BEG,

BEH,

BEI,

BFG,

BFH,

BFI,

CDG,

CDH,

CDI,

CEG,

CEH,

CEI,

CFG,

CFH,

CFI

]

*Bonus Points*

Lock screen combination: 93553663

*/

class Solution {

    public static void main(String[] args) {
        String number = "93553663";
        List<String> combinations = generateCombinations(number);
        combinations.forEach(System.out::println);
    }

    public static List<String> generateCombinations(String input) {
        char [][] matrixChar = new char[input.length()][3];
        for (int i = 0; i < input.length();i++) {
            List<Character> characterList = getCharsForDigit(input.charAt(i));
            if(Integer.parseInt(input.charAt(i) + "") > 1) {
                for(int j = 0; j < 3; j++) {
                    matrixChar[i][j] = characterList.get(j);
                }
            }
        }
        return combine(matrixChar);
    }

    private static List<String> combine(char[][] matrix) {
        int[] sizeArray = new int[matrix.length];
        int[] counterArray = new int[matrix.length];
        int total = 1;
        for (int i = 0; i < matrix.length; ++i) {
            sizeArray[i] = matrix[i].length;
            total *= matrix[i].length;
        }
        List<String> list = new ArrayList<>(total);
        StringBuilder sb;
        for (int count = total; count > 0; --count) {
            sb = new StringBuilder();
            for (int i = 0; i < matrix.length; ++i) {
                sb.append(matrix[i][counterArray[i]]);
            }
            list.add(sb.toString());
            for (int incIndex = matrix.length - 1; incIndex >= 0; --incIndex) {
                if (counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                    ++counterArray[incIndex];
                    break;
                }
                counterArray[incIndex] = 0;
            }
        }
        return list;
    }

    public static List<Character> getCharsForDigit(char i) {
        switch (i) {
            case '2':
                return Arrays.asList('A', 'B', 'C');
            case '3':
                return Arrays.asList('D', 'E', 'F');
            case '4':
                return Arrays.asList('G', 'H', 'I');
            case '5':
                return Arrays.asList('J', 'K', 'L');
            case '6':
                return Arrays.asList('M', 'N', 'O');
            case '7':
                return Arrays.asList('P', 'Q', 'R', 'S');
            case '8':
                return Arrays.asList('T', 'U', 'V');
            case '9':
                return Arrays.asList('W', 'X', 'Y', 'Z');
            default:
                return List.of('-');
        }
    }
}