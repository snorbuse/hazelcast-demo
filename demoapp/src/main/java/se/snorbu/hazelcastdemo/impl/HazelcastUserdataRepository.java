package se.snorbu.hazelcastdemo.impl;

import lombok.AllArgsConstructor;
import se.snorbu.hazelcastdemo.domain.repository.UserdataRepository;
import se.snorbu.hazelcastdemo.usersessionstarter.config.UserawareHazelcastMap;

@AllArgsConstructor
public class HazelcastUserdataRepository implements UserdataRepository {

    private UserawareHazelcastMap<Class, Object> hazelcastMap;

    @Override
    public void save(Class clazz, Object object) {
        hazelcastMap.put(clazz, object);
    }

    @Override
    public Object get(Class clazz) {
        return hazelcastMap.get(clazz);
    }
}
