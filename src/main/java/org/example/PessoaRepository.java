package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    private static final String ARQUIVO = "pessoas.txt";

    public List<Pessoa> carregarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            pessoas = (List<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Exceção necessaria para a primeira execução, caso o usuario busque uma pessoa antes do txt ser criado
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void salvarPessoas(List<Pessoa> pessoas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

