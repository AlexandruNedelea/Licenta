package com.example.licenta2022;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.licenta2022.ItemType.RoomServiceActivityItemType;
import com.example.licenta2022.activities.BaseActivity;
import com.example.licenta2022.adapters.RoomServiceAdapter;
import com.example.licenta2022.databinding.ActivityRoomServiceBinding;
import com.example.licenta2022.enums.ListItemGenericType;
import com.example.licenta2022.helpers.DataStorageHelper;
import com.example.licenta2022.helpers.DateTimeHelper;
import com.example.licenta2022.models.ListHeaderModelUI;
import com.example.licenta2022.models.ListItemBaseModelUI;
import com.example.licenta2022.models.RoomServiceModelUI;
import com.example.licenta2022.models.network.HouseKeepingModel;
import com.example.licenta2022.models.network.RoomServiceModel;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class RoomServiceActivity extends BaseActivity<ActivityRoomServiceBinding> {
    private final ArrayList<ListItemBaseModelUI> roomServiceModelUIArrayList = new ArrayList<>();

    private int orderedItemsSentToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataBinding = ActivityRoomServiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setRecyclerView();
        setListeners();
    }

    private void setListeners() {
        dataBinding.btnRoomServiceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOrderedItems();
            }
        });
    }

    private void getOrderedItems() {
        var orderedItems = new ArrayList<RoomServiceModel>();
        for (var menuItem : roomServiceModelUIArrayList) {
            if (menuItem instanceof RoomServiceModelUI) {
                if (((RoomServiceModelUI) menuItem).getQuantity() > 0) {
                    orderedItems.add(new RoomServiceModel((RoomServiceModelUI)menuItem));
                }
            }
        }
        if (orderedItems.size() > 0) {
            sendOrdersToServer(orderedItems);
        }
    }

    private void sendOrdersToServer(ArrayList<RoomServiceModel> orderedItems) {
        var currentDateTime = DateTimeHelper.getInstance().getCurrentDateTimeInString();
        for (var item : orderedItems) {
            sendIndividualOrderToServer(item, orderedItems.size(), currentDateTime);
        }
    }

    private void sendIndividualOrderToServer(RoomServiceModel item, int size, String currentDateTime) {
        FirebaseHelper.getInstance().getRoomServiceDatabaseReference()
                .child(DataStorageHelper.getInstance().getRoomNumber())
                .child(currentDateTime)
                .push()
                .setValue(item)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        checkIfAllProblemsSent(size);
                    }
                });
    }

    private void checkIfAllProblemsSent(int totalProblems) {
        if (++orderedItemsSentToServer == totalProblems) {
            Toast.makeText(this, "Order completed", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    private void setRecyclerView() {
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Appetizer"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,1,"Bruschetta with tomatoes",25,"87,5 oz.","bread, tomatoes, gorgonzola, mozzarella, salt, pepper, basil"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,2,"Jamon",30,"100 oz.","jamon, pepper, salt, figs"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,3,"Cheese platter",35,"200 oz.","mozzarella, gouda cheese, moldy cheese, edam cheese, grapes, nuts, olives"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Main dish"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,4,"Paella",35,"150 oz.","onion, garlic, olive oil, tomatoes, shrimp, mushrooms, squid, lemon"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,5,"Seafood",50,"300 oz.","Crab legs, smoked salmon, lobster, mussels, oysters"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,6,"Fish stew",20,"150 oz.","onion, garlic, olive oil, tomatoes, mussels, butter"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,7,"Pizza Margherita",15,"100 oz.","sauce, fresh mozzarella, basil, salt, pepper"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,8,"Pizza Marinara",10,"100 oz.","tomato sauce, garlic, oregano, salt, pepper"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,9,"Pizza Frutti di Mare",20,"120 oz.","shrimp, mussels, calamari, oregano, basil, salt, pepper"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Dessert"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,10,"Tiramisu",8,"50kg","italian ladyfingers, egg yolks, mascarpone, sugar, espresso"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,11,"Strawberry cheesecake",8,"30 oz.","graham crackers, butter, brown sugar, vanilla extract"));
        roomServiceModelUIArrayList.add(new ListHeaderModelUI(ListItemGenericType.HEADER,"Drinks"));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,12,"Coca-Cola",3,"1 bottle, 16,91 fl. oz.",""));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,13,"Mineral Water",2,"1 bottle, 16,91 fl. oz.",""));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,14,"Still Water",2,"1 bottle, 16,91 fl. oz.",""));
        roomServiceModelUIArrayList.add(new RoomServiceModelUI(ListItemGenericType.ITEM,15,"Wine",15,"1 bottle, 33,81 fl. oz.",""));

        var roomServiceAdapter = new RoomServiceAdapter(roomServiceModelUIArrayList, new RoomServiceAdapter.RoomServiceClickListener() {
            @Override
            public void onMenuClick(ListItemBaseModelUI item) {
                if (item instanceof RoomServiceModelUI) {
                    ((RoomServiceModelUI) item).setSelected(!((RoomServiceModelUI) item).isSelected());
                }
            }
        });
        dataBinding.rvRowRoom.setAdapter(roomServiceAdapter);
    }
}