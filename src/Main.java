import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> baseNotes = new ArrayList<>(Arrays.asList(
                "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"
        ));

        System.out.print("Digite uma nota musical: ");
        String userInput = sc.nextLine().toUpperCase();

        for (int i = 0; i < baseNotes.size(); i++) {
            String note = baseNotes.get(i);
            if (note.equals(userInput)) {
                majorScaleBuilder(baseNotes, i);
            }
        }
    }

    public static void majorScaleBuilder(ArrayList<String> baseNotes, int notePosition){
        Integer[] majorScale = {2, 2, 1, 2, 2, 2, 1};
        ArrayList<String> scale = new ArrayList<>();
        int currentIndex = notePosition;

        System.out.print("Escala: ");
        System.out.print(baseNotes.get(notePosition) + " ");
        for (int interval : majorScale) {
            currentIndex = (currentIndex + interval) % baseNotes.size();
            System.out.print(baseNotes.get(currentIndex) + " ");
        }
    }
}