package com.coderwjq.mementopattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtContent;
    private NoteCaretaker mNoteCaretaker = new NoteCaretaker();
    private Button mBtnUndo;
    private Button mBtnRedo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtContent = (EditText) findViewById(R.id.et_content);

        mBtnUndo = (Button) findViewById(R.id.btn_undo);
        mBtnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restore(mNoteCaretaker.getPreMementor());
                refreshButtonState();
            }
        });

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNoteCaretaker.saveMementor(createMementor());
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                refreshButtonState();
            }
        });

        mBtnRedo = (Button) findViewById(R.id.btn_redo);
        mBtnRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restore(mNoteCaretaker.getNextMementor());
                refreshButtonState();
            }
        });

        mNoteCaretaker.saveMementor(createMementor());
        refreshButtonState();
    }

    private void refreshButtonState() {
        mBtnUndo.setEnabled(mNoteCaretaker.isPreButtonEnable());
        mBtnRedo.setEnabled(mNoteCaretaker.isNextButtonEnable());
    }

    /**
     * 创建备忘录对象，即存储编辑器的指定数据
     *
     * @return
     */
    public Mementor createMementor() {
        Mementor mementor = new Mementor();
        mementor.setText(mEtContent.getText().toString());
        mementor.setCursor(mEtContent.getSelectionStart());
        return mementor;
    }

    /**
     * 从备忘录中恢复数据
     *
     * @param mementor
     */
    public void restore(Mementor mementor) {
        if (mementor != null) {
            mEtContent.setText(mementor.getText());
            mEtContent.setSelection(mementor.getCursor());
        }
    }
}
