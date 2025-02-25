package com.example.demo;

import com.example.demo.model.DadosEpisodio;
import com.example.demo.model.DadosSerie;
import com.example.demo.model.DadosTemporada;
import com.example.demo.service.ConsumoApi;
import com.example.demo.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(com.example.demo.ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ConsumoApi consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
//
//        json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);
//
//        json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//        DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//        System.out.println(dadosTemporada);

        // código omitido

//        System.out.println(dados);
//        json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);

        List<DadosEpisodio> dadosEpisodiosList = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode="+i+"&apikey=6585022c");
            DadosEpisodio dadosEpisodios = conversor.obterDados(json, DadosEpisodio.class);
            dadosEpisodiosList.add(dadosEpisodios);
        }
        dadosEpisodiosList.forEach(System.out::println);

List<DadosTemporada> dadosTemporadaList = new ArrayList<>();
        for(int i = 1; i<=dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            dadosTemporadaList.add(dadosTemporada);
        }
        dadosTemporadaList.forEach(System.out::println);
    }
}
