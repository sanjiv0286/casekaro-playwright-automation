package com.casekaro.utils;

import com.casekaro.pages.CartPage;

import java.util.List;

public class CartConsolePrinter {
    public static void printItems(List<CartPage.CartItem> items) {
        System.out.println("\n========== CART ITEMS ==========");
        for (CartPage.CartItem item : items) {
            System.out.println("Material: " + safe(item.material));
            System.out.println("Price   : " + safe(item.price));
            System.out.println("Link    : " + safe(item.link));
            System.out.println("--------------------------------");
        }
        System.out.println("================================\n");
    }

    private static String safe(String s) {
        return s == null ? "" : s;
    }
}
