public abstract class Tarolo {
    int kapacitas;
    int telitettseg;
    int vedelem;

    public Tarolo(int kapacitas, int telitettseg, int vedelem) {
        this.kapacitas = kapacitas;
        if (telitettseg >= 0 && telitettseg <= kapacitas){
            this.telitettseg = telitettseg;
        }else {
            throw new IllegalArgumentException("Telitettseg hataron kivul");
        }
        this.vedelem = vedelem;
    }

    public void setTelitettseg(int telitettseg){
        if (telitettseg >= 0 && telitettseg <= kapacitas){
            this.telitettseg = telitettseg;
        }else {
            throw new IllegalArgumentException("Telitettseg hataron kivul");
        }
    }

    public abstract void eltarol(int asvanyMennyiseg);

    public boolean elegBiztonsagos(){
        if(vedelem < Math.sqrt(telitettseg)){
            return false;
        }
        return true;
    }
}
