/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckFournisseur;

/**
 *
 * @author clocal
 */
public class ManufacturePanorama 
{
   public static final int _FournisseurPanorama = 0;
public static final int _FournisseurHorizon = 1;
    
    int _typeFournisseur;
    
    public ManufacturePanorama(int typeFournisseur)
    {
        _typeFournisseur = typeFournisseur;
    }
    
    public FournisseurServices creerFournisseur()
    {
        FournisseurServices fs = null;
        
        if (_typeFournisseur == _FournisseurPanorama)
        {
            fs = new FournisseurServicesPanorama();
        }
        
        return fs;
    } 
}
