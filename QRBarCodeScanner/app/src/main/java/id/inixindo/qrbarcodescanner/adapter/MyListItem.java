package id.inixindo.qrbarcodescanner.adapter;

public class MyListItem {
    private String code;
    private String type;

    public MyListItem(String code, String type){
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
