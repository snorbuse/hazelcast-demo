package se.snorbu.hazelcastdemo.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import se.snorbu.hazelcastdemo.domain.model.Person;
import se.snorbu.hazelcastdemo.domain.repository.UserdataRepository;

@Component
@AllArgsConstructor
public class PersistenceService {

    private UserdataRepository userdataRepository;

    public void savePerson(Person person) {
        userdataRepository.save(Person.class, person);
    }

    public Person getPerson() {
        return userdataRepository.get(Person.class);
    }
}
