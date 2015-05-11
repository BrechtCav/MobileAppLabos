package nmct.howest.be.bmi;

import java.util.Scanner;

/**
 * Created by BrechtCaveye on 11/05/2015.
 */
public class RunBMI {
    public static  void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height(in m, eg:1,72):\n");
        float height = scanner.nextFloat();

        System.out.print("Enter your mass(in kg, eg:70):\n");
        int mass = scanner.nextInt();
        float result = BMIInfo.recalculate(height, mass);
        BMIInfo.Category cat = BMIInfo.Category.getGategory(result);
        System.out.print("\n Uw BMI is : " + result + " , you are in the category: " + cat.name());
    }
}
