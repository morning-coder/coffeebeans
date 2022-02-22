package CoffeeBeans;

public class GameShowDriver {

    private static final int ITERATIONS = 1000;
    private static final GameService gameService = new GameService();
    private static final String result = "Stay : count %s = %s.%s%% | Switch : count %s = %s.%s%%";

    public GameShowDriver() {
    }

    public static void main(String[] args) {
        int stayCount = 0;
        int switchCount = 0;

        for(int i = 0; i < ITERATIONS; i++){
            if (gameService.switchDoorChoice()) {
                switchCount++;
            } else {
                stayCount++;
            }
        }

        System.out.println(String.format(result,
                stayCount,
                stayCount / 10,
                stayCount % 10,
                switchCount,
                switchCount / 10,
                switchCount % 10)
        );

    }

}
