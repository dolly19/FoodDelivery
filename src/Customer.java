import java.util.ArrayList;

public class Customer{
    private ArrayList<Food> foodList;
    private ArrayList<Cart> cart;
    private ArrayList<Wallet> wallet;
    private float totalCharge;
    private float surplusmoney;
    private int deliverychargecollected;
    private int quantity;
    Customer(){
        cart = new ArrayList<Cart>();
        wallet = new ArrayList<Wallet>();
        totalCharge = 0;
        quantity =0;
        wallet.add( new Wallet("Ram"));
        wallet.add(new Wallet("Sam"));
        wallet.add(new Wallet("Tim"));
        wallet.add(new Wallet("Kim"));
        wallet.add(new Wallet("Jim"));

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected float getTotalCharge(){return totalCharge;}
    protected void setTotalCharge(float f){totalCharge =f;}
    public ArrayList<Cart> getCart(){ return cart;}
    public ArrayList<Wallet> getWallet(){ return wallet;}




    public float discountOnOverAllBill(Restaurant restaurant,float totalCharge, int dis){
        return restaurant.discountBillValue(totalCharge,dis);
    }


    public float calculateBill(String user, Restaurant restaurant, int dis){
        String rest = "null";
        int delivery;
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getUserName().equals(user) && (cart.get(i).getStatus() == 0)){
                int price = cart.get(i).getPrice();
                int quan = cart.get(i).getQuant();
                int foodDiscount = cart.get(i).getFoodDiscount();
                rest = cart.get(i).getRestname();
                quantity = quantity +quan;
                totalCharge = totalCharge + ( (price * quan) - ((foodDiscount*price*quan)/100) );
            }
        }
        if(rest.equals("Wang")){
            float total = this.discountOnOverAllBill(new FastFood(),totalCharge, dis);
            totalCharge = total;
        }

        if(rest.equals("Shah")){
            float total = this.discountOnOverAllBill(new AuthenticRestaurants(),totalCharge , dis);
            totalCharge = total ;
        }

        if(rest.equals("The Chinese")){
            float total = this.discountOnOverAllBill(new AuthenticRestaurants(),totalCharge, dis);
            totalCharge = total ;
        }

        if(user.equals("Ram")||user.equals("Sam")){
            delivery = restaurant.takeDeliveryCharge(new Elite());
        }
        else if(user.equals("Tim")){
            delivery = restaurant.takeDeliveryCharge(new Special());
        }
        else{
            delivery = restaurant.takeDeliveryCharge(new Customer());
        }


        surplusmoney = surplusmoney+ (totalCharge/100);
        deliverychargecollected= deliverychargecollected+delivery;
        System.out.println("Delivery Charge - "+delivery+"/-");
        totalCharge = totalCharge +delivery ;
        System.out.println("Total order value - INR "+totalCharge+"/-");
        System.out.println("   1) Proceed to checkout");
        return totalCharge;
    }

    public int deliveryCharge(){
        return 40;
    }

    public void companyAccountDetails(){
        System.out.println("Total Company balance - INR "+surplusmoney+"/-");
        System.out.println("Total Delivery Charges Collected - INR "+deliverychargecollected+"/-");
    }

    public char checkoutCart(String user , String restSelected , Restaurant restaurant){
        float money =0;
        char status = 0;
        float reward;
        int points;
        for(int i=0; i<wallet.size(); i++){
            if(wallet.get(i).getUserName().equals(user)) {
                if (wallet.get(i).getReward() + wallet.get(i).getTotalMoney() > totalCharge) {
                    money = Math.abs(totalCharge - wallet.get(i).getReward());
                    money = wallet.get(i).getTotalMoney() - money;
                    wallet.get(i).setTotalMoney(money);

                    if(restSelected.equals("Shah")||restSelected.equals("The Chinese") ) {
                        reward = totalCharge / 200;
                        points = (int) reward * 25;
                        if (restSelected.equals("Shah")) {
                            restaurant.getWallet().get(0).setReward(points);
                        }
                        else if (restSelected.equals("The Chinese")){
                            restaurant.getWallet().get(2).setReward(points);
                    }
                    }

                    else if(restSelected.equals("Wang")) {
                        reward = totalCharge / 150;
                        points = (int) reward * 10;
                        restaurant.getWallet().get(3).setReward(points);

                    }
                    else {
                        reward = totalCharge / 100 ;
                        points = (int) reward * 5 ;
                        if(restSelected.equals("Ravi")){
                            restaurant.getWallet().get(1).setReward(points);
                    }
                        else if(restSelected.equals("paradise")){
                            restaurant.getWallet().get(4).setReward(points);

                    }
                    }
                    wallet.get(i).setReward(points);
                    for (int j = 0; j < cart.size(); j++) {
                        if (cart.get(j).getUserName().equals(user) && (cart.get(j).getStatus() == 0)) {
                            cart.get(j).setStatus(1);
                        }
                    }
                } else {
                    status = 'N';
                }
            }
        }
        totalCharge =0;
        return status;
    }

    public void printRecentOrders(String user){
        System.out.println("Recent orders are");
        for(int i=0; i< cart.size(); i++){
            if(cart.get(i).getUserName().equals(user) && cart.get(i).getStatus() == 1)
                System.out.println(cart.get(i).toString());
        }

    }
    public void printReward(String user) {
        for (int i = 0; i < 5; i++) {
            if (wallet.get(i).getUserName().equals(user))
                System.out.println("Total Reward - " + wallet.get(i).getReward());
        }
    }

}




class Elite extends Customer {

    Elite() {
        super();
    }

    @Override
    public int deliveryCharge() {
        if (getTotalCharge() > 200)
            setTotalCharge(getTotalCharge() - 50);
        return 0;
    }
}

class Special extends Customer{

    Special(){
        super();
    }

    @Override
    public int deliveryCharge(){
        if(getTotalCharge() >200)
            setTotalCharge(getTotalCharge()-25);
        return 20 ;
    }


}
