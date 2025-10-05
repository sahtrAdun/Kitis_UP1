package task1_1;

public class LinearAlgorithm {
    public static void main(String[] args) {
        int masterRate = 30;
        int studentRate = 15;
        int totalDetails = 180;

        int combinedRate = masterRate + studentRate;
        double timeRequired = (double) totalDetails / combinedRate;

        System.out.println("Время, необходимое мастеру и ученику: " + timeRequired + " часов");
    }
}
