package br.senai.projeto.controle;


import br.senai.projeto.modelo.CarroFormula1;
import br.senai.projeto.repositorio.CarroFormula1Repositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("carros")

public class ControleCarro {

    @Autowired

    private CarroFormula1Repositorio repositorio;

    @GetMapping
    public List<CarroFormula1> listar() {
        return repositorio.findAll();
    }


    @GetMapping("/{id}")
    public CarroFormula1 buscarPorId(@PathVariable Long id) {
        return repositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado com ID: " + id));
    }

    @PostMapping
    public CarroFormula1 salvar(@Valid @RequestBody CarroFormula1 carro) {
        return repositorio.save(carro);
    }

    @PutMapping("/{id}")
    public CarroFormula1 modificar(@PathVariable Long id, @Valid @RequestBody CarroFormula1 carro) {
        carro.setId(id);
        return repositorio.save(carro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado para exclusão");
        }
        repositorio.deleteById(id);
    }
}