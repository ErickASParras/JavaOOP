
import java.util.*;

public class MoneyMachine extends ElementarMachine<Float> {
    private List<Float> banco;
    
public MoneyMachine(List<Float> banco) {
        this.banco = banco;
    }
public MoneyMachine(){
    List<Float> banco = new ArrayList<>();
    this.banco = banco;
}
public void addMoney(int n, float dinheiro){
    for(int i = n; i != 0 ; i--){
        this.banco.add(dinheiro);
    }
}
public float getTotalValue(){
    float resultado = 0;
    for(int i = 0; i<= banco.size()-1;i++){
        resultado = resultado + banco.get(i);
    }
    for (int i = 0; i <= lista.size() - 1; i++) {
        resultado = resultado + (lista.get(i)).getCount();
    }
    return resultado;
}
}
