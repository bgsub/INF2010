import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {
    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int minCost(Cell[][] grid) {
        /* Ne pas modifier ce code */
        int m = grid.length, n = grid[0].length;
        int maxPosX = m - 1,maxPosY = n - 1 ;

        Cell[][] costs = new Cell[m][n];
        for (Cell[] c : costs){
            for(int i = 0; i < c.length; i++){
                c[i] = new Cell(0,0,Integer.MAX_VALUE);
            }
        }
        costs[0][0].cost = 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(0,0,0)); // Index 0: x , Index 1: y, Index 2 : cout
        /* Ne pas modifier ce code */


        while (!heap.isEmpty()) {
            Cell curr = heap.poll();
            int x = curr.xPos, y = curr.yPos, cost = curr.cost;
            if (x == maxPosX && y == maxPosY) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x + dir[1], newY = y + dir[0];
                if (newX > maxPosX || newY > maxPosY || newX < 0 || newY < 0) {
                    continue;
                }
                int newCost = ((i+1) == grid[x][y].cost ? cost:cost+1);

                if (costs[newX][newY].cost > newCost) {
                    costs[newX][newY].cost = newCost;
                    heap.offer(new Cell(newX, newY, newCost));
                }
            }
        }
        return -1;
    }
}