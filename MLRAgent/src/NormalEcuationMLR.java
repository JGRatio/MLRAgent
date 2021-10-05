import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

class NormalEcuationMLR {
    public NormalEcuationMLR() {
        calculate();
    }

    private double B0,B1,B2;
    private double[][] VectorDataX = {
        {1,41.9,29.1},
        {1,43.4,29.3},
        {1,43.9,29.5},
        {1,44.5,29.7},
        {1,47.3,29.9},
        {1,47.5,30.3},
        {1,47.9,30.5},
        {1,50.2,30.7},
        {1,52.8,30.8},
        {1,53.2,30.9},
        {1,56.7,31.5},
        {1,57.0,31.7},
        {1,63.5,31.9},
        {1,65.3,32.0},
        {1,71.1,32.1},
        {1,77.0,32.5},
        {1,77.8,32.9}
    };
    private double[][] VectorDataY = {
            {251.3},
            {251.3},
            {248.3},
            {267.5},
            {273.0},
            {276.5},
            {270.3},
            {274.9},
            {285.0},
            {290.0},
            {297.0},
            {302.5},
            {304.5},
            {309.5},
            {321.7},
            {330.7},
            {349.0}
    };





    public void setVectorDataX(double[][] vectorDataX) {
        VectorDataX = vectorDataX;
        calculate();
    }

    public void setVectorDataY(double[][] vectorDataY) {
        VectorDataY = vectorDataY;
        calculate();
    }

    public double getB0() {
        return B0;
    }

    public double getB1() {
        return B1;
    }

    public double getB2() {
        return B2;
    }

    private void calculate(){
        RealMatrix X = MatrixUtils.createRealMatrix(VectorDataX);
        RealMatrix Y = MatrixUtils.createRealMatrix(VectorDataY);
        RealMatrix XT = X.transpose();
        RealMatrix R = MatrixUtils.inverse(XT.multiply(X)).multiply(XT.multiply(Y));
        B0 = R.getEntry(0,0);
        B1 = R.getEntry(1,0);
        B2 = R.getEntry(2,0);
    }
}
