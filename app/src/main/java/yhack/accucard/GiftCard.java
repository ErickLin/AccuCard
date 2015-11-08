package yhack.accucard;

/**
 * Created by Sreejan on 11/7/2015.
 */
public class GiftCard {
    private String company;
    private double amount;
    private String code;
    private String securityCode;

    public GiftCard(String cmpy, double amt, String num, String secode) {
        company=cmpy;
        amount=amt;
        code=num;
        securityCode=secode;
    }

    public String getCompany() {
        return company;
    }
    public double getAmount() {
        return amount;
    }
    public String getCardCode() {
        return code;
    }
    public String getSecurityCode() {
        return securityCode;
    }

    public boolean equals(GiftCard other) {
        return this.company.equals(other.getCompany()) && this.amount==other.getAmount();
    }

}
