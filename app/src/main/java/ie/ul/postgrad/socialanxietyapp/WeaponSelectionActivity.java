package ie.ul.postgrad.socialanxietyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ie.ul.postgrad.socialanxietyapp.game.Player;

public class WeaponSelectionActivity extends AppCompatActivity {

    private Player player;
    private ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inventory);

        Bundle bundle = getIntent().getExtras();
        player = MapsActivity.player;

        itemList = (ListView) findViewById(R.id.item_list);
        InventoryListAdapter adapter = new InventoryListAdapter(this, player.getInventory().getWeapons());
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItemID = player.getInventory().getWeapons().keyAt((int) itemList.getItemAtPosition(position));

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",selectedItemID);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
