package zad_dom25_settle.zad_dom25_settle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import zad_dom25_settle.zad_dom25_settle.model.FinalSettlement;

import java.util.List;


public interface SettlementRepository extends JpaRepository <FinalSettlement, Long>{

    @Query(value = "select cf.person_id, p.first_name, p.last_name, sum(cf.flow) Amount_To_Pay_Or_Recive FROM person p, cash_flow cf where p.Id = cf.person_id group by cf.person_id, p.first_name, p.last_name", nativeQuery = true)
    List<FinalSettlement> settle();

}
