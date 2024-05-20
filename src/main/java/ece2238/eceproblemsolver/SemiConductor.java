package ece2238.eceproblemsolver;

public class SemiConductor
{
    private String formula;
    private double eg;//(eV)
    private int un;// (cm^2/V*s)
    private int up;// (cm^2/V*s)
    private double b;//cm^-3*K^-1.5
    private double ni;//intrinsic concentration of electrons  (cm^-3)
    private double pi;//intrinsic concentration of holes  (cm^-3)
    private double t=300;//temperature default at 300 (K)
    private double v0;//internal bias (V)
    SemiConductor(String formula, double eg, int un, int up, double b)
    {
        this.formula = formula;
        this.eg = eg;
        this.un = un;
        this.up = up;
        this.b = b;
    }

    public String getFormula() {
        return formula;
    }

    public double getEg() {
        return eg;
    }

    public int getUn() {
        return un;
    }

    public int getUp() {
        return up;
    }

    public double getB() {
        return b;
    }

    public double getPi() {
        return pi;
    }

    public double getNi() {
        return ni;
    }

    public double getT() {
        return t;
    }

    public double getV0() {
        return v0;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setEg(double eg) {
        this.eg = eg;
    }

    public void setUn(int un) {
        this.un = un;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setNi(double ni) {
        this.ni = ni;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public void setT(double t) {
        this.t = t;
    }

    public void setV0(double v0) {
        this.v0 = v0;
    }

}