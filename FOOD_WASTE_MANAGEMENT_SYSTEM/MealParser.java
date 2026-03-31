public class MealParser {

    public static boolean hasRoti(String meal) {
        return meal.contains("Roti");
    }

    public static boolean hasDal(String meal) {
        return meal.contains("Dal");
    }

    public static boolean hasSabji(String meal) {
        return meal.contains("Sabji");
    }

    public static boolean hasRice(String meal) {
        return meal.contains("Rice");
    }
}