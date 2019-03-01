import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> wordsOccurrences = new HashMap<>();

        String fileName = "./src/test.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream
                    .map(line -> line.replaceAll("[^a-zA-Zа-яА-Я0-9 ]", "").toLowerCase())
                    .forEach(line -> {
                        for(String s : line.split("\\s+")) {
                            wordsOccurrences.put(s, wordsOccurrences.getOrDefault(s, 0) + 1);
                        }
                    });

            wordsOccurrences.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue((v1, v2) -> v2 - v1))
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
