package Laba7_DynamicProgramming.Laba7_1;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private final List<List<Integer>> matrix;
    private final int height;
    private final int width;

    public PathFinder(List<List<Integer>> matrix) {
        this.matrix = matrix;
        this.height = matrix.size();
        this.width = matrix.getFirst().size();
    }

    private enum Direction {
        DOWN,
        RIGHT
    }

    public class Path {
        private final List<Direction> directions;
        private final int profit;
        private final int row;
        private final int column;

        public Path() {
            this.directions = new ArrayList<>(0);
            this.profit = 0;
            this.row = 0;
            this.column = 0;
        }

        private Path(Path prev, Direction newDirection) {
            this.directions = new ArrayList<>(prev.directions.size() + 1);
            this.directions.addAll(prev.directions);
            this.directions.addLast(newDirection);

            if (newDirection == Direction.RIGHT) {
                this.column = prev.column + 1;
                this.row = prev.row;
            } else {
                this.row = prev.row + 1;
                this.column = prev.column;
            }
            this.profit = prev.profit + matrix.get(this.row).get(this.column);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Путь с профитом: ").append(profit).append(": ");
            for (Direction d : directions) {
                sb.append(d == Direction.DOWN ? "D " : "R ");
            }
            return sb.toString();
        }
    }

    private List<Path> paths;

    public void calculatePaths() {
        List<Path> previousGenPaths;
        List<Path> nextGenPaths = new ArrayList<>(1);
        nextGenPaths.add(new Path());
        for (int i = 0; i < height + width - 2; i++) {
            previousGenPaths = nextGenPaths;
            nextGenPaths = new ArrayList<>(previousGenPaths.size() * 2);

            for (Path p : previousGenPaths) {
                if (p.column < width - 1) {
                    nextGenPaths.add(new Path(p, Direction.RIGHT));
                }
                if (p.row < height - 1) {
                    nextGenPaths.add(new Path(p, Direction.DOWN));
                }
            }


        }
        paths = nextGenPaths;
    }


    public List<Path> getPathList(){
        return this.paths;
    }

    public Path getBestPath(){
        if(paths == null || paths.getFirst() == null){
            return null;
        }
        Path result = paths.getFirst();
        for(Path p : paths){
            if(p.profit > result.profit){
                result = p;
            }
        }
        return result;
    }

}
