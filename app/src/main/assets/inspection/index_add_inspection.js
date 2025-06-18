const survey = new Survey.Model(json);

survey.completeText = "Save Inspection";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateInspectionLocation(location) {
    survey.setValue('inspection_location', location);
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

// Match keys exactly with Java: (farmer_id, farmer_name, etc)
function populateSurveyFields(farmer_id, farmer_name, district, community) {
    survey.setValue('farmer_id', farmer_id);
    survey.setValue('farmer_name', farmer_name);
    survey.setValue('district', district);
    survey.setValue('community', community);
}

function notifyAndroidPageLoaded() {
    if (window.Android) {
        Android.notifyPageLoaded();
    }
}

document.addEventListener("DOMContentLoaded", function () {
    $("#surveyElement").Survey({ model: survey });
    notifyAndroidPageLoaded();
});

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || "";
}

function saveInspection(isDraft) {
    const data = survey.data;
    const is_sync = "0";
    Android.insertOrUpdateInspection(
        data.farmer_id || "",
        data.farmer_name || "",
        data.district || "",
        data.community || "",
        data.inspection_question1 || "",
        data.inspection_question2 || "",
        data.inspection_question3 || "",
        data.inspection_question4 || "",
        data.inspection_question5 || "",
        data.inspection_location || "",
        data.farmer_photo || "",
        data.signature ? data.signature : null,
        is_sync,
        isDraft ? "1" : "0"
    );
    if (!isDraft) {
        Android.completeSurvey();
    }
}

// Only trigger on explicit user actions:
// - For final save: via SurveyJS completion event
survey.onComplete.add(function (survey, options) {
    saveInspection(false);
});

//function saveInspection(isDraft) {
//    const data = survey.data;
//    const is_sync = "0";
//    Android.insertInspection(
//        data.farmer_id || "",
//        data.farmer_name || "",
//        data.district || "",
//        data.community || "",
//        data.inspection_question1 || "",
//        data.inspection_question2 || "",
//        data.inspection_question3 || "",
//        data.inspection_question4 || "",
//        data.inspection_question5 || "",
//        data.inspection_location || "",
//        data.farmer_photo || "",
//        data.signature ? data.signature : null,
//        is_sync,
//        isDraft ? "1" : "0"
//    );
//    Android.completeSurvey();
//}




//function saveInspection(isDraft) {
//    const data = survey.data;
//    const is_sync = "0";
//    Android.insertInspection(
//        data.farmer_id || "",
//        data.farmer_name || "",
//        data.district || "",
//        data.community || "",
//        data.inspection_question1 || "",
//        data.inspection_question2 || "",
//        data.inspection_question3 || "",
//        data.inspection_question4 || "",
//        data.inspection_question5 || "",
//        data.inspection_location || "",
//        data.farmer_photo || "",
//        data.signature ? data.signature : null,
//        is_sync,
//        isDraft ? "1" : "0"
//    );
//    Android.completeSurvey();
//}
//
//// When user taps "Save as Draft"
//saveInspection(true);
//
//// When user taps "Save Inspection"
//saveInspection(false);


//survey.onComplete.add(function (survey, options) {
//    const data = survey.data;
//
//    // is_sync to "0" for local inserts
//    const is_sync = "0";
//
//    Android.insertInspection(
//        data.farmer_id || "",
//        data.farmer_name || "",
//        data.district || "",
//        data.community || "",
//        data.inspection_question1 || "",
//        data.inspection_question2 || "",
//        data.inspection_question3 || "",
//        data.inspection_question4 || "",
//        data.inspection_question5 || "",
//        data.inspection_location || "",
//        data.farmer_photo || "",
//        data.signature || "",
//        is_sync
//    );
//    Android.completeSurvey();
//});




//const survey = new Survey.Model(json);
//
//survey.completeText = "Save Inspection";
//survey.showCompletedPage = false;
//
//function handleGetLocation() {
//    Android.openLocationActivity();
//}
//
//function updateInspectionLocation(location) {
//    survey.data.inspection_location = location;
//    survey.setValue('inspection_location', location);
//}
//
//function handleGetFarmerPhoto() {
//    Android.openFarmerPhotoActivity();
//}
//
//function updateFarmerPhoto(photoFarmerUri) {
//    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
//    if (photoFarmerImg) {
//        photoFarmerImg.src = photoFarmerUri;
//    }
//}
//
//function populateSurveyFields(farmer_id, farmer_name, district, community) {
//    survey.setValue('farmer_id', farmer_id);
//    survey.setValue('farmer_name', farmer_name);
//    survey.setValue('district', district);
//    survey.setValue('community', community);
//}
//
//function notifyAndroidPageLoaded() {
//    if (window.Android) {
//        Android.notifyPageLoaded();
//    }
//}
//
//document.addEventListener("DOMContentLoaded", function () {
//    $("#surveyElement").Survey({ model: survey });
//    notifyAndroidPageLoaded();
//});
//
//function sanitizeInput(value) {
//    if (Array.isArray(value)) {
//        return value.join(",");
//    }
//    return value || "";
//}
//
//survey.onComplete.add(function (survey, options) {
//    const surveyData = survey.data;
//    let {
//        farmer_id, farmer_name, district, community,
//        inspection_question1, inspection_question2, inspection_question3, inspection_question4,
//        inspection_question5, inspection_location, farmer_photo, signature, is_sync
//    } = surveyData;
//
//    Android.insertInspection(
//        farmer_id || "", farmer_name || "", district || "", community || "", inspection_question1 || "",
//        inspection_question2 || "", inspection_question3 || "", inspection_question4 || "",
//        inspection_question5 || "", inspection_location || "", farmer_photo || "",
//        signature || "", is_sync || ""
//    );
//    Android.completeSurvey();
//});