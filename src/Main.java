import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //Queue<Person> list = (Queue<Person>) generateClients();  //принудительное заставление принимать джаву значения лучше не использовать
        Queue<Person> listQueue = new LinkedList<>();
        listQueue.offer(generateClients().get(0));  //добавляем по индексу
        listQueue.offer(generateClients().get(1));
        listQueue.offer(generateClients().get(2));
        listQueue.offer(generateClients().get(3));
        listQueue.offer(generateClients().get(4));

        while (!listQueue.isEmpty()) {  //пока очередь не пуста
            Person sv = listQueue.poll();
            if (sv.ticket > 0) {   ////проверка на наличие билетов
                sv.ticket --;  //уменьшение билетов
                System.out.println(sv.name + " " + sv.lastName + " " + "прокатился на аттракционе");  //показать кто покатался
                if (sv.ticket <= 0) {   //проверка на наличие билетов
                    continue; // если нет билетов, то просто переходим к следующему в очереди
                } else {
                    listQueue.offer(sv); //если билеты еще остались, дописываем в конец очереди
                }
            }
        }
    }
    public static List<Person> generateClients() {
        List<Person> list = new LinkedList<>(); //создаем список

        Person person1 = new Person("Nikita", "Fedotov", 1);  //создаем человека и количество билетов
        list.add(person1);
        Person person2 = new Person("Banya", "Zimov", 3);  //создаем человека и количество билетов
        list.add(person2);
        Person person3 = new Person("Oleg", "Grachov", 5);  //создаем человека и количество билетов
        list.add(person3);
        Person person4 = new Person("Anna", "Ivanova", 2);  //создаем человека и количество билетов
        list.add(person4);
        Person person5 = new Person("Katya", "Petrova", 2);  //создаем человека и количество билетов
        list.add(person5);
        return list;
    }
}
