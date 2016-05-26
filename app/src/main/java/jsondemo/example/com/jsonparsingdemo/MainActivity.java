package jsondemo.example.com.jsonparsingdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mGetDataButton;
    private ListView mListView;
    private ListAdapter mListAdapter;
    private JsonParser mJsonParser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetDataButton = ( Button ) findViewById( R.id.getDataButton);
        mListView = ( ListView )findViewById( R.id.simplelistview );
        mGetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if( mListAdapter == null )
                {
                    new LoadTrackListTask().execute();
                }

            }
        });
    }
    class LoadTrackListTask extends AsyncTask<Void,Void,Boolean>
    {
        ArrayList<TrackDetailsModelClass> trackList;
        ProgressDialog mProgressDialog;
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Loading......");
            mProgressDialog.show();
            mGetDataButton.setEnabled(false);
        }
        @Override
        protected Boolean doInBackground(Void... voids)
        {

            mJsonParser = new JsonParser();
            trackList = mJsonParser.getTracks();
            if( trackList != null )
            {
                return true;
            }
            return false;
        }
        @Override
        protected void onPostExecute(Boolean result)
        {
            super.onPostExecute(result);
            mProgressDialog.dismiss();
            if( result )
            {

                mListView.setAdapter( new ListAdapter( trackList,getApplicationContext() ));
            }
            else
            {
                mGetDataButton.setEnabled(true);
                Toast.makeText( getApplicationContext(),"Track Loading Fail",Toast.LENGTH_LONG).show();
            }
        }
    }
}
