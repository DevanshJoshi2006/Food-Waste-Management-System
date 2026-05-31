public class HomeService {

    public static void start(
            String meal,
            String mode,
            String status
    ) {

        int people =
                UI.inputInt(
                        "Enter number of people:"
                );

        // CUSTOM FOOD
        if(meal.equals("Other")) {

            meal =
                    CustomMealManager
                            .getFoodName();
        }

        double[] required;

        // NORMAL MODE
        if(mode.equals("Normal (Average)")) {

            required =
                    AverageCalculator
                            .getAvg(meal, people);
        }

        // CUSTOM MODE
        else {

            required =
                    getCustom(meal, people);
        }

        // PREPARING MODE
        if(status.equals("Preparing")) {

            String prep =
                    PreparationPlanner
                            .prepare(
                                    required,
                                    meal,
                                    people
                            );

            UI.show(prep);

            DatabaseManager.save(prep);

            return;
        }

        // PREPARED MODE
        double[] prepared =
                getPrepared(meal);

        String result =
                FoodAnalyzer.analyze(
                        required,
                        prepared,
                        meal,
                        people
                );

        // SUGGESTIONS
        result +=
                "\n\n--- SUGGESTIONS ---\n";

        result +=
                SuggestionEngine.suggest(
                        required,
                        prepared,
                        meal
                );

        UI.show(result);

        DatabaseManager.save(result);
    }

    // ================= CUSTOM FOOD INPUT =================

    public static double[] getCustom(
            String meal,
            int people
    ) {

        double roti = 0,
               dal = 0,
               sabji = 0,
               rice = 0;

        // ROTI
        if(MealParser.hasRoti(meal)) {

            roti =
                    UI.inputDouble(
                            "Roti per person:"
                    ) * people;
        }

        // DAL
        if(MealParser.hasDal(meal)) {

            dal =
                    UI.inputDouble(
                            "Dal per person (bowls):"
                    ) * people;
        }

        // SABJI / CUSTOM FOOD
        if(MealParser.hasSabji(meal)) {

            String label = "Sabji";

            if(!meal.contains("Sabji")
               && !meal.contains("Dal")
               && !meal.contains("Rice")
               && !meal.contains("Roti")) {

                label =
                        CustomMealManager
                                .getName();
            }

            sabji =
                    UI.inputDouble(
                            label
                            + " per person (bowls):"
                    ) * people;
        }

        // RICE
        if(MealParser.hasRice(meal)) {

            rice =
                    UI.inputDouble(
                            "Rice per person (cups):"
                    ) * people;
        }

        return new double[]{
                roti,
                dal,
                sabji,
                rice
        };
    }

    // ================= PREPARED FOOD INPUT =================

    public static double[] getPrepared(
            String meal
    ) {

        double roti = 0,
               dal = 0,
               sabji = 0,
               rice = 0;

        // ROTI
        if(MealParser.hasRoti(meal)) {

            roti =
                    UI.inputDouble(
                            "Enter prepared Roti:"
                    );
        }

        // DAL
        if(MealParser.hasDal(meal)) {

            dal =
                    UI.inputDouble(
                            "Enter prepared Dal:"
                    );
        }

        // SABJI / CUSTOM FOOD
        if(MealParser.hasSabji(meal)) {

            String label = "Sabji";

            if(!meal.contains("Sabji")
               && !meal.contains("Dal")
               && !meal.contains("Rice")
               && !meal.contains("Roti")) {

                label =
                        CustomMealManager
                                .getName();
            }

            sabji =
                    UI.inputDouble(
                            "Enter prepared "
                            + label
                            + ":"
                    );
        }

        // RICE
        if(MealParser.hasRice(meal)) {

            rice =
                    UI.inputDouble(
                            "Enter prepared Rice:"
                    );
        }

        return new double[]{
                roti,
                dal,
                sabji,
                rice
        };
    }
}