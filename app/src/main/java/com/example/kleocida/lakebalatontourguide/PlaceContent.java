package com.example.kleocida.lakebalatontourguide;


import android.content.Context;

import com.example.kleocida.lakebalatontourguide.R;
import com.example.kleocida.lakebalatontourguide.Place;

import java.util.ArrayList;
import java.util.List;


public class PlaceContent {

    public List getHome(Context context) {
        List<Place> listHome = new ArrayList<>();
        listHome.add(new Place("0",
                context.getString(R.string.lake_balaton),
                R.drawable.goldenshore,
                context.getString(R.string.home0)));
        listHome.add(new Place("1",
                context.getString(R.string.major_towns),
                R.drawable.siofok,
                context.getString(R.string.home1)));
        listHome.add(new Place("2",
                context.getString(R.string.wine_region),
                R.drawable.balaton,
                context.getString(R.string.home2)));
        return listHome;
    }

    public List getDiscover(Context context) {
        List<Place> listDiscover = new ArrayList<>();
        listDiscover.add(new Place("0",
                context.getString(R.string.keszthely_town),
                R.drawable.kesztely,
                context.getString(R.string.disc0)));
        listDiscover.add(new Place("1",
                context.getString(R.string.heviz_town),
                R.drawable.lake_heviz,
                context.getString(R.string.disc1)));
        listDiscover.add(new Place("2",
                context.getString(R.string.tihany_town),
                R.drawable.tihany,
                context.getString(R.string.disc2)));
        listDiscover.add(new Place("3",
                context.getString(R.string.siofok_town),
                R.drawable.siofok_town,
                context.getString(R.string.disc3)));
        return listDiscover;
    }

    public List getMustvisit(Context context) {
        List<Place> listMustvisit = new ArrayList<>();
        listMustvisit.add(new Place("0",
                context.getString(R.string.tihany_abbey),
                R.drawable.tihanyi_apatsag,
                context.getString(R.string.mustvisit0)));
        listMustvisit.add(new Place("1",
                context.getString(R.string.tihany_echo),
                R.drawable.tihany_echo,
                context.getString(R.string.mustvisit1)));
        listMustvisit.add(new Place("2",
                context.getString(R.string.hermit_houses),
                R.drawable.hermit_houses,
                context.getString(R.string.mustvisit2)));
        listMustvisit.add(new Place("3",
                context.getString(R.string.festetics_palace),
                R.drawable.festetics,
                context.getString(R.string.mustvisit3)));
        return listMustvisit;
    }

    public List getEntertainment(Context context) {
        List<Place> listEntertainment = new ArrayList<>();
        listEntertainment.add(new Place("0",
                context.getString(R.string.lavender_fest),
                R.drawable.levendfest,
                context.getString(R.string.entertainment0)));
        listEntertainment.add(new Place("1",
                context.getString(R.string.art_cinema),
                R.drawable.artcinema_heviz,
                context.getString(R.string.entertainment1)));
        listEntertainment.add(new Place("2",
                context.getString(R.string.balaton_sound),
                R.drawable.balaton_sound,
                context.getString(R.string.entertainment2)));
        return listEntertainment;
    }

    public List getSports(Context context) {
        List<Place> listSports = new ArrayList<>();
        listSports.add(new Place("0",
                context.getString(R.string.fishing),
                R.drawable.fishing,
                context.getString(R.string.sport0)));
        listSports.add(new Place("1",
                context.getString(R.string.wintersport),
                R.drawable.balaton_ice_skating,
                context.getString(R.string.sport1)));
        listSports.add(new Place("2",
                context.getString(R.string.windsurfing),
                R.drawable.tihany_sailing,
                context.getString(R.string.sport2)));
        listSports.add(new Place("3",
                context.getString(R.string.cycling),
                R.drawable.cyle_balaton,
                context.getString(R.string.sport3)));
        return listSports;
    }

    public List getHotels(Context context) {
        List<Place> listHotels = new ArrayList<>();
        listHotels.add(new Place("0",
                context.getString(R.string.hotel_azur),
                R.drawable.azur,
                context.getString(R.string.hotel0)));
        listHotels.add(new Place("1",
                context.getString(R.string.hotel_fured),
                R.drawable.fured,
                context.getString(R.string.hotel1)));
        listHotels.add(new Place("2",
                context.getString(R.string.hotel_club),
                R.drawable.tihany_sailing,
                context.getString(R.string.hotel2)));
        listHotels.add(new Place("3",
                context.getString(R.string.hotel_lotus),
                R.drawable.lotus,
                context.getString(R.string.hotel3)));
        return listHotels;
    }

    public List getRestaurants(Context context) {
        List<Place> listRestaurants = new ArrayList<>();
        listRestaurants.add(new Place("0",
                context.getString(R.string.restaurant_vitorlás),
                R.drawable.vitorlas,
                context.getString(R.string.restaurant0)));
        listRestaurants.add(new Place("1",
                context.getString(R.string.restaurant_romai),
                R.drawable.romaipince,
                context.getString(R.string.restaurant1)));
        listRestaurants.add(new Place("2",
                context.getString(R.string.restaurant_kecske),
                R.drawable.kecskekorom,
                context.getString(R.string.restaurant2)));
        listRestaurants.add(new Place("3",
                context.getString(R.string.restaurant_roxy),
                R.drawable.roxy,
                context.getString(R.string.restaurant3)));
        return listRestaurants;
    }
}
