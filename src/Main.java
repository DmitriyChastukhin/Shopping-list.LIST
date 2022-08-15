import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите операцию: \n" +
                    "1. Добавить покупку \n" +
                    "2. Показать все покупки \n" +
                    "3. Удалить покупку из списка \n" +
                    "4. Поиск покупок по ключевым словам \n" +
                    "Для завершения программы введите end");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("1")) {
                System.out.println("Какую покупку хотите добавить в список?");
                String add = scanner.nextLine();
                list.add(add);
                System.out.println("\n Итого в списке покупок: " + list.size());

            } else if (input.equals("2")) {
                if (list.isEmpty()) {
                    System.out.println("\n Список пуст \n");
                    continue;
                }

                printList(list);
            } else if (input.equals("3")) {
                if (list.isEmpty()) {
                    System.out.println("\n Список пуст, удаление невозможно\n");
                    continue;
                }

                System.out.println("Введите номер покупки или название покупки из списка для удаления");
                printList(list);
                String toDelete = scanner.nextLine();

                int num = 0;
                try {
                    num = Integer.parseInt(toDelete);
                } catch (NumberFormatException e) {
                }
                String toDeleteLower = toDelete.toLowerCase();
                System.out.println(toDeleteLower);
                for (int i = 0; i < list.size(); i++) {
                    String item = list.get(i);
                    String itemLower = item.toLowerCase();
                    if ((num - 1) == i || toDeleteLower.equals(itemLower)) {
                        list.remove(i);
                        System.out.println("Покупка " + item + " удалена из списка.");
                    }
                }
                printList(list);
            } else if (input.equals("4")) {
                System.out.println("Введите текст для поиска: ");
                String search = scanner.nextLine();
                String searchLower = search.toLowerCase();
                ArrayList<String> searchShopping = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    String item = list.get(i);
                    String itemLower = item.toLowerCase();
                    if (itemLower.contains(searchLower)) {
                        searchShopping.add((i + 1) + ". " + item);
                    }
                }
                if (searchShopping.size() == 0) {
                    System.out.println("Совпадений нет");
                } else {
                    System.out.println("Найдено:");
                    for (String s : searchShopping) {
                        System.out.println(s);
                    }
                }
            } else {
                System.out.println("Введите корректное значение");
            }
        }
    }

    static void printList(List<String> list) {
        int num = 0;
        System.out.println("Текущий список покупок:");
        for (String s : list) {
            num++;
            System.out.println(num + ". " + s);
        }
    }
}