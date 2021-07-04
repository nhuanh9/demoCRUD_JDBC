package model;

public class Customer {
    private int idCus;
    private String name;
    private int age;

    public Customer(int idCus, String name, int age) {
        this.idCus = idCus;
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
