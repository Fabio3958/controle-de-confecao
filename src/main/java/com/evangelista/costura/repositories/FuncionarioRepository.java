package com.evangelista.costura.repositories;

import com.evangelista.costura.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


}
