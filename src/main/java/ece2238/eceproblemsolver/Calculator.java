package ece2238.eceproblemsolver;

public class Calculator
{
    public static Constants constants = new Constants();
    public double calculateElectronDensity(Element element)
    {
        return (element.getPm())*(constants.getAvogadrosNumber())*(element.getZ())/(element.getA());
    }
    public double calculateRadius(Element element) {
        return Math.pow((3*element.getA())/(4*constants.getPi()*element.getPm()* constants.getAvogadrosNumber()), 0.3333);
    }
    public double calculateMeanScatteringTime(Element element, int radiusLengths)
    {
        return (radiusLengths*element.getRadius())/constants.getAvgElectronSpeed();
    }
    public double calculateDrudeResistivity(Element element)
    {
        return constants.getElectronMass()/((element.getN()*1E6)*Math.pow(constants.getElectronCharge(),2)*element.getMeanScatteringTime());
    }//electron density must be converted to m^-3, hence it is multiplied
    public double calculateKF(Element element)
    {
        return Math.pow(3*Math.pow(constants.getPi(),2)*element.getN(),0.333333333333333333);
    }
    public double calculateEF(Element element)
    {
        return ((Math.pow(constants.getReducedPlanksConstantJS(),2)*(Math.pow(element.getKf(),2)*1E4))/(2*constants.getElectronMass()))/constants.getElectronCharge();
        //multiplying kf by 1E4 so that it is converted to m^-1 instead of cm^-1
    }
    public double calculateVF(Element element)
    {
        return (constants.getReducedPlanksConstantJS()*(element.getKf()*1E4))/constants.getElectronMass();
    }
    public double calculatetf(Element element)
    {
        return (2*element.getEf())/(3*constants.getBoltzmannConstant_eVk());
    }
    public double calculateni(SemiConductor semiConductor)//this also works for pi as it is the same formula
    {
        return (semiConductor.getB()*Math.pow(semiConductor.getT(),1.5))*Math.pow(constants.getEulersNumber(),((-semiConductor.getEg())/(2*constants.getBoltzmannConstant_eVk()*semiConductor.getT())));
    }
    public double calculateV0(SemiConductor semiConductor, double na, double nd)
    {
        return ((constants.getBoltzmannConstant_JK()*semiConductor.getT())/constants.getElectronCharge())*Math.log((na*nd)/(Math.pow(semiConductor.getNi(),2)));
    }
}