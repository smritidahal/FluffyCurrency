
package com.FluffyCurrency.Project5.controllers;

import com.osarhan.program4.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private DataLoader dataLoader;

    @RequestMapping
    public RedirectView doLoad(@RequestParam("url") String url, RedirectAttributes attributes) {

        //Logic goes
        boolean statusS3 = dataLoader.loadDataToS3(url);

        boolean statusDB = dataLoader.loadDataToDB(url);


        attributes.addAttribute("successS3", statusS3);
        attributes.addAttribute("successDB", statusDB);

        attributes.addAttribute("isLoadData", true);


        return new RedirectView("/");

    }



}
