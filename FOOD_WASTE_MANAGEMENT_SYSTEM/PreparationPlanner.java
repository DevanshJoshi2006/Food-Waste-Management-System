public class PreparationPlanner {

    public static String prepare(
            double[] required,
            String meal,
            int people
    ) {

        StringBuilder msg =
                new StringBuilder();

        msg.append(
                "=== FOOD TO PREPARE ===\n\n"
        );

        if(MealParser.hasRoti(meal)) {

            msg.append("Roti: ")
               .append(required[0])
               .append(" pieces\n");
        }

        if(MealParser.hasDal(meal)) {

            msg.append("Dal: ")
               .append(required[1])
               .append(" bowls\n");
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

            msg.append(label)
               .append(": ")
               .append(required[2])
               .append(" bowls\n");
        }

        if(MealParser.hasRice(meal)) {

            msg.append("Rice: ")
               .append(required[3])
               .append(" cups\n");
        }

        msg.append("\nPeople: ")
           .append(people);

        return msg.toString();
    }
}