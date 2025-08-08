package com.ragnanimes.api.models.anime;
import com.ragnanimes.api.models.anime.Anime;
import com.ragnanimes.api.models.anime.DadosCadastroAnime;
import com.ragnanimes.api.models.anime.Genero;

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
    }
}
