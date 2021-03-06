package edu.upc.eetac.dsa.dsaqp1415g3.gelapp;

/**
 * Created by marc on 15/05/15.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.AppException;
import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.GelappAPI;
import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.Helado;


public class CreateGelappActivity extends Activity {
    private final static String TAG = CreateGelappActivity.class.getName();

    private String capa1;
    private String capa2;
    private String capa3;
    private String capa4;
    private String capa5;


    private class PostHeladoTask extends AsyncTask<String, Void, Helado> {
        private ProgressDialog pd;

        @Override
        protected Helado doInBackground(String... params) {
            Helado helado = null;
            try {
                helado = GelappAPI.getInstance(CreateGelappActivity.this)
                        .createHelado(Integer.parseInt(params[0]), params[1], params[2], params[3], params[4], params[5], params[6]);
            } catch (AppException e) {
                Log.e(TAG, e.getMessage(), e);
            }
            return helado;
        }

        @Override
        protected void onPostExecute(Helado result) {
            showHelados(result);
            if (pd != null) {
                pd.dismiss();
            }
        }

        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(CreateGelappActivity.this);

            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_gelapp_layout);

        //Creo los spinners, doy las variables

        //Spinner1
        Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.Toppings, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);

        //envio la selección al post
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //aquí enviaríamos el topping seleccionado para hacer el post

                //Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                capa1 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner2
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Sabores, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        //envio la selección al post
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //aquí enviaríamos el topping seleccionado para hacer el post

                //Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                capa2 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner3
        Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Toppings, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);

        //envio la selección al post
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //aquí enviaríamos el topping seleccionado para hacer el post

                //Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                capa3 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner4
        Spinner sp4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this,R.array.Sabores, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(adapter4);

        //envio la selección al post
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //aquí enviaríamos el topping seleccionado para hacer el post

                //Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                capa4 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner5
        Spinner sp5 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this,R.array.Toppings, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp5.setAdapter(adapter5);

        //envio la selección al post
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //aquí enviaríamos el topping seleccionado para hacer el post

                //Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                capa5 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void cancel(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void postHelado(View v) {
        EditText etNombre = (EditText) findViewById(R.id.etNombreHelado);
        //EditText etCapa1 = (EditText) findViewById(R.id.spinner1);
        //EditText etCapa2 = (EditText) findViewById(R.id.spinner2);
        //EditText etCapa3 = (EditText) findViewById(R.id.spinner3);
        //EditText etCapa4 = (EditText) findViewById(R.id.spinner4);
        //EditText etCapa5 = (EditText) findViewById(R.id.spinner5);

        String nombreHelado = etNombre.getText().toString();
        int autorid = 1;

        (new PostHeladoTask()).execute("1",nombreHelado,capa1,capa2,capa3,capa4,capa5);

       // EditText etSubject = (EditText) findViewById(R.id.etSubject);
        //EditText etContent = (EditText) findViewById(R.id.etContent);

        //String subject = etSubject.getText().toString();
        //String content = etContent.getText().toString();

        //(new PostStingTask()).execute(subject, content);
    }

    private void showHelados(Helado result) {
        String json = new Gson().toJson(result);
        Bundle data = new Bundle();
        data.putString("json-sting", json);
        Intent intent = new Intent();
        intent.putExtras(data);
        setResult(RESULT_OK, intent);
        finish();
    }

}