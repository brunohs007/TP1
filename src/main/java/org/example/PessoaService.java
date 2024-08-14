package org.example;

import java.util.List;

public class PessoaService {
    private PessoaRepository repository;
    private List<Pessoa> pessoas;

    public PessoaService() {
        repository = new PessoaRepository();
        pessoas = repository.carregarPessoas();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        repository.salvarPessoas(pessoas);
    }

    public Pessoa consultarPessoa(String nome) {
        return pessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarPessoa(String nome, Pessoa novaPessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
                pessoas.set(i, novaPessoa);
                repository.salvarPessoas(pessoas);
                return true;
            }
        }
        return false;
    }

    public boolean excluirPessoa(String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
                pessoas.remove(i);
                repository.salvarPessoas(pessoas);
                return true;
            }
        }
        return false;
    }
}
