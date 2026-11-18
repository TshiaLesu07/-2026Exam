public class PrintProduct {
    private final IProduct products;

    public PrintProduct(IProduct products) {
        this.products = products;
    }

    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + products.GetTotalProductsSold());
    }

    public void PrintAverageProductSales() {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", products.GetAverageProductSold());
    }

    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + products.GetMostPopularProduct());
    }
}
