package factory;

import simj.SimEntity;
import simj.SimEntityFactory;
import simj.SimRandom;
import simj.SimResource;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class ProductionSite extends SimResource {

    private MachineFactory machineFactory = MachineFactory.getUniqueInstance();
    
    public ProductionSite(int nWorkingMachine, final String ressourceName) {
        super(nWorkingMachine, ressourceName);
        for(int i=0;i<nWorkingMachine;i++) {
            request(machineFactory.createSimEntity());
        }
    }

    @Override
    protected double getServiceTime(SimEntity pEntity) {
        return 0;
    }
}
