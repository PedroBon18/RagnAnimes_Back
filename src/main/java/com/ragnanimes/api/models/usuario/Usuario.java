package com.ragnanimes.api.models.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user;
    private String senha;
    private String dataCriacao;
    private String email;
    private String imagem;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Usuario(DadosCadastroUsuario dados){
        this.user = dados.user();
        this.senha = dados.senha();
        this.email = dados.email();
        this.dataCriacao = dados.dataCriacao();
    }
}
