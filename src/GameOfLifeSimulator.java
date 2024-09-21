import java.util.Set;

public class GameOfLifeSimulator {
    private Grid grid;
    private Set<Cell> lastGeneration;

    public GameOfLifeSimulator(Set<Cell> initialAliveCells) {
        grid = new Grid(initialAliveCells);
        lastGeneration = initialAliveCells; // Initialize with the first generation
    }

    public void simulateGenerations(int generations) {
        Set<Cell> currentGeneration;

        for (int i = 0; i < generations; i++) {
            System.out.println("Live Cells:");
            currentGeneration = grid.getNextGeneration();
            if (currentGeneration.equals(lastGeneration)) {
                System.out.println("Stable state reached. No changes in the next generation.");
                break; // Stop if the generation is stable
            }
            printGeneration(currentGeneration);
            lastGeneration = currentGeneration; // Update lastGeneration for comparison
            grid = new Grid(currentGeneration); // Update grid for the next generation
            System.out.println(); // Blank line for better readability
        }
    }

    private void printGeneration(Set<Cell> aliveCells) {
        for (Cell cell : aliveCells) {
            System.out.println(cell);
        }
    }
}
