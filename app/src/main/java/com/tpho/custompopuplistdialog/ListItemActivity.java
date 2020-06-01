package com.tpho.custompopuplistdialog;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends ListActivity {
    public static String RESULT_ITEMCODE = "itemcode";
    public String[] item_names, item_codes;
    private TypedArray imgs;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateItemList();
        ArrayAdapter<Item> adapter = new ListItemArrayAdapter(this, itemList);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item c = itemList.get(position);
                Intent returnIntent = new Intent();
                returnIntent.putExtra(RESULT_ITEMCODE, c.getCode());
                setResult(RESULT_OK, returnIntent);
                imgs.recycle(); //recycle images
                finish();
            }
        });
    }

    private void populateItemList() {
        itemList = new ArrayList<Item>();
        item_names = getResources().getStringArray(R.array.item_names);
        item_codes = getResources().getStringArray(R.array.item_codes);
        imgs = getResources().obtainTypedArray(R.array.item_photos);
        for(int i = 0; i < item_codes.length; i++){
            itemList.add(new Item(item_names[i], item_codes[i], imgs.getDrawable(i)));
        }
    }

    public class Item {
        private String name;
        private String code;
        private Drawable flag;
        public Item(String name, String code, Drawable flag){
            this.name = name;
            this.code = code;
            this.flag = flag;
        }
        public String getName() {
            return name;
        }
        public Drawable getFlag() {
            return flag;
        }
        public String getCode() {
            return code;
        }
    }
}
