package br.senai.projeto.controle;

import br.senai.projeto.dto.CarroDTO;
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

    @PostMapping
    public CarroFormula1 salvar(@RequestBody @Valid CarroDTO dto) {
        CarroFormula1 carro = new CarroFormula1(dto);
        return repositorio.save(carro);
    }

    @GetMapping
    public List<CarroDTO> listaCarros() {
        return repositorio.findAll().stream()
                .map(this::entidadeParaDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CarroDTO buscarPorId(@PathVariable Long id) {
        CarroFormula1 carro = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Carro não encontrado"
                ));

        return entidadeParaDto(carro);
    }

    @PutMapping("/{id}")
    public CarroDTO atualizar(@PathVariable Long id, @RequestBody @Valid CarroDTO dto) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Carro não encontrado"
            );
        }

        CarroFormula1 carro = new CarroFormula1(dto);
        carro.setId(id);

        CarroFormula1 carroSalvo = repositorio.save(carro);

        return entidadeParaDto(carroSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Carro não encontrado para exclusão"
            );
        }

        repositorio.deleteById(id);
    }

    private CarroDTO entidadeParaDto(CarroFormula1 carro) {
        return new CarroDTO(
                carro.getId(),
                carro.getEquipe(),
                carro.getModelo(),
                carro.getMotorizacao(),
                carro.getAnoTemporada(),
                carro.getNumeroPiloto(),
                carro.getPilotoPrincipal()
        );
    }
}