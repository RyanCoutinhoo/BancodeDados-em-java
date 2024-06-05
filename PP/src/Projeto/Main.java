/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {
     Scanner sc = new Scanner(System.in);
     ConectaBanco cb = new ConectaBanco();
     String CPF;
     String Nome;
     String Telefone;
     String Endereco;
     boolean ligado = true;
     
        while(ligado){
        System.out.println("Olá, seja bem, vindo ao site oficial da Coutinho's");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Inserir ");
        System.out.println("2 - Buscar ");
        System.out.println("3- Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("5 - Sair"); 
        int opc = sc.nextInt();
        sc.nextLine();
        
        switch(opc){
            case 1 ->{
                System.out.println("Insira o CPF: ");
                CPF = sc.nextLine();
                System.out.println("Insira o Nome: ");
                Nome = sc.nextLine();
                System.out.println("Insira o Telefone: ");
                Telefone = sc.nextLine();
                System.out.println("Insira o Endereço: ");
                Endereco = sc.nextLine();
                cb.inserirDado(CPF, Nome, Telefone, Endereco);
                System.out.println("Registrado com sucesso");
            } 
            case 2 -> {
                System.out.println("Insira o CPF");
                CPF = sc.nextLine();
                ResultSet busca = cb.lerDado();
                while(busca.next()){
                    System.out.println("Segue os dados do usuário: \n");
                    System.out.println("Nome = "+(busca.getString("nome")));
                    System.out.println("Telefone = "+(busca.getString("telefone")));
                    System.out.println("Endereço = "+(busca.getString("endereco")));
                }
            }
            case 3 ->{
                System.out.println("Digite o Nome");
                Nome = sc.nextLine();
                System.out.println("Digite o Telefone");
                Telefone = sc.nextLine();
                System.out.println("Digite o Endereço");
                Endereco = sc.nextLine();
                System.out.println("Digite o CPF");
                CPF = sc.nextLine();
                    if(cb.atualizarDado(Nome, Telefone, Endereco,CPF) > 0){
                        System.out.println("Atualização feita com sucesso");
                    }else{
                        System.out.println("Erro");
                    }
            }
            case 4 -> {
                System.out.println("Digite o CPF");
                CPF = sc.next();
                    if(cb.deletarDado(CPF) > 0){
                        System.out.println("Deletado com sucesso"); 
                    }else{
                        System.out.println("Erro");
                    }
            }
            case 5 ->{
                ligado = false;
                        
            }
            default ->{
                System.out.println("Operação invalida");
            }
                
        }
       }
        
        
    }
}
