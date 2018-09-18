package se.snorbu.hazelcastdemo.domain.repository;

public interface HitCounterRepository {

    int getHits();

    void setHits(int hits);

}
