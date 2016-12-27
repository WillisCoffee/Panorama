package pckDialog;

import ejb.CodePostalFacadeRemote;
import ejb.UtilisateurFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import pckEntites.Adresse;
import pckEntites.CodePostal;
import pckEntites.Utilisateur;
import pckEntites.Etudiant;

public class DlgGererEtudiant extends javax.swing.JDialog 
{
    //<editor-fold defaultstate="collapsed" desc="Variables">
    boolean result = false;
    Utilisateur _utilisateur;
    Etudiant _etudiant;
    Adresse _adresse;
    CodePostal _codePostal;
    List<Adresse> lstAdresse;
        //Facades
    UtilisateurFacadeRemote _facadeUtilisateur;
    CodePostalFacadeRemote _facadeCodePostal;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    public DlgGererEtudiant(java.awt.Frame parent, boolean modal, Etudiant pEtudiant, UtilisateurFacadeRemote pFacadeUtilisateur, CodePostalFacadeRemote pFacadeCodePostal) 
    {
        super(parent, modal);
        lstAdresse = new ArrayList<>();
        _facadeUtilisateur = pFacadeUtilisateur;
        _facadeCodePostal = pFacadeCodePostal;
        _etudiant = pEtudiant;
        
        initComponents();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public Utilisateur getUtilisateur() {
        return _utilisateur;
    }

    public void setUtilisateur(Utilisateur _utilisateur) {
        this._utilisateur = _utilisateur;
    }

    public Etudiant getEtudiant() {
        return _etudiant;
    }

    public void setEtudiant(Etudiant _etudiant) {
        this._etudiant = _etudiant;
    }

    public Adresse getAdresse() {
        return _adresse;
    }

    public void setAdresse(Adresse _adresse) {
        this._adresse = _adresse;
    }

    public CodePostal getCodePostal() {
        return _codePostal;
    }

    public void setCodePostal(CodePostal _codePostal) {
        this._codePostal = _codePostal;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Utilisateur getUnUtilisateur() {
        return _utilisateur;
    }

    public void setUnUtilisateur(Utilisateur unUtilisateur) {
        this._utilisateur = unUtilisateur;
    }

    public Etudiant getUnEtudiant() {
        return _etudiant;
    }

    public void setUnEtudiant(Etudiant unEtudiant) {
        this._etudiant = unEtudiant;
    }

    public Adresse getUnAdresse() {
        return _adresse;
    }

    public void setUnAdresse(Adresse unAdresse) {
        this._adresse = unAdresse;
    }
// </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlTitre = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        pnlContenu = new javax.swing.JPanel();
        pnlAdresse = new javax.swing.JPanel();
        txfCodePostal = new javax.swing.JTextField();
        lblCodePostal = new javax.swing.JLabel();
        cmbProvince = new javax.swing.JComboBox<>();
        lblProvince = new javax.swing.JLabel();
        txfRue = new javax.swing.JTextField();
        lblRue = new javax.swing.JLabel();
        lblNoCivique = new javax.swing.JLabel();
        txfNoCivique = new javax.swing.JTextField();
        txfVille = new javax.swing.JTextField();
        lblVille = new javax.swing.JLabel();
        pnlInformations = new javax.swing.JPanel();
        lblTelephone = new javax.swing.JLabel();
        txfTelephone = new javax.swing.JFormattedTextField();
        lblDateNaissance = new javax.swing.JLabel();
        txfDateNaissance = new javax.swing.JFormattedTextField();
        lblNom = new javax.swing.JLabel();
        txfNom = new javax.swing.JTextField();
        lblCellulaire = new javax.swing.JLabel();
        lblCellulaireOptionel = new javax.swing.JLabel();
        txfCellulaire = new javax.swing.JFormattedTextField();
        lblMotDePasse = new javax.swing.JLabel();
        pwfMotPasse = new javax.swing.JPasswordField();
        lblPrenom = new javax.swing.JLabel();
        txfPrenom = new javax.swing.JTextField();
        lblCourriel = new javax.swing.JLabel();
        txfCourriel = new javax.swing.JTextField();
        lblPhotographie = new javax.swing.JLabel();
        lblPhotoOptionnel = new javax.swing.JLabel();
        txfPhoto = new javax.swing.JTextField();
        lblNAS = new javax.swing.JLabel();
        txfNAS = new javax.swing.JFormattedTextField();
        pnlEtudiant = new javax.swing.JPanel();
        lblMatricule = new javax.swing.JLabel();
        txfCodePermanent = new javax.swing.JTextField();
        lblCodePermanent = new javax.swing.JLabel();
        txfMatricule = new javax.swing.JFormattedTextField();
        pnlBas = new javax.swing.JPanel();
        pnlMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pnlBoutons = new javax.swing.JPanel();
        btnAccepter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gérer étudiant");
        setModal(true);
        setResizable(false);

        lblTitre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTitre.setText("Gérer Étudiant");
        pnlTitre.add(lblTitre);

        getContentPane().add(pnlTitre, java.awt.BorderLayout.PAGE_START);

        pnlContenu.setToolTipText("");

        pnlAdresse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adresse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11))); // NOI18N
        pnlAdresse.setToolTipText("sdffdff");

        txfCodePostal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfCodePostal.setPreferredSize(new java.awt.Dimension(0, 25));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${codePostal.codePostal}"), txfCodePostal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblCodePostal.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodePostal.setText("Code Postal ");

        cmbProvince.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cmbProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALB", "CB", "IPE", "MAN", "NB", "NE", "ON", "QC", "SK", "TNL", "TNO", "NT", "YN" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${codePostal.province}"), cmbProvince, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        lblProvince.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProvince.setText("Province");

        txfRue.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfRue.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${adresse.rue}"), txfRue, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblRue.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRue.setText("Rue");

        lblNoCivique.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNoCivique.setText("No civique");

        txfNoCivique.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfNoCivique.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${adresse.numeroCivique}"), txfNoCivique, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txfVille.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfVille.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${codePostal.ville}"), txfVille, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblVille.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblVille.setText("Ville");

        javax.swing.GroupLayout pnlAdresseLayout = new javax.swing.GroupLayout(pnlAdresse);
        pnlAdresse.setLayout(pnlAdresseLayout);
        pnlAdresseLayout.setHorizontalGroup(
            pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdresseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfNoCivique, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoCivique))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfRue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRue))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVille)
                            .addComponent(txfVille, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodePostal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdresseLayout.setVerticalGroup(
            pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdresseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRue)
                            .addComponent(lblVille))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addComponent(lblNoCivique)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNoCivique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addComponent(lblCodePostal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAdresseLayout.createSequentialGroup()
                        .addComponent(lblProvince)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlInformations.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11))); // NOI18N

        lblTelephone.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelephone.setText("Téléphone");

        try {
            txfTelephone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDateNaissance.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDateNaissance.setText("Date naissance");

        try {
            txfDateNaissance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNom.setText("Nom");

        txfNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfNom.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${utilisateur.nom}"), txfNom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblCellulaire.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCellulaire.setText("Cellulaire");

        lblCellulaireOptionel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCellulaireOptionel.setForeground(new java.awt.Color(102, 102, 102));
        lblCellulaireOptionel.setText("- Optionel");

        try {
            txfCellulaire.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblMotDePasse.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMotDePasse.setText("Mot de passe");

        pwfMotPasse.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${utilisateur.motPasse}"), pwfMotPasse, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPrenom.setText("Prénom");

        txfPrenom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfPrenom.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${utilisateur.prenom}"), txfPrenom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblCourriel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCourriel.setText("Courriel");

        txfCourriel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfCourriel.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${utilisateur.courriel}"), txfCourriel, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblPhotographie.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPhotographie.setText("Photographie");

        lblPhotoOptionnel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPhotoOptionnel.setForeground(new java.awt.Color(102, 102, 102));
        lblPhotoOptionnel.setText("- Optionel");

        txfPhoto.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txfPhoto.setPreferredSize(new java.awt.Dimension(0, 25));

        lblNAS.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNAS.setText("NAS");

        try {
            txfNAS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnlInformationsLayout = new javax.swing.GroupLayout(pnlInformations);
        pnlInformations.setLayout(pnlInformationsLayout);
        pnlInformationsLayout.setHorizontalGroup(
            pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformationsLayout.createSequentialGroup()
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrenom)
                                    .addComponent(txfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfNom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNom))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDateNaissance)
                                    .addComponent(txfDateNaissance)))
                            .addGroup(pnlInformationsLayout.createSequentialGroup()
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMotDePasse)
                                    .addComponent(pwfMotPasse, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                                        .addComponent(lblPhotographie)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPhotoOptionnel))
                                    .addComponent(txfPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformationsLayout.createSequentialGroup()
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfCourriel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourriel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformationsLayout.createSequentialGroup()
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelephone)
                                    .addComponent(txfTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                                        .addComponent(lblCellulaire)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCellulaireOptionel))
                                    .addComponent(txfCellulaire, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(90, 90, 90))
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNAS)
                            .addComponent(txfNAS, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlInformationsLayout.setVerticalGroup(
            pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrenom)
                            .addComponent(lblNom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInformationsLayout.createSequentialGroup()
                        .addComponent(lblDateNaissance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDateNaissance)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addComponent(lblMotDePasse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwfMotPasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhotographie)
                            .addComponent(lblPhotoOptionnel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelephone)
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCellulaire, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCellulaire)
                        .addComponent(lblCellulaireOptionel)))
                .addGap(5, 5, 5)
                .addGroup(pnlInformationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfCourriel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInformationsLayout.createSequentialGroup()
                        .addComponent(lblCourriel)
                        .addGap(31, 31, 31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNAS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txfNAS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlEtudiant.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations de l'étudiant", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 11))); // NOI18N

        lblMatricule.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMatricule.setText("Matricule");

        txfCodePermanent.setPreferredSize(new java.awt.Dimension(0, 25));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${etudiant.codePermanent}"), txfCodePermanent, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblCodePermanent.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodePermanent.setText("Code permanent");

        try {
            txfMatricule.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnlEtudiantLayout = new javax.swing.GroupLayout(pnlEtudiant);
        pnlEtudiant.setLayout(pnlEtudiantLayout);
        pnlEtudiantLayout.setHorizontalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEtudiantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMatricule)
                    .addComponent(txfMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodePermanent)
                    .addComponent(txfCodePermanent, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEtudiantLayout.setVerticalGroup(
            pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEtudiantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEtudiantLayout.createSequentialGroup()
                        .addComponent(lblCodePermanent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEtudiantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCodePermanent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEtudiantLayout.createSequentialGroup()
                        .addComponent(lblMatricule)
                        .addGap(31, 31, 31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenuLayout = new javax.swing.GroupLayout(pnlContenu);
        pnlContenu.setLayout(pnlContenuLayout);
        pnlContenuLayout.setHorizontalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlEtudiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAdresse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInformations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContenuLayout.setVerticalGroup(
            pnlContenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlContenu, java.awt.BorderLayout.CENTER);

        pnlBas.setPreferredSize(new java.awt.Dimension(0, 59));
        pnlBas.setLayout(new java.awt.BorderLayout());

        lblMessage.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pnlMessage.add(lblMessage);

        pnlBas.add(pnlMessage, java.awt.BorderLayout.PAGE_START);

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

        getContentPane().add(pnlBas, java.awt.BorderLayout.PAGE_END);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Actions">
    private void btnAccepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepterActionPerformed
       
    }//GEN-LAST:event_btnAccepterActionPerformed
    
    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnAnnulerActionPerformed
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Opérations">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGererEtudiant dialog = new DlgGererEtudiant(new javax.swing.JFrame(), true, null, null, null);
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
    
    // <editor-fold defaultstate="collapsed" desc="Composants">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccepter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JComboBox<String> cmbProvince;
    private javax.swing.JLabel lblCellulaire;
    private javax.swing.JLabel lblCellulaireOptionel;
    private javax.swing.JLabel lblCodePermanent;
    private javax.swing.JLabel lblCodePostal;
    private javax.swing.JLabel lblCourriel;
    private javax.swing.JLabel lblDateNaissance;
    private javax.swing.JLabel lblMatricule;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMotDePasse;
    private javax.swing.JLabel lblNAS;
    private javax.swing.JLabel lblNoCivique;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPhotoOptionnel;
    private javax.swing.JLabel lblPhotographie;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JLabel lblRue;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JLabel lblVille;
    private javax.swing.JPanel pnlAdresse;
    private javax.swing.JPanel pnlBas;
    private javax.swing.JPanel pnlBoutons;
    private javax.swing.JPanel pnlContenu;
    private javax.swing.JPanel pnlEtudiant;
    private javax.swing.JPanel pnlInformations;
    private javax.swing.JPanel pnlMessage;
    private javax.swing.JPanel pnlTitre;
    private javax.swing.JPasswordField pwfMotPasse;
    private javax.swing.JFormattedTextField txfCellulaire;
    private javax.swing.JTextField txfCodePermanent;
    private javax.swing.JTextField txfCodePostal;
    private javax.swing.JTextField txfCourriel;
    private javax.swing.JFormattedTextField txfDateNaissance;
    private javax.swing.JFormattedTextField txfMatricule;
    private javax.swing.JFormattedTextField txfNAS;
    private javax.swing.JTextField txfNoCivique;
    private javax.swing.JTextField txfNom;
    private javax.swing.JTextField txfPhoto;
    private javax.swing.JTextField txfPrenom;
    private javax.swing.JTextField txfRue;
    private javax.swing.JFormattedTextField txfTelephone;
    private javax.swing.JTextField txfVille;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}