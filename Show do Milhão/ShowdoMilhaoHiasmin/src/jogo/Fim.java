/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import dao.RankingDAO;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Audio;
import modelo.JogoCompleto;
import modelo.Ranking;

public class Fim extends javax.swing.JFrame {

    JogoCompleto completo;
    Audio audio = new Audio();

    /**
     * Creates new form Fim
     */
    public Fim() {
        initComponents();
        audio.tocar("sbt.wav");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblfim = new javax.swing.JLabel();
        jogarnovamente = new javax.swing.JButton();
        fotoshow = new javax.swing.JLabel();
        listagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        valor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblfim.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        lblfim.setForeground(new java.awt.Color(255, 0, 0));
        lblfim.setText("FIM DE JOGO");

        jogarnovamente.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jogarnovamente.setForeground(new java.awt.Color(255, 0, 0));
        jogarnovamente.setText("Jogar Novamente");
        jogarnovamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarnovamenteActionPerformed(evt);
            }
        });

        fotoshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/showimagem2.jpg"))); // NOI18N

        listagem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        listagem.setForeground(new java.awt.Color(255, 0, 0));

        tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(255, 0, 0));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login", "Pontos", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout listagemLayout = new javax.swing.GroupLayout(listagem);
        listagem.setLayout(listagemLayout);
        listagemLayout.setHorizontalGroup(
            listagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listagemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        listagemLayout.setVerticalGroup(
            listagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        valor.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        valor.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lblfim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jogarnovamente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(fotoshow, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(listagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(listagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(fotoshow)
                        .addGap(28, 28, 28)
                        .addComponent(lblfim)
                        .addGap(18, 18, 18)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jogarnovamente)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jogarnovamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogarnovamenteActionPerformed
        Login l = new Login();
        l.setVisible(true);
        audio.parar();
        this.setVisible(false);
    }//GEN-LAST:event_jogarnovamenteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (completo.getGanhos() == 0) {
            valor.setText("Você ganhou nada.");
        } else if (completo.getGanhos() == 1000000) {
            valor.setText("VOCÊ GANHOU R$ 1.000.000!!!");
        } else {
            valor.setText("Você ganhou R$: " + completo.getGanhos().toString() + ",00");
        }

        RankingDAO dao = new RankingDAO();

        Ranking ranking = new Ranking();
        ranking.setJogador(completo.getJogador());
        ranking.setPontos(completo.getGanhos());
        ranking.setData(new Date());
        dao.inserir(ranking);

        List<Ranking> lista = dao.listar();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        Object[] linha = new Object[modelo.getColumnCount()];

        for (Ranking ran : lista) {
            linha[0] = ran.getJogador().getLogin();
            linha[1] = ran.getPontos();
            linha[2] = ran.getData();
            modelo.addRow(linha);
        }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoshow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jogarnovamente;
    private javax.swing.JLabel lblfim;
    private javax.swing.JPanel listagem;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valor;
    // End of variables declaration//GEN-END:variables
}
