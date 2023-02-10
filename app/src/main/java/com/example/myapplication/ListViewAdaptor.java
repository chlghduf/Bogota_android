package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdaptor extends BaseAdapter {
   private ArrayList<ListItem> listViewItemList = new ArrayList<>();

   //ListViewAdaptor 생성자
   public ListViewAdaptor() {

   }

   @Override
   public int getCount() {
      return listViewItemList.size();
   }

   @Override
   public Object getItem(int i) {
      return listViewItemList.get(i);
   }

   @Override
   public long getItemId(int i) {
      return i;
   }

   // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴 : 필수 구현.
   @Override
   public View getView(int position, View view, ViewGroup viewGroup) {
      final int pos = position;
      final Context context = viewGroup.getContext();

      //listitem layout을 inflate하여  view 참조 획득
      if(view ==null) {
         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         view = inflater.inflate(R.layout.listitem, viewGroup, false);
      }
      // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
      ImageView iconImageView = (ImageView) view.findViewById(R.id.image1);
      TextView nameTextView = (TextView) view.findViewById(R.id.textView1);
      TextView numTextView = (TextView) view.findViewById(R.id.textView2);

      ListItem listitem = listViewItemList.get(position);

      iconImageView.setImageDrawable(listitem.getIconDrawable());
      nameTextView.setText(listitem.getStationName());
      numTextView.setText(listitem.getStationNum());

      return view;
   }
   public void addItem(ListItem listItem) {
      ListItem item = listItem;
      listViewItemList.add(item);

   }
}
