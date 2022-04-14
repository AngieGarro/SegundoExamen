package com.cenfotec.examen2.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String ape1;
    private String ape2;
    private String direccion;
    private String tel;
    private Date FechaN;
    private String email;
    private String disponibilidad;
    private String especialidad;
    private String estado;
    private Date created;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Auditor() {
    }

    public Auditor(Long id, String nombre, String ape1, String ape2, String direccion, String tel,
                   Date fechaN, String email, String disponibilidad, String especialidad, String date, String estado) throws ParseException {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.direccion = direccion;
        this.tel = tel;
        FechaN = fechaN;
        this.email = email;
        this.disponibilidad = disponibilidad;
        this.especialidad = especialidad;
        this.estado = estado;
        this.created = format.parse(date);
    }

    //GETS Y SETS

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getFechaN() {
        return FechaN;
    }

    public void setFechaN(Date fechaN) {
        FechaN = fechaN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//CONSTRUCTORES//

    public String getCreatedAsShort() {
        return format.format(created);
    }
    public String toString() {
        StringBuilder value = new StringBuilder("AuditorEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Apellido1: ");
        value.append(ape1);
        value.append(",Apellido2: ");
        value.append(ape2);
        value.append(",Telefono: ");
        value.append(tel);
        value.append(",Fecha Nacimiento: ");
        value.append(FechaN);
        value.append(",Email: ");
        value.append(email);
        value.append(",Disponibilidad: ");
        value.append(disponibilidad);
        value.append(",Especialidad: ");
        value.append(especialidad);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
