package com.example.longnv.nimbl3_test.adapter;


import com.example.longnv.nimbl3_test.models.IncludedData;
import com.example.longnv.nimbl3_test.models.Places;
import com.example.longnv.nimbl3_test.models.User;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Vu Long on 8/26/2018.
 * nguyenvulong2002@gmail.com
 */
public class MyObjectTypeAdapter extends TypeAdapter<IncludedData> {

    @Override
    public void write(JsonWriter out, IncludedData value) throws IOException {
        out.beginObject().name("attributes").value(value.getType()).endObject();
    }

    @Override
    public IncludedData read(JsonReader in) throws IOException {
        IncludedData result = new IncludedData();
        in.beginObject();
        while (in.hasNext()) {
            User user = new User();
            Places places = new Places();
            switch (in.nextName()) {
                case "first_name":

                    //result.setUser(in.nex());
            }

        }

        in.endObject();
        return result;
    }
}