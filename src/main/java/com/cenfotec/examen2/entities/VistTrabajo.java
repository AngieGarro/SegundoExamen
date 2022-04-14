package com.cenfotec.examen2.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class VistTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date Fecha;
    private String Consultor;
    private String Cliente;
    private String AreaEspecialidad;
    private Date created;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public VistTrabajo(Date fecha, String consultor, String cliente, String areaEspecialidad, String date) throws ParseException {
        Fecha = fecha;
        Consultor = consultor;
        Cliente = cliente;
        AreaEspecialidad = areaEspecialidad;
        this.created = format.parse(date);
    }

    public VistTrabajo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getConsultor() {
        return Consultor;
    }

    public void setConsultor(String consultor) {
        Consultor = consultor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getAreaEspecialidad() {
        return AreaEspecialidad;
    }

    public void setAreaEspecialidad(String areaEspecialidad) {
        AreaEspecialidad = areaEspecialidad;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedAsShort() {
        return format.format(created);
    }

    public String toString() {
        StringBuilder value = new StringBuilder("VisitTrabajoEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Fecha: ");
        value.append(Fecha);
        value.append(",Consultor: ");
        value.append(Consultor);
        value.append(",Cliente: ");
        value.append(Cliente);
        value.append(",Area de Especialidad: ");
        value.append(AreaEspecialidad);
        value.append(",Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
