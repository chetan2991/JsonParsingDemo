package jsondemo.example.com.jsonparsingdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chetan on 27/5/16.
 */
public class ListAdapter extends BaseAdapter
{
    Context mContext;
    ArrayList<TrackDetailsModelClass> mTrackList;
    LayoutInflater mLayoutInflater;

    public ListAdapter(ArrayList<TrackDetailsModelClass> trackList, Context context)
    {
        mTrackList = trackList;
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getCount() {
        return mTrackList.size();
    }

    @Override
    public Object getItem(int i) {
        return mTrackList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        TrackDetailsModelClass trackDetailsModelClass = mTrackList.get(i);
        if( view == null )
        {
            view = mLayoutInflater.inflate( R.layout.list_item_layout, viewGroup,false );
            viewHolder = new ViewHolder();
            viewHolder.mTrackNameTextView = (TextView)view.findViewById(R.id.trackName );
            viewHolder.mTrackGenereTextView = (TextView)view.findViewById(R.id.trackGenere );
            viewHolder.mTrackArtistTextView = (TextView)view.findViewById(R.id.trackArtist );
            viewHolder.mTrackImageView = (ImageView)view.findViewById( R.id.trackLogo);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTrackNameTextView.setText(trackDetailsModelClass.getTrackName());
        viewHolder.mTrackGenereTextView.setText( trackDetailsModelClass.getTrackGenere());
        viewHolder.mTrackArtistTextView.setText( trackDetailsModelClass.getTrackArtist() );
        return view;
    }

    private class ViewHolder
    {
        public TextView mTrackNameTextView;
        public TextView mTrackGenereTextView;
        public TextView mTrackArtistTextView;
        public ImageView mTrackImageView;

    }
}
