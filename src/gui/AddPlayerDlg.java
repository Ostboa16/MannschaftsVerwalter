/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Spieler;
import db.AccessDB;
import javax.swing.JOptionPane;
import model.MannschaftsVerwalterModel;

/**
 *
 * @author Boris
 */
public class AddPlayerDlg extends javax.swing.JDialog {

    /**
     * Creates new form AddPlayerDlg
     */
    private boolean kaptExists = false;
    MannschaftsVerwalterModel model = new MannschaftsVerwalterModel();

    public AddPlayerDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public AddPlayerDlg(MannschaftsVerwalterModel model) {
        this.model = model;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spNumber = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cbPosition = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        chKap = new javax.swing.JCheckBox();
        btAdd = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1);
        jPanel1.add(tfName);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Rückennummer");
        jPanel1.add(jLabel2);

        spNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jPanel1.add(spNumber);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Position:");
        jPanel1.add(jLabel3);

        cbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stürmer", "Mittelfeld", "Verteidiger", "Torwart" }));
        jPanel1.add(cbPosition);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Kapitän?");
        jPanel1.add(jLabel4);

        chKap.setText("Ja");
        jPanel1.add(chKap);

        btAdd.setText("Hinzufügen");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdd(evt);
            }
        });
        jPanel1.add(btAdd);

        btCancel.setText("Abbrechen");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        jPanel1.add(btCancel);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        this.setVisible(false); //Dialog schließen
    }//GEN-LAST:event_onCancel

    private void onAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAdd
        try {
            if (tfName.getText().equals("")) { //Überprüfen ob das Textfeld leer ist oder nicht
                throw new Exception("Bitte Namen für den Spieler eingeben!"); 
            }
            if (chKap.isSelected() && kaptExists == false) { //Überprüfen ob es schon einen Kapitän gibt
                model.add(new Spieler("[K] " + tfName.getText(), Integer.parseInt(spNumber.getValue().toString()), cbPosition.getSelectedItem().toString()));
                kaptExists = true;
            }
            else if(kaptExists == true && chKap.isSelected()){ //Überprüfen ob es schon einen Kapitän gibt
                throw new Exception("Es gibt bereits einen Kapitän!");
            }
            else{ //Wenn kein if erfüllt ist kommt es hier hin und erstellt den Spieler normal
                model.add(new Spieler(tfName.getText(), Integer.parseInt(spNumber.getValue().toString()), cbPosition.getSelectedItem().toString()));
            }
            //Alles Felder wieder zurücksetzen
            tfName.setText("");
            spNumber.setValue(1);
            cbPosition.setSelectedIndex(0);
            //Dialog schließen
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_onAdd

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
            java.util.logging.Logger.getLogger(AddPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayerDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddPlayerDlg dialog = new AddPlayerDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JComboBox<String> cbPosition;
    private javax.swing.JCheckBox chKap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spNumber;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}