import javax.swing.*;

public class UI {

    public static void start() {

        setUI();

        String place = select("Select Place", new String[]{"Home", "Party/Event"});
        String meal = select("Select Meal", new String[]{
                "Dal+Roti", "Sabji+Roti", "Dal+Roti+Sabji",
                "Rice+Dal", "Rice+Sabji", "Rice+Dal+Sabji"
        });
        String mode = select("Select Mode", new String[]{
                "Normal (Average)", "Custom"
        });

        // if user cancels anything → stop
        if (place == null || meal == null || mode == null) return;

        if (place.equals("Home")) {
            HomeService.start(meal, mode);
        } else {
            PartyService.start(meal, mode);
        }
    }

    // set system UI look
    static void setUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
    }

    // dropdown selection
    static String select(String msg, String[] options) {
        return (String) JOptionPane.showInputDialog(
                null, msg, msg,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );
    }

    // integer input
    static int inputInt(String msg) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                error("Enter valid number!");
            }
        }
    }

    // double input
    static double inputDouble(String msg) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                error("Enter valid number!");
            }
        }
    }

    // show result
    static void show(String msg) {
        JTextArea area = new JTextArea(msg);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        JOptionPane.showMessageDialog(null, new JScrollPane(area));
    }

    // show error
    static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}