package com.example.profileclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView checkBalance, referSubmitText, showTransaction, history, report, contact, help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        checkBalance = findViewById(R.id.checkBalance);
        referSubmitText= findViewById(R.id.referSubText);
        showTransaction= findViewById(R.id.showTransaction);
        history= findViewById(R.id.history);
        report= findViewById(R.id.report);
        contact= findViewById(R.id.contact);
        help= findViewById(R.id.help);

        checkBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckBankBalanceActivity.class);
                startActivity(intent);
            }
        });

      showTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTransactionactivity.class);
                startActivity(intent);
            }
        });

      history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaymentHistoryActivity.class);
                startActivity(intent);
            }
        });

      report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReportIssueActivity.class);
                startActivity(intent);
            }
        });

      contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactSupportActivity.class);
                startActivity(intent);
            }
        });

      help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpCenterActivity.class);
                startActivity(intent);
            }
        });

      referSubmitText.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent shareIntent= new Intent(Intent.ACTION_SEND);
              shareIntent.setType("text/plain");

              String shareBody= "Hy check Out The My Profile Clone App. Download it from here:\\https://play.google.com/store/apps/details?id=com.example.myapp";
              shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Try this App");
              shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

              startActivity(Intent.createChooser(shareIntent, "Share Via"));
          }
      });

    }
}