package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class ListItem {
   private Drawable iconDrawable;
   private String stationName;
   private String stationNum;

   public ListItem(Drawable iconDrawable, String stationName, String stationNum) {
      this.iconDrawable = iconDrawable;
      this.stationName = stationName;
      this.stationNum = stationNum;
   }

   public Drawable getIconDrawable() {
      return iconDrawable;
   }

   public void setIconDrawable(Drawable iconDrawable) {
      this.iconDrawable = iconDrawable;
   }

   public String getStationName() {
      return stationName;
   }

   public void setStationName(String stationName) {
      this.stationName = stationName;
   }

   public String getStationNum() {
      return stationNum;
   }

   public void setStationNum(String stationNum) {
      this.stationNum = stationNum;
   }
}
