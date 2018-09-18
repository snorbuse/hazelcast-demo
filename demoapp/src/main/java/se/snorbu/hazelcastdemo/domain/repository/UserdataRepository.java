package se.snorbu.hazelcastdemo.domain.repository;

public interface UserdataRepository {
    void save(Class clazz, Object object);

    <T> T get(Class<T> clazz);
}
