package Laba5_HashMap.Laba5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImplementation<V> implements HashMap<String, V> {
    private static class Pair<T> {
        public String key;
        public T value;

        Pair(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;
    List<List<Pair<V>>> array;

    public HashMapImplementation() {
        array = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            array.add(new LinkedList<>());
        }
    }

    /**
     * Алгоритм хеширования строк.
     *
     * @param value ключ, по которому сохранится значение в хэш-таблицу
     * @return значение хэша
     */
    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }


    @Override
    public void put(String key, V value) {
        List<Pair<V>> bucket = array.get((int) hashByString(key));

        for (Pair<V> i : bucket) {
            if (i.key.equals(key)) {
                i.value = value;
                return;
            }
        }
        bucket.add(new Pair<V>(key, value));
    }

    @Override
    public V getValue(String key) {
        for (Pair<V> i : array.get((int) hashByString(key))) {
            if (i.key.equals(key)) {
                return i.value;
            }
        }
        return null;
    }

    @Override
    public V delete(String key) {
        List<Pair<V>> bucket = array.get((int) hashByString(key));
        V result = null;

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                result = bucket.get(i).value;
                bucket.remove(i);
                break;
            }
        }
        return result;
    }
}
