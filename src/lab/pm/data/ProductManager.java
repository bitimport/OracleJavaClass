package lab.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Locale locale;
    private ResourceBundle resourceBundle;
    private DateTimeFormatter dateTimeFormatter;
    private NumberFormat moneyFormat;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("lab.pm.data.resources",locale);
        dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

    private Product product;
    private Review review;

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore){

        product =  new Food(id, name, price, rating, bestBefore);
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating){

        product =  new Drink(id, name, price, rating);
        return product;
    }

    public  Product reviewProduct( Product product, Rating rating, String comment){
        review = new Review(rating, comment);
        this.product = product.applyRating(rating);
        return this.product;
    }

    public void printProductReport(){
        StringBuilder txt  =  new StringBuilder();
        txt.append(MessageFormat.format(resourceBundle.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                product.getBestBefore()
        ));
        txt.append('\n');
        if(review != null){
            txt.append(MessageFormat.format(resourceBundle.getString("review"),
                    review.getRating().getStars(), review.getComments()));
        }else{
            txt.append(resourceBundle.getString("no.review"));
        }

        txt.append('\n');

        System.out.println(txt);
    }
}
