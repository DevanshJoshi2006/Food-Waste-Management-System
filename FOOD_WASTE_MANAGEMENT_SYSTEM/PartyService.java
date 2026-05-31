public class PartyService {

    public static void start(
            String meal,
            String mode,
            String status
    ) {

        String choice =
                UI.partyMode();

        // PEOPLE → FOOD
        if(choice.equals("People to Food")) {

            int people =
                    UI.inputInt(
                            "Enter number of guests:"
                    );

            double[] required;

            if(mode.equals("Normal (Average)")) {

                required =
                        AverageCalculator
                                .getAvg(meal, people);

            } else {

                required =
                        HomeService
                                .getCustom(meal, people);
            }

            String result =
                    PreparationPlanner.prepare(
                            required,
                            meal,
                            people
                    );

            UI.show(result);

            DatabaseManager.save(result);
        }

        // FOOD → PEOPLE
        else {

            double[] prepared =
                    HomeService
                            .getPrepared(meal);

            String result =
                    PartyEstimator
                            .estimate(
                                    meal,
                                    prepared
                            );

            UI.show(result);

            DatabaseManager.save(result);
        }
    }
}