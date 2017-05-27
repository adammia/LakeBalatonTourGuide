package com.example.kleocida.lakebalatontourguide;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final String TAG_HOME = "home";
    private static final String TAG_DISCOVER = "discover";
    private static final String TAG_MUSTVISIT = "mustvisit";
    private static final String TAG_ENTERTAINMENT = "entertainment";
    private static final String TAG_SPORTS = "sports";
    private static final String TAG_HOTELS = "hotels";
    private static final String TAG_RESTAURANTS = "restaurants";
    public static int navItemIndex = 0;
    public static String CURRENT_TAG = TAG_HOME;
    private static String[] activityTitles;
    private Handler mHandler;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private FloatingActionButton mFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        setupFabOnClick(mFab);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        setupNavigationWithOnClick(toolbar, mDrawer, mNavigationView);

        activityTitles = getResources().getStringArray(R.array.navDrawer);
        mHandler = new Handler();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {
        setToolbarTitle();
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            mDrawer.closeDrawers();
            toggleFab();
            return;
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.content_main, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        mHandler.post(mPendingRunnable);
        toggleFab();
        mDrawer.closeDrawers();
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt(PlaceholderFragment.ARG_ARGUMENT, navItemIndex);
        PlaceholderFragment fragment = PlaceholderFragment.newInstance(navItemIndex);
        fragment.setArguments(bundle);
        return fragment;
    }


    private void toggleFab() {
        mFab.hide();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void setupNavigationWithOnClick(Toolbar toolbar, DrawerLayout drawer, NavigationView navigation) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    private void setupFabOnClick(FloatingActionButton fab) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Share with your friends", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
            return;
        }
        if (navItemIndex != 0) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
            return;
        }
        super.onBackPressed();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                break;
            case R.id.nav_discover:
                navItemIndex = 1;
                CURRENT_TAG = TAG_DISCOVER;
                break;
            case R.id.nav_mustvisit:
                navItemIndex = 2;
                CURRENT_TAG = TAG_MUSTVISIT;
                break;
            case R.id.nav_enertainment:
                navItemIndex = 3;
                CURRENT_TAG = TAG_ENTERTAINMENT;
                break;
            case R.id.nav_sports:
                navItemIndex = 4;
                CURRENT_TAG = TAG_SPORTS;
                break;
            case R.id.nav_hotels:
                navItemIndex = 5;
                CURRENT_TAG = TAG_HOTELS;
                break;
            case R.id.nav_restaurants:
                navItemIndex = 6;
                CURRENT_TAG = TAG_RESTAURANTS;
                break;

            default:
                navItemIndex = 0;
        }

        if (item.isChecked()) {
            item.setChecked(false);
        } else {
            item.setChecked(true);
        }
        item.setChecked(true);
        loadHomeFragment();
        return true;
    }


    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_ARGUMENT = "navItemIndex";
        private int mArgument;
        private RecyclerView.Adapter mAdapter;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int position) {
            Bundle args = new Bundle();
            args.putInt(ARG_ARGUMENT, position);
            //
            PlaceholderFragment fragment = new PlaceholderFragment();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
            if (getArguments() != null) {
                mArgument = getArguments().getInt(ARG_ARGUMENT);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            //
            switchDummyAdapter(mArgument);
            setupRecyclerView(recyclerView, mAdapter);
            if (mAdapter != null) {
                mAdapter.notifyDataSetChanged();
            }
            //
            getActivity().setTitle(activityTitles[mArgument]);
            //
            return rootView;
        }

        private void switchDummyAdapter(int argument) {
            PlaceContent placeContent = new PlaceContent();
            switch (argument) {
                case 0:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getHome(getContext()));
                    break;
                case 1:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getDiscover(getContext()));
                    break;
                case 2:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getMustvisit(getContext()));
                    break;
                case 3:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getEntertainment(getContext()));
                    break;
                case 4:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getSports(getContext()));
                    break;
                case 5:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getHotels(getContext()));
                    break;
                case 6:
                    mAdapter = new PlaceAdapter(getContext(), placeContent.getRestaurants(getContext()));
                    break;

                default:
                    break;
            }
        }


        private void setupRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }
    }

}
