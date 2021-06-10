public class Wallet {
    private String userName;
    private String place;
    private float totalMoney;
    private int reward;



    Wallet(){}
    Wallet(String user){
        this.userName = user;
        this.place = "Delhi";
        this.totalMoney = 1000;
        this.reward = 0;

    }

    public float getTotalMoney() {
        return totalMoney;
    }


    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    public int getReward() {
        return reward;
    }
    public String getUserName() {
        return userName;
    }
    public void setReward(int r){
        reward =r;
    }
    public String toString(){
        return userName+", "+place+", "+totalMoney+"/-";
    }

}
