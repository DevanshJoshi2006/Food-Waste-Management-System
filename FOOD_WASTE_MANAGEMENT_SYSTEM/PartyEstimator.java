public class PartyEstimator {

    public static String estimate(
            String meal,
            double[] prepared
    ) {

        int people = 0;

        if(MealParser.hasRoti(meal)) {

            people =
                    (int)(prepared[0] / 2);
        }

        else if(MealParser.hasRice(meal)) {

            people =
                    (int)(prepared[3]);
        }

        String result =
                "=== ESTIMATION ===\n\n";

        result +=
                "Estimated people who can eat: "
                + people;

        return result;
    }
}