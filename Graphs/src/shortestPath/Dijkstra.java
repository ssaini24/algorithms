package shortestPath;

public class Dijkstra {
    public final int V = 9;
    public final int src = 0;

    private int minDistance(int[] dist, Boolean[] isVisited){
        int minDist = Integer.MAX_VALUE;
        int minNode = -1;

        for(int i = 0; i < V; i++){
            if (isVisited[i] == false && dist[i] != Integer.MAX_VALUE
                    && dist[i] < minDist){
                minNode = i;
                minDist = dist[i];
            }
        }

        return minNode;
    }

    private void shortestPath(int[][] graph){
        int[] distance = new int[V];
        Boolean[] isVisited = new Boolean[V];

        for(int i = 0; i < V; i++){
            isVisited[i] = false;
            if (i == src){
                distance[i] = 0;
                continue;
            }

            distance[i] = Integer.MAX_VALUE;
        }

        int v = 0;
        while(v < V-1){
            int minNode = minDistance(distance, isVisited);
            isVisited[minNode] = true;

            for (int i = 0; i < V; i++){
                if (graph[minNode][i] != 0
                        && distance[minNode] + graph[minNode][i] < distance[i]){
                    distance[i] = distance[minNode] + graph[minNode][i];
                }
            }
            v++;
        }

        printSolution(distance);
    }

    public void dijkstra(){
        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        shortestPath(graph);
    }

    void printSolution(int dist[])
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
