/*
Implement a simple online content purchase system with the following features:
    * Each user has a unique ID, name, and email.
    * Allow users to make purchases of individual pieces of content (e.g., articles, videos).
    * Keep track of the user's purchase history.
    * Each content item has a unique ID, title, and type (e.g., article, video).
    * Implement a method to display information about the content.
    * Each purchase has a unique ID, associated user, content, purchase date, and price.
    User should not be able to purchase duplicates of the same content
    Ability to display all purchases by user per content type
    Method to efficiently check if the user has purchased a given content
*/

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MuraliTest {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

class Purchases {
    Map<Long, Map<Long, Purchase>> purchases = new HashMap<>();
    private Long sequencePurchase = 0L;

    private void sell(Long userId, Long itemId, BigDecimal price) {
        if(Objects.isNull(purchases.get(userId))){
            purchases.put(userId, new HashMap<>());
        }

        if(Objects.nonNull(purchases.get(userId).get(itemId))) {
            return;
        }
        sequencePurchase++;
        //Purchase purchase = new Purchase(sequencePurchase, userId, price);

        //purchases.get(userId).put(itemId, purchase);
    }

    public void printPurchasesFromUserByContentType(Long iduser, String type, Map<Long, Item> items) {
        /*if(Objects.nonNull(purchases.get(iduser))){
            purchases.get(iduser).entrySet().stream().filter((k,v) => {
                items.get(v.itemId).type == type
            }.forEach(x=> System.out.printLn(items.get(x.id).name);System.out.printLn(x.price);))
        }*/
    }

    public boolean userHasBoughtItem(Long userId, Long itemId) {
        if(Objects.isNull(purchases.get(userId))) {
            return false;
        }
        return Objects.nonNull(purchases.get(userId).get(itemId));
    }

    public void printPurchases() {
        /*purchases.entrySet().stream().forEach((k, v) => {

        });*/
    }
}

class User {
    Long id;
    String name;
    String email;
}

class Item {
    Long id;
    String title;
    String type;
}

class Purchase {
    Long id;
    Long userId;
    Long itemId;
    LocalDateTime purchaseData;
    BigDecimal price;

    public Purchase(Long id, Long userId, Long itemId, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.purchaseData = LocalDateTime.now();
        this.price = price;
    }
}
