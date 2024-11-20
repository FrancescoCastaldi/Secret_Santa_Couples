import java.util.*;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> participants = getParticipants(input);
        List<String> giftReceivers = generateGiftAssignments(participants);
        displayAssignments(participants, giftReceivers);
        input.close();

        System.out.println("\n🎄 Tanti auguri! 🎅");
    }
    private static List<String> getParticipants(Scanner input) {
        int count;
        do {
            System.out.print("🎄 Numero di partecipanti: ");
            try {
                count = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                count = 0;
            }
        } while (count < 2);
        List<String> participants = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("👥 Nome partecipante " + (i + 1) + ": ");
            participants.add(input.nextLine());
        }
        return participants;
    }
    private static List<String> generateGiftAssignments(List<String> participants) {
        List<String> receivers = new ArrayList<>(participants);
        while (true) {
            Collections.shuffle(receivers);
            if (isValidAssignment(participants, receivers)) break;
        }
        return receivers;
    }
    private static boolean isValidAssignment(List<String> givers, List<String> receivers) {
        return IntStream.range(0, givers.size())
                .noneMatch(i -> givers.get(i).equals(receivers.get(i)));
    }
    private static void displayAssignments(List<String> givers, List<String> receivers) {
        System.out.println("\n🎁 Abbinamenti Segreti:");
        for (int i = 0; i < givers.size(); i++) {
            System.out.printf("🔮 %s regala a %s\n", givers.get(i), receivers.get(i));
        }
    }
}
