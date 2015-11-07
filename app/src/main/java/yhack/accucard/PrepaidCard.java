package yhack.accucard;

/**
 * Created by Sreejan on 11/7/2015.
 */
public class PrepaidCard {
    private String company;
    private String number;
    private String securityCode;
    private double amount;
    private int month;
    private int date;
    private int year;

    public PrepaidCard(String comp, String num, double money, String code, int mont, int dte, int yr) {
        company=comp;
        number=num;
        securityCode=code;
        month=mont;
        date=dte;
        year=yr;
        amount=money;
    }

    public String getCompany() {
        return company;
    }
    public String getCardNumber() {
        return number;
    }
    public String getSecurityCode() {
        return securityCode;
    }
    public int getMonth() {
        return month;
    }
    public int getDate() {
        return date;
    }
    public int getYear() {
        return year;
    }
    public double getAmount() {
        return amount;
    }
}
