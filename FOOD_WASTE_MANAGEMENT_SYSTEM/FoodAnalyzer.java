public class FoodAnalyzer {

    
    public static String analyze(double[] r, double[] p, String meal, int people) {

        String msg = "People: " + people + "\n";
        msg += "Meal: " + meal + "\n\n";
        msg += "------ REPORT ------\n";

        msg += analyzeItem("Roti", r[0], p[0]);
        msg += analyzeItem("Dal", r[1], p[1]);
        msg += analyzeItem("Sabji", r[2], p[2]);
        msg += analyzeItem("Rice", r[3], p[3]);

        return msg;
    }

    static String analyzeItem(String name, double r, double p) {

        if (r == 0 && p == 0) return "";

        String unit = "";

        if (name.equals("Roti")) unit = " pieces";
        else if (name.equals("Rice")) unit = " cups";
        else unit = " bowls";

        String res = name + " -> Required: " + format(r) + unit +", Prepared: " + format(p) + unit + " : ";

        if (p > r) {
            res += "WASTED (" + format(p- r) + unit + " extra)\n";
        } 
        else if (p < r) {
            res += "SHORTAGE (" + format(r - p) + unit + " less)\n";
        } 
        else {
            res += "PERFECT\n";
        }

        return res;
    }

  
    static String format(double value) {

        if (value == 0.5) return "1/2";
        if (value == (int) value) return String.valueOf((int) value);

        return String.valueOf(value);
    }
}