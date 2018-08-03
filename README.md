# GraphDiameter

## 1) Building and Running
### Building from command line:
 For building the source files manually, compile the Runner class and pass input arguments upon execution.
 Ex:
  > javac Runner.java  
  > java Runner /path/to/input1 /path/to/input2
  
 *Note: multiple input files can be passed in as parameters*
 
  The project is also configured with Maven, and can be built accordingly with the following command at the root directory
  > mvn install
  
  **Please use JDK 8 or above.**
 
 ### Input file syntax:
  The input files should contain a graph definition that depits an edge of the graph on each line. The form for each line should be as follows: 
  Vertex - Vertex
  
  Ex:  
A – B  
B – C  
C – D  
D – E  

*Note: The delimiter between vertices can be either a dash or hyphen, and vertex names can be any sequence of characters without spaces.*

## 2) Algorithm
### Reading Input and Parsing:  
The inputs are streamed line by line, and are added to an ArrayList that contains all edges, and HashMap that maps Vertex names to integer indexes for the adjacency matrix. The use of these data structures is to avoid unncessary resizing of the adjacency matrix as the input file is streamed (since there aren't assumptions about graph metadata before parsing such as number of vertexes or edges). The amortized time complexity, however, is still O(N).

All of this functionality is defined in the *parseAdjMat* method.

### Floyd-Warshall Algorithm
The Floyd-Warshall Algorithm finds the shortest distances from each vertex to every other vertex with the use of dynamic programming. In general, it applies to weighted and directed graphs. However, an undirected and unweighted graph can also be translated such that the algorithm still holds valid.

The diameter is then calculated as the maximum of all such distances found between vertexes. If there exists a disconnect in the graph, Integer.MAX_VALUE is output instead.

### Time and Space Complexity
The Floyd-Warshall Algorithm has a time complexity of O(V³) and a space complexity of O(V²). The time complexity is realized by the three nested for loops in the *findDistance* method. The bottleneck is primarily with the diameter computation. Both the time and space complexities of the adjacency matrix generations are well bounded by those of the diameter computation.

## 3) Testing
All tests can be executed through Maven, via the command:
> mvn test

All of the tests use the JUnit framework, which is included in the maven dependancies.

### Unit Testing for Parsing
Tests for parsing primarily include proper Regex handling, duplicate edge handling, invalid input handling, etc.
These can be found in *parsingTest.java*

### Unit Testing for Diameter Calculation
Tests for the diameter calculation include sequential graphs, grid-structured graphs, cyclic graphs, and disconnected graphs. These can be found in *diameterTest.java*
