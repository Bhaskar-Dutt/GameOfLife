import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final Set<Cell> aliveCells;

    public Grid(Set<Cell> initialAliveCells) {
        this.aliveCells = new HashSet<>(initialAliveCells);
    }

    public Set<Cell> getNextGeneration() {
        Set<Cell> newAliveCells = new HashSet<>();
        Set<Cell> potentialCells = new HashSet<>(aliveCells);

        // Add neighbors to potential cells
        for (Cell cell : aliveCells) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) {
                        potentialCells.add(new Cell(cell.getX() + dx, cell.getY() + dy));
                    }
                }
            }
        }

        // Apply rules
        for (Cell cell : potentialCells) {
            int liveNeighbors = countLiveNeighbors(cell);
            if (aliveCells.contains(cell)) {
                if (liveNeighbors == 2 || liveNeighbors == 3) {
                    newAliveCells.add(cell); // Rule 3
                }
            } else {
                if (liveNeighbors == 3) {
                    newAliveCells.add(cell); // Rule 4
                }
            }
        }

        return newAliveCells;
    }

    private int countLiveNeighbors(Cell cell) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    if (aliveCells.contains(new Cell(cell.getX() + dx, cell.getY() + dy))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
