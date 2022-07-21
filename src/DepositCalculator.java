import java.util.Scanner;

public class DepositCalculator
{
    double calculateComplexPercent(double amount, double yearRate,int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate/ 12), 12 *depositPeriod);
        return getRoundValue(pay, 2);
    }

    double calculateSimplePercent(double amount,double yearRate, int depositPeriod) {
        return getRoundValue(amount+amount * yearRate *depositPeriod, 2);
    }

    double getRoundValue(double value, int places) {
        double scaLe= Math.pow(10, places);
        return Math.round(value*scaLe)/scaLe;
    }

    void calculateOutAmount( ) {
        int period;
        int action;
        int amount;
        double outAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action ==1) {
            outAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outAmount = calculateComplexPercent(amount, 0.06, period);
        }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateOutAmount();
    }
}
