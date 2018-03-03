
package com.FluffyCurrency.Project5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/load")
public class LoadController {


    @RequestMapping
    public RedirectView doLoad(@RequestParam("url") String url, RedirectAttributes attributes) {

        //Logic goes

        attributes.addAttribute("successS3", true);
        attributes.addAttribute("successDB", true);

        attributes.addAttribute("isLoadData", true);


        return new RedirectView("/");

    }


}
