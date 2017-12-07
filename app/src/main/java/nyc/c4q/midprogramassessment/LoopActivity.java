package nyc.c4q.midprogramassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoopActivity extends AppCompatActivity {
    public EditText userInput;
    public TextView display;
    public String userLimit;
    private int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        userInput = (EditText) findViewById(R.id.edit_text);
        display = (TextView) findViewById(R.id.text_view);
    }
    public void onButtonClick(View v) {
        userLimit = userInput.getText().toString();
        num = Integer.parseInt(userLimit);
        Counter count = new Counter();
        count.execute(num);

        Intent logIntent = new Intent(LoopActivity.this, LoginActivity.class);
        startActivity(logIntent);
    }
    private class Counter extends android.os.AsyncTask<Integer, Integer, Integer> {
        ArrayList<Integer> userInts = new ArrayList<>();
        @Override
        protected void onPreExecute() {
            userInts.clear();
        }
        @Override
        protected Integer doInBackground(Integer... values) {
            for (int i = num; num <  100000; i++) {
                publishProgress(i);
            }
            return userInts.size();
        }
        @Override
        protected void onProgressUpdate(Integer... progress) {
            display.setText("Loops completed " + num);
        }
        @Override
        protected void onPostExecute(Integer result) {
            display.setText("Loops completed " + num);
        }
    }
}
