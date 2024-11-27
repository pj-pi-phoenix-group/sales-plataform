package com.phoenix.pi.sales_platform.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // Nome da tabela no banco de dados
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Nome da coluna no banco
    private Long userId;

    @Column(name = "name", nullable = false, length = 100) // Nome da coluna "name"
    private String name;

    @Column(name = "number", length = 15) // Exemplo de número de telefone (opcional)
    private String number;

    @Column(name = "email", nullable = false, unique = true) // E-mail único e obrigatório
    private String email;

    @Column(name = "password", nullable = false) // Senha obrigatória
    private String password;

    // Construtores
    public User() {}

    public User(Long userId, String name, String number, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
    }

    // Getters e Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // equals e hashCode baseados no userId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
