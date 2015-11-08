package yhack.accucard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sreejan on 11/7/2015.
 */
public class User {
    public static User[] allUsers=new User[3];


    private String name;
    private String password;
    private ArrayList<GiftCard> giftCards;
    private ArrayList<PrepaidCard> prepaidCards;
    private double totalPrepaid;
    private HashMap<String, Double> totalGift;

    public User(String n, String pass) {
        name=n;
        password=pass;
        giftCards=new ArrayList<GiftCard>();
        prepaidCards=new ArrayList<PrepaidCard>();
        totalPrepaid=0.0;
        totalGift=new HashMap<String, Double>();



    }

    public static void all() {
        allUsers[0]=new User("sreejan.kumar@yale.edu","sk2436");
        allUsers[0].addGiftCard(new GiftCard("BestBuy",50.0,"034203403","053"));
        allUsers[0].addGiftCard(new GiftCard("BestBuy", 100.0, "23429034", "041"));
        allUsers[0].addGiftCard(new GiftCard("BestBuy", 200.0, "34298349", "012"));
        allUsers[0].addGiftCard(new GiftCard("Target",200.0,"2304824","313"));
        allUsers[1]=new User("bill.gates@yale.edu","microsoft");
        allUsers[2]=new User("mark.zuckerberg@yale.edu", "facebook");
    }

    public ArrayList<GiftCard> getGiftCards() {
        return giftCards;
    }
    public ArrayList<PrepaidCard> getPrepaidCards() {
        return prepaidCards;
    }
    public HashMap<String, Double> getTotalGifts() {
        return totalGift;
    }
    public double getTotalPrepaidAmount() {
        return totalPrepaid;
    }

    public String getName() {
        return name;
    }
    public void addGiftCard(GiftCard card) {
        giftCards.add(card);
        if(totalGift.containsKey(card.getCompany())) {
            totalGift.put(card.getCompany(),totalGift.get(card.getCompany())+card.getAmount());
        }
        else {
            totalGift.put(card.getCompany(),card.getAmount());
        }
    }

    public void addPrepaidCard(PrepaidCard card) {
        prepaidCards.add(card);
        totalPrepaid+=card.getAmount();
    }

    public void calculateTotalPrepaid() {
        double sum=0.0;
        for(int i=0;i<prepaidCards.size();i++) {
            sum+=prepaidCards.get(i).getAmount();
        }
    }
    public void calculateTotalGift() {
        for(int i=0;i<giftCards.size();i++) {
            GiftCard card=giftCards.get(i);
            if(!totalGift.containsKey(card.getCompany())) {
                totalGift.put(card.getCompany(),card.getAmount());
            }
            else {
                totalGift.put(card.getCompany(),totalGift.get(card.getCompany())+card.getAmount());
            }
        }
    }
    //Swap thiscompany giftcard with other user's othercompany giftcard.
    public void swapGiftCards(User other, String thiscompany, String othercompany, double amount) {
        int thisindex=-1;
        int otherindex=-1;
        for(int i=0;i<this.giftCards.size();i++) {
            if (this.giftCards.get(i).getCompany().equalsIgnoreCase(thiscompany) && this.giftCards.get(i).getAmount()==amount) {
                thisindex=i;
            }
        }
        for(int i=0;i<other.giftCards.size();i++) {
            if (other.giftCards.get(i).getCompany().equalsIgnoreCase(othercompany) && other.giftCards.get(i).getAmount()==amount) {
                otherindex=i;
            }
        }
        GiftCard thisGiftCard=this.giftCards.remove(thisindex);
        GiftCard otherGiftCard=other.giftCards.remove(otherindex);

        this.giftCards.add(otherGiftCard);
        other.giftCards.add(thisGiftCard);

        calculateTotalGift(); calculateTotalPrepaid();
    }
    //null if no traders can be found.
    public User findTraders(String company, double amount) {
        for(User trader:allUsers) {
            for(int i=0;i<trader.getGiftCards().size();i++) {
                GiftCard card=trader.getGiftCards().get(i);
                if(card.getCompany().equals(company) && card.getAmount()==amount) {
                    return trader;
                }
            }
        }
        return null;
    }

}
