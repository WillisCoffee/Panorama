package pckDialog;

// William Thibodeau.
import ejb.EtudiantFacadeRemote;
import ejb.ListeEtudiantFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import panorama.EtudiantTempo;
import pckEntites.Etudiant;
import pckEntites.Groupe;
import pckEntites.ListeEtudiant;
import pckFournisseur.FournisseurServices;
import pckImpressions.Impression;

//Fenêtre permettant la gestion d'étudiant dans un groupe
public class DlgGererGroupe2 extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="Variables">
    Groupe unGroupe;
    
    EtudiantFacadeRemote facadeEtudiant;
    //Facade pour la liste d'étudiants
    ListeEtudiantFacadeRemote facadeListeEtudiant;
    //Liste d'étudiant du groupe
    List<ListeEtudiant> lstListeEtudiant;
    //Liste d'étudiant du groupe temporaire pour l'affichage
    List<EtudiantTempo> lstEtudiantTempo = ObservableCollections.observableList(new ArrayList<EtudiantTempo>());
    //Liste d'étudiant provenant de la recherche
    List<Etudiant> lstEtudiantRecherche = new ArrayList<>();;
    //Liste d'étudiant temporaire provenant de la recherche
    List<EtudiantTempo> lstEtudiantRechercheTempo = ObservableCollections.observableList(new ArrayList<EtudiantTempo>());
    //</editor-fold>
  
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgGererGroupe2(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public DlgGererGroupe2(java.awt.Frame parent, boolean modal, Groupe leGroupe,
                                                        EtudiantFacadeRemote fe,
                                                        FournisseurServices fs)
    {
        super(parent, modal);
        unGroupe = leGroupe;
        facadeEtudiant = fe;
        facadeListeEtudiant = fs.obtenirListeEtudiantFacade();
        lstListeEtudiant = facadeListeEtudiant.getListeEtudiant(leGroupe);
  
        initialiserChamps();
        initComponents();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public List<EtudiantTempo> getLstEtudiantTempo() {
        return lstEtudiantTempo;
    }

    public void setLstEtudiantTempo(List<EtudiantTempo> lstEtudiantTempo) {
        this.lstEtudiantTempo = lstEtudiantTempo;
    }

    public List<ListeEtudiant> getLstListeEtudiant() {
        return lstListeEtudiant;
    }

    public void setLstListeEtudiant(List<ListeEtudiant> lstListeEtudiant) {
        this.lstListeEtudiant = lstListeEtudiant;
    }

    public List<EtudiantTempo> getLstEtudiantRechercheTempo() {
        return lstEtudiantRechercheTempo;
    }

    public void setLstEtudiantRechercheTempo(List<EtudiantTempo> lstEtudiantRechercheTempo) {
        this.lstEtudiantRechercheTempo = lstEtudiantRechercheTempo;
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons = new javax.swing.JPanel();
        btnImprimer = new javax.swing.JButton();
        btnSupprimerEtudiantGroupe = new javax.swing.JButton();
        btnFermer = new javax.swing.JButton();
        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEtudiant = new javax.swing.JTable();
        btnAjouter = new javax.swing.JButton();
        btnRechercher = new javax.swing.JButton();
        txfPrenom = new javax.swing.JTextField();
        lblPrenom = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        txfNom = new javax.swing.JTextField();
        txfMatricule = new javax.swing.JTextField();
        lblMatricule = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEtudiantRecherche = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer un groupe");

        pnlBas.setPreferredSize(new java.awt.Dimension(0, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        btnImprimer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnImprimer.setMnemonic('i');
        btnImprimer.setText("Imprimer");
        btnImprimer.setMaximumSize(new java.awt.Dimension(81, 23));
        btnImprimer.setMinimumSize(new java.awt.Dimension(81, 23));
        btnImprimer.setPreferredSize(new java.awt.Dimension(90, 23));
        btnImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnImprimer);

        btnSupprimerEtudiantGroupe.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSupprimerEtudiantGroupe.setMnemonic('s');
        btnSupprimerEtudiantGroupe.setText("Supprimer");
        btnSupprimerEtudiantGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerEtudiantGroupeActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnSupprimerEtudiantGroupe);

        btnFermer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnFermer.setMnemonic('f');
        btnFermer.setText("Fermer");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnFermer);

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Gérer groupe");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        tblEtudiant.setColumnSelectionAllowed(true);
        tblEtudiant.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstEtudiantTempo}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblEtudiant);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codePermanent_}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${matricule_}"));
        columnBinding.setColumnName("Prénom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom_}"));
        columnBinding.setColumnName("Matricule");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prenom_}"));
        columnBinding.setColumnName("Code permanent");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblEtudiant);
        tblEtudiant.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnAjouter.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAjouter.setMnemonic('a');
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnRechercher.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRechercher.setMnemonic('r');
        btnRechercher.setText("Rechercher");
        btnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechercherActionPerformed(evt);
            }
        });

        txfPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPrenom.setText("Prénom :");

        lblNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNom.setText("Nom :");

        txfNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        txfMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMatricule.setText("Matricule :");

        tblEtudiantRecherche.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstEtudiantRechercheTempo}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblEtudiantRecherche);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codePermanent_}"));
        columnBinding.setColumnName("Code Permanent");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${matricule_}"));
        columnBinding.setColumnName("Matricule");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom_}"));
        columnBinding.setColumnName("Nom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prenom_}"));
        columnBinding.setColumnName("Prenom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tblEtudiantRecherche);

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMatricule)
                            .addComponent(lblNom)
                            .addComponent(lblPrenom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txfPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txfMatricule, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfNom, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(247, 247, 247))
                    .addGroup(pnlContenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenuLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(btnRechercher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAjouter)
                                .addGap(150, 150, 150))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter)
                    .addComponent(btnRechercher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnSupprimerEtudiantGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerEtudiantGroupeActionPerformed
        facadeListeEtudiant.remove(lstListeEtudiant.get(tblEtudiant.getSelectedRow()));
        lstEtudiantTempo.remove(lstEtudiantTempo.get(tblEtudiant.getSelectedRow()));
    }//GEN-LAST:event_btnSupprimerEtudiantGroupeActionPerformed

    private void btnImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimerActionPerformed
        Impression uneImpression = new Impression();
        uneImpression.afficherRappGroupe(unGroupe.getIdGroupePK()); //Kathy Landry
    }//GEN-LAST:event_btnImprimerActionPerformed
    
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        if (tblEtudiantRecherche.getSelectedRow() == -1)
            lblMessage.setText("Veuillez sélectionner un étudiant à ajouter");
        else
        {
            ajouterEtudiant();
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechercherActionPerformed
        rechercheEtudiant();
    }//GEN-LAST:event_btnRechercherActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Opérations">
    private void rechercheEtudiant()
    {
        String nom = txfNom.getText();
        String prenom = txfPrenom.getText();
        String matricule= txfMatricule.getText();
        if((nom.length() ==0) && (prenom.length()==0))
        {
            if(matricule.length()==0)
            {
                lblMessage.setText("Entrez un nom, un prénom ou un matricule.");
            }
            else
            {
                //Recherche par matricule
                if (lstEtudiantRecherche.size() != 0)
                {
                    lstEtudiantRecherche.clear();
                }
                lstEtudiantRecherche.add(facadeEtudiant.findByMatriculePK(matricule)); 
            }
        }
        else if((nom.length() !=0) && (prenom.length()!=0))
        {
            //Recherche selon le nom et le prenom
            if (lstEtudiantRecherche.size() != 0)
            {
                lstEtudiantRecherche.clear();
            }
            
            if(matricule.length() !=0)
            {
                lstEtudiantRecherche.add(facadeEtudiant.findByMatriculePK(matricule)); 
            }
            else
            {   
                lstEtudiantRecherche = facadeEtudiant.findByNomPrenom(nom,prenom);
            }
        }    
        else if((nom.length()==0) && (prenom.length()!=0))
        {
            //Recherche selon le prenom
            if (lstEtudiantRecherche.size() != 0)
            {
                lstEtudiantRecherche.clear();
            }
            lstEtudiantRecherche = facadeEtudiant.findByPrenom(prenom);
        }
        else if((nom.length()!=0) && (prenom.length()==0))
        {
            //Recherche selon le nom
                if (lstEtudiantRecherche.size() != 0)
                {
                    lstEtudiantRecherche.clear();
                }            
            lstEtudiantRecherche = facadeEtudiant.findByNom(nom);
        }
        else
        {
            lblMessage.setText("Entrez un nom, un prénom ou un matricule.");
        }
        remplirListeEtudiantTempo();
    }
    
    //Méthode pour remplir la liste d'étudiant provenant de la recherche
    private void remplirListeEtudiantTempo()
    {
        lstEtudiantRechercheTempo.clear();
        for (Etudiant unEtudiant : lstEtudiantRecherche)
        {
            EtudiantTempo unEtudiantTempo = new EtudiantTempo(unEtudiant.getIdUtilisateurFK().getNom()
                                                             ,unEtudiant.getIdUtilisateurFK().getPrenom()
                                                             ,unEtudiant.getMatriculePK()
                                                             ,unEtudiant.getCodePermanent());
            lstEtudiantRechercheTempo.add(unEtudiantTempo);  
        }
    }
        
    //Méthode qui remplit la liste d'étudiant du groupe
    private void initialiserChamps()
    {
        for (ListeEtudiant unEtudiant : lstListeEtudiant)
        {
            EtudiantTempo unEtudiantTempo = new EtudiantTempo(unEtudiant.getMatriculeFK().getIdUtilisateurFK().getNom()
                                                             ,unEtudiant.getMatriculeFK().getIdUtilisateurFK().getPrenom()
                                                             ,unEtudiant.getMatriculeFK().getMatriculePK()
                                                             ,unEtudiant.getMatriculeFK().getCodePermanent());
            lstEtudiantTempo.add(unEtudiantTempo);  
        }
    }
    
    //Méthode qui ajoute un étudiant dans un groupe
    private void ajouterEtudiant()
    {
        ListeEtudiant le = new ListeEtudiant();
        le.setIdGroupeFK(unGroupe);
        le.setMatriculeFK(lstEtudiantRecherche.get(tblEtudiantRecherche.getSelectedRow()));
        facadeListeEtudiant.create(le);
        lstListeEtudiant.add(le);
        EtudiantTempo unEtudiantTempo = new EtudiantTempo(le.getMatriculeFK().getIdUtilisateurFK().getNom()
                                                         ,le.getMatriculeFK().getIdUtilisateurFK().getPrenom()
                                                         ,le.getMatriculeFK().getMatriculePK()
                                                         ,le.getMatriculeFK().getCodePermanent());
        lstEtudiantTempo.add(unEtudiantTempo); 
    }
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
            java.util.logging.Logger.getLogger(DlgGererGroupe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGererGroupe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGererGroupe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGererGroupe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGererGroupe2 dialog = new DlgGererGroupe2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnFermer;
    private javax.swing.JButton btnImprimer;
    private javax.swing.JButton btnRechercher;
    private javax.swing.JButton btnSupprimerEtudiantGroupe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMatricule;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JTable tblEtudiant;
    private javax.swing.JTable tblEtudiantRecherche;
    private javax.swing.JTextField txfMatricule;
    private javax.swing.JTextField txfNom;
    private javax.swing.JTextField txfPrenom;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}//</editor-fold>