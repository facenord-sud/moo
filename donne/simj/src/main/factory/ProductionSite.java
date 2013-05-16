/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import simj.SimEntity;
import simj.SimResource;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class ProductionSite extends SimResource {

    public ProductionSite(final int pCapacity, final String ressourceName) {
        super(pCapacity, ressourceName);
    }

    @Override
    protected double getServiceTime(SimEntity pEntity) {
        return 0;
    }
}
