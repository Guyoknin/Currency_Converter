abstract class Coin implements ICalculate {

    public abstract double getValue();

    // Implementation of the Calculate method
    public double calculate(double value1){
        return getValue() + value1;
    }
}
