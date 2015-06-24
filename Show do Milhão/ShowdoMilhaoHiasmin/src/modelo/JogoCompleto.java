
package modelo;

public class JogoCompleto {
    private Jogador jogador;
    private Integer pular;
    private Integer cartas;
    private Integer ganhos; 
    
    public JogoCompleto()
    {
        this.jogador = null;
        this.cartas = 1;
        this.ganhos = 0;
        this.pular = 1;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Integer getPular() {
        return pular;
    }

    public void setPular(Integer pular) {
        this.pular = pular;
    }

    public Integer getCartas() {
        return cartas;
    }

    public void setCartas(Integer cartas) {
        this.cartas = cartas;
    }

    public Integer getGanhos() {
        return ganhos;
    }

    public void setGanhos(Integer ganhos) {
        this.ganhos = ganhos;
    }
 
}
