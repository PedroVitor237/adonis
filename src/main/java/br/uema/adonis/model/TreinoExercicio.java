package br.uema.adonis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "treino_exercicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreinoExercicio {

    @EmbeddedId
    private TreinoExercicioId id;

    @ManyToOne
    @MapsId("idTreino")
    @JoinColumn(name = "id_treino")
    private Treino treino;

    @ManyToOne
    @MapsId("idExercicio")
    @JoinColumn(name = "id_exercicio")
    private Exercicio exercicio;

    private Integer series;
    private Integer repeticoes;
    private Double carga;
    private Integer descanso;
}