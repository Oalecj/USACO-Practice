/*
ID: nikhilf1
LANG: JAVA
TASK: barn1
*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class barn1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("barn1.in"));
        PrintWriter pw = new PrintWriter(new File("barn1.out"));

        // Read and sort input
        int m = sc.nextInt();
        int s = sc.nextInt();
        int c = sc.nextInt();
        int[] stalls = new int[c];
        for(int i=0; i<c; i++) {
            stalls[i] = sc.nextInt();
        }
        Arrays.sort(stalls);

        Set<Board> boards = new HashSet<Board>();

        // Create and add the initial board
        boards.add(new Board(stalls[0], stalls[stalls.length-1]));

        // Add up to m-1 more boards
        for(int i=0; i<m-1; i++) {
            int gapLow = stalls[0];
            int gapHigh = stalls[0];

            // Find the maximum gap that a board contains
            for(Board board : boards) {
                for(int j=0; j<stalls.length-1; j++) {
                    // the gap must be covered, look for them in boards
                    if (stalls[j+1]-stalls[j] >= gapHigh-gapLow && board.contains(stalls[j]) && board.contains(stalls[j+1])) {
                        gapLow = stalls[j];
                        gapHigh = stalls[j+1];
                    }
                }
            }

            // Find the board containing the maximum gap
            Board targetBoard = null;
            for(Board board : boards) {
                if (board.contains(gapLow)) {
                    targetBoard = board;
                }
            }

            // Remove the old board
            boards.remove(targetBoard);

            // Place two new boards which bridge the largest gap
            boards.add(new Board(targetBoard.start, gapLow));
            boards.add(new Board(gapHigh, targetBoard.end));
        }

        int sum = 0;
        for(Board board : boards) {
            sum += board.end-board.start+1;
        }

        pw.println(sum);
        pw.close();
    }

    private static class Board {
        private final int start;
        private final int end;

        public Board(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains(int stall) {
            return stall >= start && stall <= end;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + end;
            result = prime * result + start;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Board other = (Board) obj;
            if (end != other.end)
                return false;
            if (start != other.start)
                return false;
            return true;
        }


    }
}
