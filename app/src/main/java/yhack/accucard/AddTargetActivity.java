package yhack.accucard;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class AddTargetActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_target);

        TextView largeText=(TextView) findViewById(R.id.companyText);
        largeText.setText("Target");

        TextView cardText=(TextView) findViewById(R.id.cardsText);
        String cardsText="";

        if(!User.allUsers[0].getTotalGifts().containsKey("Target")) {
            cardsText+="No cards for this company";
        }
        else {
            int count=1;

            for(int i=0;i<User.allUsers[0].getGiftCards().size();i++) {
                if(User.allUsers[0].getGiftCards().get(i).getCompany().equals("Target")) {
                    cardsText+="Card "+count +" : $"+ User.allUsers[0].getGiftCards().get(i).getAmount();
                }
            }
        }
        cardText.setText(cardsText);

        ImageButton addCardButton=(ImageButton) findViewById(R.id.addCardButton);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(AddTargetActivity.this, AddGiftCardActivity.class);
                //  startActivity(intent);
            }
        });

        ImageButton backButton=(ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(AddTargetActivity.this, GiftCardActivity.class);
                  startActivity(intent);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_target, menu);
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
