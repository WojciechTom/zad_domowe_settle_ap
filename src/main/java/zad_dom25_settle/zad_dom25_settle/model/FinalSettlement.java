package zad_dom25_settle.zad_dom25_settle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinalSettlement {

    @Id
    private Long personId;
    private String firstName;
    private String lastName;
    private Double amountToPayOrRecive;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public Double getAmountToPayOrRecive() {
        return amountToPayOrRecive;
    }

    public void setAmountToPayOrRecive(Double amountToPayOrRecive) {
        this.amountToPayOrRecive = amountToPayOrRecive;
    }
}
