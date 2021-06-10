public class Food {
    private String RName;
    private String food_name;
    private int price;
    private int ID;
    private int quantity;
    private String category;
    private int offer;



    Food(String n , String fn , int i, int p , int q, String c,int o) {
        this.RName = n;
        this.food_name =fn;
        this.ID = i;
        this.price = p;
        this.quantity = q;
        this.category = c;
        this.offer = o;
    }

    public String getRName(){
        return RName;
    }
    public String getFood_name(){
        return food_name;
    }
    public int getPrice(){
        return price;
    }
    public int getID(){
        return ID;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getCategory(){
        return category;
    }
    public int getOffer(){
        return  offer;
    }
    public void setFood_name(String s){
        food_name = s;
    }
    public void setPrice(int p){
        price = p;
    }
    public void setQuantity(int q){
        quantity = q;
    }
    public void setCategory(String c){
        category = c;
    }
    public void setOffer(int o){
        offer = o;
    }

    @Override
    public String toString() {
        return ID +" "+RName+" "+"-"+" "+food_name+" "+price+" "+quantity
                +" "+offer+"%"+" "+"off"+" "+category;


    }
}
