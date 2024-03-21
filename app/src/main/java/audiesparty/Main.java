package audiesparty;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        FileInput.load(connections);

        UnionFind uf = new UnionFind();
        for (Connection connection : connections) {
            uf.createSet(connection.node1);
            uf.createSet(connection.node2);
        }

        Scanner scanner = new Scanner(System.in);
        int threshold = scanner.nextInt();

        List<Connection> selectedConnections = new ArrayList<>();
        for (Connection connection : connections) {
            if (connection.strength > threshold) {
                String leaderNode1 = uf.getSet(connection.node1);
                String leaderNode2 = uf.getSet(connection.node2);
                if (!leaderNode1.equals(leaderNode2)) {
                    uf.mergeSets(leaderNode1, leaderNode2);
                    selectedConnections.add(connection);
                }
            }
        }

        Cluster cluster = new Cluster(uf, selectedConnections);
        Map<String, Set<String>> clusters = cluster.formCluster();
        cluster.displayCluster(clusters);
        cluster.identifyStrongestAndWeakestCluster(selectedConnections, clusters);

        int count = scanner.nextInt();
        scanner.close();

        Collections.sort(selectedConnections, Comparator.comparingInt(connection -> connection.strength));

        if (count - 1 > selectedConnections.size()) {
            System.out.println("It is not possible");
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            selectedConnections.remove(i);
        }

        uf = new UnionFind();
        for (Connection connection : selectedConnections) {
            uf.createSet(connection.node1);
            uf.createSet(connection.node2);
        }

        for (Connection connection : selectedConnections) {
            String leaderNode1 = uf.getSet(connection.node1);
            String leaderNode2 = uf.getSet(connection.node2);
            if (!leaderNode1.equals(leaderNode2)) {
                uf.mergeSets(leaderNode1, leaderNode2);
            }
        }

        clusters = cluster.formCluster();

        cluster.displayCluster(clusters);

        cluster.identifyStrongestAndWeakestCluster(selectedConnections, clusters);
    }
}
