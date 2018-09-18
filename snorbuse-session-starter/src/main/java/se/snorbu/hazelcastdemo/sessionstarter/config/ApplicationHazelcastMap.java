package se.snorbu.hazelcastdemo.sessionstarter.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationHazelcastMap<K, V> {

    private K key;
    private HazelcastInstance hazelcastInstance;

    public V get() {
        IMap<K, V> map = hazelcastInstance.getMap("application");
        return map.get(key);
    }

    public void set(V value) {
        hazelcastInstance.getMap("application").put(key, value);
    }
}
