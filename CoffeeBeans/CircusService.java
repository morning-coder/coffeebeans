package CoffeeBeans.day3;

public class CircusService {
    private static final Double PI = 3.14159265359;

    public CircusService() {
    }

    public double minPossibleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double side1, side2, side3;
        double angle1, angle2, angle3;
        double radius, sideCount, area;

        side1 = calculateSide(x1, y1, x2, y2);
        side2 = calculateSide(x1, y1, x3, y3);
        side3 = calculateSide(x3, y3, x2, y2);
        radius = calculateRadius(side1, side2, side3);

        angle1 = calculateAngle(side2, side3, side1);
        angle2 = calculateAngle(side1, side3, side2);
        angle3 = calculateAngle(side1, side2, side3);

        sideCount = PI / gcd(angle1, gcd(angle2, angle3));
        area = calculateAreaOfPolygon(sideCount, radius);
        return area;
    }

    private double calculateAreaOfPolygon(double sideCount, double radius) {
        return (sideCount * radius * radius * Math.sin((2 * PI) / sideCount)) / 2;
    }

    private double calculateAngle(double side1, double side2, double side3) {
        return Math.acos(
                ((side1 * side1) + (side2 * side2) - (side3 * side3)) /
                        (2 * side1 * side2)
        );
    }

    private double calculateRadius(double side1, double side2, double side3) {
        double area = calculateAreaOfTriangle(side1, side2, side3);
        double radius = (side1 * side2 * side3) / (area * 4);
        return radius;
    }

    private double calculateAreaOfTriangle(double side1, double side2, double side3) {
        double semiParameter = calculateParameter(side1, side2, side3) / 2;
        double area = Math.sqrt(semiParameter * (semiParameter - side1) * (semiParameter - side2) * (semiParameter - side3));
        return area;
    }

    private double calculateParameter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    private double calculateSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(
                (x2 - x1) * (x2 - x1) +
                (y2 - y1) * (y2 - y1));
    }

    private double mod_function(double num1, double num2){
        int quotient = (int) Math.floor(num1 / num2);
        return num1 - quotient * num2;
    }

    private double gcd(double num1, double num2){
        if(Math.abs(num2) < 1e-4)
            return num1;
        return gcd(num2, mod_function(num1, num2));
    }
}
