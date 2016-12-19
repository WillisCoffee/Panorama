package pckDialog;

// William Thibodeau
import ejb.CoursFacadeRemote;
import ejb.ProfesseurFacadeRemote;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import org.jdesktop.beansbinding.Binding;
import pckEntites.Cours;
import pckEntites.Departement;
import pckEntites.Groupe;
import pckEntites.Professeur;
import pckEntites.Session;

//Fenêtre permettant la modification et l'ajout d'un groupe
public class DlgGroupe extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="Variables">
    boolean result = false;
    Groupe unGroupe;
    List<Departement> lstDepartement;
    List<Session> lstSession;
    List<Professeur> lstEnseignant;
    List<Cours> lstCours;
    CoursFacadeRemote facadeCours;
    ProfesseurFacadeRemote facadeProfesseur;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgGroupe(java.awt.Frame parent, boolean modal, Groupe leGroupe,
                                                List<Departement> lstDep,
                                                List<Session> lstSes,
                                                CoursFacadeRemote fc,
                                                ProfesseurFacadeRemote fe) 
    {
        super(parent, modal);
        unGroupe = leGroupe;
        lstDepartement = lstDep;
        lstSession = lstSes;
        facadeCours = fc;
        facadeProfesseur = fe;
        lstCours = facadeCours.findByDep(lstDepartement.get(0));
        lstEnseignant = facadeProfesseur.findByDep(lstDepartement.get(0));
        initComponents();
        
        ajouterListener();
        initialiserChamps();
    }
    
    public DlgGroupe(java.awt.Frame parent, boolean modal,
                                        List<Departement> lstDep,
                                        List<Session> lstSes,
                                        CoursFacadeRemote fc,
                                        ProfesseurFacadeRemote fe) 
    {
        super(parent, modal);
        unGroupe = new Groupe(); 
        lstDepartement = lstDep;
        lstSession = lstSes;
        facadeCours = fc;
        facadeProfesseur = fe;
        lstCours = facadeCours.findByDep(lstDepartement.get(0));
        lstEnseignant = facadeProfesseur.findByDep(lstDepartement.get(0));
        initComponents();
        
        ajouterListener();       
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter / setter">
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Session> getLstSession() {
        return lstSession;
    }

    public void setLstSession(List<Session> lstSession) {
        this.lstSession = lstSession;
    }

    public List<Departement> getLstDepartement() {
        return lstDepartement;
    }

    public void setLstDepartement(List<Departement> lstDepartement) {
        this.lstDepartement = lstDepartement;
    }

    public List<Cours> getLstCours() {
        return lstCours;
    }

    public void setLstCours(List<Cours> lstCours) {
        this.lstCours = lstCours;
    }

    public List<Professeur> getLstEnseignant() {
        return lstEnseignant;
    }

    public void setLstEnseignant(List<Professeur> lstEnseignant) {
        this.lstEnseignant = lstEnseignant;
    }

    public Groupe getUnGroupe() {
        return unGroupe;
    }

    public void setUnGroupe(Groupe unGroupe) {
        this.unGroupe = unGroupe;
    }
    
    
    //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlTitre = new javax.swing.JPanel();
        lblTtitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        lblSession = new javax.swing.JLabel();
        cmbCours = new javax.swing.JComboBox<>();
        cmbSession = new javax.swing.JComboBox<>();
        lblCours = new javax.swing.JLabel();
        lblProfesseur = new javax.swing.JLabel();
        cmbProfesseur = new javax.swing.JComboBox<>();
        cmbDepartement = new javax.swing.JComboBox<>();
        lblDepartement = new javax.swing.JLabel();
        pnlBas = new javax.swing.JPanel();
        pnlBoutons = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter un groupe");
        setResizable(false);

        lblTtitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTtitre.setText("Créer un groupe");
        pnlTitre.add(lblTtitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        lblSession.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblSession.setText("Session :");

        cmbCours.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbCours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir un cour" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstCours}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cmbCours, "departement");
        bindingGroup.addBinding(jComboBoxBinding);

        cmbSession.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir une session" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstSession}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cmbSession);
        bindingGroup.addBinding(jComboBoxBinding);

        lblCours.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCours.setText("Cours :");

        lblProfesseur.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProfesseur.setText("Professeur :");

        cmbProfesseur.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbProfesseur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir un professeur" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstEnseignant}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cmbProfesseur, "professeur");
        bindingGroup.addBinding(jComboBoxBinding);

        cmbDepartement.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbDepartement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir un département" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${lstDepartement}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, cmbDepartement);
        bindingGroup.addBinding(jComboBoxBinding);

        lblDepartement.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDepartement.setText("Département :");

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProfesseur)
                    .addComponent(lblSession)
                    .addComponent(lblCours)
                    .addComponent(lblDepartement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbDepartement, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProfesseur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSession))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCours))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfesseur)
                    .addComponent(cmbProfesseur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setLayout(new java.awt.BorderLayout());

        btnAccepter.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAccepter.setMnemonic('a');
        btnAccepter.setText("Accepter");
        btnAccepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccepterActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnAccepter);

        btnAnnuler.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAnnuler.setMnemonic('n');
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        pnlBoutons.add(btnAnnuler);

        pnlBas.add(pnlBoutons, java.awt.BorderLayout.CENTER);

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
        setResult(true);
        
        setInfos();
        setVisible(false);
    }//GEN-LAST:event_btnAccepterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        setResult(false);
        
        setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Opérations">
    private void setInfos()
    {
        unGroupe.setIdCoursFK(lstCours.get(cmbCours.getSelectedIndex()));
        unGroupe.setProfesseurFK(lstEnseignant.get(cmbProfesseur.getSelectedIndex()));
        unGroupe.setIdSessionFK(lstSession.get(cmbSession.getSelectedIndex()));
    }
    private void initialiserChamps()
    {
        cmbSession.setSelectedItem(unGroupe.getIdSessionFK());
        cmbDepartement.setSelectedItem(unGroupe.getIdCoursFK().getIdDepartementFK());
        cmbCours.setSelectedItem(unGroupe.getIdCoursFK());
        cmbProfesseur.setSelectedItem(unGroupe.getProfesseurFK());
    }
    
    private void ajouterListener()
    {
        cmbDepartement.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                lstCours = facadeCours.findByDep(lstDepartement.get(cmbDepartement.getSelectedIndex()));
                lstEnseignant = facadeProfesseur.findByDep(lstDepartement.get(cmbDepartement.getSelectedIndex()));
                Binding bindingCours = bindingGroup.getBinding("departement");
                Binding bindingProf = bindingGroup.getBinding("professeur");
                bindingProf.unbind();
                bindingProf.bind();
                bindingCours.unbind();
                bindingCours.bind();
            }
        });
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DlgGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGroupe dialog = new DlgGroupe(new javax.swing.JFrame(), true, null, null, null, null);
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
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JComboBox<String> cmbCours;
    private javax.swing.JComboBox<String> cmbDepartement;
    private javax.swing.JComboBox<String> cmbProfesseur;
    private javax.swing.JComboBox<String> cmbSession;
    private javax.swing.JLabel lblCours;
    private javax.swing.JLabel lblDepartement;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblProfesseur;
    private javax.swing.JLabel lblSession;
    private javax.swing.JLabel lblTtitre;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
