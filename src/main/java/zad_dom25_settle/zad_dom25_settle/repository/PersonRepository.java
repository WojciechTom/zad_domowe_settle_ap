package zad_dom25_settle.zad_dom25_settle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import zad_dom25_settle.zad_dom25_settle.model.Person;

import java.util.ArrayList;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query("select p from Person p")
    List<Person>showAll();

    @Query("select p from Person p where id = :id")
    Person showPerson(@Param("id") Long id);

    @Query("UPDATE Person set AMOUNT_OF_EXP  = AMOUNT_OF_EXP + 1  WHERE ID =  :id   ")
    @Transactional
    @Modifying
    void increaseAmountToExpJpql(@Param("id") String id);


    @Query("UPDATE Person set AMOUNT_OF_EXP  = AMOUNT_OF_EXP -1  WHERE ID =  :id   ")
    @Transactional
    @Modifying
    void decreaseAmountToExpJpql(@Param("id") Long id);




}
