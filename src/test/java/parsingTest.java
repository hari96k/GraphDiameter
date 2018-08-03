import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class parsingTest {

    private File testFile;

    @org.junit.Before
    public void setUp() {
        testFile = new File("testFile");
    }

    @org.junit.After
    public void tearDown() {
        testFile.deleteOnExit();
    }

    @Test
    public void testParsing1() throws IOException {
        String graph = " ";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = new boolean[0][0];

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

    @Test
    public void testParsing2() throws IOException {
        String graph = "Not a valid line input\n" +
                       "But Still a valid file";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = new boolean[0][0];

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

    @Test
    public void testParsing3() throws IOException {
        String graph = "A!@#$%^&*()_+-B{}|?<>";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = {{false, true},
                                    {true, false}};

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

    @Test
    public void testParsing4() throws IOException {
        String graph = "A - B";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = {{false, true},
                                    {true, false}};

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

    @Test
    public void testParsing5() throws IOException {
        String graph =  "A - B\n" +
                        "A - B\n" +
                        "B - A\n" +
                        "B - A\n";

        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = {{false, true},
                                    {true, false}};

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

    @Test
    public void testParsing6() throws IOException {
        String graph = "A - A";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = {{false}};

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }


    @Test
    public void testParsing7() throws IOException {
        String graph =  "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "D - E\n";
        Files.write(testFile.toPath(), graph.getBytes());

        boolean[][] expectAdjMat = {{false, true, false, false, false},
                                    {true, false, true, false, false},
                                    {false, true, false, true, false},
                                    {false, false, true, false, true},
                                    {false, false, false, true, false}};

        boolean[][] outputAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assert(Arrays.deepEquals(expectAdjMat, outputAdjMat));
    }

}
