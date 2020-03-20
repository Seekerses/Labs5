package productdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Class that controls a building of Product using console
 */
public class ReaderProductBuilder {
    /**
     * This method creates a Product through a console input
     * @param reader Reader that will interact with user
     * @return Builded Product
     */
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
        Coordinates coordinates = buildCoordinates(reader);
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
                            manufacturer = buildOrganization(reader);
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

    private static Coordinates buildCoordinates(BufferedReader reader){
        double x;
        Integer y = null;
        System.out.println("Введите координаты организации. Введите координату x:");
        while (true){
            try {
                x = Double.parseDouble(reader.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное значение");
            } catch (IOException e) {
                System.out.println("Ошибка: введено некорректное значение.");
            }
        }
        System.out.println("Введите координату y:");
        while (y == null) {
            try {
                y = Integer.parseInt(reader.readLine());
            }
            catch (Exception e) {
                System.out.println("Ошибка: введено некорректное значение");
                continue;
            }
            if (y < -150){
                System.out.println("Ошибка: число выходит за диапазон. Введите координату y > -150:");
                y = null;
            }
        }
        try {
            return new Coordinates(x, y);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static Organization buildOrganization(BufferedReader reader){
        String name = null;
        String fullName = null;
        OrganizationType type = null;
        Address postalAddress = null;
        try {
            System.out.println("Введите имя организации:");
            while (name == null) {
                try {
                    name = reader.readLine();
                }
                catch (IOException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите имя организации:");
                }
                if (name == null || name.equals("")) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя организации");
                }
            }
            System.out.println("Введите полное имя организации :");
            while (fullName == null) {
                while(fullName == null) {
                    try {
                        fullName = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Ошибка: введено некорректное значение. Введите полное имя организации:");
                    }
                }
                if (fullName.length() > 1404) {
                    System.out.println("Ошибка: введено слишком длинное имя. Введите имя организации:");
                    fullName = null;
                }
                if (UniqueController.check(fullName)){
                    System.out.println("Полное имя организации должно быть уникальным.");
                    fullName = null;
                }
            }
            System.out.println("Ввести тип организации ? \n yes \n any words to no");
            try {
                if(reader.readLine().equals("yes")) {
                    System.out.println("Введите тип организации:\n" +
                            " PUBLIC,\n" +
                            " TRUST,\n" +
                            " PRIVATE_LIMITED_COMPANY");
                    while(type == null) {
                        try {
                            type = OrganizationType.valueOf(reader.readLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println(" Введено неверное значение.");
                            type = null;
                        }
                    }
                }
            }
            catch (IOException e){
                System.out.println("Ошибка: введено некорректное значение.");
            }
            System.out.println("Ввести адрес ? \n yes \n any words to no");
            try {
                if(reader.readLine().equals("yes")) {
                    postalAddress = buildAddress(reader);
                }
            }
            catch (IOException e){
                System.out.println("Ошибка: введено некорректное значение.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            Organization org = new Organization(null,name,fullName,type,postalAddress);
            UniqueController.put(fullName,org);
            return org;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static Address buildAddress(BufferedReader reader){
        String street = null;
        Location town = null;
        System.out.println("Введите улицу: ");
        while (street == null) {
            try {
                street = reader.readLine();
            }
            catch (IOException e){
                System.out.println("Ошибка: введено некорректное значение. Введите улицу:");
            }
            if (street == null) {
                System.out.println("Ошибка: введено пустое значение. Введите улицу:");
            }
        }
        System.out.println("Ввести город ? \n yes \n any words to no");
        try {
            if(reader.readLine().equals("yes")) {
                town = buildLocation(reader);
            }
        }
        catch (IOException e){
            System.out.println("Ошибка: введено некорректное значение.");
        }
        return new Address(street,town);
    }

    private static Location buildLocation(BufferedReader reader){
        Long x = null;
        int y = 0;
        Long z = null;
        try {
            System.out.println("Введите координаты организации. Введите координату x:");
            while(x == null) {
                try {
                    x = Long.parseLong(reader.readLine());
                }
                catch (NumberFormatException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите координату x:");
                    x = null;
                }
            }
            System.out.println("Введите координату y:");
            while (true){
                try {
                    y = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено некорректное значение");
                } catch (IOException e) {
                    System.out.println("Ошибка: введено некорректное значение.");
                }
            }

            System.out.println("Введите координату z:");
            while(z == null) {
                try {
                    z = Long.parseLong(reader.readLine());
                }
                catch (NumberFormatException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите координату z:");
                    z = null;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new Location(x,y,z);
    }
}
