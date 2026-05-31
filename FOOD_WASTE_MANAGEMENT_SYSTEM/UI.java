import java.awt.*;
import javax.swing.*;

public class UI {

    static JFrame frame;

    // COLORS
    static Color bg =
            new Color(245, 247, 250);

    static Color primary =
            new Color(52, 152, 219);

    static Color dark =
            new Color(44, 62, 80);

    public static void start() {

        setUI();

        frame =
                new JFrame(
                        "Food Waste Management System"
                );

        frame.setSize(650, 500);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.getContentPane()
                .setBackground(bg);

        frame.setLayout(
                new BorderLayout()
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel(
                        "Reduce Food Wastage System",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(dark);

        title.setBorder(
                BorderFactory
                        .createEmptyBorder(
                                20,
                                10,
                                20,
                                10
                        )
        );

        frame.add(
                title,
                BorderLayout.NORTH
        );

        // ================= MAIN PANEL =================

        JPanel panel =
                new JPanel();

        panel.setLayout(
                new GridLayout(
                        8,
                        2,
                        15,
                        15
                )
        );

        panel.setBackground(bg);

        panel.setBorder(
                BorderFactory
                        .createEmptyBorder(
                                20,
                                40,
                                20,
                                40
                        )
        );

        // PLACE
        JLabel placeLabel =
                new JLabel("Select Place:");

        JComboBox<String> placeBox =
                new JComboBox<>(
                        new String[]{
                                "Home",
                                "Party/Event"
                        }
                );

        // MEAL
        JLabel mealLabel =
                new JLabel("Select Meal:");

        JComboBox<String> mealBox =
                new JComboBox<>(
                        new String[]{
                                "Dal+Roti",
                                "Sabji+Roti",
                                "Dal+Roti+Sabji",
                                "Rice+Dal",
                                "Rice+Sabji",
                                "Rice+Dal+Sabji",
                                "Other"
                        }
                );

        // MODE
        JLabel modeLabel =
                new JLabel("Eating Mode:");

        JComboBox<String> modeBox =
                new JComboBox<>(
                        new String[]{
                                "Normal (Average)",
                                "Custom"
                        }
                );

        // STATUS
        JLabel statusLabel =
                new JLabel("Food Status:");

        JComboBox<String> statusBox =
                new JComboBox<>(
                        new String[]{
                                "Prepared",
                                "Preparing"
                        }
                );

        // BUTTON
        JButton startBtn =
                new JButton(
                        "START ANALYSIS"
                );

        startBtn.setBackground(primary);

        startBtn.setForeground(
                Color.WHITE
        );

        startBtn.setFocusPainted(false);

        startBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        // ADD COMPONENTS
        panel.add(placeLabel);
        panel.add(placeBox);

        panel.add(mealLabel);
        panel.add(mealBox);

        panel.add(modeLabel);
        panel.add(modeBox);

        panel.add(statusLabel);
        panel.add(statusBox);

        panel.add(new JLabel());
        panel.add(startBtn);

        frame.add(
                panel,
                BorderLayout.CENTER
        );

        // ================= BUTTON ACTION =================

        startBtn.addActionListener(e -> {

            String place =
                    (String) placeBox
                            .getSelectedItem();

            String meal =
                    (String) mealBox
                            .getSelectedItem();

            String mode =
                    (String) modeBox
                            .getSelectedItem();

            String status =
                    (String) statusBox
                            .getSelectedItem();

            // HOME
            if(place.equals("Home")) {

                HomeService.start(
                        meal,
                        mode,
                        status
                );
            }

            // PARTY
            else {

                PartyService.start(
                        meal,
                        mode,
                        status
                );
            }
        });

        frame.setVisible(true);
    }

    // ================= LOOK & FEEL =================

    static void setUI() {

        try {

            UIManager.setLookAndFeel(
                    UIManager
                            .getSystemLookAndFeelClassName()
            );

        } catch(Exception e) {}
    }

    // ================= DROPDOWN =================

    static String select(
            String msg,
            String[] options
    ) {

        return (String)
                JOptionPane.showInputDialog(
                        frame,
                        msg,
                        msg,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );
    }

    // ================= INTEGER INPUT =================

    static int inputInt(
            String msg
    ) {

        while(true) {

            try {

                String input =
                        JOptionPane
                                .showInputDialog(
                                        frame,
                                        msg
                                );

                return Integer.parseInt(
                        input
                );

            } catch(Exception e) {

                error(
                        "Enter valid integer!"
                );
            }
        }
    }

    // ================= DOUBLE INPUT =================

    static double inputDouble(
            String msg
    ) {

        while(true) {

            try {

                String input =
                        JOptionPane
                                .showInputDialog(
                                        frame,
                                        msg
                                );

                return Double.parseDouble(
                        input
                );

            } catch(Exception e) {

                error(
                        "Enter valid number!"
                );
            }
        }
    }

    // ================= TEXT INPUT =================

    static String inputText(
            String msg
    ) {

        return JOptionPane
                .showInputDialog(
                        frame,
                        msg
                );
    }

    // ================= SHOW RESULT =================

    static void show(
            String msg
    ) {

        JTextArea area =
                new JTextArea(msg);

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        15
                )
        );

        area.setLineWrap(true);

        area.setWrapStyleWord(true);

        JScrollPane pane =
                new JScrollPane(area);

        pane.setPreferredSize(
                new Dimension(
                        500,
                        300
                )
        );

        JOptionPane.showMessageDialog(
                frame,
                pane,
                "Result",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // ================= ERROR =================

    static void error(
            String msg
    ) {

        JOptionPane.showMessageDialog(
                frame,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // ================= PARTY MODE =================

    static String partyMode() {

        return (String)
                JOptionPane.showInputDialog(
                        frame,
                        "Select Party Mode",
                        "Party Mode",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{
                                "People to Food",
                                "Food to People"
                        },
                        "People to Food"
                );
    }
}