package com.FluffyCurrency.Project5.controllers;

import com.FluffyCurrency.Project5.Nucleus;
import com.FluffyCurrency.Project5.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/add")
public class DeleteController {

    @Autowired
    private Nucleus nucleus;

    @RequestMapping
    public RedirectView delete(RedirectAttributes attributes) {

        String transNum = "";
        boolean results = nucleus.deleteTransactionFromUserAccount(transNum);

        attributes.addAttribute("deleteSuccess", results);

        return new RedirectView("/");
    }
}
