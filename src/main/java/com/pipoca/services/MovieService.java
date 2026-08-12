package com.pipoca.services;

import com.pipoca.models.Movie;
import com.pipoca.models.MovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private final WebClient webClient;

    public MovieService(WebClient.Builder webClientBuilder, @Value("${tmdb.api.key}") String token) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.themoviedb.org/3")
                .defaultHeader("Authorization", "Bearer " + token)
                .defaultHeader("accept", "application/json")
                .build();
    }

    public List<Movie> buscaFilmes(String busca) {
        MovieResponse response = this.webClient.get()
                .uri("/search/movie?query={busca}&language=pt-BR&include_adult=false", busca)
                .retrieve()
                .bodyToMono(MovieResponse.class)
                .block();

        if (response == null || response.getResults() == null) {
            return Collections.emptyList();
        }

        return response.getResults();
    }
}