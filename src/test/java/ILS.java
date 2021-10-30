class ILS extends Coin {

    @Override
    public double getValue() {
        return value;
    }

    final double value = 0.28;

    @Override
    public double calculate(double value1) {
        return getValue() * value1;
    }


}
