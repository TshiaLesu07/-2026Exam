public class SaleCalculator {

    private double VAT_RATE = 0.15;
    private double COMISSION_RATE = 0.05;

    public double calculateVat(double price){
        return price * VAT_RATE;
    }

    public double calculateComission(double price){
        return price * COMISSION_RATE;
    }

    public double calculateTotal(double price){
        return price + calculateVat(price)+ calculateComission(price);
    }


}
