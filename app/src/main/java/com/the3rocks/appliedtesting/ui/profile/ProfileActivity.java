package com.the3rocks.appliedtesting.ui.profile;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.the3rocks.appliedtesting.R;
import com.the3rocks.appliedtesting.TestingApplication;
import com.the3rocks.appliedtesting.di.components.DaggerProfileComponent;
import com.the3rocks.appliedtesting.di.components.ProfileComponent;
import com.the3rocks.appliedtesting.di.modules.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfilePresenter.View {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.name)
    TextView nameTextView;

    @BindView(R.id.lastname)
    TextView lastnameTextView;

    @BindView(R.id.userImage)
    ImageView userImage;

    @Inject
    ProfilePresenter presenter;

    // Product Component for dagger
    private ProfileComponent advertComponent;

    private static boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        component().inject(this);
        presenter.setView(this);
        presenter.loadUser("any");
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUserCompleteName(String name, String lastname) {
        nameTextView.setText(name);
        lastnameTextView.setText(lastname);
    }

    @Override
    public void showUserImage(String url) {
        Picasso.with(getBaseContext())
                .load(url)
                .into(userImage);
    }

    @Override
    public void showUserNotFoundMessage() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getBaseContext());
        alert.setTitle(getString(R.string.error));
        alert.setMessage(getString(R.string.user_not_found_error));
        alert.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public void showConnectionErrorMessage() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getBaseContext());
        alert.setTitle(getString(R.string.error));
        alert.setMessage(getString(R.string.connection_error));
        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public boolean isReady() {
        return active;
    }

    public ProfileComponent component() {
        if (advertComponent == null) {
            advertComponent = DaggerProfileComponent.builder()
                    .applicationComponent(((TestingApplication) getApplication()).getApplicationComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return advertComponent;
    }
}
