package android.demodbsqlite.qlsv01.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.demodbsqlite.qlsv01.Model.Khoa;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class KhoaHandler01 extends SQLiteOpenHelper {
    public static final String DB_NAME ="qlsv.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME="Khoa";
    private static final String MKHOA_COL="makhoa";
    private static final String TKHOA_COL="tenkhoa";
    public static String path = "/data/data/android.demodbsqlite/db/qlsv1.db";
    //------------------------------------------------------------------------

    public KhoaHandler01(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + MKHOA_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TKHOA_COL + " TEXT)";
        db.execSQL(query);
    }
//------------------------------------
    //thêm dữ liệu bằng inser into
    public void initData()
    {
        SQLiteDatabase db;
        db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        onCreate(db);
        String row1  = "INSERT INTO " + TABLE_NAME + " ("
                + MKHOA_COL + ", " + TKHOA_COL + ") Values ('1','CNTT')";
        db.execSQL(row1);
        String row2  = "INSERT INTO " + TABLE_NAME + " ("
                + MKHOA_COL + ", " + TKHOA_COL + ") Values ('2','TCNH')";
        db.execSQL(row2);
        String row3  = "INSERT INTO " + TABLE_NAME + " ("
                + MKHOA_COL + ", " + TKHOA_COL + ") Values ('3','QTKD')";
        db.execSQL(row3);

        db.close();
    }


 //-------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public ArrayList<Khoa> loadKhoa()
    {
        SQLiteDatabase db;
        ArrayList<Khoa> lsKhoa=new ArrayList<>();
        db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.CREATE_IF_NECESSARY);
        Cursor cursor = db.rawQuery("select * from Khoa",null);
        cursor.moveToFirst();
        do {
            Khoa khoa = new Khoa();
            khoa.setMaKhoa(cursor.getInt(0));
            khoa.setTenKhoa(cursor.getString(1));

            lsKhoa.add(khoa);
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return lsKhoa;
    }

    public void insertNewKhoa(Khoa k)
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);

        ContentValues values = new ContentValues();
        values.put(MKHOA_COL,k.getMaKhoa());
        values.put(TKHOA_COL,k.getTenKhoa());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public  void updateKhoa(Khoa oldKhoa, Khoa newKhoa)
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        ContentValues values = new ContentValues();
        values.put(MKHOA_COL,newKhoa.getMaKhoa());
        values.put(TKHOA_COL,newKhoa.getTenKhoa());
        db.update(TABLE_NAME,values,"makhoa=?",
                new String[]{String.valueOf(oldKhoa.getMaKhoa())});
        db.close();
    }
}
