package br.ufrrj.quicksell.utils;

public class Adress{
    String street;
    String cep;
    String district;
    String number;
    String city;
    String state;
    String complement;

    public Adress(String street, String cep, String district, String number, String city, String state, String complement) {
        this.street = street;
        this.cep = cep;
        this.district = district;
        this.number = number;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }
}
