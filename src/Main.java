import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Application zotato = new Application();
        Restaurant restaurant = new Restaurant();
        Customer customer = new Customer();
        int query = 0;
        int fcounter = 1;
        int discount =0;
        while (query != 5) {
            zotato.showMenu();
            query = in.nextInt();
            switch (query) {
                case 1:
                    System.out.println("Choose Restaurant :");
                    zotato.chooseRestaurant();
                    int restChosen = in.nextInt();
                    String restSelected;
                    int queryToPerform = 0;
                    while (queryToPerform != 5) {
                        restSelected = zotato.restaurantName(restChosen);
                        zotato.Restquery();
                        queryToPerform = in.nextInt();
                        switch (queryToPerform) {
                            case 1:
                                System.out.println("Enter food item details");
                                System.out.print("Food name : ");
                                in.nextLine();
                                String fn = in.nextLine();
                                System.out.print("item price : ");
                                int p = in.nextInt();
                                System.out.print("item quantity : ");
                                int q = in.nextInt();
                                System.out.print("item category : ");
                                in.nextLine();
                                String c = in.nextLine();
                                System.out.print("Offer : ");
                                int o = in.nextInt();
                                System.out.println(fcounter + " " + fn + " " + p + " " + q + " " + o + "%" + " off " + c);
                                Food food = new Food(restSelected, fn, fcounter, p, q, c, o);
                                restaurant.Additem(food);
                                fcounter++;
                                break;

                            case 2:
                                System.out.println("Choose item by code:");
                                for (int i = 0; i < restaurant.getFoodList().size(); i++) {
                                    if (restSelected.equals(restaurant.getFoodList().get(i).getRName())) {
                                        System.out.println(restaurant.getFoodList().get(i).toString());
                                    }
                                }
                                int foodChosen = in.nextInt();
                                System.out.println("Choose an attribute to edit:");
                                zotato.editAttribute();
                                int queryToEdit = in.nextInt();
                                for (int i = 0; i < restaurant.getFoodList().size(); i++) {
                                    if (foodChosen == restaurant.getFoodList().get(i).getID()) {
                                        if (queryToEdit == 1) {
                                            System.out.print("Enter the new name - ");
                                            in.nextLine();
                                            String s = in.nextLine();
                                            restaurant.editItem(foodChosen, queryToEdit, s);
                                            System.out.println(restaurant.getFoodList().get(i).toString());
                                        } else if (queryToEdit == 2) {
                                            System.out.print("Enter the new price - ");
                                            in.nextLine();
                                            String s = in.nextLine();
                                            restaurant.editItem(foodChosen, queryToEdit, s);
                                            System.out.println(restaurant.getFoodList().get(i).toString());
                                        } else if (queryToEdit == 3) {
                                            System.out.print("Enter the new Quantity - ");
                                            in.nextLine();
                                            String s = in.nextLine();
                                            restaurant.editItem(foodChosen, queryToEdit, s);
                                            System.out.println(restaurant.getFoodList().get(i).toString());
                                        } else if (queryToEdit == 4) {
                                            System.out.print("Enter the new Category - ");
                                            in.nextLine();
                                            String s = in.nextLine();
                                            restaurant.editItem(foodChosen, queryToEdit, s);
                                            System.out.println(restaurant.getFoodList().get(i).toString());
                                        } else {
                                            System.out.print("Enter the new Offer - ");
                                            in.nextLine();
                                            String s = in.nextLine();
                                            restaurant.editItem(foodChosen, queryToEdit, s);
                                            System.out.println(restaurant.getFoodList().get(i).toString());
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 3:
                                for(int i=0; i< 5; i++){
                                    if(restaurant.getWallet().get(i).getUserName().equals(restSelected))
                                        System.out.println("Reward Points - "+restaurant.getWallet().get(i).getReward());
                                }
                                break;

                            case 4:
                                System.out.print("Enter offer on total bill value - ");
                                discount = in.nextInt();
                                restaurant.setdisscountOnBillValue(restSelected, discount);
                                break;

                        }
                    }
                    break;
                case 2:
                    System.out.println("Choose Customer");
                    zotato.chooseUser();
                    int userChosen = in.nextInt();
                    String custSelected ;
                    String restchosen = "null";
                    int restChosenTOorder =0;
                    int QueryToPerform = 0;
                    while (QueryToPerform != 5) {
                        custSelected = zotato.userName(userChosen);
                        zotato.Custquery();
                        QueryToPerform = in.nextInt();
                        switch (QueryToPerform) {
                            case 1:
                                System.out.println("Choose Restaurant");
                                zotato.chooseRestaurant();
                                restChosenTOorder = in.nextInt();
                                if(restChosenTOorder== 1)
                                    restchosen = "Shah";
                                else if(restChosenTOorder== 2)
                                    restchosen = "Ravi";
                                else if(restChosenTOorder== 3)
                                    restchosen = "The Chinese";
                                else if(restChosenTOorder== 4)
                                    restchosen = "Wang";
                                else
                                    restchosen = "Paradise";
                                System.out.println("Choose item by code ");
                                for (int i = 0; i < restaurant.getFoodList().size(); i++) {
                                    if (restchosen.equals(restaurant.getFoodList().get(i).getRName())) {
                                        System.out.println(restaurant.getFoodList().get(i).toString());
                                    }
                                }
                                int chooseItem = in.nextInt();
                                System.out.print("Enter item quantity - ");
                                int quan = in.nextInt();
                                String restOrder =  restaurant.getFoodList().get(chooseItem-1).getRName();
                                String food =  restaurant.getFoodList().get(chooseItem-1).getFood_name();
                                int price = restaurant.getFoodList().get(chooseItem-1).getPrice();
                                int foodDiscount = restaurant.getFoodList().get(chooseItem-1).getOffer();
                                Cart cart = new Cart(custSelected,chooseItem,restOrder,food, price,quan,foodDiscount);
                                customer.getCart().add(cart);
                                System.out.println("Items added to cart");
                                break;

                            case 2:
                                System.out.println("Items in cart");
                                for(int i=0; i<customer.getCart().size(); i++){
                                    if((customer.getCart().get(i).getUserName().equals(custSelected)) && (customer.getCart().get(i).getStatus() == 0))
                                        System.out.println(customer.getCart().get(i).toString());
                                }
                                float totalCharge = customer.calculateBill(custSelected,restaurant, discount);
                                int check = in.nextInt();
                                char status = 0;
                                if(check== 1){
                                    status = customer.checkoutCart(custSelected ,restchosen, restaurant);
                                    System.out.println(customer.getQuantity()+" items successfully bought for INR "+totalCharge+"/-");
                                    customer.setQuantity(0);
                                    if(status == 'N'){
                                        System.out.println("Cannot procced, insufficient balance");
                                        System.out.println("1) Delete any item");
                                        int del= in.nextInt();
                                        if(del == 1) {
                                            for(int i=0; i<customer.getCart().size(); i++){
                                                if(customer.getCart().get(i).getUserName().equals(custSelected) && (customer.getCart().get(i).getStatus() == 0))
                                                    customer.getCart().get(i).toString();
                                            }
                                            System.out.println("Choose item by code to delete");
                                            del= in.nextInt();
                                            for(int i=0; i<customer.getCart().size(); i++){
                                                if(customer.getCart().get(i).getID() == del)
                                                    customer.getCart().remove(i);
                                            }
                                            totalCharge = customer.calculateBill(custSelected,restaurant, discount);
                                            check = in.nextInt();
                                            customer.checkoutCart(custSelected ,restchosen, restaurant);
                                            System.out.println(customer.getQuantity()+" items successfully bought for INR "+totalCharge+"/-");
                                            customer.setQuantity(0);
                                        }
                                    }
                                }
                                break;
                            case 3:
                               customer.printReward(custSelected);
                                break;
                            case 4:
                                customer.printRecentOrders(custSelected);
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("   1) Customer List");
                    System.out.println("   2) Restaurant List");
                    int option = in.nextInt();
                    if(option == 1){
                        zotato.custUser();
                        int custchoose = in.nextInt();
                        System.out.println(customer.getWallet().get(custchoose-1).toString());
                    }
                    else{
                        zotato.chooseRestaurant();
                        int choose = in.nextInt();
                        int orders = 0;
                        for(int i=0; i< customer.getCart().size(); i++){
                            if(choose==1 && customer.getCart().get(i).getRestname().equals("Shah") && customer.getCart().get(i).getStatus()==1)
                                orders++;
                            else if(choose==2 && customer.getCart().get(i).getRestname().equals("Ravi")&& customer.getCart().get(i).getStatus()==1)
                                orders++;
                            else if(choose==3 && customer.getCart().get(i).getRestname().equals("The Chinese")&& customer.getCart().get(i).getStatus()==1)
                                orders++;
                            else if(choose==4 && customer.getCart().get(i).getRestname().equals("Wang")&& customer.getCart().get(i).getStatus()==1)
                                orders++;
                            else if(choose==4 && customer.getCart().get(i).getRestname().equals("Paradise")&& customer.getCart().get(i).getStatus()==1)
                                orders++;
                        }
                        System.out.println(restaurant.getWallet().get(choose-1).getUserName()+
                                ", Delhi, "+"numbers of orders taken- "+ orders);
                    }
                    break;
                case 4:
                    customer.companyAccountDetails();
                    break;
            }
        }
    }
}
