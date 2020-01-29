package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContactId")
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne
    private Person person;

    @OneToOne
    private Element element;

    private String emailAddress;
    private String phoneNumber;

    public Contact() {}
    public Contact(Person person) {
        this.person = person;
    }
    public Contact(Element element){
        this.element = element;
    }
    public Contact(String emailAddress, String phoneNumber){
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
    public Contact(Person person, Element element, String emailAddress){
        this.person = person;
        this.element = element;
        this.emailAddress = emailAddress;
    }
    public Contact(Person person, Element element, String emailAddress, String phoneNumber){
        this.person = person;
        this.element = element;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public Element getElement() {
        return element;
    }
    public void setElement(Element element) {
        this.element = element;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
