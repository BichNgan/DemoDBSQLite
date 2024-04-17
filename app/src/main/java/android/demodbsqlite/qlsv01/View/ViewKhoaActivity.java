package android.demodbsqlite.qlsv01.View;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.demodbsqlite.R;
import android.demodbsqlite.qlsv01.Controller.KhoaHandler;
import android.demodbsqlite.qlsv01.Controller.KhoaHandler01;
import android.demodbsqlite.qlsv01.Model.Khoa;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewKhoaActivity extends AppCompatActivity {
//    EditText edtMKhoa, edtTenKhoa;
//    Button btnThemKhoa, btnSuaKhoa;
//    ListView lvKhoa;
//    KhoaHandler khoaHandler;
//    ArrayList<Khoa>lsKhoa=new ArrayList<>();
//    ArrayAdapter<String>adapter;
//
//       @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_khoa);
//        addControl();
//        //---------------------------
//        khoaHandler=new KhoaHandler(getApplicationContext(),"qlsv.db", null,1);
//        lsKhoa=khoaHandler.loadKhoa();
//        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,toArrStringLsKhoa());
//        lvKhoa.setAdapter(adapter);
//        //-----------------
//        addEvent();
//    }
//    public void addControl()
//    {
//        edtMKhoa=(EditText) findViewById(R.id.edtMKhoa);
//        edtTenKhoa=(EditText) findViewById(R.id.edtTenKhoa);
//        btnSuaKhoa=(Button) findViewById(R.id.btnSuaKhoa);
//        btnThemKhoa=(Button) findViewById(R.id.btnThemKhoa);
//        lvKhoa=(ListView) findViewById(R.id.lvKhoa);
//    }
//    public void addEvent()
//    {
//        btnThemKhoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Khoa k = new Khoa(Integer.parseInt(edtMKhoa.getText().toString()),edtTenKhoa.getText().toString());
//                khoaHandler.insertNewKhoa(k);
//                reloadListView();
//            }
//        });
//
//        lvKhoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Khoa k =lsKhoa.get(position);
//                edtMKhoa.setText(String.valueOf(k.getMaKhoa()));
//               // edtMKhoa.setVisibility(View.INVISIBLE);
//                edtMKhoa.setEnabled(false);
//                edtTenKhoa.setText(k.getTenKhoa());
//            }
//        });
//        btnSuaKhoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(edtMKhoa.getText().toString()==null)
//                    return;
//                else
//                {
//                    Khoa newKhoa =new Khoa(Integer.parseInt(edtMKhoa.getText().toString()),edtTenKhoa.getText().toString());
//                    Khoa oldKhoa = timKhoa(Integer.parseInt(edtMKhoa.getText().toString()),lsKhoa);
//                    khoaHandler.updateKhoa(oldKhoa,newKhoa);
//                    reloadListView();
//                }
//            }
//        });
//    }
//    private  void reloadListView()
//    {
//        khoaHandler=new KhoaHandler(getApplicationContext(),"qlsv.db", null,1);
//        lsKhoa=khoaHandler.loadKhoa();
//        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,toArrStringLsKhoa());
//        lvKhoa.setAdapter(adapter);
//    }
//    private Khoa timKhoa(int makhoa,ArrayList<Khoa>lsKhoa )
//    {
//        for (Khoa k:lsKhoa ) {
//            if(k.getMaKhoa()==makhoa)
//                return k;
//        }
//        return null;
//    }
//    ArrayList<String> toArrStringLsKhoa()
//    {
//        ArrayList<String> kq=new ArrayList<>();
//        for (Khoa k:lsKhoa) {
//            kq.add(String.valueOf(k.getMaKhoa()) + " " + k.getTenKhoa() +"\n");
//        }
//        return kq;
//    }


    //=====================================================
    //==========================================================
    EditText edtMKhoa, edtTenKhoa;
    Button btnThemKhoa, btnSuaKhoa;
    ListView lvKhoa;
    KhoaHandler01 khoaHandler01;
    ArrayList<Khoa>lsKhoa=new ArrayList<>();
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_khoa);
        addControl();
        //---------------------------
        khoaHandler01=new KhoaHandler01(getApplicationContext(),"qlsv1.db", null,1);
        khoaHandler01.initData();
        lsKhoa=khoaHandler01.loadKhoa();
        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,toArrStringLsKhoa());
        lvKhoa.setAdapter(adapter);
        //-----------------
        addEvent();
    }
    public void addControl()
    {
        edtMKhoa=(EditText) findViewById(R.id.edtMKhoa);
        edtTenKhoa=(EditText) findViewById(R.id.edtTenKhoa);
        btnSuaKhoa=(Button) findViewById(R.id.btnSuaKhoa);
        btnThemKhoa=(Button) findViewById(R.id.btnThemKhoa);
        lvKhoa=(ListView) findViewById(R.id.lvKhoa);
    }
    public void addEvent()
    {
        btnThemKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Khoa k = new Khoa(Integer.parseInt(edtMKhoa.getText().toString()),edtTenKhoa.getText().toString());
                khoaHandler01.insertNewKhoa(k);
                reloadListView();
            }
        });

        lvKhoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Khoa k =lsKhoa.get(position);
                edtMKhoa.setText(String.valueOf(k.getMaKhoa()));
                // edtMKhoa.setVisibility(View.INVISIBLE);
                edtMKhoa.setEnabled(false);
                edtTenKhoa.setText(k.getTenKhoa());
            }
        });
        btnSuaKhoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtMKhoa.getText().toString()==null)
                    return;
                else
                {
                    Khoa newKhoa =new Khoa(Integer.parseInt(edtMKhoa.getText().toString()),edtTenKhoa.getText().toString());
                    Khoa oldKhoa = timKhoa(Integer.parseInt(edtMKhoa.getText().toString()),lsKhoa);
                    khoaHandler01.updateKhoa(oldKhoa,newKhoa);
                    reloadListView();
                }
            }
        });
    }
    private  void reloadListView()
    {
        khoaHandler01=new KhoaHandler01(getApplicationContext(),"qlsv.db", null,1);
        lsKhoa=khoaHandler01.loadKhoa();
        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,toArrStringLsKhoa());
        lvKhoa.setAdapter(adapter);
    }
    private Khoa timKhoa(int makhoa,ArrayList<Khoa>lsKhoa )
    {
        for (Khoa k:lsKhoa ) {
            if(k.getMaKhoa()==makhoa)
                return k;
        }
        return null;
    }
    ArrayList<String> toArrStringLsKhoa()
    {
        ArrayList<String> kq=new ArrayList<>();
        for (Khoa k:lsKhoa) {
            kq.add(String.valueOf(k.getMaKhoa()) + " " + k.getTenKhoa() +"\n");
        }
        return kq;
    }

}