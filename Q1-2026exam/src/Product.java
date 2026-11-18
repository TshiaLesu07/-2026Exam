public class Product implements IProduct {
    private final String [] names;
    private final int [][] sales;

    public Product(String[]names,int [][] sales){
        this.names = names;
        this.sales = sales;
    }
    private int productTotal (int i){
        int j = 0;
        for (int k : sales[i]) j += k;
        return j;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++){
            total += productTotal(i);
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        return GetTotalProductsSold()/ (double) (sales.length * sales[0].length);
    }

    @Override
    public String GetMostPopularProduct() {
        int i = 0;
        for (int a = 1; i < sales.length; i++){
            if (productTotal(i) > productTotal(a)){
                a = 1;
            }
        }
        return names[i] + "(" + productTotal(i)+ ")";
    }
}
