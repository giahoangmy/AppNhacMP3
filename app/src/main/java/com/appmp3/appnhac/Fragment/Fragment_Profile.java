package com.appmp3.appnhac.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appmp3.appnhac.R;

public class Fragment_Profile extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String username = getArguments().getString("USERNAME");
        view = inflater.inflate(R.layout.fragment_profile,container,false);

        TextView txtUserName = (TextView) view.findViewById(R.id.txtUserName);
        txtUserName.setText(username);
        return view;
    }
}
