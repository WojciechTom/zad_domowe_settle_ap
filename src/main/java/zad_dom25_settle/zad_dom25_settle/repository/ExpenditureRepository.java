package zad_dom25_settle.zad_dom25_settle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zad_dom25_settle.zad_dom25_settle.model.CashFlow;
import zad_dom25_settle.zad_dom25_settle.model.Expenditure;
import java.util.ArrayList;
import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {


    @Query("select e from Expenditure e where id = :id")
    Expenditure showExpenditure (@Param("id") Long id);

    @Query("select e from Expenditure e")
    List<Expenditure> showAll();

    @Query("select e from Expenditure e order by amount asc")
    List<Expenditure> showAllAsc();

    @Query("select e from Expenditure e order by amount desc")
    List<Expenditure> showAllDesc();

    @Query("select e from Expenditure e where amount > :valueA and amount < :valueB ")
    List<Expenditure> showAllFiltr(
            @Param("valueA") Double valueA,
            @Param("valueB") Double valueB);

    @Query("select sum(amount) from Expenditure")
    Double total();

    @Query(value = "select pay_by_id from expenditure where id = :id " , nativeQuery = true)
    Long findPersonIdByExpenditureId(@Param("id") Long id);

    @Query(value = "select count(id) from expenditure", nativeQuery = true)
    int countExpenditure();


     static ArrayList<CashFlow> splitExpToCashFlow(Expenditure wydatek){
        String[] osoby = wydatek.getSplitBetweenId().split(",");
        ArrayList<CashFlow> lista = new ArrayList<>() ;

        boolean check = false;
        for(int i = 0 ; i<osoby.length ; i++){

                String id = osoby[i];


                Double przeplyw = null;
                if(id.equals( Long.toString(wydatek.getPayById()))){
                    check = true;
                    przeplyw = (wydatek.getAmount() - (wydatek.getAmount() / (osoby.length))) ;
                } else {
                    przeplyw = (-wydatek.getAmount() / (osoby.length));
                }



            CashFlow cf = new CashFlow(wydatek.getId(), Long.parseLong(id), przeplyw, wydatek.getCurrency());

            lista.add(cf);
        }

        //sprawdzenie czy osoba płacąca wchodzi do podziału
        if(!check){
            lista.add(new CashFlow(wydatek.getId(), wydatek.getPayById(), wydatek.getAmount(), wydatek.getCurrency()));
        }


        return lista;
    }


}
