import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {

        // Iterating through all input files
        for (String arg : args) {
            System.out.println("For graph in " + arg);

            boolean[][] adjMat = parseAdjMat(arg);
        }
    }

    private static boolean[][] parseAdjMat(String fileName) {
        ArrayList<String[]> parsedInputs = new ArrayList<>();
        HashMap<String, Integer> bijection = new HashMap<>();
        Path path = Paths.get(fileName);
        try {
            Stream<String> lines = Files.lines(path);
            lines.map(line -> line.split("( - +)|( – +)"))
                    .forEach(strarr -> {
                        parsedInputs.add(strarr);
                        for (String node : strarr) {
                            if (!bijection.containsKey(node))
                                bijection.put(node, bijection.size());
                        }
                    }
                    );

            boolean[][] matrix = new boolean[bijection.size()][bijection.size()];
            for(String[] strarr : parsedInputs) {
                matrix[bijection.get(strarr[0])][bijection.get(strarr[1])] = true;
                matrix[bijection.get(strarr[1])][bijection.get(strarr[0])] = true;
            }

            return matrix;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new boolean[0][];
    }

}