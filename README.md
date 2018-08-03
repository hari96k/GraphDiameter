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
  
  Please use Java SDK 8 or above.
 
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

### Floyd-Warshall Algorithm

### Time and Space Complexity

## 3) Testing
### Unit Testing for Parsing
### Unit Testing for Distance Calculation
