/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VacinarVacas.java
 *
 * Created on 08/11/2009, 22:44:52
 */

package projeto.gui;

import projeto.afazenda.Rebanho;
import projeto.bd.RebanhoDAO;
import projeto.bd.VacasDAO;
import projeto.afazenda.Vaca;
import projeto.afazenda.Rebanho;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
public class VacinarVacas extends javax.swing.JFrame {

    Main menu;
    RebanhoDAO rebanhoDAO = new RebanhoDAO();
    VacasDAO vacasDAO = new VacasDAO();
    /** Creates new form VacinarVacas */
    public VacinarVacas(Main menu, boolean visivel) {
        this.menu = menu;
        setVisible(visivel);
        setBounds(new java.awt.Rectangle(300,200, 600, 600));
        initComponents();
        mensagemConfirmacao.setVisible(false);
        atualizarListaRebanhos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        listaRebanhos = new javax.swing.JComboBox();
        listaVacas = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mensagemConfirmacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Fazenda - Vacinar Vacas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Vacinar Vacas");

        jLabel2.setText("Selecionar rebanho:");

        jLabel3.setText("Selecionar Vaca:");

        listaRebanhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaRebanhosActionPerformed(evt);
            }
        });

        jButton1.setText("Vacinar");
        
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mensagemConfirmacao.setForeground(new java.awt.Color(255, 0, 51));
        mensagemConfirmacao.setText("Vaca Raquelendar vacinada com sucesso!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listaVacas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listaRebanhos, 0, 157, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(mensagemConfirmacao)
                .addGap(68, 68, 68))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listaRebanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(listaVacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(mensagemConfirmacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        menu.setVisible(true);
    }

    public void atualizarListaRebanhos() {
     	listaRebanhos.removeAllItems();
       	for(Rebanho reb: rebanhoDAO.getTodosRebanhos()) {
            listaRebanhos.addItem("" + reb.getID() + " - " + reb.getNome());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void atualizaListaVacas(int rebanhoID) {
        listaVacas.removeAllItems();
        for(Vaca vaca : vacasDAO.getTodasVacas(rebanhoID)) {
            listaVacas.addItem("" + vaca.getID() + " - " + vaca.getNome());
        }
    }

    private void listaRebanhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaRebanhosActionPerformed
        int indice = listaRebanhos.getSelectedIndex();
        //mini-gambiarra para evitar que indice seja -1 ;D
        if (indice == -1) {
        	indice = 0;
        }
        List<Rebanho> listaRebanhosTemp = rebanhoDAO.getTodosRebanhos();
        int rebanhoID = listaRebanhosTemp.get(indice).getID();
        atualizaListaVacas(rebanhoID);
    }//GEN-LAST:event_listaRebanhosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox listaRebanhos;
    private javax.swing.JComboBox listaVacas;
    private javax.swing.JLabel mensagemConfirmacao;
    // End of variables declaration//GEN-END:variables

}
