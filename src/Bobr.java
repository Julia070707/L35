import java.util.*;

// класс представляет бобра и реализует интерфейс Comparable для сравнения
class Bobr implements Comparable<Bobr> {
    String name;
    int age;
    int relativesCount;

    // конструктор для создания Bobr с заданными параметрами
    public Bobr(String name, int age, int relativesCount) {
        this.name = name;
        this.age = age;
        this.relativesCount = relativesCount;
    }

    // метод compareTo для сравнения объектов Bobr по возрасту
    @Override
    public int compareTo(Bobr other) {
        return Integer.compare(this.age, other.age);
    }

    // метод toString для вывода о бобре
    @Override
    public String toString() {
        return "Bobr{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", relativesCount=" + relativesCount +
                '}';
    }
}

// класс представляет компаратор для сравнения объектов Bobr по имени
class NameComparator implements Comparator<Bobr> {
    @Override
    public int compare(Bobr b1, Bobr b2) {
        return b1.name.compareTo(b2.name);
    }
}

// класс представляет компаратор для сравнения объектов Bobr по количеству родственников
class RelativesCountComparator implements Comparator<Bobr> {
    @Override
    public int compare(Bobr b1, Bobr b2) {
        return Integer.compare(b1.relativesCount, b2.relativesCount);
    }
}

// Основной класс программы
 class Main {
    public static void main(String[] args) {
        // список для хранения объектов Bobr
        List<Bobr> bobrs = new ArrayList<>();
        bobrs.add(new Bobr("Bobby", 3, 10));
        bobrs.add(new Bobr("Alice", 2, 5));
        bobrs.add(new Bobr("Charlie", 5, 8));

           // сортируем бобров по возрасту (Comparable)
        Collections.sort(bobrs);
        System.out.println("Сортировка по возрасту: " + bobrs);

         // сортируем бобров по имени (NameComparator)
        Collections.sort(bobrs, new NameComparator());
        System.out.println("Сортировка по имени: " + bobrs);

        // сортируем бобров по количеству родственников (RelativesCountComparator)
        Collections.sort(bobrs, new RelativesCountComparator());
        System.out.println("Сортировка по количеству родственников: " + bobrs);

        // сортируем бобров по имени с использованием лямбда выражения
        bobrs.sort((b1, b2) -> b1.name.compareTo(b2.name));
        System.out.println("Сортировка по имени (лямбда): " + bobrs);

        // создаем Map для хранения данных о бобрах (имя -> количество родственников)
        Map<String, Integer> bobrMap = new HashMap<>();
        for (Bobr bobr : bobrs) {
            bobrMap.put(bobr.name, bobr.relativesCount);
        }

        // Выводим Map
        System.out.println("Map с данными о бобрах: " + bobrMap);
    }
}
