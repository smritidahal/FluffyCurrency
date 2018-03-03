
package com.FluffyCurrency.Project5.controllers;

import com.FluffyCurrency.Project5.Nucleus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {

    @Autowired
    private Nucleus nucleus;


    @GetMapping("/")
    public String mainPage(final Model model) {

        model.addAttribute("search", false);
        return "index";
    }

    @PostMapping("/")
    public String processPost(@RequestParam("CytpoID") String cryptoID,
                              @RequestParam("price") double price,
                              @RequestParam("amount") double amount,
                              final Model model) {


        nucleus.addTransactionToUserAccount(cryptoID, price, amount);


        model.addAttribute("search", true);
        return "index";
    }
}
