package zad_dom25_settle.zad_dom25_settle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zad_dom25_settle.zad_dom25_settle.repository.CashFlowRepository;
import zad_dom25_settle.zad_dom25_settle.repository.ExpenditureRepository;
import zad_dom25_settle.zad_dom25_settle.repository.SettlementRepository;



@Controller
public class SettlementController {

    SettlementRepository settlementRepository;
    CashFlowRepository cashFlowRepository;
    ExpenditureRepository expenditureRepository;

    @Autowired
    public SettlementController(SettlementRepository settlementRepository, CashFlowRepository cashFlowRepository, ExpenditureRepository expenditureRepository) {
        this.settlementRepository = settlementRepository;
        this.cashFlowRepository = cashFlowRepository;
        this.expenditureRepository = expenditureRepository;
    }

    @GetMapping("/settle")
    public String settle (Model model){

        //System.out.println(settlementRepository.settle());
        //System.out.println(settlementRepository.settle());
        model.addAttribute("roz", settlementRepository.settle());
        return "/settleForm";
    }

}
