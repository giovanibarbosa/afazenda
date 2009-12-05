/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeletarVaca.java
 *
 * Created on 04/12/2009, 02:16:38
 */

package projeto.gui;

import java.util.List;

import projeto.afazenda.Rebanho;
import projeto.afazenda.Vaca;
import projeto.bd.VacasDAO;
/**
 *
 * @author Rodolfo
 */
public class DeletarVaca extends javax.swing.JFrame {
    VacasDAO vacasDAO = new VacasDAO();
    
    CrudVacas crudVacas;
    /** Creates new form DeletarVaca */
    public DeletarVaca(CrudVacas crudVacas, boolean visivel) {
        this.crudVacas = crudVacas;
        setVisible(visivel);
        setBounds(new java.awt.Rectangle(300, 180, 600, 600));
        setResizable(false);
        setTitle("A Fazenda - CRUD Vacas - Remover Vacas");
        initComponents();
        atualizarListaVacas(crudVacas.rebanhoID);
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
        listaVacas = new javax.swing.JComboBox();
        deletar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        mensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Deletar Vaca");
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel2.setText("Vaca:");
        jLabel2.setName("jLabel2"); // NOI18N

        listaVacas.setName("listaVacas"); // NOI18N

        deletar.setText("Deletar");
        deletar.setName("deletar"); // NOI18N
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.setName("voltar"); // NOI18N
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        mensagem.setForeground(new java.awt.Color(255, 0, 0));
        mensagem.setText("Vaca deletada com sucesso!");
        mensagem.setName("mensagem"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaVacas, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(mensagem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listaVacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletar)
                    .addComponent(voltar))
                .addGap(18, 18, 18)
                .addComponent(mensagem)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        setVisible(false);
        crudVacas.setVisible(true);
}//GEN-LAST:event_voltarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
    	if (listaVacas.getSelectedItem().toString() != null) {

            int indice = listaVacas.getSelectedIndex();
            //mini-gambiarra para evitar que indice seja -1 ;D
            if (indice == -1) {
                indice = 0;
            }

            List<Vaca> listaVacasTemp = vacasDAO.getTodasVacas(crudVacas.rebanhoID);
            int vacaID = listaVacasTemp.get(indice).getID();

            vacasDAO.removeVaca(vacaID);
            this.atualizarListaVacas(crudVacas.rebanhoID);

            mensagem.setVisible(true);
//            crudVacas.setVisible(true);
        }
    	
    	
}//GEN-LAST:event_deletarActionPerformed
    
    public void atualizarListaVacas(int rebanhoID) {
        listaVacas.removeAllItems();
        for(Vaca vaca : vacasDAO.getTodasVacas(crudVacas.rebanhoID)) {
            listaVacas.addItem("" + vaca.getID() + " - " + vaca.getNome());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox listaVacas;
    javax.swing.JLabel mensagem;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}