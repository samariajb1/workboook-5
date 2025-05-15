package com.plurasight;

public class SalesContract extends Contract{

    protected double salesTax,recordingFee,processingFee;
    protected boolean finance;

    public SalesContract(String customerName, String customerEmail, String saleDate, double salePrice, double monthlyPayment, Vehicle vehicle, double salesTax, double recordingFee, double processingFee, boolean finace) {
        super(customerName, customerEmail, saleDate, salePrice, monthlyPayment, vehicle);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getSalePrice() {
        return this.salePrice * salesTax+recordingFee+processingFee;

    }

    @Override
    public double getMonthlyPayment() {
        //TODO:
        // if were not finacning return 0 if true return getsaleprice, intrest by 48
        if (!finance) return 0;

        double price = getSalePrice();
        double intrest = 0;
        int contractTerm = 0;
        //
        if (price >= 10000) {
            intrest = 1.0425f;
            contractTerm = 48;
        } else {
            intrest = 1.0525f;
            contractTerm = 24;
        }
        return getSalePrice() * intrest / contractTerm;
    }

}
