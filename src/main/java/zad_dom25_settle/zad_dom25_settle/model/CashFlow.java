package zad_dom25_settle.zad_dom25_settle.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
    private Long expId;
    private Long personId;
    private Double flow;
    private String currency;

    public CashFlow() {
    }

    public CashFlow(Long expId, Long personId, Double flow, String currency) {
        this.expId = expId;
        this.personId = personId;
        this.flow = flow;
        this.currency = currency;
    }

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CashFlow{" +
                "id=" + id +
                ", expId=" + expId +
                ", personId=" + personId +
                ", flow=" + flow +
                ", currency='" + currency + '\'' +
                '}';
    }
}
