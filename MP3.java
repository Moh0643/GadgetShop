import java.util.Scanner;

public class MP3 extends Gadget {
    private double availableMemory;

    public MP3(String model, double price, float weight, String size, double availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public double getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the music download (in MB):");
        double musicSize = Double.parseDouble(scanner.nextLine());

        if (musicSize > 1000) {
            System.out.println("Error: Not enough space. Please download a smaller file.");
            downloadMusic(); // Ask user to try again
        } else if (musicSize <= availableMemory) {
            availableMemory -= musicSize;
            System.out.println("Music downloaded successfully.");
            System.out.println("Available memory after downloading: " + availableMemory + " MB");
        } else {
            System.out.println("Error: Insufficient memory to download music.");
            System.out.println("Available memory: " + availableMemory + " MB");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        MP3 mp3Player = new MP3("Sony Walkman", 50.0, 50.0f, "100mm x 50mm x 10mm", 1000.0);
        System.out.println("Initial available memory: " + mp3Player.getAvailableMemory() + " MB");

        mp3Player.downloadMusic();
    }
}
