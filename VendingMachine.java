import java.io.*;
public class VendingMachine implements Serializable{
    private  static MoneyMachine banco;
    private static ProductMachine produtos;

    public VendingMachine(ProductMachine produtos,MoneyMachine banco) {
        setMoneyMachine(banco);
        setProductMachine(produtos);
    }
    public MoneyMachine getMoneyMachine() {
        return banco;
    }
    public void setMoneyMachine(MoneyMachine arg) {
        banco = arg;
    }
    public ProductMachine getProductMachine() {
        return produtos;
    }
    public void setProductMachine(ProductMachine arg) {
        produtos = arg;
    }
    
    public static void saveMachine(VendingMachine maquina, String arquivo){
        try{ 
        File outFile = new File(arquivo);
        FileOutputStream FileSave = new FileOutputStream(outFile);
        ObjectOutputStream save = new ObjectOutputStream(FileSave);
        save.writeObject(maquina.getMoneyMachine());
        save.writeObject(maquina.getProductMachine());
        save.close();
        }catch(IOException e){
            System.out.println(e);
            System.out.println("Saving error");
        }
    }
    
    public static VendingMachine restoreMachine(String arquivo){
        MoneyMachine dinheiroTemp = banco;
        ProductMachine produtosTemp = produtos;
        VendingMachine resultado = new VendingMachine(produtosTemp,dinheiroTemp);
        try{
            File outFile = new File(arquivo);
            FileInputStream FileSave = new FileInputStream(outFile);
            ObjectInputStream reader = new ObjectInputStream(FileSave);
            dinheiroTemp =(MoneyMachine)reader.readObject();
            produtosTemp =(ProductMachine)reader.readObject();
            reader.close();
            return resultado;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Loading error");
        }
        resultado.setProductMachine(produtosTemp);
        resultado.setMoneyMachine(dinheiroTemp);
        return resultado;
    }

    public void Venda(Perishable compra, float pagamento){
        try{
            if(!produtos.hasProduct(compra)){
                throw new IllegalArgumentException("o produto não esta na maquina");
        }   
        int index = 0;
            for(int i = 0 ; i < produtos.lista.size()-1 ; i++){
                if((produtos.lista.get(i).getThing().getName()).equals(compra.getName())){
                    index += i;
                    break;
                }
            }
            double preco = produtos.lista.get(index).getThing().getPrice();
            if(pagamento<preco){
                throw new IllegalArgumentException("valor menor do que o esperado");
            }
            produtos.removeOneThing(compra);
            if(pagamento != preco){
                double troco = pagamento - preco;
                System.out.println("Compra feita com sucesso! \n Seu troco é = "+troco);
                banco.addMoney(1,pagamento-(float)troco);
            }else{
            System.out.println("Compra feita com sucesso!");
            banco.addMoney(1,pagamento);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}