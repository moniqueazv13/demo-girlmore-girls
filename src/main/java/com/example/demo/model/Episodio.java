package com.example.demo.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEp) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEp.titulo();
        this.numeroEpisodio = dadosEp.numero();
        try {
            this.avaliacao = Double.valueOf(dadosEp.avaliacao());
        } catch (NumberFormatException ex){
            this.avaliacao = 0.0;
        }
        try{
            this.dataLancamento = LocalDate.parse(dadosEp.dataLancamento());
        } catch (DateTimeParseException ex) {
           this.dataLancamento = LocalDate.now();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "\ntemporada=" + temporada +
                "\ntitulo=" + titulo + '\'' +
                "\nnumeroEpisodio=" + numeroEpisodio +
                "\navalicao=" + avaliacao +
                "\ndataLancamento=" + dataLancamento;
    }
}
