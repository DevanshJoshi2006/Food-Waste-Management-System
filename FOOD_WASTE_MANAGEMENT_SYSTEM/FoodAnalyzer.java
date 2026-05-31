public class FoodAnalyzer {

    public static String analyze(
            double[] r,
            double[] p,
            String meal,
            int people
    ) {

        String msg = "";

        msg += "People: "
                + people + "\n";

        msg += "Meal: "
                + meal + "\n\n";

        msg +=
                "------ REPORT ------\n";

        // ROTI
        msg += analyzeItem(
                "Roti",
                r[0],
                p[0]
        );

        // DAL
        msg += analyzeItem(
                "Dal",
                r[1],
                p[1]
        );

        // SABJI / CUSTOM
        String sabjiName = "Sabji";

        if(!meal.contains("Roti")
           && !meal.contains("Dal")
           && !meal.contains("Rice")
           && r[2] > 0) {

            sabjiName =
                    CustomMealManager
                            .getName();
        }

        msg += analyzeItem(
                sabjiName,
                r[2],
                p[2]
        );

        // RICE
        msg += analyzeItem(
                "Rice",
                r[3],
                p[3]
        );

        // STATUS
        msg += "\nOverall Status: ";

        if(isPerfect(r, p)) {

            msg += "Balanced";

        } else {

            msg +=
                    "Needs Improvement";
        }

        return msg;
    }

    // ITEM ANALYSIS
    static String analyzeItem(
            String name,
            double required,
            double prepared
    ) {

        if(required == 0
           && prepared == 0)
            return "";

        String unit = "";

        if(name.equals("Roti")) {

            unit = " pieces";

        } else if(name.equals("Rice")) {

            unit = " cups";

        } else {

            unit = " bowls";
        }

        String res = "";

        res += name + " -> ";

        res += "Required: "
                + format(required)
                + unit;

        res += ", Prepared: "
                + format(prepared)
                + unit;

        res += " : ";

        // WASTAGE
        if(prepared > required) {

            res += "WASTED (";

            res += format(
                    prepared - required
            );

            res += unit
                    + " extra)\n";
        }

        // SHORTAGE
        else if(prepared < required) {

            res += "SHORTAGE (";

            res += format(
                    required - prepared
            );

            res += unit
                    + " less)\n";
        }

        // PERFECT
        else {

            res += "PERFECT\n";
        }

        return res;
    }

    // FORMAT VALUES
    static String format(double value) {

        if(value == 0.5)
            return "1/2";

        if(value == (int)value)
            return String.valueOf(
                    (int)value
            );

        return String.valueOf(value);
    }

    // BALANCE CHECK
    static boolean isPerfect(
            double[] r,
            double[] p
    ) {

        for(int i = 0;
            i < r.length;
            i++) {

            if(r[i] != p[i])
                return false;
        }

        return true;
    }
}