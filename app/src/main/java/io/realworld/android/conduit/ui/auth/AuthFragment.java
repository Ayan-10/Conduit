package io.realworld.android.conduit.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import io.realworld.android.conduit.R;
import io.realworld.android.conduit.ui.gallery.GalleryViewModel;

public class AuthFragment extends Fragment {

    private AuthFragment authFragment;
    private TabLayout authTabLayout;
    private AuthViewModel authViewModel;
    private NavController navController ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        authViewModel =
                new ViewModelProvider(this).get(AuthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_auth, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        authTabLayout = view.findViewById(R.id.authTabLayout);
        navController = Navigation.findNavController(getView().findViewById(R.id.authFragmentNavHost));
        TabItem logTab = view.findViewById(R.id.auth_tab_login);
        TabItem signTab = view.findViewById(R.id.auth_tab_signup);

        authTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    navController.navigate(R.id.gotoLoginFragment);
                } else if (position == 1) {
                    navController.navigate(R.id.gotoSignupFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
