
package com.FluffyCurrency.Project5.controllers;

import com.osarhan.program4.Person;
import com.osarhan.program4.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FormController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String mainPage(final Model model){

        model.addAttribute("search", false);
        return "index";
    }

    @PostMapping("/")
    public String processPost(@RequestParam("first") String firstName, @RequestParam(name="last",required = false) String lastName, final Model model){

        List<Person> people = personService.searchPeople(firstName, lastName);

        model.addAttribute("search", true);
        model.addAttribute("people", people);
        return "index";
    }
}
