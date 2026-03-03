package br.uema.adonis.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TreinoExercicioId implements Serializable {

    private Integer idTreino;
    private Integer idExercicio;
}