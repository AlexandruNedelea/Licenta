package com.example.licenta2022.customBindings;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.licenta2022.ItemType.HotelItemType;
import com.example.licenta2022.ItemType.TripsActivityItemType;
import com.example.licenta2022.R;

public class ImageViewCustomBindings {
    @BindingAdapter("loadCountryFlagIntoView")
    public static void loadCountryFlagIntoView(AppCompatImageView view, int entryType) {
        int imageToDisplay = R.drawable.menaj;
        switch (entryType) {
            case HotelItemType.ROOM:
                imageToDisplay = R.drawable.room;
                break;
//            case HotelItemType.BALCONY:
//                imageToDisplay = R.drawable.balcony;
//                break;
//            case HotelItemType.BATH:
//                imageToDisplay = R.drawable.bath;
//                break;
            case HotelItemType.ROOM_SERVICE:
                imageToDisplay = R.drawable.service;
                break;
            case HotelItemType.MENAGERIE:
                imageToDisplay = R.drawable.menaj;
                break;
            case HotelItemType.TRIPS:
                imageToDisplay = R.drawable.trip;
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
        int imageToDisplay = R.drawable.menaj;
        switch (entryType) {
            case TripsActivityItemType.PARAPANTA:
                imageToDisplay = R.drawable.parapanta;
                break;
            case TripsActivityItemType.SCUBADIVING:
                imageToDisplay = R.drawable.scubadiving;
                break;
            case TripsActivityItemType.SURF:
                imageToDisplay = R.drawable.surf;
                break;
            case TripsActivityItemType.BOAT:
                imageToDisplay = R.drawable.boat;
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
        int imageToDisplay = R.drawable.menaj;
        switch (entryType) {
            case TripsActivityItemType.PARAPANTA:
                imageToDisplay = R.drawable.parapanta;
                break;
            case TripsActivityItemType.SCUBADIVING:
                imageToDisplay = R.drawable.scubadiving;
                break;
            case TripsActivityItemType.SURF:
                imageToDisplay = R.drawable.surf;
                break;
            case TripsActivityItemType.BOAT:
                imageToDisplay = R.drawable.boat;
                break;
            default:
                break;
        }
        Glide.with(view.getContext())
                .load(imageToDisplay)
                .into(view);
    }
}


