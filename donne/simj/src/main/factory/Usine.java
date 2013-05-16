/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import simj.SimSimulation;

/**
 *
 * @author Numa de Montmollin <facenord.sud@gmail.com>
 */
public class Usine extends SimSimulation {

    private int nWorkingMachine;
    private int nStockMachine;
    private int nMachinist;
    private int tDurationOfLife;
    private int pHeavyBreakdown;
    private int minReparTimeHeavy;
    private int maxReparTiemHeavy;
    private int minReparTimeLight;
    private int maxReparTimeHeavy;

    public Usine(int nWorkingMachine, int nStockMachine, int nMachinist,
            int tDurationOfLife, int pHeavyBreakdown, int minReparTimeHeavy,
            int maxReparTiemHeavy, int minReparTimeLight, int maxReparTimeHeavy,
            final double pFinalEventTime, final int pScanInterval, final boolean pFineLogging) {
        super(pFinalEventTime, pScanInterval, pFineLogging);
        this.nWorkingMachine = nWorkingMachine;
        this.nStockMachine = nStockMachine;
        this.nMachinist = nMachinist;
        this.tDurationOfLife = tDurationOfLife;
        this.pHeavyBreakdown = pHeavyBreakdown;
        this.minReparTimeHeavy = minReparTimeHeavy;
        this.maxReparTiemHeavy = maxReparTiemHeavy;
        this.minReparTimeLight = minReparTimeLight;
        this.maxReparTimeHeavy = maxReparTimeHeavy;
    }

    @Override
    protected void setupSimulation() {
        Machine[] workingMachines = new Machine[nWorkingMachine];
        Machine[] stockMachine = new Machine[nStockMachine];
        for (int i = 0; i < workingMachines.length; i++) {
            workingMachines[i] = new Machine(0);
        }
        for (int i = 0; i < stockMachine.length; i++) {
            stockMachine[i] = new Machine(0);
        }
    }

    @Override
    protected void createEvents() {
    }

    @Override
    protected void createResources() {
        new ProductionSite(nWorkingMachine, "production site");
        new ReparationSite(nMachinist, "reparation site");
    }

    public ProductionSite getProductionSite() {
        return (ProductionSite) this.getResource(0);
    }

    public ReparationSite getReparationSite() {
        return (ReparationSite) this.getResource(1);
    }
}
