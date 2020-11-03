import java.util.ArrayList;
import java.util.Scanner;

public class investment_returns {
    static float monte_carlo(float principal, int time_horizon, float additions) {
        /* Calculates investment return over time_horizon with variable interest rates. */
        ArrayList<Float> yearly_returns = new ArrayList<Float>();
        for (var i = 0; i < time_horizon; i++) {
            double interest = 0.05 + (Math.random() * (0.11 - 0.05));
            principal = (float) (principal * (1 + interest)) + additions;
            yearly_returns.add(principal);
        }
        var horizon_return = yearly_returns.get(yearly_returns.size() - 1); // Final investment return.
        return horizon_return;
    }

    public static void main(String[] args) {
        // Retrieving user input.
        Scanner input = new Scanner(System.in);
        System.out.println("Principal: ");
        float principal = input.nextFloat();
        System.out.println("Time Horizon (Years): ");
        int time_horizon = input.nextInt();
        System.out.println("Additional Investment (Per Year): ");
        float additions = input.nextFloat();

        // Runs monte_carlo num_of_iter times and averages final investment outputs.
        int num_of_iter = 5000;
        float aggregate_sum = 0;
        for (var i = 0; i < num_of_iter; i++) {
            var horizon_return = monte_carlo(principal, time_horizon, additions);
            aggregate_sum += horizon_return;
        }
        var averaged_return = aggregate_sum / 5000;
        String output = String.format("Your return on investment over %d years is $%f", 30, averaged_return);
        System.out.println(output);

    }
}




