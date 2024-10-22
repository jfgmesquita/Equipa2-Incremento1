package Equipa2.Incremento1;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String descricao;
    private LocalDateTime data;
    private double valorHora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
}
