package fr.csk.monregimeexpress.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import fr.csk.monregimeexpress.R;
import fr.csk.monregimeexpress.utils.CustomLog;

/**
 * Created by carine on 30/05/2017.
 */

public class SportSeriesFragment extends Fragment {

    private String logTitle = this.getClass().getName();
    private CustomLog customLog = new CustomLog();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customLog.ShowLog(logTitle, "onCreateView()");

        // GET BUNDLE FROM SPORTBYDAYACTIVITY
        String str_day = getArguments().getString("day");
        String str_week = getArguments().getString("week");
        String str_serie = getArguments().getString("serie");

        //INFLATE THE SPORTBYDAYACTIVITYFRAGMENT
        View fragmentView = inflater.inflate(R.layout.activity_sport_series_fragment, container, false);

        //SET FRAGMENT IMAGES
        for (int i = 1; i<4; i++) {
            //build imageview Name
            String str_imgv = "img_" + String.valueOf(i);
            //convert imageview Name into Id
            int id_imgv = getResources().getIdentifier(str_imgv, "id", getContext().getPackageName());
            //get Imageview by Id
            ImageView img = (ImageView) fragmentView.findViewById(id_imgv);
            //get the drawable Image Id from week, day, serie
            int id = getResources().getIdentifier(getContext().getPackageName() + ":drawable/"
                            + "jpg_" + str_week + "_" + str_day + "_" + str_serie + "_" + String.valueOf(i), null, null);

            //set drawable Image into Imageview
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                img.setImageDrawable(getResources().getDrawable(id, null));
            }
        }
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customLog.ShowLog(logTitle, "onViewCreated()");
    }
}