package DesignPatterns;

//Adapter Design Pattern is a structural pattern acts as a bridge btwn two incompatible interfaces, allowing them to work together.
//It is commonly used when you want to integrate a legacy system or third-party library with your application without modifying their code

// Target Interface - The interface that the client code expects.
interface Printer {
    void print(String content);
}

// Adaptee - The existing class with an incompatible interface.
class LegacyPrinter {
    public void printDocument(String text) {
        System.out.println("Legacy Printer is printing a document: " + text);
    }
}

// Adapter - The class that adapts the LegacyPrinter to the Printer interface.
class PrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String content) {
        legacyPrinter.printDocument(content); // Adapting the call
    }
}

// Client - The code that interacts with the Printer interface.
public class AdapterDP {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer printer = new PrinterAdapter(legacyPrinter); // Using the adapter
        printer.print("Hello from the new system!");
    }
}


/*
One of the great real life example of Adapter design pattern is mobile charger.
Mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V (India).
So the mobile charger works as an adapter between battery socket and the wall socket.

Key Components:
Target Interface
Adaptee
Adapter
client

How it Works:
The client interacts with the Adapter through the Target Interface.
The Adapter receives the client's request and translates it into a format compatible with the Adaptee's interface.
The Adapter then calls the appropriate method on the Adaptee to perform the desired operation.
The Adaptee executes the operation and returns the result to the Adapter.
The Adapter may then translate the result back into a format expected by the Target Interface before returning it to the client.
 */