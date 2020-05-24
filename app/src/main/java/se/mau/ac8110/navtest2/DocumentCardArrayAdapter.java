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

public class DocumentCardArrayAdapter  extends ArrayAdapter<DocumentCard> {
    private static final String TAG = "CardArrayAdapter";
    private List<DocumentCard> cardList = new ArrayList<DocumentCard>();

    static class CardViewHolder {
        TextView line1;
        TextView line2;
        TextView line3;
        ImageView imageView;
    }

    public DocumentCardArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(DocumentCard object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public DocumentCard getItem(int index) {
        return this.cardList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.document_item_card, parent, false);
            viewHolder = new CardViewHolder();
            viewHolder.line1 = (TextView) row.findViewById(R.id.document_line1);
            viewHolder.line2 = (TextView) row.findViewById(R.id.document_line2);
            viewHolder.line3 = (TextView) row.findViewById(R.id.document_line3);
            viewHolder.imageView = (ImageView) row.findViewById(R.id.document_imageView);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CardViewHolder)row.getTag();
        }
        DocumentCard card = getItem(position);
        viewHolder.line1.setText(card.getDate());
        viewHolder.line2.setText(card.getTitle());
        viewHolder.line3.setText(card.getType());
        if(card.getType().equals("Faktura")){
            viewHolder.imageView.setImageResource(R.mipmap.icon_pdf);
        }
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
