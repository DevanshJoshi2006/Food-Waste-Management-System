public class CustomMealManager {

    static String customFoodName =
            "Custom Food";

    // GET NAME
    public static String getFoodName() {

        String input =
                UI.inputText(
                        "Enter Food Name:"
                );

        if(input == null
           || input.trim().isEmpty()) {

            customFoodName =
                    "Custom Food";

        } else {

            customFoodName = input;
        }

        return customFoodName;
    }

    // DEFAULT VALUE
    public static double[] getDefault(
            int people
    ) {

        double customFood =
                1 * people;

        return new double[]{
                0,
                0,
                customFood,
                0
        };
    }

    // GET STORED NAME
    public static String getName() {

        return customFoodName;
    }
}