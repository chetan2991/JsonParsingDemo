package jsondemo.example.com.jsonparsingdemo;

/**
 * Created by chetan on 26/5/16.
 */
public class TrackDetailsModelClass
{
    private String mTrackName;
    private String mTrackGenere;
    private String mTrackArtist;

    public TrackDetailsModelClass(String trackName, String trackGenere, String trackArtist) {
        mTrackName = trackName;
        mTrackGenere = trackGenere;
        mTrackArtist = trackArtist;
    }

    public String getTrackName() {
        return mTrackName;
    }

    public void setTrackName(String trackName) {
        mTrackName = trackName;
    }

    public String getTrackGenere() {
        return mTrackGenere;
    }

    public void setTrackGenere(String trackGenere) {
        mTrackGenere = trackGenere;
    }

    public String getTrackArtist() {
        return mTrackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        mTrackArtist = trackArtist;
    }
}
