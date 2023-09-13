import java.util.ArrayList;
import java.util.LinkedList;

public class Connected_Components_In_Undirected_Graphs
{
    private LinkedList<Integer>[] adjacent_list;
    private int V; // Vertices count
    private int E; // Edges Count
    private int count = 0; //this count will keep track of connected nodes

    int[] node_ID;  // keeps the track of which one's connected to which

    public Connected_Components_In_Undirected_Graphs(int nodes)
    {
        this.V = nodes;
        this.E  = 0;
        adjacent_list = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++)
        {
            adjacent_list[i] = new LinkedList<>();
        }
    }

    private void add_Edge(int vertex, int vertex1)
    {
        adjacent_list[vertex].add(vertex1);
        adjacent_list[vertex1].add(vertex);
        this.E++;
    }

    /*******
     * This Undirected Graph will help in understanding the graphing more
     * Here 0,1,2,3,4 and 5 are vertexes of the graph
     * 0,1,and 3 are connected. 2 and 4 are connected. 5 is alone
     *          edge
     *      0-------- 1
     *      |                 4
     * edge |               /
     *      |             /
     *      3         2 /           5
     *         edge
     * We will understand which one's connected to which with the following algorithm
     */
    public void dfs_traversal()
    {
        boolean[] visited = new boolean[V];// keeps the track of the visited node
        node_ID = new int[V]; // keeps track of the connections between the vertices

        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                dfs_traversal(node_ID, visited, i, count);
                count++;
            }
        }
    }

    public void dfs_traversal(int[] node_ID, boolean[] visited, int vertex, int count)
    {
        visited[vertex] = true;
        node_ID[vertex] = count;

        for(int adjacent_vertex : adjacent_list[vertex])
        {
            if(!visited[adjacent_vertex])
            {
                dfs_traversal(node_ID, visited, vertex, count);
            }
        }
    }

    /*******
     * After the algorithm, ones which has same ID will show that its connected with edges
     * And boolean array will just show us which one's visited and which are not
     * We will be creating methods for number of graphs that are connected and also check which ones
     */
    public int get_Count()
    {
        return count; // this is the number of connected graphs
    }

    public boolean get_connection(int vertex, int vertex1)
    {
        return node_ID[vertex] == node_ID[vertex1];
    }

    /*********
     * This is the problem where we need to find the number of islands.
     * Island is defined as the land which are covered by water
     * Here inside the matrix 1 represents the land and 0 represents the water
     * so
     * 1 1 0 0 0
     * 1 0 0 0 0
     * 0 0 0 1 0
     * 0 0 0 0 1
     * This is the pattern of the island
     * We can say that there are 3 islands
     * Because the first three are connected horizontally/vertically so
     * They are considered as a one island as a whole
     * @param matrix
     * @return
     */
    public int num_of_islands(int[][] matrix)
    {
        int count = 0; //keeps track of number of islands

        int m = matrix.length; // length of rows
        int n = matrix[0].length; // length of column
        boolean[][] visited = new boolean[m][n];

        //traversing through every node in the matrix
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!visited[i][j] && matrix[i][j] == 1)
                {
                    dfs_traversal_for_island(matrix, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**********
     * We will be using the similar concept of dfs traverse that we learnt earlier in Graph_List_Form
     * @param matrix
     * @param visited
     * @param row
     * @param column
     */
    public void dfs_traversal_for_island(int[][] matrix, boolean[][] visited, int row, int column)
    {
        // we will follow all these processes only if this method doesn't encounter any of these conditions
        if(row < 0 || row >= matrix.length || column < 0 ||
                column >= matrix[0].length || visited[row][column] || matrix[row][column] == 0)
        {
            return;
        } // this will be our base case

        visited[row][column] = true;
        // we check if there's any adjacent islands are connected to the island we visited

        //first we go left
        dfs_traversal_for_island(matrix, visited, row, column - 1); // when travelling left column gets decreased with one

        // now once we encounter water i.e. '0' we will go right
        dfs_traversal_for_island(matrix, visited, row, column + 1); // column increases when we go right

        // similarly once we encounter water we can go down
        dfs_traversal_for_island(matrix, visited, row + 1, column); // row increases while going down

        // finally all there's left is to go up
        dfs_traversal_for_island(matrix, visited, row - 1, column); // row decreases while going up
    }

    public static void main(String[] args) {
        Connected_Components_In_Undirected_Graphs my_graph = new Connected_Components_In_Undirected_Graphs(5);
        my_graph.add_Edge(0,1);
        my_graph.add_Edge(3,0);
        my_graph.add_Edge(2,4);

//        my_graph.dfs_traversal();

//        System.out.println(my_graph.get_Count());

        int[][] matrix = new int[][]
                {       {1, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 0, 0, 1}
                };
        
        System.out.println(my_graph.num_of_islands(matrix));
    }
}
