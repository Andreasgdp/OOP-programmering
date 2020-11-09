public class Cat extends HouseAnimal {

    private final int numMouseCaught;

    public Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
        this.numMouseCaught = 0;
    }

    public int getNumMouseCaught() {
        return this.numMouseCaught;
    }

    public String makeSound() {
        return "Miaw";
    }

}
