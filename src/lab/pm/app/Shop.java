package lab.pm.app;

import lab.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Shop {

    public static void main(String[] args) {
        Product p1 =  new Drink(101, "Tea", BigDecimal.valueOf(1.99), Rating.THREE_STAR);
        Product p2 =  new Drink(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
        Product p3 =  new Food(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(5));
        Product p4 = p3.applyRating(Rating.THREE_STAR);

        Product p8 =  new Drink(108, "BlueMoon", BigDecimal.valueOf(5.99), Rating.FIVE_STAR);
        Product p9 =  new Food(108, "Pizza", BigDecimal.valueOf(5.99), Rating.FIVE_STAR, LocalDate.now());
        Product p10 =  new Drink(110, "Margerita", BigDecimal.valueOf(12),Rating.FOUR_STAR);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println(p8);
        System.out.println(p9);
        System.out.println(p10);
        

        System.out.println(Ratable.covert(8).getStars());

        ProductManager pm =  new ProductManager(new Locale("en", "IN"));

        Product pp = pm.createProduct(1003,"MyProduct", BigDecimal.valueOf(15.08),Rating.THREE_STAR, LocalDate.now().plusDays(5));
        pm.reviewProduct(pp, Rating.FIVE_STAR, "MY NICE PRODUCT");
        pm.printProductReport();
        
        Product p120 = pm.createProduct(120, "Sarbat", BigDecimal.valueOf(2.33), Rating.NOT_RATED);
        pm.reviewProduct(p120, Rating.FOUR_STAR, "Very traditional drink");
        pm.printProductReport();
        
        
        
        
    }
}
