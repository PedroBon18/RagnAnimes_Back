package com.ragnanimes.api.models.anime;
import java.util.ArrayList;

import com.ragnanimes.api.models.anime.Anime;
import com.ragnanimes.api.models.anime.DadosCadastroAnime;
import com.ragnanimes.api.models.anime.Genero;
import com.ragnanimes.api.models.comentario.Comentario;
import com.ragnanimes.api.models.likes.Likes;


import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;    
    private String estudio; 
    private String imagem;
    @Enumerated(EnumType.STRING)  
    private Genero genero;  
    private String sinopse;
    private String anoLancamento;
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes = new ArrayList<>();
    

    public Anime(DadosCadastroAnime dados){
        this.nome = dados.nome();
        this.estudio = dados.estudio();
        this.imagem = dados.imagem();
        this.genero = dados.genero();
        this.sinopse = dados.sinopse();
        this.anoLancamento = dados.anoLancamento();
    }
    public void atualizaInfo(DadosAtualizadoAnime dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.estudio() != null){
            this.estudio = dados.estudio();
        }
        if (dados.estudio() != null){
            this.imagem = dados.imagem();
        }
        if (dados.estudio() != null){
            this.genero = dados.genero();
        }
        if (dados.estudio() != null){
            this.sinopse = dados.sinopse();
        }
        if (dados.estudio() != null){
            this.anoLancamento = dados.anoLancamento();
        }
    }
}
