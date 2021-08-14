package br.ufrrj.quicksell.utils;

public class Adress{
    public String street;
    public String cep;
    public String district;
    public String number;
    public String city;
    public String state;
    public String complement;

    public Adress(String street, String cep, String district, String number, String city, String state, String complement) {
        this.street = street;
        this.cep = cep;
        this.district = district;
        this.number = number;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    public String getStringAdress(){
        return this.street + " street " + "n" + this.number + ", " + this.district + ", " + this.city + "/" + this.state;
    }
}
