import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] parameters = firstLine.split(" ");

        int minLat = Integer.parseInt(parameters[0]);
        int minLon = Integer.parseInt(parameters[1]);
        int maxLat = Integer.parseInt(parameters[2]);
        int maxLon = Integer.parseInt(parameters[3]);

        LatLongTranslator translator = new LatLongTranslator(minLat, minLon, maxLat, maxLon, 1);

        int gridWidth = translator.width();
        int gridHeight = translator.height();

        AreaCalculator calculator = new AreaCalculator(gridWidth, gridHeight, 1);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");

            float lat = Float.parseFloat(split[0]);
            float lon = Float.parseFloat(split[1]);

            int faction = 1;
            if (split.length > 2)
                faction = Integer.parseInt(split[2]);

            int x = translator.translateLat(lat);
            int y = translator.translateLon(lon);

//            System.out.println("x = " + x);
//            System.out.println("y = " + y);

            calculator.addPoint(x, y, faction);

//            System.out.format("Free area: %.4f%%\n", calculator.calculateArea(0) * 100);
//            System.out.format("Area 1: %.4f%%\n", calculator.calculateArea(1) * 100);
//            System.out.format("Area 2: %.4f%%\n", calculator.calculateArea(2) * 100);
//            System.out.format("Area 3: %.4f%%\n", calculator.calculateArea(3) * 100);
//            System.out.println();
        }

        System.out.format("Free area: %.4f%%\n", calculator.calculateArea(0) * 100);
        System.out.format("Area 1: %.4f%%\n", calculator.calculateArea(1) * 100);
        System.out.format("Area 2: %.4f%%\n", calculator.calculateArea(2) * 100);
        System.out.format("Area 3: %.4f%%\n", calculator.calculateArea(3) * 100);
    }
}
