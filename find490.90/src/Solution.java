import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Double>> worker(List<Double> inputData) {
        // make amout
        List<List<Double>> result = new ArrayList<>();
        Map<Double, List<Double>> hashmap = new HashMap<>();
        for (int i = 0; i < inputData.size(); i++) {
            for (int j = i + 1; j <inputData.size(); j++) {
                double a = inputData.get(i);
                double b = inputData.get(j);
                List<Double> path = new ArrayList<>();
                path.add(a);
                path.add(b);
                double c = a + b;
                hashmap.put(c, path);
            }
        }
        for (Map.Entry<Double, List<Double>> entry : hashmap.entrySet()) {
            double first = entry.getKey();
            double next = first + 490.9;
            if (hashmap.get(next) != null) {
                List<Double> dir = new ArrayList<>();
                dir.addAll(hashmap.get(next));
                dir.addAll(entry.getValue());
                result.add(dir);
            }
        }
        return result;
    }
}
