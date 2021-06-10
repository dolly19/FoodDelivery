import java.util.ArrayList;

public class Cart {
    private String userName;
    private int ID;
    private String Restname;
    private String foodname;
    private int price;
    private int quant;
    private int foodDiscount;
    private int status;

    Cart(String n,int i, String rn , String fn , int p, int q, int fd){
        this.userName =n;
        this.ID = i;
        this.Restname = rn;
        this.foodname = fn;
        this.price = p;
        this.quant = q;
        this.foodDiscount =fd;
        this.status =0;

    }

    public int getStatus(){return status;}
    public void setStatus(int status) {
        this.status = status;
    }
    public String getRestname(){
        return Restname;
    }
    public int getID(){
        return ID;
    }
    public String getUserName(){return userName;}
    public String getFoodname(){
        return foodname;
    }
    public int getPrice(){
        return price;
    }
    public int getQuant(){
        return quant;
    }
    public int getFoodDiscount(){
        return foodDiscount;
    }
    public String toString(){
        return ID+" "+Restname+" - "+foodname+" - "+price+" - "+foodDiscount+"%"+" off";
    }


}
