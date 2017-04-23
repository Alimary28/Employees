/**
 * Created by Vaio on 20.11.2016.
 */
public class ExceptiiDeRuntime{

    public static void main(String[] args) {


        try{
            int[] numere = new int [2];
            numere [0] = 6;
            numere [1] = 61;
            numere [2] = 13;
        }
        catch (Exception e){
            System.out.println("exemplu de ce nu se prinde exceptia ci se fixeaza in cod");
            e.printStackTrace();
        }
        System.out.println("gata programul,doar daca o exceptie e tratata se ajunge aici");

    }
}