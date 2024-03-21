package audiesparty;

import java.util.*;

public class Cluster {
    UnionFind uf;
    List<Connection> connections;

    public Cluster(UnionFind uf, List<Connection> connections) {
        this.uf = uf;
        this.connections = connections;
    }

    public Map<String, Set<String>> formCluster() {
      Map<String, Set<String>> clusterMap = new HashMap<>();
      for (Connection connection : connections) {
        String parentU = uf.getSet(connection.node1);
        clusterMap.computeIfAbsent(parentU, k -> new HashSet<>()).add(connection.node1);
        clusterMap.get(parentU).add(connection.node2);
      }
      return clusterMap;
    }

    public void displayCluster(Map<String, Set<String>> clusters) {
        for (Set<String> cluster : clusters.values()) {
            for (String node : cluster) {
                System.out.print(node + " ");
            }
            System.out.println("");
        }
    }

    public void identifyStrongestAndWeakestCluster(List<Connection> connections, Map<String, Set<String>> clusters) {
        Connection strongestConnection = Collections.max(connections, Comparator.comparingInt(connection -> connection.strength));
        Connection weakestConnection = Collections.min(connections, Comparator.comparingInt(connection -> connection.strength));
        System.out.print("Cluster with strongest friendly relationship: ");
        displayCluster(clusters, strongestConnection.node1);
        System.out.print("Cluster with weakest friendly relationship: ");
        displayCluster(clusters, weakestConnection.node1);
    }

    private void displayCluster(Map<String, Set<String>> clusters, String connection) {
        Set<String> cluster = clusters.get(uf.getSet(connection));
        for (String node : cluster) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
