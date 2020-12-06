package a.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = findViewById(R.id.activity_main);
        Button button = findViewById(R.id.button);

        myLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                handleTouch(m);
                return true;
            }

            private void handleTouch(MotionEvent m) {
                TextView textView1 = findViewById(R.id.textView2);
                TextView textView2 = findViewById(R.id.textView3);
                int pointerCount = m.getPointerCount();

                for (int i = 0; i < pointerCount; i++) {
                    int x = (int) m.getX(i);
                    int y = (int) m.getY(i);
                    int id = m.getPointerId(i);
                    int action = m.getActionMasked();
                    int actionIndex = m.getActionIndex();
                    String actionString;

                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            actionString = "DOWN";
                            break;
                        case MotionEvent.ACTION_UP:
                            actionString = "UP";
                            break;
                        case MotionEvent.ACTION_POINTER_DOWN:
                            actionString = "PNTR DOWN";
                            break;
                        case MotionEvent.ACTION_POINTER_UP:
                            actionString = "PNTR UP";
                            break;
                        case MotionEvent.ACTION_MOVE:
                            actionString = "MOVE";
                            break;
                        default:
                            actionString = "";
                    }
                    String touchStatus = "Action: " + actionString + " Index: " +
                            actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
                    if (id == 0)
                        textView1.setText(touchStatus);
                    else
                        textView2.setText(touchStatus);
                }
            }
        });


        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView statusText =  findViewById(R.id.textView);
                statusText.setText("Button clicked");
            }
        });

        button.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {
                TextView statusText = findViewById(R.id.textView);
                statusText.setText("Long button click");
                return true;
            }
        });

    }
}