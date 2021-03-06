package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jogador;

public class JogadorDAO {

    public Boolean inserir(Jogador jogador) {
        Boolean retorno;
        //Monta o SQL de INSERT na tabela
        String sql = "INSERT INTO jogador (login, senha, email, imagem) VALUES(?,?,?,?)";
        //Prepara a conexão do meu SQL
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            //Insere os parametos
            pst.setString(1, jogador.getLogin());
            pst.setString(2, jogador.getSenha());
            pst.setString(3, jogador.getEmail());
            pst.setBytes(4, jogador.getImagem());
            //Executa o SQL no Banco de Dados
            pst.executeUpdate();
            retorno = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public List<Jogador> listar() {
        //Cria a lista de jogadores
        List<Jogador> lista = new ArrayList<Jogador>();
        String sql = "SELECT * FROM JOGADOR";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            //Executo o SQL e jogo em um resultSet
            ResultSet res = pst.executeQuery();
            //Enquanto tiver registro eu vou relacionar com minha classe jogador e add na lista
            while (res.next()) {
                Jogador jogador = new Jogador();
                jogador.setLogin(res.getString("login"));
                jogador.setSenha(res.getString("senha"));
                jogador.setEmail(res.getString("email"));
                jogador.setImagem(res.getBytes("imagem"));
                lista.add(jogador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Boolean excluir(Jogador jogador) {
        Boolean retorno;
        String sql = "DELETE FROM jogador WHERE login = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, jogador.getLogin());
            pst.executeUpdate();
            retorno = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public Boolean alterar(Jogador jogador) {
        Boolean retorno;
        String sql = "UPDATE jogador SET senha = ?, email = ?, imagem = ? WHERE login = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, jogador.getSenha());
            pst.setString(2, jogador.getEmail());
            pst.setString(3, jogador.getLogin());
            pst.setBytes(4, jogador.getImagem());
            pst.executeUpdate();
            retorno = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public Jogador login(Jogador jogador) {
        Jogador retorno = null;
        String sql = "SELECT * FROM jogador WHERE login = ? AND senha = ?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, jogador.getLogin());
            pst.setString(2, jogador.getSenha());

            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Jogador();
                retorno.setEmail(res.getString("email"));
                retorno.setLogin(res.getString("login"));
                retorno.setSenha(res.getString("senha"));
                retorno.setImagem(res.getBytes("imagem"));
            }
        } catch (Exception e) {
        }
        return retorno;
    }

    public Boolean consultar(String login) {
        List<Jogador> lista = new ArrayList<Jogador>();
        String sql = "SELECT * FROM JOGADOR";
        Boolean retorno = null;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Jogador jogador = new Jogador();
                jogador.setLogin(res.getString("login"));
                jogador.setSenha(res.getString("senha"));
                jogador.setEmail(res.getString("email"));
                jogador.setImagem(res.getBytes("imagem"));
                lista.add(jogador);
            }
            for (Jogador jogador : lista) {
                if (login.equals(jogador.getLogin())) {
                    retorno = true;
                    break;
                } else {
                    retorno = false;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
