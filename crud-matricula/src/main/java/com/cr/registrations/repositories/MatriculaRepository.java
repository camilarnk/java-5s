package com.cr.registrations.repositories;

import com.cr.registrations.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
