package com.bndnetworks.net.schoolAppdemo.classes.entity;

import javax.persistence.*;

@Entity(name="classe")
public class ClassEntity {
    @Id
    @Column(name = "idclasse" )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name= "libelle_classe")
    private String className;

    @Column(name="frais_pension")
    private Double schoolFee;

    @Column(name="inscription")
    private Double subscription;

   @Column(name="tranche1")
   private Double firstPayment;

   @Column(name="tranche2")
    private Double secondPayment;

   @Column(name="tranche3")
    private Double thirdPayment;

   @Column(name="fraisdossier")
    private Double examFees;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getSchoolFee() {
        return schoolFee;
    }

    public void setSchoolFee(Double schoolFee) {
        this.schoolFee = schoolFee;
    }

    public Double getSubscription() {
        return subscription;
    }

    public void setSubscription(Double subscription) {
        this.subscription = subscription;
    }

    public Double getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(Double firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Double getSecondPayment() {
        return secondPayment;
    }

    public void setSecondPayment(Double secondPayment) {
        this.secondPayment = secondPayment;
    }

    public Double getThirdPayment() {
        return thirdPayment;
    }

    public void setThirdPayment(Double thirdPayment) {
        this.thirdPayment = thirdPayment;
    }

    public Double getExamFees() {
        return examFees;
    }

    public void setExamFees(Double examFees) {
        this.examFees = examFees;
    }
}
