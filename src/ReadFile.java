import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public ArrayList<List> ReadingFile(String filename) throws FileNotFoundException{
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<List> deneme2 =  new ArrayList<>();
            String line;
            boolean hasNextLine = false;
            while(hasNextLine = scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] arrOfStr = line.split("\t", -2);

                List<String> deneme = Arrays.asList(arrOfStr);
                deneme2.add(deneme);
            }
            return deneme2;
        }

    }
}