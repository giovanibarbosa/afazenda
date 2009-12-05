/*
 * To change this template, choose Tools | Templates.
 * and open the template in the editor.
 */

/*
 * GerenciarRebanhos.java
 *
 * Created on 08/11/2009, 22:31:08
 */

package projeto.gui;
import projeto.bd.RebanhoDAO;
import projeto.afazenda.Rebanho;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
public class GerenciarRebanhos extends javax.swing.JFrame {

    Main menu;
    RebanhoDAO rebanhoDAO = new RebanhoDAO();
    CrudVacas crudVacas = new CrudVacas(this, false);
    
    

    /** Creates new form GerenciarRebanhos */
    public GerenciarRebanhos(Main menu, boolean visivel) {
        setBounds(new java.awt.Rectangle(300, 200, 600, 600));
        setTitle("A Fazenda - Gerenciar Rebanhos");
        setResizable(false);
        this.menu = menu;
        initComponents();
        for(Rebanho reb: rebanhoDAO.getTodosRebanhos()) {
            listaRebanhos.addItem("" + reb.getID() + " - " + reb.getNome());
        }
        
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
        listaRebanhos = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Gerenciar Rebanhos");

        jLabel2.setText("Rebanho:");

        jButton1.setText("Gerenciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(listaRebanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(53, Short.MAX_VALUE))
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
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
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
    	
    }
//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (listaRebanhos.getSelectedItem().toString() != null) {
            this.crudVacas.jLabel3.setText(listaRebanhos.getSelectedItem().toString());
            int indice = listaRebanhos.getSelectedIndex();
            //mini-gambiarra para evitar que indice seja -1 ;D
            if (indice == -1) {
                indice = 0;
            }
            crudVacas.setRebanhoID(getRebanhoID(indice));
            crudVacas.delVaca.atualizarListaVacas(crudVacas.rebanhoID);
            
        }

    setVisible(false);
    crudVacas.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int getRebanhoID(int indice){
        List<Rebanho> listaRebanhosTemp = rebanhoDAO.getTodosRebanhos();
        int rebanhoID = listaRebanhosTemp.get(indice).getID();
        return rebanhoID;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox listaRebanhos;
    // End of variables declaration//GEN-END:variables

}