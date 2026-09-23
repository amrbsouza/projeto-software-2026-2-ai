package projetosoftware20262.ai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import projetosoftware20262.ai.dto.AvaliacaoDTO;
import projetosoftware20262.ai.entity.Avaliacao;
import projetosoftware20262.ai.repository.AvaliacaoRepository;

@Service 
public class AvaliacaoService {
    @Autowired 
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired 
    private ApplicationEventPublisher eventPublisher;

    @Transactional 
    public Avaliacao cadastrar(AvaliacaoDTO dto) {
        if (dto.getAutor() == null || dto.getConteudo() == null || dto.getNota() == null) {
            throw new RuntimeException("Os campos obrigatórios devem ser preenchidos.");
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAutor(dto.getAutor());
        avaliacao.setConteudo(dto.getConteudo());
        avaliacao.setNota(dto.getNota());
        avaliacao.setDataAvaliacao(dto.getDataAvaliacao());

        Avaliacao cadastra = avaliacaoRepository.save(avaliacao);

        eventPublisher.publishEvent(new AvaliacaoEvent(this, "CREATE"));

        return cadastra;
    }

    @Transactional
    public void deletar(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada."));

        avaliacaoRepository.delete(avaliacao);

        eventPublisher.publishEvent(new AvaliacaoEvent(this, "DELETE"));
    }
}

