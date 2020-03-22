package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private double mRe;
    private double mIm;
    public ComplexNumber(double Re, double Im) {
        mRe = Re;
        mIm = Im;
    }
    public double getRe(){
       return mRe;
    }
    public double getIm(){
        return mIm;
    }
    public double module() {
        return Math.sqrt(mRe * mRe + mIm * mIm);
    }
    public String equality(ComplexNumber Number) {
        return (mRe + Number.mRe) + "," + (mIm + Number.mIm);
    }
}
