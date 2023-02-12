public class ProductMachine extends ElementarMachine<Product> {

    public ProductMachine(int count, Product thing) {
        super(count, thing);
    }

    public ProductMachine() {
        super();
    }

    public void addProduct(int n, Perishable produto) {
        try{
            if(n < 0){
                throw new IllegalArgumentException("O valor nao pode ser negativo");
            }
        addThings(n, produto);
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public void addProduct(int n, NonPerishable produto) {
        try{
            if(n < 0){
                throw new IllegalArgumentException("O valor nao pode ser negativo");
            }
        addThings(n, produto);
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public boolean hasProduct(Product produto) {
        boolean resultado = false;

        for (int i = 0; i <= lista.size() - 1; i++) {
            Element<Product> existeTeste = lista.get(i);
            if ((existeTeste.getThing()).getName().equals(produto.getName())) {
                resultado = true;

            }
        }
        return resultado;
    }

    // ordem crescente de custo
    // usado bubblesort para organizar a lista, e a guarda organizada para nao ser
    // necessario
    // fazer a mesma operacao duas vezes
    public void listAllOrdered() {
        Element<Product> ProdutoTemp = lista.get(0);
        double valorAtual = 0;
        double valorProx = 0;
        int CountProduto = 0;
        double PrecoProdutos = 0;
        String ElementoProduto;
        String NomeProduto;
        for (int ContadorExterior = 0; ContadorExterior <= lista.size() - 1; ContadorExterior++) {
            for (int ContadorInterior = 0; ContadorInterior < lista.size() - 1 - ContadorExterior; ContadorInterior++) {
                valorAtual = (lista.get(ContadorInterior).getThing()).getPrice();
                valorProx = (lista.get(ContadorInterior + 1).getThing()).getPrice();
                if (valorAtual > valorProx) {
                    ProdutoTemp = lista.get(ContadorInterior);
                    lista.set(ContadorInterior, lista.get(ContadorInterior + 1));
                    lista.set(ContadorInterior + 1, ProdutoTemp);
                }
            }
        }
        for (int i = 0; i <= lista.size() - 1; i++) {
           NomeProduto = lista.get(i).getThing().getName();
           PrecoProdutos = lista.get(i).getThing().getPrice();
           
            CountProduto = lista.get(i).getCount();
            ElementoProduto = lista.get(i).getThing().getClass().getSimpleName();
            System.out.println("Element [" + ElementoProduto + "=Product"
            +" [name="+NomeProduto +", cost="+ PrecoProdutos + "], count = " + CountProduto + "]");
        }

    }

}