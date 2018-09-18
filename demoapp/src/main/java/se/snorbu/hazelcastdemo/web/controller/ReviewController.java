package se.snorbu.hazelcastdemo.web.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.snorbu.hazelcastdemo.domain.model.Person;
import se.snorbu.hazelcastdemo.domain.service.PersistenceService;
import se.snorbu.hazelcastdemo.web.form.PersonForm;

@Controller
@Slf4j
@AllArgsConstructor
public class ReviewController {

    private PersistenceService persistenceService;

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String get(Model model) {
        // Fetch data from Hazelcast
        Person person = persistenceService.getPerson();
        log.info("PersistenceService data: " + person);

        // Create a web object
        PersonForm personForm = PersonForm.of(person);
        model.addAttribute("person", personForm);

        // Return the current view
        return "review";
    }
}

