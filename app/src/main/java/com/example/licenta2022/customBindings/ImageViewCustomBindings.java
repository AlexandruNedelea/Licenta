package com.example.licenta2022.customBindings;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.licenta2022.ItemType.HotelItemType;
import com.example.licenta2022.ItemType.RoomServiceActivityItemType;
import com.example.licenta2022.ItemType.TripsActivityItemType;
import com.example.licenta2022.R;

public class ImageViewCustomBindings {
    @BindingAdapter("loadCountryFlagIntoView")
    public static void loadCountryFlagIntoView(AppCompatImageView view, int entryType) {
        int imageToDisplay = R.drawable.bruschetta;
        switch (entryType) {
            case HotelItemType.ROOM:
                imageToDisplay = R.drawable.room1;
                break;
            case HotelItemType.ROOM_SERVICE:
                imageToDisplay = R.drawable.service1;
                break;
            case HotelItemType.MENAGERIE:
                imageToDisplay = R.drawable.menaj1;
                break;
            case HotelItemType.TRIPS:
                imageToDisplay = R.drawable.trip1;
                break;
            default:
                break;
        }
        Glide.with(view.getContext())
                .load(imageToDisplay)
                .into(view);
    }

    @BindingAdapter("tripsMenuImageBinding")
    public static void tripsMenuImageBinding(AppCompatImageView view, String entryType) {
        int imageToDisplay = R.drawable.parapanta;
        switch (entryType) {
            case TripsActivityItemType.PARAPANTA:
                imageToDisplay = R.drawable.parapanta1;
                break;
            case TripsActivityItemType.SCUBADIVING:
                imageToDisplay = R.drawable.scubadiving1;
                break;
            case TripsActivityItemType.SURF:
                imageToDisplay = R.drawable.surf1;
                break;
            case TripsActivityItemType.BOAT:
                imageToDisplay = R.drawable.boat1;
                break;
            default:
                break;
        }
        Glide.with(view.getContext())
                .load(imageToDisplay)
                .into(view);
    }

    @BindingAdapter("roomserviceMenuImageBinding")
    public static void roomserviceMenuImageBinding(AppCompatImageView view, int entryType) {
        int imageToDisplay = R.drawable.parapanta;
        switch (entryType) {
            case RoomServiceActivityItemType.Bruschetta:
                imageToDisplay = R.drawable.bruschetta;
                break;
            case RoomServiceActivityItemType.Jamon:
                imageToDisplay = R.drawable.jamon;
                break;
            case RoomServiceActivityItemType.Cheese:
                imageToDisplay = R.drawable.cheeseplatter;
                break;
            case RoomServiceActivityItemType.Paella:
                imageToDisplay = R.drawable.paella;
                break;
            case RoomServiceActivityItemType.Seafood:
                imageToDisplay = R.drawable.seafood;
                break;
            case RoomServiceActivityItemType.Fish:
                imageToDisplay = R.drawable.fishstew;
                break;
            case RoomServiceActivityItemType.PizzaMargherita:
                imageToDisplay = R.drawable.pizzamargherita;
                break;
            case RoomServiceActivityItemType.PizzaMarinara:
                imageToDisplay = R.drawable.pizzamarinara;
                break;
            case RoomServiceActivityItemType.PizzaFruttidiMare:
                imageToDisplay = R.drawable.pizzafruttidimare;
                break;
            case RoomServiceActivityItemType.Tiramisu:
                imageToDisplay = R.drawable.tiramisu;
                break;
            case RoomServiceActivityItemType.Strawberrycheesecake:
                imageToDisplay = R.drawable.strawberrycheesecake;
                break;
            case RoomServiceActivityItemType.CocaCola:
                imageToDisplay = R.drawable.cocacola;
                break;
            case RoomServiceActivityItemType.MineralWater:
                imageToDisplay = R.drawable.mineralwater;
                break;
            case RoomServiceActivityItemType.StillWater:
                imageToDisplay = R.drawable.stillwater;
                break;
            case RoomServiceActivityItemType.Wine:
                imageToDisplay = R.drawable.wine;
                break;
            default:
                break;
        }
        Glide.with(view.getContext())
                .load(imageToDisplay)
                .into(view);
    }


    @BindingAdapter("dealsTripsImageBinding")
    public static void dealsTripsImageBinding(AppCompatImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @BindingAdapter("balconyImageBinding")
    public static void balconyImageBinding(AppCompatImageView view, String entryType) {
        int imageToDisplay = R.drawable.parapanta;
        switch (entryType) {
            case TripsActivityItemType.PARAPANTA:
                imageToDisplay = R.drawable.parapanta1;
                break;
            case TripsActivityItemType.SCUBADIVING:
                imageToDisplay = R.drawable.scubadiving1;
                break;
            case TripsActivityItemType.SURF:
                imageToDisplay = R.drawable.surf1;
                break;
            case TripsActivityItemType.BOAT:
                imageToDisplay = R.drawable.boat1;
                break;
            default:
                break;
        }
        Glide.with(view.getContext())
                .load(imageToDisplay)
                .into(view);
    }
}


