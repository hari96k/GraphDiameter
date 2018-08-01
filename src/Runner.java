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
            int distance = findDistance(adjMat);
            System.out.println("Max distance found: " + distance);
        }
    }

    private static int findDistance(boolean[][] adjMat) {
        int[][] dist = new int[adjMat.length][adjMat.length];

        for(int i = 0; i < dist.length; i++){
            for(int j = 0; j < dist.length; j++){
                dist[i][j] = adjMat[i][j]? 1 : 99999;
            }
        }


        int max = 0;
        for (int k = 0; k < adjMat.length; k++)
        {
            for (int i = 0; i < adjMat.length; i++)
            {
                for (int j = 0; j < adjMat.length; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];

                        if(dist[i][j] > max){
                            max = dist[i][j];
                        }
                    }
                }
            }
        }
        return max;
    }

    private static boolean[][] parseAdjMat(String fileName) {
        ArrayList<String[]> parsedInputs = new ArrayList<>();
        HashMap<String, Integer> bijection = new HashMap<>();
        boolean[][] matrix = null;

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
            lines.close();

            matrix = new boolean[bijection.size()][bijection.size()];
            for(String[] strarr : parsedInputs) {
                matrix[bijection.get(strarr[0])][bijection.get(strarr[1])] = true;
                matrix[bijection.get(strarr[1])][bijection.get(strarr[0])] = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

}