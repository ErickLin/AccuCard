package yhack.accucard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AddCardActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_VENMO_APP_SWITCH = 1;
    int numCards = 0;
    double total = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        final EditText cardNoView = (EditText) findViewById(R.id.cardno);
        final EditText securityCodeView = (EditText) findViewById(R.id.securitycode);
        final EditText expirationDate = (EditText) findViewById(R.id.expirationdate);
        final EditText amount = (EditText) findViewById(R.id.amount);
        final TextView numberCards = (TextView) findViewById(R.id.numbercards);
        final TextView currentTotal = (TextView) findViewById(R.id.currenttotal);

        Button addCardButton = (Button) findViewById(R.id.addcard);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNoView.setText("");
                securityCodeView.setText("");
                expirationDate.setText("");
                amount.setText("");
                numCards++;
                String str = amount.getText().toString();
                if (str != null && !str.isEmpty()) {
                    total += Double.parseDouble(str);
                }
                numberCards.setText("Number of Cards: " + numCards);
                currentTotal.setText("Current Total: $" + total);
            }
        });

        ImageButton venmoButton = (ImageButton) findViewById(R.id.venmobutton);
        venmoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent venmoIntent = VenmoLibrary.openVenmoPayment("3109", "AccuCard", "YHack", "0", "", "pay");
                startActivityForResult(venmoIntent, REQUEST_CODE_VENMO_APP_SWITCH);
            }
        });

        ImageButton backButton=(ImageButton) findViewById(R.id.backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, GiftCardActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode) {
            case REQUEST_CODE_VENMO_APP_SWITCH: {
                if(resultCode == RESULT_OK) {
                    String signedrequest = data.getStringExtra("signedrequest");
                    if(signedrequest != null) {
                        VenmoLibrary.VenmoResponse response = (new VenmoLibrary()).validateVenmoPaymentResponse(signedrequest, "bCdQfyhSQxsRRwCn56XFRD3KhwYaNKQ8");
                        if(response.getSuccess().equals("1")) {
                            //Payment successful.  Use data from response object to display a success message
                            String note = response.getNote();
                            String amount = response.getAmount();
                        }
                    }
                    else {
                        String error_message = data.getStringExtra("error_message");
                        //An error ocurred.  Make sure to display the error_message to the user
                    }
                }
                else if(resultCode == RESULT_CANCELED) {
                    //The user cancelled the payment
                }
                break;
            }
        }
    }
}
