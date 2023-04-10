package basicjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExercises {

    public static int counting(String word) throws IOException {
        int count = 0;
        word=word.toLowerCase();
        BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String w : words) {
            	w=w.toLowerCase();
                if (w.equals(word)) {
                    count=count+1;
                }
            }
        }
        reader.close();
        return count;
    }

    public static void toUpper(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        FileWriter writer = new FileWriter(outputFile);
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line.toUpperCase() + "\n");
        }
        reader.close();
        writer.close();
    }
}
