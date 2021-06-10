public class Application {
    private final String restaurant [] ;
    private final String customer [] ;
    private final String menu [];
    private final String restquery [];
    private final String custquery [];
    private final String editattribute [];
    private final String custmenu [];
    private final String custuser [];

    Application(){
        restaurant = new String[]{"   1) Shah(Authentic)", "   2) Ravi's", "   3) The Chinese(Authentic)", "   4) Wang's(Fast Food)", "   5) Paradise"};
        customer = new String[]{"   1) Ram(Elite)", "   2) Sam (Elite)", "   3) Tim(Special)", "   4) Kim", "   5) Jim"};
        menu = new String[]{"   1) Enter as Restaurant Owner", "   2) Enter as Customer", "   3) Check User Details", "   4) Company Account Details", "   5) Exit"};
        restquery = new String[]{"   1) Add item", "   2) Edit item", "   3) Print Rewards", "   4) Discount on bill value", "   5) Exit"};
        custquery = new String[]{"   1) select Restaurant", "   2) checkout cart", "   3) Reward won", "   4) print the recent orders", "   5) Exit"};
        editattribute = new String[]{"   1) Name", "   2) Price", "   3) Quantity", "   4) Category", "   5) Offer"};
        custmenu = new String[]{"   1) Select Restaurant", "   2) Checkout cart", "   3) Reward won", "   4) print the recent orders", "   5) Exit"};
        custuser =new String[]{"   1) Ram", "   2) Sam", "   3) Tim", "   4) Kim", "   5) Jim"};
    }

    public void showMenu(){
        System.out.println("Welcome to Zotato :");
        for(int i=0; i<5; i++){
            System.out.println(menu[i]);
        }
    }

    public void custUser(){
        for(int i=0; i<5; i++){
            System.out.println(custuser[i]);
        }
    }

    public void showCustmenu(){
        System.out.println("Welcome to Zotato :");
        for(int i=0; i<5; i++){
            System.out.println(custmenu[i]);
        }
    }
    public void chooseRestaurant(){
        for(int i=0; i<5; i++){
            System.out.println(restaurant[i]);
        }
    }
    public void chooseUser(){
        for(int i=0; i<5; i++){
            System.out.println(customer[i]);
        }
    }

    public void Restquery(){
        for(int i=0; i<5; i++){
            System.out.println(restquery[i]);
        }
    }
    public void Custquery(){
        for(int i=0; i<5; i++){
            System.out.println(custquery[i]);
        }

    }
    public void editAttribute(){
        for(int i=0; i<5; i++){
            System.out.println(editattribute[i]);
        }
    }

    public String restaurantName(int i){
        if (i == 1){
            System.out.println("Welcome SHAH");
            return "Shah" ;
        }
        else if(i == 2){
            System.out.println("Welcome RAVI");
            return "Ravi";
        }
        else if(i == 3){
            System.out.println("Welcome THE CHINESE");
            return "The Chinese";
        }
        else if(i == 4){
            System.out.println("Welcome WANG");
            return "Wang";
        }
        else{
            System.out.println("Welcome PARADISE");
            return "Paradise";
        }
    }
    public String userName(int i){
        if (i == 1){
            System.out.println("Welcome RAM");
            return "Ram" ;
        }
        else if(i == 2){
            System.out.println("Welcome SAM");
            return "Sam";
        }
        else if(i == 3){
            System.out.println("Welcome TIM");
            return "Tim";
        }
        else if(i == 4){
            System.out.println("Welcome KIM");
            return "Kim";
        }
        else{
            System.out.println("Welcome JIM");
            return "Jim";
        }
    }


}
