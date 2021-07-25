import java.util.ArrayList;
import java.util.List;

public class Raktar extends Tarolo{
    public Raktar(int kapacitas, int telitettseg, int vedelem) {
        super(kapacitas, telitettseg, vedelem);
    }

    @Override
    public void eltarol(int asvanyMennyiseg) {
        setTelitettseg(telitettseg+asvanyMennyiseg);
    }

    public void feldolgoz(Taska t){
        try{
            List<Integer> ujlista = new ArrayList<>(t.getAsvanyMennyisegek());
            for (int i : ujlista) {
                eltarol(i);
            }
        }
        finally{
            t.kiurit();
        }
    }
}
