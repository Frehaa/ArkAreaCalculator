public class AreaCalculator {
    private int width;
    private int height;
    private int radius;

    private int[][] grid; // x, y grid
    private int[] factionAreaCounter;

    public AreaCalculator(int width, int height, int radius) {
        this.width = width + 1;
        this.height = height + 1;
        this.radius = radius;

        grid = new int[this.width][this.height];
        factionAreaCounter = new int[5];
        factionAreaCounter[0] = this.width * this.height;
    }

    public void addPoint(int x, int y) {
        addPoint(x, y, 1);
    }

    public void addPoint(int x, int y, int faction) {
        if (x < 0 || width <= x) throw new RuntimeException("Out of bounds");
        if (y < 0 || height <= y) throw new RuntimeException("Out of bounds");

        for (int yDiff = -radius; yDiff <= radius; ++yDiff) {
            for (int xDiff = -radius; xDiff <= radius; ++xDiff) {
                int currentX = x + xDiff;
                int currentY = y + yDiff;

                if (currentX < 0 || width <= currentX) continue;
                if (currentY < 0 || height<= currentY) continue;

                updateArea(currentX, currentY, faction);
            }
        }
    }

    private void updateArea(int x, int y, int faction) {
        --factionAreaCounter[grid[x][y]];
        ++factionAreaCounter[faction];
        grid[x][y] = faction;
    }

    public float calculateArea() {
        return calculateArea(1);
    }

    public float calculateArea(int faction) {
        float totalArea = width * height;
        return (float) factionAreaCounter[faction] / totalArea;
    }
}
