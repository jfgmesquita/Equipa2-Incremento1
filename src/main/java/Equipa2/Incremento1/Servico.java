package Equipa2.Incremento1;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servico {
    private String titulo;
    private String descricao;
    private LocalDateTime data;
}
