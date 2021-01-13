package kaushly.geekbrains.app.beans;

import kaushly.geekbrains.app.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDao extends BasicDao<Product> {

    public ProductDao(ShopSessionsFactory factory) {
        super(factory);
    }

    @Override
    public void init() {
        cls = Product.class;
    }
}
