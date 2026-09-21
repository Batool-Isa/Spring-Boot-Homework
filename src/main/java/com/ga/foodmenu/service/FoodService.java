package com.ga.foodmenu.service;

import com.ga.foodmenu.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodService {
    private ArrayList<Food> foodArrayList = new ArrayList<>();

    public FoodService() {
        foodArrayList.add(new Food("Burger", "Beef Burger", "Fast Food", 2.5));
        foodArrayList.add(new Food("Pizza", "Cheese Pizza", "Italian", 3.0));
        foodArrayList.add(new Food("Pasta", "Chicken Alfredo", "Italian", 3.5));
        foodArrayList.add(new Food("Chicken Burger", "Chicken Burger With Cheese", "Fast Food", 3.5));

        foodArrayList.add(new Food("Beef Burger", "Grilled Beef Burger With Lettuce", "Fast Food", 3.8));
        foodArrayList.add(new Food("Margherita Pizza", "Tomato, Mozzarella, and Basil", "Italian", 3.2));
        foodArrayList.add(new Food("Pepperoni Pizza", "Pizza With Pepperoni and Cheese", "Italian", 4.0));
        foodArrayList.add(new Food("Chicken Alfredo Pasta", "Creamy Alfredo Pasta With Chicken", "Italian", 4.5));

        foodArrayList.add(new Food("Caesar Salad", "Romaine Lettuce With Caesar Dressing", "Salad", 2.8));
        foodArrayList.add(new Food("Greek Salad", "Cucumber, Tomato, Feta Cheese, and Olives", "Salad", 3.0));

        foodArrayList.add(new Food("Chicken Shawarma", "Grilled Chicken Wrap With Garlic Sauce", "Arabic", 2.0));
        foodArrayList.add(new Food("Beef Shawarma", "Beef Wrap With Tahini Sauce", "Arabic", 2.5));
        foodArrayList.add(new Food("Chicken Machboos", "Spiced Rice With Chicken", "Bahraini", 4.0));
        foodArrayList.add(new Food("Chicken Nuggets", "Crispy Fried Chicken Nuggets", "Fast Food", 2.2));

        foodArrayList.add(new Food("French Fries", "Crispy Golden Potato Fries", "Sides", 1.2));
        foodArrayList.add(new Food("Chocolate Cake", "Rich Chocolate Cake Slice", "Dessert", 2.5));
        foodArrayList.add(new Food("Cheesecake", "Creamy Classic Cheesecake", "Dessert", 3.0));
        foodArrayList.add(new Food("Ice Cream", "Vanilla Ice Cream", "Dessert", 1.5));
        foodArrayList.add(new Food("Fresh Lemonade", "Fresh Lemon Juice With Mint", "Drinks", 1.0));
        foodArrayList.add(new Food("Iced Coffee", "Cold Coffee With Milk", "Drinks", 1.8));
    }


    public ArrayList<Food> getAllFoods() {
        return foodArrayList;
    }
}
