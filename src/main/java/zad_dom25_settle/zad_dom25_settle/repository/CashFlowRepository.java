package zad_dom25_settle.zad_dom25_settle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import zad_dom25_settle.zad_dom25_settle.model.CashFlow;

public interface CashFlowRepository extends JpaRepository<CashFlow, Long> {




    @Modifying
    @Transactional
    @Query(value = "delete from cash_flow where Exp_id = :id", nativeQuery = true)
    void deleteByExpID(@Param("id") Long id);


}
