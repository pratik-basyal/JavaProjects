import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
/*******
 * This Undirected Graph will help in understanding the graphing more
 * Here 0,1,2,and 3 are vertexes of the graph
 *          edge
 *      0-------- 1
 *      |         |       4
 * edge |         |edge /
 *      |         |   /
 *      3-------- 2 /
 *         edge
 * We will represent this undirected form of graph with the help of Linked_List
 */
public class Data_Structures_Graph_List_Form
{
    private LinkedList<Integer>[] adjacent_list;
    int V, E; // vertices and Edges

    public Data_Structures_Graph_List_Form(int nodes)
    {
        this.V = nodes;
        this.E = 0;
        adjacent_list = new LinkedList[nodes];
        for(int i = 0; i < nodes; i++)
        {
            adjacent_list[i] = new LinkedList<>();
        }
    }

    public void add_Edge(int vertex, int vertex1)
    {
        adjacent_list[vertex].add(vertex1);
        adjacent_list[vertex1].add(vertex);
        E++;
    }

    /********
     * This method will simply print the graph according to its edges
     * @return
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(V).append(" Vertices ").append(E).append(" Edges \n");
        for(int i = 0; i < V; i++)
        {
            str.append(i).append(" : ");
            for(int each : adjacent_list[i])
            {
                str.append(each).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    /*******
     * This method is the Breadth First Search (BFS) Traversal
     * In this method we will traverse the graph according to its level
     * *         edge
     *  *      0-------- 1
     *  *      |         |       4
     *  * edge |         |edge /
     *  *      |         |   /
     *  *      3-------- 2 /
     *  *         edge
     *  for this graph we will visit 0 first and its adjacent edges and so on
     * @param node
     */
    public void bfs_traversal(int node)
    {
        boolean[] found = new boolean[V]; // this will check if the nodes are already visited or not
        Queue<Integer> store = new LinkedList<>();
        store.offer(node);
        found[node] = true;

        while(!store.isEmpty())
        {
            int data = store.poll();
            System.out.print(data + " ");

            for(int adj_node : adjacent_list[data])
            {
                if(!found[adj_node])
                {
                    found[adj_node] = true;
                    store.offer(adj_node);
                }
            }
        }
    }

    /***********
     * This method is the Depth First Search (DFS) algorithm
     * In this algorithm we traverse as far as the edge of node goes before backtracking
     * So In this graph we have to traverse 0 - 3 - 2 - 4 - 1 OR 0 - 1 - 2 - 4 - 3
     * Both of the traversals are correct since this is the undirected graph
     *         edge
     *      0-------- 1
     *      |         |       4
     * edge |         |edge /
     *      |         |   /
     *      3-------- 2 /
     *         edge
     */
    public void DFS_traversal(int node)
    {
        // boolean array size of the number of vertices in the graph
        boolean[] found = new boolean[V]; // keeps track of the nodes we visited in the graph
        Stack<Integer> store = new Stack<>();
        store.push(node);
        found[node] = true;

        while(!store.isEmpty())
        {
            int data = store.pop();
            System.out.print(data + " ");

            for(int adjacent_node : adjacent_list[data])
            {
                if(!found[adjacent_node])
                {
                    found[adjacent_node] = true;
                    store.push(adjacent_node);
                }
            }
        }
    }

    /**********
     * This method is just to check if every nodes in the graph are visited or not
     * So sometimes there
     *         edge
     *      0-------- 1
     *      |         |       4
     * edge |         |edge /
     *      |         |   /
     *      3-------- 2 /       5
     *         edge
     * In this graph, 5 is not connected to any of the vertex and has no edge
     * So we will need to check if this has already printed or not
     * From the above method we will be able to traverse only with vertices that have edge
     * From this we should be able to print vertices that don't have an edge as well
     */
    public void recursive_DFS_traversal()
    {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                recursive_DFS_traversal(i, visited);
            }
        }
    }

    /*********
     * This is the same DFS traversal but just in a recursive way
     * @param node
     * @param visited
     */
    public void recursive_DFS_traversal(int node, boolean[] visited)
    {
        visited[node] = true;
        System.out.print(node + " ");

        for(int adjacent_node : adjacent_list[node])
        {
            if(!visited[adjacent_node])
            {
                recursive_DFS_traversal(adjacent_node, visited);
            }
        }
    }

    public static void main(String[] args) {
        Data_Structures_Graph_List_Form graph = new Data_Structures_Graph_List_Form(5);

        graph.add_Edge(0, 1);
        graph.add_Edge(1, 2);
        graph.add_Edge(2, 3);
        graph.add_Edge(3, 0);
        graph.add_Edge(2,4);

        System.out.println(graph);

        graph.bfs_traversal(0);
        System.out.println();
        graph.DFS_traversal(0);
        System.out.println();
        graph.recursive_DFS_traversal();
    }
}
