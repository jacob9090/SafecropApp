package com.jacob.fruitoftek.safecrop.comdev.ch;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jacob.fruitoftek.safecrop.R;

import org.json.JSONObject;

import java.io.File;

public class ChildSurveyedDetailsActivity extends AppCompatActivity {

    private WebView chSurveyDetails;
    private ChildModel childModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child_surveyed_details);

        // Set the status bar appearance
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_brown));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupActionBar();

        chSurveyDetails = findViewById(R.id.chSurveyDetailsWebView);
        chSurveyDetails.getSettings().setJavaScriptEnabled(true);

        // Retrieve the ChildModel from the Intent
        childModel = (ChildModel) getIntent().getSerializableExtra("child_model");

        if (childModel != null) {
            loadSurveyDetails();
        }
    }

    private void loadSurveyDetails() {
        // Load the HTML file from assets
        chSurveyDetails.loadUrl("file:///android_asset/child/chsurveydetails.html");

        // Inject survey details after the page loads
        chSurveyDetails.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSurveyDetails();
            }
        });
    }

//    private void injectSurveyDetails() {
//        String signaturePath = childModel.getSignature();
//
//        if (signaturePath != null && !signaturePath.isEmpty()) {
//            File signatureFile = new File(signaturePath);
//            Uri signatureUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", signatureFile);
//
//            String js = "javascript:document.getElementById('farmerId').textContent = '" + childModel.getFarmerId() + "';" +
//                    "document.getElementById('farmerDistrict').textContent = '" + childModel.getFarmerDistrict() + "';" +
//                    "document.getElementById('farmerVillage').textContent = '" + childModel.getFarmerVillage() + "';" +
//                    "document.getElementById('childquestion4).textContent = '" + childModel.getChildquestion4() + "';" +
//                    "document.getElementById('child1question1).textContent = '" + childModel.getChild1question1() + "';" +
//                    "document.getElementById('child1question2).textContent = '" + childModel.getChild1question2() + "';" +
//                    "document.getElementById('child1question3).textContent = '" + childModel.getChild1question3() + "';" +
//                    "document.getElementById('child1question4).textContent = '" + childModel.getChild1question4() + "';" +
//                    "document.getElementById('child1question5).textContent = '" + childModel.getChild1question5() + "';" +
//                    "document.getElementById('child1question6).textContent = '" + childModel.getChild1question6() + "';" +
//                    "document.getElementById('child1question7).textContent = '" + childModel.getChild1question7() + "';" +
//                    "document.getElementById('child1question8).textContent = '" + childModel.getChild1question8() + "';" +
//                    "document.getElementById('child1question9).textContent = '" + childModel.getChild1question9() + "';" +
//                    "document.getElementById('child1question10).textContent = '" + childModel.getChild1question10() + "';" +
//                    "document.getElementById('child1question11).textContent = '" + childModel.getChild1question11() + "';" +
//                    "document.getElementById('child1question12).textContent = '" + childModel.getChild1question12() + "';" +
//                    "document.getElementById('child1question13).textContent = '" + childModel.getChild1question13() + "';" +
//                    "document.getElementById('child1question14).textContent = '" + childModel.getChild1question14() + "';" +
//                    "document.getElementById('child1question15).textContent = '" + childModel.getChild1question15() + "';" +
//                    "document.getElementById('child1question16).textContent = '" + childModel.getChild1question16() + "';" +
//                    "document.getElementById('child1question17).textContent = '" + childModel.getChild1question17() + "';" +
//                    "document.getElementById('child1question18).textContent = '" + childModel.getChild1question18() + "';" +
//                    "document.getElementById('child1question19).textContent = '" + childModel.getChild1question19() + "';" +
//                    "document.getElementById('child2question1).textContent = '" + childModel.getChild2question1() + "';" +
//                    "document.getElementById('child2question2).textContent = '" + childModel.getChild2question2() + "';" +
//                    "document.getElementById('child2question3).textContent = '" + childModel.getChild2question3() + "';" +
//                    "document.getElementById('child2question4).textContent = '" + childModel.getChild2question4() + "';" +
//                    "document.getElementById('child2question5).textContent = '" + childModel.getChild2question5() + "';" +
//                    "document.getElementById('child2question6).textContent = '" + childModel.getChild2question6() + "';" +
//                    "document.getElementById('child2question7).textContent = '" + childModel.getChild2question7() + "';" +
//                    "document.getElementById('child2question8).textContent = '" + childModel.getChild2question8() + "';" +
//                    "document.getElementById('child2question9).textContent = '" + childModel.getChild2question9() + "';" +
//                    "document.getElementById('child2question10).textContent = '" + childModel.getChild2question10() + "';" +
//                    "document.getElementById('child2question11).textContent = '" + childModel.getChild2question11() + "';" +
//                    "document.getElementById('child2question12).textContent = '" + childModel.getChild2question12() + "';" +
//                    "document.getElementById('child2question13).textContent = '" + childModel.getChild2question13() + "';" +
//                    "document.getElementById('child2question14).textContent = '" + childModel.getChild2question14() + "';" +
//                    "document.getElementById('child2question15).textContent = '" + childModel.getChild2question15() + "';" +
//                    "document.getElementById('child2question16).textContent = '" + childModel.getChild2question16() + "';" +
//                    "document.getElementById('child2question17).textContent = '" + childModel.getChild2question17() + "';" +
//                    "document.getElementById('child2question18).textContent = '" + childModel.getChild2question18() + "';" +
//                    "document.getElementById('child2question19).textContent = '" + childModel.getChild2question19() + "';" +
//                    "document.getElementById('child3question1).textContent = '" + childModel.getChild3question1() + "';" +
//                    "document.getElementById('child3question2).textContent = '" + childModel.getChild3question2() + "';" +
//                    "document.getElementById('child3question3).textContent = '" + childModel.getChild3question3() + "';" +
//                    "document.getElementById('child3question4).textContent = '" + childModel.getChild3question4() + "';" +
//                    "document.getElementById('child3question5).textContent = '" + childModel.getChild3question5() + "';" +
//                    "document.getElementById('child3question6).textContent = '" + childModel.getChild3question6() + "';" +
//                    "document.getElementById('child3question7).textContent = '" + childModel.getChild3question7() + "';" +
//                    "document.getElementById('child3question8).textContent = '" + childModel.getChild3question8() + "';" +
//                    "document.getElementById('child3question9).textContent = '" + childModel.getChild3question9() + "';" +
//                    "document.getElementById('child3question10).textContent = '" + childModel.getChild3question10() + "';" +
//                    "document.getElementById('child3question11).textContent = '" + childModel.getChild3question11() + "';" +
//                    "document.getElementById('child3question12).textContent = '" + childModel.getChild3question12() + "';" +
//                    "document.getElementById('child3question13).textContent = '" + childModel.getChild3question13() + "';" +
//                    "document.getElementById('child3question14).textContent = '" + childModel.getChild3question14() + "';" +
//                    "document.getElementById('child3question15).textContent = '" + childModel.getChild3question15() + "';" +
//                    "document.getElementById('child3question16).textContent = '" + childModel.getChild3question16() + "';" +
//                    "document.getElementById('child3question17).textContent = '" + childModel.getChild3question17() + "';" +
//                    "document.getElementById('child3question18).textContent = '" + childModel.getChild3question18() + "';" +
//                    "document.getElementById('child3question19).textContent = '" + childModel.getChild3question19() + "';" +
//                    "document.getElementById('child4question1).textContent = '" + childModel.getChild4question1() + "';" +
//                    "document.getElementById('child4question2).textContent = '" + childModel.getChild4question2() + "';" +
//                    "document.getElementById('child4question3).textContent = '" + childModel.getChild4question3() + "';" +
//                    "document.getElementById('child4question4).textContent = '" + childModel.getChild4question4() + "';" +
//                    "document.getElementById('child4question5).textContent = '" + childModel.getChild4question5() + "';" +
//                    "document.getElementById('child4question6).textContent = '" + childModel.getChild4question6() + "';" +
//                    "document.getElementById('child4question7).textContent = '" + childModel.getChild4question7() + "';" +
//                    "document.getElementById('child4question8).textContent = '" + childModel.getChild4question8() + "';" +
//                    "document.getElementById('child4question9).textContent = '" + childModel.getChild4question9() + "';" +
//                    "document.getElementById('child4question10).textContent = '" + childModel.getChild4question10() + "';" +
//                    "document.getElementById('child4question11).textContent = '" + childModel.getChild4question11() + "';" +
//                    "document.getElementById('child4question12).textContent = '" + childModel.getChild4question12() + "';" +
//                    "document.getElementById('child4question13).textContent = '" + childModel.getChild4question13() + "';" +
//                    "document.getElementById('child4question14).textContent = '" + childModel.getChild4question14() + "';" +
//                    "document.getElementById('child4question15).textContent = '" + childModel.getChild4question15() + "';" +
//                    "document.getElementById('child4question16).textContent = '" + childModel.getChild4question16() + "';" +
//                    "document.getElementById('child4question17).textContent = '" + childModel.getChild4question17() + "';" +
//                    "document.getElementById('child4question18).textContent = '" + childModel.getChild4question18() + "';" +
//                    "document.getElementById('child4question19).textContent = '" + childModel.getChild4question19() + "';" +
//                    "document.getElementById('child5question1).textContent = '" + childModel.getChild5question1() + "';" +
//                    "document.getElementById('child5question2).textContent = '" + childModel.getChild5question2() + "';" +
//                    "document.getElementById('child5question3).textContent = '" + childModel.getChild5question3() + "';" +
//                    "document.getElementById('child5question4).textContent = '" + childModel.getChild5question4() + "';" +
//                    "document.getElementById('child5question5).textContent = '" + childModel.getChild5question5() + "';" +
//                    "document.getElementById('child5question6).textContent = '" + childModel.getChild5question6() + "';" +
//                    "document.getElementById('child5question7).textContent = '" + childModel.getChild5question7() + "';" +
//                    "document.getElementById('child5question8).textContent = '" + childModel.getChild5question8() + "';" +
//                    "document.getElementById('child5question9).textContent = '" + childModel.getChild5question9() + "';" +
//                    "document.getElementById('child5question10).textContent = '" + childModel.getChild5question10() + "';" +
//                    "document.getElementById('child5question11).textContent = '" + childModel.getChild5question11() + "';" +
//                    "document.getElementById('child5question12).textContent = '" + childModel.getChild5question12() + "';" +
//                    "document.getElementById('child5question13).textContent = '" + childModel.getChild5question13() + "';" +
//                    "document.getElementById('child5question14).textContent = '" + childModel.getChild5question14() + "';" +
//                    "document.getElementById('child5question15).textContent = '" + childModel.getChild5question15() + "';" +
//                    "document.getElementById('child5question16).textContent = '" + childModel.getChild5question16() + "';" +
//                    "document.getElementById('child5question17).textContent = '" + childModel.getChild5question17() + "';" +
//                    "document.getElementById('child5question18).textContent = '" + childModel.getChild5question18() + "';" +
//                    "document.getElementById('child5question19).textContent = '" + childModel.getChild5question19() + "';" +
//                    "document.getElementById('child6question1).textContent = '" + childModel.getChild6question1() + "';" +
//                    "document.getElementById('child6question2).textContent = '" + childModel.getChild6question2() + "';" +
//                    "document.getElementById('child6question3).textContent = '" + childModel.getChild6question3() + "';" +
//                    "document.getElementById('child6question4).textContent = '" + childModel.getChild6question4() + "';" +
//                    "document.getElementById('child6question5).textContent = '" + childModel.getChild6question5() + "';" +
//                    "document.getElementById('child6question6).textContent = '" + childModel.getChild6question6() + "';" +
//                    "document.getElementById('child6question7).textContent = '" + childModel.getChild6question7() + "';" +
//                    "document.getElementById('child6question8).textContent = '" + childModel.getChild6question8() + "';" +
//                    "document.getElementById('child6question9).textContent = '" + childModel.getChild6question9() + "';" +
//                    "document.getElementById('child6question10).textContent = '" + childModel.getChild6question10() + "';" +
//                    "document.getElementById('child6question11).textContent = '" + childModel.getChild6question11() + "';" +
//                    "document.getElementById('child6question12).textContent = '" + childModel.getChild6question12() + "';" +
//                    "document.getElementById('child6question13).textContent = '" + childModel.getChild6question13() + "';" +
//                    "document.getElementById('child6question14).textContent = '" + childModel.getChild6question14() + "';" +
//                    "document.getElementById('child6question15).textContent = '" + childModel.getChild6question15() + "';" +
//                    "document.getElementById('child6question16).textContent = '" + childModel.getChild6question16() + "';" +
//                    "document.getElementById('child6question17).textContent = '" + childModel.getChild6question17() + "';" +
//                    "document.getElementById('child6question18).textContent = '" + childModel.getChild6question18() + "';" +
//                    "document.getElementById('child6question19).textContent = '" + childModel.getChild6question19() + "';" +
//                    "document.getElementById('child7question1).textContent = '" + childModel.getChild7question1() + "';" +
//                    "document.getElementById('child7question2).textContent = '" + childModel.getChild7question2() + "';" +
//                    "document.getElementById('child7question3).textContent = '" + childModel.getChild7question3() + "';" +
//                    "document.getElementById('child7question4).textContent = '" + childModel.getChild7question4() + "';" +
//                    "document.getElementById('child7question5).textContent = '" + childModel.getChild7question5() + "';" +
//                    "document.getElementById('child7question6).textContent = '" + childModel.getChild7question6() + "';" +
//                    "document.getElementById('child7question7).textContent = '" + childModel.getChild7question7() + "';" +
//                    "document.getElementById('child7question8).textContent = '" + childModel.getChild7question8() + "';" +
//                    "document.getElementById('child7question9).textContent = '" + childModel.getChild7question9() + "';" +
//                    "document.getElementById('child7question10).textContent = '" + childModel.getChild7question10() + "';" +
//                    "document.getElementById('child7question11).textContent = '" + childModel.getChild7question11() + "';" +
//                    "document.getElementById('child7question12).textContent = '" + childModel.getChild7question12() + "';" +
//                    "document.getElementById('child7question13).textContent = '" + childModel.getChild7question13() + "';" +
//                    "document.getElementById('child7question14).textContent = '" + childModel.getChild7question14() + "';" +
//                    "document.getElementById('child7question15).textContent = '" + childModel.getChild7question15() + "';" +
//                    "document.getElementById('child7question16).textContent = '" + childModel.getChild7question16() + "';" +
//                    "document.getElementById('child7question17).textContent = '" + childModel.getChild7question17() + "';" +
//                    "document.getElementById('child7question18).textContent = '" + childModel.getChild7question18() + "';" +
//                    "document.getElementById('child7question19).textContent = '" + childModel.getChild7question19() + "';" +
//                    "document.getElementById('child8question1).textContent = '" + childModel.getChild8question1() + "';" +
//                    "document.getElementById('child8question2).textContent = '" + childModel.getChild8question2() + "';" +
//                    "document.getElementById('child8question3).textContent = '" + childModel.getChild8question3() + "';" +
//                    "document.getElementById('child8question4).textContent = '" + childModel.getChild8question4() + "';" +
//                    "document.getElementById('child8question5).textContent = '" + childModel.getChild8question5() + "';" +
//                    "document.getElementById('child8question6).textContent = '" + childModel.getChild8question6() + "';" +
//                    "document.getElementById('child8question7).textContent = '" + childModel.getChild8question7() + "';" +
//                    "document.getElementById('child8question8).textContent = '" + childModel.getChild8question8() + "';" +
//                    "document.getElementById('child8question9).textContent = '" + childModel.getChild8question9() + "';" +
//                    "document.getElementById('child8question10).textContent = '" + childModel.getChild8question10() + "';" +
//                    "document.getElementById('child8question11).textContent = '" + childModel.getChild8question11() + "';" +
//                    "document.getElementById('child8question12).textContent = '" + childModel.getChild8question12() + "';" +
//                    "document.getElementById('child8question13).textContent = '" + childModel.getChild8question13() + "';" +
//                    "document.getElementById('child8question14).textContent = '" + childModel.getChild8question14() + "';" +
//                    "document.getElementById('child8question15).textContent = '" + childModel.getChild8question15() + "';" +
//                    "document.getElementById('child8question16).textContent = '" + childModel.getChild8question16() + "';" +
//                    "document.getElementById('child8question17).textContent = '" + childModel.getChild8question17() + "';" +
//                    "document.getElementById('child8question18).textContent = '" + childModel.getChild8question18() + "';" +
//                    "document.getElementById('child8question19).textContent = '" + childModel.getChild8question19() + "';" +
//                    "document.getElementById('child9question1).textContent = '" + childModel.getChild9question1() + "';" +
//                    "document.getElementById('child9question2).textContent = '" + childModel.getChild9question2() + "';" +
//                    "document.getElementById('child9question3).textContent = '" + childModel.getChild9question3() + "';" +
//                    "document.getElementById('child9question4).textContent = '" + childModel.getChild9question4() + "';" +
//                    "document.getElementById('child9question5).textContent = '" + childModel.getChild9question5() + "';" +
//                    "document.getElementById('child9question6).textContent = '" + childModel.getChild9question6() + "';" +
//                    "document.getElementById('child9question7).textContent = '" + childModel.getChild9question7() + "';" +
//                    "document.getElementById('child9question8).textContent = '" + childModel.getChild9question8() + "';" +
//                    "document.getElementById('child9question9).textContent = '" + childModel.getChild9question9() + "';" +
//                    "document.getElementById('child9question10).textContent = '" + childModel.getChild9question10() + "';" +
//                    "document.getElementById('child9question11).textContent = '" + childModel.getChild9question11() + "';" +
//                    "document.getElementById('child9question12).textContent = '" + childModel.getChild9question12() + "';" +
//                    "document.getElementById('child9question13).textContent = '" + childModel.getChild9question13() + "';" +
//                    "document.getElementById('child9question14).textContent = '" + childModel.getChild9question14() + "';" +
//                    "document.getElementById('child9question15).textContent = '" + childModel.getChild9question15() + "';" +
//                    "document.getElementById('child9question16).textContent = '" + childModel.getChild9question16() + "';" +
//                    "document.getElementById('child9question17).textContent = '" + childModel.getChild9question17() + "';" +
//                    "document.getElementById('child9question18).textContent = '" + childModel.getChild9question18() + "';" +
//                    "document.getElementById('child9question19).textContent = '" + childModel.getChild9question19() + "';" +
//                    "document.getElementById('child10question1).textContent = '" + childModel.getChild10question1() + "';" +
//                    "document.getElementById('child10question2).textContent = '" + childModel.getChild10question2() + "';" +
//                    "document.getElementById('child10question3).textContent = '" + childModel.getChild10question3() + "';" +
//                    "document.getElementById('child10question4).textContent = '" + childModel.getChild10question4() + "';" +
//                    "document.getElementById('child10question5).textContent = '" + childModel.getChild10question5() + "';" +
//                    "document.getElementById('child10question6).textContent = '" + childModel.getChild10question6() + "';" +
//                    "document.getElementById('child10question7).textContent = '" + childModel.getChild10question7() + "';" +
//                    "document.getElementById('child10question8).textContent = '" + childModel.getChild10question8() + "';" +
//                    "document.getElementById('child10question9).textContent = '" + childModel.getChild10question9() + "';" +
//                    "document.getElementById('child10question10).textContent = '" + childModel.getChild10question10() + "';" +
//                    "document.getElementById('child10question11).textContent = '" + childModel.getChild10question11() + "';" +
//                    "document.getElementById('child10question12).textContent = '" + childModel.getChild10question12() + "';" +
//                    "document.getElementById('child10question13).textContent = '" + childModel.getChild10question13() + "';" +
//                    "document.getElementById('child10question14).textContent = '" + childModel.getChild10question14() + "';" +
//                    "document.getElementById('child10question16).textContent = '" + childModel.getChild10question16() + "';" +
//                    "document.getElementById('child10question17).textContent = '" + childModel.getChild10question17() + "';" +
//                    "document.getElementById('child10question18).textContent = '" + childModel.getChild10question18() + "';" +
//                    "document.getElementById('child10question19).textContent = '" + childModel.getChild10question19() + "';" +
//                    "document.getElementById('childquestion5).textContent = '" + childModel.getChildquestion5() + "';" +
//                    "document.getElementById('childLocation').textContent = '" + childModel.getChildLocation() + "';" +
//                    "document.getElementById('onCreate').textContent = '" + childModel.getOnCreate() + "';" +
//                    "document.getElementById('signature').src = '" + signatureUri.toString() + "';";
//            chSurveyDetails.evaluateJavascript(js, null);
//        } else {
//            String js = "javascript:document.getElementById('farmerId').textContent = '" + childModel.getFarmerId() + "';" +
//                    "document.getElementById('farmerDistrict').textContent = '" + childModel.getFarmerDistrict() + "';" +
//                    "document.getElementById('farmerVillage').textContent = '" + childModel.getFarmerVillage() + "';" +
//                    "document.getElementById('childquestion4).textContent = '" + childModel.getChildquestion4() + "';" +
//                    "document.getElementById('child1question1).textContent = '" + childModel.getChild1question1() + "';" +
//                    "document.getElementById('child1question2).textContent = '" + childModel.getChild1question2() + "';" +
//                    "document.getElementById('child1question3).textContent = '" + childModel.getChild1question3() + "';" +
//                    "document.getElementById('child1question4).textContent = '" + childModel.getChild1question4() + "';" +
//                    "document.getElementById('child1question5).textContent = '" + childModel.getChild1question5() + "';" +
//                    "document.getElementById('child1question6).textContent = '" + childModel.getChild1question6() + "';" +
//                    "document.getElementById('child1question7).textContent = '" + childModel.getChild1question7() + "';" +
//                    "document.getElementById('child1question8).textContent = '" + childModel.getChild1question8() + "';" +
//                    "document.getElementById('child1question9).textContent = '" + childModel.getChild1question9() + "';" +
//                    "document.getElementById('child1question10).textContent = '" + childModel.getChild1question10() + "';" +
//                    "document.getElementById('child1question11).textContent = '" + childModel.getChild1question11() + "';" +
//                    "document.getElementById('child1question12).textContent = '" + childModel.getChild1question12() + "';" +
//                    "document.getElementById('child1question13).textContent = '" + childModel.getChild1question13() + "';" +
//                    "document.getElementById('child1question14).textContent = '" + childModel.getChild1question14() + "';" +
//                    "document.getElementById('child1question15).textContent = '" + childModel.getChild1question15() + "';" +
//                    "document.getElementById('child1question16).textContent = '" + childModel.getChild1question16() + "';" +
//                    "document.getElementById('child1question17).textContent = '" + childModel.getChild1question17() + "';" +
//                    "document.getElementById('child1question18).textContent = '" + childModel.getChild1question18() + "';" +
//                    "document.getElementById('child1question19).textContent = '" + childModel.getChild1question19() + "';" +
//                    "document.getElementById('child2question1).textContent = '" + childModel.getChild2question1() + "';" +
//                    "document.getElementById('child2question2).textContent = '" + childModel.getChild2question2() + "';" +
//                    "document.getElementById('child2question3).textContent = '" + childModel.getChild2question3() + "';" +
//                    "document.getElementById('child2question4).textContent = '" + childModel.getChild2question4() + "';" +
//                    "document.getElementById('child2question5).textContent = '" + childModel.getChild2question5() + "';" +
//                    "document.getElementById('child2question6).textContent = '" + childModel.getChild2question6() + "';" +
//                    "document.getElementById('child2question7).textContent = '" + childModel.getChild2question7() + "';" +
//                    "document.getElementById('child2question8).textContent = '" + childModel.getChild2question8() + "';" +
//                    "document.getElementById('child2question9).textContent = '" + childModel.getChild2question9() + "';" +
//                    "document.getElementById('child2question10).textContent = '" + childModel.getChild2question10() + "';" +
//                    "document.getElementById('child2question11).textContent = '" + childModel.getChild2question11() + "';" +
//                    "document.getElementById('child2question12).textContent = '" + childModel.getChild2question12() + "';" +
//                    "document.getElementById('child2question13).textContent = '" + childModel.getChild2question13() + "';" +
//                    "document.getElementById('child2question14).textContent = '" + childModel.getChild2question14() + "';" +
//                    "document.getElementById('child2question15).textContent = '" + childModel.getChild2question15() + "';" +
//                    "document.getElementById('child2question16).textContent = '" + childModel.getChild2question16() + "';" +
//                    "document.getElementById('child2question17).textContent = '" + childModel.getChild2question17() + "';" +
//                    "document.getElementById('child2question18).textContent = '" + childModel.getChild2question18() + "';" +
//                    "document.getElementById('child2question19).textContent = '" + childModel.getChild2question19() + "';" +
//                    "document.getElementById('child3question1).textContent = '" + childModel.getChild3question1() + "';" +
//                    "document.getElementById('child3question2).textContent = '" + childModel.getChild3question2() + "';" +
//                    "document.getElementById('child3question3).textContent = '" + childModel.getChild3question3() + "';" +
//                    "document.getElementById('child3question4).textContent = '" + childModel.getChild3question4() + "';" +
//                    "document.getElementById('child3question5).textContent = '" + childModel.getChild3question5() + "';" +
//                    "document.getElementById('child3question6).textContent = '" + childModel.getChild3question6() + "';" +
//                    "document.getElementById('child3question7).textContent = '" + childModel.getChild3question7() + "';" +
//                    "document.getElementById('child3question8).textContent = '" + childModel.getChild3question8() + "';" +
//                    "document.getElementById('child3question9).textContent = '" + childModel.getChild3question9() + "';" +
//                    "document.getElementById('child3question10).textContent = '" + childModel.getChild3question10() + "';" +
//                    "document.getElementById('child3question11).textContent = '" + childModel.getChild3question11() + "';" +
//                    "document.getElementById('child3question12).textContent = '" + childModel.getChild3question12() + "';" +
//                    "document.getElementById('child3question13).textContent = '" + childModel.getChild3question13() + "';" +
//                    "document.getElementById('child3question14).textContent = '" + childModel.getChild3question14() + "';" +
//                    "document.getElementById('child3question15).textContent = '" + childModel.getChild3question15() + "';" +
//                    "document.getElementById('child3question16).textContent = '" + childModel.getChild3question16() + "';" +
//                    "document.getElementById('child3question17).textContent = '" + childModel.getChild3question17() + "';" +
//                    "document.getElementById('child3question18).textContent = '" + childModel.getChild3question18() + "';" +
//                    "document.getElementById('child3question19).textContent = '" + childModel.getChild3question19() + "';" +
//                    "document.getElementById('child4question1).textContent = '" + childModel.getChild4question1() + "';" +
//                    "document.getElementById('child4question2).textContent = '" + childModel.getChild4question2() + "';" +
//                    "document.getElementById('child4question3).textContent = '" + childModel.getChild4question3() + "';" +
//                    "document.getElementById('child4question4).textContent = '" + childModel.getChild4question4() + "';" +
//                    "document.getElementById('child4question5).textContent = '" + childModel.getChild4question5() + "';" +
//                    "document.getElementById('child4question6).textContent = '" + childModel.getChild4question6() + "';" +
//                    "document.getElementById('child4question7).textContent = '" + childModel.getChild4question7() + "';" +
//                    "document.getElementById('child4question8).textContent = '" + childModel.getChild4question8() + "';" +
//                    "document.getElementById('child4question9).textContent = '" + childModel.getChild4question9() + "';" +
//                    "document.getElementById('child4question10).textContent = '" + childModel.getChild4question10() + "';" +
//                    "document.getElementById('child4question11).textContent = '" + childModel.getChild4question11() + "';" +
//                    "document.getElementById('child4question12).textContent = '" + childModel.getChild4question12() + "';" +
//                    "document.getElementById('child4question13).textContent = '" + childModel.getChild4question13() + "';" +
//                    "document.getElementById('child4question14).textContent = '" + childModel.getChild4question14() + "';" +
//                    "document.getElementById('child4question15).textContent = '" + childModel.getChild4question15() + "';" +
//                    "document.getElementById('child4question16).textContent = '" + childModel.getChild4question16() + "';" +
//                    "document.getElementById('child4question17).textContent = '" + childModel.getChild4question17() + "';" +
//                    "document.getElementById('child4question18).textContent = '" + childModel.getChild4question18() + "';" +
//                    "document.getElementById('child4question19).textContent = '" + childModel.getChild4question19() + "';" +
//                    "document.getElementById('child5question1).textContent = '" + childModel.getChild5question1() + "';" +
//                    "document.getElementById('child5question2).textContent = '" + childModel.getChild5question2() + "';" +
//                    "document.getElementById('child5question3).textContent = '" + childModel.getChild5question3() + "';" +
//                    "document.getElementById('child5question4).textContent = '" + childModel.getChild5question4() + "';" +
//                    "document.getElementById('child5question5).textContent = '" + childModel.getChild5question5() + "';" +
//                    "document.getElementById('child5question6).textContent = '" + childModel.getChild5question6() + "';" +
//                    "document.getElementById('child5question7).textContent = '" + childModel.getChild5question7() + "';" +
//                    "document.getElementById('child5question8).textContent = '" + childModel.getChild5question8() + "';" +
//                    "document.getElementById('child5question9).textContent = '" + childModel.getChild5question9() + "';" +
//                    "document.getElementById('child5question10).textContent = '" + childModel.getChild5question10() + "';" +
//                    "document.getElementById('child5question11).textContent = '" + childModel.getChild5question11() + "';" +
//                    "document.getElementById('child5question12).textContent = '" + childModel.getChild5question12() + "';" +
//                    "document.getElementById('child5question13).textContent = '" + childModel.getChild5question13() + "';" +
//                    "document.getElementById('child5question14).textContent = '" + childModel.getChild5question14() + "';" +
//                    "document.getElementById('child5question15).textContent = '" + childModel.getChild5question15() + "';" +
//                    "document.getElementById('child5question16).textContent = '" + childModel.getChild5question16() + "';" +
//                    "document.getElementById('child5question17).textContent = '" + childModel.getChild5question17() + "';" +
//                    "document.getElementById('child5question18).textContent = '" + childModel.getChild5question18() + "';" +
//                    "document.getElementById('child5question19).textContent = '" + childModel.getChild5question19() + "';" +
//                    "document.getElementById('child6question1).textContent = '" + childModel.getChild6question1() + "';" +
//                    "document.getElementById('child6question2).textContent = '" + childModel.getChild6question2() + "';" +
//                    "document.getElementById('child6question3).textContent = '" + childModel.getChild6question3() + "';" +
//                    "document.getElementById('child6question4).textContent = '" + childModel.getChild6question4() + "';" +
//                    "document.getElementById('child6question5).textContent = '" + childModel.getChild6question5() + "';" +
//                    "document.getElementById('child6question6).textContent = '" + childModel.getChild6question6() + "';" +
//                    "document.getElementById('child6question7).textContent = '" + childModel.getChild6question7() + "';" +
//                    "document.getElementById('child6question8).textContent = '" + childModel.getChild6question8() + "';" +
//                    "document.getElementById('child6question9).textContent = '" + childModel.getChild6question9() + "';" +
//                    "document.getElementById('child6question10).textContent = '" + childModel.getChild6question10() + "';" +
//                    "document.getElementById('child6question11).textContent = '" + childModel.getChild6question11() + "';" +
//                    "document.getElementById('child6question12).textContent = '" + childModel.getChild6question12() + "';" +
//                    "document.getElementById('child6question13).textContent = '" + childModel.getChild6question13() + "';" +
//                    "document.getElementById('child6question14).textContent = '" + childModel.getChild6question14() + "';" +
//                    "document.getElementById('child6question15).textContent = '" + childModel.getChild6question15() + "';" +
//                    "document.getElementById('child6question16).textContent = '" + childModel.getChild6question16() + "';" +
//                    "document.getElementById('child6question17).textContent = '" + childModel.getChild6question17() + "';" +
//                    "document.getElementById('child6question18).textContent = '" + childModel.getChild6question18() + "';" +
//                    "document.getElementById('child6question19).textContent = '" + childModel.getChild6question19() + "';" +
//                    "document.getElementById('child7question1).textContent = '" + childModel.getChild7question1() + "';" +
//                    "document.getElementById('child7question2).textContent = '" + childModel.getChild7question2() + "';" +
//                    "document.getElementById('child7question3).textContent = '" + childModel.getChild7question3() + "';" +
//                    "document.getElementById('child7question4).textContent = '" + childModel.getChild7question4() + "';" +
//                    "document.getElementById('child7question5).textContent = '" + childModel.getChild7question5() + "';" +
//                    "document.getElementById('child7question6).textContent = '" + childModel.getChild7question6() + "';" +
//                    "document.getElementById('child7question7).textContent = '" + childModel.getChild7question7() + "';" +
//                    "document.getElementById('child7question8).textContent = '" + childModel.getChild7question8() + "';" +
//                    "document.getElementById('child7question9).textContent = '" + childModel.getChild7question9() + "';" +
//                    "document.getElementById('child7question10).textContent = '" + childModel.getChild7question10() + "';" +
//                    "document.getElementById('child7question11).textContent = '" + childModel.getChild7question11() + "';" +
//                    "document.getElementById('child7question12).textContent = '" + childModel.getChild7question12() + "';" +
//                    "document.getElementById('child7question13).textContent = '" + childModel.getChild7question13() + "';" +
//                    "document.getElementById('child7question14).textContent = '" + childModel.getChild7question14() + "';" +
//                    "document.getElementById('child7question15).textContent = '" + childModel.getChild7question15() + "';" +
//                    "document.getElementById('child7question16).textContent = '" + childModel.getChild7question16() + "';" +
//                    "document.getElementById('child7question17).textContent = '" + childModel.getChild7question17() + "';" +
//                    "document.getElementById('child7question18).textContent = '" + childModel.getChild7question18() + "';" +
//                    "document.getElementById('child7question19).textContent = '" + childModel.getChild7question19() + "';" +
//                    "document.getElementById('child8question1).textContent = '" + childModel.getChild8question1() + "';" +
//                    "document.getElementById('child8question2).textContent = '" + childModel.getChild8question2() + "';" +
//                    "document.getElementById('child8question3).textContent = '" + childModel.getChild8question3() + "';" +
//                    "document.getElementById('child8question4).textContent = '" + childModel.getChild8question4() + "';" +
//                    "document.getElementById('child8question5).textContent = '" + childModel.getChild8question5() + "';" +
//                    "document.getElementById('child8question6).textContent = '" + childModel.getChild8question6() + "';" +
//                    "document.getElementById('child8question7).textContent = '" + childModel.getChild8question7() + "';" +
//                    "document.getElementById('child8question8).textContent = '" + childModel.getChild8question8() + "';" +
//                    "document.getElementById('child8question9).textContent = '" + childModel.getChild8question9() + "';" +
//                    "document.getElementById('child8question10).textContent = '" + childModel.getChild8question10() + "';" +
//                    "document.getElementById('child8question11).textContent = '" + childModel.getChild8question11() + "';" +
//                    "document.getElementById('child8question12).textContent = '" + childModel.getChild8question12() + "';" +
//                    "document.getElementById('child8question13).textContent = '" + childModel.getChild8question13() + "';" +
//                    "document.getElementById('child8question14).textContent = '" + childModel.getChild8question14() + "';" +
//                    "document.getElementById('child8question15).textContent = '" + childModel.getChild8question15() + "';" +
//                    "document.getElementById('child8question16).textContent = '" + childModel.getChild8question16() + "';" +
//                    "document.getElementById('child8question17).textContent = '" + childModel.getChild8question17() + "';" +
//                    "document.getElementById('child8question18).textContent = '" + childModel.getChild8question18() + "';" +
//                    "document.getElementById('child8question19).textContent = '" + childModel.getChild8question19() + "';" +
//                    "document.getElementById('child9question1).textContent = '" + childModel.getChild9question1() + "';" +
//                    "document.getElementById('child9question2).textContent = '" + childModel.getChild9question2() + "';" +
//                    "document.getElementById('child9question3).textContent = '" + childModel.getChild9question3() + "';" +
//                    "document.getElementById('child9question4).textContent = '" + childModel.getChild9question4() + "';" +
//                    "document.getElementById('child9question5).textContent = '" + childModel.getChild9question5() + "';" +
//                    "document.getElementById('child9question6).textContent = '" + childModel.getChild9question6() + "';" +
//                    "document.getElementById('child9question7).textContent = '" + childModel.getChild9question7() + "';" +
//                    "document.getElementById('child9question8).textContent = '" + childModel.getChild9question8() + "';" +
//                    "document.getElementById('child9question9).textContent = '" + childModel.getChild9question9() + "';" +
//                    "document.getElementById('child9question10).textContent = '" + childModel.getChild9question10() + "';" +
//                    "document.getElementById('child9question11).textContent = '" + childModel.getChild9question11() + "';" +
//                    "document.getElementById('child9question12).textContent = '" + childModel.getChild9question12() + "';" +
//                    "document.getElementById('child9question13).textContent = '" + childModel.getChild9question13() + "';" +
//                    "document.getElementById('child9question14).textContent = '" + childModel.getChild9question14() + "';" +
//                    "document.getElementById('child9question15).textContent = '" + childModel.getChild9question15() + "';" +
//                    "document.getElementById('child9question16).textContent = '" + childModel.getChild9question16() + "';" +
//                    "document.getElementById('child9question17).textContent = '" + childModel.getChild9question17() + "';" +
//                    "document.getElementById('child9question18).textContent = '" + childModel.getChild9question18() + "';" +
//                    "document.getElementById('child9question19).textContent = '" + childModel.getChild9question19() + "';" +
//                    "document.getElementById('child10question1).textContent = '" + childModel.getChild10question1() + "';" +
//                    "document.getElementById('child10question2).textContent = '" + childModel.getChild10question2() + "';" +
//                    "document.getElementById('child10question3).textContent = '" + childModel.getChild10question3() + "';" +
//                    "document.getElementById('child10question4).textContent = '" + childModel.getChild10question4() + "';" +
//                    "document.getElementById('child10question5).textContent = '" + childModel.getChild10question5() + "';" +
//                    "document.getElementById('child10question6).textContent = '" + childModel.getChild10question6() + "';" +
//                    "document.getElementById('child10question7).textContent = '" + childModel.getChild10question7() + "';" +
//                    "document.getElementById('child10question8).textContent = '" + childModel.getChild10question8() + "';" +
//                    "document.getElementById('child10question9).textContent = '" + childModel.getChild10question9() + "';" +
//                    "document.getElementById('child10question10).textContent = '" + childModel.getChild10question10() + "';" +
//                    "document.getElementById('child10question11).textContent = '" + childModel.getChild10question11() + "';" +
//                    "document.getElementById('child10question12).textContent = '" + childModel.getChild10question12() + "';" +
//                    "document.getElementById('child10question13).textContent = '" + childModel.getChild10question13() + "';" +
//                    "document.getElementById('child10question14).textContent = '" + childModel.getChild10question14() + "';" +
//                    "document.getElementById('child10question16).textContent = '" + childModel.getChild10question16() + "';" +
//                    "document.getElementById('child10question17).textContent = '" + childModel.getChild10question17() + "';" +
//                    "document.getElementById('child10question18).textContent = '" + childModel.getChild10question18() + "';" +
//                    "document.getElementById('child10question19).textContent = '" + childModel.getChild10question19() + "';" +
//                    "document.getElementById('childquestion5).textContent = '" + childModel.getChildquestion5() + "';" +
//                    "document.getElementById('childLocation').textContent = '" + childModel.getChildLocation() + "';" +
//                    "document.getElementById('onCreate').textContent = '" + childModel.getOnCreate() + "';" +
//                    "document.getElementById('signature').alt = 'Signature not available';";
//            chSurveyDetails.evaluateJavascript(js, null);
//        }
//    }




    private void injectSurveyDetails() {
        String signaturePath = childModel.getSignature();

        String js = "javascript:" +
                "function setValueOrDefault(id, value) {" +
                "    document.getElementById(id).textContent = (value && value.trim()) ? value : 'Null';" +
                "}" +
                "setValueOrDefault('farmerId', " + JSONObject.quote(childModel.getFarmerId()) + ");" +
                "setValueOrDefault('farmerDistrict', " + JSONObject.quote(childModel.getFarmerDistrict()) + ");" +
                "setValueOrDefault('farmerVillage', " + JSONObject.quote(childModel.getFarmerVillage()) + ");" +
                "setValueOrDefault('childquestion4', " + JSONObject.quote(childModel.getChildquestion4()) + ");" +
                "setValueOrDefault('child1question1', " + JSONObject.quote(childModel.getChild1question1()) + ");" +
                "setValueOrDefault('child1question2', " + JSONObject.quote(childModel.getChild1question2()) + ");" +
                "setValueOrDefault('child1question3', " + JSONObject.quote(childModel.getChild1question3()) + ");" +
                "setValueOrDefault('child1question4', " + JSONObject.quote(childModel.getChild1question4()) + ");" +
                "setValueOrDefault('child1question5', " + JSONObject.quote(childModel.getChild1question5()) + ");" +
                "setValueOrDefault('child1question6', " + JSONObject.quote(childModel.getChild1question6()) + ");" +
                "setValueOrDefault('child1question7', " + JSONObject.quote(childModel.getChild1question7()) + ");" +
                "setValueOrDefault('child1question8', " + JSONObject.quote(childModel.getChild1question8()) + ");" +
                "setValueOrDefault('child1question9', " + JSONObject.quote(childModel.getChild1question9()) + ");" +
                "setValueOrDefault('child1question10', " + JSONObject.quote(childModel.getChild1question10()) + ");" +
                "setValueOrDefault('child1question11', " + JSONObject.quote(childModel.getChild1question11()) + ");" +
                "setValueOrDefault('child1question12', " + JSONObject.quote(childModel.getChild1question12()) + ");" +
                "setValueOrDefault('child1question13', " + JSONObject.quote(childModel.getChild1question13()) + ");" +
                "setValueOrDefault('child1question14', " + JSONObject.quote(childModel.getChild1question14()) + ");" +
                "setValueOrDefault('child1question15', " + JSONObject.quote(childModel.getChild1question15()) + ");" +
                "setValueOrDefault('child1question16', " + JSONObject.quote(childModel.getChild1question16()) + ");" +
                "setValueOrDefault('child1question17', " + JSONObject.quote(childModel.getChild1question17()) + ");" +
                "setValueOrDefault('child1question18', " + JSONObject.quote(childModel.getChild1question18()) + ");" +
                "setValueOrDefault('child1question19', " + JSONObject.quote(childModel.getChild1question19()) + ");" +
                "setValueOrDefault('child2question1', " + JSONObject.quote(childModel.getChild2question1()) + ");" +
                "setValueOrDefault('child2question2', " + JSONObject.quote(childModel.getChild2question2()) + ");" +
                "setValueOrDefault('child2question3', " + JSONObject.quote(childModel.getChild2question3()) + ");" +
                "setValueOrDefault('child2question4', " + JSONObject.quote(childModel.getChild2question4()) + ");" +
                "setValueOrDefault('child2question5', " + JSONObject.quote(childModel.getChild2question5()) + ");" +
                "setValueOrDefault('child2question6', " + JSONObject.quote(childModel.getChild2question6()) + ");" +
                "setValueOrDefault('child2question7', " + JSONObject.quote(childModel.getChild2question7()) + ");" +
                "setValueOrDefault('child2question8', " + JSONObject.quote(childModel.getChild2question8()) + ");" +
                "setValueOrDefault('child2question9', " + JSONObject.quote(childModel.getChild2question9()) + ");" +
                "setValueOrDefault('child2question10', " + JSONObject.quote(childModel.getChild2question10()) + ");" +
                "setValueOrDefault('child2question11', " + JSONObject.quote(childModel.getChild2question11()) + ");" +
                "setValueOrDefault('child2question12', " + JSONObject.quote(childModel.getChild2question12()) + ");" +
                "setValueOrDefault('child2question13', " + JSONObject.quote(childModel.getChild2question13()) + ");" +
                "setValueOrDefault('child2question14', " + JSONObject.quote(childModel.getChild2question14()) + ");" +
                "setValueOrDefault('child2question15', " + JSONObject.quote(childModel.getChild2question15()) + ");" +
                "setValueOrDefault('child2question16', " + JSONObject.quote(childModel.getChild2question16()) + ");" +
                "setValueOrDefault('child2question17', " + JSONObject.quote(childModel.getChild2question17()) + ");" +
                "setValueOrDefault('child2question18', " + JSONObject.quote(childModel.getChild2question18()) + ");" +
                "setValueOrDefault('child2question19', " + JSONObject.quote(childModel.getChild2question19()) + ");" +
                "setValueOrDefault('child3question1', " + JSONObject.quote(childModel.getChild3question1()) + ");" +
                "setValueOrDefault('child3question2', " + JSONObject.quote(childModel.getChild3question2()) + ");" +
                "setValueOrDefault('child3question3', " + JSONObject.quote(childModel.getChild3question3()) + ");" +
                "setValueOrDefault('child3question4', " + JSONObject.quote(childModel.getChild3question4()) + ");" +
                "setValueOrDefault('child3question5', " + JSONObject.quote(childModel.getChild3question5()) + ");" +
                "setValueOrDefault('child3question6', " + JSONObject.quote(childModel.getChild3question6()) + ");" +
                "setValueOrDefault('child3question7', " + JSONObject.quote(childModel.getChild3question7()) + ");" +
                "setValueOrDefault('child3question8', " + JSONObject.quote(childModel.getChild3question8()) + ");" +
                "setValueOrDefault('child3question9', " + JSONObject.quote(childModel.getChild3question9()) + ");" +
                "setValueOrDefault('child3question10', " + JSONObject.quote(childModel.getChild3question10()) + ");" +
                "setValueOrDefault('child3question11', " + JSONObject.quote(childModel.getChild3question11()) + ");" +
                "setValueOrDefault('child3question12', " + JSONObject.quote(childModel.getChild3question12()) + ");" +
                "setValueOrDefault('child3question13', " + JSONObject.quote(childModel.getChild3question13()) + ");" +
                "setValueOrDefault('child3question14', " + JSONObject.quote(childModel.getChild3question14()) + ");" +
                "setValueOrDefault('child3question15', " + JSONObject.quote(childModel.getChild3question15()) + ");" +
                "setValueOrDefault('child3question16', " + JSONObject.quote(childModel.getChild3question16()) + ");" +
                "setValueOrDefault('child3question17', " + JSONObject.quote(childModel.getChild3question17()) + ");" +
                "setValueOrDefault('child3question18', " + JSONObject.quote(childModel.getChild3question18()) + ");" +
                "setValueOrDefault('child3question19', " + JSONObject.quote(childModel.getChild3question19()) + ");" +
                "setValueOrDefault('child4question1', " + JSONObject.quote(childModel.getChild4question1()) + ");" +
                "setValueOrDefault('child4question2', " + JSONObject.quote(childModel.getChild4question2()) + ");" +
                "setValueOrDefault('child4question3', " + JSONObject.quote(childModel.getChild4question3()) + ");" +
                "setValueOrDefault('child4question4', " + JSONObject.quote(childModel.getChild4question4()) + ");" +
                "setValueOrDefault('child4question5', " + JSONObject.quote(childModel.getChild4question5()) + ");" +
                "setValueOrDefault('child4question6', " + JSONObject.quote(childModel.getChild4question6()) + ");" +
                "setValueOrDefault('child4question7', " + JSONObject.quote(childModel.getChild4question7()) + ");" +
                "setValueOrDefault('child4question8', " + JSONObject.quote(childModel.getChild4question8()) + ");" +
                "setValueOrDefault('child4question9', " + JSONObject.quote(childModel.getChild4question9()) + ");" +
                "setValueOrDefault('child4question10', " + JSONObject.quote(childModel.getChild4question10()) + ");" +
                "setValueOrDefault('child4question11', " + JSONObject.quote(childModel.getChild4question11()) + ");" +
                "setValueOrDefault('child4question12', " + JSONObject.quote(childModel.getChild4question12()) + ");" +
                "setValueOrDefault('child4question13', " + JSONObject.quote(childModel.getChild4question13()) + ");" +
                "setValueOrDefault('child4question14', " + JSONObject.quote(childModel.getChild4question14()) + ");" +
                "setValueOrDefault('child4question15', " + JSONObject.quote(childModel.getChild4question15()) + ");" +
                "setValueOrDefault('child4question16', " + JSONObject.quote(childModel.getChild4question16()) + ");" +
                "setValueOrDefault('child4question17', " + JSONObject.quote(childModel.getChild4question17()) + ");" +
                "setValueOrDefault('child4question18', " + JSONObject.quote(childModel.getChild4question18()) + ");" +
                "setValueOrDefault('child4question19', " + JSONObject.quote(childModel.getChild4question19()) + ");" +
                "setValueOrDefault('child5question1', " + JSONObject.quote(childModel.getChild5question1()) + ");" +
                "setValueOrDefault('child5question2', " + JSONObject.quote(childModel.getChild5question2()) + ");" +
                "setValueOrDefault('child5question3', " + JSONObject.quote(childModel.getChild5question3()) + ");" +
                "setValueOrDefault('child5question4', " + JSONObject.quote(childModel.getChild5question4()) + ");" +
                "setValueOrDefault('child5question5', " + JSONObject.quote(childModel.getChild5question5()) + ");" +
                "setValueOrDefault('child5question6', " + JSONObject.quote(childModel.getChild5question6()) + ");" +
                "setValueOrDefault('child5question7', " + JSONObject.quote(childModel.getChild5question7()) + ");" +
                "setValueOrDefault('child5question8', " + JSONObject.quote(childModel.getChild5question8()) + ");" +
                "setValueOrDefault('child5question9', " + JSONObject.quote(childModel.getChild5question9()) + ");" +
                "setValueOrDefault('child5question10', " + JSONObject.quote(childModel.getChild5question10()) + ");" +
                "setValueOrDefault('child5question11', " + JSONObject.quote(childModel.getChild5question11()) + ");" +
                "setValueOrDefault('child5question12', " + JSONObject.quote(childModel.getChild5question12()) + ");" +
                "setValueOrDefault('child5question13', " + JSONObject.quote(childModel.getChild5question13()) + ");" +
                "setValueOrDefault('child5question14', " + JSONObject.quote(childModel.getChild5question14()) + ");" +
                "setValueOrDefault('child5question15', " + JSONObject.quote(childModel.getChild5question15()) + ");" +
                "setValueOrDefault('child5question16', " + JSONObject.quote(childModel.getChild5question16()) + ");" +
                "setValueOrDefault('child5question17', " + JSONObject.quote(childModel.getChild5question17()) + ");" +
                "setValueOrDefault('child5question18', " + JSONObject.quote(childModel.getChild5question18()) + ");" +
                "setValueOrDefault('child5question19', " + JSONObject.quote(childModel.getChild5question19()) + ");" +
                "setValueOrDefault('child6question1', " + JSONObject.quote(childModel.getChild6question1()) + ");" +
                "setValueOrDefault('child6question2', " + JSONObject.quote(childModel.getChild6question2()) + ");" +
                "setValueOrDefault('child6question3', " + JSONObject.quote(childModel.getChild6question3()) + ");" +
                "setValueOrDefault('child6question4', " + JSONObject.quote(childModel.getChild6question4()) + ");" +
                "setValueOrDefault('child6question5', " + JSONObject.quote(childModel.getChild6question5()) + ");" +
                "setValueOrDefault('child6question6', " + JSONObject.quote(childModel.getChild6question6()) + ");" +
                "setValueOrDefault('child6question7', " + JSONObject.quote(childModel.getChild6question7()) + ");" +
                "setValueOrDefault('child6question8', " + JSONObject.quote(childModel.getChild6question8()) + ");" +
                "setValueOrDefault('child6question9', " + JSONObject.quote(childModel.getChild6question9()) + ");" +
                "setValueOrDefault('child6question10', " + JSONObject.quote(childModel.getChild6question10()) + ");" +
                "setValueOrDefault('child6question11', " + JSONObject.quote(childModel.getChild6question11()) + ");" +
                "setValueOrDefault('child6question12', " + JSONObject.quote(childModel.getChild6question12()) + ");" +
                "setValueOrDefault('child6question13', " + JSONObject.quote(childModel.getChild6question13()) + ");" +
                "setValueOrDefault('child6question14', " + JSONObject.quote(childModel.getChild6question14()) + ");" +
                "setValueOrDefault('child6question15', " + JSONObject.quote(childModel.getChild6question15()) + ");" +
                "setValueOrDefault('child6question16', " + JSONObject.quote(childModel.getChild6question16()) + ");" +
                "setValueOrDefault('child6question17', " + JSONObject.quote(childModel.getChild6question17()) + ");" +
                "setValueOrDefault('child6question18', " + JSONObject.quote(childModel.getChild6question18()) + ");" +
                "setValueOrDefault('child6question19', " + JSONObject.quote(childModel.getChild6question19()) + ");" +
                "setValueOrDefault('child7question1', " + JSONObject.quote(childModel.getChild7question1()) + ");" +
                "setValueOrDefault('child7question2', " + JSONObject.quote(childModel.getChild7question2()) + ");" +
                "setValueOrDefault('child7question3', " + JSONObject.quote(childModel.getChild7question3()) + ");" +
                "setValueOrDefault('child7question4', " + JSONObject.quote(childModel.getChild7question4()) + ");" +
                "setValueOrDefault('child7question5', " + JSONObject.quote(childModel.getChild7question5()) + ");" +
                "setValueOrDefault('child7question6', " + JSONObject.quote(childModel.getChild7question6()) + ");" +
                "setValueOrDefault('child7question7', " + JSONObject.quote(childModel.getChild7question7()) + ");" +
                "setValueOrDefault('child7question8', " + JSONObject.quote(childModel.getChild7question8()) + ");" +
                "setValueOrDefault('child7question9', " + JSONObject.quote(childModel.getChild7question9()) + ");" +
                "setValueOrDefault('child7question10', " + JSONObject.quote(childModel.getChild7question10()) + ");" +
                "setValueOrDefault('child7question11', " + JSONObject.quote(childModel.getChild7question11()) + ");" +
                "setValueOrDefault('child7question12', " + JSONObject.quote(childModel.getChild7question12()) + ");" +
                "setValueOrDefault('child7question13', " + JSONObject.quote(childModel.getChild7question13()) + ");" +
                "setValueOrDefault('child7question14', " + JSONObject.quote(childModel.getChild7question14()) + ");" +
                "setValueOrDefault('child7question15', " + JSONObject.quote(childModel.getChild7question15()) + ");" +
                "setValueOrDefault('child7question16', " + JSONObject.quote(childModel.getChild7question16()) + ");" +
                "setValueOrDefault('child7question17', " + JSONObject.quote(childModel.getChild7question17()) + ");" +
                "setValueOrDefault('child7question18', " + JSONObject.quote(childModel.getChild7question18()) + ");" +
                "setValueOrDefault('child7question19', " + JSONObject.quote(childModel.getChild7question19()) + ");" +
                "setValueOrDefault('child8question1', " + JSONObject.quote(childModel.getChild8question1()) + ");" +
                "setValueOrDefault('child8question2', " + JSONObject.quote(childModel.getChild8question2()) + ");" +
                "setValueOrDefault('child8question3', " + JSONObject.quote(childModel.getChild8question3()) + ");" +
                "setValueOrDefault('child8question4', " + JSONObject.quote(childModel.getChild8question4()) + ");" +
                "setValueOrDefault('child8question5', " + JSONObject.quote(childModel.getChild8question5()) + ");" +
                "setValueOrDefault('child8question6', " + JSONObject.quote(childModel.getChild8question6()) + ");" +
                "setValueOrDefault('child8question7', " + JSONObject.quote(childModel.getChild8question7()) + ");" +
                "setValueOrDefault('child8question8', " + JSONObject.quote(childModel.getChild8question8()) + ");" +
                "setValueOrDefault('child8question9', " + JSONObject.quote(childModel.getChild8question9()) + ");" +
                "setValueOrDefault('child8question10', " + JSONObject.quote(childModel.getChild8question10()) + ");" +
                "setValueOrDefault('child8question11', " + JSONObject.quote(childModel.getChild8question11()) + ");" +
                "setValueOrDefault('child8question12', " + JSONObject.quote(childModel.getChild8question12()) + ");" +
                "setValueOrDefault('child8question13', " + JSONObject.quote(childModel.getChild8question13()) + ");" +
                "setValueOrDefault('child8question14', " + JSONObject.quote(childModel.getChild8question14()) + ");" +
                "setValueOrDefault('child8question15', " + JSONObject.quote(childModel.getChild8question15()) + ");" +
                "setValueOrDefault('child8question16', " + JSONObject.quote(childModel.getChild8question16()) + ");" +
                "setValueOrDefault('child8question17', " + JSONObject.quote(childModel.getChild8question17()) + ");" +
                "setValueOrDefault('child8question18', " + JSONObject.quote(childModel.getChild8question18()) + ");" +
                "setValueOrDefault('child8question19', " + JSONObject.quote(childModel.getChild8question19()) + ");" +
                "setValueOrDefault('child9question1', " + JSONObject.quote(childModel.getChild9question1()) + ");" +
                "setValueOrDefault('child9question2', " + JSONObject.quote(childModel.getChild9question2()) + ");" +
                "setValueOrDefault('child9question3', " + JSONObject.quote(childModel.getChild9question3()) + ");" +
                "setValueOrDefault('child9question4', " + JSONObject.quote(childModel.getChild9question4()) + ");" +
                "setValueOrDefault('child9question5', " + JSONObject.quote(childModel.getChild9question5()) + ");" +
                "setValueOrDefault('child9question6', " + JSONObject.quote(childModel.getChild9question6()) + ");" +
                "setValueOrDefault('child9question7', " + JSONObject.quote(childModel.getChild9question7()) + ");" +
                "setValueOrDefault('child9question8', " + JSONObject.quote(childModel.getChild9question8()) + ");" +
                "setValueOrDefault('child9question9', " + JSONObject.quote(childModel.getChild9question9()) + ");" +
                "setValueOrDefault('child9question10', " + JSONObject.quote(childModel.getChild9question10()) + ");" +
                "setValueOrDefault('child9question11', " + JSONObject.quote(childModel.getChild9question11()) + ");" +
                "setValueOrDefault('child9question12', " + JSONObject.quote(childModel.getChild9question12()) + ");" +
                "setValueOrDefault('child9question13', " + JSONObject.quote(childModel.getChild9question13()) + ");" +
                "setValueOrDefault('child9question14', " + JSONObject.quote(childModel.getChild9question14()) + ");" +
                "setValueOrDefault('child9question15', " + JSONObject.quote(childModel.getChild9question15()) + ");" +
                "setValueOrDefault('child9question16', " + JSONObject.quote(childModel.getChild9question16()) + ");" +
                "setValueOrDefault('child9question17', " + JSONObject.quote(childModel.getChild9question17()) + ");" +
                "setValueOrDefault('child9question18', " + JSONObject.quote(childModel.getChild9question18()) + ");" +
                "setValueOrDefault('child9question19', " + JSONObject.quote(childModel.getChild9question19()) + ");" +
                "setValueOrDefault('child10question1', " + JSONObject.quote(childModel.getChild10question1()) + ");" +
                "setValueOrDefault('child10question2', " + JSONObject.quote(childModel.getChild10question2()) + ");" +
                "setValueOrDefault('child10question3', " + JSONObject.quote(childModel.getChild10question3()) + ");" +
                "setValueOrDefault('child10question4', " + JSONObject.quote(childModel.getChild10question4()) + ");" +
                "setValueOrDefault('child10question5', " + JSONObject.quote(childModel.getChild10question5()) + ");" +
                "setValueOrDefault('child10question6', " + JSONObject.quote(childModel.getChild10question6()) + ");" +
                "setValueOrDefault('child10question7', " + JSONObject.quote(childModel.getChild10question7()) + ");" +
                "setValueOrDefault('child10question8', " + JSONObject.quote(childModel.getChild10question8()) + ");" +
                "setValueOrDefault('child10question9', " + JSONObject.quote(childModel.getChild10question9()) + ");" +
                "setValueOrDefault('child10question10', " + JSONObject.quote(childModel.getChild10question10()) + ");" +
                "setValueOrDefault('child10question11', " + JSONObject.quote(childModel.getChild10question11()) + ");" +
                "setValueOrDefault('child10question12', " + JSONObject.quote(childModel.getChild10question12()) + ");" +
                "setValueOrDefault('child10question13', " + JSONObject.quote(childModel.getChild10question13()) + ");" +
                "setValueOrDefault('child10question14', " + JSONObject.quote(childModel.getChild10question14()) + ");" +
                "setValueOrDefault('child10question15', " + JSONObject.quote(childModel.getChild10question15()) + ");" +
                "setValueOrDefault('child10question16', " + JSONObject.quote(childModel.getChild10question16()) + ");" +
                "setValueOrDefault('child10question17', " + JSONObject.quote(childModel.getChild10question17()) + ");" +
                "setValueOrDefault('child10question18', " + JSONObject.quote(childModel.getChild10question18()) + ");" +
                "setValueOrDefault('child10question19', " + JSONObject.quote(childModel.getChild10question19()) + ");" +
                "setValueOrDefault('childquestion5', " + JSONObject.quote(childModel.getChildquestion5()) + ");" +
                "setValueOrDefault('childLocation', " + JSONObject.quote(childModel.getChildLocation()) + ");" +

                "setValueOrDefault('UserFname', " + JSONObject.quote(childModel.getUserFname()) + ");" +
                "setValueOrDefault('UserLname', " + JSONObject.quote(childModel.getUserLname()) + ");" +
                "setValueOrDefault('UserEmail', " + JSONObject.quote(childModel.getUserEmail()) + ");" +

                "setValueOrDefault('onCreate', " + JSONObject.quote(childModel.getOnCreate()) + ");";

        if (signaturePath != null && !signaturePath.isEmpty()) {
            File signatureFile = new File(signaturePath);
            Uri signatureUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", signatureFile);
            js += "document.getElementById('signature').src = " + JSONObject.quote(signatureUri.toString()) + ";";
        } else {
            js += "document.getElementById('signature').alt = 'Signature not available';";
        }

        chSurveyDetails.evaluateJavascript(js, null);
    }











