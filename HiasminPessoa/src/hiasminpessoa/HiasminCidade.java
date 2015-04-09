package hiasminpessoa;

import javax.swing.JOptionPane;
import modelo.Cidade;

public class HiasminCidade {

    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        while (cidade.getId() == null) {
            try {
                cidade.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código: ")));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "O código só pode ser preenchido com números.");
            }
        }
        cidade.setNomecidade(JOptionPane.showInputDialog("Digite o Nome: "));
        JOptionPane.showMessageDialog(null, "Cidade\nCódigo: " + cidade.getId() + "\nNome: " + cidade.getNomecidade());
    }
}
