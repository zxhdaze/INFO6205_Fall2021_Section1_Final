import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
//        LinkedList<Integer> e = new LinkedList<>();
//        e.add(u);
//        e.add(v);
//
//        for (int i = 0; i < adj.length;i++){
//            if (adj[i].isEmpty()){
//                adj[i] = e;
//                return;
//            }
//        }
        adj[u].add(v);


    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:


        for (int i :adj[u]){
            if(visited.get(i) == false){
                size += DFS(i,adj,visited);
            }
        }


        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        int tree = 0;
        Vector<Boolean> visited = new Vector<>(V);
        for(int i = 0; i < V; i++){
            visited.add(false);
        }

        for (int i = 0; i < V;i++){
            if (visited.get(i) == false){
                int re = DFS(i,adj,visited);
                if(re>=tree){
                    tree = re;

                }


            }
        }




        return tree;
    }
    public static void main(String args[]){
        System.out.println("j");
        LargestTree tree = new LargestTree();
        int V = 5;
        LinkedList<Integer> adj[] = new LinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<>();
        tree.addEdge(adj, 0, 1);
        tree.addEdge(adj, 0, 2);
        tree.addEdge(adj, 3, 4);
        for (LinkedList l:adj){
            System.out.println(l);
        }
    }
}