//    private void injectSurveyDetails() {
//        String signaturePath = childModel.getSignature();
//        String js = "javascript:" +
//                "document.getElementById('farmerId').textContent = " + JSONObject.quote(childModel.getFarmerId()) + ";" +
//                "document.getElementById('farmerDistrict').textContent = " + JSONObject.quote(childModel.getFarmerDistrict()) + ";" +
//                "document.getElementById('farmerVillage').textContent = " + JSONObject.quote(childModel.getFarmerVillage()) + ";" +
//                "document.getElementById('childquestion4').textContent = " + JSONObject.quote(childModel.getChildquestion4()) + ";" +
//                "document.getElementById('child1question1').textContent = " + JSONObject.quote(childModel.getChild1question1()) + ";" +
//                "document.getElementById('child1question2').textContent = " + JSONObject.quote(childModel.getChild1question2()) + ";" +
//                "document.getElementById('child1question3').textContent = " + JSONObject.quote(childModel.getChild1question3()) + ";" +
//                "document.getElementById('child1question4').textContent = " + JSONObject.quote(childModel.getChild1question4()) + ";" +
//                "document.getElementById('child1question5').textContent = " + JSONObject.quote(childModel.getChild1question5()) + ";" +
//                "document.getElementById('child1question6').textContent = " + JSONObject.quote(childModel.getChild1question6()) + ";" +
//                "document.getElementById('child1question7').textContent = " + JSONObject.quote(childModel.getChild1question7()) + ";" +
//                "document.getElementById('child1question8').textContent = " + JSONObject.quote(childModel.getChild1question8()) + ";" +
//                "document.getElementById('child1question9').textContent = " + JSONObject.quote(childModel.getChild1question9()) + ";" +
//                "document.getElementById('child1question10').textContent = " + JSONObject.quote(childModel.getChild1question10()) + ";" +
//                "document.getElementById('child1question11').textContent = " + JSONObject.quote(childModel.getChild1question11()) + ";" +
//                "document.getElementById('child1question12').textContent = " + JSONObject.quote(childModel.getChild1question12()) + ";" +
//                "document.getElementById('child1question13').textContent = " + JSONObject.quote(childModel.getChild1question13()) + ";" +
//                "document.getElementById('child1question14').textContent = " + JSONObject.quote(childModel.getChild1question14()) + ";" +
//                "document.getElementById('child1question15').textContent = " + JSONObject.quote(childModel.getChild1question15()) + ";" +
//                "document.getElementById('child1question16').textContent = " + JSONObject.quote(childModel.getChild1question16()) + ";" +
//                "document.getElementById('child1question17').textContent = " + JSONObject.quote(childModel.getChild1question17()) + ";" +
//                "document.getElementById('child1question18').textContent = " + JSONObject.quote(childModel.getChild1question18()) + ";" +
//                "document.getElementById('child1question19').textContent = " + JSONObject.quote(childModel.getChild1question19()) + ";" +
//                "document.getElementById('child2question1').textContent = " + JSONObject.quote(childModel.getChild2question1()) + ";" +
//                "document.getElementById('child2question2').textContent = " + JSONObject.quote(childModel.getChild2question2()) + ";" +
//                "document.getElementById('child2question3').textContent = " + JSONObject.quote(childModel.getChild2question3()) + ";" +
//                "document.getElementById('child2question4').textContent = " + JSONObject.quote(childModel.getChild2question4()) + ";" +
//                "document.getElementById('child2question5').textContent = " + JSONObject.quote(childModel.getChild2question5()) + ";" +
//                "document.getElementById('child2question6').textContent = " + JSONObject.quote(childModel.getChild2question6()) + ";" +
//                "document.getElementById('child2question7').textContent = " + JSONObject.quote(childModel.getChild2question7()) + ";" +
//                "document.getElementById('child2question8').textContent = " + JSONObject.quote(childModel.getChild2question8()) + ";" +
//                "document.getElementById('child2question9').textContent = " + JSONObject.quote(childModel.getChild2question9()) + ";" +
//                "document.getElementById('child2question10').textContent = " + JSONObject.quote(childModel.getChild2question10()) + ";" +
//                "document.getElementById('child2question11').textContent = " + JSONObject.quote(childModel.getChild2question11()) + ";" +
//                "document.getElementById('child2question12').textContent = " + JSONObject.quote(childModel.getChild2question12()) + ";" +
//                "document.getElementById('child2question13').textContent = " + JSONObject.quote(childModel.getChild2question13()) + ";" +
//                "document.getElementById('child2question14').textContent = " + JSONObject.quote(childModel.getChild2question14()) + ";" +
//                "document.getElementById('child2question15').textContent = " + JSONObject.quote(childModel.getChild2question15()) + ";" +
//                "document.getElementById('child2question16').textContent = " + JSONObject.quote(childModel.getChild2question16()) + ";" +
//                "document.getElementById('child2question17').textContent = " + JSONObject.quote(childModel.getChild2question17()) + ";" +
//                "document.getElementById('child2question18').textContent = " + JSONObject.quote(childModel.getChild2question18()) + ";" +
//                "document.getElementById('child2question19').textContent = " + JSONObject.quote(childModel.getChild2question19()) + ";" +
//                "document.getElementById('child3question1').textContent = " + JSONObject.quote(childModel.getChild3question1()) + ";" +
//                "document.getElementById('child3question2').textContent = " + JSONObject.quote(childModel.getChild3question2()) + ";" +
//                "document.getElementById('child3question3').textContent = " + JSONObject.quote(childModel.getChild3question3()) + ";" +
//                "document.getElementById('child3question4').textContent = " + JSONObject.quote(childModel.getChild3question4()) + ";" +
//                "document.getElementById('child3question5').textContent = " + JSONObject.quote(childModel.getChild3question5()) + ";" +
//                "document.getElementById('child3question6').textContent = " + JSONObject.quote(childModel.getChild3question6()) + ";" +
//                "document.getElementById('child3question7').textContent = " + JSONObject.quote(childModel.getChild3question7()) + ";" +
//                "document.getElementById('child3question8').textContent = " + JSONObject.quote(childModel.getChild3question8()) + ";" +
//                "document.getElementById('child3question9').textContent = " + JSONObject.quote(childModel.getChild3question9()) + ";" +
//                "document.getElementById('child3question10').textContent = " + JSONObject.quote(childModel.getChild3question10()) + ";" +
//                "document.getElementById('child3question11').textContent = " + JSONObject.quote(childModel.getChild3question11()) + ";" +
//                "document.getElementById('child3question12').textContent = " + JSONObject.quote(childModel.getChild3question12()) + ";" +
//                "document.getElementById('child3question13').textContent = " + JSONObject.quote(childModel.getChild3question13()) + ";" +
//                "document.getElementById('child3question14').textContent = " + JSONObject.quote(childModel.getChild3question14()) + ";" +
//                "document.getElementById('child3question15').textContent = " + JSONObject.quote(childModel.getChild3question15()) + ";" +
//                "document.getElementById('child3question16').textContent = " + JSONObject.quote(childModel.getChild3question16()) + ";" +
//                "document.getElementById('child3question17').textContent = " + JSONObject.quote(childModel.getChild3question17()) + ";" +
//                "document.getElementById('child3question18').textContent = " + JSONObject.quote(childModel.getChild3question18()) + ";" +
//                "document.getElementById('child3question19').textContent = " + JSONObject.quote(childModel.getChild3question19()) + ";" +
//                "document.getElementById('child4question1').textContent = " + JSONObject.quote(childModel.getChild4question1()) + ";" +
//                "document.getElementById('child4question2').textContent = " + JSONObject.quote(childModel.getChild4question2()) + ";" +
//                "document.getElementById('child4question3').textContent = " + JSONObject.quote(childModel.getChild4question3()) + ";" +
//                "document.getElementById('child4question4').textContent = " + JSONObject.quote(childModel.getChild4question4()) + ";" +
//                "document.getElementById('child4question5').textContent = " + JSONObject.quote(childModel.getChild4question5()) + ";" +
//                "document.getElementById('child4question6').textContent = " + JSONObject.quote(childModel.getChild4question6()) + ";" +
//                "document.getElementById('child4question7').textContent = " + JSONObject.quote(childModel.getChild4question7()) + ";" +
//                "document.getElementById('child4question8').textContent = " + JSONObject.quote(childModel.getChild4question8()) + ";" +
//                "document.getElementById('child4question9').textContent = " + JSONObject.quote(childModel.getChild4question9()) + ";" +
//                "document.getElementById('child4question10').textContent = " + JSONObject.quote(childModel.getChild4question10()) + ";" +
//                "document.getElementById('child4question11').textContent = " + JSONObject.quote(childModel.getChild4question11()) + ";" +
//                "document.getElementById('child4question12').textContent = " + JSONObject.quote(childModel.getChild4question12()) + ";" +
//                "document.getElementById('child4question13').textContent = " + JSONObject.quote(childModel.getChild4question13()) + ";" +
//                "document.getElementById('child4question14').textContent = " + JSONObject.quote(childModel.getChild4question14()) + ";" +
//                "document.getElementById('child4question15').textContent = " + JSONObject.quote(childModel.getChild4question15()) + ";" +
//                "document.getElementById('child4question16').textContent = " + JSONObject.quote(childModel.getChild4question16()) + ";" +
//                "document.getElementById('child4question17').textContent = " + JSONObject.quote(childModel.getChild4question17()) + ";" +
//                "document.getElementById('child4question18').textContent = " + JSONObject.quote(childModel.getChild4question18()) + ";" +
//                "document.getElementById('child4question19').textContent = " + JSONObject.quote(childModel.getChild4question19()) + ";" +
//                "document.getElementById('child5question1').textContent = " + JSONObject.quote(childModel.getChild5question1()) + ";" +
//                "document.getElementById('child5question2').textContent = " + JSONObject.quote(childModel.getChild5question2()) + ";" +
//                "document.getElementById('child5question3').textContent = " + JSONObject.quote(childModel.getChild5question3()) + ";" +
//                "document.getElementById('child5question4').textContent = " + JSONObject.quote(childModel.getChild5question4()) + ";" +
//                "document.getElementById('child5question5').textContent = " + JSONObject.quote(childModel.getChild5question5()) + ";" +
//                "document.getElementById('child5question6').textContent = " + JSONObject.quote(childModel.getChild5question6()) + ";" +
//                "document.getElementById('child5question7').textContent = " + JSONObject.quote(childModel.getChild5question7()) + ";" +
//                "document.getElementById('child5question8').textContent = " + JSONObject.quote(childModel.getChild5question8()) + ";" +
//                "document.getElementById('child5question9').textContent = " + JSONObject.quote(childModel.getChild5question9()) + ";" +
//                "document.getElementById('child5question10').textContent = " + JSONObject.quote(childModel.getChild5question10()) + ";" +
//                "document.getElementById('child5question11').textContent = " + JSONObject.quote(childModel.getChild5question11()) + ";" +
//                "document.getElementById('child5question12').textContent = " + JSONObject.quote(childModel.getChild5question12()) + ";" +
//                "document.getElementById('child5question13').textContent = " + JSONObject.quote(childModel.getChild5question13()) + ";" +
//                "document.getElementById('child5question14').textContent = " + JSONObject.quote(childModel.getChild5question14()) + ";" +
//                "document.getElementById('child5question15').textContent = " + JSONObject.quote(childModel.getChild5question15()) + ";" +
//                "document.getElementById('child5question16').textContent = " + JSONObject.quote(childModel.getChild5question16()) + ";" +
//                "document.getElementById('child5question17').textContent = " + JSONObject.quote(childModel.getChild5question17()) + ";" +
//                "document.getElementById('child5question18').textContent = " + JSONObject.quote(childModel.getChild5question18()) + ";" +
//                "document.getElementById('child5question19').textContent = " + JSONObject.quote(childModel.getChild5question19()) + ";" +
//                "document.getElementById('child6question1').textContent = " + JSONObject.quote(childModel.getChild6question1()) + ";" +
//                "document.getElementById('child6question2').textContent = " + JSONObject.quote(childModel.getChild6question2()) + ";" +
//                "document.getElementById('child6question3').textContent = " + JSONObject.quote(childModel.getChild6question3()) + ";" +
//                "document.getElementById('child6question4').textContent = " + JSONObject.quote(childModel.getChild6question4()) + ";" +
//                "document.getElementById('child6question5').textContent = " + JSONObject.quote(childModel.getChild6question5()) + ";" +
//                "document.getElementById('child6question6').textContent = " + JSONObject.quote(childModel.getChild6question6()) + ";" +
//                "document.getElementById('child6question7').textContent = " + JSONObject.quote(childModel.getChild6question7()) + ";" +
//                "document.getElementById('child6question8').textContent = " + JSONObject.quote(childModel.getChild6question8()) + ";" +
//                "document.getElementById('child6question9').textContent = " + JSONObject.quote(childModel.getChild6question9()) + ";" +
//                "document.getElementById('child6question10').textContent = " + JSONObject.quote(childModel.getChild6question10()) + ";" +
//                "document.getElementById('child6question11').textContent = " + JSONObject.quote(childModel.getChild6question11()) + ";" +
//                "document.getElementById('child6question12').textContent = " + JSONObject.quote(childModel.getChild6question12()) + ";" +
//                "document.getElementById('child6question13').textContent = " + JSONObject.quote(childModel.getChild6question13()) + ";" +
//                "document.getElementById('child6question14').textContent = " + JSONObject.quote(childModel.getChild6question14()) + ";" +
//                "document.getElementById('child6question15').textContent = " + JSONObject.quote(childModel.getChild6question15()) + ";" +
//                "document.getElementById('child6question16').textContent = " + JSONObject.quote(childModel.getChild6question16()) + ";" +
//                "document.getElementById('child6question17').textContent = " + JSONObject.quote(childModel.getChild6question17()) + ";" +
//                "document.getElementById('child6question18').textContent = " + JSONObject.quote(childModel.getChild6question18()) + ";" +
//                "document.getElementById('child6question19').textContent = " + JSONObject.quote(childModel.getChild6question19()) + ";" +
//                "document.getElementById('child7question1').textContent = " + JSONObject.quote(childModel.getChild7question1()) + ";" +
//                "document.getElementById('child7question2').textContent = " + JSONObject.quote(childModel.getChild7question2()) + ";" +
//                "document.getElementById('child7question3').textContent = " + JSONObject.quote(childModel.getChild7question3()) + ";" +
//                "document.getElementById('child7question4').textContent = " + JSONObject.quote(childModel.getChild7question4()) + ";" +
//                "document.getElementById('child7question5').textContent = " + JSONObject.quote(childModel.getChild7question5()) + ";" +
//                "document.getElementById('child7question6').textContent = " + JSONObject.quote(childModel.getChild7question6()) + ";" +
//                "document.getElementById('child7question7').textContent = " + JSONObject.quote(childModel.getChild7question7()) + ";" +
//                "document.getElementById('child7question8').textContent = " + JSONObject.quote(childModel.getChild7question8()) + ";" +
//                "document.getElementById('child7question9').textContent = " + JSONObject.quote(childModel.getChild7question9()) + ";" +
//                "document.getElementById('child7question10').textContent = " + JSONObject.quote(childModel.getChild7question10()) + ";" +
//                "document.getElementById('child7question11').textContent = " + JSONObject.quote(childModel.getChild7question11()) + ";" +
//                "document.getElementById('child7question12').textContent = " + JSONObject.quote(childModel.getChild7question12()) + ";" +
//                "document.getElementById('child7question13').textContent = " + JSONObject.quote(childModel.getChild7question13()) + ";" +
//                "document.getElementById('child7question14').textContent = " + JSONObject.quote(childModel.getChild7question14()) + ";" +
//                "document.getElementById('child7question15').textContent = " + JSONObject.quote(childModel.getChild7question15()) + ";" +
//                "document.getElementById('child7question16').textContent = " + JSONObject.quote(childModel.getChild7question16()) + ";" +
//                "document.getElementById('child7question17').textContent = " + JSONObject.quote(childModel.getChild7question17()) + ";" +
//                "document.getElementById('child7question18').textContent = " + JSONObject.quote(childModel.getChild7question18()) + ";" +
//                "document.getElementById('child7question19').textContent = " + JSONObject.quote(childModel.getChild7question19()) + ";" +
//                "document.getElementById('child8question1').textContent = " + JSONObject.quote(childModel.getChild8question1()) + ";" +
//                "document.getElementById('child8question2').textContent = " + JSONObject.quote(childModel.getChild8question2()) + ";" +
//                "document.getElementById('child8question3').textContent = " + JSONObject.quote(childModel.getChild8question3()) + ";" +
//                "document.getElementById('child8question4').textContent = " + JSONObject.quote(childModel.getChild8question4()) + ";" +
//                "document.getElementById('child8question5').textContent = " + JSONObject.quote(childModel.getChild8question5()) + ";" +
//                "document.getElementById('child8question6').textContent = " + JSONObject.quote(childModel.getChild8question6()) + ";" +
//                "document.getElementById('child8question7').textContent = " + JSONObject.quote(childModel.getChild8question7()) + ";" +
//                "document.getElementById('child8question8').textContent = " + JSONObject.quote(childModel.getChild8question8()) + ";" +
//                "document.getElementById('child8question9').textContent = " + JSONObject.quote(childModel.getChild8question9()) + ";" +
//                "document.getElementById('child8question10').textContent = " + JSONObject.quote(childModel.getChild8question10()) + ";" +
//                "document.getElementById('child8question11').textContent = " + JSONObject.quote(childModel.getChild8question11()) + ";" +
//                "document.getElementById('child8question12').textContent = " + JSONObject.quote(childModel.getChild8question12()) + ";" +
//                "document.getElementById('child8question13').textContent = " + JSONObject.quote(childModel.getChild8question13()) + ";" +
//                "document.getElementById('child8question14').textContent = " + JSONObject.quote(childModel.getChild8question14()) + ";" +
//                "document.getElementById('child8question15').textContent = " + JSONObject.quote(childModel.getChild8question15()) + ";" +
//                "document.getElementById('child8question16').textContent = " + JSONObject.quote(childModel.getChild8question16()) + ";" +
//                "document.getElementById('child8question17').textContent = " + JSONObject.quote(childModel.getChild8question17()) + ";" +
//                "document.getElementById('child8question18').textContent = " + JSONObject.quote(childModel.getChild8question18()) + ";" +
//                "document.getElementById('child8question19').textContent = " + JSONObject.quote(childModel.getChild8question19()) + ";" +
//                "document.getElementById('child9question1').textContent = " + JSONObject.quote(childModel.getChild9question1()) + ";" +
//                "document.getElementById('child9question2').textContent = " + JSONObject.quote(childModel.getChild9question2()) + ";" +
//                "document.getElementById('child9question3').textContent = " + JSONObject.quote(childModel.getChild9question3()) + ";" +
//                "document.getElementById('child9question4').textContent = " + JSONObject.quote(childModel.getChild9question4()) + ";" +
//                "document.getElementById('child9question5').textContent = " + JSONObject.quote(childModel.getChild9question5()) + ";" +
//                "document.getElementById('child9question6').textContent = " + JSONObject.quote(childModel.getChild9question6()) + ";" +
//                "document.getElementById('child9question7').textContent = " + JSONObject.quote(childModel.getChild9question7()) + ";" +
//                "document.getElementById('child9question8').textContent = " + JSONObject.quote(childModel.getChild9question8()) + ";" +
//                "document.getElementById('child9question9').textContent = " + JSONObject.quote(childModel.getChild9question9()) + ";" +
//                "document.getElementById('child9question10').textContent = " + JSONObject.quote(childModel.getChild9question10()) + ";" +
//                "document.getElementById('child9question11').textContent = " + JSONObject.quote(childModel.getChild9question11()) + ";" +
//                "document.getElementById('child9question12').textContent = " + JSONObject.quote(childModel.getChild9question12()) + ";" +
//                "document.getElementById('child9question13').textContent = " + JSONObject.quote(childModel.getChild9question13()) + ";" +
//                "document.getElementById('child9question14').textContent = " + JSONObject.quote(childModel.getChild9question14()) + ";" +
//                "document.getElementById('child9question15').textContent = " + JSONObject.quote(childModel.getChild9question15()) + ";" +
//                "document.getElementById('child9question16').textContent = " + JSONObject.quote(childModel.getChild9question16()) + ";" +
//                "document.getElementById('child9question17').textContent = " + JSONObject.quote(childModel.getChild9question17()) + ";" +
//                "document.getElementById('child9question18').textContent = " + JSONObject.quote(childModel.getChild9question18()) + ";" +
//                "document.getElementById('child9question19').textContent = " + JSONObject.quote(childModel.getChild9question19()) + ";" +
//                "document.getElementById('child10question1').textContent = " + JSONObject.quote(childModel.getChild10question1()) + ";" +
//                "document.getElementById('child10question2').textContent = " + JSONObject.quote(childModel.getChild10question2()) + ";" +
//                "document.getElementById('child10question3').textContent = " + JSONObject.quote(childModel.getChild10question3()) + ";" +
//                "document.getElementById('child10question4').textContent = " + JSONObject.quote(childModel.getChild10question4()) + ";" +
//                "document.getElementById('child10question5').textContent = " + JSONObject.quote(childModel.getChild10question5()) + ";" +
//                "document.getElementById('child10question6').textContent = " + JSONObject.quote(childModel.getChild10question6()) + ";" +
//                "document.getElementById('child10question7').textContent = " + JSONObject.quote(childModel.getChild10question7()) + ";" +
//                "document.getElementById('child10question8').textContent = " + JSONObject.quote(childModel.getChild10question8()) + ";" +
//                "document.getElementById('child10question9').textContent = " + JSONObject.quote(childModel.getChild10question9()) + ";" +
//                "document.getElementById('child10question10').textContent = " + JSONObject.quote(childModel.getChild10question10()) + ";" +
//                "document.getElementById('child10question11').textContent = " + JSONObject.quote(childModel.getChild10question11()) + ";" +
//                "document.getElementById('child10question12').textContent = " + JSONObject.quote(childModel.getChild10question12()) + ";" +
//                "document.getElementById('child10question13').textContent = " + JSONObject.quote(childModel.getChild10question13()) + ";" +
//                "document.getElementById('child10question14').textContent = " + JSONObject.quote(childModel.getChild10question14()) + ";" +
//                "document.getElementById('child10question16').textContent = " + JSONObject.quote(childModel.getChild10question16()) + ";" +
//                "document.getElementById('child10question17').textContent = " + JSONObject.quote(childModel.getChild10question17()) + ";" +
//                "document.getElementById('child10question18').textContent = " + JSONObject.quote(childModel.getChild10question18()) + ";" +
//                "document.getElementById('child10question19').textContent = " + JSONObject.quote(childModel.getChild10question19()) + ";" +
//                "document.getElementById('childquestion5').textContent = " + JSONObject.quote(childModel.getChildquestion5()) + ";" +
//                "document.getElementById('childLocation').textContent = " + JSONObject.quote(childModel.getChildLocation()) + ";" +
//                "document.getElementById('onCreate').textContent = " + JSONObject.quote(childModel.getOnCreate()) + ";";
//
//        if (signaturePath != null && !signaturePath.isEmpty()) {
//            File signatureFile = new File(signaturePath);
//            Uri signatureUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", signatureFile);
//            js += "document.getElementById('signature').src = " + JSONObject.quote(signatureUri.toString()) + ";";
//        } else {
//            js += "document.getElementById('signature').alt = 'Signature not available';";
//        }
//
//        chSurveyDetails.evaluateJavascript(js, null);
//    }


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.ch_view);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}