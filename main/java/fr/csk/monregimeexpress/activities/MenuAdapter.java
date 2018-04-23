package fr.csk.monregimeexpress.activities;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.models.Menu;

/**
 * Class for Adapting the Menu in the Listing Menu Layout
 */

public class MenuAdapter extends ArrayAdapter<Menu>{

    private LayoutInflater inflater;
    private int resId; //R.layout.item_listing

    public MenuAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Menu> objects) {
        super(context, resource, objects);

        inflater = LayoutInflater.from(context); //comme une création d'instance
        resId = resource;//R.layout.item_listing
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MenuAdapter.ViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(resId, null);

            viewHolder = new MenuAdapter.ViewHolder();
            viewHolder.textViewQuantity = (TextView) convertView.findViewById(R.id.textview_quantity);
            viewHolder.textViewMeal = (TextView) convertView.findViewById(R.id.textview_meal);
            convertView.setTag(viewHolder); //enregistre les Views (contenu dans le ViewHolder)

        }else{
            viewHolder = (MenuAdapter.ViewHolder) convertView.getTag();
        }

        Menu menu = getItem(position);
        viewHolder.textViewQuantity.setText(menu.getQuantity());
        viewHolder.textViewMeal.setText(menu.getDescription());
        return convertView;
    }
    private class ViewHolder {
        TextView textViewQuantity, textViewMeal;
    }
}