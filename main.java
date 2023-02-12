import java.util.*;
public class vendas {
    public static void main(String[] args) {
        ProductMachine produtos = new ProductMachine();
        produtos.addProduct(10, new Perishable("Leite", 10, new Date()));
        produtos.addProduct(10, new Perishable("Ovos", 3, new Date()));
        produtos.addProduct(10, new Perishable("Bolacha", 2, new Date()));
        produtos.addProduct(10, new Perishable("Carne", 12, new Date()));

        MoneyMachine dinheiros = new MoneyMachine();
        dinheiros.addThings(10, 2.0f);
        dinheiros.addThings(10, 0.5f);
        dinheiros.addThings(10, 1f);
        dinheiros.addThings(10, 0.5f);

        VendingMachine maquina = new VendingMachine(produtos, dinheiros);
        System.out.println("dinheiro na maquina: "+ maquina.getMoneyMachine().getTotalValue());
        maquina.Venda(new Perishable("Leite", 10, new Date()),15);
        System.out.println("dinheiro na maquina: "+ maquina.getMoneyMachine().getTotalValue());

    }
}