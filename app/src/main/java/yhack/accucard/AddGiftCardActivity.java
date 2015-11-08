package yhack.accucard;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;



public class AddGiftCardActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift_card);

        final EditText companyInput=(EditText) findViewById(R.id.companyInput);
        final EditText amountInput=(EditText) findViewById(R.id.amountInput);
        final EditText cardNumberInput=(EditText) findViewById(R.id.cardNumberInput);
        final EditText securityCodeInput=(EditText) findViewById(R.id.cardSecurityInput);

        Button finalizeButton=(Button) findViewById(R.id.finalizeButton);
        User.all();
        if(finalizeButton!=null) {
            finalizeButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    double amt=Double.parseDouble(amountInput.getText().toString());
                    GiftCard card=new GiftCard(companyInput.getText().toString(),amt,cardNumberInput.getText().toString(),securityCodeInput.getText().toString());
                    User.allUsers[0].addGiftCard(card);



                    Intent i=new Intent(AddGiftCardActivity.this,GiftCardActivity.class);
                    startActivity(i);
                }

            });
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_gift_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
