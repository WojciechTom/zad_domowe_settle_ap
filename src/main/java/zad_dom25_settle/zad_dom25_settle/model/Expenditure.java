package zad_dom25_settle.zad_dom25_settle.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Expenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String longDescription;
    private Double amount;
    private String currency;
    private Long payById;
    private String splitBetweenId;

//    @OneToMany(mappedBy = "exp_id")
//    private List<CashFlow> przeplywy;


    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPayById() {
        return payById;
    }

    public void setPayById(Long payBy) {
        this.payById = payBy;
    }

    public String getSplitBetweenId() {
        return splitBetweenId;
    }

    public void setSplitBetweenId(String splitBetweenId) {
        this.splitBetweenId = splitBetweenId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", payById=" + payById +
                ", splitBetweenId='" + splitBetweenId + '\'' +
                '}';
    }
}
