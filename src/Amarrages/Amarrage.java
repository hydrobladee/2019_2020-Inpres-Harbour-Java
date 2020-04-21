/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 25/03/2020                        */
/******************************************************/

package Amarrages;

import HarbourGlobal.AUnIdentifiant;

public abstract class Amarrage implements AUnIdentifiant
{
    protected int _capacite;
    protected int _idNumder;

    public Amarrage() 
    {
        _capacite = 0;
    }
    
    public Amarrage(int id, int capacite)
    {
        _idNumder = id;
        _capacite = capacite;
    }
    
    public int getCapacite()
    {
        return _capacite;
    }
}
