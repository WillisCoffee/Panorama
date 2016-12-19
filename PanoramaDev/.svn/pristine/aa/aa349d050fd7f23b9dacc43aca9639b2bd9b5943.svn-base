/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Evaluation;
import pckEntites.Groupe;

/**
 *
 * @author clocal
 */
@Remote
public interface EvaluationFacadeRemote {

    void create(Evaluation evaluation);

    void edit(Evaluation evaluation);

    void remove(Evaluation evaluation);

    Evaluation find(Object id);

    List<Evaluation> findAll();

    List<Evaluation> findRange(int[] range);

    int count();
    
    List<Evaluation> getEvalByGroupe(Groupe id);
    
}
