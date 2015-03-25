package cz.muni.fi.pv168;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by michalsimik on 10.03.15.
 */
public class Contact {
    Long id;
    String firstName;
    String surName;
    String address;
    String phoneNumber;
    String mail;
    LocalDate born;


    public Contact() {
    }

    public Contact(Long id, String firstName, String surName, String address, String phoneNumber, String mail, LocalDate born) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.born = born;
    }

    public void showContact(int idContact){

    }

    @Override
    public String toString() {
        return "Contact{" +
                "id= " + id +
                ", name= " + firstName + surName +
                ", address= " + address +
                ", phone= " + phoneNumber +
                ", mail= " + mail +
                ", born= " + born +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        if (born != null ? !born.equals(contact.born) : contact.born != null) return false;
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (mail != null ? !mail.equals(contact.mail) : contact.mail != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(contact.phoneNumber) : contact.phoneNumber != null) return false;
        if (surName != null ? !surName.equals(contact.surName) : contact.surName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (born != null ? born.hashCode() : 0);
        return result;
    }
}
