/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kynhanht
 */
public class Contact {
    private String address,phone,email,introPicture,mapPicture;

    public Contact() {
    }

    public Contact(String address, String phone, String email, String introPicture, String mapPicture) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.introPicture = introPicture;
        this.mapPicture = mapPicture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroPicture() {
        return introPicture;
    }

    public void setIntroPicture(String introPicture) {
        this.introPicture = introPicture;
    }

    public String getMapPicture() {
        return mapPicture;
    }

    public void setMapPicture(String mapPicture) {
        this.mapPicture = mapPicture;
    }
    
}
