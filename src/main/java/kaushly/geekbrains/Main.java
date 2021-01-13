package kaushly.geekbrains;

import kaushly.geekbrains.app.beans.AppConfig;
import kaushly.geekbrains.app.beans.ShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ShopService shopService = context.getBean("shopService",ShopService.class);
        System.out.println(shopService.findDetailsFromOrder(1,2));
        System.out.println(shopService.findProductsFromClient(1));
        System.out.println(shopService.findBuyersOfProduct(1));
        context.close();
        shopService.close();
    }
}
