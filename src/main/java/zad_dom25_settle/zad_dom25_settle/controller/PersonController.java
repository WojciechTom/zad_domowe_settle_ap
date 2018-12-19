package zad_dom25_settle.zad_dom25_settle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zad_dom25_settle.zad_dom25_settle.model.Person;
import zad_dom25_settle.zad_dom25_settle.repository.ExpenditureRepository;
import zad_dom25_settle.zad_dom25_settle.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PersonController {

    PersonRepository personRepository;
    ExpenditureRepository expenditureRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, ExpenditureRepository expenditureRepository) {
        this.personRepository = personRepository;
        this.expenditureRepository = expenditureRepository;
    }

    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("lista", personRepository.showAll());
        return "index";
    }

    @GetMapping("/addPer")
    public String addPerson(Model model){
        model.addAttribute("nowa", new Person());
        return "addPerson";
    }

    @PostMapping("/savePer")
    public String savePerson(Person nowa){
        Person savePerson = personRepository.save(nowa);
        return "redirect:/";
    }


    @GetMapping("/delPerson")
    @Transactional
    public String del(@RequestParam Long id){

        if(expenditureRepository.countExpenditure() == 0) {
            System.out.println(id);
            personRepository.deleteById(id);

            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }


}
