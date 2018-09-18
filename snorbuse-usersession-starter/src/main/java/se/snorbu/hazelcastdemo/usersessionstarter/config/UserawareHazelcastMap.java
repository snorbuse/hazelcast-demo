package se.snorbu.hazelcastdemo.usersessionstarter.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@SessionScope
@Slf4j
public class UserawareHazelcastMap<K, V> /*implements HazelcastMap<Map<K, V>> */ {

    private HttpSession httpSession;
    private HazelcastInstance hazelcastInstance;

    public void put(K key, V value) {
        hazelcastInstance.getMap(getId()).put(key, value);
    }

    public V get(K key) {
        IMap<K, V> map = hazelcastInstance.getMap(getId());
        return map.get(key);
    }

    private String getId() {
        return httpSession.getId();
    }
}
