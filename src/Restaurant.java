import java.util.ArrayList;

public class Restaurant implements User{
    private ArrayList<Food> foodList;
    private ArrayList<Wallet> wallet;

    Restaurant(){
        foodList = new ArrayList<Food>();
        wallet = new ArrayList<Wallet>();
        wallet.add( new Wallet("Shah"));
        wallet.add(new Wallet("Ravi"));
        wallet.add(new Wallet("The Chinese"));
        wallet.add(new Wallet("Wang"));
        wallet.add(new Wallet("Paradise"));


    }


    public ArrayList<Food> getFoodList(){return foodList;}
    protected ArrayList<Wallet> getWallet(){return wallet;}


    public void Additem(Food food){
        foodList.add(food);
    }

    public void editItem(int foodID, int queToEdit ,String change){

        if(queToEdit == 1){
            for(int i=0; i<foodList.size(); i++){
                if(foodID == foodList.get(i).getID()){
                    foodList.get(i).setFood_name(change);
                    break;
                }
            }
        }
        else if (queToEdit == 2){
            for(int i=0; i<foodList.size(); i++){
                if(foodID == foodList.get(i).getID()){
                    foodList.get(i).setPrice(Integer.parseInt(change));
                    break;
                }
            }
        }
        else if(queToEdit== 3){
            for(int i=0; i<foodList.size(); i++){
                if(foodID == foodList.get(i).getID()){
                    System.out.print("Enter the new Quantity - ");
                    foodList.get(i).setQuantity(Integer.parseInt(change));
                    break;
                }
            }

        }
        else if(queToEdit == 4){
            for(int i=0; i<foodList.size(); i++){
                if(foodID== foodList.get(i).getID()){
                    foodList.get(i).setCategory(change);
                    break;
                }
            }

        }
        else{
            for(int i=0; i<foodList.size(); i++){
                if(foodID == foodList.get(i).getID()){
                    foodList.get(i).setOffer(Integer.parseInt(change));
                    break;
                }
            }

        }
    }





    public int takeDeliveryCharge(Customer cust){
            return cust.deliveryCharge();

    }

    public int rewardWon(float totalCharge) {
        float reward = totalCharge / 100 ;
        int points = (int) reward * 5 ;
        return points;
    }


    public float discountBillValue(float totalCharge, int dis){
        return 0;
    }

    public void setdisscountOnBillValue(String rest , int dis){
        if(rest.equals("Shah")||rest.equals("The Chinese")||rest.equals("Paradise")){}
        else
            System.out.println("No Applicable");


    }
}

class FastFood extends Restaurant {

    FastFood(){
        super();
    }
    @Override
    public float discountBillValue(float totalCharge , int dis) {
        totalCharge = totalCharge - ((dis*totalCharge)/100);
        return  totalCharge;
    }

    @Override
    public int rewardWon(float totalCharge) {
        float reward = totalCharge / 150 ;
        int points = (int) reward * 10 ;
        return points;
    }
}


class AuthenticRestaurants extends Restaurant{
    AuthenticRestaurants(){
        super();
    }
    @Override
    public float discountBillValue(float totalCharge, int dis) {
        totalCharge = totalCharge - ((dis*totalCharge)/100);
        if(totalCharge >100)
            totalCharge= totalCharge - 50;
        return totalCharge ;
    }


    @Override
    public int rewardWon(float totalCharge) {
        float reward = totalCharge / 200 ;
        int points = (int) reward * 25 ;
        return points;
    }

}