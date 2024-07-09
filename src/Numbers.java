import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 7, 12, 3, 4, 13, 9, 1, 6};
        int target = 18;
        System.out.println(process(numbers, target));
    }

    public static List<String> process(int[] numbers, int target) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] * numbers[j] == target) {
                    result.add("[" + numbers[i] + ", " + numbers[j] + "]");
                }
            }
        }
        return result;
    }
}
