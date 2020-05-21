package com.example.m_oopfinalproject;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;


public class JackpotGBKGameData implements Parcelable {
    public ArrayList<JackpotGBKPlayer> players;

    JackpotGBKGameData(String[] playerNames){
        for (String insert:playerNames) players.add(new JackpotGBKPlayer(insert));
    }

    // Parcelable overrides
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(players);
    }
    protected JackpotGBKGameData(Parcel insert){
        this.players = insert.readArrayList(null);
    }
    public static final Parcelable.Creator<JackpotGBKGameData> CREATOR = new Parcelable.Creator<JackpotGBKGameData>() {
        @Override
        public JackpotGBKGameData createFromParcel(Parcel source) {
            return new JackpotGBKGameData(source);
        }
        @Override
        public JackpotGBKGameData[] newArray(int size) {
            return new JackpotGBKGameData[size];
        }
    };

    // In-game mechanisms
}
