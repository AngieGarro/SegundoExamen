package com.cenfotec.examen2.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class PersonContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String ape1;
    private String ape2;
    private String email;
    private int tel;
    private Date created;
    private String cliente;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public PersonContact(String nombre, String ape1, String ape2, String email, int tel, String date, String cliente) throws ParseException {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.email = email;
        this.tel = tel;
        this.created = format.parse(date);
        this.cliente = cliente;
    }

    public PersonContact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCreatedAsShort() {
        return format.format(created);
    }

    public String toString() {
        StringBuilder value = new StringBuilder("personaEntry(");
        value.append("Id:");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Apellido1: ");
        value.append(ape1);
        value.append(",Apellido2: ");
        value.append(ape2);
        value.append(",Telefono: ");
        value.append(tel);
        value.append(",Email: ");
        value.append(email);
        value.append(",Cliente: ");
        value.append(cliente);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
