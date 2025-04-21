import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class App {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        try { 
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().trim();
                if (line.length() > 0) {
                    if (map.containsKey(line)) {
                        int count = map.get(line);
                        map.put(line, count + 1);
                    } else {
                        map.put(line, 1);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        try {
            PrintWriter pw = new PrintWriter("output.txt");
            ArrayList<String> words = new ArrayList<String>(map.keySet());
            Collections.sort(words);
            for (String w : words) {
                pw.println(w + " " + map.get(w));
            }
            pw.close();
            System.out.println("Done writing to file.");
        } catch (IOException e) {
            System.out.println("Could not write output file");
        }
    }
}
