package com.example.nikhi.a4game277;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import android.util.Log;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    public String val = "";
    public static int skip = 0;
    public static int attempts = 1;
    public static int success = 0;

    public int getSuccess() {
        return success;
    }

    public void setSuccess() {
        success = success + 1;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts() {
        attempts = attempts + 1;
    }

    public static int getSkip() {
        return skip;
    }

    public static void setSkip() {
        skip = skip + 1;
    }

    public static int counter = 0;
    public String timerText;
    private Handler handler;
    private DrawerLayout mDrawerLayout;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_nav_menu);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        int id = menuItem.getItemId();
                        if(id == R.id.nav_showme){
                            Button b1 = findViewById(R.id.button_1);
                            int i1 = Integer.parseInt(b1.getText().toString());
                            Button b2 = findViewById(R.id.button_2);
                            int i2 = Integer.parseInt(b2.getText().toString());
                            Button b3 = findViewById(R.id.button_3);
                            int i3 = Integer.parseInt(b3.getText().toString());
                            Button b4 = findViewById(R.id.button_4);
                            int i4 = Integer.parseInt(b4.getText().toString());
                            String flag = MakeNumber.getSolution(i1, i2, i3, i4);
                            Log.v("sol","sol"+i1+i2+i3+i4+flag);
                            //AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                            //builder1.setTitle("Show me Solution");
                            //builder1.setMessage("" + flag + "is the solution");
                            //builder1.setPositiveButton("Ok",null);

                        }
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        final ArrayList<Integer> li = new ArrayList<Integer>();
        final EditText e1 = (EditText) findViewById(R.id.value);


        attempts = 0;
        TimerSet();
        RandomNumber();

        final Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button1.setEnabled(false);
                val = val + button1.getText().toString() + " ";
                e1.setText(val.toString());
                li.add(1);
            }
        });

        final Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button2.setEnabled(false);
                val = val + button2.getText().toString() + " ";
                e1.setText(val.toString());
                li.add(2);
                // Code here executes on main thread after user presses button
            }
        });

        final Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button3.setEnabled(false);
                val = val + button3.getText().toString() + " ";
                e1.setText(val.toString());
                li.add(3);
                // Code here executes on main thread after user presses button
            }
        });

        final Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button4.setEnabled(false);
                val = val + button4.getText().toString() + " ";
                e1.setText(val.toString());
                li.add(4);
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonplus = findViewById(R.id.button_plus);
        buttonplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttonplus.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonminus = findViewById(R.id.button_minus);
        buttonminus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttonminus.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonmul = findViewById(R.id.button_mul);
        buttonmul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttonmul.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttondiv = findViewById(R.id.button_div);
        buttondiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttondiv.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonop = findViewById(R.id.button_op);
        buttonop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttonop.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttoncp = findViewById(R.id.button_cp);
        buttoncp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                val = val + buttoncp.getText().toString() + " ";
                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonbs = findViewById(R.id.button_bs);
        buttonbs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //val = val.substring(0, val.length() - 1);

                if (val != null && val.length() > 0) {

                    if (val.matches(".*\\d+.*")) {
                        int temp = li.get(li.size() - 1);
                        Log.v("bs", "bs-" + temp + "li" + li);
                        //button1.setEnabled(true);
                        if (temp == 1) {
                            button1.setEnabled(true);
                        } else if (temp == 2) {
                            button2.setEnabled(true);
                        } else if (temp == 3) {
                            button3.setEnabled(true);
                        } else if (temp == 4) {
                            button4.setEnabled(true);
                        }
                        li.remove(new Integer(temp));
                    }
                    val = val.substring(0, val.length() - 2);
                }

                e1.setText(val.toString());
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttondone = findViewById(R.id.button_done);
        buttondone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setAttempts();
                final EditText e3 = (EditText) findViewById(R.id.attempt);
                e3.setText("" + getAttempts());
                Log.v("exp", "exp-" + val);
                int x = EvaluateExpression.evaluate(val);
                Log.v("done", "eval-" + x);
                e1.setText("" + x);
                if (x != 24 || x == 0) {
                    Snackbar.make(findViewById(android.R.id.content), "Incorrect. Please try again", Snackbar.LENGTH_LONG).show();
                    refresh();
                } else {
                    final EditText es = (EditText) findViewById(R.id.succeeded);
                    setSuccess();
                    Log.v("suc", "suc" + getSuccess());
                    es.setText(Integer.toString(getSuccess()));
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Bingooooo");
                    builder.setMessage("" + val + "is 24!");
                    builder.setPositiveButton("Next Puzzle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            RandomNumber();
                            attempts = 1;
                            final EditText ea = (EditText) findViewById(R.id.attempt);
                            ea.setText("" + getAttempts());

                        }
                    });
                    builder.show();


                }
                val = "";

                // Code here executes on main thread after user presses button
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    boolean canAddItem = false;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        if (item.getItemId() == R.id.action_cancelGame) {
            refresh();

        }
        if (item.getItemId() == R.id.action_skipGame) {
            // if a the new item is clicked show "Toast" message.
            setSkip();
            final EditText e2 = (EditText) findViewById(R.id.skipped);
            e2.setText(Integer.toString(getSkip()));
            counter = 0;
            RandomNumber();
            val = "";
            final EditText e1 = (EditText) findViewById(R.id.value);

            e1.setText("");
            refresh();


        }

        return super.onOptionsItemSelected(item);
    }

    public void RandomNumber() {
        Random r1 = new Random();
        int i1 = r1.nextInt(9 - 1);
        Button mButton1 = (Button) findViewById(R.id.button_1);
        mButton1.setText(Integer.toString(i1));

        Random r2 = new Random();
        int i2 = r2.nextInt(9 - 1);
        Button mButton2 = (Button) findViewById(R.id.button_2);
        mButton2.setText(Integer.toString(i2));

        Random r3 = new Random();
        int i3 = r3.nextInt(9 - 1);
        Button mButton3 = (Button) findViewById(R.id.button_3);
        mButton3.setText(Integer.toString(i3));

        Random r4 = new Random();
        int i4 = r4.nextInt(9 - 1);
        Button mButton4 = (Button) findViewById(R.id.button_4);
        mButton4.setText(Integer.toString(i4));

        //Button mButtondone = (Button) findViewById(R.id.button_done);
        mButton1.setEnabled(true);
        mButton2.setEnabled(true);
        mButton3.setEnabled(true);
        mButton4.setEnabled(true);
        final EditText e1 = (EditText) findViewById(R.id.value);

        e1.setText("");
        val = "";
        String flag;
        flag = MakeNumber.getSolution(i1, i2, i3, i4);
        Log.v("flag", "flag" + flag);
        if (flag == null) {
            RandomNumber();
        }
    }

    public void TimerSet() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final TextView t1 = (TextView) findViewById(R.id.time);
                final Button b1 = (Button) findViewById(R.id.button_done);

                if (TextUtils.isEmpty(val)) {
                    b1.setEnabled(false);
                } else {
                    b1.setEnabled(true);
                }
                counter = counter + 1;
                int seconds = counter;
                int minutes = seconds / 60;
                seconds = counter % 60;
                Log.d("counter", "count=" + seconds);
                timerText = String.format("%d:%02d", minutes, seconds);
                t1.setText(timerText);
                handler.postDelayed(this, 1000);
            }
        }, 1);
    }

    public void refresh() {
        val = "";
        final EditText e1 = (EditText) findViewById(R.id.value);

        e1.setText("");
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);
        final Button button4 = findViewById(R.id.button_4);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }

}
