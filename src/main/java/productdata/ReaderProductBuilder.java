package productdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReaderProductBuilder {

    public static Product buildProduct(BufferedReader reader){
        String name = null;
        Float price = null;
        UnitOfMeasure unitOfMeasure = null;
        Organization manufacturer = null;
        System.out.println("Введите имя продукта:");
        while (name == null) {
            try {
                name = reader.readLine();
            }
            catch (IOException e){
                System.out.println(" Введено некорректное значение.");
            }
            if ("".equals(name)) {
                System.out.println("Ошибка: введено пустое значение. Введите имя продукта:");
                name = null;
            }
        }
        System.out.println("Ввести цену ?\n yes \n any words to no:");
        try {
            if ("yes".equals(reader.readLine())) {
                while (price == null) {
                    try {
                        price = Float.parseFloat(reader.readLine());
                    } catch (Exception e) {
                        System.out.println("Введего некорректное значение.");
                    }
                    if (price != null && price < 0f) {
                        System.out.println("Ошибка: цена не может быть отрицательной. Введите цену:");
                        price = null;
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        LocalDateTime creationDate = LocalDateTime.now();
        Coordinates coordinates = new Coordinates(reader);
        System.out.println("Введите единицы массы: \n" +
                "    KILOGRAMS,\n" +
                "    CENTIMETERS,\n" +
                "    PCS,\n" +
                "    LITERS,\n" +
                "    MILLILITERS;");

        while (unitOfMeasure == null) {
            try {
                unitOfMeasure = UnitOfMeasure.valueOf(reader.readLine().toUpperCase());
            }
            catch (Exception e ){
                System.out.println("Ошибка: введено неккоректное значение. Введите единицы массы:");
            }
        }
        System.out.println("Ввести данные о производителе ? \n yes \n any words to no");
        try {
            if(reader.readLine().equals("yes")) {
                while (true) {
                    System.out.println("Назначить из существующих ? \n yes \n any words to no");
                    try {
                        if (reader.readLine().equals("yes")) {
                            String key;
                            System.out.println("Выберите из списка : ");
                            UniqueController.getOrgTable().forEach((k, v) -> System.out.println(k));
                            try {
                                key = reader.readLine();
                            } catch (Exception e) {
                                System.out.println("Ошибка: введено некорректное значение.");
                                continue;
                            }
                            try {
                                manufacturer = UniqueController.get(key);
                                break;
                            }
                            catch (Exception e){
                                System.out.println("Такой компании нет в списке");
                            }
                        }
                        else {
                            manufacturer = new Organization(reader);
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка: введено некорректное значение.");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Ошибка: введено некорректное значение.");
        }
        try {
            return new Product(null, name, coordinates, price, unitOfMeasure, manufacturer, creationDate);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
