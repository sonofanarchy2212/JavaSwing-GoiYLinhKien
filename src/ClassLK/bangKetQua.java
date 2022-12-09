/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassLK;

/**
 *
 * @author Admin
 */
public class bangKetQua {
    CPU cpu;
    Mainboard m;
    OCung o;
    PSU p;
    RAM ram;
    Case c;
    VGA v;

    public bangKetQua(CPU cpu, Mainboard m, OCung o, PSU p, RAM ram, Case c, VGA v) {
        this.cpu = cpu;
        this.m = m;
        this.o = o;
        this.p = p;
        this.ram = ram;
        this.c = c;
        this.v = v;
    }
    public bangKetQua(){
        cpu = new CPU();
        m = new Mainboard();
        o = new OCung();
        p = new PSU();
        ram = new RAM();
        c = new Case();
        v = new VGA();
    }
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Mainboard getM() {
        return m;
    }

    public void setM(Mainboard m) {
        this.m = m;
    }

    public OCung getO() {
        return o;
    }

    public void setO(OCung o) {
        this.o = o;
    }

    public PSU getP() {
        return p;
    }

    public void setP(PSU p) {
        this.p = p;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Case getC() {
        return c;
    }

    public void setC(Case c) {
        this.c = c;
    }

    public VGA getV() {
        return v;
    }

    public void setV(VGA v) {
        this.v = v;
    }


    public String toString() {
        return "bangKetQua{" + "cpu=" + cpu + ", m=" + m + ", o=" + o + ", p=" + p + ", ram=" + ram + ", c=" + c + ", v=" + v + '}';
    }

    
}
