package ru.practicum.dinner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dinnerConstructor = new HashMap<>();
    Random random = new Random();

    void addNewDish(String dishType, String dish) {

        if (dinnerConstructor.containsKey(dishType)) {
            ArrayList<String> tempList = dinnerConstructor.get(dishType);
            tempList.add(dish);

            dinnerConstructor.put(dishType, tempList);
            System.out.println(dinnerConstructor);

        } else {
            ArrayList<String> iniList = new ArrayList<>();
            iniList.add(dish);
            dinnerConstructor.put(dishType, iniList);
            System.out.println(dinnerConstructor);
        }

    }

    void generateCombo(int numberOfCombos, ArrayList<String> dishTypeList) {

        ArrayList<String> combo = null;
        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.println("Комбо "+ i);
            combo = new ArrayList<>();

            for (String dishType : dishTypeList) {
                System.out.println(dishType);
                if (checkType(dishType)){
                    ArrayList<String> tempList = dinnerConstructor.get(dishType);
                    combo.add(tempList.get(random.nextInt(tempList.size())));
                } else {
                    System.out.println("В меню нет типа блюд " + dishType + " введите другой тип блюда.");
                }
            }
            System.out.println(combo + "\n");
        }
    }

    boolean checkType(String type) {
        if (dinnerConstructor.containsKey(type)){
            return true;
        }
        return false;
    }
}


// }
