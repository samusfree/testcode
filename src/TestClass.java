import entities.Cat;

import java.util.List;

public class TestClass {

    public void testCatMaul() {
        Cat cat = new Cat();

        //mockito para validar si se ejecuto una vez el metodo

        //ejecutaria
        Main.doSomething(cat);

        //asset para validar si se ejcuto una cvez el metodo maul
    }

    public void testNumbers() {
        int[] numbers = {2, 5, 7, 12, 3, 4, 13, 9, 1, 6};
        int target = 18;
        String expected = "[[2, 9], [3, 6]]";
        //ejecutar
        List<String> result =  Numbers.process(numbers, target);
        //assert para validar si result to string == expected
    }
}
