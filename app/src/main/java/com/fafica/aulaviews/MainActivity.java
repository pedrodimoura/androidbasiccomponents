package com.fafica.aulaviews;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.fafica.aulaviews.adapter.ListViewCustomAdapter;
import com.fafica.aulaviews.adapter.SpinnerCustomAdapter;
import com.fafica.aulaviews.dialog.MyAlertDialog;
import com.fafica.aulaviews.util.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner mSpinner;
    private ArrayAdapter<CharSequence> mSpinnerArrayAdapter;

    private AutoCompleteTextView mAutoCompleteTextView;
    private ArrayAdapter<CharSequence> mAutoCompleteArrayAdapter;

    private Spinner mSpinnerCustom;
    private SpinnerCustomAdapter mSpinnerCustomAdapter;

    private Button mButtonProgressDialog;
    private Button mButtonProgressBar;
    private ProgressDialog mProgressDialog;
    private ProgressBar mProgressBar;
    private Button mButtonAlertDialog;

    private ListView mListView;
    private ArrayAdapter<String> mArrayAdapterListView;
    private ListViewCustomAdapter mListViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init() {

        // Simple Spinner
        this.mSpinner = (Spinner) findViewById(R.id.spinner);
        this.mSpinner.setOnItemSelectedListener(MainActivity.this);
        this.mSpinnerArrayAdapter = ArrayAdapter.createFromResource(
                MainActivity.this,
                R.array.spinner_array,
                android.R.layout.simple_spinner_item
        );

        this.mSpinnerArrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        this.mSpinner.setAdapter(this.mSpinnerArrayAdapter);
        // End Simple Spinner

        // AutoCompleteTextView
        this.mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        this.mAutoCompleteArrayAdapter = ArrayAdapter.createFromResource(
                MainActivity.this,
                R.array.auto_complete_text_array,
                android.R.layout.simple_dropdown_item_1line
        );

        this.mAutoCompleteTextView.setAdapter(this.mAutoCompleteArrayAdapter);
        // End AutoCompleteTextView


        this.mSpinnerCustom = (Spinner) findViewById(R.id.spinnerCustom);
        this.mSpinnerCustom.setOnItemSelectedListener(MainActivity.this);

        this.mSpinnerCustomAdapter = new SpinnerCustomAdapter(MainActivity.this);
        this.mSpinnerCustom.setAdapter(this.mSpinnerCustomAdapter);

        this.mButtonProgressDialog = (Button) findViewById(R.id.buttonProgressDialog);
        this.mButtonProgressDialog.setOnClickListener(this);

        this.mButtonProgressBar = (Button) findViewById(R.id.buttonProgressBar);
        this.mButtonProgressBar.setOnClickListener(this);

        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        this.mButtonAlertDialog = (Button) findViewById(R.id.buttonAlertDialog);
        this.mButtonAlertDialog.setOnClickListener(this);


        this.mListView = (ListView) findViewById(R.id.listView);

//        this.mArrayAdapterListView = new ArrayAdapter<>(
//                MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.spinner_array)
//        );

        this.mListViewCustomAdapter = new ListViewCustomAdapter(
                MainActivity.this,
                getResources().getStringArray(R.array.spinner_array)
        );

//        this.mListView.setAdapter(this.mArrayAdapterListView);
        this.mListView.setAdapter(mListViewCustomAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(Constants.DEBUG_KEY, "onItemSelected | AdapterView -> " + adapterView + ", View -> " + view + ", i -> " + i + ", l -> " + l);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(Constants.DEBUG_KEY, "onNothingSelected | AdapterView -> " + adapterView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonProgressDialog:
                this.mProgressDialog = ProgressDialog.show(
                        MainActivity.this,
                        getResources().getString(R.string.progress_dialog_title),
                        getResources().getString(R.string.progress_dialog_message),
                        true,
                        true,
                        new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface) {
                                Log.d(Constants.DEBUG_KEY, "onCancel -> " + dialogInterface); // do something
                            }
                        }
                );
                break;
            case R.id.buttonProgressBar:
                this.mProgressBar.setVisibility(
                    (this.mProgressBar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE)
                );
                break;
            case R.id.buttonAlertDialog:
                MyAlertDialog myAlertDialog = new MyAlertDialog();
                myAlertDialog.show(getSupportFragmentManager(), null);
                break;
        }
    }
}
