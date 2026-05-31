public class StatusSelector {

    public static String getStatus() {

        String[] options = {"Prepared", "Preparing"};

        return (String) javax.swing.JOptionPane.showInputDialog(
                null,
                "Select Food Status",
                "Food Status",
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}