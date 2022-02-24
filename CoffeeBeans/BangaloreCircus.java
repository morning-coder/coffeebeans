package CoffeeBeans.day3;

import java.util.Scanner;

public class BangaloreCircus {
    private static CircusService circusService = new CircusService();

    public BangaloreCircus() {
    }

    public static void main(String[] args) {
        double x1, y1, x2, y2, x3, y3;
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();
        x3 = scanner.nextDouble();
        y3 = scanner.nextDouble();

        double area = circusService.minPossibleArea(x1, y1, x2, y2, x3, y3);
        System.out.println(area);

    }
}
