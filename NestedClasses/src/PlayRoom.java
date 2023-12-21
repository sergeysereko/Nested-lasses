import Task1.Model;
import Task2.Game;
import Task1.GameConsole;

import java.util.Arrays;
import java.util.Comparator;
public class PlayRoom {

    public static void main(String[] args) {
        // Создаем массив с играми на физических носителях
        Game.GameDisk[] physicalGames = new Game.GameDisk[]{
                Game.getDisk("Game1", Task2.Genre.ACTION, "Description1"),
                Game.getDisk("Game2", Task2.Genre.SPORT, "Description2"),
                Game.getDisk("Game3", Task2.Genre.RACE, "Description3"),
                Game.getDisk("Game4", Task2.Genre.ACTION, "Description4")
        };

        // Создаем массив с играми из виртуального магазина
        Game.VirtualGame[] virtualGames = new Game.VirtualGame[]{
                Game.getVirtualGame("VirtualGame1", Task2.Genre.ACTION),
                Game.getVirtualGame("VirtualGame2", Task2.Genre.SPORT),
                Game.getVirtualGame("VirtualGame3", Task2.Genre.RACE),
                Game.getVirtualGame("VirtualGame4", Task2.Genre.ACTION)
        };

        // Создаем объект GameConsole
        GameConsole gameConsole = new GameConsole(Task1.Brand.SONY, Model.PS4_PRO, "PS4SerialNumber");

        // Пример использования созданных объектов
        System.out.println("Physical Games:");
        for (Game.GameDisk physicalGame : physicalGames) {
            System.out.println("Game name: " + physicalGame.getData().getName());
            System.out.println("Game genre: " + physicalGame.getData().getGenre());
            System.out.println("Game type: " + physicalGame.getData().getType());
            System.out.println("Game description: " + physicalGame.getDescription());
            System.out.println();
        }

        System.out.println("Virtual Games:");
        for (Game.VirtualGame virtualGame : virtualGames) {
            System.out.println("Game name: " + virtualGame.getData().getName());
            System.out.println("Game genre: " + virtualGame.getData().getGenre());
            System.out.println("Game type: " + virtualGame.getData().getType());
            System.out.println("Game rating: " + virtualGame.getRating());
            System.out.println();
        }

        System.out.println("Game Console:");
        System.out.println("Brand: " + gameConsole.getBrand());
        System.out.println("Model: " + gameConsole.getModel());
        System.out.println("Serial Number: " + gameConsole.getSerial());
        System.out.println("Is Console On: " + gameConsole.isOn());


        // Сортировка массива с физическими дисками по жанру
        Arrays.sort(physicalGames, new Comparator<Game.GameDisk>() {
            @Override
            public int compare(Game.GameDisk game1, Game.GameDisk game2) {
                return game1.getData().getGenre().compareTo(game2.getData().getGenre());
            }
        });

        // Сортировка массива с виртуальными играми по рейтингу
        Arrays.sort(virtualGames, new Comparator<Game.VirtualGame>() {
            @Override
            public int compare(Game.VirtualGame game1, Game.VirtualGame game2) {
                return Integer.compare(game1.getRating(), game2.getRating());
            }
        });

        // Вывод результатов сортировки
        System.out.println("Sorted Physical Games by Genre:");
        for (Game.GameDisk physicalGame : physicalGames) {
            System.out.println("Genre: " + physicalGame.getData().getGenre() + ", Description: " + physicalGame.getDescription());
        }

        System.out.println("\nSorted Virtual Games by Rating:");
        for (Game.VirtualGame virtualGame : virtualGames) {
            System.out.println("Rating: " + virtualGame.getRating() + ", Name: " + virtualGame.getData().getName());
        }
    }
}