/**
 * Created by Vaio on 20.11.2016.
 */
public class ExceptiiDeclarateSiTratate {

    public static void main(String[] args) {


        ExceptiiDeclarateSiTratate obj = new ExceptiiDeclarateSiTratate();
        String a = "ana are mere";
        String b = "gandul nostru ana este";
        String c = null;

        try{
            System.out.println("primul"+obj.doesItSTartWithAna(a));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("al doilea"+ obj.doesItSTartWithAna(c));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("al treilea"+ obj.doesItSTartWithAna(b));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //daca o metoda arunca exceptii,ea obliga pe cei ce o apeleaza
    //sa trateze exceptia sau sa o arunce mai departe

    private boolean doesItSTartWithAna(String sentence) throws Exception { //cu throws anunt ca arunc
        if (sentence==null)
            throw  new Exception("nu e permis null");
            boolean yes = false;
            if(sentence.startsWith("ana")||sentence.startsWith("Ana"))
                yes = true;
             return yes;


    }
}
