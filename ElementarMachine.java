import java.io.*;
import java.util.*;

 class ElementarMachine<T> implements Serializable  {
    public List<Element<T>> lista;

    public ElementarMachine(int count, T thing) {
        this.lista = new ArrayList<Element<T>>();
        Element<T> temp = new Element<T>(count, thing);
        this.lista.add(temp);
        }

    public ElementarMachine(){
        this.lista = new ArrayList<Element<T>>();
    }
    /*x
     * Para adicionar um elemento na lista, e preciso verificar se ja existe um dele na lista,
     * se for a primeira ocorrencia, e simplesmente adicionado ao fim da lista o novo objeto,
     * se ele ja existir, e criado uma copia do objeto que esta na lista, e realizado a soma
     * do count da lista com o que foi passado nos argumentos, apos a soma e guardado na copia
     * do objeto e sao colocados para repor o objeto original da lista
     */

    public void addThings(int count, T thing){
        Element<T> temp = new Element<T>(count, thing);
        int index = -1;
        for(int i = 0; i<=lista.size()-1;i++){
            Element<T> existeTeste = lista.get(i);
            if((existeTeste.getThing()).equals(thing)){
            index = i;
            Element<T> troca = lista.get(index);
            troca.setCount(temp.getCount()+troca.getCount());
            lista.set(index, troca);
            }
        }
        if(index == -1){
        this.lista.add(temp);
        }
    }
    /*
     * Para remover uma unidade do objeto, vai ser necessario verificar se existe o objeto,
     * se existe, criar uma copia temporaria dele, subtrair -1 do seu contador e substituir 
     * pela sua versao presente na lista
     */
    public boolean removeOneThing(T thing){
        boolean resultado = false;
        int index = -1; 
        for(int i = 0; i<=lista.size()-1;i++){
            Element<T> existeTeste = lista.get(i);
            if(existeTeste.getThing().equals(thing)){
                index = i;
                Element<T> troca = lista.get(index);
                troca.setCount(troca.getCount()-1);
                lista.set(index, troca);
            }
        }
        return resultado;
    }
    /*
     * E escrito no terminal cada elemento da lista no formato definido na interface Element
     */
    public void listAll(){
        for(int i = 0; i <=lista.size()-1;i++){
            System.out.println((lista.get(i)).toString());
        }
    }
}
