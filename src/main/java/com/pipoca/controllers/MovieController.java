package com.pipoca.controllers;

import com.pipoca.models.Movie;
import com.pipoca.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {


    private final JsonMapper.Builder builder;
    private final MovieService movieService;

    public MovieController(JsonMapper.Builder builder, MovieService movieService) {
        this.builder = builder;
        this.movieService = movieService;
    }

    @GetMapping
    public String redirecionaFilme(){
        return "movies";
    }

    @GetMapping("/search")
    public String buscaFilmes(@RequestParam String busca, Model model){

        List<Movie> filmes = movieService.buscaFilmes(busca);

        model.addAttribute("filmes", filmes);

        return "movies";
    }
}
