package entities;

public class MrBuilder implements Entity {
    @Override
    public void defaultProcess() {
        processMr(calculateProcess());
    }

    private int calculateProcess() {
        return 1;
    }

    private void processMr(int process) {
        saveIntoDB(process);
    }

    private void saveIntoDB(int process) {
        System.out.println("Saved in BD");
    }
}
