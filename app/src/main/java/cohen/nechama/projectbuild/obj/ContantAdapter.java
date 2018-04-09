package cohen.nechama.projectbuild.obj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cohen.nechama.projectbuild.R;

/**
 * Created by 123 on 21/03/2018.
 */

public class ContantAdapter extends BaseAdapter{


    private ArrayList<Contant> dataContant;
    private Context context;

    public ContantAdapter(ArrayList<Contant> dataContant, Context context) {
        this.dataContant = dataContant;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataContant.size();
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contant contant = dataContant.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.contant_item,parent,false);
        TextView tvName = v.findViewById(R.id.tvName);
        TextView tvAddress = v.findViewById(R.id.tvAddress);
        TextView tvPhone = v.findViewById(R.id.tvPhone);
        ImageView ivImage = v.findViewById(R.id.ivImage);
        tvName.setText(contant.getName());
        tvAddress.setText(contant.getAddress());
        tvPhone.setText(contant.getPhone());
        ivImage.setImageResource(contant.getImage());
        return v;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
