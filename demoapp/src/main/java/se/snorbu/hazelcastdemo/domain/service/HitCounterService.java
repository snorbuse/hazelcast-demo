package se.snorbu.hazelcastdemo.domain.service;

import org.springframework.stereotype.Component;
import se.snorbu.hazelcastdemo.domain.repository.HitCounterRepository;

@Component
public class HitCounterService {

    private HitCounterRepository hitRepository;

    public int getHits() {
        return hitRepository.getHits();
    }

    public void setHits(int newHits) {
        hitRepository.setHits(newHits);
    }
}
