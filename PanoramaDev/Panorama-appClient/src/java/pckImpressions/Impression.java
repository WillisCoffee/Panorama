/*
 * Par Kathy Landry, 2016/12/06
 * Remplace la fenêtre de dialogue
 * 
 */
package pckImpressions;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Kathy
 */
public class Impression {
    
    //<editor-fold defaultstate="collapsed" desc="Constructeur">
    public Impression()
    {
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Actions">
    
    public void afficherRappGroupe(int numeroGroupe)
    {
        try
        {
            //Informations pour la connexion à la BD
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://depInfo5.cegep-rimouski.qc.ca:3306/equipe05", "equipe05", "3qu1p305");
            
            JasperReport jp = JasperCompileManager.compileReport(getClass().getResourceAsStream("listeEtudiant.jrxml"));

            //Envoie de paramètre au Jasper
            Map<String,Object> map = new HashMap<>();
            map.put("Groupe", Integer.toString(numeroGroupe));
            
            //Remplir le rapport avec les données
            JasperPrint jpP = JasperFillManager.fillReport(jp, map, con);
            
            //Créer un fichier PDF de la liste et l'enregistrer en temp
            try (OutputStream opS = new FileOutputStream(new File(System.getProperty("java.io.tmpdir") + "groupe" + Integer.toString(numeroGroupe)+ ".pdf"))) 
            {
                    JasperExportManager.exportReportToPdfStream(jpP, opS);
            }
            
            //Pour ouvrir le fichier directement
            if (Desktop.isDesktopSupported()) {
                try 
                {
                    File fichier = new File(System.getProperty("java.io.tmpdir") + "groupe" + Integer.toString(numeroGroupe)+ ".pdf");
                    Desktop.getDesktop().open(fichier);
                } 
                catch (IOException ex) 
                {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }           
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void afficherRappBulletin(String matricule)
    {
        try
        {
            //Informations pour la connexion à la BD
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://depInfo5.cegep-rimouski.qc.ca:3306/equipe05", "equipe05", "3qu1p305");
            
            JasperReport jp = JasperCompileManager.compileReport(getClass().getResourceAsStream("bulletinEtudiant.jrxml"));

            //Envoie de paramètre au Jasper
            Map<String,Object> map = new HashMap<>();
            map.put("Matricule", matricule);
            
            //Remplir le rapport avec les données
            JasperPrint jpP = JasperFillManager.fillReport(jp, map, con);
            
            //Créer un fichier PDF de la liste et l'enregistrer en temp
            try (OutputStream opS = new FileOutputStream(new File(System.getProperty("java.io.tmpdir") + "bulletin" + matricule +".pdf"))) 
            {
                    JasperExportManager.exportReportToPdfStream(jpP, opS);
            }
            
            //Pour ouvrir le fichier directement
            if (Desktop.isDesktopSupported()) {
                try 
                {
                    File fichier = new File(System.getProperty("java.io.tmpdir") + "bulletin"+ matricule +".pdf");
                    Desktop.getDesktop().open(fichier);
                } 
                catch (IOException ex) 
                {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }           
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    //</editor-fold>
    
}
