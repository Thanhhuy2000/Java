import exception.InvalidExplorerException;
import service.Simulation;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        try {
            sim.setup();
            sim.run();
        } catch (InvalidExplorerException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}