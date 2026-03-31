public class AverageCalculator {

    public static double[] getAvg(String meal, int people) {

        double roti = 0, dal = 0, sabji = 0, rice = 0;

        // Roti meals
        if (meal.equals("Dal+Roti")) {
            roti = 2 * people;
            dal = 1 * people;
        } 
        else if (meal.equals("Sabji+Roti")) {
            roti = 2 * people;
            sabji = 1 * people;
        } 
        else if (meal.equals("Dal+Roti+Sabji")) {
            roti = 2 * people;
            dal = 0.5 * people;
            sabji = 0.5 * people;
        }

        // Rice meals
        else if (meal.equals("Rice+Dal")) {
            rice = 1 * people;
            dal = 1 * people;
        } 
        else if (meal.equals("Rice+Sabji")) {
            rice = 1 * people;
            sabji = 1 * people;
        } 
        else if (meal.equals("Rice+Dal+Sabji")) {
            rice = 1 * people;
            dal = 0.5 * people;
            sabji = 0.5 * people;
        }

        return new double[]{roti, dal, sabji, rice};
    }
}