package org.example.demo_session_and_cookie_int_spring.exercise.model;

import java.util.HashMap;
import java.util.Map;

public class CartEx {
    private Map<ProductEx, Integer> products = new HashMap<>();

    public CartEx() {}

    public CartEx(Map<ProductEx, Integer> products) {
        this.products = products;
    }

    public Map<ProductEx, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(ProductEx product) {
        for (Map.Entry<ProductEx, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductEx, Integer> selectItemInCart(ProductEx product) {
        for (Map.Entry<ProductEx, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addItem(ProductEx product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<ProductEx, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductEx, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float totalPayment = 0;
        for (Map.Entry<ProductEx, Integer> entry : products.entrySet()) {
            totalPayment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return totalPayment;
    }

    public void removeItem(ProductEx product) {
        products.remove(product);
    }

    public void updateItem(ProductEx product, int quantity) {
        if (products.containsKey(product)) {
            if (quantity <= 0) {
                removeItem(product);
            } else {
                products.put(product, quantity);
            }
        }
    }

}
