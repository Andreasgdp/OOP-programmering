public class Dog extends HouseAnimal {

    private Date lastCut;

    public Dog(String name, String favoriteFood, Date lastCut) {
        super(name, favoriteFood);
        this.lastCut = lastCut;
    }

    public Date getLastCut() {
        return this.lastCut;
    }

    public String makeSound() {
        return "Vov-vov";
    }
}
