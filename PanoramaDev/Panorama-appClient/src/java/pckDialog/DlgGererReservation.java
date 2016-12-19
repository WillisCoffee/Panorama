/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckDialog;

import ejb.ReserverLocauxFacadeRemote;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import panorama.ReservationTempo;
import pckEntites.ReserverLocaux;

/**
 *
 * @author clocal
 */
public class DlgGererReservation extends javax.swing.JDialog
{
    List<ReserverLocaux> lstReservation = new ArrayList<>();
    List<ReservationTempo> lstReservationTempo = new ArrayList<>();
    ReserverLocauxFacadeRemote _facadeReservation;
    public DlgGererReservation(java.awt.Frame parent, boolean modal,ReserverLocauxFacadeRemote facadeReservation) {
        super(parent, modal);
        _facadeReservation =  facadeReservation;
        remplirListe();
        initComponents();
    }
    private void remplirListe()
    {
        lstReservation.clear();
        lstReservationTempo.clear();
        lstReservation = _facadeReservation.findAll();
        for (ReserverLocaux reservation : lstReservation)
        {
            SimpleDateFormat format = new SimpleDateFormat("kk:mm");
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd",Locale.CANADA_FRENCH);
            Date dateReservation = reservation.getDateReservation();
            Date heureDebut = reservation.getHeureDebut();
            Date heureFin = reservation.getHeureFin();
            String local = reservation.getIdLocauxFK().toString();
            ReservationTempo unRes = new ReservationTempo(date.format(dateReservation),
                                                          format.format(heureDebut),
                                                          format.format(heureFin),
                                                          local,
                                                          reservation.getReserverA());
            lstReservationTempo.add(unRes);
        }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnFermer = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        pnlBoutons = new javax.swing.JPanel();
        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons1 = new javax.swing.JPanel();
        btnFermer1 = new javax.swing.JButton();
        btnSupprimer1 = new javax.swing.JButton();
        lblErreur = new javax.swing.JLabel();
        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();

        btnFermer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFermer.setMnemonic('f');
        btnFermer.setText("Fermer");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });

        btnSupprimer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSupprimer.setMnemonic('s');
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer les réservations");

        pnlBoutons.setLayout(new java.awt.BorderLayout());

        pnlBas.setPreferredSize(new java.awt.Dimension(350, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        btnFermer1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFermer1.setMnemonic('f');
        btnFermer1.setText("Fermer");
        btnFermer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermer1ActionPerformed(evt);
            }
        });
        pnlBoutons1.add(btnFermer1);

        btnSupprimer1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSupprimer1.setMnemonic('s');
        btnSupprimer1.setText("Supprimer");
        btnSupprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimer1ActionPerformed(evt);
            }
        });
        pnlBoutons1.add(btnSupprimer1);

        pnlBas.add(pnlBoutons1, java.awt.BorderLayout.PAGE_END);
        pnlBas.add(lblErreur, java.awt.BorderLayout.CENTER);

        pnlBoutons.add(pnlBas, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlBoutons, java.awt.BorderLayout.PAGE_END);

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTitre.setText("Réservations");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstReservationTempo}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblReservation);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateReservation}"));
        columnBinding.setColumnName("Date Reservation");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${heureDebut}"));
        columnBinding.setColumnName("Heure Debut");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${heureFin}"));
        columnBinding.setColumnName("Heure Fin");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${local}"));
        columnBinding.setColumnName("Local");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personne}"));
        columnBinding.setColumnName("Personne");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblReservation);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed

    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed

      
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnFermer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermer1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnFermer1ActionPerformed

    private void btnSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimer1ActionPerformed
        if(tblReservation.getSelectedRow() != -1)
        {
            ReserverLocaux unLocal = lstReservation.get(tblReservation.getSelectedRow());
            _facadeReservation.remove(unLocal);
            remplirListe();
            bindingGroup.unbind();
            bindingGroup.bind();

        }
        else
        {
            lblErreur.setText("Erreur, aucune réservation n'est sélectionnée.");
        }
    }//GEN-LAST:event_btnSupprimer1ActionPerformed
  
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
            java.util.logging.Logger.getLogger(DlgGererReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGererReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGererReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGererReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGererReservation dialog = new DlgGererReservation(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnFermer1;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JButton btnSupprimer1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErreur;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlBoutons1;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTable tblReservation;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public List<ReserverLocaux> getLstReservation() {
        return lstReservation;
    }

    public void setLstReservation(List<ReserverLocaux> lstReservation) {
        this.lstReservation = lstReservation;
    }

    public List<ReservationTempo> getLstReservationTempo() {
        return lstReservationTempo;
    }

    public void setLstReservationTempo(List<ReservationTempo> lstReservationTempo) {
        this.lstReservationTempo = lstReservationTempo;
    }

}