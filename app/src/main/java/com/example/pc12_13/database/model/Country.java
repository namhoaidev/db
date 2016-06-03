package com.example.pc12_13.database.model;


public class Country {
    public static final String TABLE_NAME = "Country";
    public static final String COL_ID = "id";
    public static final String COL_NAME_EN = "nameEn";
    public static final String COL_NAME_VI = "nameVi";
    public static final String COL_FLAG = "flag";

    public final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"("
            + COL_ID + " integer primary key, "
            + COL_NAME_EN  + " text,"
            + COL_NAME_VI + " text,"
            + COL_FLAG + " text)";

    public final static String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private long id;
    private String nameEn;
    private String nameVi;
    private String flag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Country() {
    }

    public Country(int id, String nameEn, String nameVi, String flag) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameVi = nameVi;
        this.flag = flag;
    }
}
