import java.util.*;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Demo1 {

    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        // Sort by value/weight ratio descending
        Arrays.sort(items, (a, b) -> {
            return Double.compare((double) b.value / b.weight,
                    (double) a.value / a.weight);
        });
        double totalValue = 0;
        for (Item item : items) {
            // Take full item
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            }
            // Take fractional item
            else {
                totalValue += ((double) item.value / item.weight) * capacity;
                break;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;
        double ans = fractionalKnapsack(values, weights, capacity);
        System.out.println(ans);
    }
}