package com.cenfotec.examen2.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razonSocial;
    private String cedJuridica;
    private String direccion;
    private int tel;
    private Date created;
    private String personContacts;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Cliente() {
    }

    public Cliente(String razonSocial, String cedJuridica, String direccion, int tel, String date) throws ParseException {
        this.razonSocial = razonSocial;
        this.cedJuridica = cedJuridica;
        this.direccion = direccion;
        this.tel = tel;
        this.created = format.parse(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCedJuridica() {
        return cedJuridica;
    }

    public void setCedJuridica(String cedJuridica) {
        this.cedJuridica = cedJuridica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getPersonContacts() {
        return personContacts;
    }

    public void setPersonContacts(String personContacts) {
        this.personContacts = personContacts;
    }

    public String getCreatedAsShort() {
        return format.format(created);
    }

    public String toString() {
        StringBuilder value = new StringBuilder("ClienteEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Razon Social: ");
        value.append(razonSocial);
        value.append(",Cedula Juridica: ");
        value.append(cedJuridica);
        value.append(",Direccion: ");
        value.append(direccion);
        value.append(",Telefono: ");
        value.append(tel);
        value.append(",Persona contacto: ");
        value.append(personContacts);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
