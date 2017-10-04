package com.example.marvin.jsonlotr;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import course.assignment.jsonlotr.R;



public class JSONActivity extends Activity {

    private String TAG = JSONActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> charList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonactivity);

        charList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetCooks().execute();
    }

    private class GetCooks extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler hh = new HttpHandler();


            String url = "https://raw.githubusercontent.com/btford/philosobot/master/quotes/cats.json";
            String jsonStr = hh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONArray gotArray = new JSONArray(jsonStr);



                    for (int i = 0; i < gotArray.length(); i++) {
                        JSONObject c = gotArray.getJSONObject(i);
                        /*String topic = c.getString("topic");*/
                        String quote = c.getString("quote");
                        String author = c.getString("author");



                        HashMap<String, String> character = new HashMap<>();

                        /*character.put("topic", topic);*/
                        character.put("quote", quote);
                        character.put("author", author);


                        charList.add(character);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(JSONActivity.this, charList,
                    R.layout.list_item, new String[]{/*"topic",*/ "quote", "author"},
                    new int[]{R.id.quote, R.id.author});
            lv.setAdapter(adapter);
        }
    }
}