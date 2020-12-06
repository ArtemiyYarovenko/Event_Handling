package a.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;



public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{

    private TextView gestureText;
    private GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = findViewById(R.id.activity_main);
        Button button = findViewById(R.id.button);
        gestureText = findViewById(R.id.textView);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.textView);
        switch(id){
            case R.id.button_action :
                headerView.setText("кнопка");
                return true;
            case R.id.xy_action:
                headerView.setText("координаты");
                return true;
            case R.id.jest_action:
                headerView.setText("жесты");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

}