package nyc.c4q.midprogramassessment;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListActivity extends Fragment {
    //Bundle extras = getIntent().getExtras();
    View rootView;
    TextView userInfo;
   public ListActivity(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
      // Intent i = extras;
       //i.getExtras("user email");
    rootView =  inflater.inflate(R.layout.activity_list, container, false);
    userInfo = (TextView) rootView.findViewById(R.id.fragment_Text);
    //userInfo.setText(extras);

    return rootView;
    }
}
