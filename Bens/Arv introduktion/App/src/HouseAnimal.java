public abstract class HouseAnimal {
    private String name;
    private String favoriteFood;

    public HouseAnimal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return this.name;
    }

    public String getFavoriteFood() {
        return this.favoriteFood;
    }

    public String makeSound(){
        return "Unknown animal sound";
    }
}
