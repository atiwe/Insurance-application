package se.mau.ac8110.navtest2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaymentsCardArrayAdapter extends ArrayAdapter<PaymentsCard> {
    private static final String TAG = "CardArrayAdapter";
    private List<PaymentsCard> cardList = new ArrayList<PaymentsCard>();

    static class CardViewHolder {
        TextView line1;
        TextView line2;
        TextView line3;
    }

    public PaymentsCardArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(PaymentsCard object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public PaymentsCard getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PaymentsCardArrayAdapter.CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.payments_item_card, parent, false);
            viewHolder = new PaymentsCardArrayAdapter.CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.payment_line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.payment_line2);
            viewHolder.line3 = (TextView) row.findViewById(R.id.payment_line3);
            row.setTag(viewHolder);
        } else {
            viewHolder = (PaymentsCardArrayAdapter.CardViewHolder)row.getTag();
        }
        PaymentsCard card = getItem(position);
        viewHolder.line1.setText(card.getDate());
        viewHolder.line2.setText(card.getTitle());
        viewHolder.line3.setText(card.getType());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
