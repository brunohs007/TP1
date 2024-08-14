package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaService service = new PessoaService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Consultar Pessoa");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Excluir Pessoa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(nome, idade, email, telefone);
                    service.adicionarPessoa(novaPessoa);
                    System.out.println("Pessoa adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome da pessoa a consultar: ");
                    String nomeConsulta = scanner.nextLine();
                    Pessoa pessoaConsultada = service.consultarPessoa(nomeConsulta);
                    if (pessoaConsultada != null) {
                        System.out.println("Dados da pessoa: " + pessoaConsultada);
                    } else {
                        System.out.println("Pessoa não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Nome da pessoa a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova idade: ");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    Pessoa pessoaAtualizada = new Pessoa(novoNome, novaIdade, novoEmail, novoTelefone);
                    if (service.atualizarPessoa(nomeAtualizar, pessoaAtualizada)) {
                        System.out.println("Pessoa atualizada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Nome da pessoa a excluir: ");
                    String nomeExcluir = scanner.nextLine();
                    if (service.excluirPessoa(nomeExcluir)) {
                        System.out.println("Pessoa excluída com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
