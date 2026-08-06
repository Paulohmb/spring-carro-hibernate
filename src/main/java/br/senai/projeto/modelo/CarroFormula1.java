package br.senai.projeto.modelo;


import br.senai.projeto.dto.CarroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


@Entity
@Table(name = "tb_carro_f1")
public class CarroFormula1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Equipe é obrigatória")
    private String equipe;

    @NotEmpty(message = "Modelo é obrigatório")
    private String modelo;


    private String motorizacao;

    @Min(value = 1950, message = "Ano deve ser maior que 1950")
    @Column(name = "ano_temporada", nullable = false )
    private Integer anoTemporada;


    @Column(name = "numero_piloto")
    private Integer numeroPiloto;

    @Column(name = "piloto_principal")
    private String pilotoPrincipal;


    private Boolean ativo = true;


    // Construtor padrão (obrigatório pela especificação JPA)
    public CarroFormula1() {
    }


    // Construtor completo
    // Construtor para converter DTO para Entidade
    public CarroFormula1(CarroDTO dto){
        this.equipe = dto.equipe();
        this.modelo = dto.modelo();
        this.motorizacao = dto.motorizacao();
        this.anoTemporada = dto.anoTemporada();
        this.numeroPiloto = dto.numeroPiloto();
        this.pilotoPrincipal = dto.pilotoPrincipal();
    }



    // Getters e Setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEquipe() {
        return equipe;
    }


    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getMotorizacao() {
        return motorizacao;
    }


    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }


    public Integer getAnoTemporada() {
        return anoTemporada;
    }


    public void setAnoTemporada(Integer anoTemporada) {
        this.anoTemporada = anoTemporada;
    }


    public Integer getNumeroPiloto() {
        return numeroPiloto;
    }


    public void setNumeroPiloto(Integer numeroPiloto) {
        this.numeroPiloto = numeroPiloto;
    }


    public String getPilotoPrincipal() {
        return pilotoPrincipal;
    }


    public void setPilotoPrincipal(String pilotoPrincipal) {
        this.pilotoPrincipal = pilotoPrincipal;
    }


    public Boolean getAtivo() {
        return ativo;
    }


    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarroFormula1 that = (CarroFormula1) o;
        return Objects.equals(id, that.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "CarroFormula1{" +
                "id=" + id +
                ", equipe='" + equipe + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motorizacao='" + motorizacao + '\'' +
                ", anoTemporada=" + anoTemporada +
                ", numeroPiloto=" + numeroPiloto +
                ", pilotoPrincipal='" + pilotoPrincipal + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
