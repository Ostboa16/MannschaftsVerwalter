/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Spieler;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.MannschaftsVerwalterModel;

/**
 *
 * @author Boris
 */
public class MannschaftsVerwalterGUI extends javax.swing.JFrame {

    /**
     * Creates new form MannschaftsVerwalterGUI
     */
    private MannschaftsVerwalterModel model = new MannschaftsVerwalterModel();
    private AddPlayerDlg apd = new AddPlayerDlg(model);
    private RemovePlayerDlg rpd = new RemovePlayerDlg(model);

    public MannschaftsVerwalterGUI() {
        initComponents();
        table.setModel(model);
        table.setFillsViewportHeight(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        miImport = new javax.swing.JMenuItem();
        miExport = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Name", "Rückennummer", "Position"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu2.setText("File");

        miImport.setText("Import");
        miImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onImport(evt);
            }
        });
        jMenu2.add(miImport);

        miExport.setText("Export");
        miExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });
        jMenu2.add(miExport);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Mannschaft");

        miAdd.setText("Spieler hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdd(evt);
            }
        });
        jMenu3.add(miAdd);

        miRemove.setText("Spieler entfernen");
        miRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRemove(evt);
            }
        });
        jMenu3.add(miRemove);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAdd
        apd.setVisible(true); //Dialog öffnen
    }//GEN-LAST:event_onAdd

    private void onRemove(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRemove
        rpd.setVisible(true); //Dialog öffnen
    }//GEN-LAST:event_onRemove

    private void onImport(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onImport
        try {
            //FileChooser mit .bin Filter erzeugen
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Bin Datei", "bin");
            chooser.addChoosableFileFilter(filter);
            // Dialog zum Oeffnen von Dateien anzeigen
            chooser.showOpenDialog(null);
            File f = new File(chooser.getSelectedFile().getAbsolutePath());
            model.load(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_onImport

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        try {
            //FileChooser mit .bin Filter erzeugen
            JFileChooser chooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Bin Datei", "bin");
            chooser.addChoosableFileFilter(filter);
            // Dialog zum Oeffnen von Dateien anzeigen
            chooser.showOpenDialog(null);
            File f = new File(chooser.getSelectedFile().getAbsolutePath() + ".bin");
            model.save(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_onSave

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
            java.util.logging.Logger.getLogger(MannschaftsVerwalterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MannschaftsVerwalterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MannschaftsVerwalterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MannschaftsVerwalterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MannschaftsVerwalterGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miExport;
    private javax.swing.JMenuItem miImport;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
