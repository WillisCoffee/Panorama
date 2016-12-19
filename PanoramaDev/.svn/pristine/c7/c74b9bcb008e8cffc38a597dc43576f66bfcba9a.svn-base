/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckDialog;

import ejb.CoursAnnuleFacadeRemote;
import ejb.EtudiantFacadeRemote;
import ejb.ListeEtudiantFacadeRemote;
import ejb.PlageHoraireFacadeRemote;
import ejb.ProfesseurFacadeRemote;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import pckEntites.Cours;
import pckEntites.CoursAnnule;
import pckEntites.Etudiant;
import pckEntites.ListeEtudiant;
import pckEntites.PlageHoraire;
import pckEntites.Professeur;
import pckFournisseur.FournisseurServices;
import pckValidation.Validation;
import static pckValidation.Validation.validerDate;
import static pckValidation.Validation.validerNombre;

/**
 *
 * @author clocal
 */
public class DlgAbsence extends javax.swing.JDialog {
    
    Etudiant etudiant;
    Professeur enseignant;
    
    EtudiantFacadeRemote facadeEtudiant;
    ListeEtudiantFacadeRemote facadeListeEtudiant;        
    ProfesseurFacadeRemote facadeEnseignant;
    PlageHoraireFacadeRemote facadePlageHoraire;
    FournisseurServices fournisseur;
    
    ListeEtudiant unListeEtudiant;    
    String personne;
    
    
    List<PlageHoraire> listePlage ;
    
    boolean isOk;

    public boolean isIsOk() 
    {
        return isOk;
    }
    
