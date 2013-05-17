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
public class ReparationSite extends SimResource{
    
    private MachineFactory machineFactory = MachineFactory.getUniqueInstance();
    
    public ReparationSite(int nStockMachine, String name) {
        super(nStockMachine, name);
        for(int i=0;i<nStockMachine;i++) {
            request(machineFactory.createSimEntity());
        }
    }

    @Override
    protected double getServiceTime(SimEntity pEntity) {
        return 0;
    }
    
}
