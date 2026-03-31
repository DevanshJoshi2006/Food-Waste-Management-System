public class PartyService {

    public static void start(String meal, String mode) {

        int people = UI.inputInt("Enter number of guests:");

        double[] required;

    
        if (mode.equals("Normal (Average)")) {
            required = AverageCalculator.getAvg(meal, people);
        } 
     
        else {
            required = HomeService.getCustom(meal, people);
        }

        double[] prepared = HomeService.getPrepared(meal);

        String result = FoodAnalyzer.analyze(required, prepared, meal, people);

        UI.show(result);
    }
}