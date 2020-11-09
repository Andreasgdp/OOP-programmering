public class KomodoDragon extends HouseAnimal {

    private final int numPeopleKilled;

    public KomodoDragon(String name, String favoriteFood) {
        super(name, favoriteFood);
        this.numPeopleKilled = 0;
    }

    public int getNumPeopleKilled() {
        return this.numPeopleKilled;
    }

    public String makeSound() {
        return "Fuck off!";
    }

}
