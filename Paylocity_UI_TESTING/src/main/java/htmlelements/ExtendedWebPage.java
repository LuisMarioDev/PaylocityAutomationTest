package htmlelements;

import annotations.IsAtPageMethod;
import org.hamcrest.Matcher;

/**
 * HtmlElements is not supported for later Selenium versions after 3.10.0, 
 * this is a wrapper class to avoid issues.
 * It can be also used for extending or overriding WebPage behavior
 */

public interface ExtendedWebPage{

    @IsAtPageMethod
    void isAtPage(Matcher<String> url);

    default void isAt(Matcher<String> url) {
        isAtPage(url);
    }

     class Product {
        private String name;
        private String price;

        public Product(String name, String price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setName(int name) {
            this.name = String.valueOf(name);
        }

        public void setPrice(int price) {
            this.price = String.valueOf(price);
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }

}
