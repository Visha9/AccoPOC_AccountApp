package com.example.poc_openaccount.common.ui_compenents;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.example.poc_openaccount.R;

public class AppButton extends AppCompatButton {

    private ButtonTypeEnum buttonTypeEnum = ButtonTypeEnum.PRIMARY_BUTTON;

    public AppButton(Context context) {
        super(context);
      init(null);
    }

    public AppButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.borderlessButtonStyle);
        init(attrs);
    }

    public AppButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray =
                getContext().obtainStyledAttributes(attributeSet, R.styleable.Button);
            buttonTypeEnum =
                ButtonTypeEnum.values()[
                    typedArray.getInt(
                        R.styleable.Button_buttonType,
                        ButtonTypeEnum.PRIMARY_BUTTON.intValue)];
            typedArray.recycle();
        }
        initButtonType();
    }

    private void initButtonType() {
        switch (buttonTypeEnum) {
            case PRIMARY_BUTTON:
                initPrimaryButton(false);
                break;
            case PRIMARY_SHORT_BUTTON:
                initPrimaryButton(true);
                break;

        }
    }

    private void initPrimaryButton(boolean isShort) {
        setBackgroundDrawable(
            ContextCompat.getDrawable(getContext(), R.drawable.button_primary_selector));
        setTextColor(
            ContextCompat.getColorStateList(
                getContext(), R.drawable.button_primary_text_color_selecter));
        setMinHeight(
            isShort
                ? (int) getResources().getDimension(R.dimen.dimen_40dp)
                : (int) getResources().getDimension(R.dimen.dimen_56dp));
    }




    public enum ButtonTypeEnum {
        PRIMARY_BUTTON(0),
        PRIMARY_SHORT_BUTTON(1);

        private int intValue;

        ButtonTypeEnum(int value) {
            intValue = value;
        }
    }
}

