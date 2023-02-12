
import java.util.Date;
public class Perishable extends Product implements Freshness{
    private Date limitDate;

    public Perishable(String produto, double quantidade, Date limitDate) {
        super(produto, quantidade);
        this.limitDate = limitDate;
    }

    @Override
    public boolean isFromToday() {
        boolean resultado = false;
        Date hoje = new Date();
        if(hoje.equals(limitDate)){
            resultado = true;
        }

        return resultado;
    }

    @Override
    public boolean isOutDated() {
    boolean resultado = false;
    Date hoje = new Date();
        if(hoje.after(limitDate)){
            resultado = true;
        }
        return resultado;
    }
}