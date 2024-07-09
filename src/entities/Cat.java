package entities;

public class Cat implements Entity{
    @Override
    public void defaultProcess() {
        maul();
    }

    private void maul(){
        System.out.println("maul");
    }
}
