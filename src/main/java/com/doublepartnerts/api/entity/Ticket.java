package com.doublepartnerts.api.entity;

// Importaciones necesarias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Definición de la entidad "Ticket" que será mapeada a una tabla en la base de datos
@Entity
public class Ticket {
    // Identificador único de cada ticket, se generará automáticamente en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    // Relación Many-to-One con la entidad User, usando un FetchType LAZY para cargarlo solo cuando sea necesario
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Atributo que almacenará la fecha de creación del ticket
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date createdAt;

    // Atributo que almacenará la fecha de actualización del ticket
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion")
    private Date updateDate;

    // Atributo que indica el estado del ticket (por ejemplo, si está abierto o cerrado)
    @Getter
    @Setter
    private boolean status;
}
