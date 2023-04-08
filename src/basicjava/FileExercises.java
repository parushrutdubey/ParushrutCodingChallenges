package basicjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExercises {

	public static int counting(String word)throws IOException {
		// TODO Auto-generated method stub
		int count = 0;

        BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\CS219-user\\eclipse-workspace\\GradeCalculator")); 
            String line;

            while ((line =reader.readLine())!= null) {
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }
        

        return count;
		
	}

	public void toUpper(String s1, String s2) throws IOException {
		  try (BufferedReader br = new BufferedReader(new FileReader(s1));
		             BufferedWriter bw = new BufferedWriter(new FileWriter(s2))) {

		            String line;

		            while ((line = br.readLine()) != null) {
		                bw.write(line.toUpperCase());
		                bw.newLine();
		            }
		        }

		
		
	}
	

}
