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

    public Boolean inserir(Jogador jogador) 
    {
        Boolean retorno;
        //Monta o SQL de INSERT na tabela
        String sql = "INSERT INTO jogador (login, senha, email) VALUES(?,?,?)";
        //Prepara a conexão do meu SQL
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            //Insere os parametos
            pst.setString(1, jogador.getLogin());
            pst.setString(2, jogador.getSenha());
            pst.setString(3, jogador.getEmail());
            //Executa o SQL no Banco de Dados
            pst.executeUpdate();
            retorno = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
    
    public List<Jogador> listar()
    {
        //Cria a lista de jogadores
        List<Jogador> lista = new ArrayList<Jogador>();
        String sql = "SELECT * FROM JOGADOR";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try 
        {
            //Executo o SQL e jogo em um resultSet
            ResultSet res = pst.executeQuery();
            //Enquanto tiver registro eu vou relacionar com minha classe jogador e add na lista
            while(res.next())
            {
                Jogador jogador = new Jogador();
                jogador.setLogin(res.getString("login"));
                jogador.setSenha(res.getString("senha"));
                jogador.setEmail(res.getString("email"));
                lista.add(jogador);
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public Boolean excluir(Jogador jogador) {
        Boolean retorno;
        
        String sql = "DELETE FROM jogador WHERE login = ?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try{
            pst.setString(1, jogador.getLogin());
            pst.executeUpdate();
            retorno = true;
        }
        
        catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        
        return retorno;
    }
}
