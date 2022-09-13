package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/home")
    public String list(Model model) {
        List<Institution> all = institutionRepository.findAll();
        model.addAttribute("institutions", all);
        return "index";
    }

    @GetMapping("/institution-add")
    public String foundationAdd(Model model) {
        model.addAttribute("institution", new Institution());
        return "adm/institution-add";
    }

    @PostMapping("/institution-add")
    public String institutionRegister(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "adm/institution-add";
        }
        institutionRepository.save(institution);
        return "redirect:/";
    }

    @GetMapping("institution-edit")
    public String institutionEdit(Model model) {
        //model.addAttribute("")
        return "adm/institution-edit";
    }
    @GetMapping("/institution")
    public String institutionUp(Model model,@RequestParam String n){
        List<Institution> institutionList = institutionRepository.findByNameIsStartingWithOrderById(n);
        model.addAttribute("institutionList",institutionList);
        return "adm/institution-update";
    }
    @GetMapping("institution/edit/${i.id}")
    public String institutionSave(Model model,@PathVariable long id){
        model.addAttribute("institut",institutionRepository.findById(id));
        return "adm/institution-update";
    }


}
