package com.ragnanimes.api.models.anime;

public record DadosCadastroAnime(
    String nome,
    String estudio,
    String imagem,
    Genero genero,
    String sinopse
    ) {
    
}
