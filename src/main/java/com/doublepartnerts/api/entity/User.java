package com.doublepartnerts.api.entity;

// Importación de las anotaciones de JPA (Java Persistence API) y Lombok
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// Definición de la entidad "User" que será mapeada a una tabla en la base de datos
@Entity
public class User {
    // Identificador único de cada usuario, se generará automáticamente en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    // Atributo que almacenará el nombre del usuario
    @Getter
    @Setter
    private String name;
}

