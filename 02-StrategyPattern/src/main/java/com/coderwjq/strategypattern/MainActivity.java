package com.coderwjq.strategypattern;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtBuyCount;
    private TextView mTvDiscountPrice;
    private RadioGroup mRgDiscountStrategy;
    private StrategyContext mStrategyContext;
    private boolean isSelectedStrategy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewAndListener();
    }

    private void initViewAndListener() {
        mEtBuyCount = (EditText) findViewById(R.id.et_buy_count);
        mTvDiscountPrice = (TextView) findViewById(R.id.tv_discount_price);
        mStrategyContext = new StrategyContext();

        mRgDiscountStrategy = (RadioGroup) findViewById(R.id.rg_discount_strategy);
        mRgDiscountStrategy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                isSelectedStrategy = true;

                switch (checkedId) {
                    case R.id.rb_strategy_a:
                        mStrategyContext.setStrategy(new StrategyA());
                        break;
                    case R.id.rb_strategy_b:
                        mStrategyContext.setStrategy(new StrategyB());
                        break;
                }
            }
        });

        findViewById(R.id.btn_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelectedStrategy) {
                    Toast.makeText(MainActivity.this, "请选择优惠策略", Toast.LENGTH_SHORT).show();
                    mTvDiscountPrice.setVisibility(View.GONE);
                    return;
                } else {
                    if (mEtBuyCount.getText().toString().equals("") || mEtBuyCount.getText().toString().equals("0")) {
                        Toast.makeText(MainActivity.this, "请输入购买数量", Toast.LENGTH_SHORT).show();
                        mTvDiscountPrice.setVisibility(View.GONE);
                        return;
                    } else {
                        double discountPrice = mStrategyContext.getDiscountPrice(Integer.parseInt(mEtBuyCount.getText().toString()) * 10);
                        mTvDiscountPrice.setText("折后价：" + discountPrice);
                        mTvDiscountPrice.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}
