package audiesparty;

import java.util.*;

public class UnionFind {
    Map<String, String> leader = new HashMap<>();

    public void createSet(String element) {
        leader.put(element, element);
    }

    public String getSet(String element) {
        String leaderElement = leader.get(element);
        if (leaderElement.equals(element)) {
            return element;
        }
        return getSet(leaderElement);
    }

    public void mergeSets(String element1, String element2) {
        String leader1 = getSet(element1);
        String leader2 = getSet(element2);
        leader.put(leader1, leader2);
    }
}
