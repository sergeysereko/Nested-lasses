package Task1;

public class GameConsole {

    private final Brand brand;
    private final Model model;
    private final String serial;
    private final Gamepad firstGamepad;
    private final Gamepad secondGamepad;
    private boolean isOn;



    public GameConsole(Brand brand, Model model, String serial) {
        this.brand = brand;
        this.model = model;
        this.serial = serial;
        this.firstGamepad = new Gamepad(brand, 1);
        this.secondGamepad = new Gamepad(brand, 2);
        this.isOn = false;
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

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
