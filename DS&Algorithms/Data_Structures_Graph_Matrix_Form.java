/***********
 * Graph is a non-linear data-structures to store the data
 * It is a set of vertices and collection of edges that connects a pari of vertices
 *
 * Applications :
 * 1 ---> Social Network
 * Graph helps us implement the social networking sites such as Facebook, Twitter, etc
 * This also can be called as a social networking graph
 * Names of people represents veertices of the graph
 * Friendship between them can be represented as an edge of the graph
 *
 * 2 -----> Web Content over the internet
 * Graph helps us organize the web content over the internet
 * A link between two web-pages can be represented as an edge of the graph
 */


/*******
 * This Undirected Graph will help in understanding the graphing more
 * Here 0,1,2,and 3 are vertexes of the graph
 *          edge
 *      0-------- 1
 *      |         |
 * edge |         |edge
 *      |         |
 *      3-------- 2
 *         edge
 * We will represent this undirected form of graph in the form of matrix
 */
public class Data_Structures_Graph_Matrix_Form
{
    private int V; // this represents the number of vertices in Graph
    private int E; // this represents the number of edges in the Graph
    // representing the graph with the help of matrix
    int[][] adjacent_matrix;

    // number of vertex we have is the number of nodes
    public Data_Structures_Graph_Matrix_Form(int nodes)
    {
        this.V = nodes;
        this.E = 0;
        this.adjacent_matrix = new int[nodes][nodes];
    }

    /*****
     * This method will simply add the edge in the graph
     * By representing the edge in the form of matrix
     * @param vertex
     * @param vertex1
     */
    public void add_edge(int vertex, int vertex1)
    {
        adjacent_matrix[vertex][vertex1] = 1;
        adjacent_matrix[vertex1][vertex] = 1;
        E++; // after the addition of the edge we will increase the Edge
    }

    /*******
     * This method simply represents the graph in a matrix form
     * @return
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append(V + " vertex " + E + " edges \n");
        for (int v = 0; v < V; v++)
        {
            str.append(v + " : ");
            for(int w : adjacent_matrix[v])
            {
                str.append(w + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Data_Structures_Graph_Matrix_Form graph = new Data_Structures_Graph_Matrix_Form(4);
        graph.add_edge(0, 1);
        graph.add_edge(1, 2);
        graph.add_edge(2, 3);
        graph.add_edge(3, 0);

        System.out.println(graph);
    }
}
