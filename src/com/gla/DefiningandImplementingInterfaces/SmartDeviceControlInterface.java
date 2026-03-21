package com.gla.DefiningandImplementingInterfaces;

public class SmartDeviceControlInterface {
    // The Interface
    interface SmartDevice {
        void turnOn();
        void turnOff();
    }

    // Implementation: Smart Light
    class SmartLight implements SmartDevice {
        public void turnOn() {
            System.out.println("Light: LED panel activated at 80% brightness.");
        }
        public void turnOff() {
            System.out.println("Light: LED panel powered down.");
        }
    }

    // Implementation: Air Conditioner
    class AirConditioner implements SmartDevice {
        public void turnOn() {
            System.out.println("AC: Compressor started, cooling to 22°C.");
        }
        public void turnOff() {
            System.out.println("AC: Fan stopping, vents closing.");
        }
    }
}
