package zad_dom25_settle.zad_dom25_settle.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String umlImg;
    private int amountOfExp;

//    private List<Expenditure> wydatki;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUmlImg() {
        return umlImg;
    }

    public void setUmlImg(String umlImg) {
        this.umlImg = umlImg;
    }

    public int getAmountOfExp() {
        return amountOfExp;
    }

    public void setAmountOfExp(int amountOfExp) {
        this.amountOfExp = amountOfExp;
    }
}
