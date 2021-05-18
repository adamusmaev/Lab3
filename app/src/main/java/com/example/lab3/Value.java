package com.example.lab3;

public enum Value {

    METER(1.0, 1.0),
    KILOMETER (0.001, 1000.0),
    CENTIMETER(100.0, 0.01),
    FEET(3.28, 0.3),
    MILE(0.00062, 1609.34),
    INCH(39.37, 0.025);

    private Double value;
    private Double meterValue;

    public Double getMeterValue() {
        return meterValue;
    }

    Value(Double value, Double meterValue) {
        this.value = value;
        this.meterValue = meterValue;
    }

    public Double getValue() {
        return value;
    }
}
