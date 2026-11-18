import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        product = new Product(names, sales);
    }

    // Unit Test 1
    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2
    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}