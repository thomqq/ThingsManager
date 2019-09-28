package com.tq.thingsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.tq.thingsmanager.db.PurchaseRepo;
import com.tq.thingsmanager.db.SQLLiteHelper;
import com.tq.thingsmanager.db.dao.PurchaseGroupDao;
import com.tq.thingsmanager.db.dao.PurchaseGroupDaoImpl;
import com.tq.thingsmanager.db.model.PurchaseGroup;
import com.tq.thingsmanager.factories.DAOFactory;
import com.tq.thingsmanager.view.model.tile.TileContent;
import com.tq.thingsmanager.view.TileManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PurchaseGroupDao purchaseGroupDao = DAOFactory.getPurchaseGroupDao(getApplicationContext());
        PurchaseRepo purchaseRepo = new PurchaseRepo(purchaseGroupDao);

        List<PurchaseGroup> purchaseGroups = purchaseRepo.loadAllPurchaseGroup();

        TileManager tileManager = new TileManager( createTiles(purchaseGroups));
        createTile(tileManager);
    }

    //TODO TQ - to przecieka
    private List<TileContent> createTiles(List<PurchaseGroup> purchaseGroups) {
        List<TileContent> result = new ArrayList<>();

        for( PurchaseGroup purchaseGroup : purchaseGroups ) {
            result.add(new TileContent(purchaseGroup.getId(), purchaseGroup.getName()));
        }

        return result;
    }

    private void createTile(TileManager tileManager) {

        TableLayout linearLayout = this.findViewById(R.id.TileTable);
        linearLayout.removeAllViews();


        TableRow tableRow = null;
        for( int i = 0 ; i < tileManager.size(); i++) {
            if( i % 3 == 0 ) {
                tableRow = new TableRow(this);
                linearLayout.addView(tableRow);
            }

            String text = tileManager.getText(i);
            String id = tileManager.getId(i);
            Button button = new Button(this);
            button.setText(text);
            button.setTag(id);
            button.setOnClickListener(onTileClick);
            tableRow.addView(button);
        }

    }

    private View.OnClickListener onTileClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(getApplicationContext(), "cosik: " + (String)v.getTag(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, EditActivity.class);
            intent.putExtra("id", (String) v.getTag());
            MainActivity.this.startActivity(intent);
        }
    };
}
