class PetrolPump{
    int petrol, distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}
public class Tour{
    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, totalSurplus = 0, currentSurplus = 0;

        for (int i = 0; i < pumps.length; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;

            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        if (totalSurplus >= 0) {
            return start;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(1, 6),
            new PetrolPump(3, 9),
            new PetrolPump(0, 3),
            new PetrolPump(5, 5)
        };
        int startPoint = findStartingPoint(pumps);
        if (startPoint == -1) {
            System.out.println("Not possible");
        } else {
            System.out.println("Start at: " + startPoint);
        }
    }
}
