package com.brunodunbar.transportqueue;

import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class CargaJsonWriter implements AutoCloseable {

    private JsonWriter jsonWriter;

    public CargaJsonWriter(OutputStream outputStream) {
        Objects.requireNonNull(outputStream);
        this.jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream));
    }

    public CargaJsonWriter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
    }

    public void write(List<Carga> cargas) throws IOException {
        jsonWriter.beginArray();
        for (Carga carga : cargas) {
            write(carga);
        }
        jsonWriter.endArray();
    }

    private void write(Carga carga) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("codigo").value(carga.getCodigo());
        jsonWriter.name("destinatario").value(carga.getDestinatario());
        jsonWriter.name("endereco").value(carga.getEndereco());
        jsonWriter.name("prioridade").value(carga.getPrioridade());

        jsonWriter.endObject();
    }

    @Override
    public void close() throws IOException {
        jsonWriter.close();
    }
}
