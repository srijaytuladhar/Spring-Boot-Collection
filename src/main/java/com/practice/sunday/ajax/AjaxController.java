package com.practice.sunday.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax/view")
    public String viewStudents() {
        return "ajaxView";
    }

    // for CORS
    @RequestMapping(value = "/ajax/cors")
    public String viewCors() {
        return "ajaxCORS";
    }

}
