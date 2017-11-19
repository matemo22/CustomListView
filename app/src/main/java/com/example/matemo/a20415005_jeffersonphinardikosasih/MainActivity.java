package com.example.matemo.a20415005_jeffersonphinardikosasih;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText namaBarang, hargaBarang;
    Button btnAdd, btnEdit, btnDelete, btnDeleteAll;
    ListView lvBarang;
    ArrayList<Barang> arrBarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    Barang currentBarang;
    int index=-1;
    int numId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaBarang = (EditText) findViewById(R.id.editTextNamaBarang);
        hargaBarang = (EditText) findViewById(R.id.editTextHargaBarang);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDeleteAll = (Button) findViewById(R.id.btnDeleteAll);
        lvBarang = (ListView) findViewById(R.id.listView);

        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        adapter = new BarangAdapter(this, arrBarang);
        lvBarang.setAdapter(adapter);

        lvBarang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                currentBarang = (Barang) adapterView.getItemAtPosition(i);
                namaBarang.setText(currentBarang.getNama());
                    hargaBarang.setText(currentBarang.getHarga());
                    index=i;
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = generateId(namaBarang.getText().toString());

                int number = (int) (Math.random()*3);
                int img;
                if(number==1) img = R.drawable.fb_logo;
                else if(number==2) img = R.drawable.line_logo;
                else img = R.drawable.pixiv_logo;

                Barang newBarang = new Barang(namaBarang.getText().toString(), hargaBarang.getText().toString(), img, id);
                arrBarang.add(newBarang);
                clean();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index!=-1)
                {
                    String id = namaBarang.getText().toString().toUpperCase();
                    id = id.substring(0,2);
                    String numId = currentBarang.getId().substring(2);
                    id=id+numId;
                    Barang newBarang = new Barang(namaBarang.getText().toString(), hargaBarang.getText().toString(), currentBarang.getImg(), id);
                    arrBarang.remove(index);
                    arrBarang.add(index, newBarang);
                    clean();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index!=-1)
                {
                    arrBarang.remove(index);
                    clean();
                }
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrBarang.removeAll(arrBarang);
                clean();
            }
        });
    }

    public String generateId(String namaBarang)
    {
        numId++;
        String id = namaBarang.toUpperCase();
        id = id.substring(0,2);
        if(numId<10) id=id+"00"+numId;
        else if(numId<100) id=id+"0"+numId;
        else id=id+numId;
        return id;
    }

    public void clean()
    {
        adapter.notifyDataSetChanged();
        currentBarang=null;
        index=-1;
        namaBarang.setText("");
        hargaBarang.setText("");
        namaBarang.requestFocus();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }
}
