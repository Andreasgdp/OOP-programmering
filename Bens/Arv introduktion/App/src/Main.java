public class Main {

    public static void main(String[] args) {
        HouseAnimal[] houseAnimals = new HouseAnimal[3];

        Cat miver = new Cat("miver", "Mouse");

        Date msk = new Date(20201022);
        Dog mimi = new Dog("Mimi", "Kødben", msk);

        KomodoDragon gunner = new KomodoDragon("Gunner", "Snacks");

        houseAnimals[0] = miver;
        houseAnimals[1] = mimi;
        houseAnimals[2] = gunner;

        for (HouseAnimal houseAnimal : houseAnimals) {
            System.out.println(houseAnimal.getName() + " " + houseAnimal.makeSound());
        }
    }
}
