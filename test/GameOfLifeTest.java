import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    void testNextGeneration() {
        Set<Cell> initialAliveCells = new HashSet<>();
        initialAliveCells.add(new Cell(1, 0));
        initialAliveCells.add(new Cell(2, 1));
        initialAliveCells.add(new Cell(0, 1));
        initialAliveCells.add(new Cell(1, 1));
        initialAliveCells.add(new Cell(2, 2));

        Grid grid = new Grid(initialAliveCells);
        Set<Cell> nextGeneration = grid.getNextGeneration();

        Set<Cell> expectedCells = new HashSet<>();
        expectedCells.add(new Cell(1, 0));
        expectedCells.add(new Cell(0, 1));
        expectedCells.add(new Cell(1, 1));
        expectedCells.add(new Cell(2, 1));
        expectedCells.add(new Cell(2, 0));

        assertEquals(expectedCells, nextGeneration);
    }
}
