package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ranking;
 
public class RankingDAO {

    public Boolean inserir(Ranking ranking) {
        Boolean retorno;
        String sql = "INSERT INTO ranking(login, pontos, data) VALUES (?,?,?)";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, ranking.getJogador().getLogin());
            pst.setInt(2, ranking.getPontos());
            pst.setDate(3, new Date(ranking.getData().getTime()));
            pst.executeUpdate();
            retorno = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public List<Ranking> listar() {
        List<Ranking> lista = new ArrayList<Ranking>();
        String sql = "SELECT * FROM ranking ORDER BY pontos DESC LIMIT 10";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Ranking ranking = new Ranking();
                ranking.getJogador().setLogin(res.getString("login"));
                ranking.setPontos(res.getInt("pontos"));
                ranking.setData(res.getDate("data"));
                //outro jeito
                //Jogador jog = new Jogador():
                //jog.setLogin(res.getString("login");
                //ranking.setJogador(jog);
                lista.add(ranking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RankingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
