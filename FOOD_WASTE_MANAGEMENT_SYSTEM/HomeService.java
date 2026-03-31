public class HomeService {

    public static void start(String meal, String mode) {

        int people = UI.inputInt("Enter number of people:");

        double[] required;

        
        if (mode.equals("Normal (Average)")) {
            required = AverageCalculator.getAvg(meal, people);
        } 
        
        else {
            required = getCustom(meal, people);
        }

        double[] prepared = getPrepared(meal);

        String result = FoodAnalyzer.analyze(required, prepared, meal, people);

        UI.show(result);
    }

    // CUSTOM INPUT
    public static double[] getCustom(String meal, int people) {

        double roti = 0, dal = 0, sabji = 0, rice = 0;

        if (MealParser.hasRoti(meal))
            roti = UI.inputDouble("Roti per person:") * people;

        if (MealParser.hasDal(meal))
            dal = UI.inputDouble("Dal per person (bowls):") * people;

        if (MealParser.hasSabji(meal))
            sabji = UI.inputDouble("Sabji per person (bowls):") * people;

        if (MealParser.hasRice(meal))
            rice = UI.inputDouble("Rice per person (cups):") * people;

        return new double[]{roti, dal, sabji, rice};
    }

    // PREPARED FOOD INPUT
    public static double[] getPrepared(String meal) {

        double roti = 0, dal = 0, sabji = 0, rice = 0;

        if (MealParser.hasRoti(meal))
            roti = UI.inputDouble("Enter prepared Roti:");

        if (MealParser.hasDal(meal))
            dal = UI.inputDouble("Enter prepared Dal (bowls):");

        if (MealParser.hasSabji(meal))
            sabji = UI.inputDouble("Enter prepared Sabji (bowls):");

        if (MealParser.hasRice(meal))
            rice = UI.inputDouble("Enter prepared Rice (cups):");

        return new double[]{roti, dal, sabji, rice};
    }
}