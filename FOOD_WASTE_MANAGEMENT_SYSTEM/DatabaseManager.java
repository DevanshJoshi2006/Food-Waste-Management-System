import java.io.FileWriter;

public class DatabaseManager {

    public static void save(String data) {

        try {

            FileWriter fw =
                    new FileWriter(
                            "history.txt",
                            true
                    );

            fw.write(data);

            fw.write(
                    "\n---------------------\n"
            );

            fw.close();

        } catch(Exception e) {

            System.out.println(
                    "Error saving history"
            );
        }
    }
}