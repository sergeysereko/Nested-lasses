package Task2;
import java.util.Random;

public class Game {

    private final String name;
    private final Genre genre;
    private final Type type;

    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }

    public static class GameDisk{
        private final String description;
        private final Game data;

        GameDisk(String name,Genre genre ,String description) {

            this.data = new Game(name, genre, Type.PHYSICAL);
            this.description = description;

        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }

    public static class VirtualGame{
        private int rating;
        private final Game data;

        private VirtualGame(String name, Genre genre){

            this.data = new Game(name, genre, Type.VIRTUAL);
            this.rating = generateRandomRating();
        }


        private int generateRandomRating() {
            // Generate a random rating between 0 and 5 (inclusive)
            Random random = new Random();
            return random.nextInt(6);
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            if (rating >= 0 && rating <= 5) {
                this.rating = rating;
            } else {
                throw new IllegalArgumentException("Rating must be between 0 and 5");
            }
        }

        public Game getData() {
            return data;
        }
    }

    public static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

    public static VirtualGame getVirtualGame(String name, Genre genre) {
        return new VirtualGame(name, genre);
    }
}
