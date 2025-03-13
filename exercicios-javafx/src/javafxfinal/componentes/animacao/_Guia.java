package javafxfinal.componentes.animacao;

/**
 * Esta classe serve como guia para as diferentes funcionalidades de animação
 * implementadas nas classes do pacote 'animacao'. Cada exemplo demonstra
 * diferentes abordagens para animação em JavaFX.
 */
public class _Guia {

    /**
     * AnimationExample:
     * - Demonstra como usar a classe TranslateTransition para criar uma animação de translação.
     * - Ideal para animações simples, onde um objeto se move de um ponto a outro em uma linha reta.
     * - A animação é contínua e pode ser configurada para se reverter ao atingir o final.
     * - Exemplo: Mover um círculo horizontalmente na tela.
     */
    public void animationExampleGuide() {
        System.out.println("AnimationExample: Ideal para animações simples de translação.");
    }

    /**
     * TimelineExample:
     * - Demonstra como usar a classe Timeline para criar animações com lógica em cada quadro.
     * - Ideal para animações que exigem atualizações frequentes e personalizadas, como movimentação
     *   contínua e redefinição de posição.
     * - Permite maior controle sobre a animação, incluindo a definição de intervalos de tempo entre atualizações.
     * - Exemplo: Mover um círculo continuamente da esquerda para a direita, reiniciando ao atingir o final da janela.
     */
    public void timelineExampleGuide() {
        System.out.println("TimelineExample: Ideal para animações com controle em cada quadro.");
    }

    /**
     * KeyFrameExample:
     * - Demonstra como usar a classe Timeline com múltiplos KeyFrames para criar animações com estados definidos.
     * - Ideal para animações que requerem mudanças em múltiplos atributos (como posição e cor) em momentos específicos.
     * - Permite programar animações com várias fases, alterando o comportamento do objeto ao longo do tempo.
     * - Exemplo: Mover um retângulo para a direita e mudar sua cor ao longo de três etapas.
     */
    public void keyFrameExampleGuide() {
        System.out.println("KeyFrameExample: Ideal para animações com múltiplas fases e estados definidos.");
    }

    public static void main(String[] args) {
    	_Guia guide = new _Guia();
        guide.animationExampleGuide();
        guide.timelineExampleGuide();
        guide.keyFrameExampleGuide();
    }
}

