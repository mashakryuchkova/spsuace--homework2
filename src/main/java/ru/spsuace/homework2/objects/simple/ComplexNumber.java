package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */

public class ComplexNumber {
    private double Re;
    private double Im;

    public ComplexNumber(double Re, double Im) {
        this.Re = Re;
        this.Im = Im;
    }

    public double getRe() {
        return Re;
    }

    public double getIm() {
        return Im;
    }

    public String toString() {
        return this.Re + this.Im + "*i";
    }

    public double module() {
        return Math.sqrt(Math.pow(this.Re, 2) + Math.pow(this.Im, 2));
    }

    public String equality() {
        return (this.Re + Re) + "," + (this.Im + Im);
    }
}
