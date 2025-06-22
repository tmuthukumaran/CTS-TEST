import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search 
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    
    public static void sortByProductName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Accessories"),
            new Product(3, "Keyboard", "Accessories"),
            new Product(4, "Charger", "Electronics")
        };

        // -------- Linear Search --------
        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, "Mouse");
        if (result1 != null)
            System.out.println("Found: " + result1);
        else
            System.out.println("Product not found");

        sortByProductName(products); // Sorts array by productName

        //Binary Search
        System.out.println("\nBinary Search:");
        Product result2 = binarySearch(products, "Mouse");
        if (result2 != null)
            System.out.println("Found: " + result2);
        else
            System.out.println("Product not found");
    }
}
