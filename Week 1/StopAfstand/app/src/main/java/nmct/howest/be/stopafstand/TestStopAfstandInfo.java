package nmct.howest.be.stopafstand;

import java.util.Scanner;

/**
 * Created by BrechtCaveye on 11/05/2015.
 */
public class TestStopAfstandInfo {

    public static void main(String[] args){
    System.out.print("\nType weg: WEGDEK_DROOK met snelheid van 60 km/u en reactietijd van 1.0 sec resulteert in stopafstand van 34.02778 m.");
    System.out.print("\nType weg: WEGDEK_NAT met snelheid van 60 km/u en reactietijd van 1.0 sec resulteert in stopafstand van 44.444443 m.");

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nGeef snelheid op (in km/u):\n");
    int snel = scanner.nextInt();
    System.out.print("Geef reactietijd op (in sec, bv: 1,2):\n");
    float react = scanner.nextFloat();
    System.out.print("Welk wegtype selecteer je: NAT of DROOG\n");
    String type = scanner.next().toString();
    if(type.equals("NAT") || type.equals("DROOG"))
    {
        int ty = 0;
        if(type.equals("NAT"))
        {
            ty = 5;
        }
        else if(type.equals("DROOG"))
        {
            ty = 8;
        }
        float resultaat = StopAfstandInfo.getStopafstand(snel,react,ty);
        System.out.println("De stopafstand is: " + resultaat);
    }
    else
    {
        System.out.print("ERROR: Fout wegtype");
    }
}
}