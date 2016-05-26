package jsondemo.example.com.jsonparsingdemo;

import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


public class JsonParser {

    protected static final String CATALOG_URL = "http://musicapp.xerces.info/music/getTracks.php";
    private static final String JSON_MUSIC = "music";
    private static final String JSON_TITLE = "Track_Name";
    private static final String JSON_ARTIST = "artist";
    private static final String JSON_GENRE = "Track_Genere_Type";
    private static final String TAG = "JSONPARSER";

    private TrackDetailsModelClass buildFromJSON(JSONObject json) throws JSONException {
        String title = json.getString(JSON_TITLE);
        String artist = json.getString(JSON_ARTIST);
        String genre = json.getString(JSON_GENRE);
        return new TrackDetailsModelClass(title, genre, artist);
    }

    public ArrayList<TrackDetailsModelClass> getTracks() {
        try {

            NetWorkCallHandler netWorkCallHandler = new NetWorkCallHandler();
            JSONObject parentJsonObject = netWorkCallHandler.fetchJSONFromUrl(CATALOG_URL);
            ArrayList<TrackDetailsModelClass> tracksList= null;
            if ( parentJsonObject != null) {
                tracksList = new ArrayList<>();
                JSONArray jsonTracks = parentJsonObject.getJSONArray(JSON_MUSIC);

                if (jsonTracks != null) {
                    for (int j = 0; j < jsonTracks.length(); j++) {
                        tracksList.add(buildFromJSON(jsonTracks.getJSONObject(j)));
                    }
                }
            }
            return tracksList;
        } catch (JSONException e) {
            Log.e(TAG, "Could not retrieve music list");
            return null;
        }
    }
}
