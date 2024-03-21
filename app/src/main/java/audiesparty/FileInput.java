package audiesparty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    public static void load(List<Connection> connections) {
        try {
            File file = new File("app/src/main/resources/guests.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(" ")) {
                    String[] parts = line.split(" ");
                    String villager1 = parts[0];
                    String villager2 = parts[1];
                    int relationship = Integer.parseInt(parts[2]);
                    connections.add(new Connection(villager1, villager2, relationship));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Collections.sort(connections);
    }
}
