package audiesparty;

public class Connection implements Comparable<Connection> {
    String node1;
    String node2;
    int strength;

    public Connection(String node1, String node2, int strength) {
        this.node1 = node1;
        this.node2 = node2;
        this.strength = strength;
    }

    @Override
    public int compareTo(Connection compareConnection) {
        return compareConnection.strength - this.strength;
    }
}
