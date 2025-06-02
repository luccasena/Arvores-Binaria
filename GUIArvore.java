import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GUIArvore extends JFrame {

    private PainelDesenhoArvore painelDesenho;

    public GUIArvore(Arvore noRaiz) {
        setTitle("Visualizador de Árvore Binária (Simples)");   
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        painelDesenho = new PainelDesenhoArvore(noRaiz);

        
        JScrollPane scrollPane = new JScrollPane(painelDesenho);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        add(scrollPane, BorderLayout.CENTER); 

        
        setSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(400,300));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}