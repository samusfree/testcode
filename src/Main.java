import entities.Entity;
import entities.MrBuilder;

public class Main {
    public static void main(String[] args) {
        MrBuilder dogObject = new MrBuilder();
        doSomething(dogObject);
    }

    public static void doSomething(Entity entity) {
        entity.defaultProcess();
    }
}