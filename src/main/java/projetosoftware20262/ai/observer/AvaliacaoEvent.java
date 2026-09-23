package projetosoftware20262.ai.observer;

public class AvaliacaoEvent extends ApplicationEvent {
    
    private final String tipoOperacao;

    public AvaliacaoEvent(Object source, String tipoOperacao) {
        super(source);
        this.tipoOperacao = tipoOperacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }
}
