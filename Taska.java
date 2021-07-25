import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Taska extends Tarolo{
    private List<Integer> asvanyMennyisegek;

    public List<Integer> getAsvanyMennyisegek() {
        List<Integer> masoltLista = new ArrayList<>(asvanyMennyisegek);
        return masoltLista;
    }

    public Taska(int kapacitas, int telitettseg, int vedelem) {
        super(kapacitas, telitettseg, vedelem);
        asvanyMennyisegek = new ArrayList<>();
    }

    @Override
    public void eltarol(int asvanyMennyiseg) {
        setTelitettseg(telitettseg+asvanyMennyiseg);
        asvanyMennyisegek.add(asvanyMennyiseg);
    }

    public double atlagMennyiseg(){
        int osszeg = 0;
        int darab = 0;
        for (int i : asvanyMennyisegek){
            osszeg += i;
            darab++;
        }
        if (osszeg != 0){
            return (double)osszeg/darab;
        }
        else{
            return 0.0;
        }
    }

    public void kiurit(){
        asvanyMennyisegek.clear();
        this.telitettseg = 0;
    }

    public static List<Taska> taskakatBetolt(String fajlnev){
        Scanner sc = null;
        List<Taska> taska = new ArrayList<>();
        try{
            File file = new File(fajlnev);
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                Taska taska1;
                String[] szavak = sc.nextLine().split(";");
                taska1 = new Taska(Integer.parseInt(szavak[0]),0,Integer.parseInt(szavak[1]));
                for (int i = 2; i < szavak.length; i++){
                    int current = Integer.parseInt(szavak[i]);
                    taska1.eltarol(current);
                }
                taska.add(taska1);
            }
        }
        catch (FileNotFoundException f){
            System.err.println("Hiba történt: " + f.getMessage());
            return new ArrayList<>();
        }finally {
            if (sc != null){
                sc.close();
            }
        }
        return taska;
    }
}
