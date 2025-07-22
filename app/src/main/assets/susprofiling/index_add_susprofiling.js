const survey = new Survey.Model(json);

survey.completeText = "Save Inspection";
survey.showCompletedPage = false;

function setFarmer_id(uniqueCode) {
    survey.setValue('farmer_id', uniqueCode);
}

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateInspectionLocation(location) {
    survey.setValue('suspro_location', location);
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

function saveSusProfiling(isDraft) {
    const data = survey.data;
    const is_sync = "0";
    Android.insertOrUpdateSusProfiling(
        data.farmer_id || "",
        data.district || "",
        data.community || "",
        data.suspro_question1 || "",
        data.suspro_question2 || "",
        data.suspro_question3 || "",
        data.suspro_question4 || "",
        data.suspro_question4b || "",
        data.suspro_question4c || "",
        data.suspro_question5 || "",
        data.suspro_question6 || "",
        data.suspro_question7 || "",
        data.suspro_question7b || "",
        data.suspro_question8 || "",
        data.suspro_question8b || "",
        data.suspro_question9 || "",
        data.suspro_question10 || "",
        data.suspro_question11 || "",
        data.suspro_question11b || "",
        data.suspro_question11c || "",
        data.suspro_question12 || "",
        data.suspro_question12b || "",
        data.suspro_question13 || "",
        data.suspro_question14 || "",
        data.suspro_question14b || "",
        data.suspro_question14c || "",
        data.suspro_question14d || "",
        data.suspro_question15 || "",
        data.suspro_question15b || "",
        data.suspro_question16 || "",
        data.suspro_question16b || "",
        data.suspro_question17 || "",
        data.suspro_question17b || "",
        data.suspro_question17c || "",
        data.suspro_question18 || "",
        data.suspro_question19 || "",
        data.suspro_question20 || "",
        data.suspro_question21 || "",
        data.suspro_location || "",
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
    saveSusProfiling(false);
});
