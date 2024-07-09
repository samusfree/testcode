package entities;

public class Dog implements Entity{
    @Override
    public void defaultProcess() {
        bark();
    }

    private void bark() {
        System.out.println("Bark");
    }
}
