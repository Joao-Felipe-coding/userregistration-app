package com.joaofelipe.userregistrationapp;

//Importa anotações do Room necessários para mapear esta classe como uma entidade do banco de dados
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class User {
    //Define o campo 'id' como chave primária da tabela e configuraa para ser gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campos que representam as colunas da tabela para armazenar os dados do usuário
    private String name;  // Nome Usuário
    private String cpf; // CPF do Usuário
    private String email; // email do usuário
    private String phone; // Telefone do usuário

    //Constructor da classe que será usado para criar novo objeto User
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }
    //Métodos getter e setter para acessar e modificar os dados do objeto User

    //Retorna o ID do usuário
    public int getId(){return id;}

    //Define o ID do uduário(usado pelo Room para preencher automaticamente)
    public void setId(int id){this.id = id;}

    //Retorna o nome do usuário
    public String getName(){return name;}

    //Retorna o CPF do usuario
    public String getCpf(){return cpf;}

    //Retorna o email do usuario
    public String getEmail(){return email;}

    //Retorna o telefone do usuario
    public String getPhone(){return phone;}
}
