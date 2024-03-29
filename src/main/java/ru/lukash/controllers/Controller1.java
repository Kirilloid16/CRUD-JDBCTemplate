package ru.lukash.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.lukash.DAO.Peopledao;
import ru.lukash.model.Person;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class Controller1 {
    private final Peopledao peopledao;


    public Controller1( Peopledao peopledao) {
        this.peopledao = peopledao;
    }

    @GetMapping
    public String AllPeople(Model model){
        model.addAttribute("people",peopledao.AllPeople());
        return "people/allpeople";
    }
    @GetMapping("/{id}")
    public String ShowPerson(@PathVariable("id")int id,Model model){
        model.addAttribute("person",peopledao.ShowPerson(id));
        return "people/showpeople";
    }
    @GetMapping("/new")
    public String NewPeople(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }
    @PostMapping
    public String Create(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/new";
        peopledao.save(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id){
        model.addAttribute("person",peopledao.ShowPerson(id));
                return"people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@PathVariable("id")int id,@ModelAttribute("person")@Valid Person person,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/edit";
        peopledao.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        peopledao.delete(id);
        return "redirect:/people";
    }
}
