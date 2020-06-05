/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 26/04/2020                        */
/******************************************************/
package phare;

import HarbourGlobal.DialogResult;
import HarbourGlobal.MyAppProperties;
import HarbourGlobal.PropertiesEnum;
import java.awt.Color;
import java.awt.Image;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import utilisateurs.DialogLogin;
import HarbourGlobal.GestionLocale;

public class Phare extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private PhareBrain _phareBrain;
    private DialogIdentificationBateau identiBateau;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Format date etc">
    private int _formatDate;
    private int _formatHeure;
    private Locale _fuseau;
    //</editor-fold>
        
    /**
     * Creates new form Phare
     */
    public Phare() {
        initComponents();
        _phareBrain = new PhareBrain();
        _phareBrain.getLogger().Write("Phare","Création du cerveau de l'application");
       
        if(!this.UserLogin())
        {
            this.Close();
        }
        else
        {
            //<editor-fold defaultstate="collapsed" desc="Init de la liste des bateaux en attente">
            this.InitListe();   
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Init image du phare">
            ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/phare.jpg"));
            Image scaleImage1 = icon1.getImage().getScaledInstance(300, 200,Image.SCALE_SMOOTH);
            this.imgPhare.setIcon(new javax.swing.ImageIcon(scaleImage1));                   
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Affichage de la date au format des proprietes">
            MyAppProperties map = _phareBrain.getProperties();
            _fuseau = GestionLocale.stringToLocale(map.getPropertie(PropertiesEnum.Locale));
            
            _formatDate = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatDate));
            _formatHeure = Integer.parseInt(map.getPropertie(PropertiesEnum.FormatHeure));
            
            Date maintenant = new Date();
            DateDemarrage.setText(DateFormat.getDateTimeInstance(_formatDate, _formatHeure, _fuseau).format(maintenant));
            //</editor-fold>
            
             //<editor-fold defaultstate="collapsed" desc="Init des beans">
            _phareBrain.InitBeans(bateauxEnAttenteJL);
            //</editor-fold>
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgPhare = new javax.swing.JLabel();
        btnConnexionServeur = new javax.swing.JButton();
        btnSuivant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bateauIdentifieTF = new javax.swing.JTextField();
        btnAutorisationEntree = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRAZ = new javax.swing.JButton();
        btnEntreRade = new javax.swing.JButton();
        confirmationLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bateauxEnAttenteJL = new javax.swing.JList<>();
        btnDecoServeur = new javax.swing.JButton();
        reponseCapitainerieTF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        ServeurButton = new javax.swing.JButton();
        MessagePendingCheck = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MessageRequete = new javax.swing.JTextField();
        DateDemarrage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phare d'entrée d'Inpres-Harbour");
        setResizable(false);

        btnConnexionServeur.setText("Se connecter au serveur");
        btnConnexionServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnexionServeurActionPerformed(evt);
            }
        });

        btnSuivant.setText("Suivant");
        btnSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuivantActionPerformed(evt);
            }
        });

        jLabel1.setText("Bateaux en attente");

        jLabel2.setText("Bateau identifié :");

        bateauIdentifieTF.setEditable(false);
        bateauIdentifieTF.setText("??");

        btnAutorisationEntree.setText("Demander autorisation entrée");
        btnAutorisationEntree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorisationEntreeActionPerformed(evt);
            }
        });

        jLabel3.setText("Réponse de la capitainerie :");

        btnRAZ.setText("RAZ");

        btnEntreRade.setText("Bateau entré dans la rade");
        btnEntreRade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntreRadeActionPerformed(evt);
            }
        });

        confirmationLabel.setText("??");

        bateauxEnAttenteJL.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(bateauxEnAttenteJL);

        btnDecoServeur.setText("Se déconnecter du serveur");
        btnDecoServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecoServeurActionPerformed(evt);
            }
        });

        reponseCapitainerieTF.setEditable(false);
        reponseCapitainerieTF.setText("??");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("Depart des bateaux");

        ServeurButton.setText("Démarrer serveur");
        ServeurButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServeurButtonActionPerformed(evt);
            }
        });

        MessagePendingCheck.setText("Message en attente");

        jButton1.setText("Lire requete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Valider départ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Annuler départ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        DateDemarrage.setText("???");

        jLabel6.setText("Heure de début: ");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAutorisationEntree)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirmationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reponseCapitainerieTF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(48, 48, 48)
                                        .addComponent(bateauIdentifieTF, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnSuivant)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(imgPhare, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnConnexionServeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnDecoServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(DateDemarrage, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEntreRade))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnRAZ)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(ServeurButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MessagePendingCheck, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MessageRequete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4)))
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnConnexionServeur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDecoServeur))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DateDemarrage)
                                        .addComponent(jLabel6))
                                    .addComponent(imgPhare, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuivant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(bateauIdentifieTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAutorisationEntree)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(reponseCapitainerieTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntreRade)
                    .addComponent(confirmationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRAZ)
                .addGap(0, 18, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(ServeurButton)
                .addGap(18, 18, 18)
                .addComponent(MessagePendingCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MessageRequete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    
    //<editor-fold defaultstate="collapsed" desc="Event">
    private void btnConnexionServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnexionServeurActionPerformed
        this._phareBrain.connexionServeur();
    }//GEN-LAST:event_btnConnexionServeurActionPerformed

    private void btnDecoServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecoServeurActionPerformed
        this._phareBrain.deconnexionServeur();
    }//GEN-LAST:event_btnDecoServeurActionPerformed

    private void btnSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuivantActionPerformed
        //Vérifie que la liste des bateaux en attente n'est pas vide
        if(this.bateauxEnAttenteJL.getModel().getSize() > 0 
                && this.bateauIdentifieTF.getText().compareTo("??") == 0)
        {
            //Premier element
            String bateauEnAttente = this.bateauxEnAttenteJL.getModel().getElementAt(0);
            if(bateauEnAttente.length() > 0)
            {
                _phareBrain.getLogger().Write("Phare", "Identification Bateau : " + bateauEnAttente);
                //<editor-fold defaultstate="collapsed" desc="Ouverture de la fenetre d'Identification du bateau">
                identiBateau = new DialogIdentificationBateau(this, true, bateauEnAttente);
                identiBateau.setVisible(true);
                
                if(identiBateau.getResult() == DialogResult.ok)
                {
                    _phareBrain.getLogger().Write("Phare", "Bateau identifie : "
                        + "\nNom : " + identiBateau.getNom() 
                        + "\nType : " + identiBateau.getTypeBateau()
                        + "\nPavillon : " + identiBateau.getPavillon()
                        + "\nLongueur : " + identiBateau.getLongueur() + "\n");
                    this.bateauIdentifieTF.setText(identiBateau.getNom() +" / "+ identiBateau.getLongueur());
                    this.bateauIdentifieTF.setBackground(Color.GREEN);    
                }
                //</editor-fold>
            }
        }   
    }//GEN-LAST:event_btnSuivantActionPerformed

    private void btnAutorisationEntreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorisationEntreeActionPerformed
        if(this.bateauIdentifieTF.getText().compareTo("??") != 0)
        {
            this._phareBrain.envoiMsg(_phareBrain.ENVOI_IDENTIFICATION, identiBateau.getNom(), identiBateau.getTypeBateau(), identiBateau.getPavillon(), identiBateau.getLongueur());
            String reponse = this._phareBrain.getReponseBateauIdentifie();
            _phareBrain.getLogger().Write("Phare", "Reponse recue : " + reponse);
            if(reponse.length() > 0)
            {
                //reponse a separe avec TypeDeReception + nom + amarrage + emplacement => / est le delimiteur
                StringTokenizer parser = new StringTokenizer(reponse, _phareBrain.getDelimiteur());
                int i = 0;
                String typeReception = "", nom = "", amarrage = "", emplacement = "";
                boolean bonneReception = true;
                while (parser.hasMoreTokens() && bonneReception) 
                {
                    switch(i)
                    {
                        case 0:
                            typeReception = parser.nextToken().trim();
                            if(typeReception.compareTo(_phareBrain.RECEP_IDENTIFICATION) != 0)
                            {
                                bonneReception = false;
                            }
                            break;
                        case 1:
                            nom = parser.nextToken().trim();
                            break;
                        case 2:
                            amarrage = parser.nextToken().trim();
                            break;
                        case 3:
                            emplacement = parser.nextToken().trim();
                    }
                    i++;
                }
                if(bonneReception)
                {
                    this.reponseCapitainerieTF.setText(nom + " -> " + amarrage + "*" + emplacement);
                    this.reponseCapitainerieTF.setBackground(Color.LIGHT_GRAY);  
                    this._phareBrain.setAmarrageEnCours(amarrage);
                    this._phareBrain.setEmplacementEnCours(emplacement);
                    _phareBrain.getLogger().Write("Phare","Bon TYPE Reponse - Autorisation d'entrée");
                }
                else
                {
                    this.reponseCapitainerieTF.setText("??");
                    this.reponseCapitainerieTF.setBackground(Color.WHITE);
                    this._phareBrain.setAmarrageEnCours("");
                    this._phareBrain.setEmplacementEnCours("");
                    _phareBrain.getLogger().Write("Phare","Mauvais TYPE Reponse - Autorisation d'entrée");
                }
            }
            else
                _phareBrain.getLogger().Write("Phare","Reponse amarrage non recue");
        }
    }//GEN-LAST:event_btnAutorisationEntreeActionPerformed

    private void btnEntreRadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntreRadeActionPerformed
        if(this.reponseCapitainerieTF.getText().compareTo("??") != 0)
        {
            this._phareBrain.envoiMsgRade(_phareBrain.ENVOI_ENTRE_RADE, "OK");
            String reponse = this._phareBrain.getReponseBateauEntreRade();
            _phareBrain.getLogger().Write("Phare","Reponse recue : " + reponse);
            if(reponse.length() > 0)
            {
                StringTokenizer parser = new StringTokenizer(reponse, _phareBrain.getDelimiteur());
                int i = 0;
                String typeReception = "", msg = "";
                boolean bonneReception = true;
                while (parser.hasMoreTokens() && bonneReception) 
                {
                    switch(i)
                    {
                        case 0:
                            typeReception = parser.nextToken().trim();
                            if(typeReception.compareTo(_phareBrain.RECEP_ENTRE_RADE) != 0)
                            {
                                bonneReception = false;
                            }
                            break;
                        case 1:
                            msg = parser.nextToken().trim();
                            if(msg.compareTo("OK") != 0)
                                bonneReception = false;
                            break;
                    }
                    i++;
                }
                if(bonneReception)
                {
                    this.confirmationLabel.setText(identiBateau.getNom() + " <- " + 
                            _phareBrain.getAmarrageEnCours()+ "*" + _phareBrain.getEmplacementEnCours());
                    this.reponseCapitainerieTF.setBackground(Color.LIGHT_GRAY);  
                    this._phareBrain.setAmarrageEnCours("");
                    this._phareBrain.setEmplacementEnCours("");
                    this.bateauIdentifieTF.setText("??");
                    this.reponseCapitainerieTF.setText("??");
                    this.reponseCapitainerieTF.setBackground(Color.WHITE);
                    this.bateauIdentifieTF.setBackground(Color.WHITE);
                    this.RemoveFirstBoat();
                    _phareBrain.getLogger().Write("Phare","Bon TYPE Reponse - Entre dans la rade");
                }
                else
                {
                    this.confirmationLabel.setText("??");
                    _phareBrain.getLogger().Write("Phare","Mauvais TYPE Reponse - Entre dans la rade");
                }
            }
            else
                _phareBrain.getLogger().Write("Phare","Reponse Vide - Entre dans la rade");
            
        }
    }//GEN-LAST:event_btnEntreRadeActionPerformed

    private void ServeurButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServeurButtonActionPerformed
        if(_phareBrain.IsServeurRunning() == false)
        {
            _phareBrain.StartServeur(MessagePendingCheck);
            ServeurButton.setText("Arreter serveur");
        }
        else
        {
            _phareBrain.ArreterServeur();
            ServeurButton.setText("Demarrer serveur");
        }
    }//GEN-LAST:event_ServeurButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String msg = _phareBrain.ReadMessage();
        MessageRequete.setText(msg);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        _phareBrain.sendMessage("true");
        MessageRequete.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        _phareBrain.sendMessage("false");
        MessageRequete.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Méthodes">
    //<editor-fold defaultstate="collapsed" desc="Fermeture de la fenetre">
    private void Close()
    {
        this.dispose();
        System.exit(0);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Connexion d'un utilisateur">
    public boolean UserLogin()
    {
        DialogLogin dlg = new DialogLogin(this, true);
        dlg.setVisible(true);
        
        if(null == dlg.getResult())
            return false;
        else switch (dlg.getResult()) {
            case ok:
                System.out.println("c'est ok");
                return true;
            case cancel:
                System.out.println("c'est annulé");
                return false;
            case untouched:
                System.out.println("c'est ferme sans y toucher");
                return false;
            default:
                return false;
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Liste des bateaux en attente">
    private void InitListe()
    {
        DefaultListModel dlm = new DefaultListModel();
        
        // bateaux en dur => après java beans
        for(String bateauEnAttente : this._phareBrain.getBateauxEnAttente())
            dlm.addElement(bateauEnAttente);
        
        this.bateauxEnAttenteJL.setModel(dlm); 
    }
    
    private void RemoveFirstBoat()
    {
        DefaultListModel dlm = (DefaultListModel)bateauxEnAttenteJL.getModel();
        if(!dlm.isEmpty())
            dlm.remove(0);
    }
    
    //</editor-fold>
    
    //</editor-fold>

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
            java.util.logging.Logger.getLogger(Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Phare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateDemarrage;
    private javax.swing.JCheckBox MessagePendingCheck;
    private javax.swing.JTextField MessageRequete;
    private javax.swing.JButton ServeurButton;
    private javax.swing.JTextField bateauIdentifieTF;
    private javax.swing.JList<String> bateauxEnAttenteJL;
    private javax.swing.JButton btnAutorisationEntree;
    private javax.swing.JButton btnConnexionServeur;
    private javax.swing.JButton btnDecoServeur;
    private javax.swing.JButton btnEntreRade;
    private javax.swing.JButton btnRAZ;
    private javax.swing.JButton btnSuivant;
    private javax.swing.JLabel confirmationLabel;
    private javax.swing.JLabel imgPhare;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField reponseCapitainerieTF;
    // End of variables declaration//GEN-END:variables
}
