//1. I have a SurveyJS form with json_gmr.js, index_gmr.js, and index_gmr.html below, with the following fields:
//a. farmer_code: code of farmer
//b. id_photo: photo of ID card
//c. farmer_photo: photo of farmer
//d. tp_photo: photo of thumbprint
//e. signature: png image
//
//
//2. There are these fields too from preferenceHelper that will be include when saving the SurveyJS form:
//        f. tvUserName.setText(requireNotNull(preferenceHelper.getFName()));
//        g. tvUserName2.setText(requireNotNull(preferenceHelper.getLName()));
//
//
//        3. Use GMRDbHelper to handle SQLite database operations
//Create database helper class:
//Implement methods for creating the database, inserting data, and retrieving data.
//Insert data into the database:
//In your Java code, receive the form data from the JavaScript interface.
//Insert the data into the MySQLite database using your helper class.
//
//
//        4. SurveyJS Form Completion
//Override the "complete" button behavior:
//In your JavaScript code, intercept the "complete" event.
//redirect to GMRSurveyCompletedActivity when the form is inserted into the database
//
//
//5. create GMRDbHelper and insert user_fname, user_lname, farmer_code, farmer_code, farmer_photo, tp_photo, signature, on_create and on_update
//
//
//6. GMRProfilingWebActivity hosts the SurverJS forms and has the WebView for loading index_gmr.html
//
////GMRProfilingWebActivity
//public class GMRProfilingWebActivity extends AppCompatActivity {
//
//    private PreferenceHelper preferenceHelper;
//
//    private WebView gmrSurveyWebView;
//    private ProgressBar gmrProgressBar;
//    private ActivityResultLauncher<Intent> locationLauncher;
//    private ActivityResultLauncher<Intent> photoIdLauncher;
//    private ActivityResultLauncher<Intent> photoFarmerLauncher;
//    private ActivityResultLauncher<Intent> photoTpLauncher;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_gmrprofiling_web);
//
//        // Initialize PreferenceHelper
//        injectDependencies();
//
//        TextView tvUserName = findViewById(R.id.gmrUserFNameTV);
//        TextView tvUserName2 = findViewById(R.id.gmrUserLNameTV);
//
//        // Set TextViews using PreferenceHelper
//        tvUserName.setText(requireNotNull(preferenceHelper.getFName()));
//        tvUserName2.setText(requireNotNull(preferenceHelper.getLName()));
//
//        gmrProgressBar = findViewById(R.id.gmrProgressBar);
//        gmrSurveyWebView = findViewById(R.id.gmrWebView);
//        gmrSurveyWebView.getSettings().setJavaScriptEnabled(true);
//
//        gmrSurveyWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                gmrProgressBar.setVisibility(View.GONE);
//            }
//        });
//
//        // Register the JavaScript interface
//        gmrSurveyWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
//
//        gmrProgressBar.setVisibility(View.VISIBLE);
//        gmrSurveyWebView.loadUrl("file:///android_asset/gmr/gmr.html");
//
//        locationLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                result -> {
//                    if (result.getResultCode() == RESULT_OK) {
//                        String location = result.getData().getStringExtra("location");
//                        if (location != null) {
//                            gmrSurveyWebView.evaluateJavascript("updateGMRLocation('" + location + "');", null);
//                        }
//                    }
//                }
//        );
//
//        photoIdLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                result -> {
//                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                        String IdCardPath = result.getData().getStringExtra("IdCardPath");
//                        if (IdCardPath != null) {
//                            try {
//                                // Parse URI from the received path
//                                Uri imageUri = Uri.parse(IdCardPath);
//                                Log.d("GMRProfilingWebActivity", "Received URI: " + imageUri);
//
//                                // Inject URI into JavaScript for WebView
//                                String javascriptCode = "updateIdPhoto('" + imageUri.toString() + "');";
//                                gmrSurveyWebView.evaluateJavascript(javascriptCode, null);
//                            } catch (Exception e) {
//                                Log.e("GMRProfilingWebActivity", "Error processing photo URI", e);
//                                Toast.makeText(this, "Invalid photo received.", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Log.e("GMRProfilingWebActivity", "Photo path is null");
//                            Toast.makeText(this, "No photo received.", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Log.e("GMRProfilingWebActivity", "Result canceled or no data");
//                        Toast.makeText(this, "Operation canceled.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//
//        photoFarmerLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                result -> {
//                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                        String FarmerPhotoPath = result.getData().getStringExtra("FarmerPhotoPath");
//                        if (FarmerPhotoPath != null) {
//                            try {
//                                // Parse URI from the received path
//                                Uri imageUri = Uri.parse(FarmerPhotoPath);
//                                Log.d("GMRProfilingWebActivity", "Received URI: " + imageUri);
//
//                                // Inject URI into JavaScript for WebView
//                                String javascriptCode = "updateFarmerPhoto('" + imageUri.toString() + "');";
//                                gmrSurveyWebView.evaluateJavascript(javascriptCode, null);
//                            } catch (Exception e) {
//                                Log.e("GMRProfilingWebActivity", "Error processing photo URI", e);
//                                Toast.makeText(this, "Invalid photo received.", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Log.e("GMRProfilingWebActivity", "Photo path is null");
//                            Toast.makeText(this, "No photo received.", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Log.e("GMRProfilingWebActivity", "Result canceled or no data");
//                        Toast.makeText(this, "Operation canceled.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//
//        photoTpLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                result -> {
//                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
//                        String farmerTPPath = result.getData().getStringExtra("FarmerTPPath");
//                        if (farmerTPPath != null) {
//                            try {
//                                // Parse URI from the received path
//                                Uri imageUri = Uri.parse(farmerTPPath);
//                                Log.d("GMRProfilingWebActivity", "Received URI: " + imageUri);
//
//                                // Inject URI into JavaScript for WebView
//                                String javascriptCode = "updateTpPhoto('" + imageUri.toString() + "');";
//                                gmrSurveyWebView.evaluateJavascript(javascriptCode, null);
//                            } catch (Exception e) {
//                                Log.e("GMRProfilingWebActivity", "Error processing photo URI", e);
//                                Toast.makeText(this, "Invalid photo received.", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Log.e("GMRProfilingWebActivity", "Photo path is null");
//                            Toast.makeText(this, "No photo received.", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Log.e("GMRProfilingWebActivity", "Result canceled or no data");
//                        Toast.makeText(this, "Operation canceled.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//
//    }
//
//    public class WebAppInterface {
//
//        Context context;
//        GMRDbHelper dbHelper;
//
//        WebAppInterface(Context c) {
//            context = c;
//            dbHelper = new GMRDbHelper(context);
//        }
//
//
//        @JavascriptInterface
//        public void completeSurvey() {
//            Intent intent = new Intent(context, GMRSurveyCompletedActivity.class);
//            context.startActivity(intent);
//            finish();
//        }
//
//        @JavascriptInterface
//        public void openIdPhotoActivity() {
//            Intent intent = new Intent(context, GetGMRFarmerIdActivity.class);
//            photoIdLauncher.launch(intent);
//        }
//
//        @JavascriptInterface
//        public void openFarmerPhotoActivity() {
//            Intent intent = new Intent(context, GetGMRFarmerPhotoActivity.class);
//            photoFarmerLauncher.launch(intent);
//        }
//
//        @JavascriptInterface
//        public void openPhotoTpActivity() {
//            Intent intent = new Intent(context, GetGMRFarmerThumbprintActivity.class);
//            photoTpLauncher.launch(intent);
//        }
//
//    }
//
//    private void injectDependencies() {
//        preferenceHelper = new PreferenceHelper(this);
//    }
//
//    private <T> T requireNotNull(T obj) {
//        if (obj == null) {
//            throw new NullPointerException("Required value was null.");
//        }
//        return obj;
//    }
//
//    @Override
//    protected void onDestroy() {
//        if (gmrSurveyWebView != null) {
//            gmrSurveyWebView.destroy();
//        }
//        super.onDestroy();
//    }
//}
//
//
//
//
////index_gmr.html
//<!DOCTYPE html>
//<html lang="en">
//    <head>
//        <title></title>
//        <meta name="robots" content="noindex">
//        <meta name="viewport" content="width=device-width, initial-scale=1">
//        <!-- Include local JavaScript and CSS files -->
//        <script src="js/jquery.min.js"></script>
//        <script src="js/survey.core.min.js"></script>
//        <script src="js/survey.i18n.min.js"></script>
//        <script src="js/survey-js-ui.js"></script>
//        <link rel="stylesheet" href="css/defaultV2.min.css">
//    </head>
//    <body>
//        <div id="surveyElement" style="position: absolute; left: 0; right: 0; bottom: 0; min-height: 100%; height:100%"></div>
//        <script src="json_gmr.js"></script>
//        <script src="index_gmr.js"></script>
//        <script src="js/theme.js"></script>
//    </body>
//</html>
//
//
//
//
//// json_gmr.js
//        const json = {
//        "logoPosition": "right",
//        "pages": [
//        {
//        "name": "page1",
//        "elements": [
//        {
//        "type": "text",
//        "name": "farmer_code",
//        "title": "Farmer code",
//        "isRequired": true
//        },
//        {
//        "type": "panel",
//        "name": "photo_panel",
//        "title": "Photo of ID card\n",
//        "elements": [
//        {
//        "type": "html",
//        "name": "id_photo",
//        "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='photoIdDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='ID Card Photo'/>\
//                <button id='getIdPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetIdPhoto()'>Get Photo</button>\
//              </div>"
//        }
//        ]
//        },
//        {
//        "type": "panel",
//        "name": "photo_panel",
//        "title": "Photo of farmer\n",
//        "elements": [
//        {
//        "type": "html",
//        "name": "farmer_photo",
//        "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='photoFarmerDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='School Photo'/>\
//                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
//              </div>"
//        }
//        ]
//        },
//        {
//        "type": "panel",
//        "name": "photo_panel",
//        "title": "Signature/Thumbprint of farmer\n",
//        "elements": [
//        {
//        "type": "html",
//        "name": "tp_photo",
//        "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='photoTpDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='School Photo'/>\
//                <button id='getTpPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetTpPhoto()'>Get Photo</button>\
//              </div>"
//        }
//        ]
//        },
//        {
//        "type": "signaturepad",
//        "name": "signature",
//        "title": "Agent Signature\n"
//        }
//        ]
//        }
//        ]
//        }
//
//
//
//
//// index_gmr.js
//        const survey = new Survey.Model(json);
//
//survey.showCompletedPage = false;
//
//function handleGetIdPhoto() {
//    Android.openIdPhotoActivity();
//}
//
//function updateIdPhoto(photoIdUri) {
//    const photoIdImg = document.getElementById('photoIdDisplay');
//    if (photoIdImg) {
//        photoIdImg.src = photoIdUri;
//    }
//}
//
//function handleGetFarmerPhoto() {
//    Android.openFarmerPhotoActivity();
//}
//
//function updateFarmerPhoto(photoFarmerUri) {
//    const photoFarmerImg = document.getElementById('photoFarmerDisplay');
//    if (photoFarmerImg) {
//        photoFarmerImg.src = photoFarmerUri;
//    }
//}
//
//function handleGetTpPhoto() {
//    Android.openPhotoTpActivity();
//}
//
//function updateTpPhoto(photoTpUri) {
//    const photoTpImg = document.getElementById('photoTpDisplay');
//    if (photoTpImg) {
//        photoTpImg.src = photoTpUri;
//    }
//}
//
//survey.onComplete.add(function (survey, options) {
//    const surveyData = survey.data;
//    const { farmer_code, id_photo, farmer_photo, tp_photo, signature, on_create, on_update } = surveyData;
//
//    // Send the data including the raw PNG data for the signature
//    Android.insertSurveyData(
//            farmer_code, id_photo, farmer_photo, tp_photo, signature, on_create, on_update
//    );
//    Android.completeSurvey();
//});
//
//// Render the survey
//$("#surveyElement").Survey({ model: survey });