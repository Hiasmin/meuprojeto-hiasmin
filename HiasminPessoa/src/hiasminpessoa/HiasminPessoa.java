package hiasminpessoa;

import javax.swing.JOptionPane;
import modelo.Pessoa;

public class HiasminPessoa {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        while (pessoa.getId() == null) {
            try {
                //Pra executar
                pessoa.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código: ")));
            } catch (Exception ex) {
                //Fazer se der erro
                JOptionPane.showMessageDialog(null, "O código só pode ser preenchIdo com números.");
            }
        }
        pessoa.setNome(JOptionPane.showInputDialog("Digite o Nome: "));
        pessoa.setSexo(JOptionPane.showInputDialog("Digite o Sexo: "));
        JOptionPane.showMessageDialog(null, "Código: " + pessoa.getId() + "\nNome: " + pessoa.getNome() + "\nSexo: " + pessoa.getSexo());
    }
}
