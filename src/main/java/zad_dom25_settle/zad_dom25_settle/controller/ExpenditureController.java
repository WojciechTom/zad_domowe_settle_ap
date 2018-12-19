package zad_dom25_settle.zad_dom25_settle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zad_dom25_settle.zad_dom25_settle.model.CashFlow;
import zad_dom25_settle.zad_dom25_settle.model.CurrencyEnum;
import zad_dom25_settle.zad_dom25_settle.model.Expenditure;
import zad_dom25_settle.zad_dom25_settle.model.Person;
import zad_dom25_settle.zad_dom25_settle.repository.CashFlowRepository;
import zad_dom25_settle.zad_dom25_settle.repository.ExpenditureRepository;
import zad_dom25_settle.zad_dom25_settle.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpenditureController {

    ExpenditureRepository expenditureRepository;
    PersonRepository personRepository;
    CashFlowRepository cashFlowRepository;
    Long idWyd;

    @Autowired
    public ExpenditureController(ExpenditureRepository expenditureRepository, PersonRepository personRepository, CashFlowRepository cashFlowRepository) {
        this.expenditureRepository = expenditureRepository;
        this.personRepository = personRepository;
        this.cashFlowRepository = cashFlowRepository;
    }

    @GetMapping("/exp")
    public String showAllExp(Model model){
        model.addAttribute("wydatki",  expenditureRepository.showAll());
        model.addAttribute("total" , expenditureRepository.total());
        return"expenditures";
    }

    @GetMapping("/expAsc")
    public String showAllExpAsc(Model model){
        model.addAttribute("wydatki",  expenditureRepository.showAllAsc());
        model.addAttribute("total" , expenditureRepository.total());
        return"expenditures";
    }



    @GetMapping("/expDesc")
    public String showAllExpDesc(Model model){
        model.addAttribute("wydatki",  expenditureRepository.showAllDesc());
        model.addAttribute("total" , expenditureRepository.total());
        return"expenditures";
    }


    @GetMapping("/expFiltr")
    public String showAllExpFiltr(
            @RequestParam double valueA,
            @RequestParam double valueB,
            Model model){
        model.addAttribute("wydatki",  expenditureRepository.showAllFiltr(valueA, valueB));
        model.addAttribute("total" , expenditureRepository.total());
        return"expenditures";
    }


    @GetMapping("/addExp")
    public String addPerson(Model model){
        model.addAttribute("wydatek", new Expenditure());
        model.addAttribute("listaOsob", personRepository.showAll() );
        model.addAttribute("waluty", CurrencyEnum.values());
        return "addExpenditure";
    }

    @PostMapping("/saveExp")
    public String saveExpenditure(Expenditure wydatek){
        System.out.println(wydatek.getSplitBetweenId() + " wydatek rezultat");
        wydatek = expenditureRepository.save(wydatek);
        List<CashFlow> lista = ExpenditureRepository.splitExpToCashFlow(wydatek);
        for(CashFlow cf : lista){
            cashFlowRepository.save(cf);
        }
        personRepository.increaseAmountToExpJpql(String.valueOf(wydatek.getPayById()));
        return "redirect:/exp";
    }

    @PostMapping("/saveChngExp")
    public String saveChangesInExp(Expenditure wyd){
        expenditureRepository.deleteById(idWyd);
        cashFlowRepository.deleteByExpID(idWyd);
        saveExpenditure(wyd);
        return "redirect:/exp";
    }


    @GetMapping("/del")
    @Transactional
    public String del(@RequestParam Long id){
        personRepository.decreaseAmountToExpJpql(expenditureRepository.findPersonIdByExpenditureId(id));
        expenditureRepository.deleteById(id);
        cashFlowRepository.deleteByExpID(id);
        return "redirect:/exp";
    }

    @GetMapping("/showExpenditure")
    public String showExpenditure(@RequestParam Long id,  Model model){
        model.addAttribute("waluty", CurrencyEnum.values());
        model.addAttribute("listaOsob", personRepository.showAll() );
        model.addAttribute("zaznaczone", stingToUserList(expenditureRepository.showExpenditure(id).getSplitBetweenId()));
        model.addAttribute("wyd",  expenditureRepository.showExpenditure(id));
        idWyd = id;
        return"expenditure";
    }



    public List<Person> stingToUserList(String split){
        String[] idOsob = split.split(",");
        List<Person> lista = new ArrayList<Person>();


        for(int i = 0 ; i < idOsob.length ; i++){
            Long id = Long.parseLong(idOsob[i]);
            Person p = new Person();
            lista.add(personRepository.showPerson(id));
        }
        return lista;
    }


}
