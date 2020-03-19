package productdata;
import Exceptions.NotUniqueFullName;

import java.io.BufferedReader;
import java.io.IOException;

public class Organization {
    private static int orgId;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Длина строки не должна быть больше 1404, Значение этого поля должно быть уникальным, Поле не может быть null
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization(Integer id,String name, String fullName, OrganizationType type, Address postalAddress) throws Exception{
        if (name == null || fullName == null) throw new NullPointerException();
        if (fullName.length() >1404) throw new Exception("Too large full name");
        if (UniqueController.check(fullName)) throw new NotUniqueFullName();
        if (id == null) {
            orgId++;
            this.id = orgId;
        }
        else{
            this.id = id;
        }
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        this.postalAddress = postalAddress;
        UniqueController.put(this.fullName,this);
    }


    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public OrganizationType getType(){
        return type;
    }

    @Override
    public String toString(){
        return ("ID организации: " + id + " имя организации: " + name
                + " Полное имя: " + fullName + " Тип организации: " + (type == null ? "не указано" : type.toString())
                + " Адресс организации " + (postalAddress == null ? "не указано" : postalAddress.toString()));
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Organization){
            return ((Organization) obj).fullName.equals(fullName)
                    && ((Organization) obj).name.equals(name)
                    && ((Organization) obj).type.equals(type)
                    && ((Organization) obj).postalAddress.equals(postalAddress);
        }
        else return false;
    }
}