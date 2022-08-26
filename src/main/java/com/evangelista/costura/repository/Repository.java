package com.evangelista.costura.repository;

import com.evangelista.costura.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Funcionario, Long> {


}
