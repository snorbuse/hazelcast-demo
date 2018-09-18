package se.snorbu.hazelcastdemo.web.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.snorbu.hazelcastdemo.domain.model.Person;
import se.snorbu.hazelcastdemo.domain.service.PersistenceService;
import se.snorbu.hazelcastdemo.impl.HazelcastHitCounterRepository;
import se.snorbu.hazelcastdemo.web.form.PersonForm;

@Controller
@Slf4j
@AllArgsConstructor
public class IndexController {

    private PersistenceService persistenceService;
    private HazelcastHitCounterRepository globalDataRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {

        int hits = globalDataRepository.getHits();
        log.info("Current number of hits: " + hits);
        globalDataRepository.setHits(++hits);

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String post(@ModelAttribute("personForm") PersonForm personForm, BindingResult bindingResult) {
        log.info("Postdata: " + personForm);

        Person person = Person.of(personForm.getFirstName(), personForm.getLastName());
        persistenceService.savePerson(person);

        return "redirect:/review";
    }

    @ModelAttribute
    public PersonForm getHomeForm() {
        return new PersonForm();
    }
}
