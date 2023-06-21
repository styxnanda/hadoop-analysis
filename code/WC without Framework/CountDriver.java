import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CountDriver {
    private static final HashMap<String, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws IOException {
      if (args.length != 2) {
          System.err.println("Usage: WordCount <input path> <output path>");
          System.exit(-1);
      }
  
      long startTime = System.currentTimeMillis();
  
      try (BufferedReader reader = Files.newBufferedReader(Paths.get(args[0]))) {
          String line;
          while ((line = reader.readLine()) != null) {
              StringTokenizer tokenizer = new StringTokenizer(line);
              while (tokenizer.hasMoreTokens()) {
                  String word = tokenizer.nextToken();
                  counts.put(word, counts.getOrDefault(word, 0) + 1);
              }
          }
      }
  
      try (PrintWriter writer = new PrintWriter(new FileWriter(args[1]))) {
          for (Map.Entry<String, Integer> entry : counts.entrySet()) {
              writer.println(entry.getKey() + "\t" + entry.getValue());
          }
      }
  
      long endTime = System.currentTimeMillis();
  
      System.out.println("Execution time in milliseconds: " + (endTime - startTime));
    }  
}
