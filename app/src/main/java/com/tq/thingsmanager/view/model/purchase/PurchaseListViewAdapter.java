package com.tq.thingsmanager.view.model.purchase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tq.thingsmanager.R;

import java.text.SimpleDateFormat;

public class PurchaseListViewAdapter extends ArrayAdapter<PurchaseView> {
    private final PurchaseListViewSource purchaseListViewSource;
    private Context context;
    private PurchaseListViewOperation purchaseListViewOperation;

    private static class ViewHolder {
        TextView textName;
        TextView textPurchaseDate;
        TextView textOperationDate;
        Button button;
       //PurchaseView purchase;
    }

    public PurchaseListViewAdapter(@NonNull Context context, @NonNull PurchaseListViewSource purchaseListViewSource, PurchaseListViewOperation purchaseListViewOperation) {
        super(context, R.layout.purchase_row, purchaseListViewSource.getList());
        this.context = context;
        this.purchaseListViewSource = purchaseListViewSource;
        this.purchaseListViewOperation = purchaseListViewOperation;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final PurchaseView purchaseView = purchaseListViewSource.getList().get(position);
        ViewHolder viewHolder;

       // if( convertView == null ) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.purchase_row, parent, false);
            viewHolder.textName = convertView.findViewById(R.id.pvName);
            viewHolder.textOperationDate = convertView.findViewById(R.id.pvOperationDate);
            viewHolder.textPurchaseDate = convertView.findViewById(R.id.pvPurchaseDate);
            viewHolder.button = convertView.findViewById(R.id.pvDeleteButton);
            //viewHolder.purchase = purchaseView;

            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    purchaseListViewOperation.onDelete(purchaseView);
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(viewHolder);

      //  } else {
      //      viewHolder = (ViewHolder) convertView.getTag();
      //  }

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        viewHolder.textName.setText(purchaseView.getCategoryName());
        viewHolder.textPurchaseDate.setText(simpleDateFormat.format(purchaseView.getPurchaseDate()));
        viewHolder.textOperationDate.setText(simpleDateFormat.format(purchaseView.getOperationDate()));

        return convertView;

    }
}
