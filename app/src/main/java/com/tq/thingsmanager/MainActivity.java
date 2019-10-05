package com.tq.thingsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import com.tq.thingsmanager.db.PurchaseRepo;
import com.tq.thingsmanager.factories.DAOFactory;
import com.tq.thingsmanager.view.TileManager;
import com.tq.thingsmanager.view.model.tile.CategoryGroupViewModel;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HashMap<Long, CategoryGroupViewModel> tiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PurchaseRepo purchaseRepo = DAOFactory.getPurchaseRepo(getApplicationContext());

        List<CategoryGroupViewModel> tileContents = purchaseRepo.loadTiles();
        if( tileContents.isEmpty() ) {
            purchaseRepo.initData();
        }
        tileContents = purchaseRepo.loadTiles();

        tiles = new HashMap<>();
        for( CategoryGroupViewModel groupViewModel : tileContents ) {
            tiles.put(groupViewModel.getPurchaseGroupId(), groupViewModel);
        }

        TileManager tileManager = new TileManager(tileContents);
        createTile(tileManager);
    }

    private void createTile(TileManager tileManager) {

        TableLayout linearLayout = this.findViewById(R.id.TileTable);
        linearLayout.removeAllViews();

        TableRow tableRow = null;
        for (int i = 0; i < tileManager.size(); i++) {
            if (i % 3 == 0) {
                tableRow = new TableRow(this);
                linearLayout.addView(tableRow);
            }

            Button button = new Button(this);
            button.setText(tileManager.getText(i));
            button.setTag(tileManager.getId(i));
            button.setOnClickListener(onTileClick);
            tableRow.addView(button);
        }

    }

    private View.OnClickListener onTileClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(getApplicationContext(), "cosik: " + (String)v.getTag(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, EditActivity.class);
            PurchaseRepo purchaseRepo = DAOFactory.getPurchaseRepo(getApplicationContext());

            CategoryGroupViewModel group = tiles.get( Long.parseLong(v.getTag().toString()));
            intent.putExtra("group", group );
            MainActivity.this.startActivity(intent);
        }
    };
}
