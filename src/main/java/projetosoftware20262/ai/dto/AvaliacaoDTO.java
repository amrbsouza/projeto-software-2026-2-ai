package projetosoftware20262.ai.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class AvaliacaoDTO {
    private Integer nota;
    private String autor;
    private String conteudo;
    private LocalDate dataAvaliacao;
}
