import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Homework16 { //Задача 1.
    public static void main(String[] args) { // объявляем главный метод main
        ArrayList<Integer> list = new ArrayList<>(); // создаем список целых чисел
        Random random = new Random(); // создаем объект random для генерации случайных чисел
        for (int i = 0; i < 10; i++) { // повторяем 10 раз
            list.add(random.nextInt(10) + 1); // добавляем в список случайное число от 1 до 10
        }
        System.out.println("Список: " + list); // выводим список на экран
        System.out.println("Список в обратном порядке: "); // выводим сообщение на экран
        for (int i = list.size() - 1; i >= 0; i--) { // проходим по списку с конца до начала
            System.out.print(list.get(i) + " "); // выводим элемент списка на экран
        }
        System.out.println(); // переходим на новую строку
        int max = Collections.max(list); // находим максимальный элемент в списке
        int min = Collections.min(list); // находим минимальный элемент в списке
        System.out.println("Максимум: " + max); // выводим максимум на экран
        System.out.println("Минимум: " + min); // выводим минимум на экран
        HashSet<Integer> set = new HashSet<>(list); // создаем множество из списка, чтобы удалить повторяющиеся элементы
        list.clear(); // очищаем список
        list.addAll(set); // добавляем в список все элементы из множества
        System.out.println("Список без повторений: " + list); // выводим список без повторений на экран

        class Human implements Comparable<Human> { // объявляем класс Human с реализацией интерфейса Comparable для сравнения по имени
            String name; // объявляем поле name для хранения имени человека
            int age; // объявляем поле age для хранения возраста человека
            int iq; // объявляем поле iq для хранения уровня интеллекта человека

            public Human(String name, int age, int iq) { // объявляем конструктор класса Human с тремя параметрами: name, age и iq
                this.name = name; // присваиваем полю name значение параметра name
                this.age = age; // присваиваем полю age значение параметра age
                this.iq = iq; // присваиваем полю iq значение параметра iq
            }

            @Override // переопределяем метод compareTo интерфейса Comparable для сравнения по имени
            public int compareTo(Human o) { // объявляем метод compareTo с параметром o типа Human
                return this.name.compareTo(o.name); // возвращаем результат сравнения имени текущего объекта и имени объекта o
            }

            @Override // переопределяем метод toString для вывода информации о человеке в виде строки
            public String toString() { // объявляем метод toString без параметров
                return "Human{" + "name='" + name + '\'' + ", age=" + age + ", iq=" + iq + '}'; // возвращаем строку с информацией о человеке в формате: Human{name='...', age=..., iq=...}
            }
        }

        class AgeComparator implements java.util.Comparator<Human> { // объявляем класс AgeComparator с реализацией интерфейса Comparator для сравнения по возрасту
            @Override // переопределяем метод compare интерфейса Comparator для сравнения по возрасту
            public int compare(Human o1, Human o2) { // объявляем метод compare с двумя параметрами: o1 и o2 типа Human
                return Integer.compare(o1.age, o2.age); // возвращаем результат сравнения возраста объекта o1 и возраста объекта o2
            }
        }

        ArrayList<Human> humans = new ArrayList<>(); // создаем список людей
        humans.add(new Human("Alice", 25, 120)); // добавляем в список человека с именем Alice, возрастом 25 и iq 120
        humans.add(new Human("Bob", 30, 110)); // добавляем в список человека с именем Bob, возрастом 30 и iq 110
        humans.add(new Human("Charlie", 35, 100)); // добавляем в список человека с именем Charlie, возрастом 35 и iq 100
        humans.add(new Human("David", 40, 90)); // добавляем в список человека с именем David, возрастом 40 и iq 90
        humans.add(new Human("Eve", 45, 80)); // добавляем в список человека с именем Eve, возрастом 45 и iq 80
        System.out.println("Список людей: " + humans); // выводим список людей на экран
        Collections.sort(humans); // сортируем список людей по имени с помощью метода sort класса Collections
        System.out.println("Список людей отсортированный по имени: " + humans); // выводим отсортированный список на экран
        Collections.sort(humans, new AgeComparator()); // сортируем список людей по возрасту с помощью метода sort класса Collections и объекта класса AgeComparator
        System.out.println("Список людей отсортированный по возрасту: " + humans); // выводим отсортированный список на экран

        System.out.println("Вывод списка людей с помощью Iterator: "); // выводим сообщение на экран
        java.util.Iterator<Human> iterator = humans.iterator(); // создаем объект iterator для прохода по списку людей
        while (iterator.hasNext()) { // пока есть следующий элемент в списке
            System.out.println(iterator.next()); // выводим его на экран
        }

        System.out.println("Вывод списка людей с помощью for: "); // выводим сообщение на экран
        for (int i = 0; i < humans.size(); i++) { // проходим по списку людей от начала до конца
            System.out.println(humans.get(i)); // выводим элемент списка на экран
        }

        System.out.println("Вывод списка людей с помощью forEach: "); // выводим сообщение на экран
        for (Human human : humans) { // проходим по списку людей используя улучшенный цикл for
            System.out.println(human); // выводим элемент списка на экран
        }
    }
}
