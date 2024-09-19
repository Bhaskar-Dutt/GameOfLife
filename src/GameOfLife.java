import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameOfLife {
    public static void main(String[] args) {
        Set<Cell> initialAliveCells = new HashSet<>();
        int number_of_cells;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial number of alive cells");
        number_of_cells = sc.nextInt();
        System.out.println("Enter the coordinates of live cells");
        for(int i = 0;i<number_of_cells;i++){
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            initialAliveCells.add(new Cell(x,y));
        }
//        initialAliveCells.add(new Cell(1, 0));
//        initialAliveCells.add(new Cell(2, 1));
//        initialAliveCells.add(new Cell(0, 1));
//        initialAliveCells.add(new Cell(1, 1));
//        initialAliveCells.add(new Cell(2, 2));

        GameOfLifeSimulator simulator = new GameOfLifeSimulator(initialAliveCells);

        // Specify the number of generations to simulate
        int generationsToSimulate = 5; // Change this value to simulate more or fewer generations
        simulator.simulateGenerations(generationsToSimulate);
    }
}
