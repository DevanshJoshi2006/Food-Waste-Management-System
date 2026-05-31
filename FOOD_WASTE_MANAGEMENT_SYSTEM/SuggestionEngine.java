public class SuggestionEngine {

    public static String suggest(
            double[] r,
            double[] p,
            String meal
    ) {

        String result = "";

        if(MealParser.hasRoti(meal)) {

            result += getSuggestion(
                    "Roti",
                    r[0],
                    p[0]
            );
        }

        if(MealParser.hasDal(meal)) {

            result += getSuggestion(
                    "Dal",
                    r[1],
                    p[1]
            );
        }

        if(MealParser.hasSabji(meal)) {

            String label = "Sabji";

            if(!meal.contains("Roti")
               && !meal.contains("Dal")
               && !meal.contains("Rice")) {

                label =
                        CustomMealManager
                                .getName();
            }

            result += getSuggestion(
                    label,
                    r[2],
                    p[2]
            );
        }

        if(MealParser.hasRice(meal)) {

            result += getSuggestion(
                    "Rice",
                    r[3],
                    p[3]
            );
        }

        if(result.isEmpty()) {

            return "Perfect Planning";
        }

        return result;
    }

    // HELPER
    static String getSuggestion(
            String name,
            double r,
            double p
    ) {

        if(p > r) {

            return "Reduce "
                    + name + "\n";
        }

        if(p < r) {

            return "Increase "
                    + name + "\n";
        }

        return "";
    }
}