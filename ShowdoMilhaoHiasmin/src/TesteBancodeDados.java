
import dao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Jogador;

public class TesteBancodeDados {

    public static void main(String[] args) {
        inserir();
        List<Jogador> lista = listar();
        for (Jogador jogador : lista) {
            System.out.println(jogador.getLogin() + "\n" + jogador.getSenha() + "\n" + jogador.getEmail());
        }
    }

    public static List<Jogador> listar() {
        List<Jogador> jogadores = new ArrayList<Jogador>();
        try {
            String sql = "SELECT * FROM JOGADOR"; //LIMIT 10
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) { //Vai fazer isso enquanto tiver registros, vai repetir
                //Pega a estrutura do ResultSet e relaciona a classe jogador
                Jogador jog = new Jogador();
                jog.setLogin(res.getString("login")); //Quando quiser o login: res.getString("login"); Que está no BD
                jog.setSenha(res.getString("senha"));
                jog.setEmail(res.getString("email"));
                //Adiciona na lista
                jogadores.add(jog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TesteBancodeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jogadores;
    }

    public static void inserir() {
        String sql, login, senha, email;
        login = JOptionPane.showInputDialog("Login: ");
        senha = JOptionPane.showInputDialog("Senha: ");
        email = JOptionPane.showInputDialog("Email: ");
        sql = "INSERT INTO jogador(login, senha, email) VALUES (?, ?, ?)"; //no ? = substitui com comando abaixo
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try { //Ou: import java.sql.SQLException;
            pst.setString(1, login);
            pst.setString(2, senha);
            pst.setString(3, email);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TesteBancodeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
