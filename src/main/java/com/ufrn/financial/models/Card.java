package com.ufrn.financial.models;

import com.ufrn.financial.models.enums.FlagEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Table(name = "card")
@Entity(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String embossing;

    private String number;

    private String cvv;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private FlagEnum flag;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private Boolean active;

    @ManyToMany(mappedBy = "cards")
    private Set<Transaction> transactions;

    public Card() {
    }

    public UUID getId() {
        return id;
    }

    public String getEmbossing() {
        return embossing;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public FlagEnum getFlag() {
        return flag;
    }

    public Person getPerson() {
        return person;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmbossing(String embossing) {
        this.embossing = embossing;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setFlag(FlagEnum flag) {
        this.flag = flag;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
