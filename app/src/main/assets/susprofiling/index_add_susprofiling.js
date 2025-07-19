const survey = new Survey.Model(json);

survey.showCompletedPage = false;

function handleGetIdPhoto() {
    Android.openIdPhotoActivity();
}

function updateIdPhoto(photoIdUri) {
    const photoIdImg = document.getElementById('IdPhotoDisplay');
    if (photoIdImg) {
        photoIdImg.src = photoIdUri;
    }
}

function handleGetFarmerPhoto() {
    Android.openFarmerPhotoActivity();
}

function updateFarmerPhoto(photoFarmerUri) {
    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
    if (photoFarmerImg) {
        photoFarmerImg.src = photoFarmerUri;
    }
}

function handleGetTpPhoto() {
    Android.openPhotoTpActivity();
}

function updateTpPhoto(photoTpUri) {
    const photoTpImg = document.getElementById('TpPhotoDisplay');
    if (photoTpImg) {
        photoTpImg.src = photoTpUri;
    }
}

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateChildLocation(location) {
    survey.data.child_location = location;
    survey.setValue('child_location', location);
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { gmrquestion1, gmrquestion2, gmrquestion3, gmrquestion4, gmrquestion5, gmrquestion6, gmrquestion7,
    gmrquestion8, gmrquestion9, id_photo, gmrquestion11, gmrquestion12, gmrquestion13, gmrquestion14, gmrquestion15,
    gmrquestion16, gmrquestion17, gmrquestion18, gmrquestion19, gmrquestion20, gmrquestion21, gmrquestion22,
    gmrquestion23, gmrquestion24, gmrquestion25, gmrquestion26, gmrquestion27, gmrquestion28, gmrquestion29,
    gmrquestion30, gmrquestion31, gmrquestion32, gmrquestion33, gmrquestion34, gmrquestion35, gmrquestion36,
    gmrquestion37, gmrquestion38, gmrquestion39,farmer_photo, tp_photo, signature, gmrquestion43 } = surveyData;

    // Log survey data
    console.log("Survey onComplete triggered:", surveyData);

    // Ensure photos have valid paths
    const idPhotoPath = id_photo || "No image";
    const farmerPhotoPath = farmer_photo || "No image";
    const tpPhotoPath = tp_photo || "No image";

    // Send the data including the raw PNG data for the signature
    Android.insertSurveyData( gmrquestion1, gmrquestion2, gmrquestion3, gmrquestion4, gmrquestion5, gmrquestion6,
    gmrquestion7, gmrquestion8, gmrquestion9, idPhotoPath, gmrquestion11, gmrquestion12, gmrquestion13, gmrquestion14,
    gmrquestion15, gmrquestion16, gmrquestion17, gmrquestion18, gmrquestion19, gmrquestion20, gmrquestion21,
    gmrquestion22, gmrquestion23, gmrquestion24, gmrquestion25, gmrquestion26, gmrquestion27, gmrquestion28,
    gmrquestion29, gmrquestion30, gmrquestion31, gmrquestion32, gmrquestion33, gmrquestion34, gmrquestion35,
    gmrquestion36, gmrquestion37, gmrquestion38, gmrquestion39, farmerPhotoPath, tpPhotoPath, signature, gmrquestion43
    );
    Android.completeSurvey();
});

//survey.onComplete.add(function (survey, options) {
//    const surveyData = survey.data;
//    const { farmer_code, id_photo, farmer_photo, tp_photo, signature } = surveyData;
//
//    // Log survey data
//    console.log("Survey onComplete triggered:", surveyData);
//
//    // Send the data including the raw PNG data for the signature
//    Android.insertSurveyData(
//        farmer_code, id_photo, farmer_photo, tp_photo, signature
//    );
//    Android.completeSurvey();
//});

// Render the survey
$("#surveyElement").Survey({ model: survey });












//// index_add_gmr.js
//const survey = new Survey.Model(json);
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
//        farmer_code, id_photo, farmer_photo, tp_photo, signature, on_create, on_update
//    );
//    Android.completeSurvey();
//});
//
//// Render the survey
//$("#surveyElement").Survey({ model: survey });
