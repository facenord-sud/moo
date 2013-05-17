/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import simj.SimEntity;
import simj.SimEntityFactory;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class MachineFactory extends SimEntityFactory{

    private static MachineFactory instance = new MachineFactory();
    
    private MachineFactory() {}
    
    @Override
    protected SimEntity doCreateSimEntity(int pId) {
        return new Machine(pId);
    }
    
    public static MachineFactory getUniqueInstance() {
        return instance;
    }
}
