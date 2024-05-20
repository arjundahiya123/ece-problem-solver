package ece2238.eceproblemsolver;

public class Element
{
    private String name;//name of element
    private int atomicNumber;//atomic number of element
    private double A;//density of element(g/mol)
    private int Z;
    private double pm;//g/cm^-3
    private double p;//resistivity (ohm*m)
    private double n;//electron density (cm^-3)
    private double radius;//radius of atom (cm)
    private double meanScatteringTime;//meanScatteringTime (s)
    private double pDrude;//resistivity according to drude model (ohm*m)
    private double kf;// (cm^-1)
    private double ef;//fermi energy (eV)
    private double vf;// (cm/s)
    private double tf;//Effective Temperature (K)

    public Element(String name, int atomicNumber, double A, int Z, double pm, double p)
    {
        setName(name);
        setAtomicNumber(atomicNumber);
        setA(A);
        setZ(Z);
        setPm(pm);
        setP(p);
    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getA() {
        return A;
    }

    public int getZ() {
        return Z;
    }

    public double getPm() {
        return pm;
    }

    public double getP() {
        return p;
    }

    public double getN() {
        return n;
    }

    public double getRadius() {
        return radius;
    }

    public double getMeanScatteringTime() {
        return meanScatteringTime;
    }

    public double getpDrude() {
        return pDrude;
    }
    public double getEf() {
        return ef;
    }

    public double getKf() {
        return kf;
    }

    public double getVf() {
        return vf;
    }

    public double getTf() {
        return tf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setA(double a) {
        A = a;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void setPm(double pm) {
        this.pm = pm;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setN(double n) {
        this.n = n;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMeanScatteringTime(double meanScatteringTime) {
        this.meanScatteringTime = meanScatteringTime;
    }

    public void setpDrude(double pDrude) {
        this.pDrude = pDrude;
    }

    public void setKf(double kf) {
        this.kf = kf;
    }

    public void setEf(double ef) {
        this.ef = ef;
    }

    public void setVf(double vf) {
        this.vf = vf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }
}