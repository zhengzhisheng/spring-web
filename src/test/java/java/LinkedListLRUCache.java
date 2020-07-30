//package java;
//
//import com.google.common.base.Preconditions;
//import com.google.common.collect.Maps;
//import sun.misc.LRUCache;
//
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * @author zs
// * @date 2020/5/29 2:20 下午
// */
//public class LinkedListLRUCache<K, V> implements LRUCache<K, V> {
//
//    private final int limit;
//    private final LinkedList<K> keys = new LinkedList<>();
//    private final Map<K, V> cache = Maps.newHashMap();
//
//    public LinkedListLRUCache(int limit) {
//        this.limit = limit;
//    }
//
//    @Override
//    public void put(K key, V value) {
//        Preconditions.checkNotNull(key);
//        Preconditions.checkNotNull(value);
//        if (keys.size() >= limit) {
//            K oldesKey = keys.removeFirst();
//            cache.remove(oldesKey);
//        }
//
//        keys.addLast(key);
//        cache.put(key, value);
//    }
//
//    @Override
//    public V get(K key) {
//        boolean exist = keys.remove(key);
//        if (!exist) {
//            return null;
//        }
//
//        keys.addLast(key);
//        return cache.get(key);
//    }
//
//    @Override
//    public void remove(K key) {
//
//        boolean exist = keys.remove(key);
//        if (exist) {
//            keys.remove(key);
//            cache.remove(key);
//        }
//    }
//
//    @Override
//    public int size() {
//        return keys.size();
//    }
//
//    @Override
//    public void clear() {
//        keys.clear();
//        cache.clear();
//    }
//
//    @Override
//    public int limit() {
//        return this.limit;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        for (K key : keys) {
//            builder.append(key).append("=").append(cache.get(key)).append(";");
//        }
//        return builder.toString();
//    }
//}
