public class RandomizedSet {

    private final Random random;
    private final Map<Integer, Integer> valueToIndex;
    private final List<Integer> values;

    public RandomizedSet() {
        random = new Random();
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!valueToIndex.containsKey(val)) {
            valueToIndex.put(val, values.size());
            values.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (valueToIndex.containsKey(val)) {
            int indexToRemove = valueToIndex.get(val);
            int lastIndex = values.size() - 1;
            int lastValue = values.get(lastIndex);

            // Swap the value to remove with the last value in the list
            values.set(indexToRemove, lastValue);
            valueToIndex.put(lastValue, indexToRemove);

            // Remove the last element
            values.remove(lastIndex);
            valueToIndex.remove(val);

            return true;
        }
        return false;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
