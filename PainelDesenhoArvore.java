import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D; 

public class PainelDesenhoArvore extends JPanel {

    private Arvore noRaizDaArvore;
    private static final int RAIO_NO = 20; 
    private static final int ESPACO_VERTICAL_ENTRE_NIVEIS = 60;

    public PainelDesenhoArvore(Arvore noRaiz) {
        this.noRaizDaArvore = noRaiz;
        setBackground(Color.WHITE);
        setPreferredSize(new java.awt.Dimension(800, 600)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (noRaizDaArvore != null && noRaizDaArvore.getAluno() != null) {
            desenharNoERecursao(g2d, noRaizDaArvore, getWidth() / 2, RAIO_NO + 20, 0, 0, true, getWidth());
        } else {
            g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
            FontMetrics fm = g2d.getFontMetrics();
            String mensagem = "Árvore está vazia.";
            g2d.drawString(mensagem, (getWidth() - fm.stringWidth(mensagem)) / 2, getHeight() / 2);
        }
    }

    private void desenharNoERecursao(Graphics2D g2d, Arvore noAtual, 
                                    int xCentroNoAtual, int yCentroNoAtual, 
                                    int xCentroPai, int yCentroPai, 
                                    boolean ehRaiz, int larguraTotalDisponivel) {
        
        if (noAtual == null || noAtual.getAluno() == null) {
            return;
        }

        Ellipse2D.Double circulo = new Ellipse2D.Double(
            xCentroNoAtual - RAIO_NO, 
            yCentroNoAtual - RAIO_NO, 
            2 * RAIO_NO, 
            2 * RAIO_NO
        );
        g2d.setColor(new Color(135, 206, 250)); 
        g2d.fill(circulo);
        g2d.setColor(Color.BLACK);
        g2d.draw(circulo);

        String textoNo = String.valueOf(noAtual.getAluno().getRgm());
        g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
        FontMetrics fm = g2d.getFontMetrics();
        int larguraTexto = fm.stringWidth(textoNo);
        // Desenha o texto centralizado no nó
        g2d.drawString(textoNo, xCentroNoAtual - larguraTexto / 2, yCentroNoAtual + fm.getAscent() / 2 - 2);

        
        if (!ehRaiz) {
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawLine(xCentroPai, yCentroPai + RAIO_NO, xCentroNoAtual, yCentroNoAtual - RAIO_NO); 
        }

        int yFilhos = yCentroNoAtual + ESPACO_VERTICAL_ENTRE_NIVEIS;
        
        int nivel = (yCentroNoAtual - (RAIO_NO + 20)) / ESPACO_VERTICAL_ENTRE_NIVEIS; 
        int deslocamentoHorizontal = larguraTotalDisponivel / (int) Math.pow(2, nivel + 2); 
        if (deslocamentoHorizontal < RAIO_NO * 2) deslocamentoHorizontal = RAIO_NO * 2 + 10;

        if (noAtual.getEsquerda() != null && noAtual.getEsquerda().getAluno() != null) {
            int xFilhoEsquerda = xCentroNoAtual - deslocamentoHorizontal;
            desenharNoERecursao(g2d, noAtual.getEsquerda(), xFilhoEsquerda, yFilhos, xCentroNoAtual, yCentroNoAtual, false, larguraTotalDisponivel);
        }

       
        if (noAtual.getDireita() != null && noAtual.getDireita().getAluno() != null) {
            int xFilhoDireita = xCentroNoAtual + deslocamentoHorizontal;
            desenharNoERecursao(g2d, noAtual.getDireita(), xFilhoDireita, yFilhos, xCentroNoAtual, yCentroNoAtual, false, larguraTotalDisponivel);
        }
    }
}