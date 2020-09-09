package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.controller.form.CursoForm;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> list(){
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter(cursos);
    }

    @PostMapping
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm cursoForm, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoForm.converter();

        cursoRepository.save(curso);

        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }

}
