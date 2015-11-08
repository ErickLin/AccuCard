package yhack.accucard;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class GiftCardActivity extends ActionBarActivity {
    public static String company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_card);

        User.all();

        ImageButton bestbuyButton=(ImageButton) findViewById(R.id.bestbuybutton);
        bestbuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftCardActivity.this, AddTargetActivity.class);
                company="BestBuy";
                startActivity(intent);
            }
        });

        ImageButton macysButton=(ImageButton) findViewById(R.id.macysbutton);
        macysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftCardActivity.this,AddTargetActivity.class);
                company="Macys";
                startActivity(intent);
            }
        });

        ImageButton microsoftButton=(ImageButton) findViewById(R.id.microsoftbutton);
        microsoftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftCardActivity.this, AddTargetActivity.class);
                company="Microsoft";
                startActivity(intent);
            }
        });

        ImageButton targetButton=(ImageButton) findViewById(R.id.targetbutton);
        targetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftCardActivity.this, AddTargetActivity.class);
                company="Target";
                startActivity(intent);
            }
        });

        ImageButton visaButton=(ImageButton) findViewById(R.id.visabutton);
        visaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(GiftCardActivity.this, AddGiftCardActivity.class);
               // startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gift_card, menu);
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
