
/*
 * CadastrarRebanho.java.
 *
 * Created on 08/11/2009, 10:34:07
 */

package projeto.gui;

import projeto.afazenda.Rebanho;
import projeto.bd.RebanhoDAO;
/**
 *
 * @author Rodolfo
 */
public class CadastrarRebanho extends javax.swing.JFrame {

    Main menu;
    Rebanho reb = new Rebanho("");
    RebanhoDAO rebDAO = new RebanhoDAO();
    /** Creates new form CadastrarRebanho */
    public CadastrarRebanho(Main menu, boolean visivel) {
        this.menu = menu;
        setBounds(new java.awt.Rectangle(350, 180, 600, 600));
        setVisible(visivel);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        campoNomeRebanho = new javax.swing.JTextField();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Fazenda - Cadastrar Rebanho");
        setBounds(new java.awt.Rectangle(300, 200, 300, 300));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Cadastrar Rebanho");

        jLabel2.setText("Nome:");

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(133, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeRebanho, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(confirmar)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addContainerGap(115, Short.MAX_VALUE))
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
                    .addComponent(campoNomeRebanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar)
                    .addComponent(cancelar))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        campoNomeRebanho.setText("");
        setVisible(false);
        menu.setVisible(true);
    }

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {
        reb.setNome(campoNomeRebanho.getText());
        rebDAO.insereRebanho(reb);
        atualizarListasNasOutrasTelas();
        campoNomeRebanho.setText("");
        setVisible(false);
        menu.setVisible(true);
    }
    
    private void atualizarListasNasOutrasTelas() {
    	 menu.gerenciadorDeRebanhos.atualizarListaRebanhos();
    	 int rebanhoID = rebDAO.getTodosRebanhos().get(rebDAO.getTodosRebanhos().size() - 1).getID();
    	 menu.vacinadorDeVacas.atualizarListaRebanhos();
    	 menu.vacinadorDeVacas.atualizaListaVacas(rebanhoID);
    	 menu.telaCoberturaDeVacas.inseminador.atualizarListaRebanhos();
    	 menu.telaCoberturaDeVacas.inseminador.atualizarListaVacas(rebanhoID);
    	 menu.menuTiragens.menuNovaTiragem.atualizarListaRebanhos();
    	 menu.menuTiragens.menuNovaTiragem.atualizarListaVacas(rebanhoID);
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField campoNomeRebanho;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration

}
