package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String nome;
    private String categoria;

    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }

    public static List<CursoDto> converter(List<Curso> cursos){
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
