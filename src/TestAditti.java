import java.util.LinkedList;

public class TestAditti {


    /*
    *  List of numbers 0 1
    *  Order List
    *  1 fist after 0
    *
    *
    * */

    public static void main(String[] args) {
        Integer[] array = {0, 1, 1, 0, 0, 1};

        orderNumbers(array);
        for (int j : array) {
            System.out.println(j);
        }
    }

    static void orderNumbers(LinkedList<Integer> numbers) {

    }


    static void orderNumbers(Integer[] a) {
        int temporal;
        for(int i = 0; i< a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] < a[j]) {
                    temporal = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temporal;
                }
            }
        }
    }
}
