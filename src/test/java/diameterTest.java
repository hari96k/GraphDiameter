import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class diameterTest {

    private File testFile;


    @org.junit.Before
    public void setUp() {
        testFile = new File("testFile");
    }

    @org.junit.After
    public void tearDown(){
        testFile.deleteOnExit();
    }

    @Test
    public void testDiameter0() {

        boolean[][] testAdjmat = {};

        assertEquals(0, Runner.findDistance(testAdjmat));
    }

    @Test
    public void testDiameter1() throws IOException {

        String graph = "A - B";
        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(1, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter2() throws IOException {

         /*
                 E
                  \
        A          D
          \       /
            B – C

         */

        String graph =  "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "D - E\n";
        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(4, Runner.findDistance(testAdjMat));

    }


    @Test
    public void testDiameter3() throws IOException {

        /*
            F – E
          /       \
        A          D
          \       /
            B – C

         */

        String graph =
                "A - B\n" +
                "B - C\n" +
                "C - D\n" +
                "D - E\n" +
                "E - F\n" +
                "F - A";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(3, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter4() throws IOException {

        /*
            F – E
            |    \
        A   |     D
          \ |    /
            B – C

         */

        String graph =
                        "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "D - E\n" +
                        "E - F\n" +
                        "F - B";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(3, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter5() throws IOException {

        /*
            F – E
            |    \
        A   |     D
          \ |
            B – C

         */

        String graph =
                        "A - B\n" +
                        "B - C\n" +
                        "D - E\n" +
                        "E - F\n" +
                        "F - B";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(4, Runner.findDistance(testAdjMat));

    }


    @Test
    public void testDiameter6() throws IOException {

        /*
        A – B – C – D
            |   |
            - E -
         */

        String graph =
                        "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "B - E\n" +
                        "C - E";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(3, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter7() throws IOException {

        /*
        A – B – C – D
        |   |   |   |
        E – F – G – H
         */

        String graph =  "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "A - E\n" +
                        "B - F\n" +
                        "C - G\n" +
                        "D - H\n" +
                        "E - F\n" +
                        "F - G\n" +
                        "G - H";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(4, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter8() throws IOException {

        /*
        A – B – C – D
            |
        E – F – G – H
         */

        String graph =  "A - B\n" +
                "B - C\n" +
                "C - D\n" +
                "B - F\n" +
                "E - F\n" +
                "F - G\n" +
                "G - H";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(5, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter9() throws IOException {

        /*
                B
                |
            A – C – E
                |
                D
         */

        String graph =  "A - C\n" +
                "B - C\n" +
                "C - D\n" +
                "C - E";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(2, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter10() throws IOException {

        /*

                B
                |
            A – C – E
                |   |
                D – F
         */

        String graph =  "A - C\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "C - E\n" +
                        "D - F\n" +
                        "E - F";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(3, Runner.findDistance(testAdjMat));

    }

    @Test
    public void testDiameter11() throws IOException {

        /*

                B
                |
            A – C   E
                    |
                D – F
         */

        String graph =  "A - C\n" +
                        "B - C\n" +
                        "D - F\n" +
                        "E - F";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(Integer.MAX_VALUE, Runner.findDistance(testAdjMat));
    }

    @Test
    public void testDiameter12() throws IOException {

        /*
            A     B
         (Note, these vertexes are disjoint)
         */

        String graph =  "A - A\n" +
                        "B - B";


        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(Integer.MAX_VALUE, Runner.findDistance(testAdjMat));
    }


    @Test
    public void testDiameter13() throws IOException {

        /*
            F – E

        A          D
          \       /
            B – C
        (Note, F – E is disjoint)
         */

        String graph =
                        "A - B\n" +
                        "B - C\n" +
                        "C - D\n" +
                        "F - E\n";

        Files.write(testFile.toPath(), graph.getBytes());
        boolean[][] testAdjMat = Runner.parseAdjMat(testFile.toPath().toString());

        assertEquals(Integer.MAX_VALUE, Runner.findDistance(testAdjMat));

    }
}
