//Gives suggestions to reduce food wastage
public class SuggestionEngine {

    public static String suggest(double[] r, double[] p, String meal) {

        String result = "";

        if (MealParser.hasRoti(meal)) {
            result += getSuggestion("Roti", r[0], p[0]);
        }

        if (MealParser.hasDal(meal)) {
            result += getSuggestion("Dal", r[1], p[1]);
        }

        if (MealParser.hasSabji(meal)) {
            result += getSuggestion("Sabji", r[2], p[2]);
        }

        if (MealParser.hasRice(meal)) {
            result += getSuggestion("Rice", r[3], p[3]);
        }

        if (result.isEmpty()) {
            return "Perfect Planning";
        }

        return result;
    }

    // Helper method
    static String getSuggestion(String name, double r, double p) {

        if (p > r) {
            return "Reduce " + name + "\n";
        }

        if (p < r) {
            return "Increase " + name + "\n";
        }

        return "";
    }
}