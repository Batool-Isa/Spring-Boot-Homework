package com.ga.foodmenu.controller;

import com.ga.foodmenu.model.Food;
import com.ga.foodmenu.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/welcome")
    public Map<String, String> getProfile() {
        Map<String, String> info = new HashMap<>();
        info.putAll(Map.of(
                "Application Name", "Food Menu API",
                "Developer Name", "Batool Isa",
                "Description", "An Api that is developed to search , retrieve food menu",
                "Theme", "Restaurant Foods"
        ));
        return info;
    }

    @GetMapping("/foods")
    public ArrayList<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/food")
    public Food getSpecificFood(@RequestParam(value = "id", defaultValue = "1") int id) {
        return foodService.getAllFoods()
                .stream().
                filter(f -> f.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/foods/{id}")
    public Food getFoodById(@PathVariable("id") int id) {
        return foodService.getAllFoods()
                .stream()
                .filter(food -> food.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/foods/search")
    public ArrayList<Food> search(@RequestParam(value = "name", defaultValue = "Burger") String name) {
        return foodService.getAllFoods()
                .stream().
                filter(f -> f.getName().toLowerCase()
                        .contains(name.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    @GetMapping("/foods/filter")
    public List<Food> filterByCategory(@RequestParam(value = "category", defaultValue = "fast food") String category) {
        return foodService.getAllFoods()
                .stream().
                filter(f -> f.getCategory().toLowerCase()
                        .contains(category.toLowerCase())).toList();
    }

    @PostMapping("/foods/add")
    public String addFood(@RequestParam(value = "name", defaultValue = "dish name") String name,
                          @RequestParam(value = "description", defaultValue = "dish description") String description,
                          @RequestParam(value = "category", defaultValue = "fast food") String category,
                          @RequestParam(value = "price", defaultValue = "2") double price) {
        boolean added = foodService.getAllFoods().add(new Food(name, description, category, price));
        if (added) {
            return "Food Added Successfully!";
        } else {
            return "Not Added Successfully!";
        }
    }

    @PutMapping("/food/update")
    public Food updatePrice(@RequestParam(value = "name", defaultValue = "dishName") String name,
                            @RequestParam(value = "price", defaultValue = "0") double price) {
        Food food = foodService.getAllFoods()
                .stream().
                filter(f -> f.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (food != null) {
            food.setPrice(price);
        }
        return food;
    }

    @DeleteMapping("/food/delete")
    public String deleteFood(@RequestParam(value = "name", defaultValue = "dishName") String name) {
        boolean deleted = false;
        Food food = foodService.getAllFoods()
                .stream().
                filter(f -> f.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (food != null) {
            deleted = foodService.getAllFoods().remove(food);
            if (deleted == true) {
                return "Deleted Successfully";
            } else {
                return "Not Deleted";
            }
        }else{
            return "Food not found in menu";
        }

    }

    @GetMapping("/foods/statistics")
    public Map<String, String> statistics() {
        Map<String, String> info = new HashMap<>();
        int total = foodService.getAllFoods().size();
        Food expensiveItem = foodService.getAllFoods().stream().max(Comparator.comparingDouble(Food::getPrice)).orElse(null);
        Food cheapestItem = foodService.getAllFoods().stream().min(Comparator.comparingDouble(Food::getPrice)).orElse(null);

        info.put(
                "Total Food Items", String.valueOf(total));
        if (expensiveItem !=null && cheapestItem != null){
            info.putAll(Map.of("Most Expensive Food", expensiveItem.getName(),
                    "Cheapest Food", cheapestItem.getName()));
        }

        return info;
    }

    // route to select random food for user
    @GetMapping("/foods/surprise")
    public Food foodRoulette() {
        if (foodService.getAllFoods().isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(foodService.getAllFoods().size());
        return foodService.getAllFoods().get(randomIndex);
    }

    // route to find meals with th user budget
    @GetMapping("/foods/budget")
    public List<Food> mealFinder(@RequestParam(value = "maxPrice", defaultValue = "2") double budget) {
        return foodService.getAllFoods()
                .stream().
                filter(f -> f.getPrice() <= budget).toList();

    }
}
