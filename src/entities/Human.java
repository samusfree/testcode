package entities;

public class Human implements Entity{
    @Override
    public void defaultProcess() {
        talk();
    }

    private void talk(){
        System.out.println("Human hello");
    }
}
