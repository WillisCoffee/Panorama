package pckDialog;

import ejb.EvaluationFacadeRemote;
import ejb.ListeEtudiantFacadeRemote;
import ejb.NoteFacadeRemote;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;
import pckEntites.Etudiant;
import pckEntites.Evaluation;
import pckEntites.ListeEtudiant;
import pckEntites.Note;
import pckImpressions.Impression;

public class DlgResultat2 extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="Variables">
        //La variable
    private Etudiant unEtudiant;
        //Liste
    List<ResultatCours> lstResultats = ObservableCollections.observableList(new ArrayList<>());
    
        //Facade
    NoteFacadeRemote facadeNote;
    ListeEtudiantFacadeRemote facadeListeEtudiant;
    EvaluationFacadeRemote facadeEvaluation;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgResultat2(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public DlgResultat2(java.awt.Frame parent, boolean modal, Etudiant leEtudiant, 
                                                    NoteFacadeRemote nf,
                                                    ListeEtudiantFacadeRemote lsf,
                                                    EvaluationFacadeRemote ef)
    {
        super(parent, modal);
        unEtudiant = leEtudiant;
        facadeNote = nf;
        facadeListeEtudiant = lsf;
        facadeEvaluation = ef;
        
        initComponents();
        obtenirResultatCours();

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public Etudiant getUnEtudiant() 
    {
        return unEtudiant;
    }

    public void setUnEtudiant(Etudiant unEtudiant) 
    {
        this.unEtudiant = unEtudiant;
    }

    public List<ResultatCours> getLstResultats() 
    {
        return lstResultats;
    }

    public void setLstResultats(List<ResultatCours> lstResultats) {
        lstResultats = lstResultats;
    }
    
   //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlBoutons = new javax.swing.JPanel();
        btnFermer = new javax.swing.JButton();
        btnImprimer = new javax.swing.JButton();
        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblMatricule = new javax.swing.JLabel();
        lblPrenom = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        lblLibelleprenom = new javax.swing.JLabel();
        lblLibelleNom = new javax.swing.JLabel();
        lblLibelleMatricule = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Résultats d'un élève");

        btnFermer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFermer.setMnemonic('f');
        btnFermer.setText("Fermer");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnFermer);

        btnImprimer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnImprimer.setMnemonic('i');
        btnImprimer.setText("Imprimer");
        btnImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnImprimer);

        getContentPane().add(pnlBoutons, java.awt.BorderLayout.PAGE_END);

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Résultats");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        lblMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.matriculePK}"), lblMatricule, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.idUtilisateurFK.prenom}"), lblPrenom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${unEtudiant.idUtilisateurFK.nom}"), lblNom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblLibelleprenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLibelleprenom.setText("Prénom :");

        lblLibelleNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLibelleNom.setText("Nom :");

        lblLibelleMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLibelleMatricule.setText("Matricule :");

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenuLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLibelleNom)
                                    .addComponent(lblLibelleprenom))
                                .addGap(18, 18, 18)
                                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrenom)
                                    .addComponent(lblNom)))
                            .addGroup(pnlContenuLayout.createSequentialGroup()
                                .addComponent(lblLibelleMatricule)
                                .addGap(18, 18, 18)
                                .addComponent(lblMatricule)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibelleprenom)
                    .addComponent(lblPrenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibelleNom)
                    .addComponent(lblNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibelleMatricule)
                    .addComponent(lblMatricule))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimerActionPerformed
        Impression uneImpression = new Impression();
        uneImpression.afficherRappBulletin(unEtudiant.getMatriculePK()); //Kathy Landry
    }//GEN-LAST:event_btnImprimerActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Opérations">
    private void obtenirResultatCours()
    {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Cours");
        dtm.addColumn("Note");
        dtm.addColumn("Moyenne");
        dtm.addColumn("Session");
        jTable1.setModel(dtm);

        //Trouve la liste des cours d'un étudiant
        List<ListeEtudiant> lstListeEtudiant = facadeListeEtudiant.getListeEtudiantByMatricule(unEtudiant);

        for (ListeEtudiant e : lstListeEtudiant)
        {
            //Listes des notes et évaluations pour un cours
            List<Note> lstNotes = new ArrayList<>();
            List<Evaluation> lstEval = new ArrayList<>();
            double result = 0.00;
            double resultTotal = 0.00;
            double moyenne = 0.00;
            double moyenneCours = 0.00;
            
            //Cherche toutes les notes de l'etudiant pour calculer ses moyennes
            String session = e.getIdGroupeFK().getIdSessionFK().getCodeSession();
            lstNotes = facadeNote.getNoteByMatricule(unEtudiant, e.getIdGroupeFK());
            for (Note n : lstNotes)
            {
                result += n.getPointsObtenus().doubleValue();
                resultTotal += n.getIdEvaluationFK().getNombrePoints().doubleValue();
            }
            
            //Cherche toutes les evaluations pour calculer la moyenne du groupe
            lstEval = facadeEvaluation.getEvalByGroupe(e.getIdGroupeFK());
            int nbrEval = 0;
            for (Evaluation eval : lstEval)
            {
                moyenne += eval.getMoyenne().doubleValue();
                nbrEval++;
            }
            //Moyenne de groupe
            if (nbrEval != 0)
                moyenne = moyenne/nbrEval;
            
            //Moyenne de l'etudiant
            if (resultTotal != 0)
                moyenneCours = (result * 100) / resultTotal;
            
            //Formateur
            DecimalFormat dec = new DecimalFormat("#.##");
            
            //Création d'un objet Resultat
            lstResultats.add(new ResultatCours(e.getIdGroupeFK().getIdCoursFK().getNomCours()));
            
            //Ajout de la donnée dans le jtable
            dtm.addRow(new Object[]{e.getIdGroupeFK().getIdCoursFK().getNomCours(), dec.format(moyenneCours) + "%", dec.format(moyenne) + "%", session});
        }
        //Obtenir ListeEtudiant selon UNE matricule?

        //Obtenir Evaluations D'UN groupe?
        
        //Obtenir Notes des Evaluations D'UN cours?
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="Classe">
    public class ResultatCours implements Serializable
    {
        private float _moyenneGroupe;
        private String _nomCours;
        private float _moyenneEtudiant;
        private String _session;
        
        public ResultatCours(String nomCours)
        {
             _moyenneGroupe = 0;
            _nomCours = nomCours;
            _moyenneEtudiant = 0;
            _session = "hiver";
        }
        
        public ResultatCours(float moyenneGroupe, String nomCours, float moyenneEtudiant, String session)
        {
            _moyenneGroupe = moyenneGroupe;
            _nomCours = nomCours;
            _moyenneEtudiant = moyenneEtudiant;
            _session = session;
        }

        public float getMoyenneGroupe() {
            return _moyenneGroupe;
        }

        public void setMoyenneGroupe(float _moyenneGroupe) {
            this._moyenneGroupe = _moyenneGroupe;
        }

        public String getNomCours() {
            return _nomCours;
        }

        public void setNomCours(String _nomCours) {
            this._nomCours = _nomCours;
        }

        public float getMoyenneEtudiant() {
            return _moyenneEtudiant;
        }

        public void setMoyenneEtudiant(float _moyenneEtudiant) {
            this._moyenneEtudiant = _moyenneEtudiant;
        }

        public String getSession() {
            return _session;
        }

        public void setSession(String _session) {
            this._session = _session;
        }
        
        
    }
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
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
            java.util.logging.Logger.getLogger(DlgResultat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgResultat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgResultat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgResultat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgResultat2 dialog = new DlgResultat2(new javax.swing.JFrame(), true);
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Composants">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnImprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLibelleMatricule;
    private javax.swing.JLabel lblLibelleNom;
    private javax.swing.JLabel lblLibelleprenom;
    private javax.swing.JLabel lblMatricule;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlTitre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
    //</editor-fold>