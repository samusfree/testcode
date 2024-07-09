package entities;

public class Lion implements Entity{
    @Override
    public void defaultProcess() {
        roar();
    }

    private void roar(){
        System.out.println("roar");
    }
}
