package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

// 툴바에 사용될 검색창 구현을 위해 EditText 를 커스텀
public class CustomHYEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener{

   private Drawable cancelDrawable;
   private OnFocusChangeListener onFocusChangeListener;
   private OnTouchListener onTouchListener;

   public CustomHYEditText(@NonNull Context context) {
      super(context);
      init();
   }

   public CustomHYEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
      super(context, attrs);
      init();
   }

   public CustomHYEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
      init();
   }

   @Override
   public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
      this.onFocusChangeListener = onFocusChangeListener;
   }

   @Override
   public void setOnTouchListener(OnTouchListener onTouchListener) {
      this.onTouchListener = onTouchListener;
   }

   private void init() {
      Log.d("custom", "init()");
      Drawable tempDrawable = ContextCompat.getDrawable(getContext(),R.drawable.ic_cancel);
      cancelDrawable = DrawableCompat.wrap(tempDrawable);
      //색 지정
      DrawableCompat.setTintList(cancelDrawable,getHintTextColors());
      cancelDrawable.setBounds(0, 0, cancelDrawable.getIntrinsicWidth(), cancelDrawable.getIntrinsicHeight());
      //초기 이미지 없애기.
      setClearIconVisible(false);
      super.setOnFocusChangeListener(this::onFocusChange);
      super.setOnTouchListener(this::onTouch);
   }

   @Override
   public boolean onTouch(View view, MotionEvent motionEvent) {
      final int x = (int) motionEvent.getX();
      if(cancelDrawable.isVisible() && x>getWidth() - getPaddingRight() - cancelDrawable.getIntrinsicWidth()) {
         if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
            setError(null);
            setText(null);
         }
         return true;
      }
      if(onTouchListener != null) {
         return onTouchListener.onTouch(view, motionEvent);
      } else  {
         return false;
      }
   }

   @Override
   public void onFocusChange(View view, boolean b) {
      Log.d("custom", "onFocusChange");

      if(b) {
         //이미지 visible
         setClearIconVisible(true);
      }
      else {
         setClearIconVisible(false);
      }
      if (onFocusChangeListener != null) {
         onFocusChangeListener.onFocusChange(view, b);
      }
   }
   private void setClearIconVisible(boolean visible) {
      Log.d("custom", "setClearIconVisible()");

      cancelDrawable.setVisible(visible, false);
      setCompoundDrawables(null, null, visible ? cancelDrawable : null, null);
   }
}
