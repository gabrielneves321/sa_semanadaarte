package br.com.sa.repository;


import br.com.sa.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public Funcionario findByEmail(String email);
    public Funcionario findByNome(String nome);

    public Funcionario findByIdNotAndEmail(Long id, String email);
    public Funcionario findByIdNotAndNome(Long id, String nome);

}
