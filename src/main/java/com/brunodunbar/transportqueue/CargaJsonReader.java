package com.brunodunbar.transportqueue;

import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CargaJsonReader implements AutoCloseable {

    private JsonReader jsonReader;

    public CargaJsonReader(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        this.jsonReader = new JsonReader(new InputStreamReader(inputStream));
    }

    public CargaJsonReader(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }

    public List<Carga> read() throws IOException {

        jsonReader.beginArray();

        List<Carga> cargas = new ArrayList<>();

        while (jsonReader.hasNext()) {
            cargas.add(readCarga());
        }

        jsonReader.endArray();

        return cargas;
    }

    private Carga readCarga() throws IOException {

        jsonReader.beginObject();

        String codigo = null;
        String destinatario = null;
        String endereco = null;
        Integer prioridade = 0;

        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "codigo":
                    codigo = jsonReader.nextString();
                    break;
                case "destinatario":
                    destinatario = jsonReader.nextString();
                    break;
                case "endereco":
                    endereco = jsonReader.nextString();
                    break;
                case "prioridade":
                    prioridade = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
            }
        }
        jsonReader.endObject();

        return new Carga(codigo, destinatario, endereco, prioridade);
    }

    @Override
    public void close() throws IOException {
        jsonReader.close();
    }
}
