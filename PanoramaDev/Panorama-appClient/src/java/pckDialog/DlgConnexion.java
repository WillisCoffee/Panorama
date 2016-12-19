/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckDialog;

import ejb.PersonnelSoutienFacadeRemote;
import java.awt.Component;
import java.awt.Container;
import javax.swing.AbstractButton;
import javax.swing.JRootPane;
import pckEntites.PersonnelSoutien;
import pckEntites.Utilisateur;
import pckFournisseur.FournisseurServices;

/**
 *
 * @author clocal
 */
public class DlgConnexion extends javax.swing.JDialog {

    FournisseurServices leFournisseurService;
    private int giPersonneConnecter = 0;
    //0 : Personne non autorisé
    //1 : Personne du registraire
    //2 : API
    //3 : Employe ressource humaine 
    //4 : Adminitrateur

    public int getGiPersonneConnecter() {
        return giPersonneConnecter;
    }

    public void setGiPersonneConnecter(int giPersonneConnecter) {
        this.giPersonneConnecter = giPersonneConnecter;
    }

    public DlgConnexion(java.awt.Frame parent, boolean modal, FournisseurServices pFournisseurSer) {
        super(parent, modal);
        leFournisseurService = pFournisseurSer;
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        removeMinMaxCloseButton(this);
        initComponents();
        setLocationRelativeTo(null);
        lblMessage.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBas = new javax.swing.JPanel();
        pnlBoutons = new javax.swing.JPanel();
        btnConnexion = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlTitre = new javax.swing.JPanel();
        lblConnexion = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        txfPassword = new javax.swing.JPasswordField();
        txfLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connexion à Panorama");
        setMinimumSize(new java.awt.Dimension(350, 220));
        setResizable(false);

        pnlBas.setLayout(new java.awt.BorderLayout());

        btnConnexion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConnexion.setMnemonic('C');
        btnConnexion.setText("Connexion");
        btnConnexion.setPreferredSize(new java.awt.Dimension(105, 23));
        btnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnexionActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnConnexion);

        btnAnnuler.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAnnuler.setMnemonic('A');
        btnAnnuler.setText("Annuler");
        btnAnnuler.setPreferredSize(new java.awt.Dimension(95, 23));
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnAnnuler);

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.CENTER);

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMessage.setText("Veuillez entrer un nom d'utilisateur valide");
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        lblConnexion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblConnexion.setText("Connexion");
        pnlTitre.add(lblConnexion);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        pnlContenu.setPreferredSize(new java.awt.Dimension(500, 150));

        lblLogin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblLogin.setText("Nom d'usager :");

        txfPassword.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfPassword.setPreferredSize(new java.awt.Dimension(150, 20));

        txfLogin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfLogin.setPreferredSize(new java.awt.Dimension(150, 20));

        lblPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPassword.setText("Mot de passe :");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pckIcons/logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogin)
                            .addComponent(txfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnexionActionPerformed
        boolean lbConnection = true;
        if (txfLogin.getText().length() > 0) {
            if (txfPassword.getPassword().length > 0) {
                try {
                    PersonnelSoutienFacadeRemote persSoutienFacRemote = leFournisseurService.obtenirFacadePersonnelSoutien();
                    PersonnelSoutien unPersonnel = persSoutienFacRemote.rechercherPersonnelConnecter(txfLogin.getText());
                    String poste = unPersonnel.getFonction();
                    Utilisateur unUtilisateur = unPersonnel.getIdUtilisateurFK();
                    StringBuilder motpasse = new StringBuilder();
                    char[] tblMotPasse = txfPassword.getPassword();
                    for (int indice = 0; indice < tblMotPasse.length; indice++) {
                        motpasse.append(tblMotPasse[indice]);
                    }
                    String chaineMotPasse = motpasse.toString();
                    int liMotPasseCompare = chaineMotPasse.compareTo(unUtilisateur.getMotPasse());
                    if (liMotPasseCompare == 0) {
                        int liAPI = poste.compareTo("API");
                        int liBuRegistraire = poste.compareTo("Bureau du registraire");
                        int liRessourceHumaine = poste.compareTo("Ressources humaines");
                        int administrateur = poste.compareTo("Adminstrateur");
                        if (liAPI == 0)// il s'agit d'un membre API
                        {
                            giPersonneConnecter = 2;
                            this.setVisible(false);
                        } else if (liBuRegistraire == 0)// il s'agit d'un employé du bureau du régistraire
                        {
                            giPersonneConnecter = 1;
                            this.setVisible(false);
                        } else if (liRessourceHumaine == 0)// il s'agit d'un membre des ressources humaines
                        {
                            giPersonneConnecter = 3;

                            this.setVisible(false);
                        } else if (administrateur == 0)// il s'agit d'un administrateur
                        {
                            giPersonneConnecter = 4;
                            this.setVisible(false);
                        } else // Le numéro n'est pas trouver
                        {
                            giPersonneConnecter = 0;
                            lblMessage.setText("Le login que l'usage a entré n'est pas autorisé");
                            txfLogin.setText("");
                            txfPassword.setText("");
                            txfLogin.requestFocus();
                        }
                    } else {
                        lblMessage.setText("Le mot de passe entré n'est pas correcte.");
                    }

                } catch (Exception e) {
                    lblMessage.setText("Le login entrer n'est pas valide");
                    txfLogin.setText("");
                    txfPassword.setText("");
                    txfLogin.requestFocus();
                }
            } else {
                lblMessage.setText("Veuillez inscrire votre mot de passe");
                txfPassword.requestFocus();
            }
        } else {
            lblMessage.setText("Veuillez inscrire votre identifiant");
            txfLogin.requestFocus();
        }
    }//GEN-LAST:event_btnConnexionActionPerformed

    private void removeMinMaxCloseButton(Component comp) {
        if (comp instanceof AbstractButton) {
            comp.getParent().remove(comp);
        }
        if (comp instanceof Container) {
            Component[] comps = ((Container) comp).getComponents();
            for (int x = 0, y = comps.length; x < y; x++) {
                removeMinMaxCloseButton(comps[x]);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(DlgConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConnexion dialog = new DlgConnexion(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnConnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblConnexion;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTextField txfLogin;
    private javax.swing.JPasswordField txfPassword;
    // End of variables declaration//GEN-END:variables

    private PersonnelSoutien InitialContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}