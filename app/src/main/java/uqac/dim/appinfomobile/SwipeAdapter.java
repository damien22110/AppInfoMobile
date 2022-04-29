package uqac.dim.appinfomobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SwipeAdapter extends BaseAdapter {
    private List<Film> list;

    public SwipeAdapter(List<Film> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Film getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null)
        {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_koloda,parent,false);
            TextView mv_name = view.findViewById(R.id.movie_name);
            com.google.android.material.imageview.ShapeableImageView picture = view.findViewById(R.id.image);
            mv_name.setText(getItem(i).title);
            Picasso.get().load(getItem(i).picture).into(picture);
        } else
        {
            view=convertView;
        }
        return view;

    }
}
