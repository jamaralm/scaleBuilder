import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar;

        ArrayList<String> baseNotes = new ArrayList<>(Arrays.asList(
                "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"
        ));

        do {
            System.out.print("Digite uma nota musical: ");
            String userInput = sc.nextLine().toUpperCase();

            System.out.println("(1) Escala Maior\n(2) Escala Menor");
            int userScaleSelect =  sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < baseNotes.size(); i++) {
                String note = baseNotes.get(i);
                if (userScaleSelect == 1) {
                    if (note.equals(userInput)) {
                        majorScaleBuilder(baseNotes, i);
                    }
                } else if (userScaleSelect == 2) {
                    if (note.equals(userInput)) {
                        minorScaleBuilder(baseNotes, i);
                    }
                }
            }

            System.out.println("\nDeseja continuar? (S/N)");
            String continueInput = sc.nextLine().toUpperCase();

            continuar = continueInput.equals("S");
        } while(continuar);
    }

    public static void majorScaleBuilder(ArrayList<String> baseNotes, int notePosition){
        Integer[] majorScale = {2, 2, 1, 2, 2, 2, 1};
        int currentIndex = notePosition;

        System.out.print("Escala Maior de " +  baseNotes.get(notePosition) + ": ");
        System.out.print(baseNotes.get(notePosition) + " ");
        for (int interval : majorScale) {
            currentIndex = (currentIndex + interval) % baseNotes.size();
            System.out.print(baseNotes.get(currentIndex) + " ");
        }
    }

    public static void minorScaleBuilder(ArrayList<String> baseNotes, int notePosition){
        Integer[] minorScale = {2, 1, 2, 1, 2, 2, 1};
        int currentIndex = notePosition;

        System.out.print("Escala Menor de " + baseNotes.get(notePosition) + ": ");
        System.out.print(baseNotes.get(notePosition) + " ");
        for (int interval : minorScale) {
            currentIndex = (currentIndex + interval) % baseNotes.size();
            System.out.print(baseNotes.get(currentIndex) + " ");
        }
    }
}