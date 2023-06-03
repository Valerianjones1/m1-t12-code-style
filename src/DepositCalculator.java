import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         double value = amount + amount * yearRate * depositPeriod;
         return round(value, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void printMenu() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double income = 0;
        if (action == 1) {
            income = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            income = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.printMenu();
    }

}
