import java.util.Set;

public class GameOfLifeSimulator {
    private Grid grid;

    public GameOfLifeSimulator(Set<Cell> initialAliveCells) {
        grid = new Grid(initialAliveCells);
    }

    public void simulateGenerations(int generations) {
        for (int i = 0; i < generations; i++) {
            System.out.println("Live Cells:");
            Set<Cell> nextGeneration = grid.getNextGeneration();
            printGeneration(nextGeneration);
            grid = new Grid(nextGeneration); // Update grid for the next generation
            System.out.println(); // Blank line for better readability
        }
    }

    private void printGeneration(Set<Cell> aliveCells) {
        for (Cell cell : aliveCells) {
            System.out.println(cell);
        }
    }
}
