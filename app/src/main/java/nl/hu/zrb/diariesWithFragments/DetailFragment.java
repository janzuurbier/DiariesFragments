package nl.hu.zrb.diariesWithFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

public class DetailFragment extends Fragment {
    DiaryEntry entry;
    TextView tv1, tv2, tv3;

    public DetailFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        tv1 = (TextView)v.findViewById(R.id.titleView);
        tv2 = (TextView) v.findViewById(R.id.contentView);
        tv3 = (TextView) v.findViewById(R.id.dateView);
        if (entry != null){
            tv1.setText(entry.getTitle());
            tv2.setText(entry.getContent());
            Date date = new Date(entry.getDate());
            String datedata = DateFormat.format("MMM dd, yyyy h:mmaa", date).toString();
            tv3.setText(datedata);
        }
        return v;
    }

    public void setDiaryEntry(DiaryEntry anEntry){
        if(tv1 != null && tv2 != null && tv3  != null){
            entry = anEntry;
            tv1.setText(entry.getTitle());
            tv2.setText(entry.getContent());
            Date date = new Date(entry.getDate());
            String datedata = DateFormat.format("MMM dd, yyyy h:mmaa", date).toString();
            tv3.setText(datedata);
        }
    }
}
