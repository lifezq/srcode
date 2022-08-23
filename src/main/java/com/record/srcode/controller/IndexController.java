package com.record.srcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Hashtable;

/**
 * @Package com.record.srcode.controller
 * @ClassName IndexController
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/21
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        Hashtable<String, String> vars = new Hashtable<>();
        vars.put("title", "test index page");
        vars.put("name", "test name");
        model.addAllAttributes(vars);
        return "index";
    }
}
