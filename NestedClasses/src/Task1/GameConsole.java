package Task1;

import Task1.Brand;
import Task1.Model;
import Task2.Game;
public class GameConsole implements Powered {

    private final Brand brand;
    private final Model model;
    private final String serial;
    private final Gamepad firstGamepad;
    private final Gamepad secondGamepad;
    private boolean isOn;
    private Game activeGame;
    private int counter;


    public GameConsole(Brand brand, Model model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.firstGamepad = new Gamepad(brand, 1);
        this.secondGamepad = new Gamepad(brand, 2);
        this.isOn = false;
        this.activeGame = null;
        this.counter = 0;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Консоль включена");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("Консоль выключена");
    }


    public void loadGame(Game game) {
        activeGame = game;
        System.out.println("Игра " + game.getName() + " игра загружается");
    }


    public void playGame() {
        if (!isOn) {
            System.out.println("Игровая консоль выключена. Пожалуйста, включите её");
            return;
        }

        checkStatus();

        if (activeGame != null) {
            System.out.println("Играем " + activeGame.getName());
            System.out.println("Уровень заряда геймпадов:");
            firstGamepad.printChargeLevel();
            secondGamepad.printChargeLevel();

            firstGamepad.decreaseChargeLevel();
            secondGamepad.decreaseChargeLevel();

            if (firstGamepad.getChargeLevel() <= 0) {
                firstGamepad.setOn(false);
                System.out.println("Первый геймпад отключился из-за низкого заряда");
            }

            if (secondGamepad.getChargeLevel() <= 0) {
                secondGamepad.setOn(false);
                System.out.println("Второй геймпад отключился из-за низкого заряда");
            }
        }
    }

    private void checkStatus() {
        if (!firstGamepad.isOn() && !secondGamepad.isOn()) {
            counter++;
            if (counter > 5) {
                powerOff();
                throw new InactivityException("Игровая консоль отключается из-за бездействия");
            }
            System.out.println("Подключите геймпад. Счетчик ожидания: " + counter);
        } else {
            counter = 0;
        }
    }



    // Класс Gamepad
    class Gamepad {
        private final Brand brand;
        private final String consoleSerial;
        private final int connectedNumber;
        private Color color;
        private double chargeLevel;
        private boolean isOn;


        public Gamepad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = "XC123QeWR";
            this.color = Color.RED;
            this.chargeLevel = 100.0;
            this.isOn = false;
        }

        @Override
        public String toString() {
            return "Gamepad{" +
                    "brand=" + brand +
                    ", consoleSerial='" + consoleSerial + '\'' +
                    ", connectedNumber=" + connectedNumber +
                    ", color=" + color +
                    ", chargeLevel=" + chargeLevel +
                    ", isOn=" + isOn +
                    '}';
        }

        public void printChargeLevel() {
            System.out.println("Gamepad " + connectedNumber + " Уровень заряда: " + chargeLevel);
        }

        public void decreaseChargeLevel() {
            chargeLevel -= 10;
        }

        public Brand getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }


        public boolean isOn() {
            return isOn;
        }


        public void setColor(Color color) {
            this.color = color;
        }

        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public void setOn(boolean isOn) {
            this.isOn = isOn;
        }
    }

    @Override
    public String toString() {
        return "GameConsole{" +
                "brand=" + brand +
                ", model=" + model +
                ", serial='" + serial + '\'' +
                ", firstGamepad=" + firstGamepad +
                ", secondGamepad=" + secondGamepad +
                ", isOn=" + isOn +
                '}';
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private static class InactivityException extends RuntimeException {
        public InactivityException(String message) {
            super(message);
        }
    }
}
