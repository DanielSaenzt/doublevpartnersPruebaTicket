package com.doublepartnerts.api.repository;

// Importaciones necesarias
import com.doublepartnerts.api.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Definición de la interfaz de repositorio para la entidad "Ticket"
@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    // Método para buscar un ticket por su identificador (id), paginando los resultados
    // El método retorna una página de tickets que coinciden con el id proporcionado
    Page<Ticket> findById(Long id, Pageable pageable);

}

