package se.snorbu.hazelcastdemo.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import se.snorbu.hazelcastdemo.domain.repository.HitCounterRepository;
import se.snorbu.hazelcastdemo.sessionstarter.config.ApplicationHazelcastMap;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class HazelcastHitCounterRepository implements HitCounterRepository {

    private ApplicationHazelcastMap<String, Integer> hazelcastMap;

    public int getHits() {
        return Optional.ofNullable(hazelcastMap.get()).orElse(0);
    }

    public void setHits(int hits) {
        log.info("Setting hits to: {}", hits);
        hazelcastMap.set(hits);
    }
}
