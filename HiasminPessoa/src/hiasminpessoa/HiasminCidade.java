package hiasminpessoa;

import javax.swing.JOptionPane;
import modelo.Cidade;

public class HiasminCidade {

    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        while (cidade.getCodigocidade() == null) {
            try {
                cidade.setCodigocidade(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código: ")));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "O código só pode ser preenchido com números.");
            }
        }
        cidade.setNomecidade(JOptionPane.showInputDialog("Digite o Nome: "));
        JOptionPane.showMessageDialog(null, "Cidade\nCódigo: " + cidade.getCodigocidade() + "\nNome: " + cidade.getNomecidade());
    }
}
