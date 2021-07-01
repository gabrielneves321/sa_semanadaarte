package br.com.sa.service;


import br.com.sa.model.Funcionario;

import java.util.List;


public interface FuncionarioService {

    public Funcionario findById(Long id);
    public List<Funcionario> findAll();
    public Funcionario findByEmail(String email);
    public Funcionario findByNome(String nome);
    public String validarFuncionario(Funcionario funcionario);



    public boolean save(Funcionario funcionario);
    public boolean delete(Long id);


}
