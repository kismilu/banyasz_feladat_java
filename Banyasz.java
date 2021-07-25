public class Banyasz {
    private Taska taska;
    private Raktar raktar;

    public Banyasz(Raktar raktar) {
        this.taska = new Taska(15,0,4);
        this.raktar = raktar;
    }

    public boolean banyaszik(int asvanyMennyiseg) throws OmlasException{
        double currentAtlag = taska.atlagMennyiseg();
        try {
            taska.eltarol(asvanyMennyiseg);
        }catch (IllegalArgumentException e){
            raktar.feldolgoz(taska);
            taska.eltarol(asvanyMennyiseg);
        }
        if (raktar.elegBiztonsagos() == false){
            throw new OmlasException();
        }

        double ujAtlag = taska.atlagMennyiseg();
        return ujAtlag > currentAtlag;
    }
}