     private void ajouterListener()
    {
        cmbPlageHoraire.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                choisirPlage();
            }
        });
    }
    private void choisirPlage()
    {
         unListeEtudiant = facadeListeEtudiant.getListeEtudiantByidGroupeMatricule( //recherche selon le groupe et le matricule
                listePlage.get(cmbPlageHoraire.getSelectedIndex()).getIdGroupeFK(), //vas chercher le id du groupe
                etudiant); //vas chercher l'étudiant
                lblHeure.setText(unListeEtudiant.getHeuresAbsences().toString());
    }
    private void validerDates(String date)
    {
        if(!validerDate(date))
        {
        lblErreur.setText("La date n'est pas valide, entrer selon le format aaaa-mm-jj");
        txfDate.requestFocus();
        }
    }
    private void validerHeures(String heure)
    {
        if(!validerNombre(heure))
        {
            lblErreur.setText("L'heure n'est pas valide, entrer un nombre");
            txfNbrHeure.requestFocus();
        }
    }
            

    public void setIsOk(boolean isOk) 
    {
        this.isOk = isOk;
    }
    private void gererAbsenceEtudiant()
    {
        int nbHeure = Integer.parseInt(txfNbrHeure.getText());
        int nbHeureAbs = Integer.parseInt(lblHeure.getText());
        validerHeures(txfNbrHeure.getText());
        
        unListeEtudiant.setHeuresAbsences(nbHeure+nbHeureAbs);
        
    }
    private void gererAbsenceEnseignant()
    {
        String date = txfDate.getText();
        validerDates(date);
        CoursAnnuleFacadeRemote facadeCoursAnnule = fournisseur.obtenirCoursAnnuleFacade();
        if(Validation.validerDate(date))
        {
            PlageHoraire unPlage = listePlage.get(cmbPlageHoraire.getSelectedIndex());
            Cours unCours = unPlage.getIdGroupeFK().getIdCoursFK();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CANADA_FRENCH);
            try
            {
                Date unDate = format.parse(date);
                CoursAnnule coursAnnule = new CoursAnnule(unCours.getIdCoursPK(),unDate);
                coursAnnule.setIdHoraireFK(unPlage);
                facadeCoursAnnule.create(coursAnnule); 
            }
            catch(ParseException Px)
            {
                JOptionPane.showMessageDialog(this,"Erreur, entrer une date valide" +"(aaaa-mm-jj)");
            }
             
        }
    }
    

    /**
     * Creates new form DlgAbsence
     */
    public DlgAbsence(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
       
    }
    public DlgAbsence(java.awt.Frame parent, boolean modal,Etudiant unEtudiant,PlageHoraireFacadeRemote plageFacade,ListeEtudiantFacadeRemote listeEtudiantFacade)   
    {
        super(parent, modal);
 
        etudiant = unEtudiant;
        personne = "etudiant";
        facadeListeEtudiant = listeEtudiantFacade;
        facadePlageHoraire = plageFacade;
        listePlage = facadePlageHoraire.findPlageParMatricule(etudiant);
        initComponents();
        
        choisirPlage();
        
        ajouterListener();
        txfDate.setVisible(false);
        lblDate.setVisible(false);
    }
    public DlgAbsence(java.awt.Frame parent, boolean modal,Professeur unEnseignant,PlageHoraireFacadeRemote plageFacade,FournisseurServices fs) 
            
    {
        super(parent, modal);
        enseignant = unEnseignant;
        personne = "enseignant";
        facadePlageHoraire = plageFacade;
        listePlage = facadePlageHoraire.findPlageParNoEmploye(enseignant);
        fournisseur = fs;
        initComponents();
        ajouterListener();
        lblHeure.setVisible(false);
        lblHeureAbsence.setVisible(false);
        txfNbrHeure.setVisible(false);
        lblNbrHeure.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblHeureAbsence = new javax.swing.JLabel();
        lblHeure = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPlageHoraire = new javax.swing.JComboBox<>();
        lblNbrHeure = new javax.swing.JLabel();
        txfNbrHeure = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txfDate = new javax.swing.JTextField();
        lblErreur = new javax.swing.JLabel();
        pnlBas = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer les absences");

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Gérer absence");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        lblHeureAbsence.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblHeureAbsence.setText("Heure d'absence :");

        lblHeure.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblHeure.setText("0");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Plage horaire :");

        cmbPlageHoraire.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbPlageHoraire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plage horaire 1" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listePlage}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cmbPlageHoraire);
        bindingGroup.addBinding(jComboBoxBinding);

        lblNbrHeure.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNbrHeure.setText("Nombre d'heures :");

        txfNbrHeure.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblDate.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDate.setText("Date :");

        txfDate.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHeureAbsence)
                            .addComponent(jLabel3)
                            .addComponent(lblNbrHeure)
                            .addComponent(lblDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPlageHoraire, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHeure)
                            .addComponent(txfNbrHeure)
                            .addComponent(txfDate)))
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblErreur)))
                .addGap(51, 51, 51))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeureAbsence)
                    .addComponent(lblHeure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlageHoraire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNbrHeure)
                    .addComponent(txfNbrHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblErreur))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setPreferredSize(new java.awt.Dimension(400, 32));

        btnAccepter.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAccepter.setMnemonic('a');
        btnAccepter.setText("Accepter");
        btnAccepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccepterActionPerformed(evt);
            }
        });
        pnlBas.add(btnAccepter);

        btnAnnuler.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAnnuler.setMnemonic('n');
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        pnlBas.add(btnAnnuler);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
        if(personne.equals("etudiant"))
        {
            gererAbsenceEtudiant();
        }
        else if(personne.equals("enseignant"))
        {
            gererAbsenceEnseignant();
        }
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(DlgAbsence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgAbsence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgAbsence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgAbsence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgAbsence dialog = new DlgAbsence(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JComboBox<String> cmbPlageHoraire;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblErreur;
    private javax.swing.JLabel lblHeure;
    private javax.swing.JLabel lblHeureAbsence;
    private javax.swing.JLabel lblNbrHeure;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTextField txfDate;
    private javax.swing.JTextField txfNbrHeure;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public List<PlageHoraire> getListePlage() {
        return listePlage;
    }

    public void setListePlage(List<PlageHoraire> listePlage) {
        this.listePlage = listePlage;
    }

}
