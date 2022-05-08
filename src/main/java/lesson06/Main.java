package lesson06;

public class Main{
    public static void main(String[] args) {

        Cat cat = new Cat(200);
        Dog dog = new Dog(500, 100);
        Dog littleDog = new Dog(500, 10);

        System.out.println(dog.run(100));
        System.out.println(dog.swim(70));
        System.out.println(cat.getSwimDistance());
        System.out.println(cat.swim(30));

        System.out.println("Animal count: " + Animal.getAnimalCount());
        System.out.println("Cat count: " + Cat.getCatCount());
        System.out.println("Dog count: " + Dog.getDogCount());

    }
}

/*


        2. В классе Животное добавить методы run и swim, которые принимают дистанцию и возвращают true или false в зависимости от того, может ли животное преодолеть данную дистанцию данным способом. У каждого животного есть ограничения: бег: кот 200, собака 500; плавание: кот не умеет плавать, собака 10

        3.* Добавить возможность задавать индивидуальные параметры плавания и бега для животных (т.е. для каждого объекта параметры плавания и бега будут свои), причем важно сохранить невозможность плавания для кота

        4.* Добавить подсчет создаваемых собак, котов и всех животных вместе.
        Подсказка: использовать статическую переменную в классе

        */
