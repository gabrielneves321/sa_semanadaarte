package br.com.sa.controller;

import br.com.sa.model.Funcionario;
import br.com.sa.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioServiceImpl funcionarioService;


    @GetMapping("/funcionario/list")
    public String list(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "/funcionario/list";

    }


    @GetMapping("/funcionario/add")
    public String add(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";

    }

    @PostMapping("/funcionario/save")
    public String save(Funcionario funcionario, Model model) {
        String path;
        if (funcionario.getId() == null){ path = "funcionario/add"; }
        else { path = "funcionario/edit";}


        if (funcionarioService.save(funcionario)){
            return "redirect:/funcionario/list";
        } else {
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("erroMsg", "Erro ao salvar o Funcionário.");
            return path;

        }
    }

    @GetMapping("/funcionario/edit/{id}")
    public String edit(@PathVariable long id, Model model ){
        model.addAttribute("funcionario", funcionarioService.findById(id));

        return "funcionario/edit";
    }

    @GetMapping("/funcionario/delete/{id}")
    public String delete(@PathVariable long id){

        if (funcionarioService.delete(id)){
            return "redirect:/funcionario/list";
        } else {
            //TODO: tratar esse erro
            return "redirect:/funcionario/list";
        }
    }
}

