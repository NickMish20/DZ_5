package DZ_5;

//1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// 1.1). Дан список сотрудников:
    // Иван Иванов
    // Светлана Петрова
    // Кристина Белова
    // Анна Мусина
    // Анна Крутова
    // Иван Юрин
    // Петр Лыков
    // Павел Чернов
    // Петр Чернышов
    // Мария Федорова
    // Марина Светлова
    // Мария Савина
    // Мария Рыкова
    // Марина Лугова
    // Анна Владимирова
    // Иван Мечников
    // Петр Петин
    // Иван Ежов
    // Написать программу, которая найдёт и выведет повторяющиеся имена с
    // количеством повторений. Отсортировать по убыванию популярности.



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import javax.swing.RowFilter.Entry;

public class Zadacha_1 {
    
    public static void main(String[] args) {
        HashMap<String, Integer> humans = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./DZ_5/people.txt"));
            String fullName;
            while ((fullName = br.readLine()) != null) {
                String[] name = fullName.split(" ");
                if (humans.containsKey(name[0])) {
                    int count = (int) humans.get(name[0]);
                    humans.put(name[0], ++count);
                } else {
                    humans.put(name[0], 1);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
         humans = sortHumans(humans);
        for (Map.Entry<String, Integer> item : humans.entrySet()) {
            System.out.printf("[%S: %d]\n", item.getKey(), item.getValue());
        }

    }

    /**
     СЛАВСЯ chatJPT !!! :)
     */
    public static HashMap<String, Integer> sortHumans(HashMap<String, Integer> hashMap) {
        // Преобразование записей HashMap в список
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        // Сортировка списка в порядке убывания (от большего к меньшему) на основе
        // значений
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // Создание новой LinkedHashMap для сохранения отсортированных значений
        LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}