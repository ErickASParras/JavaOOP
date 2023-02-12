public abstract class Product{
    private String name;
    private double Price;

    public Product(String produto, double preco){
        try{
            if(preco < 0){
                throw new IllegalArgumentException("O valor nao pode ser negativo");
            }
            setName(produto);
            setPrice(preco);  
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public double getPrice() {
        return Price;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }
}