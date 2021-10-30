class USD extends Coin {

    @Override
    public double getValue() {
        return value;
    }

    private final double value = 3.52;

    @Override
    public double calculate(double value1) {
        return getValue() * value1;
    }


}
