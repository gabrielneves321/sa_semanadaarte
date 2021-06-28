package br.com.sa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/artigos")
    public String getArtigos() {
        return "artigos";
    }

    @GetMapping("/proposta")
    public String getProposta() {
        return "proposta";
    }
}
